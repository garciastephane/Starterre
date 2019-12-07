package fr.afpa.entite;

import javax.swing.ImageIcon;

public class MeteoriteDeFeu extends Meteorite {
	private static int PAUSE = 10;
	private static final int DegatsCauseFeu = 2;
	private boolean contactFeu;
	
	public MeteoriteDeFeu(int x, int y) {
		super(x,y);
		this.meteoriteIcon = new ImageIcon(getClass().getResource("../ihm/images/meteoritefeu.png"));
		this.meteorite = this.meteoriteIcon.getImage();
	
	}

	public static int getDegatscausefeu() {
		return DegatsCauseFeu;
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

	public boolean isContactFeu() {
		return contactFeu;
	}

	public void setContactFeu(boolean contactFeu) {
		this.contactFeu = contactFeu;
	}

	@Override
	public String toString() {
		return "MeteoriteDeFeu [getVitesseDeplacement()=" + getVitesseDeplacement() + ", getLargeur()=" + getLargeur()
				+ ", getHauteur()=" + getHauteur() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
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
