package br.alexsusama.interfacescadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class ScreenInit extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenInit frame = new ScreenInit();
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
	public ScreenInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAqui = new JLabel("");
		lblAqui.setIcon(new ImageIcon(ScreenInit.class.getResource("/br/alexsusama/imagens/ostraInit.png")));
		//Image imgInit = new ImageIcon(this.getClass().getResource("/ostra.png")).getImage();
		contentPane.setLayout(new BorderLayout(0, 0));
		//lblAqui.setIcon(new ImageIcon(imgInit));
		contentPane.add(lblAqui);
	}
}









