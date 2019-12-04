package fr.afpa.entite;

public class MeteoriteDeFeu extends Meteorite {
	
	private static final int DegatsCauseFeu = 2;
	
	public MeteoriteDeFeu(int vitesseDeplacement, int largeur, int hauteur) {
		super(vitesseDeplacement,largeur, hauteur);
		// TODO Auto-generated constructor stub
	}

	public static int getDegatscausefeu() {
		return DegatsCauseFeu;
	}

	@Override
	public String toString() {
		return "MeteoriteDeFeu [getVitesseDeplacement()=" + getVitesseDeplacement() + ", getLargeur()=" + getLargeur()
				+ ", getHauteur()=" + getHauteur() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

}
