package br.alexsusama.interfacescadastro;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.alexsusama.modelo.Povoamento;
//import br.alexsusama.persisntencia.SaidaEntradaPovoamento;
import br.alexsusama.validacoes.RestricoesDeValores;
import br.alexsusama.validacoes.ValidacaoDeDatas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
//import java.util.Calendar;
import java.awt.event.ActionEvent;

public class AtualizarPovoamento extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldNomeOstricultor;
	private JTextField textFieldQuantidadeSementes;
	private JTextField textFieldMunicipio;
	private JTextField textFieldLocalidade;
	private JTextField textFieldLongGraus;
	private JTextField textFieldLongMinutos;
	private JTextField textFieldLongSegundos;
	private JTextField textFieldLatiGraus;
	private JTextField textFieldLatiMinutos;
	private JTextField textFieldLatiSegundos;
	private JTextField textFieldData;
	RestricoesDeValores restricoes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarPovoamento frame = new AtualizarPovoamento();
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
	public AtualizarPovoamento() {
		setTitle("Atualizar Povoamento");

		restricoes = new RestricoesDeValores();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeOstriculor = new JLabel("Nome ostriculor: ");
		lblNomeOstriculor.setBounds(80, 73, 89, 14);
		contentPane.add(lblNomeOstriculor);

		JLabel lblPovoamento = new JLabel("Povoamento:");
		lblPovoamento.setBounds(80, 28, 89, 14);
		contentPane.add(lblPovoamento);

		JLabel lblMunicipio = new JLabel("Municipio:");
		lblMunicipio.setBounds(80, 163, 63, 14);
		contentPane.add(lblMunicipio);

		JLabel lblLocalidade = new JLabel("Localidade:");
		lblLocalidade.setBounds(336, 163, 63, 14);
		contentPane.add(lblLocalidade);

		JLabel lblQuantidadeDeSementes = new JLabel("Quantidade de Sementes:");
		lblQuantidadeDeSementes.setBounds(80, 115, 126, 14);
		contentPane.add(lblQuantidadeDeSementes);

		JLabel lblCoordenadasGeograficas = new JLabel("Coordenadas geograficas:");
		lblCoordenadasGeograficas.setBounds(80, 223, 142, 14);
		contentPane.add(lblCoordenadasGeograficas);

		JLabel lblLongitude = new JLabel("Longitude:");
		lblLongitude.setBounds(80, 271, 63, 14);
		contentPane.add(lblLongitude);

		JLabel lblLatitude = new JLabel("Latitude:");
		lblLatitude.setBounds(80, 318, 63, 14);
		contentPane.add(lblLatitude);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(257, 386, 89, 23);
		btnAtualizar.addActionListener(btnAtualizar());
		contentPane.add(btnAtualizar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(427, 386, 89, 23);
		contentPane.add(btnCancelar);

		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setBounds(179, 25, 86, 20);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);

		textFieldNomeOstricultor = new JTextField();
		textFieldNomeOstricultor.setColumns(10);
		textFieldNomeOstricultor.setBounds(257, 70, 293, 20);
		textFieldNomeOstricultor.addKeyListener(restricoes.negarNumeros(textFieldNomeOstricultor));
		contentPane.add(textFieldNomeOstricultor);

		textFieldQuantidadeSementes = new JTextField();
		textFieldQuantidadeSementes.setColumns(10);
		textFieldQuantidadeSementes.setBounds(257, 112, 293, 20);
		textFieldQuantidadeSementes.addKeyListener(restricoes.negarLetras(textFieldQuantidadeSementes));
		contentPane.add(textFieldQuantidadeSementes);

		textFieldMunicipio = new JTextField();
		textFieldMunicipio.setColumns(10);
		textFieldMunicipio.setBounds(153, 160, 161, 20);
		textFieldMunicipio.addKeyListener(restricoes.negarNumeros(textFieldMunicipio));
		contentPane.add(textFieldMunicipio);

		textFieldLocalidade = new JTextField();
		textFieldLocalidade.setColumns(10);
		textFieldLocalidade.setBounds(399, 160, 161, 20);
		textFieldLocalidade.addKeyListener(restricoes.negarNumeros(textFieldLocalidade));
		contentPane.add(textFieldLocalidade);

		textFieldLongGraus = new JTextField();
		textFieldLongGraus.setColumns(10);
		textFieldLongGraus.setBounds(153, 268, 44, 20);
		textFieldLongGraus.addKeyListener(restricoes.negarLetras(textFieldLongGraus));
		contentPane.add(textFieldLongGraus);

		textFieldLongMinutos = new JTextField();
		textFieldLongMinutos.setColumns(10);
		textFieldLongMinutos.setBounds(221, 268, 44, 20);
		textFieldLongMinutos.addKeyListener(restricoes.negarLetras(textFieldLongMinutos));
		contentPane.add(textFieldLongMinutos);

		textFieldLongSegundos = new JTextField();
		textFieldLongSegundos.setColumns(10);
		textFieldLongSegundos.setBounds(286, 268, 44, 20);
		textFieldLongSegundos.addKeyListener(restricoes.negarLetras(textFieldLongSegundos));
		contentPane.add(textFieldLongSegundos);

		textFieldLatiGraus = new JTextField();
		textFieldLatiGraus.setColumns(10);
		textFieldLatiGraus.setBounds(153, 315, 44, 20);
		textFieldLatiGraus.addKeyListener(restricoes.negarLetras(textFieldLatiGraus));
		contentPane.add(textFieldLatiGraus);

		textFieldLatiMinutos = new JTextField();
		textFieldLatiMinutos.setColumns(10);
		textFieldLatiMinutos.setBounds(221, 315, 44, 20);
		textFieldLatiMinutos.addKeyListener(restricoes.negarLetras(textFieldLatiMinutos));
		contentPane.add(textFieldLatiMinutos);

		textFieldLatiSegundos = new JTextField();
		textFieldLatiSegundos.setColumns(10);
		textFieldLatiSegundos.setBounds(286, 315, 44, 20);
		textFieldLatiSegundos.addKeyListener(restricoes.negarLetras(textFieldLatiSegundos));
		contentPane.add(textFieldLatiSegundos);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(298, 28, 44, 14);
		contentPane.add(lblData);
		try {
			MaskFormatter mascara = new MaskFormatter("##/##/####");
			textFieldData = new JFormattedTextField(mascara);
			textFieldData.setColumns(10);
			textFieldData.setBounds(341, 25, 209, 20);
			contentPane.add(textFieldData);
		} catch (Exception e) {
			// TODO: handle exception
		}
		JLabel label = new JLabel("\u00B0");
		label.setBounds(199, 271, 23, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel("'");
		label_1.setBounds(272, 271, 23, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("''");
		label_2.setBounds(338, 271, 23, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u00B0");
		label_3.setBounds(199, 318, 23, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("'");
		label_4.setBounds(272, 318, 23, 14);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("''");
		label_5.setBounds(338, 318, 23, 14);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("*");
		label_6.setBounds(282, 28, 13, 14);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("*");
		label_7.setBounds(68, 73, 13, 14);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("*");
		label_8.setBounds(68, 115, 13, 14);
		contentPane.add(label_8);

		JLabel label_9 = new JLabel("*");
		label_9.setBounds(68, 163, 13, 14);
		contentPane.add(label_9);

		JLabel label_10 = new JLabel("*");
		label_10.setBounds(319, 163, 13, 14);
		contentPane.add(label_10);
	}

	public void AtualizarCampos(Povoamento povoamento) {
		if (povoamento != null) {
			textFieldData.setText(povoamento.getDataInicialPovoamento());
			textFieldNomeOstricultor.setText(povoamento.getNomeOstricultor());
			textFieldQuantidadeSementes.setText(String.valueOf(povoamento.getQuantidadeSementes()));
			textFieldMunicipio.setText(povoamento.getMunicipio());
			textFieldLocalidade.setText(povoamento.getLocalidade());
			textFieldLongGraus.setText(String.valueOf(povoamento.getGrausLong()));
			textFieldLongMinutos.setText(String.valueOf(povoamento.getMinutosLong()));
			textFieldLongSegundos.setText(String.valueOf(povoamento.getSegundosLong()));
			textFieldLatiGraus.setText(String.valueOf(povoamento.getGrausLat()));
			textFieldLatiMinutos.setText(String.valueOf(povoamento.getMinutosLat()));
			textFieldLatiSegundos.setText(String.valueOf(povoamento.getSegundosLat()));
			textFieldID.setText(String.valueOf(povoamento.getIDPovoamentos()));

		} else {
			System.out.println("campos vazios");
		}
	}
	public ActionListener btnAtualizar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(textFieldData.getText().equals("") || textFieldLocalidade.getText().equals("")
						|| textFieldMunicipio.getText().equals("") || textFieldNomeOstricultor.getText().equals("")
						|| textFieldQuantidadeSementes.getText().equals("") || textFieldID.getText().equals(""))) {

					String id = textFieldID.getText().toString();

					String data = textFieldData.getText().toString();
					String nome = textFieldNomeOstricultor.getText().toString();
					String municipio = textFieldMunicipio.getText().toString();
					String local = textFieldLocalidade.getText().toString();
					int sementes = Integer.parseInt(textFieldQuantidadeSementes.getText().toString());

					int latiGraus = Integer.parseInt(textFieldLatiGraus.getText().toString());
					int latiMinutos = Integer.parseInt(textFieldLatiMinutos.getText().toString());
					double latiSegundos = Double.parseDouble(textFieldLatiSegundos.getText().toString());

					int longGraus = Integer.parseInt(textFieldLongGraus.getText().toString());
					int longMinutos = Integer.parseInt(textFieldLongMinutos.getText().toString());
					double longSegundos = Double.parseDouble(textFieldLongSegundos.getText().toString());

					Povoamento povoamento1 = new Povoamento();

					povoamento1.setDataInicial(ValidacaoDeDatas.ordenarData(data));
					povoamento1.setNomeOstricultor(nome);
					povoamento1.setLocalidade(local);
					povoamento1.setMunicipio(municipio);
					povoamento1.setQuantidadeSementes(sementes);
					// variaveis que é possivel não ter
					povoamento1.setGrausLat(latiGraus);
					povoamento1.setMinutosLat(latiMinutos);
					povoamento1.setSegundosLat(latiSegundos); 

					povoamento1.setGrausLong(longGraus);
					povoamento1.setMinutosLong(longMinutos);
					povoamento1.setSegundosLong(longSegundos);

					// povoamento1.printarPovoamento();
					povoamento1.editarPovoamentos(id);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Algum campo obrigatório não foi preenchido corretamente!");
				}
			}
		};
	}
}
