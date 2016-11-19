package projet.cartes;

import projet.joueur.Joueur;

/**
 * La classe CarteCroyants représente les cartes Croyants dans le jeu
 * @author Tung NGO
 *
 */
public class CarteCroyants extends Carte {
	private Integer nbrCroyants;
	protected String [] dogmes= new String[3];
	public String afficherCarte(){
		return ("c_"+idCarte+" : "+"Carte "+type+" "+nom+" d'origine "+origine+", dogmes:"+dogmes[0]+","+
				dogmes[1]+","+dogmes[2]+", capacité"+capaciteSpeciale+" et contient "+nbrCroyants+" Croyants");
	}	
	
	public void activerFonctionCarte(Joueur joueur){
		Tapis.recevoirCartes(this);
		this.calculerPtAction(joueur);
	}
	/**
	 * Constructeur par défaut d'une carte Croyants
	 * @param nom : nom de la carte
	 * @param idCarte : id de la carte 
	 * @param type: type de la carte
	 * @param origine : origine de la carte
	 * @param dogmes : dogmes de la carte
	 * @param nbrCroyants : le nombre de Croyants que la carte possède
	 * @param capaciteSpeciale : la capacité spéciale de la carte
	 */
	public CarteCroyants (String nom, Integer idCarte, TypeCarte type, Origine origine, String [] dogmes, Integer nbrCroyants, CapaciteSpeciale capaciteSpeciale ){
		this.nom = nom;
		this.idCarte = idCarte;
		this.type = type;
		this.origine = origine;
		this.dogmes = dogmes;
		this.nbrCroyants = nbrCroyants;
		this.capaciteSpeciale = capaciteSpeciale;
	}
	
		
		}
	




