package fr.afpa.entite;

import javax.swing.ImageIcon;

public class MeteoriteIceBerg extends MeteoriteDeGlace{
	

	private static final int degatCauseIceberg = 4;

	/**
	 * Methode qui permets de creer les meteorites iceberg
	 * @param x
	 * @param y
	 */
	public MeteoriteIceBerg(int x, int y) {
		super(x, y);
		this.largeur = this.largeur * 2;
		this.meteoriteIcon = new ImageIcon(getClass().getResource("../ihm/images/meteorite.png"));
		this.meteorite = this.meteoriteIcon.getImage();
	}
	
	
	/**
	 * @return the degatcauseiceberg
	 */
	public static int getDegatcauseiceberg() {
		return degatCauseIceberg;
	}
	
}
