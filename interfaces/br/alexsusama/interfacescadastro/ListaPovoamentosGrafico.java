package br.alexsusama.interfacescadastro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.alexsusama.modelo.Povoamento;
import br.alexsusama.persisntencia.SaidaEntradaPovoamento;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaPovoamentosGrafico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTable table;
	private String idCapturado = "";

	int controladorDeSelecao = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaPovoamentosGrafico frame = new ListaPovoamentosGrafico();
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
	public ListaPovoamentosGrafico() {
		setTitle("Povoamentos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 26, 678, 238);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setShowVerticalLines(false);
		table.setBackground(new Color(0, 139, 139));
		table.setForeground(new Color(211, 211, 211));
		table.getTableHeader().setBackground(new Color(80, 139, 139));
		table.setRowHeight(30);

		table.addMouseListener(new java.awt.event.MouseAdapter() {
			// Importe a classe java.awt.event.MouseEvent
			public void mouseClicked(MouseEvent e) {
				// Se o bot�o direito do mouse foi pressionado
				if (e.getButton() == MouseEvent.BUTTON1) {
					// Exibe o popup menu na posi��o do mouse.
					String id = table.getValueAt(table.getSelectedRow(), 0).toString();
				//	SaidaEntradaBiometria saida = new SaidaEntradaBiometria();
				//	SaidaEntradaPovoamento saidaPovoamento = new SaidaEntradaPovoamento();
					try {

						idCapturado = id;

						switch (controladorDeSelecao) {
						case 0:
							GraficosBiometricos graficosBiometricos = new GraficosBiometricos();
							graficosBiometricos.atualizarInfoPov(idCapturado);

							Home.repassarTelas(graficosBiometricos);

							break;
						case 1:
							GraficosComercializacao graficosComercializacao = new GraficosComercializacao();
							graficosComercializacao.atualizarInfoPov(idCapturado);
							
							Home.repassarTelas(graficosComercializacao);
							
							break;
						default:
							break;
						}

						System.out.println("id do povoamento: " + id);

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		// table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Povoamento", "Ostricultor",
				"Munic\u00EDpio", "Localidade", "Data Inicial", "Ultima biometria", "Total ostras", "Est\u00E1gio" }));
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		SaidaEntradaPovoamento resgatar = new SaidaEntradaPovoamento();
		try {
			for (Povoamento a : resgatar.resgatarPovoamentos()) {
				modelo.addRow(new Object[] { a.getIDPovoamentos(), a.getNomeOstricultor(), a.getMunicipio(),
						a.getLocalidade(), a.getDataInicialPovoamento(), a.getMaxData(), a.getQtTotal(),
						a.getEstagioCrescimento() });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scrollPane.setViewportView(table);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(688, 218, 95, 41);
		contentPane.add(btnFechar);

		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setBounds(688, 30, 95, 41);
		contentPane.add(btnSelecionar);
	}

	public boolean verificarId(String idCaturado) {
		if (idCaturado.equals("")) {
			return false;
		} else {
			return true;
		}

	}
 
	public void controladorDeSelecao(int tela) {
		this.controladorDeSelecao = tela;
	}

}
