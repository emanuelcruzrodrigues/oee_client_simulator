package br.feevale.tc.oee.simulador.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import br.feevale.tc.oee.simulador.model.Simulacao;

public class DesligarEquipamentoJob implements Job{
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String[] parameters = context.getJobDetail().getKey().getName().split(" ");
		String idEquipamento = parameters[0];
		Simulacao.getInstance().desligar(new Integer(idEquipamento));
	}

}
