package br.feevale.tc.oee.simulador.ws;

import static org.junit.Assert.*;

import org.junit.Test;

import br.feevale.tc.oee.simulador.dto.EquipamentoDTO;
import br.feevale.tc.oee.ws.equipamento.ExcluirEquipamentoResponse;
import br.feevale.tc.oee.ws.equipamento.InserirOuAlterarEquipamentoResponse;

public class EquipamentoWSClientTest {
	
	private EquipamentoWSClient wsClient;
	
	public EquipamentoWSClientTest() {
		wsClient = new EquipamentoWSClient("http://localhost:8080/oee/ws/");
	}

	@Test
	public void testInserirOuAlterar() {
		EquipamentoDTO equipamentoDTO = new EquipamentoDTO();
		equipamentoDTO.setId(-2);
		equipamentoDTO.setNome("nome do equipamento");
		InserirOuAlterarEquipamentoResponse response = wsClient.inserirOuAlterar(equipamentoDTO);
		assertNull(response.getErros());
	}

	@Test
	public void testExcluir() {
		int codigo = -2;
		ExcluirEquipamentoResponse response = wsClient.excluir(codigo);
		assertNull(response.getErros());
	}

}
