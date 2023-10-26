package telas;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;

import componentesDeTelas.RoundJFormattedTextField;
import componentesDeTelas.RoundJPanel;
import componentesDeTelas.RoundJTextField;

public class PainelEscolhaDeOrcamento implements Painel {

	private JPanel painel;
	
	private Color corDeFundo;
	private Color corJanelaInterna;
	private Color corTitulo;
	private Color corTexto;
	private Color corInputs;
	
	public PainelEscolhaDeOrcamento() {
		painel = new JPanel();
		
		Path pathfile = Path.of("config.txt");
		Properties properties = new Properties();
		
		try {
			String aux;
			String[] auxArray;
			int[] auxInt = new int[3];
			
			properties.load(Files.newBufferedReader(pathfile));
			
			aux = properties.getProperty("COR_DE_FUNDO");
			auxArray = aux.split(",");
			for (int i = 0; i < auxArray.length; i++) auxInt[i] = Integer.valueOf(auxArray[i]);
			corDeFundo = new Color(auxInt[0], auxInt[1], auxInt[2]);
			painel.setBackground(corDeFundo);
			//painel.setBackground(new Color(255,255,255));
			
			aux = properties.getProperty("COR_DE_FUNDO_JANELA_INTERNA");
			auxArray = aux.split(",");
			for (int i = 0; i < auxArray.length; i++) auxInt[i] = Integer.valueOf(auxArray[i]);
			corJanelaInterna = new Color(auxInt[0], auxInt[1], auxInt[2]);
			
			aux = properties.getProperty("COR_LETRA_TITULO");
			auxArray = aux.split(",");
			for (int i = 0; i < auxArray.length; i++) auxInt[i] = Integer.valueOf(auxArray[i]);
			corTitulo = new Color(auxInt[0], auxInt[1], auxInt[2]);
			
			aux = properties.getProperty("COR_LETRA_JANELA_INTERNA");
			auxArray = aux.split(",");
			for (int i = 0; i < auxArray.length; i++) auxInt[i] = Integer.valueOf(auxArray[i]);
			corTexto = new Color(auxInt[0], auxInt[1], auxInt[2]);
			
			aux = properties.getProperty("COR_LETRA_INPUTS");
			auxArray = aux.split(",");
			for (int i = 0; i < auxArray.length; i++) auxInt[i] = Integer.valueOf(auxArray[i]);
			corInputs = new Color(auxInt[0], auxInt[1], auxInt[2]);
		} catch (Exception e) {
			System.out.println("Erro: Ao tentar abrir o arquivo configs.txt");
		}
			
			JLabel labelTitulo = new JLabel("Informações do evento");
			labelTitulo.setForeground(corTitulo);
			labelTitulo.setFont(new Font("Calibri Light", Font.PLAIN, 44));
			
			JPanel painelDivisor = new JPanel();
			painelDivisor.setBackground(corDeFundo);
			
			JPanel painelAvancar = new JPanel();
			painelAvancar.setBackground(corDeFundo);
			
			JPanel painelVoltarTudo = new JPanel();
			painelVoltarTudo.setBackground(corDeFundo);
			GroupLayout gl_painel = new GroupLayout(painel);
			gl_painel.setHorizontalGroup(
				gl_painel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_painel.createSequentialGroup()
						.addGroup(gl_painel.createParallelGroup(Alignment.TRAILING)
							.addGroup(Alignment.LEADING, gl_painel.createSequentialGroup()
								.addGap(40)
								.addGroup(gl_painel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_painel.createSequentialGroup()
										.addComponent(labelTitulo, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE)
										.addGap(566)
										.addComponent(painelVoltarTudo, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))
									.addGroup(gl_painel.createSequentialGroup()
										.addComponent(painelDivisor, GroupLayout.PREFERRED_SIZE, 1180, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE))))
							.addGroup(gl_painel.createSequentialGroup()
								.addGap(1177)
								.addComponent(painelAvancar, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE)))
						.addGap(18))
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
						.addPreferredGap(ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
						.addComponent(painelAvancar, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addGap(20))
			);
			
