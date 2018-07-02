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
import br.alexsusama.modelo.Povoamento;
import br.alexsusama.persisntencia.SaidaEntradaComercializacao;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author AlexSama
 *
 */
public class ListaComercializacao extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;
	private String idCapturado = "";
	private JTextField textFieldIDPovoamento;
	private JTextField textFieldProdutor;
	private JTextField textFieldMunicipio;
	private JTextField textFieldLocalidade;

	List<Comercializacao> listComercializacao;

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

		JButton btnNova = new JButton("Nova");
		btnNova.setBounds(688, 115, 89, 41);
		btnNova.addActionListener(btnNovo());
		btnNova.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CadastroComercializacao tela = new CadastroComercializacao();
				tela.repassarIdPovoamento(textFieldIDPovoamento.getText().toString());
				Home.repassarTelas(tela);
				dispose();
			}
		});
		contentPane.add(btnNova);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(688, 167, 89, 41);
		btnEditar.addActionListener(btnEditar());
		contentPane.add(btnEditar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(688, 231, 89, 41);
		btnExcluir.addActionListener(btnExcluir());
		contentPane.add(btnExcluir);

		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 825, 102);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblIdPovoamento = new JLabel("ID Povoamento");
		lblIdPovoamento.setBounds(10, 11, 92, 14);
		panel.add(lblIdPovoamento);

		JLabel lblProdutor = new JLabel("Produtor");
		lblProdutor.setBounds(10, 61, 47, 14);
		panel.add(lblProdutor);

		textFieldIDPovoamento = new JTextField();
		textFieldIDPovoamento.setBounds(97, 8, 147, 20);
		panel.add(textFieldIDPovoamento);
		textFieldIDPovoamento.setColumns(10);

		textFieldProdutor = new JTextField();
		textFieldProdutor.setColumns(10);
		textFieldProdutor.setBounds(97, 58, 147, 20);
		panel.add(textFieldProdutor);

		JLabel lblMunicpio = new JLabel("Munic\u00EDpio");
		lblMunicpio.setBounds(265, 11, 71, 14);
		panel.add(lblMunicpio);

		JLabel lblLocalidade = new JLabel("Localidade");
		lblLocalidade.setBounds(527, 11, 71, 14);
		panel.add(lblLocalidade);

		textFieldMunicipio = new JTextField();
		textFieldMunicipio.setColumns(10);
		textFieldMunicipio.setBounds(317, 8, 147, 20);
		panel.add(textFieldMunicipio);

		textFieldLocalidade = new JTextField();
		textFieldLocalidade.setColumns(10);
		textFieldLocalidade.setBounds(608, 8, 147, 20);
		panel.add(textFieldLocalidade);
		
		JButton btnSelecioneOPovoamento = new JButton("Selecione o povoamento");
		btnSelecioneOPovoamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaPovoamentosEstoque listaPovoamentosEstoque = new ListaPovoamentosEstoque();
				listaPovoamentosEstoque.opcaoDeTela(2);
				listaPovoamentosEstoque.setVisible(true);
			}
		});
		btnSelecioneOPovoamento.setBounds(608, 57, 166, 41);
		panel.add(btnSelecioneOPovoamento);
	}
	
	//metodo do btn de nova biometria
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

	public void inializarTela() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 113, 678, 317);
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
			
			if (listComercializacao != null) {
				for (Comercializacao a : listComercializacao) {
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
					editarCadastro.repassarIdPovoamento(textFieldIDPovoamento.getText().toString());
					Home.repassarTelas(editarCadastro);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Você precisa ecolher uma comercialização antes de editar");
				}
			}
		};
	}

	public void repassarComercializacao(List<Comercializacao> comercializacao, Povoamento povoamento) {
		
		textFieldIDPovoamento.setText(String.valueOf(povoamento.getIDPovoamentos()));
		textFieldLocalidade.setText(povoamento.getLocalidade());
		textFieldMunicipio.setText(povoamento.getMunicipio());
		textFieldProdutor.setText(povoamento.getNomeOstricultor());
		
		this.listComercializacao = comercializacao;
		inializarTela();
	}
}
