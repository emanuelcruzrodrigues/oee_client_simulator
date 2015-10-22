package br.feevale.tc.oee.simulador.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import br.feevale.tc.oee.simulador.model.Equipamento;
import br.feevale.tc.oee.simulador.model.Simulacao;

public class DesligarSimulacaoJob implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Simulacao simulacao = Simulacao.getInstance();
		for (Equipamento equipamento : simulacao.getEquipamentos()) {
			simulacao.getApontamentoWS().encerrarApontamentos(equipamento.getId());
		}
		System.exit(0);
	}

}
