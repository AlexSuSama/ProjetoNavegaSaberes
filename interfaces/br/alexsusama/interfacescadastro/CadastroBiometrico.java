package br.alexsusama.interfacescadastro;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.alexsusama.modelo.Ambiente;
import br.alexsusama.modelo.Biometria;
import br.alexsusama.modelo.GeradorDeGraficosBiometria;
import br.alexsusama.modelo.Ostra;
import br.alexsusama.persisntencia.SaidaEntradaBiometria;
import br.alexsusama.persisntencia.SaidaEntradaPovoamento;
import br.alexsusama.validacoes.Calculos;
import br.alexsusama.validacoes.RestricoesDeValores;
import br.alexsusama.validacoes.ValidacaoDeDatas;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;

public class CadastroBiometrico extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6795603587013201531L;
	private JPanel contentPane;
	private JTextField textFieldQtMorta;
	private JTextField textFieldQtTotal;
	private JTextField textFieldIDPovoamento;
	private JTextField textFieldDataBiometria;
	private JTextField textFieldAmostra;
	private JTextField textFieldQuantidadeAmostras;
	private JTextField textFieldMediaCrescimento;
	private JTextField textFieldTemperatura;
	private JTextField textFieldSalinidade;

	private String estagioCrescimento = "";
	private String sistemaProducao = "";

	private int contador = 0;
	private double mediaCrescimento = 0.0;

	private int idBiometria;
	private boolean atualizar = true;
	
	
	JLabel labelGrafico;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroBiometrico frame = new CadastroBiometrico();
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
	public CadastroBiometrico() {
		setTitle("Nova Biometria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		RestricoesDeValores restricoes = new RestricoesDeValores();

		JLabel lblQuantidadeMorta = new JLabel("Quantidade morta:");
		lblQuantidadeMorta.setBounds(30, 181, 149, 14);
		contentPane.add(lblQuantidadeMorta);

		JLabel lblQuantidadeTotal = new JLabel("Quantidade total");
		lblQuantidadeTotal.setBounds(30, 206, 149, 14);
		contentPane.add(lblQuantidadeTotal);

		JLabel lblIdDoPovoamento = new JLabel("id do povoamento");
		lblIdDoPovoamento.setBounds(214, 43, 99, 14);
		contentPane.add(lblIdDoPovoamento);

		textFieldQtMorta = new JTextField();
		textFieldQtMorta.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldQtMorta.setToolTipText("Ex: 400");
		textFieldQtMorta.setBounds(214, 178, 168, 20);
		contentPane.add(textFieldQtMorta);
		textFieldQtMorta.setColumns(10);
		textFieldQtMorta.addKeyListener(restricoes.negarLetras(textFieldQtMorta));

		textFieldQtTotal = new JTextField();
		textFieldQtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldQtTotal.setToolTipText("Ex: 10000");
		textFieldQtTotal.setColumns(10);
		textFieldQtTotal.setBounds(214, 203, 168, 20);
		contentPane.add(textFieldQtTotal);
		textFieldQtTotal.addKeyListener(restricoes.negarLetras(textFieldQtTotal));

		textFieldIDPovoamento = new JTextField();
		textFieldIDPovoamento.setEditable(false);
		textFieldIDPovoamento.setColumns(10);
		textFieldIDPovoamento.setBounds(323, 40, 67, 20);
		contentPane.add(textFieldIDPovoamento);

		JButton btnSalva = new JButton("Salvar");
		btnSalva.setBounds(444, 386, 89, 35);
		btnSalva.addActionListener(btnSalvar());
		contentPane.add(btnSalva);

		JButton btnEditar = new JButton("editar");
		btnEditar.setBounds(20, 417, 89, 23);
		btnEditar.setVisible(false);
		// btnEditar.addActionListener(btnEditar());
		contentPane.add(btnEditar);

		JButton btnExcluir = new JButton("excluir");
		btnExcluir.setBounds(20, 386, 89, 23);
		btnExcluir.setVisible(false);
		// btnExcluir.addActionListener(btnExcluir());
		contentPane.add(btnExcluir);

		JLabel lblTemperatura = new JLabel("Temperatura");
		lblTemperatura.setBounds(30, 231, 149, 14);
		contentPane.add(lblTemperatura);

		JLabel lblSalinidade = new JLabel("Salinidade");
		lblSalinidade.setBounds(30, 256, 149, 14);
		contentPane.add(lblSalinidade);

		JLabel lblSistemaDeProduo = new JLabel("Selecione o sistema de produ\u00E7\u00E3o");
		lblSistemaDeProduo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSistemaDeProduo.setBounds(30, 312, 240, 23);
		contentPane.add(lblSistemaDeProduo);

		JLabel lblDataDaBiometria = new JLabel("Data da biometria");
		lblDataDaBiometria.setBounds(20, 43, 99, 14);
		contentPane.add(lblDataDaBiometria);
		try {
			MaskFormatter mascara = new MaskFormatter("##/##/####");
			textFieldDataBiometria = new JFormattedTextField(mascara);
			textFieldDataBiometria.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldDataBiometria.setToolTipText("EX: 12/12/2012");
			textFieldDataBiometria.setColumns(10);
			textFieldDataBiometria.setBounds(118, 40, 86, 20);
			contentPane.add(textFieldDataBiometria);
		} catch (Exception e) {
			// TODO: handle exception
		}
		JLabel lblSelecioneOEstgio = new JLabel("Selecione o est\u00E1gio de crescimento");
		lblSelecioneOEstgio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSelecioneOEstgio.setBounds(20, 68, 168, 14);
		contentPane.add(lblSelecioneOEstgio);

		ButtonGroup groupRadioEstagio = new ButtonGroup();

		JRadioButton rdbtnSemente = new JRadioButton("Semente");
		rdbtnSemente.setBounds(50, 92, 89, 23);
		contentPane.add(rdbtnSemente);
		rdbtnSemente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				estagioCrescimento = "Semente";
				System.out.println(estagioCrescimento);
			}
		});
		groupRadioEstagio.add(rdbtnSemente);

		JRadioButton rdbtnJuvenil = new JRadioButton("Juvenil");
		rdbtnJuvenil.setBounds(141, 92, 67, 23);
		contentPane.add(rdbtnJuvenil);
		rdbtnJuvenil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				estagioCrescimento = "Juvenil";
				System.out.println(estagioCrescimento);
			}
		});
		groupRadioEstagio.add(rdbtnJuvenil);

		JRadioButton rdbtnBaby = new JRadioButton("Baby");
		rdbtnBaby.setBounds(210, 92, 67, 23);
		contentPane.add(rdbtnBaby);
		groupRadioEstagio.add(rdbtnBaby);
		rdbtnBaby.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				estagioCrescimento = "Baby";
				System.out.println(estagioCrescimento);
			}
		});

		JRadioButton rdbtnMdia = new JRadioButton("M\u00E9dia");
		rdbtnMdia.setBounds(291, 92, 67, 23);
		contentPane.add(rdbtnMdia);
		rdbtnMdia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				estagioCrescimento = "Média";
				System.out.println(estagioCrescimento);
			}
		});
		groupRadioEstagio.add(rdbtnMdia);

		JButton btnCancelar = new JButton("Cancelar");

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaidaEntradaBiometria saida = new SaidaEntradaBiometria();
				SaidaEntradaPovoamento saidaPovoamento = new SaidaEntradaPovoamento();
				String idCapturado = textFieldIDPovoamento.getText().toString();
				try {
					// faz a busca e repassa os valores do banco de dados
					// para a lista de biometrias

					ListaBiometrias listaBiometrias = new ListaBiometrias();
					listaBiometrias.repassarBiometrias(saida.resgatarBiometrias(idCapturado),
							saidaPovoamento.resgatarPovoamento(idCapturado));
					listaBiometrias.setVisible(true);
					// metodo criado para passar a tela sem usar as
					// variaveis da tela inicial
					Home.repassarTelas(listaBiometrias);
					dispose();
				} catch (SQLException e2) {
					// TODO: handle exception
				}
			}

		});

		JRadioButton rdbtnMaster = new JRadioButton("Master");
		rdbtnMaster.setBounds(359, 92, 67, 23);
		contentPane.add(rdbtnMaster);
		rdbtnMaster.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				estagioCrescimento = "Master";
				System.out.println(estagioCrescimento);
			}
		});
		groupRadioEstagio.add(rdbtnMaster);

		btnCancelar.setBounds(191, 386, 89, 35);
		contentPane.add(btnCancelar);

		JLabel lblCrescimentoDaAmostra = new JLabel("Crescimento da amostra");
		lblCrescimentoDaAmostra.setBounds(20, 119, 132, 14);
		contentPane.add(lblCrescimentoDaAmostra);

		textFieldAmostra = new JTextField();
		textFieldAmostra.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldAmostra.setToolTipText("EX: 65");
		textFieldAmostra.setColumns(10);
		textFieldAmostra.setBounds(20, 133, 67, 20);
		textFieldAmostra.addKeyListener(restricoes.negarLetras(textFieldAmostra));
		contentPane.add(textFieldAmostra);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(97, 132, 79, 23);
		btnAdicionar.addActionListener(btnAdicionar());
		contentPane.add(btnAdicionar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(191, 132, 79, 23);
		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				textFieldAmostra.setText("");
				textFieldMediaCrescimento.setText("");
				textFieldQuantidadeAmostras.setText("");
				mediaCrescimento = 0.0;
				contador = 0;
			}
		});
		contentPane.add(btnLimpar);

		textFieldQuantidadeAmostras = new JTextField();
		textFieldQuantidadeAmostras.setEditable(false);
		textFieldQuantidadeAmostras.setColumns(10);
		textFieldQuantidadeAmostras.setBounds(300, 133, 31, 20);
		contentPane.add(textFieldQuantidadeAmostras);

		JLabel lblN = new JLabel("N\u00B0");
		lblN.setBounds(280, 136, 25, 14);
		contentPane.add(lblN);

		JLabel lblMdia = new JLabel("M\u00E9dia");
		lblMdia.setBounds(341, 136, 42, 14);
		contentPane.add(lblMdia);

		textFieldMediaCrescimento = new JTextField();
		textFieldMediaCrescimento.setEditable(false);
		textFieldMediaCrescimento.setColumns(10);
		textFieldMediaCrescimento.setBounds(376, 133, 50, 20);
		contentPane.add(textFieldMediaCrescimento);
		textFieldMediaCrescimento.addKeyListener(restricoes.negarLetras(textFieldMediaCrescimento));

		JLabel lblMm = new JLabel("mm");
		lblMm.setBounds(434, 136, 25, 14);
		contentPane.add(lblMm);

		textFieldTemperatura = new JTextField();
		textFieldTemperatura.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldTemperatura.setToolTipText("Ex: 25\r\n");
		textFieldTemperatura.setColumns(10);
		textFieldTemperatura.setBounds(214, 228, 168, 20);
		contentPane.add(textFieldTemperatura);
		textFieldTemperatura.addKeyListener(restricoes.negarLetras(textFieldTemperatura));

		textFieldSalinidade = new JTextField();
		textFieldSalinidade.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldSalinidade.setToolTipText("Ex: 22");
		textFieldSalinidade.setColumns(10);
		textFieldSalinidade.setBounds(214, 253, 168, 20);
		contentPane.add(textFieldSalinidade);
		textFieldSalinidade.addKeyListener(restricoes.negarLetras(textFieldSalinidade));
		
		
		
		
		ButtonGroup groupSistemaProducao = new ButtonGroup();

		JRadioButton rdbtnLongLine = new JRadioButton("Long line");
		rdbtnLongLine.setBounds(20, 342, 67, 23);
		contentPane.add(rdbtnLongLine);
		groupSistemaProducao.add(rdbtnLongLine);
		rdbtnLongLine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sistemaProducao = "Long Line";

			}
		});
		JRadioButton rdbtnVaral = new JRadioButton("Varal");
		rdbtnVaral.setBounds(89, 342, 67, 23);
		contentPane.add(rdbtnVaral);
		groupSistemaProducao.add(rdbtnVaral);
		rdbtnVaral.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sistemaProducao = "Varal";

			}
		});

		JRadioButton rdbtnMesaMadeira = new JRadioButton("Mesa de madeira");
		rdbtnMesaMadeira.setBounds(158, 342, 112, 23);
		contentPane.add(rdbtnMesaMadeira);
		groupSistemaProducao.add(rdbtnMesaMadeira);
		rdbtnMesaMadeira.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sistemaProducao = "Mesa de Madeira";
			}
		});
		JRadioButton rdbtnMesaTelada = new JRadioButton("Mesa telada");
		rdbtnMesaTelada.setBounds(272, 342, 86, 23);
		contentPane.add(rdbtnMesaTelada);
		groupSistemaProducao.add(rdbtnMesaTelada);
		rdbtnMesaTelada.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sistemaProducao = "Mesa Telada";
			}
		});
		JRadioButton rdbtnMesaPvc = new JRadioButton("Mesa PVC");
		rdbtnMesaPvc.setBounds(359, 342, 86, 23);
		contentPane.add(rdbtnMesaPvc);
		groupSistemaProducao.add(rdbtnMesaPvc);
		
		JScrollPane scrollPane = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(469, 25, 316, 209);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		labelGrafico = new JLabel("");
		panel.add(labelGrafico);
		rdbtnMesaPvc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sistemaProducao = "Mesa PVC";
			}
		});
	}

	// usado para salvar as informações sobre as biometrias
	public ActionListener btnSalvar() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!(textFieldIDPovoamento == null || textFieldQtMorta.getText().equals("")
						|| textFieldQtTotal.getText().equals("") || textFieldDataBiometria.getText().trim().equals("//")
						|| textFieldMediaCrescimento.getText().equals("") || textFieldTemperatura.getText().equals("")
						|| textFieldSalinidade.getText().equals("") || estagioCrescimento.equals("")
						|| sistemaProducao.equals(""))) {

					String idDoPovoamento = textFieldIDPovoamento.getText().toString();
					int quantidadeMorta = Integer.parseInt(textFieldQtMorta.getText().toString());
					int quantidadeTotal = Integer.parseInt(textFieldQtTotal.getText().toString());
					String data = textFieldDataBiometria.getText().toString();
					String replaceMedia = textFieldMediaCrescimento.getText().toString().replaceAll(",", ".");

					double mediaCrescimento = Double.parseDouble(replaceMedia);
					// só lembrando que ainda não desenvolvi uma
					// forma de calcular
					// a mortalidade e sobrevivencia
					// que funcione em todos os casos

					// por enquanto a mortalidade ainda não mostra apenas os
					// ultimos dois valores depois da virgula como eu queria

					double mortalidade = Calculos.calcularMortalidade(quantidadeTotal, quantidadeMorta);
					double sobrevivencia = 1.2;
					int temperatura = Integer.parseInt(textFieldTemperatura.getText().toString());
					int salinidade = Integer.parseInt(textFieldSalinidade.getText().toString());

					Ostra ostra = new Ostra(estagioCrescimento, quantidadeTotal, quantidadeMorta);

					Ambiente ambiente = new Ambiente(temperatura, salinidade);
					Biometria biometria = new Biometria(ValidacaoDeDatas.ordenarData(data), sistemaProducao,
							mediaCrescimento, mortalidade, sobrevivencia, ostra, ambiente);
					if (atualizar) {
						biometria.criarBiometria(idDoPovoamento);
						
						SaidaEntradaBiometria saida = new SaidaEntradaBiometria();
						GeradorDeGraficosBiometria geradorDeGraficosBiometria = new GeradorDeGraficosBiometria();
						try {
							geradorDeGraficosBiometria.graficoPeriodoDeCrescimento(saida.resgatarUltimasBiometrias(idDoPovoamento), "Ultimas 12 biometrias", "período","médias");
							geradorDeGraficosBiometria.salvarGrafico(new FileOutputStream("graficoPainel12.png"));
							
							File file = new File("graficoPainel12.png");
							ImageIcon logo = new ImageIcon(file.getPath());
							
							labelGrafico.setIcon(logo);
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						//dispose();
						// faz a busca e repassa os valores do banco de dados
						// para a lista de biometrias
						
						//estou apenas testando a funcionalidade de colocar o grafico
						/*SaidaEntradaBiometria saida = new SaidaEntradaBiometria();

						SaidaEntradaPovoamento saidaPovoamento = new SaidaEntradaPovoamento();

						ListaBiometrias listaBiometrias = new ListaBiometrias();
						try {
							listaBiometrias.repassarBiometrias(saida.resgatarBiometrias(idDoPovoamento),
									saidaPovoamento.resgatarPovoamento(idDoPovoamento));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						listaBiometrias.setVisible(true);*/
						// metodo criado para passar a tela sem usar as
						// variaveis da tela inicial
						
						//Home.repassarTelas(listaBiometrias);
					} else {
						// aqui sera onde vai atualizar a biometria
						biometria.editarBiometria(String.valueOf(idBiometria));
						// atualiza a tela tabela de biometrias
						SaidaEntradaPovoamento saidaPovoamento = new SaidaEntradaPovoamento();
						SaidaEntradaBiometria saida = new SaidaEntradaBiometria();
						ListaBiometrias listaBiometrias = new ListaBiometrias();

						try {
							System.out.println("id biometria: " + idBiometria + " id povoamento: " + idDoPovoamento);
							listaBiometrias.repassarBiometrias(saida.resgatarBiometrias(idDoPovoamento),
									saidaPovoamento.resgatarPovoamento(idDoPovoamento));
							Home.repassarTelas(listaBiometrias);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					//dispose();
				} else {
					JOptionPane.showMessageDialog(null, "algum campo não foi devidamente preenchido");

				}
			}
		};
	}
	// Código desnecessário usado apenas para prototipar as telas

	/*
	 * public ActionListener btnEditar() { return new ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { if
	 * (!(textFieldIDPovoamento == null || textFieldQtMorta == null ||
	 * textFieldQtTotal == null)) { String idDoPovoamento =
	 * textFieldIDPovoamento.getText().toString(); int quantidadeMorta =
	 * Integer.parseInt(textFieldQtMorta.getText().toString()); int
	 * quantidadeTotal =
	 * Integer.parseInt(textFieldQtTotal.getText().toString()); String data =
	 * "23/09/2015"; String sistemaProducao = "varal"; double mediaCrescimento =
	 * 66.2; double mortalidade = 0.1; double sobrevivencia = 1.2; Ostra ostra =
	 * new Ostra("master", quantidadeTotal, quantidadeMorta); Ambiente ambiente
	 * = new Ambiente(23, 14); Biometria biometria = new
	 * Biometria(ValidacaoDeDatas.ordenarData(data), sistemaProducao,
	 * mediaCrescimento, mortalidade, sobrevivencia, ostra, ambiente);
	 * biometria.editarBiometria(idDoPovoamento); } else {
	 * JOptionPane.showMessageDialog(null,
	 * "algum campo não foi devidamente preenchido"); }
	 * 
	 * } }; }
	 */
	// usado para calcular as medias das amostras
	public ActionListener btnAdicionar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!textFieldAmostra.getText().equals("")) {
					Calculos calculos = new Calculos();
					contador++;
					mediaCrescimento += Integer.parseInt(textFieldAmostra.getText().toString());
					System.out.println(mediaCrescimento);
					textFieldQuantidadeAmostras.setText(String.valueOf(contador));
					textFieldMediaCrescimento
							.setText(calculos.format(calculos.calculoDaMedia(mediaCrescimento, contador)));

					System.out.println("media de crescimento correto: " + mediaCrescimento / contador);
				} else {
					JOptionPane.showMessageDialog(null, "você precisa preencher o campo");
				}
			}
		};
	}
	// pedaço de código apenas para prototipar as paginas

	/*
	 * public ActionListener btnExcluir() { return new ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { if
	 * (textFieldIDPovoamento != null) { String id =
	 * textFieldIDPovoamento.getText().toString();
	 * Biometria.excluirBiometria(id); } else {
	 * JOptionPane.showMessageDialog(null, "erro ao repassar os dados"); }
	 * 
	 * } }; }
	 */
	// metodo para preencher os dados referentes aquela biometria na hora de
	// atualizar
	public void preencherCampos(Biometria biometria, boolean atualizar) {
		System.out.println("data da biometria: " + biometria.getDataInicial());
		// textFieldDataBiometria.setText(ValidacaoDeDatas.padronizarDatasCampoAtualizacao(biometria.getDataInicial()));
		textFieldMediaCrescimento.setText(String.valueOf(biometria.getMediaCrescimento()));
		textFieldQtMorta.setText(String.valueOf(biometria.getQtMorta()));
		textFieldQtTotal.setText(String.valueOf(biometria.getQtTotal()));
		textFieldSalinidade.setText(String.valueOf(biometria.getSalinidade()));
		textFieldTemperatura.setText(String.valueOf(biometria.getTemperatura()));

		// vamos começar a depuração
		System.out.println("Biometria quantidade total: " + biometria.getQtTotal());
		System.out.println("Biometria quantidade morta: " + biometria.getQtMorta());

		this.idBiometria = biometria.getIDBiometria();
		this.atualizar = atualizar;
	}

	public void atualizarCampos(String idPovoamento) {
		// textFieldIDPovoamento.setText(String.valueOf(povoamento.getIDPovoamentos()));
		textFieldIDPovoamento.setText(String.valueOf(idPovoamento));

	}
}
