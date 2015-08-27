
package br.feevale.tc.oee.ws.apontamento;

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
@WebService(name = "inserirApontamentoQuantidade", targetNamespace = "apontamento.ws.oee.tc.feevale.br")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface InserirApontamentoQuantidade {


    /**
     * 
     * @param inserirApontamentoQuantidadeRequest
     * @return
     *     returns br.feevale.tc.oee.ws.apontamento.InserirApontamentoQuantidadeResponse
     */
    @WebMethod
    @WebResult(name = "inserirApontamentoQuantidadeResponse", targetNamespace = "apontamento.ws.oee.tc.feevale.br", partName = "inserirApontamentoQuantidadeResponse")
    public InserirApontamentoQuantidadeResponse inserirApontamentoQuantidade(
        @WebParam(name = "inserirApontamentoQuantidadeRequest", targetNamespace = "apontamento.ws.oee.tc.feevale.br", partName = "inserirApontamentoQuantidadeRequest")
        InserirApontamentoQuantidadeRequest inserirApontamentoQuantidadeRequest);

}
