package br.feevale.tc.oee.simulador.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.feevale.tc.oee.simulador.dto.EquipamentoDTO;
import br.feevale.tc.oee.simulador.dto.OrdemProducaoDTO;
import br.feevale.tc.oee.simulador.processo.threads.AnalisadorQualidadeEquipamentoThread;
import br.feevale.tc.oee.simulador.processo.threads.EquipamentoParadaEmProcessoThread;
import br.feevale.tc.oee.simulador.processo.threads.EquipamentoParadaPorFaltaDeMaterialThread;
import br.feevale.tc.oee.simulador.processo.threads.EquipamentoParadaPorQualidadeThread;
import br.feevale.tc.oee.simulador.processo.threads.EquipamentoParadaPorSetupThread;
import br.feevale.tc.oee.simulador.processo.threads.EquipamentoProducaoThread;
import br.feevale.tc.oee.simulador.processo.threads.GeradorParadadaEmProcessoThread;
import br.feevale.tc.oee.simulador.processo.threads.SimulacaoThread;

public class Equipamento {
	
	private Integer id;
	private boolean ligado;
	private boolean emProcesso;
	private Logger logger;
	private List<OrdemProducao> ordensProducao;
	
	private OrdemProducao ordemProducaoAtual;
	private SimulacaoThread threadProducao;
	private SimulacaoThread threadParada;
	
	private EquipamentoDTO dto;
	
	private int quantidadeTotalProduzida;
	
	public Equipamento(EquipamentoDTO equipamentoDTO) {
		this(equipamentoDTO.getId());
		for (OrdemProducaoDTO ordemProducaoDTO : equipamentoDTO.getOrdensProducao()) {
			OrdemProducao ordemProducao = new OrdemProducao(ordemProducaoDTO);
			addOrdemProducao(ordemProducao);
		}
		this.dto = equipamentoDTO;
	}
	
	public Equipamento(Integer id) {
		super();
		this.id = id;
		this.logger = Logger.getLogger(getClass());
		this.ordensProducao = new ArrayList<>();
	}
	

	public void ligar(){
		this.ligado = true;
		this.emProcesso = false;
		
		new GeradorParadadaEmProcessoThread(Simulacao.getInstance().getDTO().getIdsMotivosParadaNoProcesso(), this).start();
		new AnalisadorQualidadeEquipamentoThread(this).start();
		
		logger.info(String.format("Equipamento %d ligado", id));
	}
	
	public void desligar(){
		this.ligado = false;
		this.emProcesso = false;
		killThreadProducao();
		killThreadParada();
		
		logger.info(String.format("Equipamento %d desligado", id));
		Simulacao.getInstance().getApontamentoWS().encerrarApontamentos(getId());
		
	}

	public void iniciarParadaEmProcesso(Integer idMotivoParada){
		if (!ligado || isParado() || ordemProducaoAtual == null) return;
		this.emProcesso = false;
		killThreadProducao();
		
		if (threadParada == null){
			threadParada = new EquipamentoParadaEmProcessoThread(this);
			threadParada.start();
		}

		logger.info(String.format("Equipamento %d parado", id));
		Simulacao.getInstance().getApontamentoWS().iniciarApontamentoParada(getId(), idMotivoParada);
	}
	
	private void iniciarParadaPorFaltaDeMateriaPrima() {
		if (!ligado) return;
		this.emProcesso = false;
		killThreadProducao();
		
		if (threadParada == null){
			threadParada = new EquipamentoParadaPorFaltaDeMaterialThread(this);
			threadParada.start();
		}

		logger.info(String.format("Equipamento %d parado por falta de MP", id));
		Simulacao.getInstance().getApontamentoWS().iniciarApontamentoParada(getId(), getDTO().getIdMotivoParadaFaltaMateriaPrima());
	}
	
	private void iniciarParadaPorSetup() {
		if (!ligado) return;
		this.emProcesso = false;
		killThreadProducao();
		
		if (threadParada == null){
			threadParada = new EquipamentoParadaPorSetupThread(this);
			threadParada.start();
		}
		
		logger.info(String.format("Equipamento %d parado por setup", id));
		Simulacao.getInstance().getApontamentoWS().iniciarApontamentoParada(getId(), getDTO().getIdMotivoParadaSetupOrdemProducao());
	}
	
