package br.feevale.tc.oee.simulador.processo.threads;

import org.apache.log4j.Logger;

public class SimulacaoThread extends Thread{
	
	protected Logger logger;
	private boolean dead;
	
	public SimulacaoThread() {
		this.logger = Logger.getLogger(getClass());
		this.dead = false;
	}
	
	public void kill() {
		this.dead = true;
	}
	
	public boolean isDead() {
		return dead;
	}

}
