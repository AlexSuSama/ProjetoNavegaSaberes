package br.alexsusama.interfacescadastro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.alexsusama.modelo.Biometria;
import br.alexsusama.modelo.Comercializacao;
import br.alexsusama.persisntencia.SaidaEntradaComercializacao;
import javax.swing.JButton;

/**
 * @author AlexSama
 *
 */
public class ListaComercializacao extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;
	List<Comercializacao> comercializacoes;
	private String idCapturado = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaComercializacao frame = new ListaComercializacao();
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
	public ListaComercializacao() {
		setTitle("Comercializa\u00E7\u00F5es");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 471);
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
		table.setBackground(new Color(50, 250, 139));
		table.setForeground(Color.BLACK);
		table.getTableHeader().setBackground(new Color(80, 139, 139));
		table.setRowHeight(30);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			// Importe a classe java.awt.event.MouseEvent
			public void mouseClicked(MouseEvent e) {
				// Se o botão direito do mouse foi pressionado
				if (e.getButton() == MouseEvent.BUTTON1) {
					// Exibe o popup menu na posição do mouse.
					String id = table.getValueAt(table.getSelectedRow(), 0).toString();
					try {
						idCapturado = id;
						System.out.println(idCapturado);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Data", "Nome ", "Tipo comprador",
				"Valor", "Tipo comercializado", "Duzias vendidas", "Munic\u00EDpio", "Local" }));
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();

		try {
			SaidaEntradaComercializacao saida = new SaidaEntradaComercializacao();
			comercializacoes = saida.resgatarComercializacoes();
			if (comercializacoes != null) {
				for (Comercializacao a : comercializacoes) {
					modelo.addRow(new Object[] { a.getIdComercializacao(), a.getNomeComprador(), a.getTipoDeComprador(),
							a.getValorVenda(), a.getTipoComercializado(), a.getTipoComercializado(), a.getMunicipio(),
							a.getLocalidade(), });

				}
			} else {
				System.out.println("campos nulos");
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scrollPane.setViewportView(table);

		JButton btnNova = new JButton("Nova");
		btnNova.setBounds(688, 56, 89, 41);
		btnNova.addActionListener(btnNovo());
		btnNova.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CadastroComercializacao tela = new CadastroComercializacao();
				Home.repassarTelas(tela);
				dispose();
			}
		});
		contentPane.add(btnNova);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(688, 108, 89, 41);
		btnEditar.addActionListener(btnEditar()); 
		contentPane.add(btnEditar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(688, 160, 89, 41);
		btnExcluir.addActionListener(btnExcluir());
		contentPane.add(btnExcluir);
	}

	public ActionListener btnNovo() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CadastroComercializacao comercializacao = new CadastroComercializacao();
				comercializacao.setVisible(true);
			}
		};
	}

	public ActionListener btnExcluir() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!idCapturado.equals("")) {
					int confirmacao = JOptionPane.showConfirmDialog(null, "Confirmar exclusão");
					switch (confirmacao) {
					case 0:
						System.out.println("vou excluir");
						SaidaEntradaComercializacao entrada = new SaidaEntradaComercializacao();
						entrada.excluirComercializacao(idCapturado);
						break;
					case 1:
						System.out.println("não vou excluir");
						break;

					default:
						System.out.println("Cancelei");
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Você precisa ecolher uma comercialização antes de excluir");
				}
			}
		};
	}

	public ActionListener btnEditar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!idCapturado.equals("")) {
					SaidaEntradaComercializacao entrada = new SaidaEntradaComercializacao();
					CadastroComercializacao editarCadastro = new CadastroComercializacao();
					editarCadastro.atualizarCampos(entrada.resgatarComercializacao(idCapturado), false);
					Home.repassarTelas(editarCadastro);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Você precisa ecolher uma comercialização antes de editar");
				}
			}
		};
	}
	
	
}
