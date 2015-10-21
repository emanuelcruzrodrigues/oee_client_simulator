
package br.feevale.tc.oee.ws.programacao;

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
@WebService(name = "inserirOuAlterarProgramacaoProducaoEquipamento", targetNamespace = "programacao.ws.oee.tc.feevale.br")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface InserirOuAlterarProgramacaoProducaoEquipamento {


    /**
     * 
     * @param inserirOuAlterarProgramacaoProducaoEquipamentoRequest
     * @return
     *     returns br.feevale.tc.oee.ws.programacao.InserirOuAlterarProgramacaoProducaoEquipamentoResponse
     */
    @WebMethod
    @WebResult(name = "inserirOuAlterarProgramacaoProducaoEquipamentoResponse", targetNamespace = "programacao.ws.oee.tc.feevale.br", partName = "inserirOuAlterarProgramacaoProducaoEquipamentoResponse")
    public InserirOuAlterarProgramacaoProducaoEquipamentoResponse inserirOuAlterarProgramacaoProducaoEquipamento(
        @WebParam(name = "inserirOuAlterarProgramacaoProducaoEquipamentoRequest", targetNamespace = "programacao.ws.oee.tc.feevale.br", partName = "inserirOuAlterarProgramacaoProducaoEquipamentoRequest")
        InserirOuAlterarProgramacaoProducaoEquipamentoRequest inserirOuAlterarProgramacaoProducaoEquipamentoRequest);

}
