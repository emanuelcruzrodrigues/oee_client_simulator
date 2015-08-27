package br.feevale.tc.oee.simulador.processo.threads;

import br.feevale.tc.oee.simulador.model.Equipamento;
import br.feevale.tc.oee.simulador.utils.ThreadUtils;



public class EquipamentoParadaEmProcessoThread extends SimulacaoThread{

	private final Equipamento equipamento;

	public EquipamentoParadaEmProcessoThread(Equipamento equipamento) {
		super();
		this.equipamento = equipamento;
	};

	@Override
	public void run() {
		try {
			while(!isDead()){

				int minimo = equipamento.getDTO().getDuracaoMinimaParadasNoProcesso();
				int maximo = equipamento.getDTO().getDuracaoMaximaParadasNoProcesso();
				int intervalo = ThreadUtils.getIntervalo(minimo, maximo);
				Thread.sleep(intervalo);
				if (isDead()) return;

				equipamento.iniciarProducao();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
