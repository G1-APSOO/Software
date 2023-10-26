package telas;

import java.awt.Color;

import javax.swing.JPanel;

import componentesDeTelas.RoundJPanel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;

public class PainelEscolhaDeOrcamento implements Painel {
	
	private JPanel painel;
	private Color corDeFundo;
	private Color corJanelaInterna;
	private Color corTitulo;
	private Color corTexto;
	private Color corInputs;
	
	public PainelEscolhaDeOrcamento() {
		painel = new JPanel();
		
		setCores();
		corDeFundo = new Color(100, 183, 206);
		corTexto = new Color(240,240,240);
		corTitulo = new Color(34,45,48);
		corJanelaInterna = new Color(25,25,25);
		corInputs = new Color(0,0,0);
		
		painel.setBackground(corDeFundo);
		
		
		JPanel painelDivisorBotoes = new JPanel();
		
		JPanel painelRetornaTudo = new JPanel();
		
		JPanel painelVolta = new JPanel();
		GroupLayout gl_painel = new GroupLayout(painel);
		gl_painel.setHorizontalGroup(
			gl_painel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel.createSequentialGroup()
					.addGap(400)
					.addComponent(painelDivisorBotoes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(400))
				.addGroup(gl_painel.createSequentialGroup()
					.addGap(1163)
					.addGroup(gl_painel.createParallelGroup(Alignment.LEADING)
						.addComponent(painelVolta, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(painelRetornaTudo, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_painel.setVerticalGroup(
			gl_painel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel.createSequentialGroup()
					.addGap(29)
					.addComponent(painelRetornaTudo, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(111)
					.addComponent(painelDivisorBotoes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(109)
					.addComponent(painelVolta, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
		);
		painelDivisorBotoes.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel painelExternoOrcamentoBuffetCompleto = new JPanel();
		painelExternoOrcamentoBuffetCompleto.setBackground(corDeFundo);
		painelDivisorBotoes.add(painelExternoOrcamentoBuffetCompleto);
		
		RoundJPanel painelBotaoOrcamentoBuffetCompleto = new RoundJPanel(35, 35, 35, 35);
		painelBotaoOrcamentoBuffetCompleto.setBackground(corJanelaInterna);
		GroupLayout gl_painelExternoOrcamentoBuffetCompleto = new GroupLayout(painelExternoOrcamentoBuffetCompleto);
		gl_painelExternoOrcamentoBuffetCompleto.setHorizontalGroup(
			gl_painelExternoOrcamentoBuffetCompleto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelExternoOrcamentoBuffetCompleto.createSequentialGroup()
					.addGap(15)
					.addComponent(painelBotaoOrcamentoBuffetCompleto, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
					.addGap(15))
		);
		gl_painelExternoOrcamentoBuffetCompleto.setVerticalGroup(
			gl_painelExternoOrcamentoBuffetCompleto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelExternoOrcamentoBuffetCompleto.createSequentialGroup()
					.addGap(20)
					.addComponent(painelBotaoOrcamentoBuffetCompleto, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
					.addGap(20))
		);
		painelExternoOrcamentoBuffetCompleto.setLayout(gl_painelExternoOrcamentoBuffetCompleto);
		
		JPanel painelExternoOrcamentoLocacao = new JPanel();
		painelExternoOrcamentoLocacao.setBackground(corDeFundo);
		painelDivisorBotoes.add(painelExternoOrcamentoLocacao);
		
		RoundJPanel painelBotaoOrcamentoLocacao = new RoundJPanel(35, 35, 35, 35);
		painelBotaoOrcamentoLocacao.setBackground(corJanelaInterna);
		GroupLayout gl_painelExternoOrcamentoLocacao = new GroupLayout(painelExternoOrcamentoLocacao);
		gl_painelExternoOrcamentoLocacao.setHorizontalGroup(
			gl_painelExternoOrcamentoLocacao.createParallelGroup(Alignment.LEADING)
				.addGap(0, 470, Short.MAX_VALUE)
				.addGroup(gl_painelExternoOrcamentoLocacao.createSequentialGroup()
					.addGap(15)
					.addComponent(painelBotaoOrcamentoLocacao, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
					.addGap(15))
		);
		gl_painelExternoOrcamentoLocacao.setVerticalGroup(
			gl_painelExternoOrcamentoLocacao.createParallelGroup(Alignment.LEADING)
				.addGap(0, 160, Short.MAX_VALUE)
				.addGroup(gl_painelExternoOrcamentoLocacao.createSequentialGroup()
					.addGap(20)
					.addComponent(painelBotaoOrcamentoLocacao, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
					.addGap(20))
		);
		painelExternoOrcamentoLocacao.setLayout(gl_painelExternoOrcamentoLocacao);
		painel.setLayout(gl_painel);
		
	}

	@Override
	public JPanel getPainel() {
		return painel;
	}

	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCores() {
		// TODO Auto-generated method stub
		
	}
}
