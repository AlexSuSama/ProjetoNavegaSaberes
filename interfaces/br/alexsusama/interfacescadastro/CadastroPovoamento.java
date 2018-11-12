package br.alexsusama.interfacescadastro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.alexsusama.modelo.Povoamento;
import br.alexsusama.validacoes.RestricoesDeValores;
import br.alexsusama.validacoes.ValidacaoDeDatas;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CadastroPovoamento extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3214135085144347579L;
	private JPanel contentPane;
	private JTextField textFieldOstricultor;
	private JTextField textFieldLocalidade;
	private JTextField textFieldMunicipio;
	private JTextField textFieldIdPovoamento;
	private JTextField textFieldQTSementes;
	private JTextField textFieldLongitudeGraus;
	private JTextField textFieldLongitudeMinutos;
	private JTextField textFieldLongitudeSegundos;
	private JTextField textFieldLatitudeGraus;
	private JTextField textFieldLatitudeMinutos;
	private JTextField textFieldLatitudeSegundos;
	private JTextField textFieldDataPovoamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPovoamento frame = new CadastroPovoamento();
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
	public CadastroPovoamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		RestricoesDeValores valores = new RestricoesDeValores();

		textFieldOstricultor = new JTextField();
		textFieldOstricultor.setToolTipText("EX: Aleksandro Oliveira");
		textFieldOstricultor.setBounds(262, 45, 215, 20);
		textFieldOstricultor.addKeyListener(valores.negarNumeros(textFieldOstricultor));
		contentPane.add(textFieldOstricultor);
		textFieldOstricultor.setColumns(10);

		textFieldLocalidade = new JTextField();
		textFieldLocalidade.setToolTipText("Ex Alegre\r\n");
		textFieldLocalidade.setColumns(10);
		textFieldLocalidade.setBounds(371, 178, 179, 20);
		textFieldLocalidade.addKeyListener(valores.negarNumeros(textFieldLocalidade));
		contentPane.add(textFieldLocalidade);

		textFieldMunicipio = new JTextField();
		textFieldMunicipio.setToolTipText("Ex: Bragan\u00E7a\r\n");
		textFieldMunicipio.setColumns(10);
		textFieldMunicipio.setBounds(107, 178, 150, 20);
		textFieldMunicipio.addKeyListener(valores.negarNumeros(textFieldMunicipio));
		contentPane.add(textFieldMunicipio);

		JLabel lblOstricultor = new JLabel("Ostricultor");
		lblOstricultor.setBounds(39, 48, 98, 14);
		contentPane.add(lblOstricultor);

		JLabel lblLocalidade = new JLabel("Localidade");
		lblLocalidade.setBounds(280, 181, 82, 14);
		contentPane.add(lblLocalidade);

		JLabel lblMunicipio = new JLabel("Municipio");
		lblMunicipio.setBounds(39, 181, 69, 14);
		contentPane.add(lblMunicipio);

		JButton btnSalvar = new JButton("Salvar");

		btnSalvar.setBounds(289, 345, 89, 23);
		btnSalvar.addActionListener(btnSalvar());
		contentPane.add(btnSalvar);

		JLabel lblIdPovoamento = new JLabel("id povoamento");
		lblIdPovoamento.setEnabled(false);
		lblIdPovoamento.setBounds(39, 11, 115, 14);
		contentPane.add(lblIdPovoamento);

		textFieldIdPovoamento = new JTextField();
		textFieldIdPovoamento.setEnabled(false);
		textFieldIdPovoamento.setBounds(262, 8, 69, 20);
		contentPane.add(textFieldIdPovoamento);
		textFieldIdPovoamento.setColumns(10);

		JLabel lblQuantidadeDeSementes = new JLabel("Quantidade de Sementes");
		lblQuantidadeDeSementes.setBounds(39, 96, 140, 14);
		contentPane.add(lblQuantidadeDeSementes);

		textFieldQTSementes = new JTextField();
		textFieldQTSementes.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldQTSementes.setToolTipText("EX: 10000");
		textFieldQTSementes.setColumns(10);
		textFieldQTSementes.setBounds(262, 93, 215, 20);
		textFieldQTSementes.addKeyListener(valores.negarLetras(textFieldQTSementes));
		contentPane.add(textFieldQTSementes);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home.repassarTelas(new ListaPovoamentos());
				dispose();
			}
		});
		btnCancelar.setBounds(441, 345, 89, 23);
		contentPane.add(btnCancelar);

		JLabel lblCoordenadasGeogrficas = new JLabel("Coordenadas geogr\u00E1ficas");
		lblCoordenadasGeogrficas.setBounds(39, 209, 130, 14);
		contentPane.add(lblCoordenadasGeogrficas);

		JLabel lblN = new JLabel("Longitude");
		lblN.setBounds(24, 267, 53, 14);
		contentPane.add(lblN);

		JLabel lblLatitude = new JLabel("Latitude");
		lblLatitude.setBounds(24, 299, 53, 14);
		contentPane.add(lblLatitude);

		textFieldLongitudeGraus = new JTextField();
		textFieldLongitudeGraus.setColumns(10);
		textFieldLongitudeGraus.setBounds(87, 264, 41, 20);
		textFieldLongitudeGraus.addKeyListener(valores.negarLetras(textFieldLongitudeGraus));
		contentPane.add(textFieldLongitudeGraus);

		JLabel label = new JLabel("\u00B0");
		label.setBounds(138, 267, 13, 14);
		contentPane.add(label);

		textFieldLongitudeMinutos = new JTextField();
		textFieldLongitudeMinutos.setColumns(10);
		textFieldLongitudeMinutos.setBounds(148, 264, 41, 20);
		textFieldLongitudeMinutos.addKeyListener(valores.negarLetras(textFieldLongitudeMinutos));
		contentPane.add(textFieldLongitudeMinutos);

		JLabel label_1 = new JLabel("'");
		label_1.setBounds(201, 267, 13, 14);
		contentPane.add(label_1);
		try {
			MaskFormatter mascara = new MaskFormatter("##.#");
			textFieldLongitudeSegundos = new JFormattedTextField(mascara);
			textFieldLongitudeSegundos.setColumns(10);
			textFieldLongitudeSegundos.setBounds(216, 264, 41, 20);
			textFieldLongitudeSegundos.addKeyListener(valores.negarLetras(textFieldLongitudeSegundos));
			contentPane.add(textFieldLongitudeSegundos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		JLabel label_2 = new JLabel("\"");
		label_2.setBounds(259, 267, 13, 14);
		contentPane.add(label_2);

		textFieldLatitudeGraus = new JTextField();
		textFieldLatitudeGraus.setColumns(10);
		textFieldLatitudeGraus.setBounds(87, 296, 41, 20);
		textFieldLatitudeGraus.addKeyListener(valores.negarLetras(textFieldLatitudeGraus));
		contentPane.add(textFieldLatitudeGraus);

		textFieldLatitudeMinutos = new JTextField();
		textFieldLatitudeMinutos.setColumns(10);
		textFieldLatitudeMinutos.setBounds(148, 296, 41, 20);
		textFieldLatitudeMinutos.addKeyListener(valores.negarLetras(textFieldLatitudeMinutos));
		contentPane.add(textFieldLatitudeMinutos);
		try {
			MaskFormatter mascara = new MaskFormatter("##.#");
			textFieldLatitudeSegundos = new JFormattedTextField(mascara);
			textFieldLatitudeSegundos.setColumns(10);
			textFieldLatitudeSegundos.setBounds(216, 296, 41, 20);
			textFieldLatitudeSegundos.addKeyListener(valores.negarLetras(textFieldLatitudeSegundos));
			contentPane.add(textFieldLatitudeSegundos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		JLabel label_3 = new JLabel("\u00B0");
		label_3.setBounds(138, 299, 13, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("'");
		label_4.setBounds(201, 299, 13, 14);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("\"");
		label_5.setBounds(262, 299, 13, 14);
		contentPane.add(label_5);

		JLabel lblDataDoPovoamento = new JLabel("Data do povoamento");
		lblDataDoPovoamento.setBounds(39, 133, 140, 14);
		contentPane.add(lblDataDoPovoamento);

		try {
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");
			textFieldDataPovoamento = new JFormattedTextField(mascaraData);
			textFieldDataPovoamento.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldDataPovoamento.setToolTipText("EX: 12/12/2012");
			textFieldDataPovoamento.setColumns(10);
			textFieldDataPovoamento.setBounds(262, 130, 69, 20);
			contentPane.add(textFieldDataPovoamento);

		} catch (Exception e) {
			// TODO: handle exception
		}

		JLabel lblDadasdasd = new JLabel("");
		lblDadasdasd.setForeground(Color.RED);
		lblDadasdasd.setBackground(Color.RED);
		lblDadasdasd.setBounds(0, 0, 584, 39);
		contentPane.add(lblDadasdasd);

		JLabel label_6 = new JLabel("*");
		label_6.setBounds(23, 48, 13, 14);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("*");
		label_7.setBounds(23, 96, 13, 14);
		contentPane.add(label_7);
 
		JLabel label_8 = new JLabel("*");
		label_8.setBounds(23, 133, 13, 14);
		contentPane.add(label_8);

		JLabel label_9 = new JLabel("*");
		label_9.setBounds(23, 181, 13, 14);
		contentPane.add(label_9);

		JLabel label_10 = new JLabel("*");
		label_10.setBounds(262, 181, 13, 14);
		contentPane.add(label_10);
	}

	public ActionListener btnSalvar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String data = textFieldDataPovoamento.getText().trim().toString();
				if (!(textFieldLocalidade.getText().trim().equals("") || textFieldMunicipio.getText().trim().equals("")
						|| textFieldOstricultor.getText().trim().equals("")				
						|| textFieldQTSementes.getText().trim().equals("")||textFieldDataPovoamento.getText().trim().equals("//"))) {
					
					String dataInicial = textFieldDataPovoamento.getText().toString();
					String nomeOstricultor = textFieldOstricultor.getText().toString();
					String localidade = textFieldLocalidade.getText().toString();
					String municipio = textFieldMunicipio.getText().toString();

					int quantidadeSementes = Integer.parseInt(textFieldQTSementes.getText().toString());

					if (!textFieldLatitudeSegundos.getText().trim().equals(".")) {
						int longitudeGraus = Integer.parseInt(textFieldLongitudeGraus.getText().toString());
						int longitudeMinutos = Integer.parseInt(textFieldLongitudeMinutos.getText().toString());
						double longitudeSegundos = Double.parseDouble(textFieldLongitudeSegundos.getText().toString());
						int latitudeGraus = Integer.parseInt(textFieldLatitudeGraus.getText().toString());
						int latitudeMinutos = Integer.parseInt(textFieldLatitudeMinutos.getText().toString());
						double latitudeSegundos = Double.parseDouble(textFieldLatitudeSegundos.getText().toString());

						Povoamento povoamento = new Povoamento(quantidadeSementes,
								ValidacaoDeDatas.ordenarData(dataInicial), nomeOstricultor, localidade, municipio,
								latitudeGraus, latitudeMinutos, latitudeSegundos, longitudeGraus, longitudeMinutos,
								longitudeSegundos);
						povoamento.criarPovoamento();

						ListaPovoamentos povoamentos = new ListaPovoamentos();
						povoamentos.setVisible(true);
						Home.repassarTelas(povoamentos);
						dispose();

					} else {
						System.out.println(data);
						if(data.equals("//")){
							System.out.println("data valida");
						}else{
							System.out.println("data vazia");
						}
						Povoamento povoamento = new Povoamento(quantidadeSementes,
								ValidacaoDeDatas.ordenarData(dataInicial), nomeOstricultor, localidade, municipio);
						povoamento.criarPovoamento();

						ListaPovoamentos povoamentos = new ListaPovoamentos();
						povoamentos.setVisible(true);
						Home.repassarTelas(povoamentos);
						dispose();

					}
				} else {
					JOptionPane.showMessageDialog(null, "campos obrigatórios vazios.");
				}
			}
		};
	}
}
