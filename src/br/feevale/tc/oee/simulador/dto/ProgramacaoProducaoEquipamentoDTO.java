package br.feevale.tc.oee.simulador.dto;


public class ProgramacaoProducaoEquipamentoDTO {
	
	private int id;
	private DataHoraDTO dtHrInicio;
	private DataHoraDTO dtHrFim;
	
	public ProgramacaoProducaoEquipamentoDTO(int id, DataHoraDTO dtHrInicio, DataHoraDTO dtHrFim) {
		this();
		this.id = id;
		this.dtHrInicio = dtHrInicio;
		this.dtHrFim = dtHrFim;
	}
	
	public ProgramacaoProducaoEquipamentoDTO() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public DataHoraDTO getDtHrInicio() {
		return dtHrInicio;
	}
	public void setDtHrInicio(DataHoraDTO dtHrInicio) {
		this.dtHrInicio = dtHrInicio;
	}
	
	public DataHoraDTO getDtHrFim() {
		return dtHrFim;
	}
	public void setDtHrFim(DataHoraDTO dtHrFim) {
		this.dtHrFim = dtHrFim;
	}

}