			JLabel labelVoltarTudo = new JLabel("");
			labelVoltarTudo.setIcon(new ImageIcon("imgs/retorno.png"));
			painelVoltarTudo.add(labelVoltarTudo);
			
			JLabel labelAvancar = new JLabel("");
			painelAvancar.add(labelAvancar);
			painelDivisor.setLayout(new GridLayout(2, 2, 0, 0));
			
			JPanel painelNumeroDeConvidados = new JPanel();
			painelNumeroDeConvidados.setBackground(corDeFundo);
			painelDivisor.add(painelNumeroDeConvidados);
			
			RoundJPanel painelInternoNumeroDeConvidados = new RoundJPanel(25, 25, 25, 25);
			painelInternoNumeroDeConvidados.setBackground(corJanelaInterna);
			painelInternoNumeroDeConvidados.setBorder(new EmptyBorder(10, 10, 10, 10));
			painelInternoNumeroDeConvidados.setLayout(new GridLayout(0, 1, 0, 0));
			
			JLabel labelNumeroDeConvidados = new JLabel(" Nº de convidados");
			labelNumeroDeConvidados.setForeground(corTexto);
			labelNumeroDeConvidados.setFont(new Font("Arial", Font.PLAIN, 24));
			painelInternoNumeroDeConvidados.add(labelNumeroDeConvidados);
			
			RoundJTextField inputNumeroDeConvidados = new RoundJTextField(0);
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
			painelNumeroDeColaboradores.setBackground(corDeFundo);
			painelDivisor.add(painelNumeroDeColaboradores);
			
			RoundJPanel painelInternoNumeroDeColaboradores = new RoundJPanel(25, 25, 25, 25);
			painelInternoNumeroDeColaboradores.setBackground(corJanelaInterna);
			painelInternoNumeroDeColaboradores.setBorder(new EmptyBorder(10, 10, 10, 10));
			painelInternoNumeroDeColaboradores.setLayout(new GridLayout(0, 1, 0, 0));
			
			JLabel labelNumeroDeColaboradores = new JLabel(" Nº de colaboradores");
			labelNumeroDeColaboradores.setForeground(corTexto);
			labelNumeroDeColaboradores.setFont(new Font("Arial", Font.PLAIN, 24));
			painelInternoNumeroDeColaboradores.add(labelNumeroDeColaboradores);
			
			RoundJTextField inputNumeroDeColaboradores = new RoundJTextField(0);
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
			painelData.setBackground(corDeFundo);
			painelDivisor.add(painelData);
			
			RoundJPanel painelInternoData = new RoundJPanel(25, 25, 25, 25);
			painelInternoData.setBackground(corJanelaInterna);
			painelInternoData.setBorder(new EmptyBorder(10, 10, 10, 10));
			painelInternoData.setLayout(new GridLayout(0, 1, 0, 0));
			
			JLabel labelData = new JLabel(" Data");
			labelData.setForeground(corTexto);
			labelData.setFont(new Font("Arial", Font.PLAIN, 24));
			painelInternoData.add(labelData);
			
			RoundJFormattedTextField inputData = new RoundJFormattedTextField(0);
			inputData.setText("");
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
			painelHoraDeInicio.setBackground(corDeFundo);
			painelDivisor.add(painelHoraDeInicio);
			
			RoundJPanel painelInternoHoraDeInicio = new RoundJPanel(25, 25, 25, 25);
			painelInternoHoraDeInicio.setBackground(corJanelaInterna);
			painelInternoHoraDeInicio.setBorder(new EmptyBorder(10, 10, 10, 10));
			painelInternoHoraDeInicio.setLayout(new GridLayout(0, 1, 0, 0));
			
			JLabel labelHoraDeInicio = new JLabel(" Hora de início do evento");
			labelHoraDeInicio.setForeground(corTexto);
			labelHoraDeInicio.setFont(new Font("Arial", Font.PLAIN, 24));
			painelInternoHoraDeInicio.add(labelHoraDeInicio);
			
			RoundJFormattedTextField inputHoraDeInicio = new RoundJFormattedTextField(0);
			inputHoraDeInicio.setText("");
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
	
	@Override
	public JPanel getPainel() {
		return painel;
	}

	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub
		
	}
}
