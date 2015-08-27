
package br.feevale.tc.oee.ws.programacao;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.feevale.tc.oee.ws.programacao package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CodigoEquipamento_QNAME = new QName("programacao.ws.oee.tc.feevale.br", "codigoEquipamento");
    private final static QName _Erros_QNAME = new QName("programacao.ws.oee.tc.feevale.br", "erros");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.feevale.tc.oee.ws.programacao
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExcluirProgramacaoProducaoEquipamentoResponse }
     * 
     */
    public ExcluirProgramacaoProducaoEquipamentoResponse createExcluirProgramacaoProducaoEquipamentoResponse() {
        return new ExcluirProgramacaoProducaoEquipamentoResponse();
    }

    /**
     * Create an instance of {@link ExcluirProgramacaoProducaoEquipamentoRequest }
     * 
     */
    public ExcluirProgramacaoProducaoEquipamentoRequest createExcluirProgramacaoProducaoEquipamentoRequest() {
        return new ExcluirProgramacaoProducaoEquipamentoRequest();
    }

    /**
     * Create an instance of {@link Data }
     * 
     */
    public Data createData() {
        return new Data();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "programacao.ws.oee.tc.feevale.br", name = "codigoEquipamento")
    public JAXBElement<Integer> createCodigoEquipamento(Integer value) {
        return new JAXBElement<Integer>(_CodigoEquipamento_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "programacao.ws.oee.tc.feevale.br", name = "erros")
    public JAXBElement<String> createErros(String value) {
        return new JAXBElement<String>(_Erros_QNAME, String.class, null, value);
    }

}
