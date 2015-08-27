package br.feevale.tc.oee.simulador.dto;

public class EncadeamentoProcessoDTO {
	
	private int idEquipamentoProdutor;
	private int idEquipamentoConsumidor;
	
	public EncadeamentoProcessoDTO(int idEquipamentoProdutor, int idEquipamentoConsumidor) {
		this();
		this.idEquipamentoProdutor = idEquipamentoProdutor;
		this.idEquipamentoConsumidor = idEquipamentoConsumidor;
	}
	
	public EncadeamentoProcessoDTO() {
		super();
	}

	public int getIdEquipamentoProdutor() {
		return idEquipamentoProdutor;
	}
	public void setIdEquipamentoProdutor(int idEquipamentoProdutor) {
		this.idEquipamentoProdutor = idEquipamentoProdutor;
	}
	
	public int getIdEquipamentoConsumidor() {
		return idEquipamentoConsumidor;
	}
	public void setIdEquipamentoConsumidor(int idEquipamentoConsumidor) {
		this.idEquipamentoConsumidor = idEquipamentoConsumidor;
	}
	
	

}
