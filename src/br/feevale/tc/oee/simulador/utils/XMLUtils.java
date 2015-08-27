package br.feevale.tc.oee.simulador.utils;
import br.feevale.tc.oee.simulador.dto.DataHoraDTO;
import br.feevale.tc.oee.simulador.dto.EncadeamentoProcessoDTO;
import br.feevale.tc.oee.simulador.dto.EquipamentoDTO;
import br.feevale.tc.oee.simulador.dto.MotivoParadaDTO;
import br.feevale.tc.oee.simulador.dto.OrdemProducaoDTO;
import br.feevale.tc.oee.simulador.dto.ProgramacaoProducaoEquipamentoDTO;
import br.feevale.tc.oee.simulador.dto.SimulacaoDTO;

import com.thoughtworks.xstream.XStream;


public class XMLUtils {
	
	public static XStream getXStream(){
		XStream xStream = new XStream();
		xStream.alias("DataHora", DataHoraDTO.class);
		xStream.alias("EncadeamentoProcesso", EncadeamentoProcessoDTO.class);
		xStream.alias("Equipamento", EquipamentoDTO.class);
		xStream.alias("MotivoParada", MotivoParadaDTO.class);
		xStream.alias("OrdemProducao", OrdemProducaoDTO.class);
		xStream.alias("ProgramacaoProducaoEquipamento", ProgramacaoProducaoEquipamentoDTO.class);
		xStream.alias("Simulacao", SimulacaoDTO.class);
		return xStream;
	}

}
