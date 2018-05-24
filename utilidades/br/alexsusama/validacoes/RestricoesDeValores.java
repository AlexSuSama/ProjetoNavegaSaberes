package br.alexsusama.validacoes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class RestricoesDeValores {
	public KeyListener negarLetras(JTextField field) {
		return new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				field.setText(field.getText().replaceAll("[^0-9]", ""));

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		};
	}
	public KeyListener negarNumeros(JTextField field) {
		return new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				field.setText(field.getText().replaceAll("[^a-z,^A-Z, ,У,у,Ю,А,ц,Ц,М,И,С,З,аисмз,Й,й,Г,г]", ""));

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		};
	}
}
