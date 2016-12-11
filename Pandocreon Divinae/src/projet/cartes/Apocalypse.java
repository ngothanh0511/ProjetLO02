package projet.cartes;

import projet.joueur.Joueur;

/**
 * La classe Apocalypse repr�sente les Cartes Apocalypse dans le jeu
 * 
 *
 */
public class Apocalypse extends Carte {
	/**
	 * Constructeur par d�faut d'une carte Apocalypse
	 * @param nom : nom de la carte
	 * @param idCarte: id de la carte
	 * @param type : type de la carte
	 * @param origine: origine de la carte
	 * @param capacitespeciale: capacit� de la carte
	 */
	public Apocalypse(String nom, Integer idCarte, String type, String origine, String familleCapacitespeciale){
		this.nom= nom;
		this.idCarte = idCarte;
		this.type = type;
		this.origine = origine;
		this.familleCapaciteSpeciale = familleCapacitespeciale;
	}
	/**
	 * Cette m�thode active la fonctionne de la carte Apocalypse quand elle est utilis�e
	 *
	 */
	public void activerFonctionCarte(Joueur joueur,StockCarte s){
		joueur.activerCapaciteSpeciale(this, s);
	}
	/**
	 * Cette m�thode affiche les attributes de la carte Apocalypse
	 *
	 */
	public String afficherCarte(){
		return ("c_"+idCarte+" :"+"Carte "+type+" "+nom+" d'origine "+origine);
	}	
	

	
	

}
