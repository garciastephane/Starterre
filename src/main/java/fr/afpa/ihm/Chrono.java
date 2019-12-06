package fr.afpa.ihm;

import fr.afpa.startTerre.App;

public class Chrono implements Runnable {

	private final int PAUSE = 5;

	public void run() {
		while (true) {
			App.scene.repaint();

			try {
				
				Thread.sleep(PAUSE);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
