package fr.afpa.entite;

import javax.swing.ImageIcon;

import fr.afpa.startTerre.App;

public class MeteoriteDeGlace extends Meteorite {
	private static final int PAUSE = 7;
	public static final int degatCauseGlace = 2;
	
	public MeteoriteDeGlace(int x, int y) {
		super(x, y);
		this.meteoriteIcon = new ImageIcon(getClass().getResource("../ihm/images/meteoritefeu.png"));
		this.meteorite = this.meteoriteIcon.getImage();
	}

	public static int getDegatcauseglace() {
		return degatCauseGlace;
	}

	/**
	 * @return the pause
	 */
	public static int getPause() {
		return PAUSE;
	}
	
	

}
