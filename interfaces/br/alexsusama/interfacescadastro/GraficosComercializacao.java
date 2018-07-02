package br.alexsusama.interfacescadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.alexsusama.modelo.GeradorDeGraficosComercializacao;
import br.alexsusama.persisntencia.SaidaEntradaComercializacao;
import br.alexsusama.validacoes.ValidacaoDeDatas;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFormattedTextField;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JTextField;

public class GraficosComercializacao extends JInternalFrame {
	JFormattedTextField textDataInicial;
	JFormattedTextField textDataFinal;

	int ControladorGrafico = 0;

	private JPanel contentPane;
	private JTextField textFieldIdPovomanto;
	private static int SELECIONARCOMERCIALIZACAO = 1;
	
	JLabel labelGraficos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraficosComercializacao frame = new GraficosComercializacao();
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
	public GraficosComercializacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(22, 81, 682, 309);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(panel);
		panel.setLayout(new BorderLayout(0, 0));

		labelGraficos = new JLabel("");
		panel.add(labelGraficos, BorderLayout.CENTER);

		JLabel label = new JLabel("Selecione o Per\u00EDodo");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(289, 50, 119, 14);
		contentPane.add(label);
		try {
			MaskFormatter mascara = new MaskFormatter("##-##-####");
			textDataInicial = new JFormattedTextField(mascara);
			textDataInicial.setBounds(432, 48, 108, 20);
			contentPane.add(textDataInicial);
		} catch (Exception e) {
			// TODO: handle exception
		}
		JLabel label_1 = new JLabel("at\u00E9");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(550, 50, 24, 14);
		contentPane.add(label_1);
		try {
			MaskFormatter mascara = new MaskFormatter("##-##-####");
			textDataFinal = new JFormattedTextField(mascara);
			textDataFinal.setBounds(596, 48, 108, 20);
			contentPane.add(textDataFinal);
		} catch (Exception e) {
			// TODO: handle exception
		}
		JButton button = new JButton("Buscar");
		button.setBounds(615, 401, 89, 23);
		button.addActionListener(btnBuscar());
		contentPane.add(button);

		JRadioButton rdbtnQuantidadeVendida = new JRadioButton("Quantidade vendida");
		rdbtnQuantidadeVendida.setBounds(22, 401, 136, 23);
		rdbtnQuantidadeVendida.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ControladorGrafico = 1;
			}
		});
		contentPane.add(rdbtnQuantidadeVendida);

		JRadioButton rdbtnreasDeComercializao = new JRadioButton("\u00C1reas de comercializa\u00E7\u00E3o");
		rdbtnreasDeComercializao.setBounds(160, 401, 158, 23);
		rdbtnreasDeComercializao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ControladorGrafico = 2;
			}
		});
		contentPane.add(rdbtnreasDeComercializao);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnreasDeComercializao);
		group.add(rdbtnQuantidadeVendida);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EscolhaGrafico escolhaGrafico = new EscolhaGrafico();
				Home.repassarTelas(escolhaGrafico);
				dispose();
			}
		});
		btnVoltar.setBounds(501, 401, 89, 23);
		contentPane.add(btnVoltar);

		JLabel lblPovoamento = new JLabel("Povoamento");
		lblPovoamento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPovoamento.setBounds(22, 51, 89, 14);
		contentPane.add(lblPovoamento);

		textFieldIdPovomanto = new JTextField();
		textFieldIdPovomanto.setEditable(false);
		textFieldIdPovomanto.setBounds(143, 48, 86, 20);
		contentPane.add(textFieldIdPovomanto);
		textFieldIdPovomanto.setColumns(10);

		JButton btnNewButton = new JButton("Selecionar Povoamento");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaPovoamentosGrafico listaPovoamentosGrafico = new ListaPovoamentosGrafico();
				listaPovoamentosGrafico.controladorDeSelecao(SELECIONARCOMERCIALIZACAO);
				listaPovoamentosGrafico.setVisible(true);

			}
		});
		btnNewButton.setBounds(22, 0, 207, 40);
		contentPane.add(btnNewButton);
	}

	public ActionListener btnBuscar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String dataInicial = textDataInicial.getText().toString();
				String dataFinal = textDataFinal.getText().toString();

				if (ValidacaoDeDatas.verificarData(dataInicial, dataFinal)) {
					GeradorDeGraficosComercializacao geradorDeGraficosComercializacao = new GeradorDeGraficosComercializacao();
					SaidaEntradaComercializacao saida = new SaidaEntradaComercializacao();
					switch (ControladorGrafico) {

					// quantidade vendida
					case 1:
						try { 
							geradorDeGraficosComercializacao.graficoDuziasVendidas(
									saida.valoresComercializacaoMunicipio(dataInicial, dataFinal,
											textFieldIdPovomanto.getText().toString()),
									"Valores por municio", "Municipios", "Duzias vendidas");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							geradorDeGraficosComercializacao.salvarGrafico(new FileOutputStream("imgGrafico02.png"));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					// areas de comercializacao
					case 2:
						try {
							geradorDeGraficosComercializacao.gerarGraficoDePizzaComercializacao(
									saida.valoresComercializacaoMunicipio(dataInicial, dataFinal,
											textFieldIdPovomanto.getText().toString()),
									"Valores por municio", "Municipios", "Duzias vendidas");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							geradorDeGraficosComercializacao.salvarGrafico(new FileOutputStream("imgGrafico02.png"));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;

					default:
						break;
					}
					if (labelGraficos.getIcon() == null) {
						File file = new File("imgGrafico02.png");
						ImageIcon icon = new ImageIcon(file.getAbsolutePath());
						labelGraficos.setIcon(icon);
					} else {
						File file = new File("imgGrafico02.png");
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
					JOptionPane.showMessageDialog(null, "datas invalidas");
				}
			}
		};
	}

	public void atualizarInfoPov(String idPovoamento) {
		textFieldIdPovomanto.setText(idPovoamento);
	}
}
