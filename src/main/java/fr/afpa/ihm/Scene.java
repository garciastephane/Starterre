package fr.afpa.ihm;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fr.afpa.startTerre.App;

public class Scene extends JPanel {

	private static final long serialVersionUID = -8255319694373975038L;

	private ImageIcon espaceFond;
	private ImageIcon espaceFond2;
	private ImageIcon meteoriteFond;
	private Image espace;
	private Image espace2;

	private ImageIcon vaisseauFond;
	private Image vaisseau;
	private int yFond1;
	private int yFond2;
	private Image meteorite;
	private int meteoriteY;
	private int meteoriteYActuel;
	private int meteoriteXActuel;
	private int meteoriteVit;
	private int dy;
	private int vaisseauX;
	private int vaisseauXActuel;
	private int vaisseauYActuel;
	private int vaisseauY;
	private Thread chronoEcran;

	public Scene() {

		super();
		this.vaisseauXActuel = 220;
		this.vaisseauYActuel = 680;
		this.meteoriteYActuel = -80;
		this.meteoriteXActuel = meteoritePositionAleatoire();
		this.meteoriteY = -1;
		this.dy = -1;
		this.yFond1 = 0;
		this.yFond2 = -750;
		this.espaceFond = new ImageIcon(getClass().getResource("../ihm/images/espace.png"));
		this.espaceFond2 = new ImageIcon(getClass().getResource("../ihm/images/espaceR.png"));
		this.espace = this.espaceFond.getImage();
		this.espace2 = this.espaceFond2.getImage();
		this.vaisseauFond = new ImageIcon(getClass().getResource("../ihm/images/avion.png"));
		this.vaisseau = this.vaisseauFond.getImage();
		this.meteoriteFond = new ImageIcon(getClass().getResource("../ihm/images/meteorite.png"));
		this.meteorite = this.meteoriteFond.getImage();

		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());

		chronoEcran = new Thread(new Chrono());
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
		this.meteoriteYActuel = this.meteoriteYActuel - this.meteoriteY;
		if (this.yFond1 == 800) {
			this.yFond1 = -690;
		} else if (this.yFond2 == 800) {
			this.yFond2 = -690;
		}
		if (this.meteoriteYActuel == 880) {
			this.meteoriteYActuel = -80;
			this.meteoriteXActuel = meteoritePositionAleatoire();
		}

	}

	public void deplacementVaisseau() {

	System.out.println("vaisseauX : " +vaisseauXActuel);
		System.out.println("METEORITE X : " +meteoriteXActuel);
		System.out.println();		
		System.out.println();
		System.out.println("vaisseauY : " +vaisseauYActuel);
		System.out.println("METEORITE Y : " +meteoriteYActuel);


		
		System.out.println();


		
		
		if( ((vaisseauXActuel >= meteoriteXActuel && vaisseauXActuel<= meteoriteXActuel+40)
				&& (vaisseauYActuel >= meteoriteYActuel && vaisseauYActuel <= meteoriteYActuel +40) )
				|| ((vaisseauXActuel+75 <= meteoriteXActuel && vaisseauXActuel+75 >= meteoriteXActuel +40) 
				&& (vaisseauYActuel >= meteoriteYActuel && vaisseauYActuel <= meteoriteYActuel +40 ) )) {
			
			chronoEcran.stop();
			
		}
		
		
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

		this.deplacementFond();
		this.deplacementVaisseau();
		g2.drawImage(this.espace, 0, this.yFond1, null, this);
		g2.drawImage(this.espace2, 0, this.yFond2, null, this);
		g2.drawImage(this.vaisseau, this.vaisseauXActuel, this.vaisseauYActuel, 75, 75, this);
		g2.drawImage(this.meteorite, meteoriteXActuel, this.meteoriteYActuel, 80, 80, this);
	}

	public int meteoritePositionAleatoire() {
		int random = new Random().nextInt(420);
		return random;
	}
}
