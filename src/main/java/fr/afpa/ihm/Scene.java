package fr.afpa.ihm;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fr.afpa.startTerre.App;

public class Scene extends JPanel {

	private static final long serialVersionUID = -8255319694373975038L;

	private ImageIcon espaceFond;
	private Image espace;
	private Image espace2;

	private ImageIcon vaisseauFond;
	private Image vaisseau;
	private int yFond1;
	private int yFond2;
	private int dy;
	private int vaisseauX;
	private int vaisseauXActuel;
	private int vaisseauYActuel;
	private int vaisseauY;

	public Scene() {

		super();
		this.vaisseauXActuel = 220;
		this.vaisseauYActuel = 680;
		this.dy = -1;
		this.yFond1 = 0;
		this.yFond2 = -750;
		espaceFond = new ImageIcon(getClass().getResource("../ihm/images/espace.png"));
		this.espace = this.espaceFond.getImage();
		this.espace2 = this.espaceFond.getImage();
		vaisseauFond = new ImageIcon(getClass().getResource("../ihm/images/avion.png"));
		this.vaisseau = this.vaisseauFond.getImage();

		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());

		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
	}

	/**
	 * @return the vaisseauX
	 */
	public int getVaisseauX() {
		return vaisseauX;
	}

	/**
	 * @param vaisseauX the vaisseauX to set
	 */
	public void setVaisseauX(int vaisseauX) {
		this.vaisseauX = vaisseauX;
	}

	/**
	 * @return the vaisseauY
	 */
	public int getVaisseauY() {
		return vaisseauY;
	}

	/**
	 * @param vaisseauY the vaisseauY to set
	 */
	public void setVaisseauY(int vaisseauY) {
		this.vaisseauY = vaisseauY;
	}

	public void deplacementFond() {
		this.yFond1 = this.yFond1 - this.dy;
		this.yFond2 = this.yFond2 - this.dy;
		if (this.yFond1 == 800) {
			this.yFond1 = -690;
		} else if (this.yFond2 == 800) {
			this.yFond2 = -690;
		}

	}

	public void deplacementVaisseau() {

		if (this.vaisseauXActuel == 0) {

			this.vaisseauXActuel = 1;

		} else if (this.vaisseauXActuel == 425) {
			this.vaisseauXActuel = 424;

		}
		if (this.vaisseauYActuel == 0) {

			this.vaisseauYActuel = 1;

		} else if (this.vaisseauYActuel == 695) {
			this.vaisseauYActuel = 694;

		}

		else {
			this.vaisseauXActuel = this.vaisseauXActuel + this.vaisseauX;

			this.vaisseauYActuel = this.vaisseauYActuel + this.vaisseauY;
		}
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics g2 = (Graphics2D) g;
		Dimension d = getSize();
		this.deplacementFond();
		this.deplacementVaisseau();
		g2.drawImage(this.espace, 0, this.yFond1, d.width, d.height, this);
		g2.drawImage(this.espace2, 0, this.yFond2, d.width, d.height, this);

		g2.drawImage(this.vaisseau, this.vaisseauXActuel, this.vaisseauYActuel, 75, 75, this);
	}
}
