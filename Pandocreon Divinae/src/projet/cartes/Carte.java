package projet.cartes;


import java.util.Arrays;
import projet.joueur.Joueur;
import projet.joueur.Partie;

/**
 * La classe Carte représente les Cartes dans le jeu
 * 
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
	protected boolean estFonctionnable = true;
	protected boolean estChoisi = false;
	
	public void setEstChoisi(boolean value){
		estChoisi = value;
	}
	public boolean getEstChoisi(){
		return estChoisi;
	}
	/**
	 * Méthode abstract qui affiche les attributes de la carte d'Action
	 *
	 */
	public abstract String afficherCarte();
	/**
	 * Setter de l'attribute estUtilisable
	 *
	 */
	public void setUtilisable(boolean value){
		estUtilisable = value;
	}
	/**
	 * Setter de l'attribute estFonctionnable
	 *
	 */
	public void setFonctionnable(boolean value){
		estFonctionnable=value;
	}
	/**
	 * Méthode permet de savoir si la carte est utilisée ou pas
	 *
	 */
	public boolean utilisee(){
		if (estUtilisable == true){
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Setter de l'attribute estAnnule
	 *
	 */
	public void setAnnule(boolean value){
		 estAnnule = value;
	}
	/**
	 * Getter de l'attribute estAnnule
	 *
	 */
	public boolean getAnnule(){
		return estAnnule;
	}
	/**
	 * Getter de l'attribute nom
	 *
	 */
	public String getNom(){
		return nom;
	}
	/**
	 * Getter de l'attribute idCarte
	 *
	 */
	public int getIdCarte(){
		return idCarte;
	}
	/**
	 * Getter de l'attribute estSarifiable
	 *
	 */
	public boolean getSacrifiable(){
		return estSacrifiable;
	}
	/**
	 * Setter de l'attribute estSacrifiable
	 *
	 */
	public void setSacrifiable(boolean values){
		estSacrifiable = values;
	}

	
//	public int getNbrCroyants(){	
//		return 0;
//	}
	/**
	 * Getter de l'attribute type
	 *
	 */
	public String getType(){
		return type;
	}
	/**
	 * Getter de l'attribute origine
	 *
	 */
	public String getOrigine(){
		return origine;
	}
	/**
	 * Getter de l'attribute familleCapaciteSpeciale
	 *
	 */
	public String getFamilleCapaciteSpeciale(){
		return familleCapaciteSpeciale;
	}
	/**
	 * Voir si la carte est jouable ou pas
	 * @param joueur
	 */
	public void getUtilisable(Joueur joueur){
	if(estFonctionnable==false){
		estUtilisable = false;
	}
	else{
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
		if(joueur.getTypeJoueur()=="Joueur Virtuel"){
			switch(type){
			case "GuideSpirituel":
				if(estUtilisable==true){
					if(Tapis.getListeCartesCroyants().isEmpty()==true){
						estUtilisable=false;
					}
					else{
						int a=0;
						for(int i=0;i<Tapis.getListeCartesCroyants().size();i++){
							if((Arrays.asList(Tapis.getListeCartesCroyants().get(i).dogmes).contains((((GuideSpirituel)this).getDogmes())[0]))
									||Arrays.asList(Tapis.getListeCartesCroyants().get(i).dogmes).contains((((GuideSpirituel)this).getDogmes())[1])){
								a+=1;
							}
						}
						if(a==0){
							estUtilisable=false;
						}
					}
				}
				break;
			case "Apocalypse":
				Partie.setRangJoueur();
				int rang = Partie.getRangJoueur().indexOf(this);
				if (Partie.getRangJoueur().size() > 3) {
					if(rang==Partie.getRangJoueur().size()-1){
						estUtilisable=false;
					}
					else{
						if(Partie.getEliminant()==null){
							estUtilisable=false;
						}
					}
					
			}
				else if(Partie.getInstance().getListeJoueur().size() < 4){
					if(rang!=0){
						estUtilisable=false;
				}
					else{
						if(Partie.getGagnant()==null){
							estUtilisable=false;
						}
					}
					
				}
			break;
			}
		}
	}
}
	/**
	 * La méthode qui calcule les points d'Action du joueur 
	 * @param joueur
	 */
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
/**
 * La méthode abstract qui active la fonctionne de la carte d'Action quand elle est utilisée
 * @param joueur
 * @param s
 */
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