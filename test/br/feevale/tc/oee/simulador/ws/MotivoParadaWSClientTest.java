package br.feevale.tc.oee.simulador.ws;

import static org.junit.Assert.*;

import org.junit.Test;

import br.feevale.tc.oee.simulador.dto.MotivoParadaDTO;
import br.feevale.tc.oee.ws.motivoparada.ExcluirMotivoParadaResponse;
import br.feevale.tc.oee.ws.motivoparada.InserirOuAlterarMotivoParadaResponse;

public class MotivoParadaWSClientTest {
	
	private MotivoParadaWSClient wsClient;

	public MotivoParadaWSClientTest() {
		wsClient = new MotivoParadaWSClient("http://localhost:8080/oee/ws/");
	}
	
	@Test
	public void testInserirOuAlterar() {
		int id = -2;
		String descricao = "teste de motivo parada 2";
		String tipoParada = "DTT";
		MotivoParadaDTO motivoParadaDTO = new MotivoParadaDTO(id, descricao, tipoParada);
		InserirOuAlterarMotivoParadaResponse response = wsClient.inserirOuAlterar(motivoParadaDTO);
		assertNull(response.getErros());
	}

	@Test
	public void testExcluir() {
		testInserirOuAlterar();
		
		int codigo = -2;
		ExcluirMotivoParadaResponse response = wsClient.excluir(codigo);
		assertNull(response.getErros());
	}


}
