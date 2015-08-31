
package br.feevale.tc.oee.ws.apontamento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{apontamento.ws.oee.tc.feevale.br}codigoEquipamento"/>
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
    "codigoEquipamento"
})
@XmlRootElement(name = "encerrarApontamentoEquipamentoRequest")
public class EncerrarApontamentoEquipamentoRequest {

    protected int codigoEquipamento;

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

}
