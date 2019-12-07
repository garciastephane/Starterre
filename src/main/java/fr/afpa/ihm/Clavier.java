package fr.afpa.ihm;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.afpa.startTerre.App;


public class Clavier implements KeyListener{

	/**
	 * direction de l'avion lorsque le joueur appuie sur un des boutons gauche droite haut bas
	 */
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			App.scene.avion.setDx(1);
			
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			App.scene.avion.setDx(-1);

		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			App.scene.avion.setDy(-1);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			App.scene.avion.setDy(1);
		}
	}

	/**
	 * on stop le déplacement en relachant le bouton
	 */
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		App.scene.avion.setDx(0);
		App.scene.avion.setDy(0);
	
	}

	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
