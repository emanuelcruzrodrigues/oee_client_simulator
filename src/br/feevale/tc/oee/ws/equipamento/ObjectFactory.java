
package br.feevale.tc.oee.ws.equipamento;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.feevale.tc.oee.ws.equipamento package. 
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

    private final static QName _Codigo_QNAME = new QName("equipamento.ws.oee.tc.feevale.br", "codigo");
    private final static QName _Erros_QNAME = new QName("equipamento.ws.oee.tc.feevale.br", "erros");
    private final static QName _Situacao_QNAME = new QName("equipamento.ws.oee.tc.feevale.br", "situacao");
    private final static QName _Nome_QNAME = new QName("equipamento.ws.oee.tc.feevale.br", "nome");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.feevale.tc.oee.ws.equipamento
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InserirOuAlterarEquipamentoRequest }
     * 
     */
    public InserirOuAlterarEquipamentoRequest createInserirOuAlterarEquipamentoRequest() {
        return new InserirOuAlterarEquipamentoRequest();
    }

    /**
     * Create an instance of {@link InserirOuAlterarEquipamentoResponse }
     * 
     */
    public InserirOuAlterarEquipamentoResponse createInserirOuAlterarEquipamentoResponse() {
        return new InserirOuAlterarEquipamentoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "equipamento.ws.oee.tc.feevale.br", name = "codigo")
    public JAXBElement<Integer> createCodigo(Integer value) {
        return new JAXBElement<Integer>(_Codigo_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "equipamento.ws.oee.tc.feevale.br", name = "erros")
    public JAXBElement<String> createErros(String value) {
        return new JAXBElement<String>(_Erros_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "equipamento.ws.oee.tc.feevale.br", name = "situacao")
    public JAXBElement<String> createSituacao(String value) {
        return new JAXBElement<String>(_Situacao_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "equipamento.ws.oee.tc.feevale.br", name = "nome")
    public JAXBElement<String> createNome(String value) {
        return new JAXBElement<String>(_Nome_QNAME, String.class, null, value);
    }

}
