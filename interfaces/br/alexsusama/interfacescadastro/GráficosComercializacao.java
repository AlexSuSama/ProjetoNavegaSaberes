package br.alexsusama.interfacescadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.alexsusama.validacoes.ValidacaoDeDatas;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;

public class GráficosComercializacao extends JFrame {
	JFormattedTextField textDataInicial;
	JFormattedTextField textDataFinal;

	int ControladorGrafico = 0;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GráficosComercializacao frame = new GráficosComercializacao();
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
	public GráficosComercializacao() {
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

		JLabel labelGraficos = new JLabel("");
		panel.add(labelGraficos, BorderLayout.CENTER);

		JLabel label = new JLabel("Selecione o Per\u00EDodo");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(22, 50, 119, 14);
		contentPane.add(label);
		try {
			MaskFormatter mascara = new MaskFormatter("##-##-####");
			textDataInicial = new JFormattedTextField(mascara);
			textDataInicial.setBounds(189, 48, 108, 20);
			contentPane.add(textDataInicial);
		} catch (Exception e) {
			// TODO: handle exception
		}
		JLabel label_1 = new JLabel("at\u00E9");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(307, 50, 24, 14);
		contentPane.add(label_1);
		try {
			MaskFormatter mascara = new MaskFormatter("##-##-####");
			textDataFinal = new JFormattedTextField(mascara);
			textDataFinal.setBounds(341, 48, 108, 20);
			contentPane.add(textDataFinal);
		} catch (Exception e) {
			// TODO: handle exception
		}
		JButton button = new JButton("Buscar");
		button.setBounds(483, 47, 89, 23);
		button.addActionListener(btnBuscar());
		contentPane.add(button);

		JRadioButton rdbtnQuantidadeVendida = new JRadioButton("Quantidade vendida");
		rdbtnQuantidadeVendida.setBounds(22, 7, 136, 23);
		rdbtnQuantidadeVendida.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ControladorGrafico = 1;
			}
		});
		contentPane.add(rdbtnQuantidadeVendida);

		JRadioButton rdbtnreasDeComercializao = new JRadioButton("\u00C1reas de comercializa\u00E7\u00E3o");
		rdbtnreasDeComercializao.setBounds(160, 7, 158, 23);
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
	}

	public ActionListener btnBuscar() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String dataInicial = textDataInicial.getText().toString();
				String dataFinal = textDataFinal.getText().toString();
				
				if(ValidacaoDeDatas.verificarData(dataInicial, dataFinal)) {
				switch (ControladorGrafico) {
				case 1:
					JOptionPane.showMessageDialog(null, "qt vendida "+dataFinal+" "+dataInicial);
					
					break;
				case 2:
					JOptionPane.showMessageDialog(null, "comercialização no geral"+dataFinal+" "+dataInicial);
					break;

				default:
					break;
				}}else {
					JOptionPane.showMessageDialog(null,"datas invalidas");
				}
			}
		};
	}
}
