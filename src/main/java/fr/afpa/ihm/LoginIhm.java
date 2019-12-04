package fr.afpa.ihm;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginIhm {

	public static void DisplayLoginMenu()	{
		final JFrame parent = new JFrame();
		JButton button = new JButton();

		button.setText("Bienvenue!");
		parent.add(button);
		parent.pack();
		parent.setVisible(true);
		
		button.addActionListener(new java.awt.event.ActionListener() 
			{			
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String name = JOptionPane.showInputDialog(parent, "Quel est ton nom?", null);
			}
			});
	}
}
