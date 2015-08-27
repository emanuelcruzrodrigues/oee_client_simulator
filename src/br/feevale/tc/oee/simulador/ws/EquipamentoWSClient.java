package br.feevale.tc.oee.simulador.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import br.feevale.tc.oee.simulador.dto.EquipamentoDTO;
import br.feevale.tc.oee.ws.equipamento.InserirOuAlterarEquipamento;
import br.feevale.tc.oee.ws.equipamento.InserirOuAlterarEquipamentoRequest;
import br.feevale.tc.oee.ws.equipamento.InserirOuAlterarEquipamentoService;

public class EquipamentoWSClient {
	
	private static final String NAMESPACE = "equipamento.ws.oee.tc.feevale.br";
	private static final String SERVICE_NAME = "inserirOuAlterarEquipamentoService";
	
	private InserirOuAlterarEquipamento port;

	public EquipamentoWSClient(String oeeServerURL) {
		try {
			URL wsdlLocation = new URL(oeeServerURL + SERVICE_NAME + "Definition.wsdl");
			QName qname = new QName(NAMESPACE, SERVICE_NAME);
			
			InserirOuAlterarEquipamentoService service = new InserirOuAlterarEquipamentoService(wsdlLocation, qname);
			port = service.getPort(InserirOuAlterarEquipamento.class);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void inserirOuAlterar(EquipamentoDTO equipamentoDTO){
		InserirOuAlterarEquipamentoRequest request = new InserirOuAlterarEquipamentoRequest();
		request.setCodigo(equipamentoDTO.getId());
		request.setNome(equipamentoDTO.getNome());
		request.setSituacao("A");
		port.inserirOuAlterarEquipamento(request);
	}

}
