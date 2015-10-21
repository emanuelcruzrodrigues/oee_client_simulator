
package br.feevale.tc.oee.ws.ordemproducao;

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
 *         &lt;element ref="{ordemProducao.ws.oee.tc.feevale.br}codigo"/>
 *         &lt;element ref="{ordemProducao.ws.oee.tc.feevale.br}descricao"/>
 *         &lt;element ref="{ordemProducao.ws.oee.tc.feevale.br}codigoEquipamento"/>
 *         &lt;element ref="{ordemProducao.ws.oee.tc.feevale.br}unidadesPorMinuto"/>
 *         &lt;element ref="{ordemProducao.ws.oee.tc.feevale.br}situacao"/>
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
    "codigoEquipamento",
    "unidadesPorMinuto",
    "situacao"
})
@XmlRootElement(name = "inserirOuAlterarOrdemProducaoRequest")
public class InserirOuAlterarOrdemProducaoRequest {

    protected int codigo;
    @XmlElement(required = true)
    protected String descricao;
    protected int codigoEquipamento;
    protected double unidadesPorMinuto;
    @XmlElement(required = true)
    protected String situacao;

    /**
     * Obtém o valor da propriedade codigo.
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
     * Obtém o valor da propriedade descricao.
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
     * Obtém o valor da propriedade codigoEquipamento.
     * 
     */
    public int getCodigoEquipamento() {
        return codigoEquipamento;
    }

    /**
     * Define o valor da propriedade codigoEquipamento.
     * 
     */
    public void setCodigoEquipamento(int value) {
        this.codigoEquipamento = value;
    }

    /**
     * Obtém o valor da propriedade unidadesPorMinuto.
     * 
     */
    public double getUnidadesPorMinuto() {
        return unidadesPorMinuto;
    }

    /**
     * Define o valor da propriedade unidadesPorMinuto.
     * 
     */
    public void setUnidadesPorMinuto(double value) {
        this.unidadesPorMinuto = value;
    }

    /**
     * Obtém o valor da propriedade situacao.
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
