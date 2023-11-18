package interface_usuario;

import javax.swing.JPanel;

import controladoras.ControladoraJanela;
import controladoras.ControladoraOrcamentoDeBuffetCompleto;
import negocio.OrcamentoBuffetCompleto;
import negocio.OrcamentoEvento;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.border.EmptyBorder;

public class PainelConfirmarOuCancelarOrcamento extends Painel {

	OrcamentoEvento orcamentoEvento;
	
	PainelOrganizadorOrcamentoDeBuffetCompleto organizador;
	
	JPanel painel;
	private JLabel labelVoltaPagina;
	private JLabel labelRetornaTudo;
	private JLabel labelValor;
	private SemVFXJButton botaoConfirmar;
	private SemVFXJButton botaoCancelar;
	
	public PainelConfirmarOuCancelarOrcamento(PainelOrganizadorOrcamentoDeBuffetCompleto organizador) {
		super();
		this.organizador = organizador;
		
		labelRetornaTudo = new JLabel("");
		labelRetornaTudo.addMouseListener(new ListenerRetornaTudo(organizador));
		
		labelVoltaPagina = new JLabel("");
		labelVoltaPagina.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {/* Não faz nada */}
			@Override
			public void mouseReleased(MouseEvent e) { /* Não faz nada */ }
			
			@Override
			public void mousePressed(MouseEvent e) { 
				organizador.paginaAnterior();
			}
			
			@Override
			public void mouseExited(MouseEvent e) { /* Não faz nada */ }
			
			@Override
			public void mouseEntered(MouseEvent e) { /* Não faz nada */ }
			
		});
		
		botaoCancelar = new SemVFXJButton("CANCELAR", Color.WHITE, Color.WHITE);
		botaoCancelar.setFont(getFonteLabelInterno());
		botaoCancelar.setForeground(getCorInputs());
		botaoCancelar.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "Orçamento foi cancelado com sucesso!");
			ControladoraJanela.voltarPainelInicial();
			organizador.limparCampos();
		});
		
		construtorDaTela();
	}
	
	private void construtorDaTela() {
		painel = new JPanel();
		painel.setBackground(getCorDeFundo());
		orcamentoEvento = null;
		
		RoundJPanel painelValor = new RoundJPanel(25, 25, 25, 25);
		painelValor.setBorder(new EmptyBorder(0, 20, 0, 0));
		painelValor.setBackground(getCorDeJanelaInterna());
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBackground(getCorDeFundo());
		painelValor.setLayout(new BorderLayout(0, 0));
		
		labelValor = new JLabel("R$ ");
		labelValor.setFont(getFonteValor());
		labelValor.setForeground(getCorValor());
		painelValor.add(labelValor, BorderLayout.CENTER);
		painelBotoes.setLayout(new GridLayout(1, 0, 30, 0));
		
		RoundJPanel painelCancelar = new RoundJPanel(25, 25, 25, 25);
		painelCancelar.setBorder(new EmptyBorder(15, 15, 15, 15));
		painelCancelar.setBackground(getCorDeJanelaInterna());
		painelBotoes.add(painelCancelar);
		painelCancelar.setLayout(new BorderLayout(0, 0));
		
		painelCancelar.add(botaoCancelar);
		
		RoundJPanel painelConfirmar = new RoundJPanel(25, 25, 25, 25);
		painelConfirmar.setBorder(new EmptyBorder(15, 15, 15, 15));
		painelConfirmar.setBackground(getCorDeJanelaInterna());
		painelBotoes.add(painelConfirmar);
		painelConfirmar.setLayout(new BorderLayout(0, 0));
		
		botaoConfirmar = new SemVFXJButton("CONFIRMAR", Color.WHITE, Color.WHITE);
		botaoConfirmar.setFont(getFonteLabelInterno());
		botaoConfirmar.setForeground(getCorInputs());
		painelConfirmar.add(botaoConfirmar);
		
		JLabel labelTitulo = new JLabel("Confirmar ou cancelar orçamento?");
		labelTitulo.setFont(getFonteTitulo());
		labelTitulo.setForeground(getCorTitulo());
		
		JPanel painelVoltaPagina = new JPanel();
		JPanel painelRetornaTudo = new JPanel();
		
		painelVoltaPagina.setBackground(getCorDeFundo());
		painelRetornaTudo.setBackground(getCorDeFundo());
		
		GroupLayout gl_painel = new GroupLayout(painel);
		gl_painel.setHorizontalGroup(
			gl_painel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel.createSequentialGroup()
					.addGroup(gl_painel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel.createSequentialGroup()
							.addGap(289)
							.addGroup(gl_painel.createParallelGroup(Alignment.TRAILING)
								.addComponent(painelBotoes, GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)
								.addComponent(painelValor, GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_painel.createSequentialGroup()
							.addGap(20)
							.addComponent(painelVoltaPagina, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_painel.createSequentialGroup()
							.addGap(60)
							.addComponent(labelTitulo, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 457, Short.MAX_VALUE)
							.addComponent(painelRetornaTudo, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
					.addGap(20))
		);
		gl_painel.setVerticalGroup(
			gl_painel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel.createSequentialGroup()
					.addGroup(gl_painel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel.createSequentialGroup()
							.addGap(51)
							.addComponent(labelTitulo, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(106)
							.addComponent(painelValor, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(painelBotoes, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
							.addComponent(painelVoltaPagina, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_painel.createSequentialGroup()
							.addGap(20)
							.addComponent(painelRetornaTudo, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
					.addGap(20))
		);
		painelRetornaTudo.setLayout(new BorderLayout(0, 0));
		
		labelRetornaTudo.setIcon(getIconeRetornaTudo());
		labelVoltaPagina.setIcon(getIconeVoltarPagina());
		painelRetornaTudo.add(labelRetornaTudo, BorderLayout.CENTER);
		painelVoltaPagina.setLayout(new BorderLayout(0, 0));
		
		painelVoltaPagina.add(labelVoltaPagina, BorderLayout.CENTER);
		painel.setLayout(gl_painel);
		configurarBotoes();
	}
	
	public void setOrcamento(OrcamentoEvento orcamentoEvento) {
		this.orcamentoEvento = orcamentoEvento;
		
		if (orcamentoEvento != null) labelValor.setText(String.format("R$ %.2f", orcamentoEvento.calcularValorTotal()));
	}
	
	public OrcamentoEvento getOrcamento() {
		return orcamentoEvento;
	}
	
	@Override 
	protected void configurarBotoes() {
		botaoConfirmar.addActionListener( e -> {
			ControladoraOrcamentoDeBuffetCompleto.cadastrarOrcamento((OrcamentoBuffetCompleto) orcamentoEvento);
		
		});
		
	}
	
	@Override
	public JPanel getPainel() {
		return painel;
	}

	@Override
	public void limparCampos() {
		orcamentoEvento = null;
		labelValor.setText("R$ ");

		
	}
}