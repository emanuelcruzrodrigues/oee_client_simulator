package br.feevale.tc.oee.simulador.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import br.feevale.tc.oee.simulador.model.Equipamento;
import br.feevale.tc.oee.simulador.model.OrdemProducao;
import br.feevale.tc.oee.ws.apontamento.DataHora;
import br.feevale.tc.oee.ws.apontamento.DataHoraFinal;
import br.feevale.tc.oee.ws.apontamento.DataHoraInicial;
import br.feevale.tc.oee.ws.apontamento.EncerrarApontamentoEquipamento;
import br.feevale.tc.oee.ws.apontamento.EncerrarApontamentoEquipamentoRequest;
import br.feevale.tc.oee.ws.apontamento.EncerrarApontamentoEquipamentoResponse;
import br.feevale.tc.oee.ws.apontamento.EncerrarApontamentoEquipamentoService;
import br.feevale.tc.oee.ws.apontamento.ExcluirApontamentoParada;
import br.feevale.tc.oee.ws.apontamento.ExcluirApontamentoParadaRequest;
import br.feevale.tc.oee.ws.apontamento.ExcluirApontamentoParadaResponse;
import br.feevale.tc.oee.ws.apontamento.ExcluirApontamentoParadaService;
import br.feevale.tc.oee.ws.apontamento.ExcluirApontamentoProducao;
import br.feevale.tc.oee.ws.apontamento.ExcluirApontamentoProducaoRequest;
import br.feevale.tc.oee.ws.apontamento.ExcluirApontamentoProducaoResponse;
import br.feevale.tc.oee.ws.apontamento.ExcluirApontamentoProducaoService;
import br.feevale.tc.oee.ws.apontamento.ExcluirApontamentoQuantidade;
import br.feevale.tc.oee.ws.apontamento.ExcluirApontamentoQuantidadeRequest;
import br.feevale.tc.oee.ws.apontamento.ExcluirApontamentoQuantidadeResponse;
import br.feevale.tc.oee.ws.apontamento.ExcluirApontamentoQuantidadeService;
import br.feevale.tc.oee.ws.apontamento.IniciarApontamentoParada;
import br.feevale.tc.oee.ws.apontamento.IniciarApontamentoParadaRequest;
import br.feevale.tc.oee.ws.apontamento.IniciarApontamentoParadaResponse;
import br.feevale.tc.oee.ws.apontamento.IniciarApontamentoParadaService;
import br.feevale.tc.oee.ws.apontamento.IniciarApontamentoProducao;
import br.feevale.tc.oee.ws.apontamento.IniciarApontamentoProducaoRequest;
import br.feevale.tc.oee.ws.apontamento.IniciarApontamentoProducaoResponse;
import br.feevale.tc.oee.ws.apontamento.IniciarApontamentoProducaoService;
import br.feevale.tc.oee.ws.apontamento.InserirApontamentoQuantidade;
import br.feevale.tc.oee.ws.apontamento.InserirApontamentoQuantidadeRefugo;
import br.feevale.tc.oee.ws.apontamento.InserirApontamentoQuantidadeRefugoRequest;
import br.feevale.tc.oee.ws.apontamento.InserirApontamentoQuantidadeRefugoResponse;
import br.feevale.tc.oee.ws.apontamento.InserirApontamentoQuantidadeRefugoService;
import br.feevale.tc.oee.ws.apontamento.InserirApontamentoQuantidadeRequest;
import br.feevale.tc.oee.ws.apontamento.InserirApontamentoQuantidadeResponse;
import br.feevale.tc.oee.ws.apontamento.InserirApontamentoQuantidadeService;
import br.feevale.tc.oee.ws.apontamento.InserirOuAlterarApontamentoParada;
import br.feevale.tc.oee.ws.apontamento.InserirOuAlterarApontamentoParadaRequest;
import br.feevale.tc.oee.ws.apontamento.InserirOuAlterarApontamentoParadaResponse;
import br.feevale.tc.oee.ws.apontamento.InserirOuAlterarApontamentoParadaService;
import br.feevale.tc.oee.ws.apontamento.InserirOuAlterarApontamentoProducao;
import br.feevale.tc.oee.ws.apontamento.InserirOuAlterarApontamentoProducaoRequest;
import br.feevale.tc.oee.ws.apontamento.InserirOuAlterarApontamentoProducaoResponse;
import br.feevale.tc.oee.ws.apontamento.InserirOuAlterarApontamentoProducaoService;
import br.feevale.tc.oee.ws.apontamento.InserirOuAlterarApontamentoQuantidade;
import br.feevale.tc.oee.ws.apontamento.InserirOuAlterarApontamentoQuantidadeRequest;
import br.feevale.tc.oee.ws.apontamento.InserirOuAlterarApontamentoQuantidadeResponse;
import br.feevale.tc.oee.ws.apontamento.InserirOuAlterarApontamentoQuantidadeService;

