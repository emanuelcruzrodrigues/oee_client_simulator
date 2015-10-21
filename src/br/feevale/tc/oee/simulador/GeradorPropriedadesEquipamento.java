package br.feevale.tc.oee.simulador;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import br.feevale.tc.oee.simulador.dto.DataHoraDTO;
import br.feevale.tc.oee.simulador.dto.EquipamentoDTO;
import br.feevale.tc.oee.simulador.dto.OrdemProducaoDTO;
import br.feevale.tc.oee.simulador.dto.ProgramacaoProducaoEquipamentoDTO;
import br.feevale.tc.oee.simulador.utils.XMLUtils;

import com.thoughtworks.xstream.XStream;

public class GeradorPropriedadesEquipamento {
	
	public static void main(String[] args) throws FileNotFoundException {
		XStream xStream = XMLUtils.getXStream();
		gerarCorte(xStream);
		gerarPerfilamento(xStream);
		gerarInjecao(xStream);
		
	}

	private static void gerarCorte(XStream xStream) throws FileNotFoundException {
		EquipamentoDTO equipamento = new EquipamentoDTO(123, "GUILHOTINA 3000MM");
		equipamento.setSaldoInicialMateriaPrima(10_000);
		
		equipamento.setIntervaloMinimoEntreParadasNoProcesso(120);
		equipamento.setIntervaloMaximoEntreParadasNoProcesso(480);
		equipamento.setDuracaoMinimaParadasNoProcesso(10);
		equipamento.setDuracaoMaximaParadasNoProcesso(30);
		
		equipamento.setIdMotivoParadaSetupOrdemProducao(1);
		equipamento.setDuracaoMinimaParadaSetup(5);
		equipamento.setDuracaoMaximaParadaSetup(20);
		
		equipamento.setIdMotivoParadaQualidade(2);
		equipamento.setUnidadesPorParadaQualidade(100);
		equipamento.setDuracaoMinimaParadaQualidade(1);
		equipamento.setDuracaoMaximaParadaQualidade(5);
		
		equipamento.setIdMotivoParadaFaltaMateriaPrima(3);
		equipamento.setBufferInicioProducaoAposFaltaDeMateriaPrima(50);
		
		equipamento.setPercentualMaximoRefugo(0.1d);
		
		equipamento.addOrdemProducao(new OrdemProducaoDTO(101, "JIT 150820 - Corte", 3, 5, 1000));
		equipamento.addOrdemProducao(new OrdemProducaoDTO(102, "JIT 150822 - Corte", 2, 3, 500));
		equipamento.addOrdemProducao(new OrdemProducaoDTO(103, "JIT 150824 - Corte", 3, 4, 5000));
		
		equipamento.addProgramacaoProducao(new ProgramacaoProducaoEquipamentoDTO(1
																				, new DataHoraDTO(2015, 8, 27, 15, 45)
																			   	, new DataHoraDTO(2015, 8, 27, 17, 18)));
		
		String xml = xStream.toXML(equipamento);
		try(PrintWriter writer = new PrintWriter("D:\\equipamento_1.xml")){
			writer.print(xml);
			writer.flush();
		}
	}
	
	private static void gerarPerfilamento(XStream xStream) throws FileNotFoundException {
		EquipamentoDTO equipamento = new EquipamentoDTO(37, "PERFILADEIRA DE TELHAS");
		equipamento.setSaldoInicialMateriaPrima(0);
		
		equipamento.setIntervaloMinimoEntreParadasNoProcesso(120);
		equipamento.setIntervaloMaximoEntreParadasNoProcesso(480);
		equipamento.setDuracaoMinimaParadasNoProcesso(10);
		equipamento.setDuracaoMaximaParadasNoProcesso(30);
		
		equipamento.setIdMotivoParadaSetupOrdemProducao(1);
		equipamento.setDuracaoMinimaParadaSetup(5);
		equipamento.setDuracaoMaximaParadaSetup(20);
		
		equipamento.setIdMotivoParadaQualidade(2);
		equipamento.setUnidadesPorParadaQualidade(100);
		equipamento.setDuracaoMinimaParadaQualidade(1);
		equipamento.setDuracaoMaximaParadaQualidade(5);
		
		equipamento.setIdMotivoParadaFaltaMateriaPrima(3);
		equipamento.setBufferInicioProducaoAposFaltaDeMateriaPrima(20);
		
		equipamento.setPercentualMaximoRefugo(0.1d);
		
		equipamento.addOrdemProducao(new OrdemProducaoDTO(201, "JIT 150820 - Perfilamento", 3, 5, 1000));
		equipamento.addOrdemProducao(new OrdemProducaoDTO(202, "JIT 150822 - Perfilamento", 2, 3, 500));
		equipamento.addOrdemProducao(new OrdemProducaoDTO(203, "JIT 150824 - Perfilamento", 3, 5, 5000));
		
		equipamento.addProgramacaoProducao(new ProgramacaoProducaoEquipamentoDTO(1
																				, new DataHoraDTO(2015, 8, 27, 15, 50)
		   																		, new DataHoraDTO(2015, 8, 27, 17, 18)));
		
		String xml = xStream.toXML(equipamento);
		try(PrintWriter writer = new PrintWriter("D:\\equipamento_2.xml")){
			writer.print(xml);
			writer.flush();
		}
	}
	
	private static void gerarInjecao(XStream xStream) throws FileNotFoundException {
		EquipamentoDTO equipamento = new EquipamentoDTO(28, "INJETORA DE POLIURETANO CANNON");
		equipamento.setSaldoInicialMateriaPrima(0);
		
		equipamento.setIntervaloMinimoEntreParadasNoProcesso(120);
		equipamento.setIntervaloMaximoEntreParadasNoProcesso(480);
		equipamento.setDuracaoMinimaParadasNoProcesso(10);
		equipamento.setDuracaoMaximaParadasNoProcesso(30);
		
		equipamento.setIdMotivoParadaSetupOrdemProducao(1);
		equipamento.setDuracaoMinimaParadaSetup(10);
		equipamento.setDuracaoMaximaParadaSetup(30);
		
		equipamento.setIdMotivoParadaQualidade(2);
		equipamento.setUnidadesPorParadaQualidade(100);
		equipamento.setDuracaoMinimaParadaQualidade(1);
		equipamento.setDuracaoMaximaParadaQualidade(5);
		
		equipamento.setIdMotivoParadaFaltaMateriaPrima(3);
		equipamento.setBufferInicioProducaoAposFaltaDeMateriaPrima(5);
		
		equipamento.setPercentualMaximoRefugo(0.1d);
		
		equipamento.addOrdemProducao(new OrdemProducaoDTO(301, "JIT 150820 - Injecao", 2, 4, 500));
		equipamento.addOrdemProducao(new OrdemProducaoDTO(302, "JIT 150822 - Injecao", 2, 3, 250));
		equipamento.addOrdemProducao(new OrdemProducaoDTO(303, "JIT 150824 - Injecao", 2, 3, 2500));
		equipamento.addOrdemProducao(new OrdemProducaoDTO(304, "JIT 150825 - Injecao", 2, 3, 2500));
		
		equipamento.addProgramacaoProducao(new ProgramacaoProducaoEquipamentoDTO(1
																					, new DataHoraDTO(2015, 8, 27, 16, 00)
																					, new DataHoraDTO(2015, 8, 27, 17, 18)));
		
		String xml = xStream.toXML(equipamento);
		try(PrintWriter writer = new PrintWriter("D:\\equipamento_3.xml")){
			writer.print(xml);
			writer.flush();
		}
	}

}
