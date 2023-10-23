package classes;

import java.util.ArrayList;

public class OrcamentoBuffetCompleto extends OrcamentoEvento {
	private double teraCerveja;
	
	private ArrayList<SalgadoSelecionado> arraySalgadoSelecionados = new ArrayList<>();
	private ArrayList<DoceSelecionado>    arrayDoceSelecionados    = new ArrayList<>();
	private Bolo bolo;
	
	public OrcamentoBuffetCompleto(Data data, int numeroDeConvidados, String horaDeInicio, int id, double teraCerveja, ArrayList<Salgado> salgados, ArrayList<Doce> doces, Bolo bolo) {
		super(data, id, numeroDeConvidados, horaDeInicio);
		setTeraCerveja(teraCerveja);
		setBolo(bolo);
		calcularQuantidades(salgados, doces);
	}
	
	public OrcamentoBuffetCompleto(Data data, int numeroDeConvidados, String horaDeInicio, double teraCerveja, ArrayList<Salgado> salgados, ArrayList<Doce> doces, Bolo bolo) {
		super(data, -1, numeroDeConvidados, horaDeInicio);
		setTeraCerveja(teraCerveja);
		setBolo(bolo);
		calcularQuantidades(salgados, doces);
	}
	
	public OrcamentoBuffetCompleto(Data data, int numeroDeConvidados, int numeroDeColaboradores, String horaDeInicio, int id, double teraCerveja, ArrayList<Salgado> salgados, ArrayList<Doce> doces, Bolo bolo) {
		super(data, id, numeroDeConvidados, numeroDeColaboradores, horaDeInicio);
		setTeraCerveja(teraCerveja);
		setBolo(bolo);
		calcularQuantidades(salgados, doces);
	}
	
	public OrcamentoBuffetCompleto(Data data, int numeroDeConvidados, int numeroDeColaboradores, String horaDeInicio, double teraCerveja, ArrayList<Salgado> salgados, ArrayList<Doce> doces, Bolo bolo) {
		super(data, -1, numeroDeConvidados, numeroDeColaboradores, horaDeInicio);
		setTeraCerveja(teraCerveja);
		setBolo(bolo);
		calcularQuantidades(salgados, doces);
	}
	
	private void calcularQuantidades(ArrayList<Salgado> salgados, ArrayList<Doce> doces) {
		int quantidadeSalgados = calcularQuantidadeDeSalgados();
		int quantidadeDoces = calcularQuantidadeDeDoces();
		double pesoBolo = calcularPesoDoBolo();
		
		for (int i = 0; i < salgados.size(); i++) 
			arraySalgadoSelecionados.add(new SalgadoSelecionado(quantidadeSalgados, salgados.get(i)));
		
		for (int i = 0; i < doces.size(); i++) 
			arrayDoceSelecionados.add(new DoceSelecionado(quantidadeDoces, doces.get(i)));
		
		bolo.setPeso(pesoBolo);
		
	}
	
	private int calcularQuantidadeDeSalgados() {
		// TODO Pedir para cliente
		return -1;
	}
	
	private int calcularQuantidadeDeDoces() {
		// TODO Pedir para cliente
		return -1;
	}
	
	private double calcularPesoDoBolo() {
		// TODO Pedir para cliente
		return -1;
	}
	
	private int calcularNumeroMinimoDeColaboradores() {
		// TODO Pedir para cliente
		return -1;
	}
	
	public static ArrayList<Salgado> getAllSalgados() {
		return SalgadoSelecionado.getAllSalgados();
	}
	
	public static ArrayList<Doce> getAllDoces() {
		return DoceSelecionado.getAllDoces();
	}
	
	public static ArrayList<Bolo> getAllBolos() {
		return Bolo.getAllBolos();
	}
	
	private void setTeraCerveja(double teraCerveja) {
		this.teraCerveja = teraCerveja;
	}
	
	private void setBolo(Bolo bolo) {
		this.bolo = bolo;
	}
	
	public double getTeraCerveja() {
		return teraCerveja;
	}	
	
	public ArrayList<SalgadoSelecionado> getArraySalgadoSelecionados() {
		return arraySalgadoSelecionados;
	}

	public ArrayList<DoceSelecionado> getArrayDoceSelecionados() {
		return arrayDoceSelecionados;
	}

	public Bolo getBolo() {
		return bolo;
	}

}