/**
 * 
 * @author Emanuel Cruz Rodrigues -> emanuelcruzrodrigues@gmail.com
 * @see ApontamentoWSClientTest
 */
public class ApontamentoWSClient {

	private static final String NAMESPACE = "apontamento.ws.oee.tc.feevale.br";
	
	private IniciarApontamentoProducao iniciarApontamentoProducaoPort;
	private IniciarApontamentoParada iniciarApontamentoParadaPort;
	private InserirApontamentoQuantidadeRefugo inserirApontamentoQuantidadeRefugoPort;
	private InserirApontamentoQuantidade inserirApontamentoQuantidadePort;
	private EncerrarApontamentoEquipamento encerrarApontamentoEquipamentoPort;
	
	private InserirOuAlterarApontamentoParada inserirOuAlterarApontamentoParadaPort;
	private InserirOuAlterarApontamentoProducao inserirOuAlterarApontamentoProducaoPort;
	private InserirOuAlterarApontamentoQuantidade inserirOuAlterarApontamentoQuantidadePort;
	
	private ExcluirApontamentoParada excluirApontamentoParadaPort;
	private ExcluirApontamentoProducao excluirApontamentoProducaoPort;
	private ExcluirApontamentoQuantidade excluirApontamentoQuantidadePort;

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
			
			inserirOuAlterarApontamentoParadaPort = new InserirOuAlterarApontamentoParadaService(
												 new URL(oeeServerURL + "inserirOuAlterarApontamentoParadaServiceDefinition.wsdl")
												,new QName(NAMESPACE, "inserirOuAlterarApontamentoParadaService"))
												.getPort(InserirOuAlterarApontamentoParada.class);

			inserirOuAlterarApontamentoProducaoPort = new InserirOuAlterarApontamentoProducaoService(
												 new URL(oeeServerURL + "inserirOuAlterarApontamentoProducaoServiceDefinition.wsdl")
												,new QName(NAMESPACE, "inserirOuAlterarApontamentoProducaoService"))
												.getPort(InserirOuAlterarApontamentoProducao.class);
			
			inserirOuAlterarApontamentoQuantidadePort = new InserirOuAlterarApontamentoQuantidadeService(
												 new URL(oeeServerURL + "inserirOuAlterarApontamentoQuantidadeServiceDefinition.wsdl")
												,new QName(NAMESPACE, "inserirOuAlterarApontamentoQuantidadeService"))
												.getPort(InserirOuAlterarApontamentoQuantidade.class);
			
			excluirApontamentoParadaPort = new ExcluirApontamentoParadaService(
												 new URL(oeeServerURL + "excluirApontamentoParadaServiceDefinition.wsdl")
												,new QName(NAMESPACE, "excluirApontamentoParadaService"))
												.getPort(ExcluirApontamentoParada.class);

			excluirApontamentoProducaoPort = new ExcluirApontamentoProducaoService(
												 new URL(oeeServerURL + "excluirApontamentoProducaoServiceDefinition.wsdl")
												,new QName(NAMESPACE, "excluirApontamentoProducaoService"))
												.getPort(ExcluirApontamentoProducao.class);

			excluirApontamentoQuantidadePort = new ExcluirApontamentoQuantidadeService(
												 new URL(oeeServerURL + "excluirApontamentoQuantidadeServiceDefinition.wsdl")
												,new QName(NAMESPACE, "excluirApontamentoQuantidadeService"))
												.getPort(ExcluirApontamentoQuantidade.class);

			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public IniciarApontamentoProducaoResponse iniciarApontamentoProducao(OrdemProducao ordemProducao) {
		IniciarApontamentoProducaoRequest request = new IniciarApontamentoProducaoRequest();
		request.setCodigoOrdemProducao(ordemProducao.getId());
		return iniciarApontamentoProducaoPort.iniciarApontamentoProducao(request);
	}

	public IniciarApontamentoParadaResponse iniciarApontamentoParada(Equipamento equipamento, Integer idMotivoParada) {
		IniciarApontamentoParadaRequest request = new IniciarApontamentoParadaRequest();
		request.setCodigoEquipamento(equipamento.getId());
		request.setCodigoMotivoParada(idMotivoParada);
		return iniciarApontamentoParadaPort.iniciarApontamentoParada(request);
	}

