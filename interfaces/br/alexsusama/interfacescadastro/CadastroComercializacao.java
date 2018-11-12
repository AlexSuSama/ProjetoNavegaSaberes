package br.alexsusama.interfacescadastro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.alexsusama.modelo.Comercializacao;
import br.alexsusama.persisntencia.SaidaEntradaComercializacao;
import br.alexsusama.persisntencia.SaidaEntradaPovoamento;
import br.alexsusama.validacoes.RestricoesDeValores;
import br.alexsusama.validacoes.ValidacaoDeDatas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;

public class CadastroComercializacao extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDataComercializacao;
	private JTextField textFieldMunicipio;
	private JTextField textFieldLocal;
	private JTextField textFieldQTVendidaBaby;
	private JTextField textFieldValor;
	private JTextField textFieldNomeComprador;
	private String tipoComprador = "";
	private String tipoVendido = "";
	private boolean atualizar = true;
	private int idComercializacao;
	private JTextField textFieldIDPovoamento;

	private String idDoPovoamento = "";
	private JTextField textFieldValorFrete;
	private JTextField textFieldQTVendidaMedia;
	private JTextField textFieldQTVendidaMaster;

	JLabel lblQuantidadeVendidaBaby;
	JLabel label_4;

	JLabel label_9;
	JLabel lblQuantidadeVendidaMedia;

	JLabel label_10;
	JLabel lblQuantidadeVendidaMaster;

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
		setBounds(100, 100, 820, 478);
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

		JLabel lblLocal = new JLabel("Estabelecimento");
		lblLocal.setBounds(402, 98, 108, 14);
		contentPane.add(lblLocal);

		JLabel lblTamanhoComercializado = new JLabel("Tamanho de ostras comercializadas");
		lblTamanhoComercializado.setBounds(41, 129, 214, 14);
		contentPane.add(lblTamanhoComercializado);

		// ButtonGroup groupOstras = new ButtonGroup();
		ButtonGroup comprador = new ButtonGroup();

		JRadioButton rdbtnBaby = new JRadioButton("Baby");
		rdbtnBaby.setBounds(51, 150, 109, 23);
		contentPane.add(rdbtnBaby);
		// groupOstras.add(rdbtnBaby);
		rdbtnBaby.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tipoVendido = "Baby";
				if (rdbtnBaby.isSelected()) {
					label_4.setVisible(true);
					lblQuantidadeVendidaBaby.setVisible(true);
					textFieldQTVendidaBaby.setVisible(true);
				} else {
					label_4.setVisible(false);
					lblQuantidadeVendidaBaby.setVisible(false);
					textFieldQTVendidaBaby.setVisible(false);

				}
			}
		});

		JRadioButton rdbtnMdia = new JRadioButton("M\u00E9dia");
		rdbtnMdia.setBounds(162, 150, 109, 23);
		contentPane.add(rdbtnMdia);
		// groupOstras.add(rdbtnMdia);
		rdbtnMdia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tipoVendido = "Média";
				if (rdbtnMdia.isSelected()) {
					label_9.setVisible(true);
					lblQuantidadeVendidaMedia.setVisible(true);
					textFieldQTVendidaMedia.setVisible(true);

				} else {
					label_9.setVisible(false);
					lblQuantidadeVendidaMedia.setVisible(false);
					textFieldQTVendidaMedia.setVisible(false);
				}
			}
		});

		JRadioButton rdbtnMaster = new JRadioButton("Master");
		rdbtnMaster.setBounds(273, 150, 109, 23);
		contentPane.add(rdbtnMaster);
		// groupOstras.add(rdbtnMaster);
		rdbtnMaster.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tipoVendido = "Master";
				if (rdbtnMaster.isSelected()) {
					label_10.setVisible(true);
					lblQuantidadeVendidaMaster.setVisible(true);
					textFieldQTVendidaMaster.setVisible(true);
				} else {
					label_10.setVisible(false);
					lblQuantidadeVendidaMaster.setVisible(false);
					textFieldQTVendidaMaster.setVisible(false);
				}
			}
		});

		lblQuantidadeVendidaBaby = new JLabel("Duzias baby");
		lblQuantidadeVendidaBaby.setBounds(41, 193, 109, 14);
		lblQuantidadeVendidaBaby.setVisible(false);
		contentPane.add(lblQuantidadeVendidaBaby);

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
				// faz a busca e repassa os valores do banco de dados
				// para a lista de biometrias
				String idPovoamento = textFieldIDPovoamento.getText().toString();
				SaidaEntradaComercializacao saida = new SaidaEntradaComercializacao();
				SaidaEntradaPovoamento saidaPovoamento = new SaidaEntradaPovoamento();

				ListaComercializacao listaComercializacao = new ListaComercializacao();
				// tenho que modificar aqui para retornar apenas as
				// comercializações referentes aquele povoamento

				try {
					listaComercializacao.repassarComercializacao(saida.resgatarComercializacoes(idPovoamento),
							saidaPovoamento.resgatarPovoamento(idPovoamento));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				listaComercializacao.setVisible(true);
				// metodo criado para passar a tela sem usar as
				// variaveis da tela inicial
				Home.repassarTelas(listaComercializacao);
				dispose();

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
		textFieldLocal.setBounds(520, 98, 228, 20);
		textFieldLocal.addKeyListener(restricao.negarNumeros(textFieldLocal));
		contentPane.add(textFieldLocal);

		textFieldQTVendidaBaby = new JTextField();
		textFieldQTVendidaBaby.setText("0");
		textFieldQTVendidaBaby.setToolTipText("Insira a quantidade em duzias vendidas");
		textFieldQTVendidaBaby.setColumns(10);
		textFieldQTVendidaBaby.setBounds(121, 190, 96, 20);
		textFieldQTVendidaBaby.addKeyListener(restricao.negarLetras(textFieldQTVendidaBaby));
		textFieldQTVendidaBaby.setVisible(false);
		contentPane.add(textFieldQTVendidaBaby);

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
		label_2.setBounds(371, 98, 139, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("*");
		label_3.setBounds(22, 129, 22, 14);
		contentPane.add(label_3);

		label_4 = new JLabel("*");
		label_4.setBounds(22, 193, 22, 14);
		label_4.setVisible(false);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("*");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(22, 240, 22, 14);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("*");
		label_6.setBounds(22, 337, 22, 14);
		contentPane.add(label_6);

		JLabel lblId = new JLabel("ID Povoamento");
		lblId.setBounds(566, 70, 96, 14);
		contentPane.add(lblId);

		textFieldIDPovoamento = new JTextField();
		textFieldIDPovoamento.setEditable(false);
		textFieldIDPovoamento.setBounds(652, 67, 86, 20);
		contentPane.add(textFieldIDPovoamento);
		textFieldIDPovoamento.setColumns(10);

		JLabel lblValorDoFrete = new JLabel("Valor do frete");
		lblValorDoFrete.setBounds(402, 240, 108, 14);
		contentPane.add(lblValorDoFrete);

		textFieldValorFrete = new JTextField();
		textFieldValorFrete.setToolTipText("insira o valor da venda em R$");
		textFieldValorFrete.setColumns(10);
		textFieldValorFrete.setBounds(520, 237, 151, 20);
		textFieldValorFrete.addKeyListener(restricao.negarLetras(textFieldValorFrete));
		contentPane.add(textFieldValorFrete);

		JLabel label_7 = new JLabel("*");
		label_7.setBounds(371, 240, 139, 14);
		contentPane.add(label_7);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(10, 11, 784, 51);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblPreenchaOsCampos = new JLabel(
				"Preencha os campos abaixo com as informa\u00E7\u00F5es referentes a comercializa\u00E7\u00E3o");
		lblPreenchaOsCampos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPreenchaOsCampos.setBounds(10, 11, 532, 14);
		panel.add(lblPreenchaOsCampos);

		JLabel lblNewLabel = new JLabel("campos com (*) s\u00E3o obrigat\u00F3rios");
		lblNewLabel.setBounds(10, 37, 247, 14);
		panel.add(lblNewLabel);

		lblQuantidadeVendidaMedia = new JLabel("Duzias m\u00E9dia");
		lblQuantidadeVendidaMedia.setBounds(271, 190, 109, 14);
		lblQuantidadeVendidaMedia.setVisible(false);
		contentPane.add(lblQuantidadeVendidaMedia);

		label_9 = new JLabel("*");
		label_9.setBounds(252, 190, 22, 14);
		label_9.setVisible(false);
		contentPane.add(label_9);

		textFieldQTVendidaMedia = new JTextField();
		textFieldQTVendidaMedia.setText("0");
		textFieldQTVendidaMedia.setToolTipText("Insira a quantidade em duzias vendidas");
		textFieldQTVendidaMedia.setColumns(10);
		textFieldQTVendidaMedia.setBounds(351, 187, 96, 20);
		textFieldQTVendidaMedia.addKeyListener(restricao.negarLetras(textFieldQTVendidaMedia));
		textFieldQTVendidaMedia.setVisible(false);
		contentPane.add(textFieldQTVendidaMedia);

		textFieldQTVendidaMaster = new JTextField();
		textFieldQTVendidaMaster.setText("0");
		textFieldQTVendidaMaster.setToolTipText("Insira a quantidade em duzias vendidas");
		textFieldQTVendidaMaster.setColumns(10);
		textFieldQTVendidaMaster.setBounds(575, 187, 96, 20);
		textFieldQTVendidaMaster.addKeyListener(restricao.negarLetras(textFieldQTVendidaMaster));
		textFieldQTVendidaMaster.setVisible(false);
		contentPane.add(textFieldQTVendidaMaster);

		lblQuantidadeVendidaMaster = new JLabel("Duzias master");
		lblQuantidadeVendidaMaster.setBounds(495, 190, 109, 14);
		lblQuantidadeVendidaMaster.setVisible(false);
		contentPane.add(lblQuantidadeVendidaMaster);

		label_10 = new JLabel("*");
		label_10.setBounds(476, 190, 22, 14);
		label_10.setVisible(false);
		contentPane.add(label_10);

	}

	public ActionListener btnSalvar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int duziasBaby = Integer.parseInt(textFieldQTVendidaBaby.getText().toString());
				int duziasMedia = Integer.parseInt(textFieldQTVendidaMedia.getText().toString());
				int duziasMaster = Integer.parseInt(textFieldQTVendidaMaster.getText().toString());

				int somaDuzia = duziasBaby + duziasMedia + duziasMaster;

				if (atualizar) {
					System.out.println("você vai salvar");
					if (!(textFieldDataComercializacao.getText().trim().equals("//")
							|| textFieldLocal.getText().equals("") || textFieldMunicipio.getText().equals("")
							|| textFieldNomeComprador.getText().equals("")
							|| textFieldQTVendidaBaby.getText().equals("") || textFieldValor.getText().equals("")
							|| tipoComprador.equals("") || tipoVendido.equals("")
							|| textFieldValorFrete.getText().equals("")) && (somaDuzia > 0)) {

						String nomeComprador = textFieldNomeComprador.getText().toString();
						String dataVenda = textFieldDataComercializacao.getText().toString();
						String municipio = textFieldMunicipio.getText().toString();
						String local = textFieldLocal.getText().toString();
						int valor = Integer.parseInt(textFieldValor.getText().toString());
						int valorFrete = Integer.parseInt(textFieldValorFrete.getText().toString());

						Comercializacao comercializacao = new Comercializacao(nomeComprador, tipoComprador, municipio,
								local, tipoVendido, ValidacaoDeDatas.ordenarData(dataVenda), valor, valorFrete,
								duziasBaby, duziasMedia, duziasMaster);
						comercializacao.criarComercializacao(idDoPovoamento);

					} else {
						JOptionPane.showMessageDialog(null, "Algum campo obrigatório esta vázio");
					}
				} else {
					System.out.println("você vai atualizar");
					if (!(textFieldDataComercializacao.getText().trim().equals("//")
							|| textFieldLocal.getText().equals("") || textFieldMunicipio.getText().equals("")
							|| textFieldNomeComprador.getText().equals("")
							|| textFieldQTVendidaBaby.getText().equals("") || textFieldValor.getText().equals("")
							|| tipoComprador.equals("") || tipoVendido.equals("")
							|| textFieldValorFrete.getText().equals("")) && (somaDuzia > 0)) {

						String nomeComprador = textFieldNomeComprador.getText().toString();
						String dataVenda = textFieldDataComercializacao.getText().toString();
						String municipio = textFieldMunicipio.getText().toString();
						String local = textFieldLocal.getText().toString();
						int valor = Integer.parseInt(textFieldValor.getText().toString());
						int valorFrete = Integer.parseInt(textFieldValorFrete.getText().toString());

						Comercializacao comercializacao = new Comercializacao(nomeComprador, tipoComprador, municipio,
								local, tipoVendido, ValidacaoDeDatas.ordenarData(dataVenda), valor, valorFrete,
								duziasBaby, duziasMedia, duziasMaster);

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
			//textFieldQTVendidaBaby.setText(String.valueOf(comercializacao.getQtVendidas()));
			
			textFieldQTVendidaBaby.setText(String.valueOf(comercializacao.getDuziasBaby()));
			textFieldQTVendidaMedia.setText(String.valueOf(comercializacao.getDuziasMedias()));
			textFieldQTVendidaMaster.setText(String.valueOf(comercializacao.getDuziasMaster()));
			
			
			
			textFieldValor.setText(String.valueOf(comercializacao.getValorVenda()));
			this.atualizar = atualizar;
			this.idComercializacao = comercializacao.getIdComercializacao();
		} else {
			System.out.println("comercialização nula");
		}
	}

}
