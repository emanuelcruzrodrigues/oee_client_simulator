


import java.io.FileNotFoundException;
import java.io.PrintWriter;

import br.feevale.tc.oee.simulador.dto.EncadeamentoProcessoDTO;
import br.feevale.tc.oee.simulador.dto.MotivoParadaDTO;
import br.feevale.tc.oee.simulador.dto.SimulacaoDTO;
import br.feevale.tc.oee.simulador.utils.XMLUtils;

import com.thoughtworks.xstream.XStream;

public class GeradorPropriedadesSimulacao {
	
	public static void main(String[] args) throws FileNotFoundException {
		XStream xStream = XMLUtils.getXStream();
		
		SimulacaoDTO simulacao = new SimulacaoDTO();
		
		simulacao.setOEEServerURL("http://10.1.1.32:18080/oee/ws/");
		
		simulacao.addXmlEquipamento("D:\\equipamento_1.xml");
		simulacao.addXmlEquipamento("D:\\equipamento_2.xml");
		simulacao.addXmlEquipamento("D:\\equipamento_3.xml");
		
		simulacao.setIdsMotivosParadaNoProcesso(new int[]{1001,1002,1003});
		
		//paradas planejadas
		simulacao.addMotivoParada(new MotivoParadaDTO(1, "Setup do equipamento", "STO"));
		simulacao.addMotivoParada(new MotivoParadaDTO(2, "Parada para realizacao de testes padrao", "STO"));
		//paradas nao planejadas
		simulacao.addMotivoParada(new MotivoParadaDTO(3, "Parada por falta de MP", "STI"));
		simulacao.addMotivoParada(new MotivoParadaDTO(1001, "Parada por falha no equipamento", "DTT"));
		simulacao.addMotivoParada(new MotivoParadaDTO(1002, "Parada por falha do operador", "DTO"));
		simulacao.addMotivoParada(new MotivoParadaDTO(1003, "Parada por qualidade fora das especificacoes", "DTQ"));
		
		simulacao.addEncadeamentoProcesso(new EncadeamentoProcessoDTO(123, 37));
		simulacao.addEncadeamentoProcesso(new EncadeamentoProcessoDTO(37, 28));
		
		String xml = xStream.toXML(simulacao);
		try(PrintWriter writer = new PrintWriter("D:\\simulacao.xml")){
			writer.print(xml);
			writer.flush();
		}
	}

}
