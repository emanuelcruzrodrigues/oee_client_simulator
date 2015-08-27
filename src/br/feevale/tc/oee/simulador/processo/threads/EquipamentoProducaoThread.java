package br.feevale.tc.oee.simulador.processo.threads;

import org.apache.log4j.Logger;

import br.feevale.tc.oee.simulador.model.Equipamento;
import br.feevale.tc.oee.simulador.model.OrdemProducao;
import br.feevale.tc.oee.simulador.utils.RandomUtils;
import br.feevale.tc.oee.simulador.utils.ThreadUtils;


public class EquipamentoProducaoThread extends SimulacaoThread{

	private final Equipamento equipamento;
	private OrdemProducao ordemProducao;

	public EquipamentoProducaoThread(Equipamento equipamento, OrdemProducao ordemProducao) {
		super();
		this.equipamento = equipamento;
		this.ordemProducao = ordemProducao;
		this.logger = Logger.getLogger(getClass());
	};

	@Override
	public void run() {
		try {
			while(!isDead()){

				Thread.sleep(ThreadUtils.aplicarConversaoIntervalo(1));
				if (isDead()) return;

				if (ordemProducao == null) {
					logger.info(String.format("Equipamento %d sem ordem de producao", equipamento.getId()));
					equipamento.desligar();
					return;
				}

				Integer minimo = ordemProducao.getDTO().getUnidadesPorMinutoMinimo();
				Integer maximo = ordemProducao.getDTO().getUnidadesPorMinutoMaximo();
				int quantidadeProduzida = RandomUtils.nextInt(minimo, maximo);

				equipamento.produzir(this, quantidadeProduzida);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public OrdemProducao getOrdemProducao() {
		return ordemProducao;
	}
	public void setOrdemProducao(OrdemProducao ordemProducao) {
		this.ordemProducao = ordemProducao;
	}
	
}
