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
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
		setBounds(100, 100, 953, 650);
		
		
		
		// btn e indicadores
		JPanel btnGraficos = new JPanel();
		JPanel btnPovoamentos = new JPanel();
		JPanel btnComercializacao = new JPanel();
		JPanel btnEstoque = new JPanel();

		JPanel indPovoamentos = new JPanel();
		JPanel indComercializacao = new JPanel();
		JPanel indGraficos = new JPanel();
		JPanel indEstoque = new JPanel();

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
		mntmBiometria.setVisible(false);
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
		panel_6.setBounds(10, 501, 917, 78);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel labelAgromar = new JLabel("");
		labelAgromar.setBounds(852, 11, 55, 56);
		Image imgAgromar = new ImageIcon(this.getClass().getResource("/agromar.png")).getImage();
		labelAgromar.setIcon(new ImageIcon(imgAgromar));
		panel_6.add(labelAgromar);
		
		JLabel labelUfpa = new JLabel("");
		labelUfpa.setBounds(764, 11, 55, 56);
		Image imgUfpa = new ImageIcon(this.getClass().getResource("/ufpalogo.png")).getImage();
		labelUfpa.setIcon(new ImageIcon(imgUfpa));
		panel_6.add(labelUfpa);
		
		JLabel labelProex = new JLabel("");
		labelProex.setBounds(646, 25, 113, 42);
		Image imgProex = new ImageIcon(this.getClass().getResource("/proexlogo.png")).getImage();
		labelProex.setIcon(new ImageIcon(imgProex)); 
		panel_6.add(labelProex);
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(10, 11, 118, 479);
		contentPane.add(panel);
		panel.setLayout(null);

		btnPovoamentos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				trocaDeJanelas(TELALISTADEPOVOAMENTOS);
				setColor(btnPovoamentos);
				indPovoamentos.setOpaque(true);
				resetColor(new JPanel[] { btnComercializacao, btnEstoque, btnGraficos },
						new JPanel[] { indComercializacao, indEstoque, indGraficos });
			}
		});
		btnPovoamentos.setBounds(10, 38, 98, 34);
		panel.add(btnPovoamentos);
		btnPovoamentos.setLayout(null);

		JLabel lblPovoamentos = new JLabel("Povoamentos");
		lblPovoamentos.setBounds(11, 5, 76, 16);
		lblPovoamentos.setBackground(Color.LIGHT_GRAY);
		btnPovoamentos.add(lblPovoamentos);

		indPovoamentos.setBackground(Color.LIGHT_GRAY);
		indPovoamentos.setBounds(0, 0, 4, 34);
		btnPovoamentos.add(indPovoamentos);

		btnComercializacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				trocaDeJanelas(TELALISTADECOMERCIALIZACAO);
				setColor(btnComercializacao);
				indComercializacao.setOpaque(true);
				resetColor(new JPanel[] { btnPovoamentos, btnEstoque, btnGraficos },
						new JPanel[] { indEstoque, indPovoamentos, indGraficos });
			}
		});
		btnComercializacao.setBounds(10, 83, 98, 34);
		panel.add(btnComercializacao);
		btnComercializacao.setLayout(null);

		JLabel lblComercializao = new JLabel("Comercializa\u00E7\u00E3o");
		lblComercializao.setBounds(3, 5, 92, 16);
		lblComercializao.setBackground(Color.LIGHT_GRAY);
		btnComercializacao.add(lblComercializao);

		indComercializacao.setBackground(Color.LIGHT_GRAY);
		indComercializacao.setBounds(0, 0, 4, 34);
		btnComercializacao.add(indComercializacao);

		btnEstoque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				trocaDeJanelas(TELADEESTOQUE);
				setColor(btnEstoque);
				indEstoque.setOpaque(true);
				resetColor(new JPanel[] { btnComercializacao, btnGraficos, btnPovoamentos },
						new JPanel[] { indComercializacao, indGraficos, indPovoamentos });
			}
		});
		btnEstoque.setBounds(10, 128, 98, 34);
		panel.add(btnEstoque);
		btnEstoque.setLayout(null);

		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setBounds(26, 5, 46, 16);
		lblEstoque.setBackground(Color.LIGHT_GRAY);
		btnEstoque.add(lblEstoque);

		indEstoque.setBackground(Color.LIGHT_GRAY);
		indEstoque.setBounds(0, 0, 4, 34);
		btnEstoque.add(indEstoque);

		btnGraficos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				trocaDeJanelas(TELADEGRAFICOSBIOMETRICOS);
				setColor(btnGraficos);
				indGraficos.setOpaque(true);
				resetColor(new JPanel[] { btnComercializacao, btnEstoque, btnPovoamentos },
						new JPanel[] { indComercializacao, indEstoque, indPovoamentos });

			}
		});
		btnGraficos.setBounds(10, 170, 98, 34);
		panel.add(btnGraficos);
		btnGraficos.setLayout(null);

		JLabel lblGrficos = new JLabel("Gr\u00E1ficos");
		lblGrficos.setBounds(26, 5, 46, 16);
		lblGrficos.setBackground(Color.LIGHT_GRAY);
		btnGraficos.add(lblGrficos);

		indGraficos.setBackground(Color.LIGHT_GRAY);
		indGraficos.setBounds(0, 0, 4, 34);
		btnGraficos.add(indGraficos);

		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		panel_5.setBounds(10, 434, 98, 34);
		panel.add(panel_5);

		JLabel lblSair = new JLabel("Sair");
		lblSair.setBackground(Color.LIGHT_GRAY);
		panel_5.add(lblSair);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 216, 98, 34);
		panel.add(panel_1);
		
		JLabel lblRelatrio = new JLabel("Relat\u00F3rio");
		lblRelatrio.setBackground(Color.LIGHT_GRAY);
		lblRelatrio.setBounds(26, 0, 72, 16);
		panel_1.add(lblRelatrio);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 0, 4, 34);
		panel_1.add(panel_2);

		desktopPane.setBounds(138, 11, 805, 479);
		contentPane.add(desktopPane);
		desktopPane.setLayout(new BorderLayout(0, 0));
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
				listaComercializacao.setVisible(true);
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
				telaDeEstoque.preencherCampos();
				desktopPane.add(telaDeEstoque);
				telaDeEstoque.setVisible(true);
			} else {
				telaDeEstoque.dispose();
				telaDeEstoque = new TelaDeEstoque();
				telaDeEstoque.preencherCampos();
				desktopPane.add(telaDeEstoque);
				telaDeEstoque.setVisible(true);
				telaDeEstoque.moveToFront();
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
			// desktopPane.removeAll();
			desktopPane.add(tela);
			tela.setVisible(true);
			tela.moveToFront();

		} else {
			System.out.println("vamos ver");
		}
	}

	// teste para mudar de cor
	private void setColor(JPanel pane) {
		pane.setBackground(new Color(41, 57, 200));
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
