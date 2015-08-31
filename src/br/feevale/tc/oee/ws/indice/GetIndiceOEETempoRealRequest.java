
package br.feevale.tc.oee.ws.indice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o Conteudo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{indice.ws.oee.tc.feevale.br}codigoEquipamento"/>
 *         &lt;element ref="{indice.ws.oee.tc.feevale.br}periodoMinutos"/>
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
    "codigoEquipamento",
    "periodoMinutos"
})
@XmlRootElement(name = "getIndiceOEETempoRealRequest")
public class GetIndiceOEETempoRealRequest {

    protected int codigoEquipamento;
    protected int periodoMinutos;

    /**
     * Obtem o valor da propriedade codigoEquipamento.
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
     * Obtem o valor da propriedade periodoMinutos.
     * 
     */
    public int getPeriodoMinutos() {
        return periodoMinutos;
    }

    /**
     * Define o valor da propriedade periodoMinutos.
     * 
     */
    public void setPeriodoMinutos(int value) {
        this.periodoMinutos = value;
    }

}
