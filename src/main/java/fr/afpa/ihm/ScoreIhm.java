package fr.afpa.ihm;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.afpa.startTerre.App;

public class ScoreIhm implements Comparable<ScoreIhm>{

	private JPanel score;
	private JLabel pv;
	private JLabel name;
	private JLabel scoret;
	private String pseudo;
	private String date;
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
	public ScoreIhm(String pseudo, int pointDeScore, String date) {
		this.pseudo = pseudo;
		this.pointDeScore = pointDeScore;
		this.setDate(date);
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int compareTo(ScoreIhm o) {
		// TODO Auto-generated method stub
		return o.getPointDeScore() - this.getPointDeScore();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScoreIhm other = (ScoreIhm) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pointDeScore != other.pointDeScore)
			return false;
		if (pointDeVie != other.pointDeVie)
			return false;
		if (pseudo == null) {
			if (other.pseudo != null)
				return false;
		} else if (!pseudo.equals(other.pseudo))
			return false;
		if (pv == null) {
			if (other.pv != null)
				return false;
		} else if (!pv.equals(other.pv))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (scoret == null) {
			if (other.scoret != null)
				return false;
		} else if (!scoret.equals(other.scoret))
			return false;
		return true;
	}
	
}
