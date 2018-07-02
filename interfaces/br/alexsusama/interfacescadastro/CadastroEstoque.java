package br.alexsusama.interfacescadastro;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.alexsusama.modelo.Estoque;
import br.alexsusama.validacoes.RestricoesDeValores;
import br.alexsusama.validacoes.ValidacaoDeDatas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class CadastroEstoque extends JInternalFrame {

	private JPanel background;
	private JTextField txtFieldSementes;
	private JTextField txtFieldBaby;
	private JTextField txtFieldJuvenil;
	private JTextField txtFieldMedia;
	private JTextField txtFieldMaster;
	private JTextField txtFieldMalha69;
	private JTextField txtFieldMalha12;
	private JTextField txtFieldMalha14;
	private JTextField txtFieldMalha21;
	private JTextField txtFieldColetores;
	private JTextField txtFieldVaral;
	private JTextField txtFieldLongline;
	private JTextField txtFieldLanternas;
	private JTextField txtFieldMesaPVC;
	private JTextField txtFieldMesaTelada;
	private JTextField txtFieldMesaMadeira;
	private JTextField txtFieldData;

	private RestricoesDeValores restricao = new RestricoesDeValores();
	private JTextField textFieldIdPovoamento;

	private String idPovoamento;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroEstoque frame = new CadastroEstoque();
					frame.setVisible(true);
					// frame.inicializarTelas();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroEstoque() {
		setTitle("Novo estoque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 506);
		background = new JPanel();
		background.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(background);
		background.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(305, 186, 10, 10);

		panel.setPreferredSize(new Dimension(600, 700));
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(0, 46, 718, 365);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setViewportBorder(BorderFactory.createLoweredBevelBorder());
		scroll.setAutoscrolls(true);
		scroll.setViewportView(panel);
		panel.setLayout(null);

		JLabel lblSementes = new JLabel("Sementes");
		lblSementes.setToolTipText("Insira a quantidade de sementes em estoque");
		lblSementes.setBounds(87, 113, 61, 14);
		panel.add(lblSementes);

		JLabel lblBaby = new JLabel("Baby");
		lblBaby.setBounds(87, 170, 61, 14);
		panel.add(lblBaby);

		JLabel lblJuvenil = new JLabel("Juvenil");
		lblJuvenil.setBounds(87, 220, 61, 14);
		panel.add(lblJuvenil);

		JLabel lblMdia = new JLabel("M\u00E9dia");
		lblMdia.setBounds(87, 280, 61, 14);
		panel.add(lblMdia);

		JLabel lblMaster = new JLabel("Master");
		lblMaster.setBounds(87, 351, 61, 14);
		panel.add(lblMaster);

		JLabel lblMalha = new JLabel("Malha 69");
		lblMalha.setBounds(376, 113, 61, 14);
		panel.add(lblMalha);

		JLabel lblMalha_1 = new JLabel("Malha 12");
		lblMalha_1.setBounds(376, 189, 61, 14);
		panel.add(lblMalha_1);

		JLabel lblMalha_2 = new JLabel("Malha 14");
		lblMalha_2.setBounds(376, 236, 61, 14);
		panel.add(lblMalha_2);

		JLabel lblMalha_3 = new JLabel("Malha 21");
		lblMalha_3.setBounds(376, 291, 61, 14);
		panel.add(lblMalha_3);

		JLabel lblColetores = new JLabel("Coletores");
		lblColetores.setBounds(87, 443, 61, 14);
		panel.add(lblColetores);

		JLabel lblVaral = new JLabel("Varal");
		lblVaral.setBounds(101, 501, 31, 14);
		panel.add(lblVaral);

		JLabel lblLongline = new JLabel("Longline");
		lblLongline.setBounds(87, 561, 45, 14);
		panel.add(lblLongline);

		JLabel lblMesaTelada = new JLabel("Mesa Telada");
		lblMesaTelada.setBounds(345, 501, 75, 14);
		panel.add(lblMesaTelada);

		JLabel lblMesaDeMadeira = new JLabel("Mesa de Madeira");
		lblMesaDeMadeira.setBounds(345, 561, 93, 14);
		panel.add(lblMesaDeMadeira);

		JLabel lblMesaDePvc = new JLabel("Mesa de PVC");
		lblMesaDePvc.setBounds(344, 443, 93, 14);
		panel.add(lblMesaDePvc);

		JLabel lblLanternas = new JLabel("Lanternas");
		lblLanternas.setBounds(84, 612, 75, 14);
		panel.add(lblLanternas);

		txtFieldSementes = new JTextField();
		txtFieldSementes.setToolTipText("Insira a quantidade de sementes em estoque");
		txtFieldSementes.setBounds(161, 110, 86, 20);
		txtFieldSementes.addKeyListener(restricao.negarLetras(txtFieldSementes));
		panel.add(txtFieldSementes);
		txtFieldSementes.setColumns(10);

		txtFieldBaby = new JTextField();
		txtFieldBaby.setToolTipText("Insira a quantidade de ostras em tamanho baby em estoque");
		txtFieldBaby.setColumns(10);
		txtFieldBaby.setBounds(158, 167, 86, 20);
		txtFieldBaby.addKeyListener(restricao.negarLetras(txtFieldBaby));
		panel.add(txtFieldBaby);

		txtFieldJuvenil = new JTextField();
		txtFieldJuvenil.setToolTipText("Insira a quantidade de ostras em tamanho juvenil em estoque");
		txtFieldJuvenil.setColumns(10);
		txtFieldJuvenil.setBounds(158, 217, 86, 20);
		txtFieldJuvenil.addKeyListener(restricao.negarLetras(txtFieldJuvenil));
		panel.add(txtFieldJuvenil);

		txtFieldMedia = new JTextField();
		txtFieldMedia.setToolTipText("Insira a quantidade de ostras em tamanho m\u00E9dio em estoque");
		txtFieldMedia.setColumns(10);
		txtFieldMedia.setBounds(161, 277, 86, 20);
		txtFieldMedia.addKeyListener(restricao.negarLetras(txtFieldMedia));
		panel.add(txtFieldMedia);

		txtFieldMaster = new JTextField();
		txtFieldMaster.setToolTipText("Insira a quantidade de ostras em tamanho master em estoque");
		txtFieldMaster.setColumns(10);
		txtFieldMaster.setBounds(158, 348, 86, 20);
		txtFieldMaster.addKeyListener(restricao.negarLetras(txtFieldMaster));
		panel.add(txtFieldMaster);

		txtFieldMalha69 = new JTextField();
		txtFieldMalha69.setToolTipText("Insira a quantidade de malhas tamanho 69 em estoque");
		txtFieldMalha69.setColumns(10);
		txtFieldMalha69.setBounds(447, 110, 86, 20);
		txtFieldMalha69.addKeyListener(restricao.negarLetras(txtFieldMalha69));
		panel.add(txtFieldMalha69);

		txtFieldMalha12 = new JTextField();
		txtFieldMalha12.setToolTipText("Insira a quantidade de malhas tamanho 12 em estoque");
		txtFieldMalha12.setColumns(10);
		txtFieldMalha12.setBounds(447, 186, 86, 20);
		txtFieldMalha12.addKeyListener(restricao.negarLetras(txtFieldMalha12));
		panel.add(txtFieldMalha12);

		txtFieldMalha14 = new JTextField();
		txtFieldMalha14.setToolTipText("Insira a quantidade de malhas tamanho 14 em estoque");
		txtFieldMalha14.setColumns(10);
		txtFieldMalha14.setBounds(447, 233, 86, 20);
		txtFieldMalha14.addKeyListener(restricao.negarLetras(txtFieldMalha14));
		panel.add(txtFieldMalha14);

		txtFieldMalha21 = new JTextField();
		txtFieldMalha21.setToolTipText("Insira a quantidade de malhas tamanho 21 em estoque");
		txtFieldMalha21.setColumns(10);
		txtFieldMalha21.setBounds(447, 288, 86, 20);
		txtFieldMalha21.addKeyListener(restricao.negarLetras(txtFieldMalha21));
		panel.add(txtFieldMalha21);

		txtFieldColetores = new JTextField();
		txtFieldColetores.setToolTipText("Insira a quantidade de coletores em estoque");
		txtFieldColetores.setColumns(10);
		txtFieldColetores.setBounds(161, 440, 86, 20);
		txtFieldColetores.addKeyListener(restricao.negarLetras(txtFieldColetores));
		panel.add(txtFieldColetores);

		txtFieldVaral = new JTextField();
		txtFieldVaral.setToolTipText("Insira a quantidade de varal em estoque");
		txtFieldVaral.setColumns(10);
		txtFieldVaral.setBounds(161, 498, 86, 20);
		txtFieldVaral.addKeyListener(restricao.negarLetras(txtFieldVaral));
		panel.add(txtFieldVaral);

		txtFieldLongline = new JTextField();
		txtFieldLongline.setToolTipText("Insira a quantidade de longline em estoque");
		txtFieldLongline.setColumns(10);
		txtFieldLongline.setBounds(161, 558, 86, 20);
		txtFieldLongline.addKeyListener(restricao.negarLetras(txtFieldLongline));
		panel.add(txtFieldLongline);

		txtFieldLanternas = new JTextField();
		txtFieldLanternas.setToolTipText("Insira a quantidade de lanternas em estoque");
		txtFieldLanternas.setColumns(10);
		txtFieldLanternas.setBounds(161, 609, 86, 20);
		txtFieldLanternas.addKeyListener(restricao.negarLetras(txtFieldLanternas));
		panel.add(txtFieldLanternas);

		txtFieldMesaPVC = new JTextField();
		txtFieldMesaPVC.setToolTipText("Insira a quantidade de mesas PVC em estoque");
		txtFieldMesaPVC.setColumns(10);
		txtFieldMesaPVC.setBounds(447, 443, 86, 20);
		txtFieldMesaPVC.addKeyListener(restricao.negarLetras(txtFieldMesaPVC));
		panel.add(txtFieldMesaPVC);

		txtFieldMesaTelada = new JTextField();
		txtFieldMesaTelada.setToolTipText("Insira a quantidade de mesas teladas em estoque");
		txtFieldMesaTelada.setColumns(10);
		txtFieldMesaTelada.setBounds(447, 498, 86, 20);
		txtFieldMesaTelada.addKeyListener(restricao.negarLetras(txtFieldMesaTelada));
		panel.add(txtFieldMesaTelada);

		txtFieldMesaMadeira = new JTextField();
		txtFieldMesaMadeira.setToolTipText("Insira a quantidade de mesa de madeira em estoque");
		txtFieldMesaMadeira.setColumns(10);
		txtFieldMesaMadeira.setBounds(447, 558, 86, 20);
		txtFieldMesaMadeira.addKeyListener(restricao.negarLetras(txtFieldMesaMadeira));
		panel.add(txtFieldMesaMadeira);
		try {
			MaskFormatter mascara = new MaskFormatter("##/##/####");
			txtFieldData = new JFormattedTextField(mascara);
			txtFieldData.setColumns(10);
			txtFieldData.setBounds(161, 54, 86, 20);
			panel.add(txtFieldData);
		} catch (Exception e) {
			// TODO: handle exception
		}
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(98, 57, 61, 14);
		panel.add(lblData);

		JLabel label = new JLabel("*");
		label.setBounds(87, 57, 22, 14);
		panel.add(label);

		background.add(scroll);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(437, 422, 89, 23);
		background.add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(585, 422, 89, 23);
		background.add(btnCancelar);

		JLabel lblTelaDeCadastro = new JLabel("Tela de cadastro do estoque");
		lblTelaDeCadastro.setBounds(22, 21, 229, 14);
		background.add(lblTelaDeCadastro);

		JLabel lblIdPovoamento = new JLabel("id Povoamento");
		lblIdPovoamento.setBounds(318, 21, 94, 14);
		background.add(lblIdPovoamento);

		textFieldIdPovoamento = new JTextField();
		textFieldIdPovoamento.setEditable(false);
		textFieldIdPovoamento.setBounds(440, 18, 86, 20);
		background.add(textFieldIdPovoamento);
		textFieldIdPovoamento.setColumns(10);
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TelaDeEstoque telaDeEstoque = new TelaDeEstoque();
				telaDeEstoque.preencherCampos(idPovoamento);
				telaDeEstoque.preencherIDPovoamento(idPovoamento);
				Home.repassarTelas(telaDeEstoque);
				dispose();
			}
		});
		btnSalvar.addActionListener(btnSalvar());

	}

	public ActionListener btnSalvar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!txtFieldData.getText().equals("")) {
					int semente = Integer.parseInt(txtFieldSementes.getText().toString());
					int juvenil = Integer.parseInt(txtFieldJuvenil.getText().toString());
					int baby = Integer.parseInt(txtFieldBaby.getText().toString());
					int media = Integer.parseInt(txtFieldMedia.getText().toString());
					int master = Integer.parseInt(txtFieldMaster.getText().toString());

					int malha69 = Integer.parseInt(txtFieldMalha69.getText().toString());
					int malha12 = Integer.parseInt(txtFieldMalha12.getText().toString());
					int malha14 = Integer.parseInt(txtFieldMalha14.getText().toString());
					int malha21 = Integer.parseInt(txtFieldMalha21.getText().toString());

					int coletores = Integer.parseInt(txtFieldColetores.getText().toString());
					int varal = Integer.parseInt(txtFieldVaral.getText().toString());
					//falta adicionar essa informação no banco de dados
					int lanterna = Integer.parseInt(txtFieldLanternas.getText().toString());
					int longline = Integer.parseInt(txtFieldLongline.getText().toString());
					int mesaMadeira = Integer.parseInt(txtFieldMesaMadeira.getText().toString());
					int mesaPVC = Integer.parseInt(txtFieldMesaPVC.getText().toString());
					int mesaTelada = Integer.parseInt(txtFieldMesaTelada.getText().toString());

					String data = txtFieldData.getText().toString();

					Estoque estoque = new Estoque(ValidacaoDeDatas.ordenarData(data), baby, semente, media, master,
							juvenil, malha69, malha12, malha14, malha21, longline, varal, mesaTelada, mesaPVC,
							mesaMadeira, coletores);
					estoque.criarEstoque(idPovoamento);
				} else {
					JOptionPane.showMessageDialog(null, "campo obrigatório vazio");
				}
			}
		};
	}

	public void preecherIdPovoamento(String id) {
		textFieldIdPovoamento.setText(id);
		idPovoamento = id;
	}
}
