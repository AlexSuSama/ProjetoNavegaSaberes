package br.alexsusama.interfacescadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.alexsusama.modelo.GeradorDeGraficosEstoque;
import br.alexsusama.persisntencia.SaidaEntradaEstoque;
import br.alexsusama.validacoes.ValidacaoDeDatas;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import java.awt.Font;

public class GraficosEstoque extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldIDPovoamento;
	JFormattedTextField formattedTextFieldDataInicial;
	JFormattedTextField formattedTextFieldDataFinal;
	int controladorGrafico = 0;
	JLabel labelGraficos;
	String idPovoamento = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraficosEstoque frame = new GraficosEstoque();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GraficosEstoque() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(20, 73, 682, 309);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(panel);
		panel.setLayout(new BorderLayout(0, 0));

		labelGraficos = new JLabel("");
		panel.add(labelGraficos);

		JLabel lblAt = new JLabel("at\u00E9");
		lblAt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAt.setBounds(596, 48, 34, 14);
		contentPane.add(lblAt);

		JButton btnNewButton = new JButton("Selecionar povoamento");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaPovoamentosEstoque listaPovoamentosEstoque = new ListaPovoamentosEstoque();
				listaPovoamentosEstoque.nEhGrafico = false;
				listaPovoamentosEstoque.setVisible(true);
			}
		});
		btnNewButton.setBounds(20, 1, 163, 40);
		contentPane.add(btnNewButton);

		textFieldIDPovoamento = new JTextField();
		textFieldIDPovoamento.setEditable(false);
		textFieldIDPovoamento.setBounds(96, 45, 86, 20);
		contentPane.add(textFieldIDPovoamento);
		textFieldIDPovoamento.setColumns(10);
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			formattedTextFieldDataInicial = new JFormattedTextField(mask);
			formattedTextFieldDataInicial.setBounds(500, 45, 67, 20);
			contentPane.add(formattedTextFieldDataInicial);

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			formattedTextFieldDataFinal = new JFormattedTextField(mask);
			formattedTextFieldDataFinal.setBounds(635, 45, 67, 20);
			contentPane.add(formattedTextFieldDataFinal);

			JLabel lblPovoamento = new JLabel("Povoamento");
			lblPovoamento.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPovoamento.setBounds(20, 47, 97, 14);
			contentPane.add(lblPovoamento);

			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String dataInicial = formattedTextFieldDataInicial.getText().toString();
					String dataFinal = formattedTextFieldDataFinal.getText().toString();

					if (ValidacaoDeDatas.verificarData(dataInicial, dataFinal)&& (controladorGrafico!=0)) {
						GeradorDeGraficosEstoque graficosEstoque = new GeradorDeGraficosEstoque();
						SaidaEntradaEstoque saida = new SaidaEntradaEstoque();
						switch (controladorGrafico) {

						// ostras em estoque
						case 1:
							graficosEstoque.graficoOstraEmEstoque(saida.resgatarEstoque(idPovoamento),
									"Estoque de ostras", "Estoque", "Quantidade");
							try {
								graficosEstoque.salvarGrafico(new FileOutputStream("imgGraficoEstoque.png"));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						// areas de comercializacao
						case 2:
							graficosEstoque.gerarGraficoDePizzaEstoqueComercializacao(saida.resgatarEstoque(idPovoamento), "Ostras em fase de comercialização", dataInicial+" "+dataFinal,"");
							try {
								graficosEstoque.salvarGrafico(new FileOutputStream("imgGraficoEstoque.png"));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case 3: 
							graficosEstoque.gerarGraficoDePizzaEstoqueApetrechos(saida.resgatarEstoque(idPovoamento), "Apetrechos em estoque", "", "");
							try {
								graficosEstoque.salvarGrafico(new FileOutputStream("imgGraficoEstoque.png"));
							} catch (IOException e) {
								// TODO: handle exception
							e.printStackTrace();
							}
						default:
							break;
						}
						if (labelGraficos.getIcon() == null) {
							File file = new File("imgGraficoEstoque.png");
							ImageIcon icon = new ImageIcon(file.getAbsolutePath());
							labelGraficos.setIcon(icon);
						} else {
							File file = new File("imgGraficoEstoque.png");
							BufferedImage img;
							try {
								img = ImageIO.read(file);
							} catch (IOException exception) {
								exception.printStackTrace();
								return;
							}
							ImageIcon icon = new ImageIcon(img);
							labelGraficos.setIcon(icon);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos");
					}

				}
			});
			btnBuscar.setBounds(613, 393, 89, 38);
			contentPane.add(btnBuscar);

			JButton btnVoltar = new JButton("voltar");
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Home.repassarTelas(new EscolhaGrafico());
					dispose();
				}
			});
			btnVoltar.setBounds(20, 393, 89, 38);
			contentPane.add(btnVoltar);

			ButtonGroup group = new ButtonGroup();

			JRadioButton rdbtOstrasEstoque = new JRadioButton("Ostras em estoque");
			rdbtOstrasEstoque.setBounds(125, 393, 135, 23);
			rdbtOstrasEstoque.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					controladorGrafico = 1;

				}
			});
			group.add(rdbtOstrasEstoque);
			contentPane.add(rdbtOstrasEstoque);

			JRadioButton rdbtnEtapaDeComercializao = new JRadioButton("Para comercializa\u00E7\u00E3o");
			rdbtnEtapaDeComercializao.setBounds(268, 393, 163, 23);
			rdbtnEtapaDeComercializao.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					controladorGrafico = 2;
					
				}
			});
			group.add(rdbtnEtapaDeComercializao);
			contentPane.add(rdbtnEtapaDeComercializao);

			JRadioButton rdbtnApetrechos = new JRadioButton("Apetrechos");
			rdbtnApetrechos.setBounds(433, 393, 118, 23);
			rdbtnApetrechos.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					controladorGrafico = 3;
				}
			});
			group.add(rdbtnApetrechos);
			contentPane.add(rdbtnApetrechos);
			
			JLabel lblSelecioneOPerodo = new JLabel("Selecione o per\u00EDodo:");
			lblSelecioneOPerodo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblSelecioneOPerodo.setBounds(348, 48, 135, 14);
			contentPane.add(lblSelecioneOPerodo);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void preencherIDPovoamento(String idPovoamento) {
		this.idPovoamento = idPovoamento;
		textFieldIDPovoamento.setText(idPovoamento);
	}
}
