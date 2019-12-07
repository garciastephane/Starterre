package fr.afpa.controles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import fr.afpa.ihm.ScoreIhm;

public class FichierControl {
	/**
	 * Stocker le nom, le score et la date du moment dans un fichier
	 * @param joueur
	 */
	public static void stockerScore(ScoreIhm playerScore) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
		//	fw = new FileWriter(System.getenv("C:\\Users\\59013-70-07\\Desktop\\testFichier"));
		//	fw = new FileWriter(System.getenv("LABY_HOME")+"\\Score.txt", true);
			fw = new FileWriter(System.getenv("StarTerre")+"Starterre.txt", true);	
		    bw = new BufferedWriter(fw);
			bw.write(playerScore.getPseudo());
			bw.write(";");
			bw.write(playerScore.getPointDeScore()+"");
			bw.write(";");
			bw.write(LocalDate.now().toString());
			bw.newLine();
			bw.close();
		}catch(Exception e){
			System.out.println("Erreur "+e);
		}
		
	}
	 
	/**
	 * Lire le fichier contenant le nom, le score et la date et l'heure du moment
	 * @return un tableau de string pour pouvoir le parser
	 */
	public static LinkedList<String> LectureFichierScore() {
		LinkedList<String> strScore = new LinkedList<String>();
		FileReader fr = null;
		BufferedReader br = null;
		try {		
			// fr = new FileReader("C:\\ENV\\Ressources\\Score.txt");
			fr = new FileReader(System.getenv("StarTerre")+"Starterre.txt");
			 br = new BufferedReader(fr);		
			while(br.ready()) {
				strScore.add(br.readLine());
			}		
			br.close();
		}catch(Exception e) {
			System.out.println("Erreur "+e);
		}
		return strScore;
	}
	
	/**
	 * Recuperer les lignes dans une liste de score
	 * @return la liste contenant les scores
	 */
	public static LinkedList<ScoreIhm> getAllScore() {		
		List<String> strScore = LectureFichierScore();
		LinkedList<ScoreIhm> listScore = new LinkedList<ScoreIhm>();
		String[] splitScore = null;
		for (String score : strScore) {
			splitScore = score.split(";");
			listScore.add(new ScoreIhm(splitScore[0], Integer.parseInt(splitScore[1]), splitScore[2]));
		}
		Collections.sort(listScore);
		return listScore;
	}
	
	/**
	 * Affichage des 20 meilleurs score;
	 */
	public static void afficheScore() {
		LinkedList<ScoreIhm> listScore = getAllScore();
		int taille = listScore.size();
		if(taille > 20) {
			taille = 20;
		}
		System.out.println("Joueur\tScore\tDate");
		for(int i=0; i<taille;i++) {
			System.out.println(listScore.get(i).getPseudo()+ "\t"+listScore.get(i).getPointDeScore()+ "\t"+listScore.get(i).getDate() );
		}
	}
	
}
