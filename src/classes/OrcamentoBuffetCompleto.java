package classes;

import java.util.ArrayList;

import bancoDeDados.BoloDAO;
import bancoDeDados.DoceSelecionadoDAO;
import bancoDeDados.OrcamentoBuffetCompletoDAO;
import bancoDeDados.SalgadoSelecionadoDAO;

public class OrcamentoBuffetCompleto extends OrcamentoEvento {
	private boolean teraCerveja;

	private static final OrcamentoBuffetCompletoDAO orcamentoBuffetCompletoDAO = new OrcamentoBuffetCompletoDAO();
	private ArrayList<SalgadoSelecionado> arraySalgadoSelecionados = new ArrayList<>();
	private ArrayList<DoceSelecionado> arrayDoceSelecionados = new ArrayList<>();
	private Bolo bolo;

	public OrcamentoBuffetCompleto(int numeroDeConvidados, String horaDeInicio, Data data, Pagamento pagamento,
			Cliente cliente, int id, boolean teraCerveja, ArrayList<Salgado> salgados, ArrayList<Doce> doces,
			Bolo bolo) {
		
		super(id, numeroDeConvidados, horaDeInicio, data, pagamento, cliente);
		setTeraCerveja(teraCerveja);
		setBolo(bolo);
		calcularQuantidades(salgados, doces);
	}

	public OrcamentoBuffetCompleto(int numeroDeConvidados, String horaDeInicio, Data data, Pagamento pagamento,
			Cliente cliente, boolean teraCerveja, ArrayList<Salgado> salgados, ArrayList<Doce> doces, Bolo bolo) {
		
		super(-1, numeroDeConvidados, horaDeInicio, data, pagamento, cliente);
		setTeraCerveja(teraCerveja);
		setBolo(bolo);
		calcularQuantidades(salgados, doces);
	}

	public OrcamentoBuffetCompleto(int numeroDeConvidados, int numeroDeColaboradores, String horaDeInicio, Data data,
			Pagamento pagamento, Cliente cliente, int id, boolean teraCerveja, ArrayList<Salgado> salgados,
			ArrayList<Doce> doces, Bolo bolo) {
		
		super(id, numeroDeConvidados, numeroDeColaboradores, horaDeInicio, data, pagamento, cliente);
		setTeraCerveja(teraCerveja);
		setBolo(bolo);
		calcularQuantidades(salgados, doces);
	}

	public OrcamentoBuffetCompleto(int numeroDeConvidados, int numeroDeColaboradores, String horaDeInicio, Data data,
			Pagamento pagamento, Cliente cliente, boolean teraCerveja, ArrayList<Salgado> salgados,
			ArrayList<Doce> doces, Bolo bolo) {
		
		super(-1, numeroDeConvidados, numeroDeColaboradores, horaDeInicio, data, pagamento, cliente);
		setTeraCerveja(teraCerveja);
		setBolo(bolo);
		calcularQuantidades(salgados, doces);
	}

	private void calcularQuantidades(ArrayList<Salgado> salgados, ArrayList<Doce> doces) {
		int quantidadeSalgados = calcularQuantidadeDeSalgados() / salgados.size();
		int quantidadeDoces = calcularQuantidadeDeDoces() / doces.size();
		double pesoBolo = calcularPesoDoBolo();

		for (int i = 0; i < salgados.size(); i++) arraySalgadoSelecionados.add(new SalgadoSelecionado(quantidadeSalgados, salgados.get(i)));
		for (int i = 0; i < doces.size(); i++) arrayDoceSelecionados.add(new DoceSelecionado(quantidadeDoces, doces.get(i)));

		bolo.setPeso(pesoBolo);

	}

	private int calcularQuantidadeDeSalgados() {
		return 12 * getNumeroDeConvidados();
	}

	private int calcularQuantidadeDeDoces() {
		return 3 * getNumeroDeConvidados();
	}

	private double calcularPesoDoBolo() {
		return getNumeroDeConvidados() * 0.1;
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

	public static boolean verificarSeDataEstaDisponivel(Data dataDoEvento) {
		return orcamentoBuffetCompletoDAO.verificarData(dataDoEvento);
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

	@Override
	public double calcularValorTotal() {
		double valorTotal = 2799.00;

		for (int i = 0; i < arraySalgadoSelecionados.size(); i++) {
			valorTotal = valorTotal + arraySalgadoSelecionados.get(i).getValor();
		}

		for (int i = 0; i < arrayDoceSelecionados.size(); i++) {
			valorTotal = valorTotal + arrayDoceSelecionados.get(i).getValor();
		}

		valorTotal = valorTotal + bolo.getValor();

		if (getNumeroDeConvidados() > 50 && getNumeroDeConvidados() <= 180) {
			valorTotal = valorTotal + (getNumeroDeConvidados() - 50) * 40.00;
		}

		return valorTotal;
	}

	public static boolean verificarData(Data data) {
		OrcamentoBuffetCompletoDAO orcamentoBuffetCompletoDAO = new OrcamentoBuffetCompletoDAO();
		return orcamentoBuffetCompletoDAO.verificarData(data);
	}

	public static boolean deletarOrcamento(OrcamentoBuffetCompleto orcamentoBuffet) {
		OrcamentoBuffetCompletoDAO orcamentoBuffetCompletoDAO = new OrcamentoBuffetCompletoDAO();
		return orcamentoBuffetCompletoDAO.deletar(orcamentoBuffet.getId());
	}

	public static boolean cadastrarOrcamento(OrcamentoBuffetCompleto orcamentoBuffet) {
		OrcamentoBuffetCompletoDAO orcamentoBuffetCompletoDAO = new OrcamentoBuffetCompletoDAO();
		return orcamentoBuffetCompletoDAO.criar(orcamentoBuffet);
	}

}
