package br.feevale.tc.oee.simulador.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import br.feevale.tc.oee.simulador.dto.DataHoraDTO;
import br.feevale.tc.oee.simulador.dto.ProgramacaoProducaoEquipamentoDTO;
import br.feevale.tc.oee.simulador.model.Equipamento;
import br.feevale.tc.oee.ws.programacao.DataHoraFinal;
import br.feevale.tc.oee.ws.programacao.DataHoraInicial;
import br.feevale.tc.oee.ws.programacao.ExcluirProgramacaoProducaoEquipamento;
import br.feevale.tc.oee.ws.programacao.ExcluirProgramacaoProducaoEquipamentoRequest;
import br.feevale.tc.oee.ws.programacao.ExcluirProgramacaoProducaoEquipamentoResponse;
import br.feevale.tc.oee.ws.programacao.InserirOuAlterarProgramacaoProducaoEquipamento;
import br.feevale.tc.oee.ws.programacao.InserirOuAlterarProgramacaoProducaoEquipamentoRequest;
import br.feevale.tc.oee.ws.programacao.InserirOuAlterarProgramacaoProducaoEquipamentoResponse;
import br.feevale.tc.oee.ws.programacao.InserirOuAlterarProgramacaoProducaoEquipamentoService;

/**
 * 
 * @author Emanuel Cruz Rodrigues -> emanuelcruzrodrigues@gmail.com
 * @see ProgramacaoProducaoEquipamentoWSClientTest
 *
 */
public class ProgramacaoProducaoEquipamentoWSClient {
	
	private static final String NAMESPACE = "programacao.ws.oee.tc.feevale.br";
	private static final String INSERIR_SERVICE_NAME = "inserirOuAlterarProgramacaoProducaoEquipamentoService";
	private static final String EXCLUIR_SERVICE_NAME = "excluirProgramacaoProducaoEquipamentoService";
	
	private InserirOuAlterarProgramacaoProducaoEquipamento portInserirOuAlterar;
	private ExcluirProgramacaoProducaoEquipamento portExcluir;

	public ProgramacaoProducaoEquipamentoWSClient(String oeeServerURL) {
		try {
			URL wsdlLocationIncluir = new URL(oeeServerURL + INSERIR_SERVICE_NAME + "Definition.wsdl");
			
			portInserirOuAlterar = new InserirOuAlterarProgramacaoProducaoEquipamentoService(wsdlLocationIncluir, new QName(NAMESPACE, INSERIR_SERVICE_NAME))
												.getPort(InserirOuAlterarProgramacaoProducaoEquipamento.class);
			
			URL wsdlLocationExcluir = new URL(oeeServerURL + EXCLUIR_SERVICE_NAME + "Definition.wsdl");
			portExcluir = new InserirOuAlterarProgramacaoProducaoEquipamentoService(wsdlLocationExcluir, new QName(NAMESPACE, EXCLUIR_SERVICE_NAME))
												.getPort(ExcluirProgramacaoProducaoEquipamento.class);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public InserirOuAlterarProgramacaoProducaoEquipamentoResponse inserirOuAlterar(Integer codigo, int codigoEquipamento, DataHoraInicial dataHoraInicial, DataHoraFinal dataHoraFinal) {
		InserirOuAlterarProgramacaoProducaoEquipamentoRequest request = new InserirOuAlterarProgramacaoProducaoEquipamentoRequest();
		request.setCodigo(codigo);
		request.setCodigoEquipamento(codigoEquipamento);
		request.setDataHoraInicial(dataHoraInicial);
		request.setDataHoraFinal(dataHoraFinal);
		return portInserirOuAlterar.inserirOuAlterarProgramacaoProducaoEquipamento(request);
	}
	
	public ExcluirProgramacaoProducaoEquipamentoResponse excluir(Integer codigo){
		ExcluirProgramacaoProducaoEquipamentoRequest request = new ExcluirProgramacaoProducaoEquipamentoRequest();
		request.setCodigo(codigo);
		return portExcluir.excluirProgramacaoProducaoEquipamento(request);
	}
	
	public void programarEquipamento(Equipamento equipamento){
		inserirProgramacoes(equipamento);
	}

	private void inserirProgramacoes(Equipamento equipamento) {
		for (ProgramacaoProducaoEquipamentoDTO dto : equipamento.getDTO().getProgramacoesProducao()) {
			inserirOuAlterar(dto.getId(), equipamento.getId(), toDataHoraInicial(dto.getDtHrInicio()), toDataHoraFinal(dto.getDtHrFim()));
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
