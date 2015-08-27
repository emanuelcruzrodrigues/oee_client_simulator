
package br.feevale.tc.oee.ws.motivoparada;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "inserirOuAlterarMotivoParadaService", targetNamespace = "motivoParada.ws.oee.tc.feevale.br", wsdlLocation = "http://localhost:8080/oee/ws/inserirOuAlterarMotivoParadaServiceDefinition.wsdl")
public class InserirOuAlterarMotivoParadaService
    extends Service
{

    private final static URL INSERIROUALTERARMOTIVOPARADASERVICE_WSDL_LOCATION;
    private final static WebServiceException INSERIROUALTERARMOTIVOPARADASERVICE_EXCEPTION;
    private final static QName INSERIROUALTERARMOTIVOPARADASERVICE_QNAME = new QName("motivoParada.ws.oee.tc.feevale.br", "inserirOuAlterarMotivoParadaService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/oee/ws/inserirOuAlterarMotivoParadaServiceDefinition.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        INSERIROUALTERARMOTIVOPARADASERVICE_WSDL_LOCATION = url;
        INSERIROUALTERARMOTIVOPARADASERVICE_EXCEPTION = e;
    }

    public InserirOuAlterarMotivoParadaService() {
        super(__getWsdlLocation(), INSERIROUALTERARMOTIVOPARADASERVICE_QNAME);
    }

    public InserirOuAlterarMotivoParadaService(WebServiceFeature... features) {
        super(__getWsdlLocation(), INSERIROUALTERARMOTIVOPARADASERVICE_QNAME, features);
    }

    public InserirOuAlterarMotivoParadaService(URL wsdlLocation) {
        super(wsdlLocation, INSERIROUALTERARMOTIVOPARADASERVICE_QNAME);
    }

    public InserirOuAlterarMotivoParadaService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, INSERIROUALTERARMOTIVOPARADASERVICE_QNAME, features);
    }

    public InserirOuAlterarMotivoParadaService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public InserirOuAlterarMotivoParadaService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns InserirOuAlterarMotivoParada
     */
    @WebEndpoint(name = "inserirOuAlterarMotivoParadaSoap11")
    public InserirOuAlterarMotivoParada getInserirOuAlterarMotivoParadaSoap11() {
        return super.getPort(new QName("motivoParada.ws.oee.tc.feevale.br", "inserirOuAlterarMotivoParadaSoap11"), InserirOuAlterarMotivoParada.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns InserirOuAlterarMotivoParada
     */
    @WebEndpoint(name = "inserirOuAlterarMotivoParadaSoap11")
    public InserirOuAlterarMotivoParada getInserirOuAlterarMotivoParadaSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("motivoParada.ws.oee.tc.feevale.br", "inserirOuAlterarMotivoParadaSoap11"), InserirOuAlterarMotivoParada.class, features);
    }

    private static URL __getWsdlLocation() {
        if (INSERIROUALTERARMOTIVOPARADASERVICE_EXCEPTION!= null) {
            throw INSERIROUALTERARMOTIVOPARADASERVICE_EXCEPTION;
        }
        return INSERIROUALTERARMOTIVOPARADASERVICE_WSDL_LOCATION;
    }

}