package fr.afpa.entite;

import java.awt.Image;

import javax.swing.ImageIcon;

import fr.afpa.startTerre.App;
import fr.afpa.ihm.Scene;

public class Meteorite implements Runnable{
	private int vitesseDeplacement;
	private static final int degatCause = 1;
	protected int largeur = 80;
	protected int hauteur = 80;
	protected int x;
	protected int y;
	protected Image meteorite;
	protected ImageIcon meteoriteIcon;
	private static final int PAUSE = 7;
	protected int meteoriteY;

	
	public Meteorite(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.meteoriteY = 1;
		this.meteoriteIcon = new ImageIcon(getClass().getResource("../ihm/images/meteorite.png"));
		this.meteorite = this.meteoriteIcon.getImage();
		
		Thread chronoMeteorite = new Thread(this);
		chronoMeteorite.start();
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

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the meteorite
	 */
	public Image getMeteorite() {
		return meteorite;
	}



	public static int getDegatcause() {
		return degatCause;
	}

	/**
	 * @return the pAUSE
	 */
	public static int getPAUSE() {
		return PAUSE;
	}

	/**
	 * @return the meteoriteX
	 */
	public int getMeteoriteY() {
		return meteoriteY;
	}

	/**
	 * @param meteoriteX the meteoriteX to set
	 */
	public void setMeteoriteY(int meteoriteY) {
		this.meteoriteY = meteoriteY;
	}


	
	public void deplacementMeteorite() {
		this.y = this.y+meteoriteY;
		if(this.y == 880) {
			App.scene.getScoreIhm().setPointDeScore(App.scene.getScoreIhm().getPointDeScore()+1);
			this.y = -80;
			this.x = Scene.meteoritePositionAleatoire(420);
		}
	}
	

	public void run() {	
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			this.deplacementMeteorite();
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
	
			}
		}
	}
	
	@Override
	public String toString() {
		return "Meteorite [vitesseDeplacement=" + vitesseDeplacement + ", degatCause=" + degatCause + ", largeur="
				+ largeur + ", hauteur=" + hauteur + "]";
	}
	
	
}
