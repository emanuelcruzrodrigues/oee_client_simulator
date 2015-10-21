package br.feevale.tc.oee.simulador.ws;

import static org.junit.Assert.*;

import org.junit.Test;

import br.feevale.tc.oee.ws.programacao.DataHoraFinal;
import br.feevale.tc.oee.ws.programacao.DataHoraInicial;
import br.feevale.tc.oee.ws.programacao.ExcluirProgramacaoProducaoEquipamentoResponse;
import br.feevale.tc.oee.ws.programacao.InserirOuAlterarProgramacaoProducaoEquipamentoResponse;

public class ProgramacaoProducaoEquipamentoWSClientTest {

	private ProgramacaoProducaoEquipamentoWSClient wsClient;

	public ProgramacaoProducaoEquipamentoWSClientTest() {
		wsClient = new ProgramacaoProducaoEquipamentoWSClient("http://localhost:8080/oee/ws/");
	}
	
	@Test
	public void testInclusaoAlteracao() {
		Integer codigo = -2;
		int codigoEquipamento = -1;
		DataHoraInicial dataHoraInicial = new DataHoraInicial();
		dataHoraInicial.setAno(2015);
		dataHoraInicial.setMes(10);
		dataHoraInicial.setDia(21);
		dataHoraInicial.setHora(7);
		dataHoraInicial.setMinuto(30);
		
		DataHoraFinal dataHoraFinal = new DataHoraFinal();
		dataHoraFinal.setAno(2015);
		dataHoraFinal.setMes(10);
		dataHoraFinal.setDia(21);
		dataHoraFinal.setHora(11);
		dataHoraFinal.setMinuto(45);
		
		InserirOuAlterarProgramacaoProducaoEquipamentoResponse response = wsClient.inserirOuAlterar(codigo, codigoEquipamento, dataHoraInicial, dataHoraFinal);
		assertNull(response.getErros());
	}

	@Test
	public void testExclusao() {
		testInclusaoAlteracao();
		
		Integer codigo = -2;
		ExcluirProgramacaoProducaoEquipamentoResponse response = wsClient.excluir(codigo);
		assertNull(response.getErros());
	}

}