	private void iniciarParadaPorQualidade() {
		if (!ligado) return;
		this.emProcesso = false;
		killThreadProducao();
		
		if (threadParada == null){
			threadParada = new EquipamentoParadaPorQualidadeThread(this);
			threadParada.start();
		}
		
		logger.info(String.format("Equipamento %d parado por qualidade (testes)", id));
		Simulacao.getInstance().getApontamentoWS().iniciarApontamentoParada(getId(), getDTO().getIdMotivoParadaQualidade());
	}

	
	public void iniciarProducao(){
		if (!ligado) return;
		this.emProcesso = true;
		killThreadParada();
		
		
		OrdemProducao ordemProducao = getProximaOrdemProducao();
		if (ordemProducao != null && !ordemProducao.equals(ordemProducaoAtual)){
			ordemProducaoAtual = ordemProducao;
			iniciarParadaPorSetup();
			return;
		}
		ordemProducaoAtual = ordemProducao;
		
		if (threadProducao == null){
			threadProducao = new EquipamentoProducaoThread(this, ordemProducao);
			threadProducao.start();
		}
		
		logger.info(String.format("Equipamento %d em producao", id));
		Simulacao.getInstance().getApontamentoWS().iniciarApontamentoProducao(ordemProducao.getId());
	}
	
	public void produzir(EquipamentoProducaoThread thread, Integer quantidadeProduzida) {
		if (!emProcesso) return;

		OrdemProducao ordemProducao = thread.getOrdemProducao();
		
		if (quantidadeProduzida > ordemProducao.getSaldoProduzir()){
			quantidadeProduzida = ordemProducao.getSaldoProduzir();
		}
		
		Integer saldoMateriaPrima = Simulacao.getInstance().getSaldoMateriaPrima(id);
		if (quantidadeProduzida > saldoMateriaPrima){
			quantidadeProduzida = saldoMateriaPrima;
		}
		
		ordemProducao.removeQuantidade(quantidadeProduzida);
		
		addQuantidadeTotalProduzida(quantidadeProduzida);
		
		Simulacao.getInstance().updateSaldoMateriaPrima(id, -quantidadeProduzida);
		
		Simulacao.getInstance().updateQuantidadeProduzida(this, ordemProducao, +quantidadeProduzida);
		
		if (getQuantidadeTotalProduzida() > 0 && getQuantidadeTotalProduzida() % getDTO().getUnidadesPorParadaQualidade() == 0){
			iniciarParadaPorQualidade();
			return;
		}
		
		if (ordemProducao.getSaldoProduzir() <= 0){
			ordemProducao = getProximaOrdemProducao();
			if (ordemProducao != null && !ordemProducao.equals(ordemProducaoAtual)){
				ordemProducaoAtual = ordemProducao;
				iniciarParadaPorSetup();
				return;
			}
			thread.setOrdemProducao(ordemProducao);
		}
		
		if (ordemProducao != null && ordemProducao.getSaldoProduzir() > 0 && Simulacao.getInstance().getSaldoMateriaPrima(id) <= 0){
			iniciarParadaPorFaltaDeMateriaPrima();
		}
	}
	
	public void addOrdemProducao(OrdemProducao ordemProducao){
		ordensProducao.add(ordemProducao);
	}
	
	public OrdemProducao getProximaOrdemProducao() {
		for (OrdemProducao ordemProducao : ordensProducao) {
			if (ordemProducao.getSaldoProduzir() > 0) return ordemProducao;
		}
		return null;
	}
	
	public boolean isEmProcesso() {
		return emProcesso;
	}
	
	public boolean isParado() {
		return isLigado() && !emProcesso;
	}
	
	public boolean isLigado() {
		return ligado;
	}
	
	public Integer getId() {
		return id;
	}
	
	private void killThreadProducao() {
		if (threadProducao != null){
			threadProducao.kill();
			threadProducao = null;
		}
	}
	
	private void killThreadParada() {
		if (threadParada != null){
			threadParada.kill();
			threadParada = null;
		}
	}
	
	public List<OrdemProducao> getOrdensProducao() {
		return ordensProducao;
	}
	
	public EquipamentoDTO getDTO() {
		return dto;
	}

	public synchronized void addQuantidadeTotalProduzida(int quantidade) {
		this.quantidadeTotalProduzida += quantidade;
	}
	
	public int getQuantidadeTotalProduzida() {
		return quantidadeTotalProduzida;
	}
	
		
}
