package br.alexsusama.interfacescadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.UIManager;

public class Home extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// interfaces do programa
	static CadastroBiometrico cadastroBiometrico;
	static CadastroComercializacao cadastroComercializacao;
	static CadastroPovoamento cadastroPovoamento;
	static CadastroEstoque cadastroEstoque;
	static ListaComercializacao listaComercializacao;
	static ListaPovoamentos listaPovoamentos;
	static GraficosBiometricos graficosBiometricos;
	static TelaDeEstoque telaDeEstoque;
	static EscolhaGrafico escolhaGrafico;
	static TelaRelatorio telaDeRelatorio;

	// variaveis que controlam a tela que vai ser exibida
	static int TELACADASTROBIOMETRICO = 1;
	static int TELACADASTROCOMERCIALIZACAO = 2;
	static int TELACADASTROESTOQUE = 3;
	static int TELACADASTROPOVOAMENTO = 4;
	// variaveis para o segundo item do menu
	static int TELALISTADEPOVOAMENTOS = 5;
	static int TELALISTADECOMERCIALIZACAO = 6;
	static int TELADEGRAFICOSBIOMETRICOS = 7;
	static int TELADEESTOQUE = 8;
	static int TELAESCOLHAGRAFICO = 9;
	static int TELADERELATORIO = 10;

	private JPanel contentPane;
	static JDesktopPane desktopPane = new JDesktopPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("Monitoramento de Ostras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1041, 679);

		// btn
		JPanel btnGraficos = new JPanel();
		JPanel btnPovoamentos = new JPanel();
		JPanel btnComercializacao = new JPanel();
		JPanel btnEstoque = new JPanel();
		JPanel btnRelatorio = new JPanel();
		//indicadores
		JPanel indPovoamentos = new JPanel();
		JPanel indComercializacao = new JPanel();
		JPanel indGraficos = new JPanel();
		JPanel indEstoque = new JPanel();
		JPanel indRelatorio = new JPanel();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 128, 128));
		setJMenuBar(menuBar);

		JMenu mnCadastro = new JMenu("Cadastro");
		mnCadastro.setBackground(new Color(0, 100, 0));
		menuBar.add(mnCadastro);

		// botão usado para entrar na biometria mais rápido para depuração
		JMenuItem mntmBiometria = new JMenuItem("Biometria");
		mntmBiometria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trocaDeJanelas(TELACADASTROBIOMETRICO);
			}
		});
		//mntmBiometria.setVisible(true);
		mnCadastro.add(mntmBiometria);

		JMenuItem mntmPovoamento = new JMenuItem("Povoamento");
		mntmPovoamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trocaDeJanelas(TELACADASTROPOVOAMENTO);
			}
		});
		mnCadastro.add(mntmPovoamento);

		JMenuItem mntmComercializao = new JMenuItem("Comercializa\u00E7\u00E3o");
		mntmComercializao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trocaDeJanelas(TELACADASTROCOMERCIALIZACAO);
			}
		});
		mnCadastro.add(mntmComercializao);

		JMenuItem mntmEstoque = new JMenuItem("Estoque");
		mntmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trocaDeJanelas(TELACADASTROESTOQUE);
			}
		});
		mnCadastro.add(mntmEstoque);

		JMenu mnPovoamentos = new JMenu("Listas");
		menuBar.add(mnPovoamentos);

		JMenuItem mntmPovoamentos = new JMenuItem("Povoamentos");
		mntmPovoamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trocaDeJanelas(TELALISTADEPOVOAMENTOS);
			}
		});
		mnPovoamentos.add(mntmPovoamentos);

		JMenuItem mntmComercializaes = new JMenuItem("Comercializa\u00E7\u00F5es");
		mntmComercializaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trocaDeJanelas(TELALISTADECOMERCIALIZACAO);
			}
		});
		mnPovoamentos.add(mntmComercializaes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(173, 216, 230));
		panel_6.setBounds(10, 530, 1005, 89);
		contentPane.add(panel_6);
		panel_6.setLayout(null);

		JLabel labelAgromar = new JLabel("");
		labelAgromar.setIcon(new ImageIcon(Home.class.getResource("/br/alexsusama/imagens/agromar.png")));
		labelAgromar.setBounds(926, 22, 55, 56);
		//Image imgAgromar = new ImageIcon(this.getClass().getResource("/agromar.png")).getImage();
		//labelAgromar.setIcon(new ImageIcon(imgAgromar));
		panel_6.add(labelAgromar);
 
		JLabel labelUfpa = new JLabel("");
		labelUfpa.setIcon(new ImageIcon(Home.class.getResource("/br/alexsusama/imagens/logoUfpa.png")));
		labelUfpa.setBounds(843, 11, 55, 67);
		
		//Image imgUfpa = new ImageIcon(this.getClass().getResource("/ufpalogo.png")).getImage();
		//labelUfpa.setIcon(new ImageIcon(imgUfpa));
		panel_6.add(labelUfpa);

		JLabel labelProex = new JLabel("");
		labelProex.setIcon(new ImageIcon(Home.class.getResource("/br/alexsusama/imagens/proexlogo.png")));
		labelProex.setBounds(720, 22, 113, 42);
		//Image imgProex = new ImageIcon(this.getClass().getResource("/proexlogo.png")).getImage();
		//labelProex.setIcon(new ImageIcon(imgProex));
		panel_6.add(labelProex);
		
		JLabel lblDensenvolvimento = new JLabel("Densenvolvimento");
		lblDensenvolvimento.setBounds(720, 11, 102, 14);
		panel_6.add(lblDensenvolvimento);
		
		JLabel lblParceria = new JLabel("Parceria");
		lblParceria.setBounds(926, 11, 55, 14);
		panel_6.add(lblParceria);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(10, 40, 190, 479);
		contentPane.add(panel);
		panel.setLayout(null);

		btnPovoamentos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				trocaDeJanelas(TELALISTADEPOVOAMENTOS);
				setColor(btnPovoamentos);
				indPovoamentos.setOpaque(true);
				resetColor(new JPanel[] { btnComercializacao, btnEstoque, btnGraficos,btnRelatorio },
						new JPanel[] { indComercializacao, indEstoque, indGraficos, indRelatorio });
			}
		});
		btnPovoamentos.setBounds(10, 50, 170, 47);
		panel.add(btnPovoamentos);
		btnPovoamentos.setLayout(null);

		JLabel lblPovoamentos = new JLabel("Povoamentos");
		lblPovoamentos.setBounds(61, 11, 109, 16);
		lblPovoamentos.setBackground(Color.LIGHT_GRAY);
		btnPovoamentos.add(lblPovoamentos);

		indPovoamentos.setBackground(Color.LIGHT_GRAY);
		indPovoamentos.setBounds(0, 0, 4, 47);
		btnPovoamentos.add(indPovoamentos);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Home.class.getResource("/br/alexsusama/imagens/icone menor.png")));
		//Image imgBiometria = new ImageIcon(this.getClass().getResource("/imagens/iconePovoamentoMenu.png")).getImage();

		String diretorio = "/br/alexsusama/imagens/iconePovoamentoMenu.png";
	
		/*URL resource = getClass().getResource(diretorio);
         try {
			File file = new File(resource.toURI());
			ImageIcon icon = new ImageIcon(file.getAbsolutePath());
			
			label_5.setIcon(icon);
			
         } catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
         //label_5.setIcon(new ImageIcon(imgBiometria));
		label_5.setBounds(10, 0, 46, 47);
		btnPovoamentos.add(label_5);

		btnComercializacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				trocaDeJanelas(TELALISTADECOMERCIALIZACAO);
				setColor(btnComercializacao);
				indComercializacao.setOpaque(true);
				resetColor(new JPanel[] { btnPovoamentos, btnEstoque, btnGraficos,btnRelatorio },
						new JPanel[] { indEstoque, indPovoamentos, indGraficos, indRelatorio });
			}
		});
		btnComercializacao.setBounds(10, 282, 170, 47);
		panel.add(btnComercializacao);
		btnComercializacao.setLayout(null);

		JLabel lblComercializao = new JLabel("Comercializa\u00E7\u00E3o");
		lblComercializao.setBounds(62, 11, 98, 16);
		lblComercializao.setBackground(Color.LIGHT_GRAY);
		btnComercializacao.add(lblComercializao);

		indComercializacao.setBackground(Color.LIGHT_GRAY);
		indComercializacao.setBounds(0, 0, 4, 47);
		btnComercializacao.add(indComercializacao);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Home.class.getResource("/br/alexsusama/imagens/iconeComercializacaoMenu.png")));
		//Image imgComercializacao = new ImageIcon(this.getClass().getResource("/icone-comercializacao.png")).getImage();
		//label.setIcon(new ImageIcon(imgComercializacao));
		label.setBounds(10, 0, 46, 47);
		btnComercializacao.add(label);

		btnEstoque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				trocaDeJanelas(TELADEESTOQUE);
				setColor(btnEstoque);
				indEstoque.setOpaque(true);
				resetColor(new JPanel[] { btnComercializacao, btnGraficos, btnPovoamentos,btnRelatorio },
						new JPanel[] { indComercializacao, indGraficos, indPovoamentos,indRelatorio });
			}
		});
		btnEstoque.setBounds(10, 108, 170, 47);
		panel.add(btnEstoque);
		btnEstoque.setLayout(null);

		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setBounds(66, 11, 46, 16);
		lblEstoque.setBackground(Color.LIGHT_GRAY);
		btnEstoque.add(lblEstoque);

		indEstoque.setBackground(Color.LIGHT_GRAY);
		indEstoque.setBounds(0, 0, 4, 47);
		btnEstoque.add(indEstoque);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Home.class.getResource("/br/alexsusama/imagens/iconeEstoqueMenu.png")));
		//Image imgEstoque = new ImageIcon(this.getClass().getResource("/icone-estoque.png")).getImage();
		//label_1.setIcon(new ImageIcon(imgEstoque));
		label_1.setBounds(10, 0, 46, 47);
		btnEstoque.add(label_1);

		btnGraficos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				trocaDeJanelas(TELAESCOLHAGRAFICO);
				setColor(btnGraficos);
				indGraficos.setOpaque(true);
				resetColor(new JPanel[] { btnComercializacao, btnEstoque, btnPovoamentos,btnRelatorio },
						new JPanel[] { indComercializacao, indEstoque, indPovoamentos,indRelatorio });

			}
		});
		btnGraficos.setBounds(10, 166, 170, 47);
		panel.add(btnGraficos);
		btnGraficos.setLayout(null);

		JLabel lblGrficos = new JLabel("Gr\u00E1ficos");
		lblGrficos.setBounds(63, 11, 46, 16);
		lblGrficos.setBackground(Color.LIGHT_GRAY);
		btnGraficos.add(lblGrficos);

		indGraficos.setBackground(Color.LIGHT_GRAY);
		indGraficos.setBounds(0, 0, 4, 47);
		btnGraficos.add(indGraficos);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Home.class.getResource("/br/alexsusama/imagens/iconeGraficoMenu.png")));
		//Image imgGrafico = new ImageIcon(this.getClass().getResource("/icone-graficos.png")).getImage();
		//label_2.setIcon(new ImageIcon(imgGrafico));
		label_2.setBounds(7, 0, 46, 47);
		btnGraficos.add(label_2);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(211, 211, 211));
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				dispose();
			}
		});
		panel_5.setBounds(10, 415, 170, 34);
		panel.add(panel_5);

		JLabel lblSair = new JLabel("Sair");
		lblSair.setBackground(Color.LIGHT_GRAY);
		panel_5.add(lblSair);

		
		btnRelatorio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				trocaDeJanelas(TELADERELATORIO);
				setColor(btnRelatorio);
				indRelatorio.setOpaque(true);
				resetColor(new JPanel[] { btnPovoamentos, btnEstoque, btnGraficos,btnComercializacao},
						new JPanel[] { indEstoque, indPovoamentos, indGraficos,indComercializacao });
			}
		});
		btnRelatorio.setLayout(null);
		btnRelatorio.setBounds(10, 224, 170, 47);
		panel.add(btnRelatorio);

		JLabel lblRelatrio = new JLabel("Relat\u00F3rio");
		lblRelatrio.setBackground(Color.LIGHT_GRAY);
		lblRelatrio.setBounds(64, 11, 81, 16);
		btnRelatorio.add(lblRelatrio);
		
		indRelatorio.setBackground(Color.LIGHT_GRAY);
		indRelatorio.setBounds(0, 0, 4, 47);
		btnRelatorio.add(indRelatorio);

		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Home.class.getResource("/br/alexsusama/imagens/iconeRelat\u00F3rioMenu.png")));
		//Image imgRelatorio = new ImageIcon(this.getClass().getResource("/icone-relatorio.png")).getImage();
		//label_6.setIcon(new ImageIcon(imgRelatorio));
		label_6.setBounds(8, 0, 46, 47);
		btnRelatorio.add(label_6);

		desktopPane.setBounds(210, 40, 805, 479);
		contentPane.add(desktopPane); 
		desktopPane.setLayout(new BorderLayout(0, 0));

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Home.class.getResource("/br/alexsusama/imagens/ostraInit.png")));
		//Image imgOstraLogo = new ImageIcon(this.getClass().getResource("/ostra.png")).getImage();
		//label_4.setIcon(new ImageIcon(imgOstraLogo));
		desktopPane.add(label_4, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(175, 238, 238));
		panel_3.setBounds(10, 0, 1005, 37);
		contentPane.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Home.class.getResource("/br/alexsusama/imagens/top.png")));
		label_3.setBackground(new Color(244, 242, 232));
		//Image imgTop = new ImageIcon(this.getClass().getResource("/top.png")).getImage();
		//label_3.setIcon(new ImageIcon(imgTop));
		panel_3.add(label_3, BorderLayout.CENTER);
	}

	public static void trocaDeJanelas(int janela) {
		switch (janela) {
		case 1:
			if (cadastroBiometrico == null) {
				cadastroBiometrico = new CadastroBiometrico();
				desktopPane.add(cadastroBiometrico);
				cadastroBiometrico.setVisible(true);
			} else {
				cadastroBiometrico.dispose();
				cadastroBiometrico = new CadastroBiometrico();
				desktopPane.add(cadastroBiometrico);
				cadastroBiometrico.setVisible(true);
				cadastroBiometrico.moveToFront();
			}
			break;
		case 2:
			if (cadastroComercializacao == null) {
				cadastroComercializacao = new CadastroComercializacao();
				desktopPane.add(cadastroComercializacao);
				cadastroComercializacao.setVisible(true);
			} else {
				cadastroComercializacao.dispose();
				cadastroComercializacao = new CadastroComercializacao();
				desktopPane.add(cadastroComercializacao);
				cadastroComercializacao.setVisible(true);
				cadastroComercializacao.moveToFront();
			}
			break;
		case 3:
			if (cadastroEstoque == null) {
				cadastroEstoque = new CadastroEstoque();
				desktopPane.add(cadastroEstoque);
				cadastroEstoque.setVisible(true);
			} else {
				cadastroEstoque.dispose();
				cadastroEstoque = new CadastroEstoque();
				desktopPane.add(cadastroEstoque);
				cadastroEstoque.setVisible(true);
				cadastroEstoque.moveToFront();
			}
			break;
		case 4:
			if (cadastroPovoamento == null) {
				cadastroPovoamento = new CadastroPovoamento();
				desktopPane.add(cadastroPovoamento);
				cadastroPovoamento.setVisible(true);
			} else {
				cadastroPovoamento.dispose();
				cadastroPovoamento = new CadastroPovoamento();
				desktopPane.add(cadastroPovoamento);
				cadastroPovoamento.setVisible(true);
				cadastroPovoamento.moveToFront();
			}
			break;
		case 5:
			if (listaPovoamentos == null) {
				listaPovoamentos = new ListaPovoamentos();
				desktopPane.add(listaPovoamentos);
				listaPovoamentos.setVisible(true);
			} else {
				listaPovoamentos.dispose();
				listaPovoamentos = new ListaPovoamentos();
				desktopPane.add(listaPovoamentos);
				listaPovoamentos.setVisible(true);
				listaPovoamentos.moveToFront();
			}
			break;
		case 6:
			if (listaComercializacao == null) {
				listaComercializacao = new ListaComercializacao();
				desktopPane.add(listaComercializacao);
				listaComercializacao.setVisible(true);
			} else {
				listaComercializacao.dispose();
				listaComercializacao = new ListaComercializacao();
				desktopPane.add(listaComercializacao);
				listaComercializacao.setVisible(true);
				listaComercializacao.moveToFront();
			}
			break;
		case 7:
			if (graficosBiometricos == null) {
				graficosBiometricos = new GraficosBiometricos();
				desktopPane.add(graficosBiometricos);
				graficosBiometricos.setVisible(true);
			} else {
				graficosBiometricos.dispose();
				graficosBiometricos = new GraficosBiometricos();
				desktopPane.add(graficosBiometricos);
				graficosBiometricos.setVisible(true);
				graficosBiometricos.moveToFront();
			}
			break;
		case 8:
			if (telaDeEstoque == null) {
				telaDeEstoque = new TelaDeEstoque();
				// estou tirando esse método para que possa ser inicializada
				// apenas a tela sem nenhuma informação
				// telaDeEstoque.preencherCampos("");
				desktopPane.add(telaDeEstoque);
				telaDeEstoque.setVisible(true);
			} else {
				telaDeEstoque.dispose();
				telaDeEstoque = new TelaDeEstoque();
				// estou tirando esse método para que possa ser inicializada
				// apenas a tela sem nenhuma informação
				// telaDeEstoque.preencherCampos("");
				desktopPane.add(telaDeEstoque);
				telaDeEstoque.setVisible(true);
				telaDeEstoque.moveToFront();
			}
			break;
		case 9:
			if (escolhaGrafico == null) {
				escolhaGrafico = new EscolhaGrafico();
				desktopPane.add(escolhaGrafico);
				escolhaGrafico.setVisible(true);
			} else {
				escolhaGrafico.dispose();
				escolhaGrafico = new EscolhaGrafico();
				desktopPane.add(escolhaGrafico);
				escolhaGrafico.setVisible(true);
				escolhaGrafico.moveToFront();
			}
			break;
		case 10:
			if (telaDeRelatorio == null) {
				telaDeRelatorio = new TelaRelatorio();
				// estou tirando esse método para que possa ser inicializada
				// apenas a tela sem nenhuma informação
				// telaDeEstoque.preencherCampos("");
				desktopPane.add(telaDeRelatorio);
				telaDeRelatorio.setVisible(true);
			} else {
				telaDeRelatorio.dispose();
				telaDeRelatorio = new TelaRelatorio();
				// estou tirando esse método para que possa ser inicializada
				// apenas a tela sem nenhuma informação
				// telaDeEstoque.preencherCampos("");
				desktopPane.add(telaDeRelatorio);
				telaDeRelatorio.setVisible(true);
				telaDeRelatorio.moveToFront();
			}
			break;
		default:
			break;
		}
	}

	// metodo usado para a atualizacao de telas que estão em outras interfaces
	public static void repassarTelas(JInternalFrame tela) {
		if (tela != null) {
			tela.dispose();
			desktopPane.removeAll();
			desktopPane.add(tela);
			tela.setVisible(true);
			tela.moveToFront();

		} else {
			System.out.println("vamos ver");
		}
	}

	// teste para mudar de cor
	private void setColor(JPanel pane) {
		pane.setBackground(new Color(95, 107, 215));
	}

	private void resetColor(JPanel[] pane, JPanel[] indicators) {
		for (int i = 0; i < pane.length; i++) {
			pane[i].setBackground(new Color(230, 230, 230));

		}
		for (int i = 0; i < indicators.length; i++) {
			indicators[i].setOpaque(false);
		}

	}
}
