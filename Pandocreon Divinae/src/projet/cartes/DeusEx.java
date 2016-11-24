package projet.cartes;

import java.util.Collections;
import java.util.Scanner;

import projet.joueur.Joueur;
import projet.joueur.Partie;

/**
 * La classe DeusEx représente les cartes Deus Ex dans le jeu
 * @author Tung NGO
 *
 */
public class DeusEx extends Carte {
	static Scanner scan = new Scanner(System.in);
	/**
	 * Constructeur par défaut d'une carte Deus Ex
	 * @param nom: nom de la carte
	 * @param idCarte : id de la carte
	 * @param type: type de la carte
	 * @param origine: origine de la carte
	 * @param capacitespeciale : capacité spéciale de la carte
	 */
	
	public DeusEx (String nom, Integer idCarte, String type, String origine, String familleCapacitespeciale){
		this.nom= nom;
		this.idCarte = idCarte;
		this.type = type;
		this.origine = origine;
		this.familleCapaciteSpeciale = familleCapacitespeciale;
	}
	
	
	public String afficherCarte(){
		return ("c_"+idCarte+": "+"Carte "+type+" "+nom+" d'origine "+origine+", capacité "+familleCapaciteSpeciale);
	}


	@Override
	public void activerFonctionCarte(Joueur joueur) {
		// TODO Auto-generated method stub
		
	}	
	
	

}
