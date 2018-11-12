package br.alexsusama.interfacescadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class EscolhaGrafico extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EscolhaGrafico frame = new EscolhaGrafico();
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
	public EscolhaGrafico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			//JOptionPane.showMessageDialog(null, "vc apertou comercialização");
			GraficosComercializacao graficosComercializacao = new GraficosComercializacao();
			Home.repassarTelas(graficosComercializacao);
			}
		});
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(274, 118, 219, 188);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblComercializao = new JLabel("");
		lblComercializao.setBackground(Color.LIGHT_GRAY);
		lblComercializao.setIcon(new ImageIcon(EscolhaGrafico.class.getResource("/br/alexsusama/imagens/iconeGraficoComercializacao.png")));
		panel.add(lblComercializao);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Home.repassarTelas(new GraficosEstoque());
			}
		});
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(45, 118, 219, 188);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBiometria = new JLabel("");
		lblBiometria.setIcon(new ImageIcon(EscolhaGrafico.class.getResource("/br/alexsusama/imagens/iconeEstoque.png")));
		panel_1.add(lblBiometria);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//JOptionPane.showMessageDialog(null, "vc pressionou biometria");
				GraficosBiometricos graficosBiometricos = new GraficosBiometricos();
				Home.repassarTelas(graficosBiometricos);
			}
		});
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(503, 118, 219, 188);
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEstoque = new JLabel("");
		lblEstoque.setIcon(new ImageIcon(EscolhaGrafico.class.getResource("/br/alexsusama/imagens/iconeGraficoBiometria.png")));
		panel_2.add(lblEstoque);
		
		JLabel lblComercializao_1 = new JLabel("Comercializa\u00E7\u00E3o");
		lblComercializao_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblComercializao_1.setBounds(331, 317, 109, 22);
		contentPane.add(lblComercializao_1);
		
		JLabel lblBiometria_1 = new JLabel("Biometria");
		lblBiometria_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBiometria_1.setBounds(583, 317, 80, 22);
		contentPane.add(lblBiometria_1);
		
		JLabel lblEscolhaOGrfico = new JLabel("Escolha o tipo de gr\u00E1fico:");
		lblEscolhaOGrfico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEscolhaOGrfico.setBounds(45, 33, 219, 31);
		contentPane.add(lblEscolhaOGrfico);
		
		JLabel lblEstoque_1 = new JLabel("Estoque");
		lblEstoque_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEstoque_1.setBounds(128, 317, 91, 22);
		contentPane.add(lblEstoque_1);
	}
}
