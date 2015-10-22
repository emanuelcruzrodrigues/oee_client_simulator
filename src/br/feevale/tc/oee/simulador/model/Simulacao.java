package br.feevale.tc.oee.simulador.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.feevale.tc.oee.driver.ws.ApontamentoWSClient;
import br.feevale.tc.oee.simulador.dto.EncadeamentoProcessoDTO;
import br.feevale.tc.oee.simulador.dto.SimulacaoDTO;

public class Simulacao {
	
	private static Simulacao instance;
	
	private List<Equipamento> equipamentos;
	private Map<Integer, Saldo> saldoMateriaPrimaPorIdMaquina = new HashMap<>();
	private Map<Integer, Saldo> saldoQuantidadesProduzidasPorIdOrdemProducao = new HashMap<>();
	private SimulacaoDTO dto;
	
	private ApontamentoWSClient apontamentoWS;
	
	public static Simulacao getInstance() {
		if (instance == null){
			instance = new Simulacao();
		}
		return instance;
	}
	
	private Simulacao() {
		this.equipamentos = new ArrayList<Equipamento>();
	}

	public void desligar(Integer idEquipamento) {
		for (Equipamento equipamento : equipamentos) {
			if (equipamento.getId().equals(idEquipamento)){
				equipamento.desligar();
				return;
			}
		}
	}
	
	public Equipamento ligar(Integer idEquipamento) {
		for (Equipamento equipamento : equipamentos) {
			if (equipamento.getId().equals(idEquipamento)){
				equipamento.ligar();
				return equipamento;
			}
		}
		return null;
	}
	
	public void addEquipamento(Equipamento equipamento, Integer saldoInicialMP){
		equipamentos.add(equipamento);
		setSaldoInicialMateriaPrima(equipamento.getId(), saldoInicialMP);
		for (OrdemProducao ordemProducao : equipamento.getOrdensProducao()) {
			setSaldoQuantidadeProduzidaPorOrdemProducaoInicial(ordemProducao, 0);
		}
	}
	
	public void setSaldoQuantidadeProduzidaPorOrdemProducaoInicial(OrdemProducao ordemProducao, Integer saldo){
		saldoQuantidadesProduzidasPorIdOrdemProducao.put(ordemProducao.getId(), new Saldo(saldo));
	}
	
	public void setSaldoInicialMateriaPrima(Integer idEquipamento, Integer saldo){
		saldoMateriaPrimaPorIdMaquina.put(idEquipamento, new Saldo(saldo));
	}
	
	public Integer getSaldoMateriaPrima(Integer id) {
		return saldoMateriaPrimaPorIdMaquina.get(id).getSaldo();
	}
	
	public void updateSaldoMateriaPrima(Integer id, Integer quantidade) {
		Saldo saldo = saldoMateriaPrimaPorIdMaquina.get(id);
		synchronized (saldo) {
			saldo.update(quantidade);
		}
	}
	
	public void updateQuantidadeProduzida(Equipamento equipamento, OrdemProducao ordemProducao, Integer quantidade) {
		Saldo saldo = saldoQuantidadesProduzidasPorIdOrdemProducao.get(ordemProducao.getId());
		synchronized (saldo) {
			saldo.update(quantidade);
		}
		encadearProducao(equipamento, quantidade);

	}
	
	private void encadearProducao(Equipamento equipamento, Integer quantidade) {
		List<Integer> idsEquipamentosDestino = getEquipamentosDestino(equipamento.getId()); 
		for (Integer id : idsEquipamentosDestino) {
			updateSaldoMateriaPrima(id, quantidade);
		}
	}

	private List<Integer> getEquipamentosDestino(int id) {
		List<Integer> result = new ArrayList<>(); 
		for (EncadeamentoProcessoDTO encadeamento : getDTO().getEncadeamentosProcessos()) {
			if (encadeamento.getIdEquipamentoProdutor() != id) continue;
			result.add(encadeamento.getIdEquipamentoConsumidor());
		}
		return result;
	}

	public Integer zerarQuantidadeProduzida(OrdemProducao ordemProducao){
		Saldo saldo = saldoQuantidadesProduzidasPorIdOrdemProducao.get(ordemProducao.getId());
		synchronized (saldo) {
			return saldo.resgatar();
		}
	}

	public SimulacaoDTO getDTO() {
		return dto;
	}
	public void setDTO(SimulacaoDTO dto) {
		this.dto = dto;
	}
	
	public ApontamentoWSClient getApontamentoWS() {
		return apontamentoWS;
	}
	public void setApontamentoWS(ApontamentoWSClient apontamentoWS) {
		this.apontamentoWS = apontamentoWS;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}
	

}
