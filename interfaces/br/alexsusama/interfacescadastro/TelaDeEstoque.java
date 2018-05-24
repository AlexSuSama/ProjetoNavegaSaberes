package br.alexsusama.interfacescadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.alexsusama.modelo.Estoque;
import br.alexsusama.persisntencia.SaidaEntradaEstoque;
import br.alexsusama.validacoes.ValidacaoDeDatas;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDeEstoque extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textFieldData;
	private JTextField textFieldSemente;
	private JTextField textFieldJuvenil;
	private JTextField textFieldBaby;
	private JTextField textFieldMedia;
	private JTextField textFieldMaster;
	private JTextField textFieldMalha12;
	private JTextField textFieldMalha14;
	private JTextField textFieldMalha21;
	private JTextField textFieldMalha69;
	private JTextField textFieldColetores;
	private JTextField textFieldLongline;
	private JTextField textFieldVaral;
	private JTextField textFieldMesaTela;
	private JTextField textFieldMesaPVC;
	private JTextField textFieldMesaMadeira;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeEstoque frame = new TelaDeEstoque();
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
	public TelaDeEstoque() {
		setTitle("Estoque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setBounds(29, 30, 39, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSemente = new JLabel("Semente");
		lblSemente.setBounds(29, 117, 50, 14);
		contentPane.add(lblSemente);
		
		JLabel lblJuvenil = new JLabel("Juvenil");
		lblJuvenil.setBounds(29, 142, 50, 14);
		contentPane.add(lblJuvenil);
		
		JLabel lblBaby = new JLabel("Baby");
		lblBaby.setBounds(29, 181, 50, 14);
		contentPane.add(lblBaby);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E9dia");
		lblNewLabel_1.setBounds(29, 223, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMaster = new JLabel("Master");
		lblMaster.setBounds(29, 265, 46, 14);
		contentPane.add(lblMaster);
		
		JLabel lblMalha = new JLabel("Malha 12");
		lblMalha.setBounds(244, 120, 69, 14);
		contentPane.add(lblMalha);
		
		JLabel lblMalha_1 = new JLabel("Malha 14");
		lblMalha_1.setBounds(244, 160, 69, 14);
		contentPane.add(lblMalha_1);
		
		JLabel lblMalha_2 = new JLabel("Malha 21");
		lblMalha_2.setBounds(244, 194, 69, 14);
		contentPane.add(lblMalha_2);
		
		JLabel lblMalha_3 = new JLabel("Malha 6/9");
		lblMalha_3.setBounds(244, 226, 58, 14);
		contentPane.add(lblMalha_3);
		
		JLabel lblColetores = new JLabel("Coletores");
		lblColetores.setBounds(473, 113, 69, 14);
		contentPane.add(lblColetores);
		
		JLabel lblLongLine = new JLabel("Long line");
		lblLongLine.setBounds(473, 153, 69, 14);
		contentPane.add(lblLongLine);
		
		JLabel lblVaral = new JLabel("Varal");
		lblVaral.setBounds(473, 187, 69, 14);
		contentPane.add(lblVaral);
		
		JLabel lblMesaTelada = new JLabel("Mesa de tela");
		lblMesaTelada.setBounds(473, 219, 69, 14);
		contentPane.add(lblMesaTelada);
		
		JLabel lblMesaDePvc = new JLabel("Mesa de PVC");
		lblMesaDePvc.setBounds(473, 249, 69, 14);
		contentPane.add(lblMesaDePvc);
		
		JLabel lblMesaDeMadeira = new JLabel("Mesa de madeira");
		lblMesaDeMadeira.setBounds(473, 297, 69, 14);
		contentPane.add(lblMesaDeMadeira);
		
		textFieldData = new JTextField();
		textFieldData.setEditable(false);
		textFieldData.setBounds(60, 27, 86, 20);
		contentPane.add(textFieldData);
		textFieldData.setColumns(10);
		
		textFieldSemente = new JTextField();
		textFieldSemente.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldSemente.setEditable(false);
		textFieldSemente.setColumns(10);
		textFieldSemente.setBounds(83, 114, 86, 20);
		contentPane.add(textFieldSemente);
		
		textFieldJuvenil = new JTextField();
		textFieldJuvenil.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldJuvenil.setEditable(false);
		textFieldJuvenil.setColumns(10);
		textFieldJuvenil.setBounds(83, 139, 86, 20);
		contentPane.add(textFieldJuvenil);
		
		textFieldBaby = new JTextField();
		textFieldBaby.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldBaby.setEditable(false);
		textFieldBaby.setColumns(10);
		textFieldBaby.setBounds(83, 178, 86, 20);
		contentPane.add(textFieldBaby);
		
		textFieldMedia = new JTextField();
		textFieldMedia.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldMedia.setEditable(false);
		textFieldMedia.setColumns(10);
		textFieldMedia.setBounds(83, 220, 86, 20);
		contentPane.add(textFieldMedia);
		
		textFieldMaster = new JTextField();
		textFieldMaster.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldMaster.setEditable(false);
		textFieldMaster.setColumns(10);
		textFieldMaster.setBounds(83, 262, 86, 20);
		contentPane.add(textFieldMaster);
		
		textFieldMalha12 = new JTextField();
		textFieldMalha12.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldMalha12.setEditable(false);
		textFieldMalha12.setColumns(10);
		textFieldMalha12.setBounds(307, 117, 86, 20);
		contentPane.add(textFieldMalha12);
		
		textFieldMalha14 = new JTextField();
		textFieldMalha14.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldMalha14.setEditable(false);
		textFieldMalha14.setColumns(10);
		textFieldMalha14.setBounds(307, 157, 86, 20);
		contentPane.add(textFieldMalha14);
		
		textFieldMalha21 = new JTextField();
		textFieldMalha21.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldMalha21.setEditable(false);
		textFieldMalha21.setColumns(10);
		textFieldMalha21.setBounds(307, 191, 86, 20);
		contentPane.add(textFieldMalha21);
		
		textFieldMalha69 = new JTextField();
		textFieldMalha69.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldMalha69.setEditable(false);
		textFieldMalha69.setColumns(10);
		textFieldMalha69.setBounds(307, 223, 86, 20);
		contentPane.add(textFieldMalha69);
		
		textFieldColetores = new JTextField();
		textFieldColetores.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldColetores.setEditable(false);
		textFieldColetores.setColumns(10);
		textFieldColetores.setBounds(552, 110, 86, 20);
		contentPane.add(textFieldColetores);
		
		textFieldLongline = new JTextField();
		textFieldLongline.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldLongline.setEditable(false);
		textFieldLongline.setColumns(10);
		textFieldLongline.setBounds(552, 150, 86, 20);
		contentPane.add(textFieldLongline);
		
		textFieldVaral = new JTextField();
		textFieldVaral.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldVaral.setEditable(false);
		textFieldVaral.setColumns(10);
		textFieldVaral.setBounds(552, 184, 86, 20);
		contentPane.add(textFieldVaral);
		
		textFieldMesaTela = new JTextField();
		textFieldMesaTela.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldMesaTela.setEditable(false);
		textFieldMesaTela.setColumns(10);
		textFieldMesaTela.setBounds(552, 216, 86, 20);
		contentPane.add(textFieldMesaTela);
		
		textFieldMesaPVC = new JTextField();
		textFieldMesaPVC.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldMesaPVC.setEditable(false);
		textFieldMesaPVC.setColumns(10);
		textFieldMesaPVC.setBounds(552, 246, 86, 20);
		contentPane.add(textFieldMesaPVC);
		
		textFieldMesaMadeira = new JTextField();
		textFieldMesaMadeira.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldMesaMadeira.setEditable(false);
		textFieldMesaMadeira.setColumns(10);
		textFieldMesaMadeira.setBounds(552, 291, 86, 20);
		contentPane.add(textFieldMesaMadeira);
		
		JLabel lblOstrasEmEstoque = new JLabel("Ostras em estoque");
		lblOstrasEmEstoque.setBounds(29, 72, 140, 14);
		contentPane.add(lblOstrasEmEstoque);
		
		JLabel lblMalhasEmEstoque = new JLabel("Malhas em estoque");
		lblMalhasEmEstoque.setBounds(244, 72, 140, 14);
		contentPane.add(lblMalhasEmEstoque);
		
		JLabel lblApetrechosEmEstoque = new JLabel("Apetrechos em estoque");
		lblApetrechosEmEstoque.setBounds(473, 72, 140, 14);
		contentPane.add(lblApetrechosEmEstoque);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroEstoque cadastroEstoque = new CadastroEstoque();
				Home.repassarTelas(cadastroEstoque);
				dispose();
			}
		});
		btnAtualizar.setBounds(668, 11, 89, 33);
		contentPane.add(btnAtualizar);
	}
	public void preencherCampos(){
		SaidaEntradaEstoque entrada = new SaidaEntradaEstoque();
		Estoque estoque = entrada.resgatarEstoque();
		
		textFieldSemente.setText(String.valueOf(estoque.getOstraSemente()));
		textFieldBaby.setText(String.valueOf(estoque.getOstraBaby()));
		textFieldJuvenil.setText(String.valueOf(estoque.getOstraJuvenil()));
		textFieldMedia.setText(String.valueOf(estoque.getOstraJuvenil()));
		textFieldMaster.setText(String.valueOf(estoque.getOstraMaster()));
		
		textFieldData.setText(ValidacaoDeDatas.padronizarDatasNoCampo(estoque.getDataEstoque()));
		
		textFieldColetores.setText(String.valueOf(estoque.getColetores()));
		textFieldLongline.setText(String.valueOf(estoque.getLongLine()));
		textFieldMalha12.setText(String.valueOf(estoque.getMalha12()));
		textFieldMalha14.setText(String.valueOf(estoque.getMalha14()));
		textFieldMalha21.setText(String.valueOf(estoque.getMalha21()));
		textFieldMalha69.setText(String.valueOf(estoque.getMalha69()));
		textFieldMesaMadeira.setText(String.valueOf(estoque.getMesaMadeira()));
		textFieldMesaPVC.setText(String.valueOf(estoque.getMesaPVC()));
		textFieldMesaTela.setText(String.valueOf(estoque.getMesaTelada()));
		textFieldVaral.setText(String.valueOf(estoque.getVaral()));
	}
}