	public EncerrarApontamentoEquipamentoResponse encerrarApontamentos(Equipamento equipamento) {
		EncerrarApontamentoEquipamentoRequest request = new EncerrarApontamentoEquipamentoRequest();
		request.setCodigoEquipamento(equipamento.getId());
		return encerrarApontamentoEquipamentoPort.encerrarApontamentoEquipamento(request);
	}
	
	public InserirApontamentoQuantidadeResponse inserirApontamentoQuantidade(OrdemProducao ordemProducao, double quantidade){
		InserirApontamentoQuantidadeRequest request = new InserirApontamentoQuantidadeRequest();
		request.setCodigoOrdemProducao(ordemProducao.getId());
		request.setQuantidade(quantidade);
		return inserirApontamentoQuantidadePort.inserirApontamentoQuantidade(request);
	}
	
	public InserirApontamentoQuantidadeRefugoResponse inserirApontamentoQuantidadeRefugo(OrdemProducao ordemProducao, double quantidade){
		InserirApontamentoQuantidadeRefugoRequest request = new InserirApontamentoQuantidadeRefugoRequest();
		request.setCodigoOrdemProducao(ordemProducao.getId());
		request.setQuantidade(quantidade);
		return inserirApontamentoQuantidadeRefugoPort.inserirApontamentoQuantidadeRefugo(request);
	}
	
	public InserirOuAlterarApontamentoParadaResponse inserirOuAlterarApontamentoParada(Integer codigo, Integer idEquipamento, Integer idMotivoParada, DataHoraInicial dtHrInicial, DataHoraFinal dtHrFinal){
		InserirOuAlterarApontamentoParadaRequest request = new InserirOuAlterarApontamentoParadaRequest();
		request.setCodigo(codigo);
		request.setCodigoEquipamento(idEquipamento);
		request.setCodigoMotivoParada(idMotivoParada);
		request.setDataHoraInicial(dtHrInicial);
		request.setDataHoraFinal(dtHrFinal);
		return inserirOuAlterarApontamentoParadaPort.inserirOuAlterarApontamentoParada(request);
	}
	
	public InserirOuAlterarApontamentoProducaoResponse inserirOuAlterarApontamentoProducao(Integer codigo, int idOrdemProducao, DataHoraInicial dtHrInicial, DataHoraFinal dtHrFinal){
		InserirOuAlterarApontamentoProducaoRequest request = new InserirOuAlterarApontamentoProducaoRequest();
		request.setCodigo(codigo);
		request.setCodigoOrdemProducao(idOrdemProducao);
		request.setDataHoraInicial(dtHrInicial);
		request.setDataHoraFinal(dtHrFinal);
		return inserirOuAlterarApontamentoProducaoPort.inserirOuAlterarApontamentoProducao(request);
	}
	
	public InserirOuAlterarApontamentoQuantidadeResponse inserirOuAlterarApontamentoQuantidade(Integer codigo, int idOrdemProducao, DataHora dtHr, String dmQualidade, double quantidade){
		InserirOuAlterarApontamentoQuantidadeRequest request = new InserirOuAlterarApontamentoQuantidadeRequest();
		request.setCodigo(codigo);
		request.setCodigoOrdemProducao(idOrdemProducao);
		request.setDataHora(dtHr);
		request.setQualidadeProducao(dmQualidade);
		request.setQuantidade(quantidade);
		return inserirOuAlterarApontamentoQuantidadePort.inserirOuAlterarApontamentoQuantidade(request);
	}
	
	public ExcluirApontamentoParadaResponse excluirApontamentoParada(Integer codigo){
		ExcluirApontamentoParadaRequest request = new ExcluirApontamentoParadaRequest();
		request.setCodigo(codigo);
		return excluirApontamentoParadaPort.excluirApontamentoParada(request);
	}
	
	public ExcluirApontamentoProducaoResponse excluirApontamentoProducao(Integer codigo){
		ExcluirApontamentoProducaoRequest request = new ExcluirApontamentoProducaoRequest();
		request.setCodigo(codigo);
		return excluirApontamentoProducaoPort.excluirApontamentoProducao(request);
	}
	
	public ExcluirApontamentoQuantidadeResponse excluirApontamentoQuantidade(Integer codigo){
		ExcluirApontamentoQuantidadeRequest request = new ExcluirApontamentoQuantidadeRequest();
		request.setCodigo(codigo);
		return excluirApontamentoQuantidadePort.excluirApontamentoQuantidade(request);
	}

}
