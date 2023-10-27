package telas;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import componentesDeTelas.RoundJPanel;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;

public class PainelOpcoesOrcamentoDeBuffetCompleto extends Painel {
	
	private JPanel painel;
	
	private JRadioButton botaoDoceBrigadeiro;
	private JRadioButton botaoDoceBrigadeiroBranco;
	private JRadioButton botaoDoceBrigadeiroColorido;
	private JRadioButton botaoDoceBeijinhoDeCoco;
	private JRadioButton botaoDoceCasadinho;
	private JRadioButton botaoDoceCajuzinho;
	private JRadioButton botaoBoloBrigadeiro;
	private JRadioButton botaoBoloPrestigio;
	private JRadioButton botaoBoloAbacaxi;
	private JRadioButton botaoBoloPessego;
	private JRadioButton botaoBoloDoisAmores;
	private JRadioButton botaoBoloViuvaNegra;
	private JRadioButton botaoComCerveja;
	private JRadioButton rdbtnSemCerveja;
	private JRadioButton botaoSalgadoCoxinhaDeFrango;
	private JRadioButton botaoSalgadoCoxinhaDeFrangoComCatupiry;
	private JRadioButton botaoSalgadoRisolesDeCarne;
	private JRadioButton botaoSalgadoQuibe;
	private JRadioButton botaoSalgadoEsfihaDeCarne;
	private JRadioButton botaoSalgadoEmpadinhaDePalmito;
	private JRadioButton botaoSalgadoEnroladinhoDeSalsicha;
	private JRadioButton botaoSalgadoBolinhaDeQueijo;
	private JRadioButton botaoSalgadoBolinhaDeQueijoComMilho;
	private JRadioButton botaoSalgadoRisolesDeFrango;
	private JRadioButton botaoSalgadoRisolesDePresuntoQueijo;
	private JRadioButton botaoSalgadoEnroladinhoPresuntoQueijo;
	
