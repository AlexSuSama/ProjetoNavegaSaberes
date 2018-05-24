package br.alexsusama.interfacescadastro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.alexsusama.modelo.Biometria;
import br.alexsusama.modelo.Povoamento;
import br.alexsusama.persisntencia.SaidaEntradaBiometria;
import br.alexsusama.persisntencia.SaidaEntradaPovoamento;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaPovoamentos extends JInternalFrame {

	private JPanel contentPane;

	private JTable table;
	private String idCapturado = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaPovoamentos frame = new ListaPovoamentos();
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
	public ListaPovoamentos() {
		setTitle("Povoamentos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 26, 678, 339);
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
				// Se o botão direito do mouse foi pressionado
				if (e.getButton() == MouseEvent.BUTTON1) {
					// Exibe o popup menu na posição do mouse.
					String id = table.getValueAt(table.getSelectedRow(), 0).toString();
					SaidaEntradaBiometria saida = new SaidaEntradaBiometria();
					SaidaEntradaPovoamento saidaPovoamento = new SaidaEntradaPovoamento();
					try {
						/*
						 * ListaBiometrias listaBiometrias = new
						 * ListaBiometrias();
						 * listaBiometrias.repassarBiometrias(saida.
						 * resgatarBiometrias(id),
						 * saidaPovoamento.resgatarPovoamento(id));
						 * listaBiometrias.setVisible(true);
						 */
						idCapturado = id;
						System.out.println("id do povoamento: " + id);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		// table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Povoamento", "Ostricultor", "Munic\u00EDpio",
						"Localidade", "Data Inicial", "Ultima biometria", "Sistema", "Total ostras", "Est\u00E1gio" }));
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		SaidaEntradaPovoamento resgatar = new SaidaEntradaPovoamento();
		try {
			for (Povoamento a : resgatar.resgatarPovoamentos()) {
				modelo.addRow(new Object[] { a.getIDPovoamentos(), a.getNomeOstricultor(), a.getMunicipio(),
						a.getLocalidade(), a.getDataInicialPovoamento(), a.getMaxData(), a.getSistema(), a.getQtTotal(),
						a.getEstagioCrescimento() });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scrollPane.setViewportView(table);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (verificarId(idCapturado)) {
					SaidaEntradaPovoamento saida = new SaidaEntradaPovoamento();
					try {

						AtualizarPovoamento atualizarPovoamento = new AtualizarPovoamento();
						atualizarPovoamento.AtualizarCampos(saida.resgatarPovoamento(idCapturado));
						atualizarPovoamento.setVisible(true);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,
								"Erro ao atualizar a lista de povoamentos? " + e1.getMessage());
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null, "você precisa escolher um povoamento primeiro");
				}
			}
		});
		btnEditar.setBounds(688, 74, 95, 41);
		contentPane.add(btnEditar);

		JButton btnDetalhes = new JButton("Detalhes");
		btnDetalhes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaidaEntradaBiometria saida = new SaidaEntradaBiometria();
				SaidaEntradaPovoamento saidaPovoamento = new SaidaEntradaPovoamento();
				if (verificarId(idCapturado)) {
					try {
						// faz a busca e repassa os valores do banco de dados
						// para a lista de biometrias
						
						ListaBiometrias listaBiometrias = new ListaBiometrias();
						listaBiometrias.repassarBiometrias(saida.resgatarBiometrias(idCapturado),
								saidaPovoamento.resgatarPovoamento(idCapturado));
						listaBiometrias.setVisible(true);
						//metodo criado para passar a tela sem usar as variaveis da tela inicial
						Home.repassarTelas(listaBiometrias);
						dispose();
					} catch (SQLException e2) {
						// TODO: handle exception
					}
				} else {
					JOptionPane.showMessageDialog(null, "você precisa escolher um povoamento primeiro");
				}
			}
		});
		btnDetalhes.setBounds(688, 126, 95, 41);
		contentPane.add(btnDetalhes);

		JButton btnNovaBiometria = new JButton("Nova biometria");
		btnNovaBiometria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (verificarId(idCapturado)) {
					CadastroBiometrico cadastroBiometrico = new CadastroBiometrico();
					cadastroBiometrico.atualizarCampos(idCapturado);
					cadastroBiometrico.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "você precisa escolher o povoamento primeiro");
				}
			}
		});
		btnNovaBiometria.setBounds(688, 178, 95, 41);
		contentPane.add(btnNovaBiometria);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(688, 230, 95, 41);
		contentPane.add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int confirmacao = JOptionPane.showConfirmDialog(null,"Você tem certeza?");
				switch (confirmacao) {
				case 0:
					if (verificarId(idCapturado)) {
						SaidaEntradaPovoamento saida = new SaidaEntradaPovoamento();
						saida.excluirPovoamento(idCapturado);

						dispose(); 
						ListaPovoamentos povoamentos = new ListaPovoamentos();
						povoamentos.setVisible(true);
						Home.repassarTelas(povoamentos);

					} else {
						JOptionPane.showMessageDialog(null, "você precisa clicar em um povoamento da lista");
					}	
					break;

				default:
					System.out.println("você decidiu não excluir");
					break;
				}
				
			}
		});

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(688, 324, 95, 41);
		contentPane.add(btnFechar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					CadastroPovoamento cadastroPovoamento = new CadastroPovoamento();
					cadastroPovoamento.setVisible(true);
					Home.repassarTelas(cadastroPovoamento);
					dispose();
			} 
		});
		btnNovo.setBounds(688, 30, 95, 41);
		contentPane.add(btnNovo);
	} 

	public boolean verificarId(String idCaturado) {
		if (idCaturado.equals("")) {
			return false;
		} else {
			return true;
		}

	}
}
