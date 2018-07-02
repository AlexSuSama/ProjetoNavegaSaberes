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
import br.alexsusama.modelo.Comercializacao;
import br.alexsusama.modelo.Povoamento;
import br.alexsusama.persisntencia.SaidaEntradaBiometria;
import br.alexsusama.persisntencia.SaidaEntradaComercializacao;
import br.alexsusama.persisntencia.SaidaEntradaPovoamento;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaPovoamentosEstoque extends JFrame {
 
	private JPanel contentPane;

	private JTable table;
	// private String idCapturado = "";

	static boolean nEhGrafico = true;

	int controladorDeSelecao = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaPovoamentosEstoque frame = new ListaPovoamentosEstoque();
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
	public ListaPovoamentosEstoque() {
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
				// Se o botão direito do mouse foi pressionado
				if (e.getButton() == MouseEvent.BUTTON1) {
					// Exibe o popup menu na posição do mouse.
					String id = table.getValueAt(table.getSelectedRow(), 0).toString();
					if(nEhGrafico){
					switch (controladorDeSelecao) {
					case 1:
						try {
							TelaDeEstoque telaDeEstoque = new TelaDeEstoque();
							telaDeEstoque.preencherIDPovoamento(id);
							telaDeEstoque.preencherCampos(id);
							Home.repassarTelas(telaDeEstoque);
							dispose();
							System.out.println("id do povoamento: " + id);

						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						break;
					case 2: 
						try {
							// faz a busca e repassa os valores do banco de dados
							// para a lista de biometrias
							SaidaEntradaComercializacao saida = new SaidaEntradaComercializacao();
							SaidaEntradaPovoamento saidaPovoamento = new SaidaEntradaPovoamento();
							
							ListaComercializacao listaComercializacao = new ListaComercializacao();
							// tenho que modificar aqui para retornar apenas as
							// comercializações referentes aquele povoamento
							
							listaComercializacao.repassarComercializacao(saida.resgatarComercializacoes(id),saidaPovoamento.resgatarPovoamento(id));
						
							listaComercializacao.setVisible(true);
							// metodo criado para passar a tela sem usar as
							// variaveis da tela inicial
							Home.repassarTelas(listaComercializacao);
							dispose();

						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						case 3:
							try {
								SaidaEntradaPovoamento saidaEntradaPovoamento = new SaidaEntradaPovoamento();
								Povoamento povoamento = saidaEntradaPovoamento.resgatarPovoamento(id);
								TelaRelatorio telaRelatorio = new TelaRelatorio();
								telaRelatorio.atualizarCampos(povoamento);
								telaRelatorio.setVisible(true);
							} catch (Exception e2) {
								// TODO: handle exception
							}

					default:
						break;
					}
					
					
					}else{
						GraficosEstoque graficosEstoque = new GraficosEstoque();
						graficosEstoque.preencherIDPovoamento(id);
						Home.repassarTelas(graficosEstoque);
						dispose();
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

	public void opcaoDeTela(int tela) {
		this.controladorDeSelecao = tela;
	}

}
