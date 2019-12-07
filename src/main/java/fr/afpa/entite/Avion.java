package fr.afpa.entite;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Avion {
	private String nom;
	private int largeur;
	private int hauteur;
	private int x;
	private int y;
	private int dx;
	private int dy;
	private int nombreDeVie;
	private boolean estEnVie;
	private boolean contact;
	private Image imgVaisseau;
	private ImageIcon iconVaisseau;
	private Image explosionVaisseau;
	private ImageIcon explosionVaisseauIcon;
	
	public Avion(int x, int y) {
		super();
		this.nom = nom;
		this.nombreDeVie = 5;
		this.x = x;
		this.y = y;
		this.largeur = 75;
		this.hauteur = 75;
		this.estEnVie = true;
		this.iconVaisseau = new ImageIcon(getClass().getResource("../ihm/images/vaisseau.png"));
		this.imgVaisseau = this.iconVaisseau.getImage();
		this.explosionVaisseauIcon =  new ImageIcon(getClass().getResource("../ihm/images/explosion.png"));
		this.explosionVaisseau = this.explosionVaisseauIcon.getImage();
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
	 * @return the hauteur
	 */
	public int getHauteur() {
		return hauteur;
	}

	/**
	 * @param hauteur the hauteur to set
	 */
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	/**
	 * @return the largeur
	 */
	public int getLargeur() {
		return largeur;
	}

	/**
	 * @param largeur the largeur to set
	 */
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	/**
	 * @return the dx
	 */
	public int getDx() {
		return dx;
	}

	/**
	 * @param dx the dx to set
	 */
	public void setDx(int dx) {
		this.dx = dx;
	}

	/**
	 * @return the dy
	 */
	public int getDy() {
		return dy;
	}

	/**
	 * @param dy the dy to set
	 */
	public void setDy(int dy) {
		this.dy = dy;
	}

	public boolean isEstEnVie() {
		return estEnVie;
	}

	public void setEstEnVie(boolean estEnVie) {
		this.estEnVie = estEnVie;
	}

	public boolean isContact() {
		return contact;
	}

	public void setContact(boolean contact) {
		this.contact = contact;
	}

	/**
	 * @return the imgVaisseau
	 */
	public Image getImgVaisseau() {
		return imgVaisseau;
	}

	/**
	 * @return the explosionVaisseau
	 */
	public Image getExplosionVaisseau() {
		return explosionVaisseau;
	}


	@Override
	public String toString() {
		return "Avion [nom=" + nom + ", nombreDeVie=" + nombreDeVie + ", estEnVie=" + "]";
	}
	
	
}
