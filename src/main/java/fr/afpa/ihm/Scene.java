package fr.afpa.ihm;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fr.afpa.controles.FichierControl;
import fr.afpa.entite.Avion;
import fr.afpa.entite.Meteorite;
import fr.afpa.entite.MeteoriteDeFeu;
import fr.afpa.entite.MeteoriteDeGlace;
import fr.afpa.startTerre.App;


public class Scene extends JPanel {

	private static final long serialVersionUID = -8255319694373975038L;
	private ImageIcon espaceFond;
	private Image espace;
	private Image espace2;
	private ScoreIhm scoreIhm;
	private int yFond1;
	private int yFond2;
	private int dy;
	public Avion avion;
	private Meteorite meteorite;
	private Meteorite meteoriteFeu;
	private Meteorite meteoriteGlace;
	Thread chronoEcran;
	List<Meteorite> typeMeteorite = new ArrayList<Meteorite>();
	int meteoriteRandom;
	
	/**
	 * création de la scene, de la plateforme du jeu avec initialisation des composants
	 */
	public Scene() {
		
		super();
		this.dy = -1;
		this.yFond1 = 0;
		this.yFond2 = -750;
		this.espaceFond = new ImageIcon(getClass().getResource("../ihm/images/espace.png"));
		this.espace = this.espaceFond.getImage();
		this.espace2 = this.espaceFond.getImage();
		
		avion = new Avion(220, 680);
		scoreIhm = new ScoreIhm();
		scoreIhm.setPseudo(App.pseudo);
		scoreIhm.setPointDeVie(avion.getNombreDeVie());
		meteorite = new Meteorite(meteoritePositionAleatoire(420), -80);
		meteoriteFeu = new MeteoriteDeFeu(meteoritePositionAleatoire(420), -80);
		meteoriteGlace = new MeteoriteDeGlace(meteoritePositionAleatoire(420), -80);
		typeMeteorite.add(meteorite);
		typeMeteorite.add(meteoriteFeu);
		typeMeteorite.add(meteoriteGlace);
		meteoriteRandom = meteoritePositionAleatoire(typeMeteorite.size());
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());

		chronoEcran = new Thread(new Chrono());
		
		chronoEcran.start();
	}


	public ScoreIhm getScoreIhm() {
		return scoreIhm;
	}


	public void setScoreIhm(ScoreIhm scoreIhm) {
		this.scoreIhm = scoreIhm;
	}


	public Avion getAvion() {
		return avion;
	}


	public void setAvion(Avion avion) {
		this.avion = avion;
	}


	public Meteorite getMeteorite() {
		return meteorite;
	}


	public void setMeteorite(Meteorite meteorite) {
		this.meteorite = meteorite;
	}


	


	public void setMeteoriteFeu(MeteoriteDeFeu meteoriteFeu) {
		this.meteoriteFeu = meteoriteFeu;
	}

	/**
	 * défilement du background du jeu (espace)
	 */
	public void deplacementFond() {
		this.yFond1 = this.yFond1 - this.dy;
		this.yFond2 = this.yFond2 - this.dy;

		if(this.yFond1 == 800) {			
			this.yFond1 = -690;
		} else if (this.yFond2 == 800) {
			this.yFond2 = -690;
		}
		
	}
	
	/**
	 * collision entre l'avion et les météorites et s
	 * @return
	 */
	public boolean crash() {
		for (Meteorite meteorite : typeMeteorite) {
			if( ((this.avion.getX()+30  >= meteorite.getX() && avion.getX()<= meteorite.getX()+40)
					&& (this.avion.getY() >= meteorite.getY() && avion.getY() <= meteorite.getY() +40 && !this.avion.isContact()))
					|| ((this.avion.getX()+75 <= meteorite.getX() && avion.getX()+75 >= meteorite.getX() +40)
					&& (this.avion.getY()>= meteorite.getY() && avion.getY() <= meteorite.getY() +40 && !this.avion.isContact()) ))
					 {		
							this.avion.setContact(true);	
							if(this.meteorite instanceof Meteorite) {
								this.avion.setNombreDeVie(this.avion.getNombreDeVie()-Meteorite.getDegatcause());
								this.scoreIhm.setPointDeVie(this.avion.getNombreDeVie());
							}
							else if(this.meteorite instanceof MeteoriteDeFeu) {
								this.avion.setNombreDeVie(this.avion.getNombreDeVie()-MeteoriteDeFeu.getDegatscausefeu());
								this.scoreIhm.setPointDeVie(this.avion.getNombreDeVie());
							}
							else if(this.meteorite instanceof MeteoriteDeGlace) {
								this.avion.setNombreDeVie(this.avion.getNombreDeVie()-MeteoriteDeGlace.getDegatcauseglace());
								this.scoreIhm.setPointDeVie(this.avion.getNombreDeVie());
							}
							return true;									
					}
			
			if(this.avion.getY() + 75 <this.meteorite.getY()) {
				this.avion.setContact(false);
				return false;
			}
		}
		return false;
		
	}
	
	/**
	 * deplacement du vaisseau et les collision avec les bords du cadre
	 */
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
	
	/**
	 * dessiner les composants selon leur position et leur définition
	 */
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D) g;
		
		
		
		this.deplacementFond();
		this.deplacementVaisseau();
		g2.drawImage(this.espace, 0, this.yFond1, 500, 800, this);
		g2.drawImage(this.espace2, 0, this.yFond2, 500,800, this);
		if(crash()) {
			g2.drawImage(this.avion.getExplosionVaisseau(), this.avion.getX(), this.avion.getY(), this.avion.getLargeur(),this.avion.getHauteur() ,this);	
			
		}else {
			g2.drawImage(this.avion.getImgVaisseau(), this.avion.getX(), this.avion.getY(), this.avion.getLargeur(),this.avion.getHauteur() ,this);	
		}
		
		g2.drawImage(this.meteorite.getMeteorite(), this.meteorite.getX(), this.meteorite.getY(), this.meteorite.getLargeur(), this.meteorite.getHauteur(),this);
		g2.drawImage(this.meteoriteFeu.getMeteorite(), this.meteoriteFeu.getX(), this.meteoriteFeu.getY(), this.meteoriteFeu.getLargeur(), this.meteoriteFeu.getHauteur(),this);
		g2.drawImage(this.meteoriteGlace.getMeteorite(), this.meteoriteGlace.getX(), this.meteoriteGlace.getY(), this.meteoriteGlace.getLargeur(), this.meteoriteGlace.getHauteur(),this);
		JPanel score = scoreIhm.getScore();
		App.window.getContentPane().add(score, BorderLayout.NORTH);
		if(this.avion.getNombreDeVie() == 0) {
			g2.drawImage(this.avion.getExplosionVaisseau(), this.avion.getX(), this.avion.getY(), this.avion.getLargeur(),this.avion.getHauteur() ,this);
			FichierControl.stockerScore(scoreIhm);
			chronoEcran.suspend();
		}
	}
	
	public static int meteoritePositionAleatoire(int value) {
		int random = new Random().nextInt(value);
		return random;
	}
}
