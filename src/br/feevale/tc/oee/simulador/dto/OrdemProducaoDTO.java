package br.feevale.tc.oee.simulador.dto;

public class OrdemProducaoDTO {
	
	private int id;
	private String descricao;
	private int unidadesPorMinutoMinimo;
	private int unidadesPorMinutoMaximo;
	private int volumeTotal;
	
	public OrdemProducaoDTO(int id, String descricao, int unidadesPorMinutoMinimo, int unidadesPorMinutoMaximo, int volumeTotal) {
		this();
		this.id = id;
		this.descricao = descricao;
		this.unidadesPorMinutoMinimo = unidadesPorMinutoMinimo;
		this.unidadesPorMinutoMaximo = unidadesPorMinutoMaximo;
		this.volumeTotal = volumeTotal;
	}
	
	public OrdemProducaoDTO() {
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
	
	public int getUnidadesPorMinutoMinimo() {
		return unidadesPorMinutoMinimo;
	}
	public void setUnidadesPorMinutoMinimo(int unidadesPorMinutoMinimo) {
		this.unidadesPorMinutoMinimo = unidadesPorMinutoMinimo;
	}

	public int getUnidadesPorMinutoMaximo() {
		return unidadesPorMinutoMaximo;
	}
	public void setUnidadesPorMinutoMaximo(int unidadesPorMinutoMaximo) {
		this.unidadesPorMinutoMaximo = unidadesPorMinutoMaximo;
	}

	public int getVolumeTotal() {
		return volumeTotal;
	}
	public void setVolumeTotal(int volumeTotal) {
		this.volumeTotal = volumeTotal;
	}
	
	

}
