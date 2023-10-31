package telas;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import componentesDeTelas.ListenerRetornaTudo;
import componentesDeTelas.RoundJFormattedTextField;
import componentesDeTelas.RoundJPanel;
import componentesDeTelas.RoundJTextField;
import controladoras.ControladoraGerenciarCliente;
import controladoras.ControladoraJanela;
import controladoras.ControladoraOrcamentoDeBuffetCompleto;
import excecoes.ExcecaoDDDInvalido;
import excecoes.ExcecaoParametroPreenchidoErrado;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import classes.Cliente;

public class PainelCriarOuAtualizarCliente extends Painel {

	private JPanel painel;
	
	private JLabel labelTituloTela;
	
	private RoundJTextField inputNomeCompleto;					// OBRIGATORIO
	private RoundJFormattedTextField inputCPF;					// OBRIGATORIO
	private RoundJTextField inputRG;							// OPCIONAL
	private RoundJTextField inputEmail;							// OBRIGATORIO
	private RoundJTextField inputAlternado;						// OBRIGATORIO
	private RoundJTextField inputCEP;							// OBRIGATORIO
	private RoundJFormattedTextField inputCelular;				// OBRIGATORIO
	private RoundJFormattedTextField inputTelefoneResidencial;	// OPCIONAL
	private RoundJFormattedTextField inputTelefoneComercial;	// OPCIONAL
	
	private RoundJPanel painelErro;
	
	private JPanel painelDelimitadorNomeCompleto;
	private JPanel painelDelimitadorCPF;
	private JPanel painelDelimitadorRG;
	private JPanel painelDelimitadorEmail;
	private JPanel painelDelimitadorCEP;
	private JPanel painelDelimitadorCelular;
	private JPanel painelDelimitadorTelefoneResidencial;
	private JPanel painelDelimitadorTelefoneComercial;
	
	private JLabel labelAlternado;
	private boolean usuarioJaPesquisado;
	private Cliente cliente;
	
