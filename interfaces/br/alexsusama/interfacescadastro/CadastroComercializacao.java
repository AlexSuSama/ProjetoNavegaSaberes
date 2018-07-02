package br.alexsusama.interfacescadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.alexsusama.modelo.Comercializacao;
import br.alexsusama.validacoes.RestricoesDeValores;
import br.alexsusama.validacoes.ValidacaoDeDatas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.beans.MethodDescriptor;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class CadastroComercializacao extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textFieldDataComercializacao;
	private JTextField textFieldMunicipio;
	private JTextField textFieldLocal;
	private JTextField textFieldQTVendida;
	private JTextField textFieldValor;
	private JTextField textFieldNomeComprador;
	private String tipoComprador = "";
	private String tipoVendido = "";
	private boolean atualizar = true;
	private int idComercializacao;
	private JTextField textFieldIDPovoamento;

	private String idDoPovoamento = "";
	private JTextField textFieldValorFrete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroComercializacao frame = new CadastroComercializacao();
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
	public CadastroComercializacao() {
		setTitle("Nova comercializa\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		RestricoesDeValores restricao = new RestricoesDeValores();

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(41, 73, 46, 14);
		contentPane.add(lblData);

		JLabel lblMunicpio = new JLabel("Munic\u00EDpio");
		lblMunicpio.setBounds(41, 101, 57, 14);
		contentPane.add(lblMunicpio);

		JLabel lblLocal = new JLabel("Local");
		lblLocal.setBounds(453, 98, 57, 14);
		contentPane.add(lblLocal);

		JLabel lblTamanhoComercializado = new JLabel("Tamanho comercializado");
		lblTamanhoComercializado.setBounds(41, 129, 144, 14);
		contentPane.add(lblTamanhoComercializado);

		ButtonGroup groupOstras = new ButtonGroup();
		ButtonGroup comprador = new ButtonGroup();
		
		JRadioButton rdbtnBaby = new JRadioButton("Baby");
		rdbtnBaby.setBounds(51, 150, 109, 23);
		contentPane.add(rdbtnBaby);
		groupOstras.add(rdbtnBaby);
		rdbtnBaby.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tipoVendido = "Baby";

			}
		});

		JRadioButton rdbtnMdia = new JRadioButton("M\u00E9dia");
		rdbtnMdia.setBounds(162, 150, 109, 23);
		contentPane.add(rdbtnMdia);
		groupOstras.add(rdbtnMdia);
		rdbtnMdia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tipoVendido = "Média";
			}
		});

		JRadioButton rdbtnMaster = new JRadioButton("Master");
		rdbtnMaster.setBounds(273, 150, 109, 23);
		contentPane.add(rdbtnMaster);
		groupOstras.add(rdbtnMaster);
		rdbtnMaster.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tipoVendido = "Master";

			}
		});

		JLabel lblQuantidadeVendidadz = new JLabel("Quantidade vendida (DZ)");
		lblQuantidadeVendidadz.setBounds(41, 193, 144, 14);
		contentPane.add(lblQuantidadeVendidadz);

		JLabel lblInformaesSobreO = new JLabel("Informa\u00E7\u00F5es sobre o comprador");
		lblInformaesSobreO.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInformaesSobreO.setBounds(22, 283, 220, 14);
		contentPane.add(lblInformaesSobreO);

		JRadioButton rdbtnP = new JRadioButton("Pessoa F\u00EDsica");
		rdbtnP.setBounds(51, 304, 124, 23);
		contentPane.add(rdbtnP);
		comprador.add(rdbtnP);
		rdbtnP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tipoComprador = "Pessoa física";
			}
		});
		JRadioButton rdbtnPessoaJu = new JRadioButton("Pessoa Jur\u00EDdica");
		rdbtnPessoaJu.setBounds(185, 304, 130, 23);
		contentPane.add(rdbtnPessoaJu);
		comprador.add(rdbtnPessoaJu);
		rdbtnPessoaJu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tipoComprador = "Pessoa Jurídica";
			}
		});

		JLabel lblValorDaVenda = new JLabel("Valor da venda");
		lblValorDaVenda.setBounds(41, 240, 109, 14);
		contentPane.add(lblValorDaVenda);

		JLabel lblNomeComprador = new JLabel("Nome comprador");
		lblNomeComprador.setBounds(41, 334, 119, 14);
		contentPane.add(lblNomeComprador);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(332, 390, 96, 38);
		contentPane.add(btnSalvar);
		btnSalvar.addActionListener(btnSalvar());

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(566, 390, 96, 38);
		contentPane.add(btnCancelar);
		try {
			MaskFormatter mascara = new MaskFormatter("##/##/####");
			textFieldDataComercializacao = new JFormattedTextField(mascara);
			textFieldDataComercializacao.setBounds(108, 70, 69, 20);
			contentPane.add(textFieldDataComercializacao);
			textFieldDataComercializacao.setColumns(10);
		} catch (Exception e) {
			// TODO: handle exception
		}
		textFieldMunicipio = new JTextField();
		textFieldMunicipio.setToolTipText("Insira o nome do munic\u00EDpio vendido");
		textFieldMunicipio.setColumns(10);
		textFieldMunicipio.setBounds(108, 98, 237, 20);
		textFieldMunicipio.addKeyListener(restricao.negarNumeros(textFieldMunicipio));
		contentPane.add(textFieldMunicipio);

		textFieldLocal = new JTextField();
		textFieldLocal.setToolTipText("Insira o nome do local vendido");
		textFieldLocal.setColumns(10);
		textFieldLocal.setBounds(492, 95, 237, 20);
		textFieldLocal.addKeyListener(restricao.negarNumeros(textFieldLocal));
		contentPane.add(textFieldLocal);

		textFieldQTVendida = new JTextField();
		textFieldQTVendida.setToolTipText("Insira a quantidade em duzias vendidas");
		textFieldQTVendida.setColumns(10);
		textFieldQTVendida.setBounds(194, 190, 151, 20);
		textFieldQTVendida.addKeyListener(restricao.negarLetras(textFieldQTVendida));
		contentPane.add(textFieldQTVendida);

		textFieldValor = new JTextField();
		textFieldValor.setToolTipText("insira o valor da venda em R$");
		textFieldValor.setColumns(10);
		textFieldValor.setBounds(194, 237, 151, 20);
		textFieldValor.addKeyListener(restricao.negarLetras(textFieldValor));
		contentPane.add(textFieldValor);

		textFieldNomeComprador = new JTextField();
		textFieldNomeComprador.setToolTipText("Insira o nome do comprador");
		textFieldNomeComprador.setColumns(10);
		textFieldNomeComprador.setBounds(196, 334, 237, 20);
		textFieldNomeComprador.addKeyListener(restricao.negarNumeros(textFieldNomeComprador));
		contentPane.add(textFieldNomeComprador);

		JLabel label = new JLabel("*");
		label.setBounds(22, 73, 22, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel("*");
		label_1.setBounds(22, 101, 22, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("*");
		label_2.setBounds(422, 98, 22, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("*");
		label_3.setBounds(22, 129, 22, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("*");
		label_4.setBounds(22, 193, 22, 14);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("*");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(22, 240, 22, 14);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("*");
		label_6.setBounds(22, 337, 22, 14);
		contentPane.add(label_6);

		JLabel lblId = new JLabel("ID Povoamento");
		lblId.setBounds(22, 11, 96, 14);
		contentPane.add(lblId); 

		textFieldIDPovoamento = new JTextField();
		textFieldIDPovoamento.setEditable(false);
		textFieldIDPovoamento.setBounds(108, 8, 86, 20);
		contentPane.add(textFieldIDPovoamento);
		textFieldIDPovoamento.setColumns(10);
		
		JLabel lblValorDoFrete = new JLabel("Valor do frete");
		lblValorDoFrete.setBounds(453, 240, 75, 14);
		contentPane.add(lblValorDoFrete);
		
		textFieldValorFrete = new JTextField();
		textFieldValorFrete.setToolTipText("insira o valor da venda em R$");
		textFieldValorFrete.setColumns(10);
		textFieldValorFrete.setBounds(578, 237, 151, 20);
		contentPane.add(textFieldValorFrete);
		
		JLabel label_7 = new JLabel("*");
		label_7.setBounds(422, 240, 22, 14);
		contentPane.add(label_7);
		
		
		
	}

	public ActionListener btnSalvar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (atualizar) {
					System.out.println("você vai salvar");
					if (!(textFieldDataComercializacao.getText().trim().equals("//")
							|| textFieldLocal.getText().equals("") || textFieldMunicipio.getText().equals("")
							|| textFieldNomeComprador.getText().equals("") || textFieldQTVendida.getText().equals("")
							|| textFieldValor.getText().equals("") || tipoComprador.equals("")
							|| tipoVendido.equals("")||textFieldValorFrete.getText().equals(""))) {

						String nomeComprador = textFieldNomeComprador.getText().toString();
						String dataVenda = textFieldDataComercializacao.getText().toString();
						String municipio = textFieldMunicipio.getText().toString();
						String local = textFieldLocal.getText().toString();
						int qtVendida = Integer.parseInt(textFieldQTVendida.getText().toString());
						int valor = Integer.parseInt(textFieldValor.getText().toString());
						int valorFrete = Integer.parseInt(textFieldValorFrete.getText().toString());
						
						Comercializacao comercializacao = new Comercializacao(nomeComprador, tipoComprador, municipio,
								local, tipoVendido, qtVendida, ValidacaoDeDatas.ordenarData(dataVenda), valor,valorFrete);
						comercializacao.criarComercializacao(idDoPovoamento);

					} else {
						JOptionPane.showMessageDialog(null, "Algum campo obrigatório esta vázio");
					}
				} else {
					System.out.println("você vai atualizar");
					if (!(textFieldDataComercializacao.getText().trim().equals("//")
							|| textFieldLocal.getText().equals("") || textFieldMunicipio.getText().equals("")
							|| textFieldNomeComprador.getText().equals("") || textFieldQTVendida.getText().equals("")
							|| textFieldValor.getText().equals("") || tipoComprador.equals("")
							|| tipoVendido.equals("")||textFieldValorFrete.getText().equals(""))) {

						String nomeComprador = textFieldNomeComprador.getText().toString();
						String dataVenda = textFieldDataComercializacao.getText().toString();
						String municipio = textFieldMunicipio.getText().toString();
						String local = textFieldLocal.getText().toString();
						int qtVendida = Integer.parseInt(textFieldQTVendida.getText().toString());
						int valor = Integer.parseInt(textFieldValor.getText().toString());
						int valorFrete = Integer.parseInt(textFieldValorFrete.getText().toString());
						
						Comercializacao comercializacao = new Comercializacao(nomeComprador, tipoComprador, municipio,
								local, tipoVendido, qtVendida, ValidacaoDeDatas.ordenarData(dataVenda), valor,valorFrete);
						comercializacao.editarComercializacao(String.valueOf(idComercializacao));

					} else {
						JOptionPane.showMessageDialog(null, "Algum campo não foi preenchido corretamente");
					}
				} 
			}
		};

	}

	public void repassarIdPovoamento(String id) {
		if (!id.equals("")) {
			textFieldIDPovoamento.setText(id);
			idDoPovoamento = id;
		} else {
			System.out.println("id inválido");
		}
	}

	public void atualizarCampos(Comercializacao comercializacao, boolean atualizar) {
		if (comercializacao != null) {
			textFieldDataComercializacao.setText(comercializacao.getDataComercializacao());
			textFieldLocal.setText(comercializacao.getLocalidade());
			textFieldMunicipio.setText(comercializacao.getMunicipio());
			textFieldNomeComprador.setText(comercializacao.getNomeComprador());
			textFieldQTVendida.setText(String.valueOf(comercializacao.getQtVendidas()));
			textFieldValor.setText(String.valueOf(comercializacao.getValorVenda()));
			this.atualizar = atualizar;
			this.idComercializacao = comercializacao.getIdComercializacao();
		} else {
			System.out.println("comercialização nula");
		}
	}
}
