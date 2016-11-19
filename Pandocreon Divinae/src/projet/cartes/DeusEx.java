package projet.cartes;

import projet.joueur.Joueur;

/**
 * La classe DeusEx repr�sente les cartes Deus Ex dans le jeu
 * @author Tung NGO
 *
 */
public class DeusEx extends Carte {
	/**
	 * Constructeur par d�faut d'une carte Deus Ex
	 * @param nom: nom de la carte
	 * @param idCarte : id de la carte
	 * @param type: type de la carte
	 * @param origine: origine de la carte
	 * @param capacitespeciale : capacit� sp�ciale de la carte
	 */
	
	public DeusEx (String nom, Integer idCarte, TypeCarte type, Origine origine, CapaciteSpeciale capacitespeciale){
		this.nom= nom;
		this.idCarte = idCarte;
		this.type = type;
		this.origine = origine;
		this.capaciteSpeciale = capacitespeciale;
	}
	
	public void activerFonctionCarte(Joueur joueur){
		
	}
	
	public String afficherCarte(){
		return ("c_"+idCarte+": "+"Carte "+type+" "+nom+" d'origine "+origine+", capacit� "+capaciteSpeciale);
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
