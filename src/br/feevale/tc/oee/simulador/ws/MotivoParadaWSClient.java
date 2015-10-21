package br.feevale.tc.oee.simulador.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import br.feevale.tc.oee.simulador.dto.MotivoParadaDTO;
import br.feevale.tc.oee.ws.motivoparada.ExcluirMotivoParada;
import br.feevale.tc.oee.ws.motivoparada.ExcluirMotivoParadaRequest;
import br.feevale.tc.oee.ws.motivoparada.ExcluirMotivoParadaResponse;
import br.feevale.tc.oee.ws.motivoparada.ExcluirMotivoParadaService;
import br.feevale.tc.oee.ws.motivoparada.InserirOuAlterarMotivoParada;
import br.feevale.tc.oee.ws.motivoparada.InserirOuAlterarMotivoParadaRequest;
import br.feevale.tc.oee.ws.motivoparada.InserirOuAlterarMotivoParadaResponse;
import br.feevale.tc.oee.ws.motivoparada.InserirOuAlterarMotivoParadaService;

/**
 * 
 * @author Emanuel Cruz Rodrigues -> emanuelcruzrodrigues@gmail.com
 * @see MotivoParadaWSClientTest
 *
 */
public class MotivoParadaWSClient {
	
	private static final String NAMESPACE = "motivoParada.ws.oee.tc.feevale.br";
	private static final String INCLUIR_SERVICE_NAME = "inserirOuAlterarMotivoParadaService";
	private static final String EXCLUIR_SERVICE_NAME = "excluirMotivoParadaService";
	
	private InserirOuAlterarMotivoParada portIncluir;
	private ExcluirMotivoParada portExcluir;

	public MotivoParadaWSClient(String oeeServerURL) {
		try {
			portIncluir = new InserirOuAlterarMotivoParadaService(
															  new URL(oeeServerURL + INCLUIR_SERVICE_NAME + "Definition.wsdl")
															, new QName(NAMESPACE, INCLUIR_SERVICE_NAME))
													.getPort(InserirOuAlterarMotivoParada.class);
			
			portExcluir = new ExcluirMotivoParadaService(
														  new URL(oeeServerURL + EXCLUIR_SERVICE_NAME + "Definition.wsdl")
														, new QName(NAMESPACE, EXCLUIR_SERVICE_NAME))
												.getPort(ExcluirMotivoParada.class);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public InserirOuAlterarMotivoParadaResponse inserirOuAlterar(MotivoParadaDTO motivoParadaDTO){
		InserirOuAlterarMotivoParadaRequest request = new InserirOuAlterarMotivoParadaRequest();
		request.setCodigo(motivoParadaDTO.getId());
		request.setDescricao(motivoParadaDTO.getDescricao());
		request.setSituacao("A");
		request.setTipoParada(motivoParadaDTO.getTipoParada());
		return portIncluir.inserirOuAlterarMotivoParada(request);
	}
	
	public ExcluirMotivoParadaResponse excluir(int codigo){
		ExcluirMotivoParadaRequest request = new ExcluirMotivoParadaRequest();
		request.setCodigo(codigo);
		return portExcluir.excluirMotivoParada(request);
	}
	
}
