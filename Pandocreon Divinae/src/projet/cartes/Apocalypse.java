package projet.cartes;

import projet.joueur.Joueur;

/**
 * La classe Apocalypse représente les Cartes Apocalypse dans le jeu
 * @author Tung NGO
 *
 */
public class Apocalypse extends Carte {
	/**
	 * Constructeur par défaut d'une carte Apocalypse
	 * @param nom : nom de la carte
	 * @param idCarte: id de la carte
	 * @param type : type de la carte
	 * @param origine: origine de la carte
	 * @param capacitespeciale: capacité de la carte
	 */
	public Apocalypse(String nom, Integer idCarte, String type, String origine, String familleCapacitespeciale){
		this.nom= nom;
		this.idCarte = idCarte;
		this.type = type;
		this.origine = origine;
		this.familleCapaciteSpeciale = familleCapacitespeciale;
	}
	
	public void activerFonctionCarte(Joueur joueur){
		
	}
	
	public String afficherCarte(){
		return ("c_"+idCarte+" :"+"Carte "+type+" "+nom+" d'origine "+origine);
	}	
	

	
	

}
