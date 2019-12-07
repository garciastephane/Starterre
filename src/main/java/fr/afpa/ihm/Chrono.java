package fr.afpa.ihm;

import fr.afpa.entite.Meteorite;
import fr.afpa.entite.MeteoriteDeFeu;
import fr.afpa.entite.MeteoriteDeGlace;
import fr.afpa.startTerre.App;

public class Chrono implements Runnable {

	private  int PAUSE = 5;
	
	/**
	 * thread de 5 ms ou moins pour faire redessiner le jeu
	 */
	public void run() {
		while (true) {
			App.scene.repaint();

			try {
				
				if(App.scene.getScoreIhm().getPointDeScore()==3) {
					PAUSE = 4;
					Meteorite.setPAUSE(5);
					MeteoriteDeFeu.setPAUSE(7);
					MeteoriteDeGlace.setPAUSE(5);
				}
				if(App.scene.getScoreIhm().getPointDeScore()==6) {
					PAUSE = 3;
					Meteorite.setPAUSE(4);
					MeteoriteDeFeu.setPAUSE(6);
					MeteoriteDeGlace.setPAUSE(4);
				}
				if(App.scene.getScoreIhm().getPointDeScore()==9) {
					PAUSE = 2;
					Meteorite.setPAUSE(3);
					MeteoriteDeFeu.setPAUSE(5);
					MeteoriteDeGlace.setPAUSE(3);
				}
				if(App.scene.getScoreIhm().getPointDeScore()==12) {
					PAUSE = 1;
					Meteorite.setPAUSE(2);
					MeteoriteDeFeu.setPAUSE(3);
					MeteoriteDeGlace.setPAUSE(2);
				}
				if(App.scene.getScoreIhm().getPointDeScore()==15) {
					PAUSE = 0;
					Meteorite.setPAUSE(1);
					MeteoriteDeFeu.setPAUSE(2);
					MeteoriteDeGlace.setPAUSE(1);
				}
				Thread.sleep(PAUSE);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
