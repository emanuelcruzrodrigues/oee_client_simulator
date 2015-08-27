package br.feevale.tc.oee.simulador.utils;

public class ThreadUtils {
	
	public static int getIntervalo(int min, int max){
		int intervalo = RandomUtils.nextInt(min, max);
		return aplicarConversaoIntervalo(intervalo);
	}
	
	public static int aplicarConversaoIntervalo(int minutos) {
		return minutos * 60 * 1000;
//		return minutos * 10 * 1000;
	}

}
