package projet.cartes;

import java.util.Scanner;
import projet.joueur.Joueur;


/**
 * La classe DeusEx repr�sente les cartes Deus Ex dans le jeu
 * 
 *
 */
public class DeusEx extends Carte {
	static Scanner scan = new Scanner(System.in);
	/**
	 * Constructeur par d�faut d'une carte Deus Ex
	 * @param nom: nom de la carte
	 * @param idCarte : id de la carte
	 * @param type: type de la carte
	 * @param origine: origine de la carte
	 * @param capacitespeciale : capacit� sp�ciale de la carte
	 */
	
	public DeusEx (String nom, Integer idCarte, String type, String origine, String familleCapacitespeciale){
		this.nom= nom;
		this.idCarte = idCarte;
		this.type = type;
		this.origine = origine;
		this.familleCapaciteSpeciale = familleCapacitespeciale;
	}
	
	/**
	 * La m�thode qui affiche les attributes de la carte DeusEx
	 */
	public String afficherCarte(){
		return ("c_"+idCarte+": "+"Carte "+type+" "+nom+" d'origine "+origine+", capacit� "+familleCapaciteSpeciale);
	}


	/**
	 * La m�thode active la fonctionne de la carte DeusEx quand elle est utilis�e
	 */
	public void activerFonctionCarte(Joueur joueur,StockCarte s) {
		joueur.activerCapaciteSpeciale(this, s);
		
	}	
	
	

}
