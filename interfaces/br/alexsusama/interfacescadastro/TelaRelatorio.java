package br.alexsusama.interfacescadastro;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.itextpdf.text.DocumentException;

import br.alexsusama.modelo.GeradorDePDF;
import br.alexsusama.modelo.Povoamento;
import br.alexsusama.validacoes.ValidacaoDeDatas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class TelaRelatorio extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldIDPovoamento;
	private JTextField textFieldProdutorNome;
	private JTextField textFieldGrausLat;
	private JTextField textFieldMinutosLat;
	private JTextField textFieldSegundosLat;
	private JTextField textFieldGrausLog;
	private JTextField textFieldMinutosLog;
	private JTextField textFieldSegundosLog;
	private JFormattedTextField textFieldDataInicial;
	private JFormattedTextField textFieldDataFinal;
	private JTextField textFieldLocalidade;

	private int relatorioCompleto = 1;
	private int relatorioParcialBiometriaAmbiente = 2;
	private int relatorioParcialBiometriaComercializacao = 3;
	private int relatorioParcialComercialiazacaoAmbiente = 4;
	private int relatorioParcialComercializacao = 5;
	private int relatorioParcialAmbiente = 6;
	private int relatorioParcialBiometria = 7;
	// private boolean biometria = false;
	// private boolean comercilizacao = false;
	// private boolean ambiente = false;

	JRadioButton rdbtnComercializacao;

	JRadioButton rdbtnBiometrias;

	JRadioButton rdbtnAmbiente;
	private JTextField textFieldMunicipio;
	private JTextField textFieldCaminho;
	private JLabel lblCaminho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorio frame = new TelaRelatorio();
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
	public TelaRelatorio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Selecione o povoamento");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaPovoamentosEstoque listaPovoamentosEstoque = new ListaPovoamentosEstoque();
				listaPovoamentosEstoque.opcaoDeTela(3);
				listaPovoamentosEstoque.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 11, 161, 51);
		contentPane.add(btnNewButton);

		JLabel lblPovoamento = new JLabel("Povoamento:");
		lblPovoamento.setBounds(20, 76, 76, 14);
		contentPane.add(lblPovoamento);

		textFieldIDPovoamento = new JTextField();
		textFieldIDPovoamento.setEditable(false);
		textFieldIDPovoamento.setBounds(96, 73, 86, 20);
		contentPane.add(textFieldIDPovoamento);
		textFieldIDPovoamento.setColumns(10);

		JLabel lblProdutor = new JLabel("Produtor:");
		lblProdutor.setBounds(20, 118, 76, 14);
		contentPane.add(lblProdutor);

		textFieldProdutorNome = new JTextField();
		textFieldProdutorNome.setEditable(false);
		textFieldProdutorNome.setColumns(10);
		textFieldProdutorNome.setBounds(96, 115, 201, 20);
		contentPane.add(textFieldProdutorNome);

		JLabel lblCoordenadas = new JLabel("coordenadas:");
		lblCoordenadas.setBounds(20, 143, 76, 14);
		contentPane.add(lblCoordenadas);

		textFieldGrausLat = new JTextField();
		textFieldGrausLat.setEditable(false);
		textFieldGrausLat.setColumns(10);
		textFieldGrausLat.setBounds(96, 160, 86, 20);
		contentPane.add(textFieldGrausLat);

		textFieldMinutosLat = new JTextField();
		textFieldMinutosLat.setEditable(false);
		textFieldMinutosLat.setColumns(10);
		textFieldMinutosLat.setBounds(211, 160, 86, 20);
		contentPane.add(textFieldMinutosLat);

		textFieldSegundosLat = new JTextField();
		textFieldSegundosLat.setEditable(false);
		textFieldSegundosLat.setColumns(10);
		textFieldSegundosLat.setBounds(314, 160, 86, 20);
		contentPane.add(textFieldSegundosLat);

		textFieldGrausLog = new JTextField();
		textFieldGrausLog.setEditable(false);
		textFieldGrausLog.setColumns(10);
		textFieldGrausLog.setBounds(96, 193, 86, 20);
		contentPane.add(textFieldGrausLog);

		textFieldMinutosLog = new JTextField();
		textFieldMinutosLog.setEditable(false);
		textFieldMinutosLog.setColumns(10);
		textFieldMinutosLog.setBounds(211, 193, 86, 20);
		contentPane.add(textFieldMinutosLog);

		textFieldSegundosLog = new JTextField();
		textFieldSegundosLog.setEditable(false);
		textFieldSegundosLog.setColumns(10);
		textFieldSegundosLog.setBounds(314, 193, 86, 20);
		contentPane.add(textFieldSegundosLog);

		JLabel lblSelecioneAsInformaes = new JLabel(
				"Selecione as informa\u00E7\u00F5es que estaram presentes no relat\u00F3rio");
		lblSelecioneAsInformaes.setBounds(10, 242, 302, 14);
		contentPane.add(lblSelecioneAsInformaes);

		rdbtnComercializacao = new JRadioButton("Comercializa\u00E7\u00E3o");
		rdbtnComercializacao.setBounds(6, 276, 109, 23);
		contentPane.add(rdbtnComercializacao);

		rdbtnBiometrias = new JRadioButton("Biometrias");
		rdbtnBiometrias.setBounds(117, 276, 109, 23);
		contentPane.add(rdbtnBiometrias);

		rdbtnAmbiente = new JRadioButton("Ambiente");
		rdbtnAmbiente.setBounds(228, 276, 109, 23);
		contentPane.add(rdbtnAmbiente);

		JLabel lblSelecioneOPerodo = new JLabel("Selecione o per\u00EDodo:");
		lblSelecioneOPerodo.setBounds(10, 334, 124, 14);
		contentPane.add(lblSelecioneOPerodo);
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			textFieldDataInicial = new JFormattedTextField(mask);
			textFieldDataInicial.setColumns(10);
			textFieldDataInicial.setBounds(48, 362, 86, 20);
			contentPane.add(textFieldDataInicial);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			textFieldDataFinal = new JFormattedTextField(mask);
			textFieldDataFinal.setColumns(10);
			textFieldDataFinal.setBounds(174, 362, 86, 20);
			contentPane.add(textFieldDataFinal);
		} catch (Exception e) {
			// TODO: handle exception
		}
		JLabel lblDe = new JLabel("De");
		lblDe.setBounds(10, 365, 40, 14);
		contentPane.add(lblDe);

		JLabel lblAt = new JLabel("At\u00E9");
		lblAt.setBounds(144, 365, 40, 14);
		contentPane.add(lblAt);

		JLabel lblLocalidade = new JLabel("Localidade");
		lblLocalidade.setBounds(324, 118, 76, 14);
		contentPane.add(lblLocalidade);

		textFieldLocalidade = new JTextField();
		textFieldLocalidade.setEditable(false);
		textFieldLocalidade.setColumns(10);
		textFieldLocalidade.setBounds(388, 115, 201, 20);
		contentPane.add(textFieldLocalidade);

		JLabel lblLatitude = new JLabel("Latitude");
		lblLatitude.setBounds(20, 163, 76, 14);
		contentPane.add(lblLatitude);

		JLabel lblLongitude = new JLabel("Longitude");
		lblLongitude.setBounds(20, 199, 76, 14);
		contentPane.add(lblLongitude);

		JButton btnGerar = new JButton("Gerar");
		btnGerar.setBounds(650, 357, 109, 51);
		btnGerar.addActionListener(gerarPDF("local"));
		contentPane.add(btnGerar);

		textFieldMunicipio = new JTextField();
		textFieldMunicipio.setEditable(false);
		textFieldMunicipio.setColumns(10);
		textFieldMunicipio.setBounds(388, 73, 201, 20);
		contentPane.add(textFieldMunicipio);

		JLabel lblMunicpio = new JLabel("Munic\u00EDpio");
		lblMunicpio.setBounds(324, 76, 76, 14);
		contentPane.add(lblMunicpio);

		textFieldCaminho = new JTextField();
		textFieldCaminho.setColumns(10);
		textFieldCaminho.setBounds(287, 11, 403, 20);
		contentPane.add(textFieldCaminho);

		lblCaminho = new JLabel("Caminho");
		lblCaminho.setBounds(211, 11, 76, 14);
		contentPane.add(lblCaminho);

		JButton btnPasta = new JButton("");
		btnPasta.setIcon(new ImageIcon(TelaRelatorio.class.getResource("/br/alexsusama/imagens/iconePasta.png")));
		//java.awt.Image imgIconePasta = new ImageIcon(this.getClass().getResource("/pasta.png")).getImage();
		//btnPasta.setIcon(new ImageIcon(imgIconePasta));
		btnPasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser file = new JFileChooser();
				file.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int i = file.showSaveDialog(null);
				if (i == 1) {
					textFieldCaminho.setText("");
				} else {
					File arquivo = file.getSelectedFile();
					textFieldCaminho.setText(arquivo.getPath());
				}
			}
		});
		btnPasta.setBounds(700, 2, 59, 39);
		contentPane.add(btnPasta);
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home.repassarTelas(new TelaRelatorio());
			}
		});
		buttonCancelar.setBounds(474, 357, 109, 51);
		contentPane.add(buttonCancelar);
	}

	public ActionListener gerarPDF(String local) {
		return new ActionListener() {
 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				String dataInicial = textFieldDataInicial.getText().toString();
				String dataFinal = textFieldDataFinal.getText().toString();

				if (ValidacaoDeDatas.verificarData(dataInicial, dataFinal) && !(textFieldCaminho.getText().equals(""))) {
					if (rdbtnAmbiente.isSelected() && rdbtnComercializacao.isSelected()
							&& rdbtnBiometrias.isSelected()) {
						System.out.println("vai gerar o relatório completo");

						GeradorDePDF geradorDePDF = new GeradorDePDF();
						try {
							geradorDePDF.criarPDFCompleto(textFieldCaminho.getText().toString(), dataInicial, dataFinal,
									textFieldIDPovoamento.getText().toString(), relatorioCompleto,1);
						} catch (DocumentException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					} else if (rdbtnAmbiente.isSelected() && rdbtnComercializacao.isSelected()
							&& (rdbtnBiometrias.isSelected() == false)) {
						System.out.println("vai gerar o relatório apenas do ambiente e comercialização");
						GeradorDePDF geradorDePDF = new GeradorDePDF();
						try {
							geradorDePDF.criarPDFCompleto(textFieldCaminho.getText().toString(), dataInicial, dataFinal,
									textFieldIDPovoamento.getText().toString(), relatorioParcialComercialiazacaoAmbiente,2);
						} catch (DocumentException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (rdbtnAmbiente.isSelected() && rdbtnBiometrias.isSelected()
							&& (rdbtnComercializacao.isSelected() == false)) {
						GeradorDePDF geradorDePDF = new GeradorDePDF();
						try {
							geradorDePDF.criarPDFCompleto(textFieldCaminho.getText().toString(), dataInicial, dataFinal,
									textFieldIDPovoamento.getText().toString(), relatorioParcialBiometriaAmbiente,1);
						} catch (DocumentException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("vai gerar o relatório ambiente biometria");
					} else if (rdbtnComercializacao.isSelected() && rdbtnBiometrias.isSelected()
							&& (rdbtnAmbiente.isSelected() == false)) {
						GeradorDePDF geradorDePDF = new GeradorDePDF();
						try {
							geradorDePDF.criarPDFCompleto(textFieldCaminho.getText().toString(), dataInicial, dataFinal,
									textFieldIDPovoamento.getText().toString(), relatorioParcialBiometriaComercializacao,1);
						} catch (DocumentException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("vai gerar o relatório comercialização biometria");
						
					} else if (rdbtnComercializacao.isSelected()
							&& (rdbtnBiometrias.isSelected() == false && rdbtnAmbiente.isSelected() == false)) {
						GeradorDePDF geradorDePDF = new GeradorDePDF();
						try {
							geradorDePDF.criarPDFCompleto(textFieldCaminho.getText().toString(), dataInicial, dataFinal,
									textFieldIDPovoamento.getText().toString(), relatorioParcialComercializacao,3);
						} catch (DocumentException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("vai gerar o relatório comercialização");
					} else if (rdbtnAmbiente.isSelected()
							&& (rdbtnComercializacao.isSelected() == false && rdbtnBiometrias.isSelected() == false)) {
						GeradorDePDF geradorDePDF = new GeradorDePDF();
						try {
							geradorDePDF.criarPDFCompleto(textFieldCaminho.getText().toString(), dataInicial, dataFinal,
									textFieldIDPovoamento.getText().toString(), relatorioParcialAmbiente,2);
						} catch (DocumentException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("vai gerar o relatório ambiente");
						
					} else if (rdbtnBiometrias.isSelected()
							&& (rdbtnComercializacao.isSelected() == false && rdbtnAmbiente.isSelected() == false)) {
						GeradorDePDF geradorDePDF = new GeradorDePDF();
						try {
							geradorDePDF.criarPDFCompleto(textFieldCaminho.getText().toString(), dataInicial, dataFinal,
									textFieldIDPovoamento.getText().toString(), relatorioParcialBiometria,1);
						} catch (DocumentException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("vai gerar o relatório biometria");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de gerar o relatório");
				}
			}
		};
	}

	public void atualizarCampos(Povoamento povoamento) {
		textFieldIDPovoamento.setText(String.valueOf(povoamento.getIDPovoamentos()));
		textFieldLocalidade.setText(povoamento.getLocalidade());
		textFieldProdutorNome.setText(povoamento.getNomeOstricultor());
		textFieldMunicipio.setText(povoamento.getMunicipio());

		if (povoamento.getGrausLat() > 0) {
			textFieldGrausLat.setText(String.valueOf(povoamento.getGrausLat()));
			textFieldMinutosLat.setText(String.valueOf(povoamento.getMinutosLat()));
			textFieldSegundosLat.setText(String.valueOf(povoamento.getSegundosLat()));

			textFieldGrausLog.setText(String.valueOf(povoamento.getGrausLong()));
			textFieldMinutosLog.setText(String.valueOf(povoamento.getMinutosLong()));
			textFieldSegundosLog.setText(String.valueOf(povoamento.getSegundosLong()));
		} else {
			System.out.println("povoamento não possui informação de latitude");
		}
	}
}
