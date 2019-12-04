package fr.afpa.entite;

public class Avion {
	private String nom;
	private int nombreDeVie;
	private boolean estEnVie;
	private Score score;
	
	public Avion(String nom, int nombreDeVie, boolean estEnVie) {
		super();
		this.nom = nom;
		this.nombreDeVie = nombreDeVie;
		this.estEnVie = estEnVie;
		this.score = new Score(nom);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNombreDeVie() {
		return nombreDeVie;
	}

	public void setNombreDeVie(int nombreDeVie) {
		this.nombreDeVie = nombreDeVie;
	}

	public boolean isEstEnVie() {
		return estEnVie;
	}

	public void setEstEnVie(boolean estEnVie) {
		this.estEnVie = estEnVie;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Avion [nom=" + nom + ", nombreDeVie=" + nombreDeVie + ", estEnVie=" + estEnVie + ", score=" + score
				+ "]";
	}
	
	
}
