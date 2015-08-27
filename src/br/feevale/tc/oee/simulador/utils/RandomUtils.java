package br.feevale.tc.oee.simulador.utils;

import java.util.Random;

public class RandomUtils {
	
	public static int nextInt(int min, int max){
		
		if (min == max){
			return max;
		}
		
		int	result = max - min;
		result = new Random().nextInt(result+1);
		result = result + min;
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(nextInt(10, 10));
		System.out.println(nextInt(1, 3));
	}
	


}
