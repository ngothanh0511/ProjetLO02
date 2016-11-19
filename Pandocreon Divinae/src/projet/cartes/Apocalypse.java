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
	public Apocalypse(String nom, Integer idCarte, TypeCarte type, Origine origine, CapaciteSpeciale capacitespeciale){
		this.nom= nom;
		this.idCarte = idCarte;
		this.type = type;
		this.origine = origine;
		this.capaciteSpeciale = capacitespeciale;
	}
	
	public void activerFonctionCarte(Joueur joueur){
		
	}
	
	public String afficherCarte(){
		return ("c_"+idCarte+" :"+"Carte "+type+" "+nom+" d'origine "+origine);
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
