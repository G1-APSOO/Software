package telas;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;

import componentesDeTelas.RoundJFormattedTextField;
import componentesDeTelas.RoundJPanel;
import javax.swing.JFormattedTextField;

public class PainelInicialOrcamentoDeBuffetCompleto extends Painel {

	private JPanel painel;
	private RoundJFormattedTextField inputNumeroDeConvidados;
	private RoundJFormattedTextField inputNumeroDeColaboradores;
	private RoundJFormattedTextField inputData;
	private RoundJFormattedTextField inputHoraDeInicio;
	private JLabel labelVoltarTudo;
	private JLabel labelAvancar;
	
	public PainelInicialOrcamentoDeBuffetCompleto() {
		super();
		
		painel = new JPanel();
		painel.setBackground(getCorDeFundo());
		
		JLabel labelTitulo = new JLabel("Informações do evento");
		labelTitulo.setForeground(getCorTitulo());
		labelTitulo.setFont(getFonteTitulo());
		
		JPanel painelDivisor = new JPanel();
		painelDivisor.setBackground(getCorDeFundo());
		
		JPanel painelAvancar = new JPanel();
		painelAvancar.setBackground(getCorDeFundo());
		
		JPanel painelVoltarTudo = new JPanel();
		painelVoltarTudo.setBackground(getCorDeFundo());
		GroupLayout gl_painel = new GroupLayout(painel);
		gl_painel.setHorizontalGroup(
			gl_painel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_painel.createSequentialGroup()
					.addGroup(gl_painel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel.createSequentialGroup()
							.addGap(40)
							.addGroup(gl_painel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_painel.createSequentialGroup()
									.addComponent(labelTitulo, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE)
									.addGap(566)
									.addComponent(painelVoltarTudo, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
								.addComponent(painelDivisor, GroupLayout.PREFERRED_SIZE, 1180, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_painel.createSequentialGroup()
							.addGap(1177)
							.addComponent(painelAvancar, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
					.addGap(20))
		);
		gl_painel.setVerticalGroup(
			gl_painel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel.createSequentialGroup()
					.addGroup(gl_painel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel.createSequentialGroup()
							.addGap(34)
							.addComponent(labelTitulo, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_painel.createSequentialGroup()
							.addGap(20)
							.addComponent(painelVoltarTudo, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(painelDivisor, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
					.addComponent(painelAvancar, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		painelVoltarTudo.setLayout(new GridLayout(0, 1, 0, 0));
		
		setLabelVoltarTudo();
		painelVoltarTudo.add(labelVoltarTudo);
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
		painel.setLayout(gl_painel);
		
	}
	
	private void setInputNumeroDeConvidados() {
		inputNumeroDeConvidados = new RoundJFormattedTextField(0);
		inputNumeroDeConvidados.setFocusLostBehavior(JFormattedTextField.COMMIT);
		inputNumeroDeConvidados.setFont(getFonteInputs());
		inputNumeroDeConvidados.setText("");
		// TODO Adiciona mascara aqui até 3 digitos
	}
	
	private void setInputNumeroDeColaboradores() {
		inputNumeroDeColaboradores = new RoundJFormattedTextField(0);
		inputNumeroDeColaboradores.setFocusLostBehavior(JFormattedTextField.COMMIT);
		inputNumeroDeColaboradores.setFont(getFonteInputs());
		inputNumeroDeColaboradores.setText("");
		// TODO Adiciona mascara aqui até 3 digitos
	}
	
	private void setInputData() {
		inputData = new RoundJFormattedTextField(0);
		inputData.setFocusLostBehavior(JFormattedTextField.COMMIT);
		inputData.setFont(getFonteInputs());
		inputData.setText("");
		// TODO Adiciona mascara aqui
	}
	
	private void setInputHoraDeInicio() {
		inputHoraDeInicio = new RoundJFormattedTextField(0);
		inputHoraDeInicio.setFocusLostBehavior(JFormattedTextField.COMMIT);
		inputHoraDeInicio.setFont(getFonteInputs());
		inputHoraDeInicio.setText("");
		// TODO Adiciona mascara aqui
	}
	
	private void setLabelVoltarTudo() {
		labelVoltarTudo = new JLabel("");
		labelVoltarTudo.setIcon(getIconeRetornaTudo());
		// TODO Adionar MouseListener
	}
	
	private void setLabelAvancar() {
		labelAvancar = new JLabel("");
		labelAvancar.setIcon(getIconeProximaPagina());
		// TODO Adionar MouseListener
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
