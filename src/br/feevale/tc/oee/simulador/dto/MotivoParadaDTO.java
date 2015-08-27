package br.feevale.tc.oee.simulador.dto;

public class MotivoParadaDTO {
	
	private int id;
	private String descricao;
	private String tipoParada;

	public MotivoParadaDTO(int id, String descricao, String tipoParada) {
		this();
		this.id = id;
		this.descricao = descricao;
		this.tipoParada = tipoParada;
	}
	
	public MotivoParadaDTO() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getTipoParada() {
		return tipoParada;
	}
	public void setTipoParada(String tipoParada) {
		this.tipoParada = tipoParada;
	}

	
}
