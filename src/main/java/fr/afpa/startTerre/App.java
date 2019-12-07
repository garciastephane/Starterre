package fr.afpa.startTerre;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.afpa.ihm.LoginIhm;
import fr.afpa.ihm.Scene;


public class App {
	public static Scene scene;
	public static LoginIhm loginihm;
	public static JFrame window;
	public static String pseudo;

	public static void main(String[] args) {

		pseudo = LoginIhm.lancement();
	    window = new JFrame("Star Terre");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 800);
		window.setResizable(false);

		window.setLocationRelativeTo(null);
		scene = new Scene();
		//window.setContentPane(scene);
		
		
		window.getContentPane().add(scene, BorderLayout.CENTER);
		window.setVisible(true);

	}

}
