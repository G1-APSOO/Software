package classes;

import java.util.ArrayList;

public class OrcamentoBuffetCompleto extends OrcamentoEvento {
	private boolean teraCerveja;
	
	private ArrayList<SalgadoSelecionado> arraySalgadoSelecionados = new ArrayList<>();
	private ArrayList<DoceSelecionado>    arrayDoceSelecionados    = new ArrayList<>();
	private Bolo bolo;
	private OrcamentoBuffetCompletoDAO orcamentoBuffetCompletoDAO;
	
	public OrcamentoBuffetCompleto(int numeroDeConvidados, String horaDeInicio, Data data, Pagamento pagamento, int id, boolean teraCerveja, ArrayList<Salgado> salgados, ArrayList<Doce> doces, Bolo bolo) {
		super(id, numeroDeConvidados, horaDeInicio, data, pagamento);
		setTeraCerveja(teraCerveja);
		setBolo(bolo);
		calcularQuantidades(salgados, doces);
		this.orcamentoBuffetCompletoDAO = new OrcamentoBuffetCompletoDAO();
	}
	
	public OrcamentoBuffetCompleto(int numeroDeConvidados, String horaDeInicio, Data data, Pagamento pagamento, boolean teraCerveja, ArrayList<Salgado> salgados, ArrayList<Doce> doces, Bolo bolo) {
		super(-1, numeroDeConvidados, horaDeInicio, data, pagamento);
		setTeraCerveja(teraCerveja);
		setBolo(bolo);
		calcularQuantidades(salgados, doces);
		this.orcamentoBuffetCompletoDAO = new OrcamentoBuffetCompletoDAO();
	}
	
	public OrcamentoBuffetCompleto(int numeroDeConvidados, int numeroDeColaboradores, String horaDeInicio, Data data, Pagamento pagamento, int id, boolean teraCerveja, ArrayList<Salgado> salgados, ArrayList<Doce> doces, Bolo bolo) {
		super(id, numeroDeConvidados, numeroDeColaboradores, horaDeInicio, data, pagamento);
		setTeraCerveja(teraCerveja);
		setBolo(bolo);
		calcularQuantidades(salgados, doces);
		this.orcamentoBuffetCompletoDAO = new OrcamentoBuffetCompletoDAO();
	}
	
	public OrcamentoBuffetCompleto(int numeroDeConvidados, int numeroDeColaboradores, String horaDeInicio, Data data, Pagamento pagamento, boolean teraCerveja, ArrayList<Salgado> salgados, ArrayList<Doce> doces, Bolo bolo) {
		super(-1, numeroDeConvidados, numeroDeColaboradores, horaDeInicio, data, pagamento);
		setTeraCerveja(teraCerveja);
		setBolo(bolo);
		calcularQuantidades(salgados, doces);
		this.orcamentoBuffetCompletoDAO = new OrcamentoBuffetCompletoDAO();
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
		SalgadoSelecionadoDAO SalgadoSelecionadoDAO = new SalgadoSelecionadoDAO();
		return SalgadoSelecionadoDAO.getAllSalgados();
	}
	
	public static ArrayList<Doce> getAllDoces() {
		DoceSelecionadoDAO DoceSelecionadoDAO = new DoceSelecionadoDAO();
		return DoceSelecionadoDAO.getAllDoces();
	}
	
	public static ArrayList<Bolo> getAllBolos() {
		BoloDAO BoloDAO = new BoloDAO();
		return BoloDAO.getAllBolos();
	}
	
	private void setTeraCerveja(boolean teraCerveja) {
		this.teraCerveja = teraCerveja;
	}
	
	private void setBolo(Bolo bolo) {
		this.bolo = bolo;
	}
	
	public boolean getTeraCerveja() {
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
