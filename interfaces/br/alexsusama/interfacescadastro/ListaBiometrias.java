package br.alexsusama.interfacescadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.alexsusama.modelo.Biometria;
import br.alexsusama.modelo.Povoamento;
import br.alexsusama.persisntencia.SaidaEntradaBiometria;
import br.alexsusama.persisntencia.SaidaEntradaPovoamento;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ListaBiometrias extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;

	List<Biometria> biometrias;
	private JTextField textFieldPovoamento;
	private JTextField textFieldProdutor;
	private JTextField textFieldMunicipio;
	private JTextField textField_3;
	private JTextField textFieldLocalidade;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField;

	private String idCapturado = "";

	int idPovoamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaBiometrias frame = new ListaBiometrias();
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
	public ListaBiometrias() {
		setTitle("Biometrias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 798, 108);
		panel.setBackground(new Color(95, 158, 160));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblPovoamento = new JLabel("Povoamento");
		lblPovoamento.setBounds(10, 11, 75, 14);
		panel.add(lblPovoamento);

		JLabel lblProdutor = new JLabel("Produtor");
		lblProdutor.setBounds(10, 65, 55, 14);
		panel.add(lblProdutor);

		JLabel lblLocal = new JLabel("Localidade");
		lblLocal.setBounds(477, 11, 75, 14);
		panel.add(lblLocal);

		JLabel lblMunicipio = new JLabel("Municipio");
		lblMunicipio.setBounds(226, 11, 55, 14);
		panel.add(lblMunicipio);

		JLabel lblCoordenadas = new JLabel("Coordenadas ");
		lblCoordenadas.setBounds(413, 49, 82, 14);
		panel.add(lblCoordenadas);

		textFieldPovoamento = new JTextField();
		textFieldPovoamento.setEditable(false);
		textFieldPovoamento.setBounds(91, 8, 125, 20);
		panel.add(textFieldPovoamento);
		textFieldPovoamento.setColumns(10);

		textFieldProdutor = new JTextField();
		textFieldProdutor.setEditable(false);
		textFieldProdutor.setColumns(10);
		textFieldProdutor.setBounds(91, 62, 125, 20);
		panel.add(textFieldProdutor);

		textFieldMunicipio = new JTextField();
		textFieldMunicipio.setEditable(false);
		textFieldMunicipio.setColumns(10);
		textFieldMunicipio.setBounds(291, 8, 144, 20);
		panel.add(textFieldMunicipio);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(599, 46, 34, 20);
		panel.add(textField_3);

		textFieldLocalidade = new JTextField();
		textFieldLocalidade.setEditable(false);
		textFieldLocalidade.setColumns(10);
		textFieldLocalidade.setBounds(547, 8, 227, 20);
		panel.add(textFieldLocalidade);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(655, 46, 34, 20);
		panel.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(699, 46, 34, 20);
		panel.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(599, 77, 34, 20);
		panel.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(655, 77, 34, 20);
		panel.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(699, 77, 34, 20);
		panel.add(textField_9);

		JLabel lblL = new JLabel("Late");
		lblL.setBounds(547, 49, 42, 14);
		panel.add(lblL);

		JLabel lblLong = new JLabel("Long");
		lblLong.setBounds(547, 80, 42, 14);
		panel.add(lblLong);

		JButton btnGrficos = new JButton("Gr\u00E1ficos");
		btnGrficos.setBounds(698, 262, 89, 41);
		btnGrficos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				GraficosBiometricos graficosBiometricos = new GraficosBiometricos();

				graficosBiometricos.setVisible(true);
				Home.repassarTelas(graficosBiometricos);
			}
		});
		contentPane.add(btnGrficos);

		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(698, 133, 89, 41);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroBiometrico cadastro = new CadastroBiometrico();
				cadastro.atualizarCampos(textFieldPovoamento.getText().toString());
				// cadastro.setVisible(true);
				Home.repassarTelas(cadastro);
			}
		});
		contentPane.add(btnNovo);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(698, 176, 89, 41);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirmar = JOptionPane.showConfirmDialog(null, "você tem certeza?");
				switch (confirmar) {
				case 0:
					if (!(idCapturado.equals(""))) {
						System.out.println("id capturado: " + idCapturado);
						SaidaEntradaBiometria saida = new SaidaEntradaBiometria();
						saida.excluirBiometria(idCapturado);

						// Atualiza a janela ao excluir a biometria da lista
						SaidaEntradaPovoamento saidaPovoamento = new SaidaEntradaPovoamento();

						ListaBiometrias listaBiometrias = new ListaBiometrias();
						try {
							listaBiometrias.repassarBiometrias(saida.resgatarBiometrias(String.valueOf(idPovoamento)),
							saidaPovoamento.resgatarPovoamento(String.valueOf(idPovoamento)));
							Home.repassarTelas(listaBiometrias);
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null, "não foi possível atualizar as telas");
							e.printStackTrace();
						}
						dispose();

					} else {
						mensagemDeClick();
					}
					break;

				default:
					System.out.println("você decidiu não excluir");
					break;
				}

			}
		});
		contentPane.add(btnExcluir);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(698, 220, 89, 41);
		btnEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(idCapturado.equals(""))) {
					SaidaEntradaBiometria saida = new SaidaEntradaBiometria();
					// esta utilizando os dois métodos para preencher os campos
					// referentes aos dados da biometria e ao id do povoamento

					CadastroBiometrico editarBiometria = new CadastroBiometrico();
					editarBiometria.preencherCampos(saida.resgatarBiometria(idCapturado), false);
					editarBiometria.atualizarCampos(textFieldPovoamento.getText().toString());
					Home.repassarTelas(editarBiometria);

					// segundo log de depuração
					System.out.println("log de depuração 2, listabiometrias");
					System.out.println("quantidade morta log 2: " + saida.resgatarBiometria(idCapturado).getQtMorta());
					System.out.println("quantidade total log 2: " + saida.resgatarBiometria(idCapturado).getQtTotal());
					dispose();
				} else {
					mensagemDeClick();
				}
			}
		});
		contentPane.add(btnEditar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBounds(698, 389, 89, 41);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}

		});
		contentPane.add(btnFechar);

	}

	public void tela() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 130, 678, 292);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(173, 216, 220));
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			// Importe a classe java.awt.event.MouseEvent
			public void mouseClicked(MouseEvent e) {
				// Se o botão direito do mouse foi pressionado
				if (e.getButton() == MouseEvent.BUTTON1) {
					// Exibe o popup menu na posição do mouse.
					String id = table.getValueAt(table.getSelectedRow(), 0).toString();
					try {
						idCapturado = id;

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Coleta", "Total", "Unidades mortas", "Sistema", "Sobreviv\u00EAncia",
						"Mortalidade", "M\u00E9dia", "Salinidade", "	Temperatura", "Est\u00E1gio" }));
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		SaidaEntradaPovoamento resgatar = new SaidaEntradaPovoamento();
		try {
			if (biometrias != null) {
				for (Biometria a : biometrias) {
					modelo.addRow(new Object[] { a.getIDBiometria(), a.getDataInicial(), a.getQtTotal(), a.getQtMorta(),
							a.getSistemaProducao(), a.getSobrevivencia(), a.getMortalidade(), a.getMediaCrescimento(),
							a.getSalinidade(), a.getTemperatura(), a.getEstagioCrescimento() });

				}
			} else {
				System.out.println("campos nulos");
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scrollPane.setViewportView(table);
	}

	// método que repassa os valores antes da tela ser exibida para o usuário
	public void repassarBiometrias(List<Biometria> bio, Povoamento povoamento) {
		textFieldLocalidade.setText(povoamento.getLocalidade());
		textFieldMunicipio.setText(povoamento.getMunicipio());
		textFieldPovoamento.setText(String.valueOf(povoamento.getIDPovoamentos()));
		textFieldProdutor.setText(povoamento.getNomeOstricultor());
		idPovoamento = povoamento.getIDPovoamentos();
		this.biometrias = bio;

		// invoca o método para criar a lista de biometrias
		tela();
	}

	public void mensagemDeClick() {
		JOptionPane.showMessageDialog(null, "Você precisa escolher uma biometria primeiro!");
	}
}
