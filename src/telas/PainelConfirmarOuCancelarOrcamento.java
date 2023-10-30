package telas;

import javax.swing.JPanel;

import classes.OrcamentoEvento;
import componentesDeTelas.SemVFXJButton;
import componentesDeTelas.RoundJPanel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class PainelConfirmarOuCancelarOrcamento extends Painel {

	OrcamentoEvento orcamentoEvento;
	
	JPanel painel;
	
	public PainelConfirmarOuCancelarOrcamento() {
		painel = new JPanel();
		painel.setBackground(getCorDeFundo());
		orcamentoEvento = null;
		
		RoundJPanel painelValor = new RoundJPanel(25, 25, 25, 25);
		painelValor.setBorder(new EmptyBorder(0, 20, 0, 0));
		painelValor.setBackground(getCorDeJanelaInterna());
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBackground(getCorDeFundo());
		painelValor.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("R$ ");
		lblNewLabel.setFont(getFonteValor());
		lblNewLabel.setForeground(getCorValor());
		painelValor.add(lblNewLabel, BorderLayout.CENTER);
		painelBotoes.setLayout(new GridLayout(1, 0, 30, 0));
		
		RoundJPanel painelCancelar = new RoundJPanel(25, 25, 25, 25);
		painelCancelar.setBorder(new EmptyBorder(15, 15, 15, 15));
		painelCancelar.setBackground(getCorDeJanelaInterna());
		painelBotoes.add(painelCancelar);
		painelCancelar.setLayout(new BorderLayout(0, 0));
		
		SemVFXJButton botaoCancelar = new SemVFXJButton("CANCELAR");
		botaoCancelar.setFont(getFonteLabelInterno());
		botaoCancelar.setForeground(getCorInputs());
		painelCancelar.add(botaoCancelar);
		
		RoundJPanel painelConfirmar = new RoundJPanel(25, 25, 25, 25);
		painelConfirmar.setBorder(new EmptyBorder(15, 15, 15, 15));
		painelConfirmar.setBackground(getCorDeJanelaInterna());
		painelBotoes.add(painelConfirmar);
		painelConfirmar.setLayout(new BorderLayout(0, 0));
		
		SemVFXJButton botaoConfirmar = new SemVFXJButton("CONFIRMAR");
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
		
		JLabel labelRetornaTudo = new JLabel("");
		labelRetornaTudo.setIcon(getIconeRetornaTudo());
		painelRetornaTudo.add(labelRetornaTudo, BorderLayout.CENTER);
		painelVoltaPagina.setLayout(new BorderLayout(0, 0));
		
		JLabel labelVoltaPagina = new JLabel("");
		labelVoltaPagina.setIcon(getIconeVoltarPagina());
		painelVoltaPagina.add(labelVoltaPagina, BorderLayout.CENTER);
		painel.setLayout(gl_painel);
		
	}
	
	public void setOrcamento(OrcamentoEvento orcamentoEvento) {
		this.orcamentoEvento = orcamentoEvento;
	}
	
	@Override
	public JPanel getPainel() {
		return painel;
	}

	@Override
	public void limparCampos() {
		orcamentoEvento = null;
		//TODO Limpar o resto
		
	}
}