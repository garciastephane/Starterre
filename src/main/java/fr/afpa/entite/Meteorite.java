package fr.afpa.entite;

public class Meteorite {
	private int vitesseDeplacement;
	private static final int degatCause = 1;
	private int largeur;
	private int hauteur;
	
	public Meteorite(int vitesseDeplacement,int largeur, int hauteur) {
		super();
		this.vitesseDeplacement = vitesseDeplacement;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	public int getVitesseDeplacement() {
		return vitesseDeplacement;
	}

	public void setVitesseDeplacement(int vitesseDeplacement) {
		this.vitesseDeplacement = vitesseDeplacement;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	@Override
	public String toString() {
		return "Meteorite [vitesseDeplacement=" + vitesseDeplacement + ", degatCause=" + degatCause + ", largeur="
				+ largeur + ", hauteur=" + hauteur + "]";
	}

	public static int getDegatcause() {
		return degatCause;
	}
}
