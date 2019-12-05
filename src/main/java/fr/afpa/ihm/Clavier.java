package fr.afpa.ihm;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.afpa.startTerre.App;

public class Clavier implements KeyListener{

	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			App.scene.setVaisseauX(1);
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			App.scene.setVaisseauX(-1);
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			App.scene.setVaisseauY(-1);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			App.scene.setVaisseauY(1);
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		App.scene.setVaisseauX(0);
		App.scene.setVaisseauY(0);
	}

	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
