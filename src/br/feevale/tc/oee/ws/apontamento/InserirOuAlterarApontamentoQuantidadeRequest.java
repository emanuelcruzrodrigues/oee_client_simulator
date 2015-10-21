
package br.feevale.tc.oee.ws.apontamento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{apontamento.ws.oee.tc.feevale.br}codigo"/>
 *         &lt;element ref="{apontamento.ws.oee.tc.feevale.br}codigoOrdemProducao"/>
 *         &lt;element ref="{apontamento.ws.oee.tc.feevale.br}dataHora"/>
 *         &lt;element ref="{apontamento.ws.oee.tc.feevale.br}quantidade"/>
 *         &lt;element ref="{apontamento.ws.oee.tc.feevale.br}qualidadeProducao"/>
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
    "codigoOrdemProducao",
    "dataHora",
    "quantidade",
    "qualidadeProducao"
})
@XmlRootElement(name = "inserirOuAlterarApontamentoQuantidadeRequest")
public class InserirOuAlterarApontamentoQuantidadeRequest {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codigo;
    protected int codigoOrdemProducao;
    @XmlElement(required = true)
    protected DataHora dataHora;
    protected double quantidade;
    @XmlElement(required = true)
    protected String qualidadeProducao;

    /**
     * Obtém o valor da propriedade codigo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * Define o valor da propriedade codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodigo(Integer value) {
        this.codigo = value;
    }

    /**
     * Obtém o valor da propriedade codigoOrdemProducao.
     * 
     */
    public int getCodigoOrdemProducao() {
        return codigoOrdemProducao;
    }

    /**
     * Define o valor da propriedade codigoOrdemProducao.
     * 
     */
    public void setCodigoOrdemProducao(int value) {
        this.codigoOrdemProducao = value;
    }

    /**
     * Obtém o valor da propriedade dataHora.
     * 
     * @return
     *     possible object is
     *     {@link DataHora }
     *     
     */
    public DataHora getDataHora() {
        return dataHora;
    }

    /**
     * Define o valor da propriedade dataHora.
     * 
     * @param value
     *     allowed object is
     *     {@link DataHora }
     *     
     */
    public void setDataHora(DataHora value) {
        this.dataHora = value;
    }

    /**
     * Obtém o valor da propriedade quantidade.
     * 
     */
    public double getQuantidade() {
        return quantidade;
    }

    /**
     * Define o valor da propriedade quantidade.
     * 
     */
    public void setQuantidade(double value) {
        this.quantidade = value;
    }

    /**
     * Obtém o valor da propriedade qualidadeProducao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQualidadeProducao() {
        return qualidadeProducao;
    }

    /**
     * Define o valor da propriedade qualidadeProducao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQualidadeProducao(String value) {
        this.qualidadeProducao = value;
    }

}
