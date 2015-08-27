
package br.feevale.tc.oee.ws.motivoparada;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.feevale.tc.oee.ws.motivoparada package. 
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

    private final static QName _Situacao_QNAME = new QName("motivoParada.ws.oee.tc.feevale.br", "situacao");
    private final static QName _Descricao_QNAME = new QName("motivoParada.ws.oee.tc.feevale.br", "descricao");
    private final static QName _Codigo_QNAME = new QName("motivoParada.ws.oee.tc.feevale.br", "codigo");
    private final static QName _TipoParada_QNAME = new QName("motivoParada.ws.oee.tc.feevale.br", "tipoParada");
    private final static QName _Erros_QNAME = new QName("motivoParada.ws.oee.tc.feevale.br", "erros");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.feevale.tc.oee.ws.motivoparada
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InserirOuAlterarMotivoParadaRequest }
     * 
     */
    public InserirOuAlterarMotivoParadaRequest createInserirOuAlterarMotivoParadaRequest() {
        return new InserirOuAlterarMotivoParadaRequest();
    }

    /**
     * Create an instance of {@link InserirOuAlterarMotivoParadaResponse }
     * 
     */
    public InserirOuAlterarMotivoParadaResponse createInserirOuAlterarMotivoParadaResponse() {
        return new InserirOuAlterarMotivoParadaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "motivoParada.ws.oee.tc.feevale.br", name = "situacao")
    public JAXBElement<String> createSituacao(String value) {
        return new JAXBElement<String>(_Situacao_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "motivoParada.ws.oee.tc.feevale.br", name = "descricao")
    public JAXBElement<String> createDescricao(String value) {
        return new JAXBElement<String>(_Descricao_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "motivoParada.ws.oee.tc.feevale.br", name = "codigo")
    public JAXBElement<Integer> createCodigo(Integer value) {
        return new JAXBElement<Integer>(_Codigo_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "motivoParada.ws.oee.tc.feevale.br", name = "tipoParada")
    public JAXBElement<String> createTipoParada(String value) {
        return new JAXBElement<String>(_TipoParada_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "motivoParada.ws.oee.tc.feevale.br", name = "erros")
    public JAXBElement<String> createErros(String value) {
        return new JAXBElement<String>(_Erros_QNAME, String.class, null, value);
    }

}
