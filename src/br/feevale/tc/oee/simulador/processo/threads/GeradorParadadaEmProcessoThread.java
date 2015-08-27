package br.feevale.tc.oee.simulador.processo.threads;

import java.util.Random;

import br.feevale.tc.oee.simulador.model.Equipamento;
import br.feevale.tc.oee.simulador.utils.ThreadUtils;

public class GeradorParadadaEmProcessoThread extends Thread{
	
	private final int[] idsMotivosParadas;
	private final Equipamento equipamento;
	
	public GeradorParadadaEmProcessoThread(int[] idsMotivosParadas, Equipamento equipamento) {
		super();
		this.idsMotivosParadas = idsMotivosParadas;
		this.equipamento = equipamento;
	}

	@Override
	public void run() {
		while(true){
			try {
				int minimo = equipamento.getDTO().getIntervaloMinimoEntreParadasNoProcesso();
				int maximo = equipamento.getDTO().getIntervaloMaximoEntreParadasNoProcesso();
				int intervalo = ThreadUtils.getIntervalo(minimo, maximo);
				Thread.sleep(intervalo);
				if (!equipamento.isLigado()) return;
				
				int idx = new Random().nextInt(idsMotivosParadas.length-1);
				equipamento.iniciarParadaEmProcesso(idsMotivosParadas[idx]);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
