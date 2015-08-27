package br.feevale.tc.oee.simulador.processo.threads;

import br.feevale.tc.oee.simulador.model.Equipamento;
import br.feevale.tc.oee.simulador.model.Simulacao;
import br.feevale.tc.oee.simulador.utils.ThreadUtils;



public class EquipamentoParadaPorFaltaDeMaterialThread extends SimulacaoThread{

	private final Equipamento equipamento;

	public EquipamentoParadaPorFaltaDeMaterialThread(Equipamento equipamento) {
		super();
		this.equipamento = equipamento;
	};

	@Override
	public void run() {
		try {
			while(!isDead()){

				Thread.sleep(ThreadUtils.aplicarConversaoIntervalo(1));
				
				if (isDead()) return;

				Integer saldoMateriaPrima = Simulacao.getInstance().getSaldoMateriaPrima(equipamento.getId());
				int buffer = equipamento.getDTO().getBufferInicioProducaoAposFaltaDeMateriaPrima();
				if (saldoMateriaPrima > buffer){
					equipamento.iniciarProducao();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
