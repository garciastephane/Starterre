package fr.afpa.startTerre;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.afpa.ihm.LoginIhm;
import fr.afpa.ihm.Scene;

public class App {
	public static Scene scene;
	public static LoginIhm loginihm;

	public static void main(String[] args) {

		LoginIhm.lancement();
		
		JFrame window = new JFrame("Star Terre");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 800);
		window.setResizable(false);

		window.setLocationRelativeTo(null);

		scene = new Scene();
		//window.setContentPane(scene);
		JPanel score = new JPanel();
		JLabel pv = new JLabel("Point de vie : ");
		JLabel name = new JLabel("Nom : ");
		JLabel scoret = new JLabel("Score : ");
		score.setLayout(new GridLayout(1,3));
		score.add(pv);
		score.add(name);
		score.add(scoret);
		window.getContentPane().add(score, BorderLayout.NORTH);
		window.getContentPane().add(scene, BorderLayout.CENTER);
		window.setVisible(true);

	}

}
