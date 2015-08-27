package br.feevale.tc.oee.simulador.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import br.feevale.tc.oee.simulador.dto.MotivoParadaDTO;
import br.feevale.tc.oee.ws.motivoparada.InserirOuAlterarMotivoParada;
import br.feevale.tc.oee.ws.motivoparada.InserirOuAlterarMotivoParadaRequest;
import br.feevale.tc.oee.ws.motivoparada.InserirOuAlterarMotivoParadaService;

public class MotivoParadaWSClient {
	
	private static final String NAMESPACE = "motivoParada.ws.oee.tc.feevale.br";
	private static final String SERVICE_NAME = "inserirOuAlterarMotivoParadaService";
	
	private InserirOuAlterarMotivoParada port;

	public MotivoParadaWSClient(String oeeServerURL) {
		try {
			URL wsdlLocation = new URL(oeeServerURL + SERVICE_NAME + "Definition.wsdl");
			QName qname = new QName(NAMESPACE, SERVICE_NAME);
			
			InserirOuAlterarMotivoParadaService service = new InserirOuAlterarMotivoParadaService(wsdlLocation, qname);
			port = service.getPort(InserirOuAlterarMotivoParada.class);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void inserirOuAlterar(MotivoParadaDTO motivoParadaDTO){
		InserirOuAlterarMotivoParadaRequest request = new InserirOuAlterarMotivoParadaRequest();
		request.setCodigo(motivoParadaDTO.getId());
		request.setDescricao(motivoParadaDTO.getDescricao());
		request.setSituacao("A");
		request.setTipoParada(motivoParadaDTO.getTipoParada());
		port.inserirOuAlterarMotivoParada(request);
	}

}
