package classes;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int dia, int mes, int ano) {
		setDia(dia);
		setMes(mes);
		setAno(ano);
	}
	
	private void setDia(int dia) {
		this.dia = dia;
	}
	
	private void setMes(int mes) {
		this.mes = mes;
	}

	private void setAno(int ano) {
		this.ano = ano;
	}
	
	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

}
