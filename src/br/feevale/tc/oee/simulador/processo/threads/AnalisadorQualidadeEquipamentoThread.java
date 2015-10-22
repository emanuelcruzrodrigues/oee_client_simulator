package br.feevale.tc.oee.simulador.processo.threads;

import java.util.Random;

import br.feevale.tc.oee.simulador.model.Equipamento;
import br.feevale.tc.oee.simulador.model.OrdemProducao;
import br.feevale.tc.oee.simulador.model.Simulacao;
import br.feevale.tc.oee.simulador.utils.ThreadUtils;

public class AnalisadorQualidadeEquipamentoThread extends Thread {

	private final Equipamento equipamento;

	public AnalisadorQualidadeEquipamentoThread(Equipamento equipamento) {
		super();
		this.equipamento = equipamento;
	}
	
	@Override
	public void run() {
		try {
			while(true){
				Thread.sleep(ThreadUtils.aplicarConversaoIntervalo(5));
				if (!equipamento.isLigado()) return;
				for (OrdemProducao ordemProducao : equipamento.getOrdensProducao()) {
					Simulacao simulacao = Simulacao.getInstance();
					Integer quantidadeProduzida = simulacao.zerarQuantidadeProduzida(ordemProducao);
					if (quantidadeProduzida.equals(0)) continue;
					
					Double percentualRefugo = new Random().nextDouble() * equipamento.getDTO().getPercentualMaximoRefugo();
					
					Integer refugo = new Double(percentualRefugo * quantidadeProduzida).intValue();
					
					simulacao.getApontamentoWS().inserirApontamentoQuantidade(ordemProducao.getId(), quantidadeProduzida);
					if (refugo > 0){
						simulacao.getApontamentoWS().inserirApontamentoQuantidadeRefugo(ordemProducao.getId(), refugo);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