	public PainelCriarOuAtualizarCliente(PainelOrganizadorOrcamentoDeBuffetCompleto organizador) {
		
		painel = new JPanel();
		painel.setBackground(getCorDeFundo());
		Painel estePainel = this;
		
		labelTituloTela = new JLabel("Cliente");
		labelTituloTela.setFont(getFonteTitulo());
		
		JPanel painelPaginaAnterior = new JPanel();
		JPanel painelProximaPagina = new JPanel();
		JPanel painelRetornaTudo = new JPanel();
		painelErro = new RoundJPanel(25, 25, 25, 25);
		usuarioJaPesquisado = false;
		cliente = null;

		painelPaginaAnterior.setBackground(getCorDeFundo());
		painelProximaPagina.setBackground(getCorDeFundo());
		painelRetornaTudo.setBackground(getCorDeFundo());
		painelErro.setBackground(getCorDeJanelaInterna());
		
		JPanel painelDelimitadorCampos = new JPanel();
		painelDelimitadorCampos.setBackground(getCorDeFundo());
		painelDelimitadorCampos.setLayout(new GridLayout(3, 3, 20, 20));
		
		painelDelimitadorNomeCompleto = new JPanel();
		painelDelimitadorNomeCompleto.setBorder(new EmptyBorder(0, 0, 0, 0));
		painelDelimitadorNomeCompleto.setBackground(getCorDeFundo());
		painelDelimitadorCampos.add(painelDelimitadorNomeCompleto);
		painelDelimitadorNomeCompleto.setLayout(new GridLayout(1, 0, 0, 0));
		painelDelimitadorNomeCompleto.setVisible(false);
		
		RoundJPanel painelNomeCompleto = new RoundJPanel(25, 25, 25, 25);
		painelNomeCompleto.setBorder(new EmptyBorder(20, 20, 20, 20));
		painelNomeCompleto.setBackground(getCorDeJanelaInterna());
		painelDelimitadorNomeCompleto.add(painelNomeCompleto);
		
		JLabel labelNomeCompleto = new JLabel("Nome completo");
		labelNomeCompleto.setFont(getFonteLabelInterno());
		labelNomeCompleto.setForeground(getCorTexto());
		inputNomeCompleto = new RoundJTextField(25);
		inputNomeCompleto.setColumns(10);
		inputNomeCompleto.setFont(getFonteInputs());
		GroupLayout gl_painelNomeCompleto = new GroupLayout(painelNomeCompleto);
		gl_painelNomeCompleto.setHorizontalGroup(
			gl_painelNomeCompleto.createParallelGroup(Alignment.LEADING)
				.addComponent(inputNomeCompleto, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_painelNomeCompleto.createSequentialGroup()
					.addGap(5)
					.addComponent(labelNomeCompleto, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
		);
		gl_painelNomeCompleto.setVerticalGroup(
			gl_painelNomeCompleto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelNomeCompleto.createSequentialGroup()
					.addComponent(labelNomeCompleto, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addGap(5)
					.addComponent(inputNomeCompleto, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
		);
		painelNomeCompleto.setLayout(gl_painelNomeCompleto);
		
		painelDelimitadorCPF = new JPanel();
		painelDelimitadorCPF.setBackground(getCorDeFundo());
		painelDelimitadorCampos.add(painelDelimitadorCPF);
		painelDelimitadorCPF.setLayout(new GridLayout(1, 0, 0, 0));
		painelDelimitadorCPF.setVisible(false);
		
		RoundJPanel painelCPF = new RoundJPanel(25, 25, 25, 25);
		painelCPF.setBorder(new EmptyBorder(20, 15, 20, 15));
		painelCPF.setBackground(getCorDeJanelaInterna());
		painelDelimitadorCPF.add(painelCPF);
		
		JLabel labelCPF = new JLabel("CPF");
		labelCPF.setFont(getFonteLabelInterno());
		labelCPF.setForeground(getCorTexto());
		
		inputCPF = new RoundJFormattedTextField(25);
		inputCPF.setColumns(10);
		inputCPF.setFont(getFonteInputs());
		
		try {
			MaskFormatter mascara;
			mascara = new MaskFormatter("###.###.###-##");
			mascara.install(inputCPF);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		GroupLayout gl_painelCPF = new GroupLayout(painelCPF);
		gl_painelCPF.setHorizontalGroup(
			gl_painelCPF.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelCPF.createSequentialGroup()
					.addGroup(gl_painelCPF.createParallelGroup(Alignment.LEADING)
						.addComponent(labelCPF, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
						.addComponent(inputCPF, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
					.addGap(0))
		);
		gl_painelCPF.setVerticalGroup(
			gl_painelCPF.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelCPF.createSequentialGroup()
					.addComponent(labelCPF, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(inputCPF, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
		);
		painelCPF.setLayout(gl_painelCPF);
		
		painelDelimitadorRG = new JPanel();
		painelDelimitadorRG.setBackground(getCorDeFundo());
		painelDelimitadorCampos.add(painelDelimitadorRG);
		painelDelimitadorRG.setLayout(new GridLayout(1, 0, 0, 0));
		painelDelimitadorRG.setVisible(false);
		
		RoundJPanel painelRG = new RoundJPanel(25, 25, 25, 25);
		painelRG.setBorder(new EmptyBorder(20, 15, 20, 15));
		painelRG.setBackground(getCorDeJanelaInterna());
		painelDelimitadorRG.add(painelRG);
		
		JLabel labelRG = new JLabel("RG");
		labelRG.setFont(getFonteLabelInterno());
		labelRG.setForeground(getCorTexto());
		
		inputRG = new RoundJTextField(25);
		inputRG.setColumns(10);
		inputRG.setFont(getFonteInputs());
		
		GroupLayout gl_painelRG = new GroupLayout(painelRG);
		gl_painelRG.setHorizontalGroup(
			gl_painelRG.createParallelGroup(Alignment.LEADING)
				.addComponent(labelRG, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
				.addComponent(inputRG, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
		);
		gl_painelRG.setVerticalGroup(
			gl_painelRG.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelRG.createSequentialGroup()
					.addComponent(labelRG, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(inputRG, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
		);
		painelRG.setLayout(gl_painelRG);
		
		
		painelDelimitadorEmail = new JPanel();
		painelDelimitadorEmail.setBackground(getCorDeFundo());
		painelDelimitadorCampos.add(painelDelimitadorEmail);
		painelDelimitadorEmail.setLayout(new GridLayout(1, 0, 0, 0));
		painelDelimitadorEmail.setVisible(false);
		
		RoundJPanel painelEmail = new RoundJPanel(25, 25, 25, 25);
		painelEmail.setBorder(new EmptyBorder(20, 15, 20, 15));
		painelEmail.setBackground(getCorDeJanelaInterna());
		painelDelimitadorEmail.add(painelEmail);
		
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setFont(getFonteLabelInterno());
		labelEmail.setForeground(getCorTexto());
		
		inputEmail = new RoundJTextField(25);
		inputEmail.setColumns(10);
		inputEmail.setFont(getFonteInputs());
		
		GroupLayout gl_painelEmail = new GroupLayout(painelEmail);
		gl_painelEmail.setHorizontalGroup(
			gl_painelEmail.createParallelGroup(Alignment.LEADING)
				.addComponent(labelEmail, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
				.addComponent(inputEmail, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
		);
		gl_painelEmail.setVerticalGroup(
			gl_painelEmail.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelEmail.createSequentialGroup()
					.addComponent(labelEmail, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(inputEmail, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
		);
		painelEmail.setLayout(gl_painelEmail);
		
		JPanel painelDelimitadorAlternado = new JPanel();
		painelDelimitadorAlternado.setBackground(getCorDeFundo());
		painelDelimitadorCampos.add(painelDelimitadorAlternado);
		painelDelimitadorAlternado.setLayout(new GridLayout(1, 0, 0, 0));
		
		RoundJPanel painelAlternado = new RoundJPanel(25, 25, 25, 25);
		painelAlternado.setBorder(new EmptyBorder(20, 15, 20, 15));
		painelAlternado.setBackground(getCorDeJanelaInterna());
		painelDelimitadorAlternado.add(painelAlternado);
		
		labelAlternado = new JLabel("CPF");
		labelAlternado.setFont(getFonteLabelInterno());
		labelAlternado.setForeground(getCorTexto());
		
		inputAlternado = new RoundJTextField(25);
		inputAlternado.setColumns(10);
		inputAlternado.setFont(getFonteInputs());
		
		GroupLayout gl_painelAlternado = new GroupLayout(painelAlternado);
		gl_painelAlternado.setHorizontalGroup(
			gl_painelAlternado.createParallelGroup(Alignment.LEADING)
				.addComponent(labelAlternado, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
				.addComponent(inputAlternado, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
		);
		gl_painelAlternado.setVerticalGroup(
			gl_painelAlternado.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelAlternado.createSequentialGroup()
					.addComponent(labelAlternado, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(inputAlternado, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
		);
		painelAlternado.setLayout(gl_painelAlternado);
		
		painelDelimitadorCEP = new JPanel();
		painelDelimitadorCEP.setBackground(getCorDeFundo());
		painelDelimitadorCampos.add(painelDelimitadorCEP);
		painelDelimitadorCEP.setLayout(new GridLayout(1, 0, 0, 0));
		painelDelimitadorCEP.setVisible(false);
		
		RoundJPanel painelCEP = new RoundJPanel(25, 25, 25, 25);
		painelCEP.setBorder(new EmptyBorder(20, 15, 20, 15));
		painelCEP.setBackground(getCorDeJanelaInterna());
		painelDelimitadorCEP.add(painelCEP);
		
		JLabel labelCEP = new JLabel("CEP");
		labelCEP.setFont(getFonteLabelInterno());
		labelCEP.setForeground(getCorTexto());
		
		inputCEP = new RoundJTextField(25);
		inputCEP.setColumns(10);
		inputCEP.setFont(getFonteInputs());
		
		GroupLayout gl_painelCEP = new GroupLayout(painelCEP);
		gl_painelCEP.setHorizontalGroup(
			gl_painelCEP.createParallelGroup(Alignment.LEADING)
				.addComponent(labelCEP, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
				.addComponent(inputCEP, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
		);
		gl_painelCEP.setVerticalGroup(
			gl_painelCEP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelCEP.createSequentialGroup()
					.addComponent(labelCEP, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(inputCEP, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
		);
		painelCEP.setLayout(gl_painelCEP);
		
		painelDelimitadorCelular = new JPanel();
		painelDelimitadorCelular.setBackground(getCorDeFundo());
		painelDelimitadorCampos.add(painelDelimitadorCelular);
		painelDelimitadorCelular.setLayout(new GridLayout(1, 0, 0, 0));
		painelDelimitadorCelular.setVisible(false);
		
		RoundJPanel painelCelular = new RoundJPanel(25, 25, 25, 25);
		painelCelular.setBorder(new EmptyBorder(20, 15, 20, 15));
		painelCelular.setBackground(getCorDeJanelaInterna());
		painelDelimitadorCelular.add(painelCelular);
		
		JLabel labelCelular = new JLabel("Celular");
		labelCelular.setFont(getFonteLabelInterno());
		labelCelular.setForeground(getCorTexto());
		
		inputCelular = new RoundJFormattedTextField(25);
		inputCelular.setColumns(10);
		inputCelular.setFont(getFonteInputs());
		
		try {
			MaskFormatter mascara;
			mascara = new MaskFormatter("## #####-####");
			mascara.install(inputCelular);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		GroupLayout gl_painelCelular = new GroupLayout(painelCelular);
		gl_painelCelular.setHorizontalGroup(
			gl_painelCelular.createParallelGroup(Alignment.LEADING)
				.addComponent(labelCelular, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
				.addComponent(inputCelular, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
		);
		gl_painelCelular.setVerticalGroup(
			gl_painelCelular.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelCelular.createSequentialGroup()
					.addComponent(labelCelular, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(inputCelular, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
		);
		painelCelular.setLayout(gl_painelCelular);
		
		painelDelimitadorTelefoneResidencial = new JPanel();
		painelDelimitadorTelefoneResidencial.setBackground(getCorDeFundo());
		painelDelimitadorCampos.add(painelDelimitadorTelefoneResidencial);
		painelDelimitadorTelefoneResidencial.setLayout(new GridLayout(1, 0, 0, 0));
		painelDelimitadorTelefoneResidencial.setVisible(false);
		
		RoundJPanel painelTelefoneResidencial = new RoundJPanel(25, 25, 25, 25);
		painelTelefoneResidencial.setBorder(new EmptyBorder(20, 15, 20, 15));
		painelTelefoneResidencial.setBackground(getCorDeJanelaInterna());
		painelDelimitadorTelefoneResidencial.add(painelTelefoneResidencial);
		
		JLabel labelTelefoneResidencial = new JLabel("Telefone residencial");
		labelTelefoneResidencial.setFont(getFonteLabelInterno());
		labelTelefoneResidencial.setForeground(getCorTexto());
		
		inputTelefoneResidencial = new RoundJFormattedTextField(25);
		inputTelefoneResidencial.setColumns(10);
		inputTelefoneResidencial.setFont(getFonteInputs());
		
		try {
			MaskFormatter mascara;
			mascara = new MaskFormatter("## ####-####");
			mascara.install(inputTelefoneResidencial);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		GroupLayout gl_painelTelefoneResidencial = new GroupLayout(painelTelefoneResidencial);
		gl_painelTelefoneResidencial.setHorizontalGroup(
			gl_painelTelefoneResidencial.createParallelGroup(Alignment.LEADING)
				.addComponent(labelTelefoneResidencial, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
				.addComponent(inputTelefoneResidencial, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
		);
		gl_painelTelefoneResidencial.setVerticalGroup(
			gl_painelTelefoneResidencial.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelTelefoneResidencial.createSequentialGroup()
					.addComponent(labelTelefoneResidencial, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(inputTelefoneResidencial, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
		);
		painelTelefoneResidencial.setLayout(gl_painelTelefoneResidencial);
		
		painelDelimitadorTelefoneComercial = new JPanel();
		painelDelimitadorTelefoneComercial.setBackground(getCorDeFundo());
		painelDelimitadorCampos.add(painelDelimitadorTelefoneComercial);
		painelDelimitadorTelefoneComercial.setLayout(new GridLayout(1, 0, 0, 0));
		painelDelimitadorTelefoneComercial.setVisible(false);
		
		RoundJPanel painelTelefoneComercial = new RoundJPanel(25, 25, 25, 25);
		painelTelefoneComercial.setBorder(new EmptyBorder(20, 15, 20, 15));
		painelTelefoneComercial.setBackground(getCorDeJanelaInterna());
		painelDelimitadorTelefoneComercial.add(painelTelefoneComercial);
		
		JLabel labelTelefoneComercial = new JLabel("Telefone comercial");
		labelTelefoneComercial.setFont(getFonteLabelInterno());
		labelTelefoneComercial.setForeground(getCorTexto());
		
		inputTelefoneComercial = new RoundJFormattedTextField(25);
		inputTelefoneComercial.setColumns(10);
		inputTelefoneComercial.setFont(getFonteInputs());
		
		try {
			MaskFormatter mascara;
			mascara = new MaskFormatter("## #####-####");
			mascara.install(inputTelefoneComercial);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		GroupLayout gl_painelTelefoneComercial = new GroupLayout(painelTelefoneComercial);
		gl_painelTelefoneComercial.setHorizontalGroup(
			gl_painelTelefoneComercial.createParallelGroup(Alignment.LEADING)
				.addComponent(labelTelefoneComercial, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
				.addComponent(inputTelefoneComercial, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
		);
		gl_painelTelefoneComercial.setVerticalGroup(
			gl_painelTelefoneComercial.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelTelefoneComercial.createSequentialGroup()
					.addComponent(labelTelefoneComercial, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(inputTelefoneComercial, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
		);
		
		painelTelefoneComercial.setLayout(gl_painelTelefoneComercial);
		painelPaginaAnterior.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel labelPaginaAnterior = new JLabel("");
		labelPaginaAnterior.addMouseListener(new MouseListener() {
			
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
		
		labelPaginaAnterior.setIcon(getIconeVoltarPagina());
		painelPaginaAnterior.add(labelPaginaAnterior);
		painelProximaPagina.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel labelProximaPagina = new JLabel("");
		
		labelProximaPagina.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {/* Não faz nada */}
			@Override
			public void mouseReleased(MouseEvent e) { /* Não faz nada */ }
			
			@Override
			public void mousePressed(MouseEvent e) { 
				
				if (usuarioJaPesquisado == false) {
					
					if (ControladoraOrcamentoDeBuffetCompleto.verificarCPF(inputAlternado.getText())) {
						usuarioJaPesquisado = true;
						
						cliente = ControladoraGerenciarCliente.getCliente(inputAlternado.getText());
						
						if (cliente == null) {
							ControladoraJanela.ativarPopUp(estePainel, "Cliente não cadastrado", "Para continuar, efetue o cadastro do cliente", "Cadastrar Cliente");
							inputCPF.setText(inputAlternado.getText());
							inputAlternado.setText("");
							labelTituloTela.setText("Cadastrar Cliente");
							
						} else {
							JOptionPane.showMessageDialog(null, "Cliente já cadastrado, carregando dados...");
							labelTituloTela.setText("Atualizar Cliente");
							
							inputNomeCompleto.setText(cliente.getNome());
							inputCPF.setText(cliente.getCpf());
							inputRG.setText(cliente.getRg() == null ? "" : cliente.getRg());
							inputEmail.setText(cliente.getEmail());
							inputAlternado.setText(cliente.getEndereco());
							inputCEP.setText(cliente.getCep());
							inputCelular.setText(cliente.getCelular());
							inputTelefoneResidencial.setText(cliente.getTelefoneResidencial() == null ? "" : cliente.getTelefoneResidencial());
							inputTelefoneComercial.setText(cliente.getTelefoneComercial() == null ? "" : cliente.getTelefoneComercial());
						}
						
						labelAlternado.setText("Endereço");
						painelDelimitadorNomeCompleto.setVisible(true);
						painelDelimitadorCPF.setVisible(true);
						painelDelimitadorRG.setVisible(true);
						painelDelimitadorEmail.setVisible(true);
						painelDelimitadorCEP.setVisible(true);
						painelDelimitadorCelular.setVisible(true);
						painelDelimitadorTelefoneResidencial.setVisible(true);
						painelDelimitadorTelefoneComercial.setVisible(true);
						
						painel.repaint();
					
					} else {
						ControladoraJanela.ativarPopUp(estePainel, "CPF informado está inválido", "Para continuar, forneça um CPF válido", "Preencher CPF");
					}
					
					return;
				}
				
				if (ControladoraOrcamentoDeBuffetCompleto.verificarNomeCompleto(inputNomeCompleto.getText()) == false) {
					ControladoraJanela.ativarPopUp(estePainel, "Nome informado está inválido", "Para continuar, forneça um nome válido", "Preencher Nome");
					painelErro.setVisible(true);
					return;
				}
				
				if (ControladoraOrcamentoDeBuffetCompleto.verificarCPF(inputCPF.getText()) == false) {
					ControladoraJanela.ativarPopUp(estePainel, "CPF informado está inválido", "Para continuar, forneça um CPF válido", "Preencher CPF");
					painelErro.setVisible(true);
					return;
				}

				if (ControladoraOrcamentoDeBuffetCompleto.verificarEmail(inputEmail.getText()) == false) {
					ControladoraJanela.ativarPopUp(estePainel, "Email está inválido", "Para continuar, forneça um Email válido", "Preencher Email");
					painelErro.setVisible(true);
					return;
				}

				if (inputAlternado.getText().isBlank() || inputAlternado.getText().isEmpty()) {
					ControladoraJanela.ativarPopUp(estePainel, "Endereço não está preenchido", "Para continuar, preencha o campo Endereço", "Preencher Endereço");
					painelErro.setVisible(true);
					return;
				}
				
				if (ControladoraOrcamentoDeBuffetCompleto.verificarCEP(inputCEP.getText()) == false) {
					ControladoraJanela.ativarPopUp(estePainel, "CEP está inválido", "Para continuar, forneça um CEP válido", "Preencher CEP");
					painelErro.setVisible(true);
					return;
				}
				
				try {
					if (ControladoraOrcamentoDeBuffetCompleto.verificarCelular(inputCelular.getText()) == false) {
						ControladoraJanela.ativarPopUp(estePainel, "Celular está inválido", "Para continuar, forneça um Celular válido", "Preencher Celular");
						painelErro.setVisible(true);
						return;
					}					
				} catch (ExcecaoDDDInvalido eDDD) {
					ControladoraJanela.ativarPopUp(estePainel, "DDD informado está inválido", "Para continuar, forneça um DDD válido", "Preencher DDD");
					painelErro.setVisible(true);
					return;
				}
				
				String cpf = inputCPF.getText();
				cpf = cpf.replace(".", "");
				cpf = cpf.replace("-", "");
				
				cliente = new Cliente(inputNomeCompleto.getText(), cpf, inputAlternado.getText(), inputCEP.getText(), inputCelular.getText(), inputEmail.getText());						
				
				if (inputRG.getText().isBlank() == false && inputRG.getText().isEmpty() == false) {
					cliente.setRg(inputRG.getText());
				}
				
				if (inputTelefoneResidencial.getText().equals("       -    ") == false) {
					try {
						cliente.setTelefoneResidencial(inputTelefoneResidencial.getText());
						
					} catch (ExcecaoDDDInvalido | ExcecaoParametroPreenchidoErrado | NumberFormatException erro) {
						ControladoraJanela.ativarPopUp(estePainel, "Telefone Residencial", "Para continuar, insira um telefone válido", "Mudar Telefone Residencial");
						cliente = null;
						return;
					}
				}
				
				if (inputTelefoneComercial.getText().equals("        -    ") == false) {
					try {
						cliente.setTelefoneComercial(inputTelefoneComercial.getText());
						
					} catch (ExcecaoDDDInvalido | ExcecaoParametroPreenchidoErrado | NumberFormatException erro) {
						ControladoraJanela.ativarPopUp(estePainel, "Telefone Comercial", "Para continuar, insira um celular válido", "Mudar Telefone Comercial");
						cliente = null;
						return;
					}
				}
				
				organizador.proximaPagina();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) { /* Não faz nada */ }
			
			@Override
			public void mouseEntered(MouseEvent e) { /* Não faz nada */ }
		});
		labelProximaPagina.setIcon(getIconeProximaPagina());
		painelProximaPagina.add(labelProximaPagina);
		painelRetornaTudo.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel labelRetornaTudo = new JLabel("");
		labelRetornaTudo.addMouseListener(new ListenerRetornaTudo(organizador));
		labelRetornaTudo.setIcon(getIconeRetornaTudo());
		painelRetornaTudo.add(labelRetornaTudo);
		GroupLayout gl_painel = new GroupLayout(painel);
		gl_painel.setHorizontalGroup(
			gl_painel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel.createSequentialGroup()
					.addGap(67)
					.addComponent(labelTituloTela, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE)
					.addGap(505)
					.addComponent(painelRetornaTudo, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_painel.createSequentialGroup()
					.addGap(10)
					.addComponent(painelDelimitadorCampos, GroupLayout.PREFERRED_SIZE, 1157, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_painel.createSequentialGroup()
					.addGap(20)
					.addComponent(painelPaginaAnterior, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(310)
					.addComponent(painelErro, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
					.addGap(360)
					.addComponent(painelProximaPagina, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
		);
		gl_painel.setVerticalGroup(
			gl_painel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_painel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel.createSequentialGroup()
							.addGap(20)
							.addComponent(labelTituloTela, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addComponent(painelRetornaTudo, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(painelDelimitadorCampos, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addGroup(gl_painel.createParallelGroup(Alignment.LEADING)
						.addComponent(painelPaginaAnterior, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(painelProximaPagina, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(painelErro, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))))
		);
		
		JLabel iconeErro = new JLabel("");
		iconeErro.setIcon(new ImageIcon("imgs/erroPequeno.png"));
		
		JLabel labelErro = new JLabel("Preencha todos os campos");
		labelErro.setFont(getFonteLabelInterno());
		labelErro.setForeground(getCorTextoErro());
		
		GroupLayout gl_painelErro = new GroupLayout(painelErro);
		gl_painelErro.setHorizontalGroup(
			gl_painelErro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelErro.createSequentialGroup()
					.addContainerGap()
					.addComponent(iconeErro, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(labelErro, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
					.addGap(14))
		);
		gl_painelErro.setVerticalGroup(
			gl_painelErro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelErro.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_painelErro.createParallelGroup(Alignment.LEADING)
						.addComponent(labelErro, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
						.addComponent(iconeErro, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		painelErro.setLayout(gl_painelErro);
		painel.setLayout(gl_painel);
		painelErro.setVisible(false);
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	@Override 
	protected void configurarBotoes() {
		// TODO
	}
	
	@Override
	public JPanel getPainel() {
		return painel;
	}

	@Override
	public void limparCampos() {
		labelTituloTela.setText("Cliente");
		labelAlternado.setText("CPF");
		usuarioJaPesquisado = false;
		cliente = null;
		
		inputNomeCompleto.setText("");
		inputCPF.setText("");
		inputRG.setText("");
		inputEmail.setText("");
		inputAlternado.setText("");
		inputCEP.setText("");
		inputCelular.setText("");
		inputTelefoneResidencial.setText("");
		inputTelefoneComercial.setText("");
		
		painelDelimitadorNomeCompleto.setVisible(false);
		painelDelimitadorCPF.setVisible(false);
		painelDelimitadorRG.setVisible(false);
		painelDelimitadorEmail.setVisible(false);
		painelDelimitadorCEP.setVisible(false);
		painelDelimitadorCelular.setVisible(false);
		painelDelimitadorTelefoneResidencial.setVisible(false);
		painelDelimitadorTelefoneComercial.setVisible(false);
		
		painelErro.setVisible(false);
		
	}
}
