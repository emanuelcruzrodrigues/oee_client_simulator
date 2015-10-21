
package br.feevale.tc.oee.ws.indice;

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
 *         &lt;element ref="{indice.ws.oee.tc.feevale.br}disponibilidade"/>
 *         &lt;element ref="{indice.ws.oee.tc.feevale.br}desempenho"/>
 *         &lt;element ref="{indice.ws.oee.tc.feevale.br}qualidade"/>
 *         &lt;element ref="{indice.ws.oee.tc.feevale.br}oee"/>
 *         &lt;element ref="{indice.ws.oee.tc.feevale.br}erros"/>
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
    "disponibilidade",
    "desempenho",
    "qualidade",
    "oee",
    "erros"
})
@XmlRootElement(name = "getIndiceOEETempoRealResponse")
public class GetIndiceOEETempoRealResponse {

    protected double disponibilidade;
    protected double desempenho;
    protected double qualidade;
    protected double oee;
    @XmlElement(required = true)
    protected String erros;

    /**
     * Obtém o valor da propriedade disponibilidade.
     * 
     */
    public double getDisponibilidade() {
        return disponibilidade;
    }

    /**
     * Define o valor da propriedade disponibilidade.
     * 
     */
    public void setDisponibilidade(double value) {
        this.disponibilidade = value;
    }

    /**
     * Obtém o valor da propriedade desempenho.
     * 
     */
    public double getDesempenho() {
        return desempenho;
    }

    /**
     * Define o valor da propriedade desempenho.
     * 
     */
    public void setDesempenho(double value) {
        this.desempenho = value;
    }

    /**
     * Obtém o valor da propriedade qualidade.
     * 
     */
    public double getQualidade() {
        return qualidade;
    }

    /**
     * Define o valor da propriedade qualidade.
     * 
     */
    public void setQualidade(double value) {
        this.qualidade = value;
    }

    /**
     * Obtém o valor da propriedade oee.
     * 
     */
    public double getOee() {
        return oee;
    }

    /**
     * Define o valor da propriedade oee.
     * 
     */
    public void setOee(double value) {
        this.oee = value;
    }

    /**
     * Obtém o valor da propriedade erros.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErros() {
        return erros;
    }

    /**
     * Define o valor da propriedade erros.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErros(String value) {
        this.erros = value;
    }

}
