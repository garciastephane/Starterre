package fr.afpa.entite;

public class Score {
	private String pseudo;
	private int pointGagner;
	private String date;
	
	
	public Score(String pseudo, int pointGagner, String date) {
		super();
		this.pseudo = pseudo;
		this.pointGagner = pointGagner;
		this.date = date;
	}
	public Score(String pseudo) {
		super();
		this.pseudo = pseudo;
		
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public int getPointGagner() {
		return pointGagner;
	}


	public void setPointGagner(int pointGagner) {
		this.pointGagner = pointGagner;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Score [pseudo=" + pseudo + ", pointGagner=" + pointGagner + ", date=" + date + "]";
	}
}
