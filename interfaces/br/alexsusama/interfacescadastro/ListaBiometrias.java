package br.alexsusama.interfacescadastro;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	List<Biometria> biometrias;
	private JTextField textFieldPovoamento;
	private JTextField textFieldProdutor;
	private JTextField textFieldMunicipio;
	private JTextField textGrausLate;
	private JTextField textFieldLocalidade;
	private JTextField textMinutosLate;
	private JTextField textSegundosLate;
	private JTextField textGrausLong;
	private JTextField textMinutosLong;
	private JTextField textSegundosLong;

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

		textGrausLate = new JTextField();
		textGrausLate.setEditable(false);
		textGrausLate.setColumns(10);
		textGrausLate.setBounds(599, 46, 34, 20);
		panel.add(textGrausLate);

		textFieldLocalidade = new JTextField();
		textFieldLocalidade.setEditable(false);
		textFieldLocalidade.setColumns(10);
		textFieldLocalidade.setBounds(547, 8, 227, 20);
		panel.add(textFieldLocalidade);

		textMinutosLate = new JTextField();
		textMinutosLate.setEditable(false);
		textMinutosLate.setColumns(10);
		textMinutosLate.setBounds(655, 46, 34, 20);
		panel.add(textMinutosLate);

		textSegundosLate = new JTextField();
		textSegundosLate.setEditable(false);
		textSegundosLate.setColumns(10);
		textSegundosLate.setBounds(699, 46, 34, 20);
		panel.add(textSegundosLate);

		textGrausLong = new JTextField();
		textGrausLong.setEditable(false);
		textGrausLong.setColumns(10);
		textGrausLong.setBounds(599, 77, 34, 20);
		panel.add(textGrausLong);

		textMinutosLong = new JTextField();
		textMinutosLong.setEditable(false);
		textMinutosLong.setColumns(10);
		textMinutosLong.setBounds(655, 77, 34, 20);
		panel.add(textMinutosLong);

		textSegundosLong = new JTextField();
		textSegundosLong.setEditable(false);
		textSegundosLong.setColumns(10);
		textSegundosLong.setBounds(699, 77, 34, 20);
		panel.add(textSegundosLong);

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
				Home.repassarTelas(new ListaPovoamentos());
				dispose();
			}

		});
		contentPane.add(btnFechar);

	}

	// metodo para criar a tabela que vai receber os valores da biometria
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
		//SaidaEntradaPovoamento resgatar = new SaidaEntradaPovoamento();
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
		textGrausLate.setText(String.valueOf(povoamento.getGrausLat()));
		textMinutosLate.setText(String.valueOf(povoamento.getMinutosLat()));
		textSegundosLate.setText(String.valueOf(povoamento.getSegundosLat()));
		
		textGrausLong.setText(String.valueOf(povoamento.getGrausLong()));
		textMinutosLong.setText(String.valueOf(povoamento.getMinutosLong()));
		textSegundosLong.setText(String.valueOf(povoamento.getSegundosLong()));
		
		this.biometrias = bio;

		// invoca o método para criar a lista de biometrias
		tela();
	}

	public void mensagemDeClick() {
		JOptionPane.showMessageDialog(null, "Você precisa escolher uma biometria primeiro!");
	}
}
