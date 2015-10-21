package br.feevale.tc.oee.simulador.ws;

import static org.junit.Assert.*;

import org.junit.Test;

import br.feevale.tc.oee.ws.ordemproducao.ExcluirOrdemProducaoResponse;
import br.feevale.tc.oee.ws.ordemproducao.InserirOuAlterarOrdemProducaoResponse;

public class OrdemProducaoWSClientTest {
	
	private OrdemProducaoWSClient wsClient;

	public OrdemProducaoWSClientTest() {
		wsClient = new OrdemProducaoWSClient("http://localhost:8080/oee/ws/");
	}

	@Test
	public void testInserirOuAlterar() {
		int id = -2;
		String descricao = "teste...";
		double unidadesPorMinuto = 10;
		String situacao = "A";
		int codigoEquipamento = -1;
		InserirOuAlterarOrdemProducaoResponse response = wsClient.inserirOuAlterar(id, descricao, unidadesPorMinuto, situacao, codigoEquipamento);
		assertNull(response.getErros());
	}

	@Test
	public void testExcluir() {
		testInserirOuAlterar();
		
		int codigo = -2;
		ExcluirOrdemProducaoResponse response = wsClient.excluir(codigo);
		assertNull(response.getErros());
	}

}
