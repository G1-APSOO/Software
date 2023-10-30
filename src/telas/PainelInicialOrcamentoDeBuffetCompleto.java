package telas;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import componentesDeTelas.ListenerRetornaTudo;
import componentesDeTelas.RoundJFormattedTextField;
import componentesDeTelas.RoundJPanel;
import javax.swing.JFormattedTextField;

public class PainelInicialOrcamentoDeBuffetCompleto extends Painel {

	private JPanel painel;
	
	private PainelOrganizadorOrcamentoDeBuffetCompleto organizador;
	
	private RoundJFormattedTextField inputNumeroDeConvidados;
	private RoundJFormattedTextField inputNumeroDeColaboradores;
	private RoundJFormattedTextField inputData;
	private RoundJFormattedTextField inputHoraDeInicio;
	private JLabel labelRetornarTudo;
	private JLabel labelAvancar;
	
	public PainelInicialOrcamentoDeBuffetCompleto(PainelOrganizadorOrcamentoDeBuffetCompleto organizador) {
		super();
		
		this.organizador = organizador;
		
		painel = new JPanel();
		painel.setBackground(getCorDeFundo());
		
		JLabel labelTitulo = new JLabel("Informações do evento");
		labelTitulo.setBounds(40, 34, 571, 85);
		labelTitulo.setForeground(getCorTitulo());
		labelTitulo.setFont(getFonteTitulo());
		
		JPanel painelDivisor = new JPanel();
		painelDivisor.setBounds(40, 125, 1180, 344);
		painelDivisor.setBackground(getCorDeFundo());
		
		JPanel painelAvancar = new JPanel();
		painelAvancar.setBounds(1177, 577, 70, 70);
		painelAvancar.setBackground(getCorDeFundo());
		
		JPanel painelVoltarTudo = new JPanel();
		painelVoltarTudo.setBounds(1177, 20, 70, 70);
		painelVoltarTudo.setBackground(getCorDeFundo());
		painelVoltarTudo.setLayout(new GridLayout(0, 1, 0, 0));
		
		setLabelRetornarTudo(new ListenerRetornaTudo(organizador));
		painelVoltarTudo.add(labelRetornarTudo);
		painelAvancar.setLayout(new GridLayout(0, 1, 0, 0));
		
		setLabelAvancar();
		painelAvancar.add(labelAvancar);
		painelDivisor.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel painelNumeroDeConvidados = new JPanel();
		painelNumeroDeConvidados.setBackground(getCorDeFundo());
		painelDivisor.add(painelNumeroDeConvidados);
		
		RoundJPanel painelInternoNumeroDeConvidados = new RoundJPanel(25, 25, 25, 25);
		painelInternoNumeroDeConvidados.setBackground(getCorDeJanelaInterna());
		painelInternoNumeroDeConvidados.setBorder(new EmptyBorder(30, 20, 30, 20));
		painelInternoNumeroDeConvidados.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNumeroDeConvidados = new JLabel(" Nº de convidados");
		labelNumeroDeConvidados.setForeground(getCorTexto());
		labelNumeroDeConvidados.setFont(getFonteLabelInterno());
		painelInternoNumeroDeConvidados.add(labelNumeroDeConvidados);
		
		setInputNumeroDeConvidados();
		painelInternoNumeroDeConvidados.add(inputNumeroDeConvidados);
		GroupLayout gl_painelNumeroDeConvidados = new GroupLayout(painelNumeroDeConvidados);
		gl_painelNumeroDeConvidados.setHorizontalGroup(
			gl_painelNumeroDeConvidados.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_painelNumeroDeConvidados.createSequentialGroup()
					.addGap(15)
					.addComponent(painelInternoNumeroDeConvidados, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
					.addGap(30))
		);
		gl_painelNumeroDeConvidados.setVerticalGroup(
			gl_painelNumeroDeConvidados.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelNumeroDeConvidados.createSequentialGroup()
					.addGap(12)
					.addComponent(painelInternoNumeroDeConvidados, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
					.addGap(12))
		);
		painelNumeroDeConvidados.setLayout(gl_painelNumeroDeConvidados);
		
		JPanel painelNumeroDeColaboradores = new JPanel();
		painelNumeroDeColaboradores.setBackground(getCorDeFundo());
		painelDivisor.add(painelNumeroDeColaboradores);
		
		RoundJPanel painelInternoNumeroDeColaboradores = new RoundJPanel(25, 25, 25, 25);
		painelInternoNumeroDeColaboradores.setBackground(getCorDeJanelaInterna());
		painelInternoNumeroDeColaboradores.setBorder(new EmptyBorder(30, 20, 30, 20));
		painelInternoNumeroDeColaboradores.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNumeroDeColaboradores = new JLabel(" Nº de colaboradores");
		labelNumeroDeColaboradores.setForeground(getCorTexto());
		labelNumeroDeColaboradores.setFont(getFonteLabelInterno());
		painelInternoNumeroDeColaboradores.add(labelNumeroDeColaboradores);
		
		setInputNumeroDeColaboradores();
		painelInternoNumeroDeColaboradores.add(inputNumeroDeColaboradores);
		GroupLayout gl_painelNumeroDeColaboradores = new GroupLayout(painelNumeroDeColaboradores);
		gl_painelNumeroDeColaboradores.setHorizontalGroup(
			gl_painelNumeroDeColaboradores.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelNumeroDeColaboradores.createSequentialGroup()
					.addGap(30)
					.addComponent(painelInternoNumeroDeColaboradores, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
					.addGap(15))
		);
		gl_painelNumeroDeColaboradores.setVerticalGroup(
			gl_painelNumeroDeColaboradores.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelNumeroDeColaboradores.createSequentialGroup()
					.addGap(12)
					.addComponent(painelInternoNumeroDeColaboradores, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
					.addGap(12))
		);
		painelNumeroDeColaboradores.setLayout(gl_painelNumeroDeColaboradores);
		
		JPanel painelData = new JPanel();
		painelData.setBackground(getCorDeFundo());
		painelDivisor.add(painelData);
		
		RoundJPanel painelInternoData = new RoundJPanel(25, 25, 25, 25);
		painelInternoData.setBackground(getCorDeJanelaInterna());
		painelInternoData.setBorder(new EmptyBorder(30, 20, 30, 20));
		painelInternoData.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelData = new JLabel(" Data");
		labelData.setForeground(getCorTexto());
		labelData.setFont(getFonteLabelInterno());
		painelInternoData.add(labelData);
		
		setInputData();
		painelInternoData.add(inputData);
		GroupLayout gl_painelData = new GroupLayout(painelData);
		gl_painelData.setHorizontalGroup(
			gl_painelData.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelData.createSequentialGroup()
					.addGap(15)
					.addComponent(painelInternoData, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
					.addGap(30))
		);
		gl_painelData.setVerticalGroup(
			gl_painelData.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelData.createSequentialGroup()
					.addGap(12)
					.addComponent(painelInternoData, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
					.addGap(12))
		);
		painelData.setLayout(gl_painelData);
		
		JPanel painelHoraDeInicio = new JPanel();
		painelHoraDeInicio.setBackground(getCorDeFundo());
		painelDivisor.add(painelHoraDeInicio);
		
		RoundJPanel painelInternoHoraDeInicio = new RoundJPanel(25, 25, 25, 25);
		painelInternoHoraDeInicio.setBackground(getCorDeJanelaInterna());
		painelInternoHoraDeInicio.setBorder(new EmptyBorder(30, 20, 30, 20));
		painelInternoHoraDeInicio.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelHoraDeInicio = new JLabel(" Hora de início do evento");
		labelHoraDeInicio.setForeground(getCorTexto());
		labelHoraDeInicio.setFont(getFonteLabelInterno());
		painelInternoHoraDeInicio.add(labelHoraDeInicio);
		
		setInputHoraDeInicio();
		painelInternoHoraDeInicio.add(inputHoraDeInicio);
		GroupLayout gl_painelHoraDeInicio = new GroupLayout(painelHoraDeInicio);
		gl_painelHoraDeInicio.setHorizontalGroup(
			gl_painelHoraDeInicio.createParallelGroup(Alignment.LEADING)
				.addGap(0, 600, Short.MAX_VALUE)
				.addGroup(gl_painelHoraDeInicio.createSequentialGroup()
					.addGap(30)
					.addComponent(painelInternoHoraDeInicio, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
					.addGap(15))
		);
		gl_painelHoraDeInicio.setVerticalGroup(
			gl_painelHoraDeInicio.createParallelGroup(Alignment.LEADING)
				.addGap(0, 172, Short.MAX_VALUE)
				.addGroup(gl_painelHoraDeInicio.createSequentialGroup()
					.addGap(12)
					.addComponent(painelInternoHoraDeInicio, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
					.addGap(12))
		);
		painelHoraDeInicio.setLayout(gl_painelHoraDeInicio);
		painel.setLayout(null);
		painel.add(labelTitulo);
		painel.add(painelVoltarTudo);
		painel.add(painelDivisor);
		painel.add(painelAvancar);
		
	}
	
	private void setInputNumeroDeConvidados() {
		inputNumeroDeConvidados = new RoundJFormattedTextField();
		inputNumeroDeConvidados.setFocusLostBehavior(JFormattedTextField.COMMIT);
		inputNumeroDeConvidados.setFont(getFonteInputs());
		
		try {
			MaskFormatter mascara;
			mascara = new MaskFormatter("###");
			mascara.install(inputNumeroDeConvidados);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private void setInputNumeroDeColaboradores() {
		inputNumeroDeColaboradores = new RoundJFormattedTextField();
		inputNumeroDeColaboradores.setFocusLostBehavior(JFormattedTextField.COMMIT);
		inputNumeroDeColaboradores.setFont(getFonteInputs());

		try {
			MaskFormatter mascara;
			mascara = new MaskFormatter("###");
			mascara.install(inputNumeroDeColaboradores);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private void setInputData() {
		inputData = new RoundJFormattedTextField();
		inputData.setFocusLostBehavior(JFormattedTextField.COMMIT);
		inputData.setFont(getFonteInputs());

		try {
			MaskFormatter mascara;
			mascara = new MaskFormatter("##/##/####");
			mascara.install(inputData);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	private void setInputHoraDeInicio() {
		inputHoraDeInicio = new RoundJFormattedTextField();
		inputHoraDeInicio.setFocusLostBehavior(JFormattedTextField.COMMIT);
		inputHoraDeInicio.setFont(getFonteInputs());

		try {
			MaskFormatter mascara;
			mascara = new MaskFormatter("##:##");
			mascara.install(inputHoraDeInicio);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private void setLabelRetornarTudo(ListenerRetornaTudo listenerRetornaTudo) {
		labelRetornarTudo = new JLabel("");
		labelRetornarTudo.setIcon(getIconeRetornaTudo());
		labelRetornarTudo.addMouseListener(listenerRetornaTudo);
	}
	
	private void setLabelAvancar() {
		labelAvancar = new JLabel("");
		labelAvancar.setIcon(getIconeProximaPagina());
		labelAvancar.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {/* Não faz nada */}
			@Override
			public void mouseReleased(MouseEvent e) { /* Não faz nada */ }
			
			@Override
			public void mousePressed(MouseEvent e) { 
				if(verificarPreenchimentoCampos())
					organizador.proximaPagina();
			}
			
			@Override
			public void mouseExited(MouseEvent e) { /* Não faz nada */ }
			
			@Override
			public void mouseEntered(MouseEvent e) { /* Não faz nada */ }
		});
	}
	
	public boolean verificarPreenchimentoCampos() {
		try {
			boolean estaVazio;
			boolean resposta = true;
			
			estaVazio = inputNumeroDeConvidados.getText().isBlank() || inputNumeroDeConvidados.getText().isEmpty();
			
			if (estaVazio) {
				JOptionPane.showMessageDialog(null, "Numero de convidados não está preenchido"); // TODO Substituir depois por um JPanel de erro
				resposta = false;
			}
			
			estaVazio = inputData.getText().equals("  /  /    "); 
			
			if (estaVazio) {
				JOptionPane.showMessageDialog(null, "Data não está preenchido"); // TODO Substituir depois por um JPanel de erro
				resposta = false;
			} else {
				if (inputData.getText().matches("(\\d{2}|\\d\s|\s\\d)/(\\d{2}|\\d\\s|\s\\d)/\\d{4}") == false) {
					JOptionPane.showMessageDialog(null, "Data inválida"); // TODO Substituir depois por um JPanel de erro
					resposta = false;
				}
			}
			
			estaVazio = inputHoraDeInicio.getText().equals("  :  ");
			
			if (estaVazio) {
				JOptionPane.showMessageDialog(null, "Hora de inicio não está preenchido"); // TODO Substituir depois por um JPanel de erro
				resposta = false;
				
			} else {
				if (inputHoraDeInicio.getText().matches("\\d{2}:\\d{2}") == false) {
					JOptionPane.showMessageDialog(null, "Hora inválida"); // TODO Substituir depois por um JPanel de erro
					resposta = false;
				}
			}
			
			// Numero de colaboradores é um parametro opcional
			
			return resposta;
			
		} catch (Exception e) {
			return false;
		}
		
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
		inputNumeroDeConvidados.setText("###");
		inputNumeroDeColaboradores.setText("###");
		inputData.setText("##/##/####");
		inputHoraDeInicio.setText("##:##");
	}
	
}
