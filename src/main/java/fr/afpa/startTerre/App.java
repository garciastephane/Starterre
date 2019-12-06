package fr.afpa.startTerre;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import fr.afpa.ihm.LoginIhm;
import fr.afpa.ihm.Scene;

public class App {
	public static Scene scene;
	public static LoginIhm loginihm;

	public static void main(String[] args) {

		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
		String nom = JOptionPane.showInputDialog(null, "Veuillez entrer votre nom !", "Bienvenue sur STARTERRE",
				JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog(null, "Votre nom est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);

		JFrame window = new JFrame("Star Terre");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 800);
		window.setResizable(false);

		window.setLocationRelativeTo(null);

		scene = new Scene();
		window.setContentPane(scene);
		window.setVisible(true);

	}

}
