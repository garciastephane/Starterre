package fr.afpa.controles;

public class PlayerControl {

	public static boolean validNamePlayer(String name) {
		if (name != null && name.matches("[a-zA-Z ^;]{3,6}"))
			return true;

		return false;
	}

}
