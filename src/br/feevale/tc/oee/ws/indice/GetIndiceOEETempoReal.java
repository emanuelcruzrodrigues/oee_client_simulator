
package br.feevale.tc.oee.ws.indice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "getIndiceOEETempoReal", targetNamespace = "indice.ws.oee.tc.feevale.br")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GetIndiceOEETempoReal {


    /**
     * 
     * @param getIndiceOEETempoRealRequest
     * @return
     *     returns br.feevale.tc.oee.ws.indice.GetIndiceOEETempoRealResponse
     */
    @WebMethod
    @WebResult(name = "getIndiceOEETempoRealResponse", targetNamespace = "indice.ws.oee.tc.feevale.br", partName = "getIndiceOEETempoRealResponse")
    public GetIndiceOEETempoRealResponse getIndiceOEETempoReal(
        @WebParam(name = "getIndiceOEETempoRealRequest", targetNamespace = "indice.ws.oee.tc.feevale.br", partName = "getIndiceOEETempoRealRequest")
        GetIndiceOEETempoRealRequest getIndiceOEETempoRealRequest);

}