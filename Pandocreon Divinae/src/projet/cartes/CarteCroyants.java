package projet.cartes;

import java.util.Arrays;

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
				dogmes[1]+","+dogmes[2]+", capacité"+familleCapaciteSpeciale+" et contient "+nbrCroyants+" Croyants");
	}	
	 public int getNbrCroyants(){
		 return nbrCroyants;
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
	public CarteCroyants (String nom, Integer idCarte, TypeCarte type, Origine origine, String [] dogmes, Integer nbrCroyants, FamilleCapaciteSpeciale familleCapaciteSpeciale ){
		this.nom = nom;
		this.idCarte = idCarte;
		this.type = type;
		this.origine = origine;
		this.dogmes = dogmes;
		this.nbrCroyants = nbrCroyants;
		this.familleCapaciteSpeciale = familleCapaciteSpeciale;
	}
	
	public void activerCapaciteSpeciale(Joueur joueur){
		if (familleCapaciteSpeciale == FamilleCapaciteSpeciale.F_1) {
			if (origine==Origine.Jour){
				int point = joueur.getPtActionJour() +1;
				joueur.setPtActionJour(point);
			}
			else if (origine ==Origine.Nuit){
				int point = joueur.getPtActionNuit() +1;
				joueur.setPtActionNuit(point);
			}
			else {
				int point = joueur.getPtActionNeant() +1;
				joueur.setPtActionNeant(point);
			}
		
		}
		else if (familleCapaciteSpeciale == FamilleCapaciteSpeciale.F_2){
			if ((Arrays.asList(dogmes).contains(joueur.getDogmesDivin()[0]) == false) &&
					((Arrays.asList(dogmes).contains(joueur.getDogmesDivin()[1]) == false)) &&
					((Arrays.asList(dogmes).contains(joueur.getDogmesDivin()[2]) == false))){
				joueur.setPeutSacrifier(false);
			}
		}
		
		}
	}
		
		
	




