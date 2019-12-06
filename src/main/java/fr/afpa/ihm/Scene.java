package fr.afpa.ihm;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fr.afpa.entite.Avion;
import fr.afpa.entite.Meteorite;
import fr.afpa.entite.MeteoriteDeFeu;


public class Scene extends JPanel {

	private static final long serialVersionUID = -8255319694373975038L;

	private ImageIcon espaceFond;
	private ImageIcon espaceFond2;
	private Image espace;
	private Image espace2;

	private int yFond1;
	private int yFond2;
	private int dy;

	public Avion avion;
	private Meteorite meteorite;
	private MeteoriteDeFeu meteoriteFeu;

	public Scene() {

		super();
		this.dy = -1;
		this.yFond1 = 0;
		this.yFond2 = -750;
		this.espaceFond = new ImageIcon(getClass().getResource("../ihm/images/espace.png"));
		this.espaceFond2 = new ImageIcon(getClass().getResource("../ihm/images/espaceR.png"));
		this.espace = this.espaceFond.getImage();
		this.espace2 = this.espaceFond2.getImage();
		
		avion = new Avion("Fayaz", 220, 680);
		meteorite = new Meteorite(meteoritePositionAleatoire(420), -80);
		meteoriteFeu = new MeteoriteDeFeu(meteoritePositionAleatoire(420), -80);
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());

		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
	}


	public void deplacementFond() {
		this.yFond1 = this.yFond1 - this.dy;
		this.yFond2 = this.yFond2 - this.dy;
		//this.meteoriteYActuel = this.meteoriteYActuel - this.meteoriteY;
		if(this.yFond1 == 800) {			
			this.yFond1 = -690;
		} else if (this.yFond2 == 800) {
			this.yFond2 = -690;
		}
	/*	if(this.meteoriteYActuel == 880) {
			this.meteoriteYActuel = -80;
			this.meteoriteXActuel = meteoritePositionAleatoire();
		}*/
		
		
	}

	public void deplacementVaisseau() {

		if (this.avion.getX() == 0) {

			this.avion.setX(1);

		} else if (this.avion.getX() == 425) {
			this.avion.setX(424);

		}
		if (this.avion.getY() == 0) {

			this.avion.setY(1); 

		} else if (this.avion.getY() == 695) {
			this.avion.setY(694);

		}

		else {
			this.avion.setX( this.avion.getX() + this.avion.getDx());

			this.avion.setY(this.avion.getY() + this.avion.getDy()); 
		}
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D) g;
		Dimension d = getSize();
		this.deplacementFond();
		this.deplacementVaisseau();
		g2.drawImage(this.espace, 0, this.yFond1, d.width, d.height, this);
		g2.drawImage(this.espace2, 0, this.yFond2, d.width,d.height, this);	
		g2.drawImage(this.avion.getImgVaisseau(), this.avion.getX(), this.avion.getY(), this.avion.getLargeur(),this.avion.getHauteur() ,this);	
		g2.drawImage(this.meteorite.getMeteorite(), this.meteorite.getX(), this.meteorite.getY(), this.meteorite.getLargeur(), this.meteorite.getHauteur(),this);
		g2.drawImage(this.meteoriteFeu.getMeteorite(), this.meteoriteFeu.getX(), this.meteoriteFeu.getY(), this.meteoriteFeu.getLargeur(), this.meteoriteFeu.getHauteur(),this);
	}
	
	public static int meteoritePositionAleatoire(int value) {
		int random = new Random().nextInt(value);
		return random;
	}
}
