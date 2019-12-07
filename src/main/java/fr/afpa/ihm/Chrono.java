package fr.afpa.ihm;

import fr.afpa.entite.Meteorite;
import fr.afpa.entite.MeteoriteDeFeu;
import fr.afpa.startTerre.App;

public class Chrono implements Runnable {

	private  int PAUSE = 5;

	public void run() {
		while (true) {
			App.scene.repaint();

			try {
				
				if(App.scene.getScoreIhm().getPointDeScore()==3) {
					PAUSE = 4;
					Meteorite.setPAUSE(5);
					MeteoriteDeFeu.setPAUSE(7);
				}
				if(App.scene.getScoreIhm().getPointDeScore()==6) {
					PAUSE = 3;
					Meteorite.setPAUSE(3);
					MeteoriteDeFeu.setPAUSE(5);
				}
				if(App.scene.getScoreIhm().getPointDeScore()==9) {
					PAUSE = 2;
					Meteorite.setPAUSE(2);
					MeteoriteDeFeu.setPAUSE(5);
				}
				if(App.scene.getScoreIhm().getPointDeScore()==12) {
					PAUSE = 1;
					Meteorite.setPAUSE(1);
					MeteoriteDeFeu.setPAUSE(3);
				}
				if(App.scene.getScoreIhm().getPointDeScore()==15) {
					PAUSE = 0;
					Meteorite.setPAUSE(1);
					MeteoriteDeFeu.setPAUSE(2);
				}
				Thread.sleep(PAUSE);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
