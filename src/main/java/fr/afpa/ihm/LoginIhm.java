package fr.afpa.ihm;

import javax.swing.JOptionPane;

import fr.afpa.controles.PlayerControl;

public class LoginIhm {

	/**
	 * demande du pseudo du joueur avant le démarrage du jeu;
	 * @return
	 */
	public static String lancement() {
		
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
		String nom;

		do {
			nom = JOptionPane.showInputDialog(null, "Veuillez entrer votre nom !", "Bienvenue sur STARTERRE",
					JOptionPane.QUESTION_MESSAGE);
			if (PlayerControl.validNamePlayer(nom)) {
				JOptionPane.showMessageDialog(null, "Bienvenue sur STARTERRE " + nom, "Starterre",
						JOptionPane.INFORMATION_MESSAGE);
			}

			else {
				JOptionPane.showMessageDialog(null, "Veuillez entrer un nom valable", "Starterre",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} while (!PlayerControl.validNamePlayer(nom));
		return nom;
	}
}
