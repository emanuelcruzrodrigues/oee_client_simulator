package br.feevale.tc.oee.simulador.processo.threads;

import br.feevale.tc.oee.simulador.model.Equipamento;
import br.feevale.tc.oee.simulador.utils.ThreadUtils;



public class EquipamentoParadaPorSetupThread extends SimulacaoThread {

	private final Equipamento equipamento;

	public EquipamentoParadaPorSetupThread(Equipamento equipamento) {
		super();
		this.equipamento = equipamento;
	};

	@Override
	public void run() {
		try {

			int minimo = equipamento.getDTO().getDuracaoMinimaParadaSetup();
			int maximo = equipamento.getDTO().getDuracaoMaximaParadaSetup();
			int intervalo = ThreadUtils.getIntervalo(minimo, maximo);
			Thread.sleep(intervalo);
			
			if (isDead()) return;
			
			equipamento.iniciarProducao();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
