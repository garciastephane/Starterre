package fr.afpa.ihm;

import fr.afpa.startTerre.App;

public class Chrono implements Runnable {

	private final int PAUSE = 3;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			App.scene.repaint();
			
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
