
package br.feevale.tc.oee.ws.motivoparada;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteudo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{motivoParada.ws.oee.tc.feevale.br}codigo"/>
 *         &lt;element ref="{motivoParada.ws.oee.tc.feevale.br}descricao"/>
 *         &lt;element ref="{motivoParada.ws.oee.tc.feevale.br}tipoParada"/>
 *         &lt;element ref="{motivoParada.ws.oee.tc.feevale.br}situacao"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codigo",
    "descricao",
    "tipoParada",
    "situacao"
})
@XmlRootElement(name = "inserirOuAlterarMotivoParadaRequest")
public class InserirOuAlterarMotivoParadaRequest {

    protected int codigo;
    @XmlElement(required = true)
    protected String descricao;
    @XmlElement(required = true)
    protected String tipoParada;
    @XmlElement(required = true)
    protected String situacao;

    /**
     * Obtem o valor da propriedade codigo.
     * 
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Define o valor da propriedade codigo.
     * 
     */
    public void setCodigo(int value) {
        this.codigo = value;
    }

    /**
     * Obtem o valor da propriedade descricao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define o valor da propriedade descricao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricao(String value) {
        this.descricao = value;
    }

    /**
     * Obtem o valor da propriedade tipoParada.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoParada() {
        return tipoParada;
    }

    /**
     * Define o valor da propriedade tipoParada.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoParada(String value) {
        this.tipoParada = value;
    }

    /**
     * Obtem o valor da propriedade situacao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * Define o valor da propriedade situacao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSituacao(String value) {
        this.situacao = value;
    }

}
