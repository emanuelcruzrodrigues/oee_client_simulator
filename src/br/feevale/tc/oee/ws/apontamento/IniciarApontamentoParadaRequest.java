
package br.feevale.tc.oee.ws.apontamento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{apontamento.ws.oee.tc.feevale.br}codigoEquipamento"/>
 *         &lt;element ref="{apontamento.ws.oee.tc.feevale.br}codigoMotivoParada"/>
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
    "codigoMotivoParada"
})
@XmlRootElement(name = "iniciarApontamentoParadaRequest")
public class IniciarApontamentoParadaRequest {

    protected int codigoEquipamento;
    protected int codigoMotivoParada;

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
     * Obtém o valor da propriedade codigoMotivoParada.
     * 
     */
    public int getCodigoMotivoParada() {
        return codigoMotivoParada;
    }

    /**
     * Define o valor da propriedade codigoMotivoParada.
     * 
     */
    public void setCodigoMotivoParada(int value) {
        this.codigoMotivoParada = value;
    }

}
