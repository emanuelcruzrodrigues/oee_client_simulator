package br.feevale.tc.oee.simulador.dto;
import java.util.Calendar;
import java.util.Date;


public class DataHoraDTO {
	
	private int ano;
	private int mes;
	private int dia;
	private int hora;
	private int minutos;
	
	public DataHoraDTO(int ano, int mes, int dia, int hora, int minutos) {
		this();
		this.ano = ano;
		this.mes = mes;
		this.dia = dia;
		this.hora = hora;
		this.minutos = minutos;
	}
	
	public DataHoraDTO() {
		super();
	}
	
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	
	public int getMinutos() {
		return minutos;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public Date toDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, getAno());
		calendar.set(Calendar.MONTH, getMes()-1);
		calendar.set(Calendar.DAY_OF_MONTH, getDia());
		calendar.set(Calendar.HOUR_OF_DAY, getHora());
		calendar.set(Calendar.MINUTE, getMinutos());
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	

}
