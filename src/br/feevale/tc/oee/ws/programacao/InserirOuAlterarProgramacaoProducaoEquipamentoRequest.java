
package br.feevale.tc.oee.ws.programacao;

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
 *         &lt;element ref="{programacao.ws.oee.tc.feevale.br}codigo"/>
 *         &lt;element ref="{programacao.ws.oee.tc.feevale.br}codigoEquipamento"/>
 *         &lt;element ref="{programacao.ws.oee.tc.feevale.br}dataHoraInicial"/>
 *         &lt;element ref="{programacao.ws.oee.tc.feevale.br}dataHoraFinal"/>
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
    "codigoEquipamento",
    "dataHoraInicial",
    "dataHoraFinal"
})
@XmlRootElement(name = "inserirOuAlterarProgramacaoProducaoEquipamentoRequest")
public class InserirOuAlterarProgramacaoProducaoEquipamentoRequest {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codigo;
    protected int codigoEquipamento;
    @XmlElement(required = true)
    protected DataHoraInicial dataHoraInicial;
    @XmlElement(required = true)
    protected DataHoraFinal dataHoraFinal;

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
     * Obtém o valor da propriedade dataHoraInicial.
     * 
     * @return
     *     possible object is
     *     {@link DataHoraInicial }
     *     
     */
    public DataHoraInicial getDataHoraInicial() {
        return dataHoraInicial;
    }

    /**
     * Define o valor da propriedade dataHoraInicial.
     * 
     * @param value
     *     allowed object is
     *     {@link DataHoraInicial }
     *     
     */
    public void setDataHoraInicial(DataHoraInicial value) {
        this.dataHoraInicial = value;
    }

    /**
     * Obtém o valor da propriedade dataHoraFinal.
     * 
     * @return
     *     possible object is
     *     {@link DataHoraFinal }
     *     
     */
    public DataHoraFinal getDataHoraFinal() {
        return dataHoraFinal;
    }

    /**
     * Define o valor da propriedade dataHoraFinal.
     * 
     * @param value
     *     allowed object is
     *     {@link DataHoraFinal }
     *     
     */
    public void setDataHoraFinal(DataHoraFinal value) {
        this.dataHoraFinal = value;
    }

}
