package br.feevale.tc.oee.simulador.processo.threads;

import br.feevale.tc.oee.simulador.model.Equipamento;
import br.feevale.tc.oee.simulador.utils.ThreadUtils;


public class EquipamentoParadaPorQualidadeThread extends SimulacaoThread {
	
	private final Equipamento equipamento;

	public EquipamentoParadaPorQualidadeThread(Equipamento equipamento) {
		super();
		this.equipamento = equipamento;
	};

	@Override
	public void run() {
		try {

			int minimo = equipamento.getDTO().getDuracaoMinimaParadaQualidade();
			int maximo = equipamento.getDTO().getDuracaoMaximaParadaQualidade();
			int intervalo = ThreadUtils.getIntervalo(minimo, maximo);
			Thread.sleep(intervalo);
			
			if (isDead()) return;
			
			equipamento.iniciarProducao();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
