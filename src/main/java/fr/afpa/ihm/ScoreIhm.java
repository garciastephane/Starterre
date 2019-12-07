package fr.afpa.ihm;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.afpa.startTerre.App;

public class ScoreIhm{

	private JPanel score;
	private JLabel pv;
	private JLabel name;
	private JLabel scoret;
	private String pseudo;
	private int pointDeVie;
	private int pointDeScore;
	
	public ScoreIhm() {
		score = new JPanel();
		pv = new JLabel("Point de vie : " +pointDeVie);
		name = new JLabel("Nom : " +pseudo);
		scoret = new JLabel("Score : " +pointDeScore);
		score.setLayout(new GridLayout(1,3));
		score.add(pv);
		score.add(name);
		score.add(scoret);
	}

	public JPanel getScore() {
		pv.setText("Point de vie : " +pointDeVie);
		name.setText("Nom : " +pseudo);
		scoret.setText("Score : " +pointDeScore);
		
		return score;
	}
	public void setScore(JPanel score) {
		this.score = score;
	}
	public JLabel getPv() {
		return pv;
	}
	public void setPv(JLabel pv) {
		this.pv = pv;
	}
	public JLabel getName() {
		return name;
	}
	public void setName(JLabel name) {
		this.name = name;
	}
	public JLabel getScoret() {
		return scoret;
	}
	public void setScoret(JLabel scoret) {
		this.scoret = scoret;
	}

	public int getPointDeVie() {
		return pointDeVie;
	}

	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getPointDeScore() {
		return pointDeScore;
	}

	public void setPointDeScore(int pointDeScore) {
		this.pointDeScore = pointDeScore;
	}
	
}
