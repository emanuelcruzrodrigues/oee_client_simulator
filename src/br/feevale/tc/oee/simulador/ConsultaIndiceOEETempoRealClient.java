package br.feevale.tc.oee.simulador;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import br.feevale.tc.oee.ws.indice.GetIndiceOEETempoReal;
import br.feevale.tc.oee.ws.indice.GetIndiceOEETempoRealRequest;
import br.feevale.tc.oee.ws.indice.GetIndiceOEETempoRealResponse;
import br.feevale.tc.oee.ws.indice.GetIndiceOEETempoRealService;

public class ConsultaIndiceOEETempoRealClient {
	
	private static final String NAMESPACE = "indice.ws.oee.tc.feevale.br";
	private static final String SERVICE_NAME = "getIndiceOEETempoRealService";
	
	private GetIndiceOEETempoReal port;

	public ConsultaIndiceOEETempoRealClient(String oeeServerURL) {
		try {
			URL wsdlLocation = new URL(oeeServerURL + SERVICE_NAME + "Definition.wsdl");
			QName qname = new QName(NAMESPACE, SERVICE_NAME);
			
			GetIndiceOEETempoRealService service = new GetIndiceOEETempoRealService(wsdlLocation, qname);
			port = service.getPort(GetIndiceOEETempoReal.class);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void printResultado(){
		GetIndiceOEETempoRealRequest request = new GetIndiceOEETempoRealRequest();
		request.setCodigoEquipamento(123);
		request.setPeriodoMinutos(30);
		GetIndiceOEETempoRealResponse response = port.getIndiceOEETempoReal(request);
		System.out.println("Disponibilidade: " + response.getDisponibilidade());
		System.out.println("Desempenho: " + response.getDesempenho());
		System.out.println("Qualidade: " + response.getQualidade());
		System.out.println("OEE: " + response.getOee());
		System.out.println("Erros: " + response.getErros());
	}
	
	public static void main(String[] args) {
		ConsultaIndiceOEETempoRealClient consulta = new ConsultaIndiceOEETempoRealClient("http://localhost:8080/oee/ws/");
		consulta.printResultado();
	}
	
	

}
