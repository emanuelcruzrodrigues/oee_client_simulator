
package br.feevale.tc.oee.ws.programacao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="ano" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="mes" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="dia" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "data")
public class Data {

    @XmlAttribute(name = "ano", required = true)
    protected int ano;
    @XmlAttribute(name = "mes", required = true)
    protected int mes;
    @XmlAttribute(name = "dia", required = true)
    protected int dia;

    /**
     * Obt�m o valor da propriedade ano.
     * 
     */
    public int getAno() {
        return ano;
    }

    /**
     * Define o valor da propriedade ano.
     * 
     */
    public void setAno(int value) {
        this.ano = value;
    }

    /**
     * Obt�m o valor da propriedade mes.
     * 
     */
    public int getMes() {
        return mes;
    }

    /**
     * Define o valor da propriedade mes.
     * 
     */
    public void setMes(int value) {
        this.mes = value;
    }

    /**
     * Obt�m o valor da propriedade dia.
     * 
     */
    public int getDia() {
        return dia;
    }

    /**
     * Define o valor da propriedade dia.
     * 
     */
    public void setDia(int value) {
        this.dia = value;
    }

}