package br.feevale.tc.oee.simulador.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import br.feevale.tc.oee.simulador.dto.DataHoraDTO;
import br.feevale.tc.oee.simulador.dto.ProgramacaoProducaoEquipamentoDTO;
import br.feevale.tc.oee.simulador.model.Equipamento;
import br.feevale.tc.oee.ws.programacao.Data;
import br.feevale.tc.oee.ws.programacao.DataHoraFinal;
import br.feevale.tc.oee.ws.programacao.DataHoraInicial;
import br.feevale.tc.oee.ws.programacao.ExcluirProgramacaoProducaoEquipamento;
import br.feevale.tc.oee.ws.programacao.ExcluirProgramacaoProducaoEquipamentoRequest;
import br.feevale.tc.oee.ws.programacao.InserirProgramacaoProducaoEquipamento;
import br.feevale.tc.oee.ws.programacao.InserirProgramacaoProducaoEquipamentoRequest;
import br.feevale.tc.oee.ws.programacao.InserirProgramacaoProducaoEquipamentoService;

public class ProgramacaoProducaoEquipamentoWSClient {
	
	private static final String NAMESPACE = "programacao.ws.oee.tc.feevale.br";
	private static final String INSERIR_SERVICE_NAME = "inserirProgramacaoProducaoEquipamentoService";
	private static final String EXCLUIR_SERVICE_NAME = "excluirProgramacaoProducaoEquipamentoService";
	
	private InserirProgramacaoProducaoEquipamento portInserir;
	private ExcluirProgramacaoProducaoEquipamento portExcluir;

	public ProgramacaoProducaoEquipamentoWSClient(String oeeServerURL) {
		try {
			URL wsdlLocationIncluir = new URL(oeeServerURL + INSERIR_SERVICE_NAME + "Definition.wsdl");
			
			portInserir = new InserirProgramacaoProducaoEquipamentoService(wsdlLocationIncluir, new QName(NAMESPACE, INSERIR_SERVICE_NAME))
								.getPort(InserirProgramacaoProducaoEquipamento.class);
			
			URL wsdlLocationExcluir = new URL(oeeServerURL + EXCLUIR_SERVICE_NAME + "Definition.wsdl");
			portExcluir = new InserirProgramacaoProducaoEquipamentoService(wsdlLocationExcluir, new QName(NAMESPACE, EXCLUIR_SERVICE_NAME))
								.getPort(ExcluirProgramacaoProducaoEquipamento.class);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void programarEquipamento(Equipamento equipamento){
		excluirProgramacoes(equipamento);
		inserirProgramacoes(equipamento);
	}

	private void excluirProgramacoes(Equipamento equipamento) {
		for (ProgramacaoProducaoEquipamentoDTO dto : equipamento.getDTO().getProgramacoesProducao()) {
			
			ExcluirProgramacaoProducaoEquipamentoRequest request = new ExcluirProgramacaoProducaoEquipamentoRequest();
			request.setCodigoEquipamento(equipamento.getId());
			
			request.setData(toData(dto.getDtHrInicio()));
			portExcluir.excluirProgramacaoProducaoEquipamento(request);
			
			request.setData(toData(dto.getDtHrFim()));
			portExcluir.excluirProgramacaoProducaoEquipamento(request);
			
		}
	}
	
	private Data toData(DataHoraDTO dtHrInicio) {
		Data data = new Data();
		data.setAno(dtHrInicio.getAno());
		data.setMes(dtHrInicio.getMes());
		data.setDia(dtHrInicio.getDia());
		return data;
	}

	private void inserirProgramacoes(Equipamento equipamento) {
		for (ProgramacaoProducaoEquipamentoDTO dto : equipamento.getDTO().getProgramacoesProducao()) {
			InserirProgramacaoProducaoEquipamentoRequest request = new InserirProgramacaoProducaoEquipamentoRequest();
			request.setCodigoEquipamento(equipamento.getId());
			request.setDataHoraInicial(toDataHoraInicial(dto.getDtHrInicio()));
			request.setDataHoraFinal(toDataHoraFinal(dto.getDtHrFim()));
			portInserir.inserirProgramacaoProducaoEquipamento(request);
		}
	}

	private DataHoraInicial toDataHoraInicial(DataHoraDTO dtHr) {
		DataHoraInicial result = new DataHoraInicial();
		result.setAno(dtHr.getAno());
		result.setMes(dtHr.getMes());
		result.setDia(dtHr.getDia());
		result.setHora(dtHr.getHora());
		result.setMinuto(dtHr.getMinutos());
		return result;
	}
	
	private DataHoraFinal toDataHoraFinal(DataHoraDTO dtHr) {
		DataHoraFinal result = new DataHoraFinal();
		result.setAno(dtHr.getAno());
		result.setMes(dtHr.getMes());
		result.setDia(dtHr.getDia());
		result.setHora(dtHr.getHora());
		result.setMinuto(dtHr.getMinutos());
		return result;
	}
	

}
