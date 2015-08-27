package br.feevale.tc.oee.simulador.model;

import br.feevale.tc.oee.simulador.dto.OrdemProducaoDTO;

public class OrdemProducao {
	
	private final Integer id;
	private final OrdemProducaoDTO dto;
	private Integer saldoProduzir;
	
	public OrdemProducao(OrdemProducaoDTO dto) {
		this(dto.getId(), dto, dto.getVolumeTotal());
	}
	
	private OrdemProducao(Integer id, OrdemProducaoDTO dto, Integer saldoProduzir) {
		super();
		this.id = id;
		this.dto = dto;
		this.saldoProduzir = saldoProduzir;
	}

	public Integer getId() {
		return id;
	}
	
	public OrdemProducaoDTO getDTO() {
		return dto;
	}

	public Integer getSaldoProduzir() {
		return saldoProduzir;
	}
	public void setSaldoProduzir(Integer saldoProduzir) {
		this.saldoProduzir = saldoProduzir;
	}
	
	public void removeQuantidade(Integer quantidadeProduzida) {
		setSaldoProduzir(getSaldoProduzir() - quantidadeProduzida);
	}


}
