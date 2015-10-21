package br.feevale.tc.oee.simulador.ws;

import static org.junit.Assert.*;

import org.junit.Test;

import br.feevale.tc.oee.simulador.dto.EquipamentoDTO;
import br.feevale.tc.oee.simulador.dto.OrdemProducaoDTO;
import br.feevale.tc.oee.simulador.model.Equipamento;
import br.feevale.tc.oee.simulador.model.OrdemProducao;
import br.feevale.tc.oee.ws.apontamento.DataHora;
import br.feevale.tc.oee.ws.apontamento.DataHoraFinal;
import br.feevale.tc.oee.ws.apontamento.DataHoraInicial;
import br.feevale.tc.oee.ws.apontamento.EncerrarApontamentoEquipamentoResponse;
import br.feevale.tc.oee.ws.apontamento.ExcluirApontamentoParadaResponse;
import br.feevale.tc.oee.ws.apontamento.ExcluirApontamentoProducaoResponse;
import br.feevale.tc.oee.ws.apontamento.ExcluirApontamentoQuantidadeResponse;
import br.feevale.tc.oee.ws.apontamento.IniciarApontamentoParadaResponse;
import br.feevale.tc.oee.ws.apontamento.IniciarApontamentoProducaoResponse;
import br.feevale.tc.oee.ws.apontamento.InserirApontamentoQuantidadeRefugoResponse;
import br.feevale.tc.oee.ws.apontamento.InserirApontamentoQuantidadeResponse;
import br.feevale.tc.oee.ws.apontamento.InserirOuAlterarApontamentoParadaResponse;
import br.feevale.tc.oee.ws.apontamento.InserirOuAlterarApontamentoProducaoResponse;
import br.feevale.tc.oee.ws.apontamento.InserirOuAlterarApontamentoQuantidadeResponse;

public class ApontamentoWSClientTest {
	
	private ApontamentoWSClient wsClient;
	
	public ApontamentoWSClientTest() {
		wsClient = new ApontamentoWSClient("http://localhost:8080/oee/ws/");
	}
	
	@Test
	public void testIniciarApontamentoProducao() {
		OrdemProducaoDTO dto = new OrdemProducaoDTO();
		dto.setId(-1);
		OrdemProducao ordemProducao = new OrdemProducao(dto);
		
		IniciarApontamentoProducaoResponse response = wsClient.iniciarApontamentoProducao(ordemProducao);
		
		assertNull(response.getErros());
	}

	@Test
	public void testIniciarApontamentoParada() {
		EquipamentoDTO equipamentoDTO = new EquipamentoDTO(-1, "");
		Equipamento equipamento = new Equipamento(equipamentoDTO);
		Integer idMotivoParada = -1;
		
		IniciarApontamentoParadaResponse response = wsClient.iniciarApontamentoParada(equipamento, idMotivoParada);
		
		assertNull(response.getErros());
	}

	@Test
	public void testEncerrarApontamentos() {
		EquipamentoDTO equipamentoDTO = new EquipamentoDTO(-1, "");
		Equipamento equipamento = new Equipamento(equipamentoDTO);
		
		EncerrarApontamentoEquipamentoResponse response = wsClient.encerrarApontamentos(equipamento);
		
		assertNull(response.getErros());
	}
	
	@Test
	public void testInserirApontamentoQuantidade(){
		OrdemProducaoDTO dto = new OrdemProducaoDTO();
		dto.setId(-1);
		OrdemProducao ordemProducao = new OrdemProducao(dto);
		
		double quantidade = 10D;
		
		InserirApontamentoQuantidadeResponse response = wsClient.inserirApontamentoQuantidade(ordemProducao, quantidade);
		
		assertNull(response.getErros());
	}
	
	@Test
	public void testInserirApontamentoQuantidadeRefugo(){
		OrdemProducaoDTO dto = new OrdemProducaoDTO();
		dto.setId(-1);
		OrdemProducao ordemProducao = new OrdemProducao(dto);
		
		double quantidade = 20D;
		
		InserirApontamentoQuantidadeRefugoResponse response = wsClient.inserirApontamentoQuantidadeRefugo(ordemProducao, quantidade );
		
		assertNull(response.getErros());
	}
	
	@Test
	public void testInserirOuAlterarApontamentoProducao() {
		
		DataHoraInicial dtHrInicial = new DataHoraInicial();
		dtHrInicial.setAno(2015);
		dtHrInicial.setMes(10);
		dtHrInicial.setDia(21);
		dtHrInicial.setHora(12);
		dtHrInicial.setMinuto(0);
		
		DataHoraFinal dtHrFinal = new DataHoraFinal();
		dtHrFinal.setAno(2015);
		dtHrFinal.setMes(10);
		dtHrFinal.setDia(21);
		dtHrFinal.setHora(12);
		dtHrFinal.setMinuto(31);
		
		int codigo = -1;
		int idOrdemProducao = codigo;
		InserirOuAlterarApontamentoProducaoResponse response = wsClient.inserirOuAlterarApontamentoProducao(codigo, idOrdemProducao, dtHrInicial, dtHrFinal);
		
		assertNull(response.getErros());
	}
	
	@Test
	public void testInserirOuAlterarApontamentoParada() {
		DataHoraInicial dtHrInicial = new DataHoraInicial();
		dtHrInicial.setAno(2015);
		dtHrInicial.setMes(10);
		dtHrInicial.setDia(21);
		dtHrInicial.setHora(9);
		dtHrInicial.setMinuto(10);
		
		DataHoraFinal dtHrFinal = new DataHoraFinal();
		dtHrFinal.setAno(2015);
		dtHrFinal.setMes(10);
		dtHrFinal.setDia(21);
		dtHrFinal.setHora(10);
		dtHrFinal.setMinuto(25);
		
		Integer codigo = -2;
		Integer idMotivoParada = -1;
		Integer idEquipamento = -1;
		InserirOuAlterarApontamentoParadaResponse response = wsClient.inserirOuAlterarApontamentoParada(codigo, idEquipamento, idMotivoParada, dtHrInicial, dtHrFinal);
		
		assertNull(response.getErros());
	}
	
	@Test
	public void testInserirOuAlterarApontamentoQuantidade() {
		
		DataHora dtHr = new DataHora();
		dtHr.setAno(2015);
		dtHr.setMes(10);
		dtHr.setDia(21);
		dtHr.setHora(12);
		dtHr.setMinuto(16);
		
		int idOrdemProducao = -1;
		String dmQualidade = "R";
		double quantidade = 10D;
		InserirOuAlterarApontamentoQuantidadeResponse response = wsClient.inserirOuAlterarApontamentoQuantidade(-3, idOrdemProducao, dtHr, dmQualidade, quantidade);
		
		assertNull(response.getErros());
	}
	
	@Test
	public void testExcluirApontamentoProducao() {
		testInserirOuAlterarApontamentoProducao();
		
		Integer codigo = -1;
		ExcluirApontamentoProducaoResponse response = wsClient.excluirApontamentoProducao(codigo);
		assertNull(response.getErros());
	}

	@Test
	public void testExcluirApontamentoParada() {
		testInserirOuAlterarApontamentoParada();
		
		Integer codigo = -2;
		ExcluirApontamentoParadaResponse response = wsClient.excluirApontamentoParada(codigo);
		assertNull(response.getErros());
	}

	@Test
	public void testExcluirApontamentoQuantidade() {
		testInserirOuAlterarApontamentoQuantidade();
		
		Integer codigo = -3;
		ExcluirApontamentoQuantidadeResponse response = wsClient.excluirApontamentoQuantidade(codigo);
		assertNull(response.getErros());
	}

}
