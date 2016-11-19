package projet.cartes;

import projet.joueur.Joueur;

/**
 * La classe Carte représente les Cartes dans le jeu
 * @author Tung NGO
 *
 */
public abstract class   Carte {
	
	protected String nom ; // nom de la Carte
	protected Integer idCarte; // Id de la Carte
	protected TypeCarte type; // Le type (Carte Croyants, Guide Spirituel, Deus Ex, Apocalypse) de la Carte
	protected Origine origine; // L'orgine (Jour, Nuit, Neant) de la Carte
	protected CapaciteSpeciale capaciteSpeciale; // La capacité spéciale de la Carte
	protected boolean estUtilisable;
	public abstract String afficherCarte();
	public boolean utilisee(){
		if (estUtilisable == true){
			return true;
		}
		else {
			return false;
		}
	}
	public int getIdCarte(){
		return idCarte;
	}
	
	public int getNbrCroyants(){	
		return 0;
	}
	public TypeCarte getType(){
		return type;
	}
	/**
	 * Voir si la carte est jouable ou pas
	 * @param joueur
	 */
	public void getUtilisable(Joueur joueur){
		switch(origine) {
		case None:
			estUtilisable = true;
			break;
		case Jour:
			if (joueur.getPtActionJour()<1){
				estUtilisable = false;
			}
			else {
				estUtilisable = true;
			}
			break;
		case Nuit:
			if (joueur.getPtActionNuit()<1){
				estUtilisable = false;
			}
			else {
				estUtilisable = true;
			}
			break;
		case Neant:
			if (joueur.getPtActionNeant()<1){
				if (joueur.getPtActionJour()<2) {
					if(joueur.getPtActionNuit()<2){
						estUtilisable = false;
					}
					else {
						estUtilisable = true;
					}
				}
				else {
					estUtilisable = true;
					}
					
				}
			else {
				estUtilisable = true;
			}
		
			break;
		}
	
}
	
public void calculerPtAction(Joueur joueur){
	if (estUtilisable = true){
		switch(origine) {
		case None:
			break;
		case Jour:
			joueur.setPtActionJour(joueur.getPtActionJour()-1);
			break;
		case Nuit:
			joueur.setPtActionNuit(joueur.getPtActionNuit()-1);
			break;
		case Neant:
			if (joueur.getPtActionNeant()<1){
				if (joueur.getPtActionJour()<2) {
					joueur.setPtActionNuit(joueur.getPtActionNuit()-2);
					}
				
				else {
					joueur.setPtActionJour(joueur.getPtActionJour()-2);
					}
					
				}
			else {
				joueur.setPtActionNeant(joueur.getPtActionNeant()-1);
			}
			break;
		}
	}
}
public abstract void activerFonctionCarte(Joueur joueur);
}

  enum TypeCarte {
	Croyant, GuideSpirituel, DeusEx, Apocalypse
}
 enum Origine {
	Jour, Nuit, Neant, None 
}
 enum CapaciteSpeciale {
	Cap_1, Cap_2, Cap_3, Cap_4, Cap_5, Cap_6, Cap_7, Cap_8, Cap_9, Cap_10,
	Cap_11, Cap_12, Cap_13, Cap_14, Cap_15, Cap_16, Cap_17, Cap_18, Cap_19, 
	Cap_20, Cap_21, Cap_22, Cap_23, Cap_24, Cap_25, Cap_26, Cap_27, Cap_28, 
	Cap_29, Cap_30, Cap_31, Cap_32, Cap_33, Cap_34, Cap_35, Cap_36, Cap_37,
	Cap_38, Cap_39, Cap_40, Cap_41, Cap_42
}