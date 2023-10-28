package controladoras;

import classes.Cliente;
import classes.Data;
import classes.Salgado;
import classes.Doce;

import java.util.ArrayList;

import classes.Bolo;

public class ControladoraOrcamentoDeBuffetCompleto {
	public Double consultarValorDoOrcamento(int idOrcamento) { return null; }
	public Double cadastrarOrcamento(int numeroDeConvidados, int numeroDeColaboradores, Data dataDoEvento, Cliente cliente, String horaDeInicio, boolean teraCerveja, ArrayList<Salgado> opcoesDeSalgado, ArrayList<Doce> opcoesDeDoces, Bolo opcaoDeBolo) { return null; }
	public int verificarNumeroDeConvidados(int numeroDeConvidados) { return -1; } 
	public boolean verificarData(Data data) { return false; }
	public boolean verificarValidezHorario(String horaDeInicio) { return false; }
	public boolean verificarOpcoesSalgados(ArrayList<Salgado> opcoesDeSalgado) { return false; }
	public boolean verificarOpcoesDoces(ArrayList<Doce> opcoesDeDoces) {return false; }
	public void cancelarOrcamento() {}
	public ArrayList<Salgado> getAllSalgados() { return null; }
	public ArrayList<Doce> getAllDoces() { return null; }
	public ArrayList<Bolo> getAllBolos() { return null; }
}
