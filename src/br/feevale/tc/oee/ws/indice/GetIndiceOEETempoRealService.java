
package br.feevale.tc.oee.ws.indice;

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
@WebServiceClient(name = "getIndiceOEETempoRealService", targetNamespace = "indice.ws.oee.tc.feevale.br", wsdlLocation = "http://localhost:8080/oee/ws/getIndiceOEETempoRealServiceDefinition.wsdl")
public class GetIndiceOEETempoRealService
    extends Service
{

    private final static URL GETINDICEOEETEMPOREALSERVICE_WSDL_LOCATION;
    private final static WebServiceException GETINDICEOEETEMPOREALSERVICE_EXCEPTION;
    private final static QName GETINDICEOEETEMPOREALSERVICE_QNAME = new QName("indice.ws.oee.tc.feevale.br", "getIndiceOEETempoRealService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/oee/ws/getIndiceOEETempoRealServiceDefinition.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        GETINDICEOEETEMPOREALSERVICE_WSDL_LOCATION = url;
        GETINDICEOEETEMPOREALSERVICE_EXCEPTION = e;
    }

    public GetIndiceOEETempoRealService() {
        super(__getWsdlLocation(), GETINDICEOEETEMPOREALSERVICE_QNAME);
    }

    public GetIndiceOEETempoRealService(WebServiceFeature... features) {
        super(__getWsdlLocation(), GETINDICEOEETEMPOREALSERVICE_QNAME, features);
    }

    public GetIndiceOEETempoRealService(URL wsdlLocation) {
        super(wsdlLocation, GETINDICEOEETEMPOREALSERVICE_QNAME);
    }

    public GetIndiceOEETempoRealService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GETINDICEOEETEMPOREALSERVICE_QNAME, features);
    }

    public GetIndiceOEETempoRealService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GetIndiceOEETempoRealService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns GetIndiceOEETempoReal
     */
    @WebEndpoint(name = "getIndiceOEETempoRealSoap11")
    public GetIndiceOEETempoReal getGetIndiceOEETempoRealSoap11() {
        return super.getPort(new QName("indice.ws.oee.tc.feevale.br", "getIndiceOEETempoRealSoap11"), GetIndiceOEETempoReal.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GetIndiceOEETempoReal
     */
    @WebEndpoint(name = "getIndiceOEETempoRealSoap11")
    public GetIndiceOEETempoReal getGetIndiceOEETempoRealSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("indice.ws.oee.tc.feevale.br", "getIndiceOEETempoRealSoap11"), GetIndiceOEETempoReal.class, features);
    }

    private static URL __getWsdlLocation() {
        if (GETINDICEOEETEMPOREALSERVICE_EXCEPTION!= null) {
            throw GETINDICEOEETEMPOREALSERVICE_EXCEPTION;
        }
        return GETINDICEOEETEMPOREALSERVICE_WSDL_LOCATION;
    }

}
