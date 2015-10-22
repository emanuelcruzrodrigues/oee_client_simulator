package br.feevale.tc.oee.simulador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.joda.time.LocalDateTime;
import org.quartz.SchedulerException;

import br.feevale.tc.oee.driver.ws.ApontamentoWSClient;
import br.feevale.tc.oee.driver.ws.EquipamentoWSClient;
import br.feevale.tc.oee.driver.ws.MotivoParadaWSClient;
import br.feevale.tc.oee.driver.ws.OrdemProducaoWSClient;
import br.feevale.tc.oee.driver.ws.ProgramacaoProducaoEquipamentoWSClient;
import br.feevale.tc.oee.driver.ws.enums.AtivoInativo;
import br.feevale.tc.oee.driver.ws.enums.SituacaoOrdemProducao;
import br.feevale.tc.oee.driver.ws.enums.TipoParada;
import br.feevale.tc.oee.simulador.dto.DataHoraDTO;
import br.feevale.tc.oee.simulador.dto.EquipamentoDTO;
import br.feevale.tc.oee.simulador.dto.MotivoParadaDTO;
import br.feevale.tc.oee.simulador.dto.OrdemProducaoDTO;
import br.feevale.tc.oee.simulador.dto.ProgramacaoProducaoEquipamentoDTO;
import br.feevale.tc.oee.simulador.dto.SimulacaoDTO;
import br.feevale.tc.oee.simulador.job.AgendadorDeTarefas;
import br.feevale.tc.oee.simulador.model.Equipamento;
import br.feevale.tc.oee.simulador.model.Simulacao;
import br.feevale.tc.oee.simulador.utils.XMLUtils;

public class Main {
	
	private static EquipamentoWSClient equipamentoWSClient;
	private static ProgramacaoProducaoEquipamentoWSClient programacaoProducaoEquipamentoWSClient;
	private static OrdemProducaoWSClient ordemProducaoWSClient;
	private static MotivoParadaWSClient motivoParadaWSClient;
	private static ApontamentoWSClient apontamentoWSClient;
	
	public static void main(String[] args) throws FileNotFoundException, IOException, SchedulerException {
		SimulacaoDTO simulacaoDTO = (SimulacaoDTO) XMLUtils.getXStream().fromXML(new File(args[0]));
		
		String oeeServerURL = simulacaoDTO.getOEEServerURL();
		equipamentoWSClient = new EquipamentoWSClient(oeeServerURL);
		programacaoProducaoEquipamentoWSClient = new ProgramacaoProducaoEquipamentoWSClient(oeeServerURL);
		ordemProducaoWSClient = new OrdemProducaoWSClient(oeeServerURL);
		motivoParadaWSClient = new MotivoParadaWSClient(oeeServerURL);
		apontamentoWSClient = new ApontamentoWSClient(oeeServerURL);
		
		Simulacao simulacao = Simulacao.getInstance();
		simulacao.setDTO(simulacaoDTO);
		simulacao.setApontamentoWS(apontamentoWSClient);
		
		AgendadorDeTarefas agendador = new AgendadorDeTarefas();
		
		inserirOuAlterarMotivosParada(simulacaoDTO);
		
		inserirOuAlterarEquipamentos(simulacaoDTO, simulacao, agendador);
		
		agendador.agendarDesligamento();
		agendador.start();
		
	}

	private static void inserirOuAlterarEquipamentos(SimulacaoDTO simulacaoDTO, Simulacao simulacao, AgendadorDeTarefas agendador) {
		
		for (String xmlEquipamento : simulacaoDTO.getXmlEquipamentos()) {
			EquipamentoDTO equipamentoDTO = (EquipamentoDTO) XMLUtils.getXStream().fromXML(new File(xmlEquipamento));
			equipamentoWSClient.inserirOuAlterar(equipamentoDTO.getId(), equipamentoDTO.getNome(), AtivoInativo.ATIVO);
			
			inserirOuAlterarOrdensProducao(equipamentoDTO);
			
			inserirOuAlterarProgramacoesProducao(equipamentoDTO);
			
			Equipamento equipamento = new Equipamento(equipamentoDTO);
			simulacao.addEquipamento(equipamento, equipamentoDTO.getSaldoInicialMateriaPrima());
			agendador.agendarOperacaoEquipamento(equipamento, equipamentoDTO.getProgramacoesProducao());
		}
	}

	private static void inserirOuAlterarOrdensProducao(EquipamentoDTO equipamentoDTO) {
		for (OrdemProducaoDTO ordemProducaoDTO : equipamentoDTO.getOrdensProducao()) {
			int codigo = ordemProducaoDTO.getId();
			String descricao = ordemProducaoDTO.getDescricao();
			double unidadesPorMinuto = ordemProducaoDTO.getUnidadesPorMinutoMaximo();
			SituacaoOrdemProducao situacao = SituacaoOrdemProducao.ABERTA;
			int codigoEquipamento = equipamentoDTO.getId();
			ordemProducaoWSClient.inserirOuAlterar(codigo, descricao, unidadesPorMinuto, situacao, codigoEquipamento);
		}
	}
	
	private static void inserirOuAlterarProgramacoesProducao(EquipamentoDTO equipamentoDTO) {
		for (ProgramacaoProducaoEquipamentoDTO programacao : equipamentoDTO.getProgramacoesProducao()) {
			Integer codigo = programacao.getId();
			int codigoEquipamento = equipamentoDTO.getId();
			
			DataHoraDTO dtHrInicio = programacao.getDtHrInicio();
			LocalDateTime dtHrInicial = new LocalDateTime(dtHrInicio.getAno(), dtHrInicio.getMes(), dtHrInicio.getDia(), dtHrInicio.getHora(), dtHrInicio.getMinutos(), 0, 0);
			
			DataHoraDTO dtHrFim = programacao.getDtHrFim();
			LocalDateTime dtHrFinal = new LocalDateTime(dtHrFim.getAno(), dtHrFim.getMes(), dtHrFim.getDia(), dtHrFim.getHora(), dtHrFim.getMinutos(), 0, 0);
			
			programacaoProducaoEquipamentoWSClient.inserirOuAlterar(codigo, codigoEquipamento, dtHrInicial, dtHrFinal);
		}
	}


	private static void inserirOuAlterarMotivosParada(SimulacaoDTO simulacaoDTO) {
		for (MotivoParadaDTO motivoParadaDTO : simulacaoDTO.getMotivosParada()) {
			int codigo = motivoParadaDTO.getId();
			String descricao = motivoParadaDTO.getDescricao();
			AtivoInativo situacao = AtivoInativo.ATIVO;
			TipoParada tipoParada = TipoParada.getFromValue(motivoParadaDTO.getTipoParada());
			motivoParadaWSClient.inserirOuAlterar(codigo, descricao, situacao, tipoParada);
		}
	}
	

}
