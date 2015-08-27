package br.feevale.tc.oee.simulador.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import br.feevale.tc.oee.simulador.dto.EquipamentoDTO;
import br.feevale.tc.oee.simulador.dto.OrdemProducaoDTO;
import br.feevale.tc.oee.ws.ordemproducao.InserirOuAlterarOrdemProducao;
import br.feevale.tc.oee.ws.ordemproducao.InserirOuAlterarOrdemProducaoRequest;
import br.feevale.tc.oee.ws.ordemproducao.InserirOuAlterarOrdemProducaoService;

public class OrdemProducaoWSClient {
	
	private static final String NAMESPACE = "ordemProducao.ws.oee.tc.feevale.br";
	private static final String SERVICE_NAME = "inserirOuAlterarOrdemProducaoService";
	
	private InserirOuAlterarOrdemProducao port;

	public OrdemProducaoWSClient(String oeeServerURL) {
		try {
			URL wsdlLocation = new URL(oeeServerURL + SERVICE_NAME + "Definition.wsdl");
			QName qname = new QName(NAMESPACE, SERVICE_NAME);
			
			InserirOuAlterarOrdemProducaoService service = new InserirOuAlterarOrdemProducaoService(wsdlLocation, qname);
			port = service.getPort(InserirOuAlterarOrdemProducao.class);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void inserirOuAlterarOrdensDeProducao(EquipamentoDTO equipamentoDTO){
		for (OrdemProducaoDTO ordemProducaoDTO : equipamentoDTO.getOrdensProducao()) {
			InserirOuAlterarOrdemProducaoRequest request = new InserirOuAlterarOrdemProducaoRequest();
			request.setCodigo(ordemProducaoDTO.getId());
			request.setDescricao(ordemProducaoDTO.getDescricao());
			request.setUnidadesPorMinuto(ordemProducaoDTO.getUnidadesPorMinutoMaximo());
			request.setSituacao("A");
			request.setCodigoEquipamento(equipamentoDTO.getId());
			port.inserirOuAlterarOrdemProducao(request);
		}
	}

}
