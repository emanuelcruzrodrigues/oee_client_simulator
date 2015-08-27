package br.feevale.tc.oee.simulador.job;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import br.feevale.tc.oee.simulador.dto.ProgramacaoProducaoEquipamentoDTO;
import br.feevale.tc.oee.simulador.model.Equipamento;


public class AgendadorDeTarefas {
	
	private long maiorAgendamentoInMillis;
	private Scheduler scheduler;
	
	public AgendadorDeTarefas() {
		try {
			scheduler = new StdSchedulerFactory().getScheduler();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public void agendarOperacaoEquipamento(Equipamento equipamento, List<ProgramacaoProducaoEquipamentoDTO> programacoes) {
		try {
			agendarJobs(scheduler, equipamento, programacoes);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	private void agendarJobs(Scheduler scheduler, Equipamento equipamento, List<ProgramacaoProducaoEquipamentoDTO> programacoes) throws SchedulerException {
		Logger logger = Logger.getLogger(getClass());
		
		for (int i = 0; i < programacoes.size(); i++) {
			ProgramacaoProducaoEquipamentoDTO programacao = programacoes.get(i);
			
			Date dtLigar = programacao.getDtHrInicio().toDate();
			String idLigar = String.format("%d _ligar as %s", equipamento.getId(), dtLigar.toString());
			JobDetail jobLigar = JobBuilder.newJob(LigarEquipamentoJob.class).withIdentity(idLigar).build();
			SimpleTrigger triggerLigar = (SimpleTrigger) TriggerBuilder.newTrigger() 
					.withIdentity("trigger_" + idLigar)
					.startAt(dtLigar) 
					.forJob(idLigar)
					.build();
			scheduler.scheduleJob(jobLigar, triggerLigar);
			logger.info(idLigar);
			
			Date dtDesligar = programacao.getDtHrFim().toDate();
			String idDesligar = String.format("%d desligar as %s", equipamento.getId(), dtDesligar.toString());
			JobDetail jobDesligar = JobBuilder.newJob(DesligarEquipamentoJob.class).withIdentity(idDesligar).build();
			SimpleTrigger triggerDesligar = (SimpleTrigger) TriggerBuilder.newTrigger() 
					.withIdentity(idDesligar)
					.startAt(dtDesligar) 
					.forJob(idDesligar)
					.build();
			scheduler.scheduleJob(jobDesligar, triggerDesligar);
			logger.info(idDesligar);
			
			updateMaiorAgendamentoInMillis(dtDesligar);
			
		}
	}

	private void updateMaiorAgendamentoInMillis(Date dt) {
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		long timeInMillis = c.getTimeInMillis();
		if (timeInMillis > maiorAgendamentoInMillis){
			maiorAgendamentoInMillis = timeInMillis;
		}
	}

	public void agendarDesligamento(){
		try {
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(maiorAgendamentoInMillis + 10_000);
			
			Date dtDesligar = c.getTime();
			String idDesligar = String.format("finalizar simulacao as %s", dtDesligar.toString());
			JobDetail jobDesligar = JobBuilder.newJob(DesligarSimulacaoJob.class).withIdentity(idDesligar).build();
			SimpleTrigger triggerDesligar = (SimpleTrigger) TriggerBuilder.newTrigger() 
					.withIdentity(idDesligar)
					.startAt(dtDesligar) 
					.forJob(idDesligar)
					.build();
			
			scheduler.scheduleJob(jobDesligar, triggerDesligar);
			
			Logger logger = Logger.getLogger(getClass());
			logger.info(idDesligar);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	public void start() throws SchedulerException {
		scheduler.start();
	}
}
