package projet.cartes;

import projet.joueur.Joueur;

/**
 * La classe CarteCroyants repr�sente les cartes Croyants dans le jeu
 * 
 *
 */
public class CarteCroyants extends Carte {
	private Integer nbrCroyants;
	protected String [] dogmes= new String[3];
	/**
	 * La m�thode affiche les attributes de la carte Croyants
	 */
	public String afficherCarte(){
		return ("c_"+idCarte+" : "+"Carte "+type+" "+nom+" d'origine "+origine+", dogmes:{"+dogmes[0]+","+
				dogmes[1]+","+dogmes[2]+" }, contient "+nbrCroyants+" Croyants,"+" capacit� "+familleCapaciteSpeciale);
	}	
	/**
	 * Getter de l'attribute nbrCroyants
	 * @return
	 */
	 public int getNbrCroyants(){
		 return nbrCroyants;
	 }
	 /**
	  * Getter de l'attribute dogmes
	  * @return
	  */
	 public String [] getDogmes(){
		 return dogmes;
	 }
	 /**
	  * La m�thode active la fonctionne de la carte Croyants quand elle est utilis�e
	  */
	public void activerFonctionCarte(Joueur joueur, StockCarte s){
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
		
		
	




