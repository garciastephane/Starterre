package fr.afpa.controles;

public class PlayerControl {
	
	/**
	 * Controle du nom 
	 * @param name
	 * @return vrai si le nom est un ensemble de caractere contenant que des lettres compris entre 3 et 6 caractere
	 */
	public static boolean validNamePlayer(String name) {
		if (name != null && name.matches("[a-zA-Z ^;]{3,6}"))
			return true;

		return false;
	}

}
