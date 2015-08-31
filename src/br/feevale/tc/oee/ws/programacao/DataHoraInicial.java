
package br.feevale.tc.oee.ws.programacao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute name="ano" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="mes" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="dia" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="hora" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="minuto" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "dataHoraInicial")
public class DataHoraInicial {

    @XmlAttribute(name = "ano", required = true)
    protected int ano;
    @XmlAttribute(name = "mes", required = true)
    protected int mes;
    @XmlAttribute(name = "dia", required = true)
    protected int dia;
    @XmlAttribute(name = "hora", required = true)
    protected int hora;
    @XmlAttribute(name = "minuto", required = true)
    protected int minuto;

    /**
     * Obtem o valor da propriedade ano.
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
     * Obtem o valor da propriedade mes.
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
     * Obtem o valor da propriedade dia.
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

    /**
     * Obtem o valor da propriedade hora.
     * 
     */
    public int getHora() {
        return hora;
    }

    /**
     * Define o valor da propriedade hora.
     * 
     */
    public void setHora(int value) {
        this.hora = value;
    }

    /**
     * Obtem o valor da propriedade minuto.
     * 
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * Define o valor da propriedade minuto.
     * 
     */
    public void setMinuto(int value) {
        this.minuto = value;
    }

}
