package classes;

import java.util.ArrayList;

import bancoDeDados.BoloDAO;
import bancoDeDados.DoceSelecionadoDAO;
import bancoDeDados.OrcamentoBuffetCompletoDAO;
import bancoDeDados.SalgadoSelecionadoDAO;

public class OrcamentoBuffetCompleto extends OrcamentoEvento {
	private boolean teraCerveja;

	private ArrayList<SalgadoSelecionado> arraySalgadoSelecionados = new ArrayList<>();
	private ArrayList<DoceSelecionado> arrayDoceSelecionados = new ArrayList<>();
	private Bolo bolo;
	private OrcamentoBuffetCompletoDAO orcamentoBuffetCompletoDAO;

	public OrcamentoBuffetCompleto(int numeroDeConvidados, String horaDeInicio, Data data, Pagamento pagamento,
			Cliente cliente, int id, boolean teraCerveja, ArrayList<Salgado> salgados, ArrayList<Doce> doces,
			Bolo bolo) {
		super(id, numeroDeConvidados, horaDeInicio, data, pagamento, cliente);
		setTeraCerveja(teraCerveja);
		setBolo(bolo);
		calcularQuantidades(salgados, doces);
		this.orcamentoBuffetCompletoDAO = new OrcamentoBuffetCompletoDAO();
	}

	public OrcamentoBuffetCompleto(int numeroDeConvidados, String horaDeInicio, Data data, Pagamento pagamento,
			Cliente cliente, boolean teraCerveja, ArrayList<Salgado> salgados, ArrayList<Doce> doces, Bolo bolo) {
		super(-1, numeroDeConvidados, horaDeInicio, data, pagamento, cliente);
		setTeraCerveja(teraCerveja);
		setBolo(bolo);
		calcularQuantidades(salgados, doces);
		this.orcamentoBuffetCompletoDAO = new OrcamentoBuffetCompletoDAO();
	}

	public OrcamentoBuffetCompleto(int numeroDeConvidados, int numeroDeColaboradores, String horaDeInicio, Data data,
			Pagamento pagamento, Cliente cliente, int id, boolean teraCerveja, ArrayList<Salgado> salgados,
			ArrayList<Doce> doces, Bolo bolo) {
		super(id, numeroDeConvidados, numeroDeColaboradores, horaDeInicio, data, pagamento, cliente);
		setTeraCerveja(teraCerveja);
		setBolo(bolo);
		calcularQuantidades(salgados, doces);
		this.orcamentoBuffetCompletoDAO = new OrcamentoBuffetCompletoDAO();
	}

	public OrcamentoBuffetCompleto(int numeroDeConvidados, int numeroDeColaboradores, String horaDeInicio, Data data,
			Pagamento pagamento, Cliente cliente, boolean teraCerveja, ArrayList<Salgado> salgados,
			ArrayList<Doce> doces, Bolo bolo) {
		super(-1, numeroDeConvidados, numeroDeColaboradores, horaDeInicio, data, pagamento, cliente);
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
		int quantidadeSalgados = 12 * getNumeroDeConvidados();
		return quantidadeSalgados;
	}

	private int calcularQuantidadeDeDoces() {
		int quantidadeDoces = 3 * getNumeroDeConvidados();
		return quantidadeDoces;
	}

	private double calcularPesoDoBolo() {
		double pesoDoBolo = getNumeroDeConvidados() * 0.1;
		return pesoDoBolo;
	}

	private int calcularNumeroMinimoDeColaboradores() {
		int numeroDeColaboradores = 8;

		if (teraCerveja == true) {
			numeroDeColaboradores = numeroDeColaboradores + 1;
		}

		return numeroDeColaboradores;
	}

	public static ArrayList<Salgado> getAllSalgados() {
		SalgadoSelecionadoDAO salgadoSelecionadoDAO = new SalgadoSelecionadoDAO();
		return salgadoSelecionadoDAO.getAllSalgados();
	}

	public static ArrayList<Doce> getAllDoces() {
		DoceSelecionadoDAO doceSelecionadoDAO = new DoceSelecionadoDAO();
		
		return doceSelecionadoDAO.getAllDoces();
	}

	public static ArrayList<Bolo> getAllBolos() {
		BoloDAO boloDAO = new BoloDAO();
		return boloDAO.getAll();
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

	public ArrayList<Salgado> getArraySalgadoSelecionados() {
		SalgadoSelecionadoDAO SalgadoSelecionadoDAO = new SalgadoSelecionadoDAO();
		return SalgadoSelecionadoDAO.getAllBuffet(this.getId());
	}

	public ArrayList<Doce> getArrayDoceSelecionados() {
		DoceSelecionadoDAO DoceSelecionadoDAO = new DoceSelecionadoDAO();
		return DoceSelecionadoDAO.getAllBuffet(this.getId());
	}

	public Bolo getBolo() {
		return bolo;
	}

	public static boolean verificarData(Data data) {
		OrcamentoBuffetCompletoDAO orcamentoBuffetCompletoDAO = new OrcamentoBuffetCompletoDAO();
		return orcamentoBuffetCompletoDAO.verificarData(data);
	}

}
