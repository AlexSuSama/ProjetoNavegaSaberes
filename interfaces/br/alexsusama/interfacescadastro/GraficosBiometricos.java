package br.alexsusama.interfacescadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.alexsusama.modelo.GeradorDeGraficosBiometria;
import br.alexsusama.persisntencia.SaidaEntradaBiometria;
import br.alexsusama.validacoes.ValidacaoDeDatas;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JTextField;

public class GraficosBiometricos extends JInternalFrame {
	JFormattedTextField textDataInicial;
	JFormattedTextField textDataFinal;
	int controladorGrafico = 0;
	private JPanel contentPane;
	JLabel labelGrafico;
	boolean selecionado = false;
	private JTextField textFieldPovoamento;
	
	private static int SELECIONARBIOMETRIA = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraficosBiometricos frame = new GraficosBiometricos();
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
	public GraficosBiometricos() {
		setTitle("Gr\u00E1ficos biom\u00E9tricos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(54, 79, 682, 309);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(panel);
		panel.setLayout(new BorderLayout(0, 0));

		labelGrafico = new JLabel("");
		panel.add(labelGrafico, BorderLayout.CENTER);

		JLabel label = new JLabel("Selecione o Per\u00EDodo");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(314, 54, 119, 14);
		contentPane.add(label);
		try {
			MaskFormatter mascara = new MaskFormatter("##-##-####");
			textDataInicial = new JFormattedTextField(mascara);
			textDataInicial.setBounds(443, 48, 108, 20);
			contentPane.add(textDataInicial);
		} catch (Exception e) {
			// TODO: handle exception
		}

		JLabel label_1 = new JLabel("at\u00E9");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(581, 54, 24, 14);
		contentPane.add(label_1);
		try {
			MaskFormatter mascara = new MaskFormatter("##-##-####");
			textDataFinal = new JFormattedTextField((mascara));
			textDataFinal.setBounds(628, 48, 108, 20);
			contentPane.add(textDataFinal);
		} catch (Exception e) {
			// TODO: handle exception
		}

		JButton btnBuscar = new JButton("Buscar");

		btnBuscar.setBounds(685, 409, 89, 23);
		btnBuscar.addActionListener(gerarGrafico());
		contentPane.add(btnBuscar);

		JRadioButton radioButtonCrescimento = new JRadioButton("Crescimento");
		radioButtonCrescimento.setBounds(54, 395, 109, 23);
		radioButtonCrescimento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controladorGrafico = 1;
				selecionado = true;

			}
		});
		contentPane.add(radioButtonCrescimento);

		JRadioButton radioButtonTotal = new JRadioButton("Quantidade");
		radioButtonTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorGrafico = 3;
				selecionado = true;

			}
		});
		radioButtonTotal.setBounds(286, 397, 109, 23);
		contentPane.add(radioButtonTotal);

		JRadioButton radioButtonAmbiente = new JRadioButton("Ambiente");
		radioButtonAmbiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorGrafico = 2;
				selecionado = true;

			}
		});
		radioButtonAmbiente.setBounds(165, 395, 109, 23);
		contentPane.add(radioButtonAmbiente);

		JRadioButton radioButtonMortalidade = new JRadioButton("Mortalidade");
		radioButtonMortalidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorGrafico = 4;
				selecionado = true;

			}
		});
		radioButtonMortalidade.setBounds(397, 395, 109, 23);
		contentPane.add(radioButtonMortalidade);

		ButtonGroup groupRadio = new ButtonGroup();
		groupRadio.add(radioButtonAmbiente);
		groupRadio.add(radioButtonCrescimento);
		groupRadio.add(radioButtonTotal);
		groupRadio.add(radioButtonMortalidade);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EscolhaGrafico escolhaGrafico = new EscolhaGrafico();
				Home.repassarTelas(escolhaGrafico);
				dispose();
			}
		});
		btnVoltar.setBounds(574, 409, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnSelecionarPovoamento = new JButton("Selecionar Povoamento");
		btnSelecionarPovoamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ListaPovoamentosGrafico listaPovoamentosGrafico = new ListaPovoamentosGrafico();
			listaPovoamentosGrafico.controladorDeSelecao(SELECIONARBIOMETRIA);
			listaPovoamentosGrafico.setVisible(true);
			
			}
		}); 
		btnSelecionarPovoamento.setBounds(54, 6, 150, 37);
		contentPane.add(btnSelecionarPovoamento);
		
		JLabel lblPovoamento = new JLabel("Povoamento");
		lblPovoamento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPovoamento.setBounds(531, 6, 109, 14);
		contentPane.add(lblPovoamento);
		
		textFieldPovoamento = new JTextField(); 
		textFieldPovoamento.setEditable(false);
		textFieldPovoamento.setBounds(650, 6, 86, 20);
		contentPane.add(textFieldPovoamento);
		textFieldPovoamento.setColumns(10);

	}

	public ActionListener gerarGrafico() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String dataInicial;
				String dataFinal;

				dataInicial = textDataInicial.getText().toString();
				dataFinal = textDataFinal.getText().toString();
				if (ValidacaoDeDatas.verificarData(dataInicial, dataFinal) && selecionado) {

					GeradorDeGraficosBiometria geradorDeGraficosBiometria = new GeradorDeGraficosBiometria();
					SaidaEntradaBiometria saidaEntrada = new SaidaEntradaBiometria();
					// os codigos abaixo fazem a mudança de grafico na tela de graficos
					switch (controladorGrafico) {
					case 1:
						System.out.println("crescimento");

						try {
							geradorDeGraficosBiometria.graficoPeriodoDeCrescimento(
									saidaEntrada.biometriasPorPeriodo(
											"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataInicial) + "'", 
											"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataFinal) + "'",  textFieldPovoamento.getText().toString()),
									"Média de crescimento", "Período", "m m");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try { 
							geradorDeGraficosBiometria.salvarGrafico(new FileOutputStream("imgGrafico01.png"));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					case 2:
						System.out.println("ambiente");

						try {
							geradorDeGraficosBiometria.graficoPeriodoSalinidadeTemperatura(
									saidaEntrada.biometriasPorPeriodo(
											"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataInicial) + "'",
											"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataFinal) + "'", textFieldPovoamento.getText().toString()),
									"Salinidade e Temperatura", "agora", "Salinidade X Temperatura");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							geradorDeGraficosBiometria.salvarGrafico(new FileOutputStream("imgGrafico01.png"));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					case 3:
						System.out.println("quantidade");
						try {
							geradorDeGraficosBiometria.graficoTotalDeOstras(
									saidaEntrada.biometriasPorPeriodo(
											"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataInicial) + "'",
											"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataFinal) + "'",  textFieldPovoamento.getText().toString()),
									"Total de unidades", "agora", "Quantidade");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							geradorDeGraficosBiometria.salvarGrafico(new FileOutputStream("imgGrafico01.png"));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						break;
					case 4:
						System.out.println("mortalidade");
						try {
							geradorDeGraficosBiometria.graficoPeriodoMortalidadeSobrevivencia(
									saidaEntrada.biometriasPorPeriodo(
											"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataInicial) + "'",
											"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataFinal) + "'", textFieldPovoamento.getText().toString()),
									"Mortalidade", "agora", "Quantidade");
							//apenas para testar
							System.out.println("id "+textFieldPovoamento.getText().toString());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							geradorDeGraficosBiometria.salvarGrafico(new FileOutputStream("imgGrafico01.png"));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						break;
 
					default:
						break;

					}
					if (labelGrafico.getIcon() == null) {
						File file = new File("imgGrafico01.png");
						ImageIcon icon = new ImageIcon(file.getAbsolutePath());
						labelGrafico.setIcon(icon);
					} else {
						File file = new File("imgGrafico01.png");
						BufferedImage img;
						try {
							img = ImageIO.read(file);
						} catch (IOException exception) {
							exception.printStackTrace();
							return;
						}
						ImageIcon icon = new ImageIcon(img);
						labelGrafico.setIcon(icon);
					}

				} else {
					System.out.println("as datas não foram preenchidas");
				}
			}
		};
	}
	public void atualizarInfoPov(String povoamento){
		textFieldPovoamento.setText(povoamento);
	}
}
