package br.feevale.tc.oee.simulador.dto;
import java.util.ArrayList;
import java.util.List;


public class SimulacaoDTO {
	
	private String oeeServerURL;
	private List<String> xmlEquipamentos = new ArrayList<String>();
	private int[] idsMotivosParadaNoProcesso;
	private List<MotivoParadaDTO> motivosParada = new ArrayList<MotivoParadaDTO>();
	private List<EncadeamentoProcessoDTO> encadeamentosProcessos = new ArrayList<EncadeamentoProcessoDTO>();
	
	public String getOEEServerURL() {
		return oeeServerURL;
	}
	public void setOEEServerURL(String oeeServerURL) {
		this.oeeServerURL = oeeServerURL;
	}
	
	public List<String> getXmlEquipamentos() {
		return xmlEquipamentos;
	}
	public void setXmlEquipamentos(List<String> xmlEquipamentos) {
		this.xmlEquipamentos = xmlEquipamentos;
	}
	public void addXmlEquipamento(String xml){
		xmlEquipamentos.add(xml);
	}
	
	public List<MotivoParadaDTO> getMotivosParada() {
		return motivosParada;
	}
	public void setMotivosParada(List<MotivoParadaDTO> motivosParada) {
		this.motivosParada = motivosParada;
	}
	public void addMotivoParada(MotivoParadaDTO motivo){
		getMotivosParada().add(motivo);
	}
	
	public int[] getIdsMotivosParadaNoProcesso() {
		return idsMotivosParadaNoProcesso;
	}
	public void setIdsMotivosParadaNoProcesso(int[] idsMotivosParadaNoProcesso) {
		this.idsMotivosParadaNoProcesso = idsMotivosParadaNoProcesso;
	}
	
	public List<EncadeamentoProcessoDTO> getEncadeamentosProcessos() {
		return encadeamentosProcessos;
	}
	public void setEncadeamentosProcessos(List<EncadeamentoProcessoDTO> encadeamentosProcessos) {
		this.encadeamentosProcessos = encadeamentosProcessos;
	}
	public void addEncadeamentoProcesso(EncadeamentoProcessoDTO encadeamento){
		getEncadeamentosProcessos().add(encadeamento);
	}

}
