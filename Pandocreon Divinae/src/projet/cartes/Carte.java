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
	protected String type; // Le type (Carte Croyants, Guide Spirituel, Deus Ex, Apocalypse) de la Carte
	protected String origine; // L'orgine (Jour, Nuit, Neant) de la Carte
	protected String familleCapaciteSpeciale; // La capacité spéciale de la Carte
	protected boolean estUtilisable;
	protected boolean estSacrifiable;
	protected boolean estAnnule= false;
	public abstract String afficherCarte();
	public boolean utilisee(){
		if (estUtilisable == true){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setAnnule(boolean value){
		 estAnnule = value;
	}
	
	public boolean getAnnule(){
		return estAnnule;
	}
	public String getNom(){
		return nom;
	}
	public int getIdCarte(){
		return idCarte;
	}
	
	public boolean getSacrifiable(){
		return estSacrifiable;
	}
	
	public void setSacrifiable(boolean values){
		estSacrifiable = values;
	}
	
	public int getNbrCroyants(){	
		return 0;
	}
	public String getType(){
		return type;
	}
	
	public String getOrigine(){
		return origine;
	}
	
	public String getFamilleCapaciteSpeciale(){
		return familleCapaciteSpeciale;
	}
	/**
	 * Voir si la carte est jouable ou pas
	 * @param joueur
	 */
	public void getUtilisable(Joueur joueur){
		switch(origine) {
		case "None":
			estUtilisable = true;
			break;
		case "Jour":
			if (joueur.getPtActionJour()<1){
				estUtilisable = false;
			}
			else {
				estUtilisable = true;
			}
			break;
		case "Nuit":
			if (joueur.getPtActionNuit()<1){
				estUtilisable = false;
			}
			else {
				estUtilisable = true;
			}
			break;
		case "Neant":
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
		case "None":
			break;
		case "Jour":
			joueur.setPtActionJour(joueur.getPtActionJour()-1);
			break;
		case "Nuit":
			joueur.setPtActionNuit(joueur.getPtActionNuit()-1);
			break;
		case "Neant":
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
public abstract void activerFonctionCarte(Joueur joueur, StockCarte s);

}
  enum TypeCarte {
	Croyant, GuideSpirituel, DeusEx, Apocalypse
}
 enum Origine {
	Jour, Nuit, Neant, None 
}
 enum FamilleCapaciteSpeciale {
	F_1, F_2, F_3, F_4, F_5, F_6, F_7, F_8, F_9, F_10,
	F_11, F_12, F_13, F_14, F_15, F_16, F_17, F_18, F_19, 
	F_20, F_21, F_22, F_23, F_24, F_25, F_26, F_27, F_28, F_29
}