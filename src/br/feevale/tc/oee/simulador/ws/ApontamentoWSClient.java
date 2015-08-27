package br.feevale.tc.oee.simulador.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import br.feevale.tc.oee.simulador.model.Equipamento;
import br.feevale.tc.oee.simulador.model.OrdemProducao;
import br.feevale.tc.oee.ws.apontamento.EncerrarApontamentoEquipamento;
import br.feevale.tc.oee.ws.apontamento.EncerrarApontamentoEquipamentoRequest;
import br.feevale.tc.oee.ws.apontamento.EncerrarApontamentoEquipamentoService;
import br.feevale.tc.oee.ws.apontamento.IniciarApontamentoParada;
import br.feevale.tc.oee.ws.apontamento.IniciarApontamentoParadaRequest;
import br.feevale.tc.oee.ws.apontamento.IniciarApontamentoParadaService;
import br.feevale.tc.oee.ws.apontamento.IniciarApontamentoProducao;
import br.feevale.tc.oee.ws.apontamento.IniciarApontamentoProducaoRequest;
import br.feevale.tc.oee.ws.apontamento.IniciarApontamentoProducaoService;
import br.feevale.tc.oee.ws.apontamento.InserirApontamentoQuantidade;
import br.feevale.tc.oee.ws.apontamento.InserirApontamentoQuantidadeRefugo;
import br.feevale.tc.oee.ws.apontamento.InserirApontamentoQuantidadeRefugoRequest;
import br.feevale.tc.oee.ws.apontamento.InserirApontamentoQuantidadeRefugoService;
import br.feevale.tc.oee.ws.apontamento.InserirApontamentoQuantidadeRequest;
import br.feevale.tc.oee.ws.apontamento.InserirApontamentoQuantidadeService;

public class ApontamentoWSClient {

	private static final String NAMESPACE = "apontamento.ws.oee.tc.feevale.br";
	
	private IniciarApontamentoProducao iniciarApontamentoProducaoPort;
	private IniciarApontamentoParada iniciarApontamentoParadaPort;
	private InserirApontamentoQuantidadeRefugo inserirApontamentoQuantidadeRefugoPort;
	private InserirApontamentoQuantidade inserirApontamentoQuantidadePort;
	private EncerrarApontamentoEquipamento encerrarApontamentoEquipamentoPort;

	public ApontamentoWSClient(String oeeServerURL) {
		try {
			
			iniciarApontamentoProducaoPort = new IniciarApontamentoProducaoService(
												 new URL(oeeServerURL + "iniciarApontamentoProducaoServiceDefinition.wsdl")
												,new QName(NAMESPACE, "iniciarApontamentoProducaoService"))
												.getPort(IniciarApontamentoProducao.class);
			
			iniciarApontamentoParadaPort = new IniciarApontamentoParadaService(
												new URL(oeeServerURL + "iniciarApontamentoParadaServiceDefinition.wsdl")
											   ,new QName(NAMESPACE, "iniciarApontamentoParadaService"))
											   .getPort(IniciarApontamentoParada.class);
			
			inserirApontamentoQuantidadePort = new InserirApontamentoQuantidadeService(
												new URL(oeeServerURL + "inserirApontamentoQuantidadeServiceDefinition.wsdl")
											   ,new QName(NAMESPACE, "inserirApontamentoQuantidadeService"))
											   .getPort(InserirApontamentoQuantidade.class);

			inserirApontamentoQuantidadeRefugoPort = new InserirApontamentoQuantidadeRefugoService(
												new URL(oeeServerURL + "inserirApontamentoQuantidadeRefugoServiceDefinition.wsdl")
											   ,new QName(NAMESPACE, "inserirApontamentoQuantidadeRefugoService"))
											   .getPort(InserirApontamentoQuantidadeRefugo.class);
			
			encerrarApontamentoEquipamentoPort = new EncerrarApontamentoEquipamentoService(
												new URL(oeeServerURL + "encerrarApontamentoEquipamentoServiceDefinition.wsdl")
											   ,new QName(NAMESPACE, "encerrarApontamentoEquipamentoService"))
											   .getPort(EncerrarApontamentoEquipamento.class);

			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void iniciarApontamentoProducao(OrdemProducao ordemProducao) {
		IniciarApontamentoProducaoRequest request = new IniciarApontamentoProducaoRequest();
		request.setCodigoOrdemProducao(ordemProducao.getId());
		iniciarApontamentoProducaoPort.iniciarApontamentoProducao(request);
	}

	public void iniciarApontamentoParada(Equipamento equipamento, Integer idMotivoParada) {
		IniciarApontamentoParadaRequest request = new IniciarApontamentoParadaRequest();
		request.setCodigoEquipamento(equipamento.getId());
		request.setCodigoMotivoParada(idMotivoParada);
		iniciarApontamentoParadaPort.iniciarApontamentoParada(request);
	}

	public void encerrarApontamentos(Equipamento equipamento) {
		EncerrarApontamentoEquipamentoRequest request = new EncerrarApontamentoEquipamentoRequest();
		request.setCodigoEquipamento(equipamento.getId());
		encerrarApontamentoEquipamentoPort.encerrarApontamentoEquipamento(request);
	}
	
	public void inserirApontamentoQuantidade(OrdemProducao ordemProducao, double quantidade){
		InserirApontamentoQuantidadeRequest request = new InserirApontamentoQuantidadeRequest();
		request.setCodigoOrdemProducao(ordemProducao.getId());
		request.setQuantidade(quantidade);
		inserirApontamentoQuantidadePort.inserirApontamentoQuantidade(request);
	}
	
	public void inserirApontamentoQuantidadeRefugo(OrdemProducao ordemProducao, double quantidade){
		InserirApontamentoQuantidadeRefugoRequest request = new InserirApontamentoQuantidadeRefugoRequest();
		request.setCodigoOrdemProducao(ordemProducao.getId());
		request.setQuantidade(quantidade);
		inserirApontamentoQuantidadeRefugoPort.inserirApontamentoQuantidadeRefugo(request);
	}
	
	public static void main(String[] args) {
		ApontamentoWSClient wsClient = new ApontamentoWSClient("http://localhost:8080/oee/ws/");
		Equipamento equipamento = new Equipamento(37);
		wsClient.encerrarApontamentos(equipamento);
	}
	

}
