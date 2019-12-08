package fr.afpa.entite;

import javax.swing.ImageIcon;

import fr.afpa.startTerre.App;

public class MeteoriteDeGlace extends Meteorite {
	private static int PAUSE = 7;
	public static final int degatCauseGlace = 2;
	private boolean contactGlace;
	
	/**
	 * Methode qui permets de creer des meteorites de glace
	 * @param x
	 * @param y
	 */
	public MeteoriteDeGlace(int x, int y) {
		super(x, y);
		this.meteoriteIcon = new ImageIcon(getClass().getResource("../ihm/images/meteoriteGlace.png"));
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
	public static void setPAUSE(int pAUSE) {
		PAUSE = pAUSE;
	}
	
	public boolean isContactGlace() {
		return contactGlace;
	}

	public void setContactGlace(boolean contactGlace) {
		this.contactGlace = contactGlace;
	}

	/**
	 * Methode qui permets de controler la vitesse des meteorites de glace
	 */
	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			this.deplacementMeteorite();
		    try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
