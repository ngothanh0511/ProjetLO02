package projet.cartes;

import java.util.Arrays;

import projet.joueur.Joueur;

/**
 * La classe CarteCroyants repr�sente les cartes Croyants dans le jeu
 * @author Tung NGO
 *
 */
public class CarteCroyants extends Carte {
	private Integer nbrCroyants;
	protected String [] dogmes= new String[3];
	public String afficherCarte(){
		return ("c_"+idCarte+" : "+"Carte "+type+" "+nom+" d'origine "+origine+", dogmes:"+dogmes[0]+","+
				dogmes[1]+","+dogmes[2]+", capacit�"+familleCapaciteSpeciale+" et contient "+nbrCroyants+" Croyants");
	}	
	 public int getNbrCroyants(){
		 return nbrCroyants;
	 }
	
	 public String [] getDogmes(){
		 return dogmes;
	 }
	public void activerFonctionCarte(Joueur joueur){
		Tapis.recevoirCartes(this);
	}
	/**
	 * Constructeur par d�faut d'une carte Croyants
	 * @param nom : nom de la carte
	 * @param idCarte : id de la carte 
	 * @param type: type de la carte
	 * @param origine : origine de la carte
	 * @param dogmes : dogmes de la carte
	 * @param nbrCroyants : le nombre de Croyants que la carte poss�de
	 * @param capaciteSpeciale : la capacit� sp�ciale de la carte
	 */
	public CarteCroyants (String nom, Integer idCarte, String type, String origine, String [] dogmes, Integer nbrCroyants, String familleCapaciteSpeciale ){
		this.nom = nom;
		this.idCarte = idCarte;
		this.type = type;
		this.origine = origine;
		this.dogmes = dogmes;
		this.nbrCroyants = nbrCroyants;
		this.familleCapaciteSpeciale = familleCapaciteSpeciale;
	}
	
	}
		
		
	




