
package br.feevale.tc.oee.ws.programacao;

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
 *         &lt;element ref="{programacao.ws.oee.tc.feevale.br}erros"/>
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
    "erros"
})
@XmlRootElement(name = "excluirProgramacaoProducaoEquipamentoResponse")
public class ExcluirProgramacaoProducaoEquipamentoResponse {

    @XmlElement(required = true)
    protected String erros;

    /**
     * Obtem o valor da propriedade erros.
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
