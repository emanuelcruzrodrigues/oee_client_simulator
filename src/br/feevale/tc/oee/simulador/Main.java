package br.feevale.tc.oee.simulador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.quartz.SchedulerException;

import br.feevale.tc.oee.simulador.dto.EquipamentoDTO;
import br.feevale.tc.oee.simulador.dto.MotivoParadaDTO;
import br.feevale.tc.oee.simulador.dto.SimulacaoDTO;
import br.feevale.tc.oee.simulador.job.AgendadorDeTarefas;
import br.feevale.tc.oee.simulador.model.Equipamento;
import br.feevale.tc.oee.simulador.model.Simulacao;
import br.feevale.tc.oee.simulador.utils.XMLUtils;
import br.feevale.tc.oee.simulador.ws.ApontamentoWSClient;
import br.feevale.tc.oee.simulador.ws.EquipamentoWSClient;
import br.feevale.tc.oee.simulador.ws.MotivoParadaWSClient;
import br.feevale.tc.oee.simulador.ws.OrdemProducaoWSClient;
import br.feevale.tc.oee.simulador.ws.ProgramacaoProducaoEquipamentoWSClient;

import com.thoughtworks.xstream.XStream;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, SchedulerException {
		XStream xStream = XMLUtils.getXStream();
		SimulacaoDTO simulacaoDTO = (SimulacaoDTO) xStream.fromXML(new File(args[0]));
		String oeeServerURL = simulacaoDTO.getOEEServerURL();
		
		Simulacao simulacao = Simulacao.getInstance();
		simulacao.setDTO(simulacaoDTO);
		simulacao.setApontamentoWS(new ApontamentoWSClient(oeeServerURL));
		
		AgendadorDeTarefas agendador = new AgendadorDeTarefas();
		
		ProgramacaoProducaoEquipamentoWSClient programacaoProducaoEquipamentoWSClient = new ProgramacaoProducaoEquipamentoWSClient(oeeServerURL);
		EquipamentoWSClient equipamentoWSClient = new EquipamentoWSClient(oeeServerURL);
		OrdemProducaoWSClient ordemProducaoWSClient = new OrdemProducaoWSClient(oeeServerURL);
		
		inserirOuAlterarMotivosParada(simulacaoDTO);
		
		for (String xmlEquipamento : simulacaoDTO.getXmlEquipamentos()) {
			EquipamentoDTO equipamentoDTO = (EquipamentoDTO) xStream.fromXML(new File(xmlEquipamento));
			equipamentoWSClient.inserirOuAlterar(equipamentoDTO);
			ordemProducaoWSClient.inserirOuAlterarOrdensDeProducao(equipamentoDTO);
			
			Equipamento equipamento = new Equipamento(equipamentoDTO);
			simulacao.addEquipamento(equipamento, equipamentoDTO.getSaldoInicialMateriaPrima());
			
			agendador.agendarOperacaoEquipamento(equipamento, equipamentoDTO.getProgramacoesProducao());
			programacaoProducaoEquipamentoWSClient.programarEquipamento(equipamento);
		}
		
		agendador.agendarDesligamento();
		agendador.start();
		
	}

	private static void inserirOuAlterarMotivosParada(SimulacaoDTO simulacaoDTO) {
		MotivoParadaWSClient motivoParadaWSClient = new MotivoParadaWSClient(simulacaoDTO.getOEEServerURL());
		for (MotivoParadaDTO motivoParadaDTO : simulacaoDTO.getMotivosParada()) {
			motivoParadaWSClient.inserirOuAlterar(motivoParadaDTO);
		}
	}


}