	public PainelOpcoesOrcamentoDeBuffetCompleto() {
		super();
		
		painel = new JPanel();
		painel.setBackground(getCorDeFundo());
		
		Font fonteRadioButton = new Font("Arial", Font.BOLD, 14);
		Font fonteRadioButtonSalgados = new Font("Arial", Font.BOLD, 13);
		
		JLabel labelTitulo = new JLabel("Opções de buffet completo");
		labelTitulo.setBounds(44, 30, 494, 58);
		labelTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		labelTitulo.setFont(getFonteTitulo());
		
		RoundJPanel painelDelimitadorSalgado = new RoundJPanel(25, 25, 25, 25);
		painelDelimitadorSalgado.setBounds(40, 99, 1191, 154);
		painelDelimitadorSalgado.setBorder(new EmptyBorder(10, 10, 10, 10));
		painelDelimitadorSalgado.setBackground(getCorDeJanelaInterna());
		
		JPanel painelDelimitadorDoceBoloCerveja = new JPanel();
		painelDelimitadorDoceBoloCerveja.setBounds(40, 268, 1191, 325);
		painelDelimitadorDoceBoloCerveja.setBackground(getCorDeFundo());
		
		JPanel painelVoltaPagina = new JPanel();
		painelVoltaPagina.setBackground(getCorDeFundo());
		painelVoltaPagina.setBounds(10, 604, 70, 70);
		
		JPanel painelAvancaPagina = new JPanel();
		painelAvancaPagina.setBackground(getCorDeFundo());
		painelAvancaPagina.setBounds(1186, 604, 70, 70);
		painelAvancaPagina.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel painelRetornaTudo = new JPanel();
		painelRetornaTudo.setBackground(getCorDeFundo());
		painelRetornaTudo.setBounds(1186, 18, 70, 70);
		painelVoltaPagina.setLayout(new GridLayout(1, 0, 0, 0));
		painelDelimitadorDoceBoloCerveja.setLayout(new GridLayout(3, 1, 0, 20));
		
		RoundJPanel painelDelimitadorDoce = new RoundJPanel(25, 25, 25, 25);
		painelDelimitadorDoce.setBorder(new EmptyBorder(10, 10, 5, 10));
		painelDelimitadorDoce.setBackground(getCorDeJanelaInterna());
		painelDelimitadorDoceBoloCerveja.add(painelDelimitadorDoce);
		
		JLabel labelOpcoesDoce = new JLabel("Opções de doce");
		labelOpcoesDoce.setForeground(getCorTexto());
		labelOpcoesDoce.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JPanel painelBotoesDoce = new JPanel();
		painelBotoesDoce.setBackground(getCorDeJanelaInterna());
		GroupLayout gl_painelDelimitadorDoce = new GroupLayout(painelDelimitadorDoce);
		gl_painelDelimitadorDoce.setHorizontalGroup(
			gl_painelDelimitadorDoce.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelDelimitadorDoce.createSequentialGroup()
					.addGroup(gl_painelDelimitadorDoce.createParallelGroup(Alignment.LEADING)
						.addComponent(labelOpcoesDoce, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painelDelimitadorDoce.createSequentialGroup()
							.addGap(1)
							.addComponent(painelBotoesDoce, GroupLayout.DEFAULT_SIZE, 1169, Short.MAX_VALUE)))
					.addGap(1))
		);
		gl_painelDelimitadorDoce.setVerticalGroup(
			gl_painelDelimitadorDoce.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelDelimitadorDoce.createSequentialGroup()
					.addComponent(labelOpcoesDoce, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(painelBotoesDoce, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addGap(1))
		);
		
		botaoDoceBrigadeiro = new JRadioButton("Brigadeiro");
		botaoDoceBrigadeiro.setFont(fonteRadioButton);
		botaoDoceBrigadeiro.setForeground(getCorTexto());
		botaoDoceBrigadeiro.setBackground(getCorDeJanelaInterna());
		
		botaoDoceBrigadeiroBranco = new JRadioButton("Brigadeiro branco");
		botaoDoceBrigadeiroBranco.setFont(fonteRadioButton);
		botaoDoceBrigadeiroBranco.setForeground(getCorTexto());
		botaoDoceBrigadeiroBranco.setBackground(getCorDeJanelaInterna());
		
		botaoDoceBrigadeiroColorido = new JRadioButton("Brigadeiro colorido");
		botaoDoceBrigadeiroColorido.setFont(fonteRadioButton);
		botaoDoceBrigadeiroColorido.setForeground(getCorTexto());
		botaoDoceBrigadeiroColorido.setBackground(getCorDeJanelaInterna());
		
		botaoDoceBeijinhoDeCoco = new JRadioButton("Beijinho de coco");
		botaoDoceBeijinhoDeCoco.setFont(fonteRadioButton);
		botaoDoceBeijinhoDeCoco.setForeground(getCorTexto());
		botaoDoceBeijinhoDeCoco.setBackground(getCorDeJanelaInterna());
		
		botaoDoceCasadinho = new JRadioButton("Casadinho");
		botaoDoceCasadinho.setFont(fonteRadioButton);
		botaoDoceCasadinho.setForeground(getCorTexto());
		botaoDoceCasadinho.setBackground(getCorDeJanelaInterna());
		
		botaoDoceCajuzinho = new JRadioButton("Cajuzinho");
		botaoDoceCajuzinho.setFont(fonteRadioButton);
		botaoDoceCajuzinho.setForeground(getCorTexto());
		botaoDoceCajuzinho.setBackground(getCorDeJanelaInterna());
		
		GroupLayout gl_painelBotoesDoce = new GroupLayout(painelBotoesDoce);
		gl_painelBotoesDoce.setHorizontalGroup(
			gl_painelBotoesDoce.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelBotoesDoce.createSequentialGroup()
					.addGap(5)
					.addComponent(botaoDoceBrigadeiro, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(botaoDoceBrigadeiroBranco, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(botaoDoceBrigadeiroColorido, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(botaoDoceBeijinhoDeCoco, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(botaoDoceCasadinho, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(botaoDoceCajuzinho, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
					.addGap(347))
		);
		gl_painelBotoesDoce.setVerticalGroup(
			gl_painelBotoesDoce.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_painelBotoesDoce.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_painelBotoesDoce.createParallelGroup(Alignment.LEADING)
						.addComponent(botaoDoceBeijinhoDeCoco, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addComponent(botaoDoceCajuzinho, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addComponent(botaoDoceCasadinho, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addComponent(botaoDoceBrigadeiroColorido, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addComponent(botaoDoceBrigadeiroBranco, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addComponent(botaoDoceBrigadeiro, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
					.addGap(10))
		);
		painelBotoesDoce.setLayout(gl_painelBotoesDoce);
		painelDelimitadorDoce.setLayout(gl_painelDelimitadorDoce);
		
		RoundJPanel painelDelimitadorBolo = new RoundJPanel(25, 25, 25, 25);
		painelDelimitadorBolo.setBorder(new EmptyBorder(15, 10, 5, 10));
		painelDelimitadorBolo.setBackground(getCorDeJanelaInterna());
		painelDelimitadorDoceBoloCerveja.add(painelDelimitadorBolo);
		
		JLabel labelOpcoesBolo = new JLabel("Opções de bolo");
		labelOpcoesBolo.setForeground(getCorTexto());
		labelOpcoesBolo.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JPanel painelBotoesBolo = new JPanel();
		painelBotoesBolo.setBackground(getCorDeJanelaInterna());
		GroupLayout gl_painelDelimitadorBolo = new GroupLayout(painelDelimitadorBolo);
		gl_painelDelimitadorBolo.setHorizontalGroup(
			gl_painelDelimitadorBolo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelDelimitadorBolo.createSequentialGroup()
					.addComponent(labelOpcoesBolo, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
					.addGap(44))
				.addGroup(gl_painelDelimitadorBolo.createSequentialGroup()
					.addGap(1)
					.addComponent(painelBotoesBolo, GroupLayout.PREFERRED_SIZE, 1160, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_painelDelimitadorBolo.setVerticalGroup(
			gl_painelDelimitadorBolo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelDelimitadorBolo.createSequentialGroup()
					.addComponent(labelOpcoesBolo, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(painelBotoesBolo, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addGap(1))
		);
		
		botaoBoloBrigadeiro = new JRadioButton("Brigadeiro");
		botaoBoloBrigadeiro.setFont(fonteRadioButton);
		botaoBoloBrigadeiro.setForeground(getCorTexto());
		botaoBoloBrigadeiro.setBackground(getCorDeJanelaInterna());
		
		botaoBoloPrestigio = new JRadioButton("Prestigio");
		botaoBoloPrestigio.setFont(fonteRadioButton);
		botaoBoloPrestigio.setForeground(getCorTexto());
		botaoBoloPrestigio.setBackground(getCorDeJanelaInterna());
		
		botaoBoloAbacaxi = new JRadioButton("Abacaxi");
		botaoBoloAbacaxi.setFont(fonteRadioButton);
		botaoBoloAbacaxi.setForeground(getCorTexto());
		botaoBoloAbacaxi.setBackground(getCorDeJanelaInterna());
		
		botaoBoloPessego = new JRadioButton("Pêssego");
		botaoBoloPessego.setFont(fonteRadioButton);
		botaoBoloPessego.setForeground(getCorTexto());
		botaoBoloPessego.setBackground(getCorDeJanelaInterna());
		
		botaoBoloDoisAmores = new JRadioButton("Dois amores");
		botaoBoloDoisAmores.setFont(fonteRadioButton);
		botaoBoloDoisAmores.setForeground(getCorTexto());
		botaoBoloDoisAmores.setBackground(getCorDeJanelaInterna());
		
		botaoBoloViuvaNegra = new JRadioButton("Viúva negra");
		botaoBoloViuvaNegra.setFont(fonteRadioButton);
		botaoBoloViuvaNegra.setForeground(getCorTexto());
		botaoBoloViuvaNegra.setBackground(getCorDeJanelaInterna());
		
		GroupLayout gl_painelBotoesBolo = new GroupLayout(painelBotoesBolo);
		gl_painelBotoesBolo.setHorizontalGroup(
			gl_painelBotoesBolo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelBotoesBolo.createSequentialGroup()
					.addGap(5)
					.addComponent(botaoBoloBrigadeiro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(botaoBoloPrestigio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(botaoBoloAbacaxi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(botaoBoloPessego, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(botaoBoloDoisAmores, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(botaoBoloViuvaNegra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(549))
		);
		gl_painelBotoesBolo.setVerticalGroup(
			gl_painelBotoesBolo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelBotoesBolo.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_painelBotoesBolo.createParallelGroup(Alignment.LEADING)
						.addComponent(botaoBoloViuvaNegra, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(botaoBoloDoisAmores, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(botaoBoloPessego, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(botaoBoloAbacaxi, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(botaoBoloPrestigio, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(botaoBoloBrigadeiro, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
					.addGap(10))
		);
		painelBotoesBolo.setLayout(gl_painelBotoesBolo);
		painelDelimitadorBolo.setLayout(gl_painelDelimitadorBolo);
		
		RoundJPanel painelDelimitadorCerveja = new RoundJPanel(25, 25, 25, 25);
		painelDelimitadorCerveja.setBorder(new EmptyBorder(5, 10, 20, 10));
		painelDelimitadorCerveja.setBackground(getCorDeJanelaInterna());
		painelDelimitadorDoceBoloCerveja.add(painelDelimitadorCerveja);
		
		JLabel labelOpcionalCerveja = new JLabel("Opcional de cerveja");
		labelOpcionalCerveja.setForeground(getCorTexto());
		labelOpcionalCerveja.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JPanel painelBotoesCerveja = new JPanel();
		painelBotoesCerveja.setBackground(getCorDeJanelaInterna());
		GroupLayout gl_painelDelimitadorCerveja = new GroupLayout(painelDelimitadorCerveja);
		gl_painelDelimitadorCerveja.setHorizontalGroup(
			gl_painelDelimitadorCerveja.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_painelDelimitadorCerveja.createSequentialGroup()
					.addComponent(labelOpcionalCerveja, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
					.addGap(839))
				.addComponent(painelBotoesCerveja, GroupLayout.DEFAULT_SIZE, 1170, Short.MAX_VALUE)
		);
		gl_painelDelimitadorCerveja.setVerticalGroup(
			gl_painelDelimitadorCerveja.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelDelimitadorCerveja.createSequentialGroup()
					.addComponent(labelOpcionalCerveja, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(painelBotoesCerveja, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
					.addGap(0))
		);
		
		botaoComCerveja = new JRadioButton("Com cerveja");
		botaoComCerveja.setFont(fonteRadioButton);
		botaoComCerveja.setBackground(getCorDeJanelaInterna());
		botaoComCerveja.setForeground(getCorTexto());
		
		rdbtnSemCerveja = new JRadioButton("Sem cerveja");
		rdbtnSemCerveja.setFont(fonteRadioButton);
		rdbtnSemCerveja.setBackground(getCorDeJanelaInterna());
		rdbtnSemCerveja.setForeground(getCorTexto());
		rdbtnSemCerveja.setSelected(true);
		GroupLayout gl_painelBotoesCerveja = new GroupLayout(painelBotoesCerveja);
		gl_painelBotoesCerveja.setHorizontalGroup(
			gl_painelBotoesCerveja.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_painelBotoesCerveja.createSequentialGroup()
					.addGap(5)
					.addComponent(botaoComCerveja, GroupLayout.PREFERRED_SIZE, 114, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(rdbtnSemCerveja, GroupLayout.PREFERRED_SIZE, 122, Short.MAX_VALUE)
					.addGap(915))
		);
		gl_painelBotoesCerveja.setVerticalGroup(
			gl_painelBotoesCerveja.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_painelBotoesCerveja.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_painelBotoesCerveja.createParallelGroup(Alignment.TRAILING)
						.addComponent(botaoComCerveja, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(rdbtnSemCerveja, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(10))
		);
		painelBotoesCerveja.setLayout(gl_painelBotoesCerveja);
		painelDelimitadorCerveja.setLayout(gl_painelDelimitadorCerveja);
		
		JLabel labelSalgados = new JLabel("Opções de salgado");
		labelSalgados.setFont(new Font("Arial", Font.PLAIN, 18));
		labelSalgados.setForeground(getCorTexto());
		
		JPanel painelBotoesSalgado = new JPanel();
		painelBotoesSalgado.setBackground(getCorDeJanelaInterna());
		painelBotoesSalgado.setBackground(getCorDeJanelaInterna());
		GroupLayout gl_painelDelimitadorSalgado = new GroupLayout(painelDelimitadorSalgado);
		gl_painelDelimitadorSalgado.setHorizontalGroup(
			gl_painelDelimitadorSalgado.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelDelimitadorSalgado.createSequentialGroup()
					.addGroup(gl_painelDelimitadorSalgado.createParallelGroup(Alignment.LEADING)
						.addComponent(labelSalgados, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
						.addComponent(painelBotoesSalgado, GroupLayout.PREFERRED_SIZE, 1116, Short.MAX_VALUE))
					.addGap(1))
		);
		gl_painelDelimitadorSalgado.setVerticalGroup(
			gl_painelDelimitadorSalgado.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelDelimitadorSalgado.createSequentialGroup()
					.addComponent(labelSalgados, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(painelBotoesSalgado, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
		);
		
		botaoSalgadoBolinhaDeQueijo = new JRadioButton("Bolinha de queijo");
		botaoSalgadoBolinhaDeQueijo.setForeground(getCorTexto());
		botaoSalgadoBolinhaDeQueijo.setFont(fonteRadioButtonSalgados);
		botaoSalgadoBolinhaDeQueijo.setBackground((Color) null);
		
		botaoSalgadoBolinhaDeQueijoComMilho = new JRadioButton("Bolinha de queijo com milho");
		botaoSalgadoBolinhaDeQueijoComMilho.setForeground(getCorTexto());
		botaoSalgadoBolinhaDeQueijoComMilho.setFont(fonteRadioButtonSalgados);
		botaoSalgadoBolinhaDeQueijoComMilho.setBackground((Color) null);
		
		botaoSalgadoRisolesDeFrango = new JRadioButton("Risoles de frango");
		botaoSalgadoRisolesDeFrango.setForeground(getCorTexto());
		botaoSalgadoRisolesDeFrango.setFont(fonteRadioButtonSalgados);
		botaoSalgadoRisolesDeFrango.setBackground((Color) null);
		
		botaoSalgadoRisolesDePresuntoQueijo = new JRadioButton("Risoles de presunto e queijo");
		botaoSalgadoRisolesDePresuntoQueijo.setForeground(getCorTexto());
		botaoSalgadoRisolesDePresuntoQueijo.setFont(fonteRadioButtonSalgados);
		botaoSalgadoRisolesDePresuntoQueijo.setBackground((Color) null);
		
		botaoSalgadoEnroladinhoPresuntoQueijo = new JRadioButton("Enroladinho de presunto e queijo");
		botaoSalgadoEnroladinhoPresuntoQueijo.setForeground(getCorTexto());
		botaoSalgadoEnroladinhoPresuntoQueijo.setFont(fonteRadioButtonSalgados);
		botaoSalgadoEnroladinhoPresuntoQueijo.setBackground((Color) null);
		
		botaoSalgadoEnroladinhoDeSalsicha = new JRadioButton("Enroladinho de salsicha");
		botaoSalgadoEnroladinhoDeSalsicha.setForeground(getCorTexto());
		botaoSalgadoEnroladinhoDeSalsicha.setFont(fonteRadioButtonSalgados);
		botaoSalgadoEnroladinhoDeSalsicha.setBackground((Color) null);
		
		botaoSalgadoCoxinhaDeFrango = new JRadioButton("Coxinha de frango");
		botaoSalgadoCoxinhaDeFrango.setForeground(getCorTexto());
		botaoSalgadoCoxinhaDeFrango.setFont(fonteRadioButtonSalgados);
		botaoSalgadoCoxinhaDeFrango.setBackground((Color) null);
		
		botaoSalgadoCoxinhaDeFrangoComCatupiry = new JRadioButton("Coxinha de frango com catupiry");
		botaoSalgadoCoxinhaDeFrangoComCatupiry.setForeground(getCorTexto());
		botaoSalgadoCoxinhaDeFrangoComCatupiry.setFont(fonteRadioButtonSalgados);
		botaoSalgadoCoxinhaDeFrangoComCatupiry.setBackground((Color) null);
		
		botaoSalgadoRisolesDeCarne = new JRadioButton("Risoles de carne");
		botaoSalgadoRisolesDeCarne.setForeground(getCorTexto());
		botaoSalgadoRisolesDeCarne.setFont(fonteRadioButtonSalgados);
		botaoSalgadoRisolesDeCarne.setBackground((Color) null);
		
		botaoSalgadoQuibe = new JRadioButton("Quibe");
		botaoSalgadoQuibe.setForeground(getCorTexto());
		botaoSalgadoQuibe.setFont(fonteRadioButtonSalgados);
		botaoSalgadoQuibe.setBackground((Color) null);
		
		botaoSalgadoEsfihaDeCarne = new JRadioButton("Esfiha de carne");
		botaoSalgadoEsfihaDeCarne.setForeground(getCorTexto());
		botaoSalgadoEsfihaDeCarne.setFont(fonteRadioButtonSalgados);
		botaoSalgadoEsfihaDeCarne.setBackground((Color) null);
		
		botaoSalgadoEmpadinhaDePalmito = new JRadioButton("Empadinha de palmito");
		botaoSalgadoEmpadinhaDePalmito.setForeground(getCorTexto());
		botaoSalgadoEmpadinhaDePalmito.setFont(fonteRadioButtonSalgados);
		botaoSalgadoEmpadinhaDePalmito.setBackground((Color) null);
		
		GroupLayout gl_painelBotoesSalgado = new GroupLayout(painelBotoesSalgado);
		gl_painelBotoesSalgado.setHorizontalGroup(
			gl_painelBotoesSalgado.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelBotoesSalgado.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_painelBotoesSalgado.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelBotoesSalgado.createSequentialGroup()
							.addComponent(botaoSalgadoBolinhaDeQueijo)
							.addGap(5)
							.addComponent(botaoSalgadoBolinhaDeQueijoComMilho, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(botaoSalgadoRisolesDeFrango, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(botaoSalgadoRisolesDePresuntoQueijo, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(botaoSalgadoEnroladinhoPresuntoQueijo, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_painelBotoesSalgado.createSequentialGroup()
							.addComponent(botaoSalgadoCoxinhaDeFrango, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(botaoSalgadoCoxinhaDeFrangoComCatupiry, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(botaoSalgadoRisolesDeCarne, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(botaoSalgadoQuibe, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(botaoSalgadoEsfihaDeCarne, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(botaoSalgadoEmpadinhaDePalmito, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(botaoSalgadoEnroladinhoDeSalsicha, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		gl_painelBotoesSalgado.setVerticalGroup(
			gl_painelBotoesSalgado.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelBotoesSalgado.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_painelBotoesSalgado.createParallelGroup(Alignment.LEADING)
						.addComponent(botaoSalgadoCoxinhaDeFrango, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(botaoSalgadoCoxinhaDeFrangoComCatupiry, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(botaoSalgadoRisolesDeCarne, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(botaoSalgadoQuibe, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(botaoSalgadoEsfihaDeCarne, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painelBotoesSalgado.createParallelGroup(Alignment.BASELINE)
							.addComponent(botaoSalgadoEmpadinhaDePalmito, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addComponent(botaoSalgadoEnroladinhoDeSalsicha, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addGroup(gl_painelBotoesSalgado.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(botaoSalgadoEnroladinhoPresuntoQueijo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painelBotoesSalgado.createParallelGroup(Alignment.LEADING, false)
							.addComponent(botaoSalgadoRisolesDeFrango, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(botaoSalgadoRisolesDePresuntoQueijo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(botaoSalgadoBolinhaDeQueijo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(botaoSalgadoBolinhaDeQueijoComMilho, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(10))
		);
		painelBotoesSalgado.setLayout(gl_painelBotoesSalgado);
		painelDelimitadorSalgado.setLayout(gl_painelDelimitadorSalgado);
		painel.setLayout(null);
		painel.add(painelVoltaPagina);
		painel.add(painelAvancaPagina);
		painel.add(labelTitulo);
		painel.add(painelRetornaTudo);
		painel.add(painelDelimitadorDoceBoloCerveja);
		painel.add(painelDelimitadorSalgado);
		
		
	}

	@Override
	public JPanel getPainel() {
		return painel;
	}

	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub
		
	}
}
