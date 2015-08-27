package br.feevale.tc.oee.simulador.dto;


public class ProgramacaoProducaoEquipamentoDTO {
	
	private DataHoraDTO dtHrInicio;
	private DataHoraDTO dtHrFim;
	
	public ProgramacaoProducaoEquipamentoDTO(DataHoraDTO dtHrInicio, DataHoraDTO dtHrFim) {
		this();
		this.dtHrInicio = dtHrInicio;
		this.dtHrFim = dtHrFim;
	}
	
	public ProgramacaoProducaoEquipamentoDTO() {
		super();
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
