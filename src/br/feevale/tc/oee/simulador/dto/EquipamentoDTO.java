package br.feevale.tc.oee.simulador.dto;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDTO {
	
	private int id;
	private String nome;
	
	private int saldoInicialMateriaPrima;
	
	private int intervaloMinimoEntreParadasNoProcesso;
	private int intervaloMaximoEntreParadasNoProcesso;
	private int duracaoMinimaParadasNoProcesso;
	private int duracaoMaximaParadasNoProcesso;
	
	private int idMotivoParadaSetupOrdemProducao;
	private int duracaoMinimaParadaSetup;
	private int duracaoMaximaParadaSetup;
	
	private int idMotivoParadaQualidade;
	private int unidadesPorParadaQualidade;
	private int duracaoMinimaParadaQualidade;
	private int duracaoMaximaParadaQualidade;
	
	private int idMotivoParadaFaltaMateriaPrima;
	private int bufferInicioProducaoAposFaltaDeMateriaPrima;
	
	private double percentualMaximoRefugo;
	private int intervaloSincronizacaoQuantidade;
	
	private List<OrdemProducaoDTO> ordensProducao = new ArrayList<OrdemProducaoDTO>();
	
	private List<ProgramacaoProducaoEquipamentoDTO> programacoesProducao = new ArrayList<ProgramacaoProducaoEquipamentoDTO>();
	
	public EquipamentoDTO(int id, String nome) {
		this();
		this.id = id;
		this.nome = nome;
	}

	public EquipamentoDTO() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getSaldoInicialMateriaPrima() {
		return saldoInicialMateriaPrima;
	}
	public void setSaldoInicialMateriaPrima(int saldoInicialMateriaPrima) {
		this.saldoInicialMateriaPrima = saldoInicialMateriaPrima;
	}

	public int getIntervaloMinimoEntreParadasNoProcesso() {
		return intervaloMinimoEntreParadasNoProcesso;
	}
	public void setIntervaloMinimoEntreParadasNoProcesso(int intervaloMinimoEntreParadasNoProcesso) {
		this.intervaloMinimoEntreParadasNoProcesso = intervaloMinimoEntreParadasNoProcesso;
	}

	public int getIntervaloMaximoEntreParadasNoProcesso() {
		return intervaloMaximoEntreParadasNoProcesso;
	}
	public void setIntervaloMaximoEntreParadasNoProcesso(int intervaloMaximoEntreParadasNoProcesso) {
		this.intervaloMaximoEntreParadasNoProcesso = intervaloMaximoEntreParadasNoProcesso;
	}

	public int getDuracaoMinimaParadasNoProcesso() {
		return duracaoMinimaParadasNoProcesso;
	}
	public void setDuracaoMinimaParadasNoProcesso(int duracaoMinimaParadasNoProcesso) {
		this.duracaoMinimaParadasNoProcesso = duracaoMinimaParadasNoProcesso;
	}

	public int getDuracaoMaximaParadasNoProcesso() {
		return duracaoMaximaParadasNoProcesso;
	}
	public void setDuracaoMaximaParadasNoProcesso(int duracaoMaximaParadasNoProcesso) {
		this.duracaoMaximaParadasNoProcesso = duracaoMaximaParadasNoProcesso;
	}

	public int getIdMotivoParadaSetupOrdemProducao() {
		return idMotivoParadaSetupOrdemProducao;
	}
	public void setIdMotivoParadaSetupOrdemProducao(int idMotivoParadaSetupOrdemProducao) {
		this.idMotivoParadaSetupOrdemProducao = idMotivoParadaSetupOrdemProducao;
	}

	public int getDuracaoMinimaParadaSetup() {
		return duracaoMinimaParadaSetup;
	}
	public void setDuracaoMinimaParadaSetup(int duracaoMinimaParadaSetup) {
		this.duracaoMinimaParadaSetup = duracaoMinimaParadaSetup;
	}

	public int getDuracaoMaximaParadaSetup() {
		return duracaoMaximaParadaSetup;
	}
	public void setDuracaoMaximaParadaSetup(int duracaoMaximaParadaSetup) {
		this.duracaoMaximaParadaSetup = duracaoMaximaParadaSetup;
	}

	public int getUnidadesPorParadaQualidade() {
		return unidadesPorParadaQualidade;
	}
	public void setUnidadesPorParadaQualidade(int unidadesPorParadaQualidade) {
		this.unidadesPorParadaQualidade = unidadesPorParadaQualidade;
	}

	public int getIdMotivoParadaQualidade() {
		return idMotivoParadaQualidade;
	}
	public void setIdMotivoParadaQualidade(int idMotivoParadaQualidade) {
		this.idMotivoParadaQualidade = idMotivoParadaQualidade;
	}

	public int getDuracaoMinimaParadaQualidade() {
		return duracaoMinimaParadaQualidade;
	}
	public void setDuracaoMinimaParadaQualidade(int duracaoMinimaParadaQualidade) {
		this.duracaoMinimaParadaQualidade = duracaoMinimaParadaQualidade;
	}

	public int getDuracaoMaximaParadaQualidade() {
		return duracaoMaximaParadaQualidade;
	}
	public void setDuracaoMaximaParadaQualidade(int duracaoMaximaParadaQualidade) {
		this.duracaoMaximaParadaQualidade = duracaoMaximaParadaQualidade;
	}
	
	public int getIdMotivoParadaFaltaMateriaPrima() {
		return idMotivoParadaFaltaMateriaPrima;
	}
	public void setIdMotivoParadaFaltaMateriaPrima(int idMotivoParadaFaltaMateriaPrima) {
		this.idMotivoParadaFaltaMateriaPrima = idMotivoParadaFaltaMateriaPrima;
	}
	
	public int getBufferInicioProducaoAposFaltaDeMateriaPrima() {
		return bufferInicioProducaoAposFaltaDeMateriaPrima;
	}
	public void setBufferInicioProducaoAposFaltaDeMateriaPrima(int bufferInicioProducaoAposFaltaDeMateriaPrima) {
		this.bufferInicioProducaoAposFaltaDeMateriaPrima = bufferInicioProducaoAposFaltaDeMateriaPrima;
	}

	public double getPercentualMaximoRefugo() {
		return percentualMaximoRefugo;
	}
	public void setPercentualMaximoRefugo(double percentualMaximoRefugo) {
		this.percentualMaximoRefugo = percentualMaximoRefugo;
	}
	
	public int getIntervaloSincronizacaoQuantidade() {
		return intervaloSincronizacaoQuantidade;
	}
	public void setIntervaloSincronizacaoQuantidade(int intervaloSincronizacaoQuantidade) {
		this.intervaloSincronizacaoQuantidade = intervaloSincronizacaoQuantidade;
	}

	public List<ProgramacaoProducaoEquipamentoDTO> getProgramacoesProducao() {
		return programacoesProducao;
	}
	public void setProgramacoesProducao(List<ProgramacaoProducaoEquipamentoDTO> programacoesProducao) {
		this.programacoesProducao = programacoesProducao;
	}
	public void addProgramacaoProducao(ProgramacaoProducaoEquipamentoDTO programacao){
		getProgramacoesProducao().add(programacao);
	}
	
	public List<OrdemProducaoDTO> getOrdensProducao() {
		return ordensProducao;
	}
	public void setOrdensProducao(List<OrdemProducaoDTO> ordensProducao) {
		this.ordensProducao = ordensProducao;
	}
	public void addOrdemProducao(OrdemProducaoDTO ordemProducao){
		getOrdensProducao().add(ordemProducao);
	}

}
