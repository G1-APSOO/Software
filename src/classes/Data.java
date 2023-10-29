package classes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import excecoes.ExcecaoDiaInvalido;
import excecoes.ExcecaoMesInvalido;
import excecoes.ExcecaoNaoPreenchido;

public class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano)  
    throws ExcecaoNaoPreenchido,
    	ExcecaoDiaInvalido,
    	ExcecaoMesInvalido {
        setAno(ano);
        setMes(mes);
        setDia(dia);
    }

    private void setDia(int dia) throws ExcecaoNaoPreenchido, ExcecaoDiaInvalido {
    	
    	if (dia <= 0) {
    		throw new ExcecaoNaoPreenchido("dia");
    	}

        verificarDia(dia, this.mes, this.ano);

        this.dia = dia;
    }

    private void setMes(int mes) throws ExcecaoNaoPreenchido, ExcecaoMesInvalido {
    	
    	if (mes <= 0) {
    		throw new ExcecaoNaoPreenchido("mês");
    	}
    	
        if (mes > 12) {
            throw new ExcecaoMesInvalido();
        }

        this.mes = mes;
    }

    private void setAno(int ano) 
    throws ExcecaoNaoPreenchido {
    	
    	if (ano <= 0) {
    		throw new ExcecaoNaoPreenchido("ano");
    	}
        
        this.ano = ano;
    }

    private void verificarDia(int dia, int mes, int ano) throws ExcecaoDiaInvalido {

        GregorianCalendar calendario = new GregorianCalendar();
        calendario.set(Calendar.YEAR, ano);
        calendario.set(Calendar.MONTH, mes-1);
        
        if (dia > calendario.getActualMaximum(Calendar.DAY_OF_MONTH)) throw new ExcecaoDiaInvalido();


        this.dia = dia;

    }
    
    public boolean verificarSeDataEstaNoFuturo() {
    	GregorianCalendar dataAtual = new GregorianCalendar();
		dataAtual.set(Calendar.MONTH, dataAtual.get(Calendar.MONTH)+1);
		int diaAtual = dataAtual.get(Calendar.DAY_OF_MONTH);
		int mesAtual = dataAtual.get(Calendar.MONTH);
		int anoAtual = dataAtual.get(Calendar.YEAR);
		
		if (ano > anoAtual) {
			return true;
		} else if (ano < anoAtual) {
			return false;
		}
		
		if (mes > mesAtual) {
			return true;
		} else if (mes < mesAtual) {
			return false;
		}
		
		if (dia > diaAtual) {
			return true;
		} 
		
		return false;
		
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
    
    public String getData() {
		
    	String diaString;
    	String mesString;
    	String anoString;
    	
    	if (dia < 10) diaString = "0" + Integer.toString(dia);
    	else diaString = Integer.toString(dia);
    	
    	if (mes < 10) mesString = "0" + Integer.toString(mes);
    	else mesString = Integer.toString(mes);
    	
    	anoString = Integer.toString(ano);
    	
    	return diaString + "/" + mesString + "/" + anoString;
	}

}