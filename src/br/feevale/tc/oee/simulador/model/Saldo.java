package br.feevale.tc.oee.simulador.model;

public class Saldo {
	
	private Integer saldo;
	
	public Saldo(Integer saldo) {
		super();
		this.saldo = saldo;
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void update(Integer quantidade) {
		saldo += quantidade;
	}

	public Integer resgatar() {
		Integer result = saldo;
		this.saldo = 0;
		return result;
	}
}
