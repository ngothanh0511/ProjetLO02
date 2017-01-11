/**
 * 
 */
package projet.strategy;

import java.util.ArrayList;

import projet.cartes.Carte;
import projet.cartes.StockCarte;
import projet.cartes.Tapis;
import projet.joueur.JoueurVirtuel;

/**
 * Cette classe représente la stratégie Agressif du joueur virtuel
 *
 */
public class Agressif implements Strategy{
	
	/**
	*Cette methode retourne le mode de joueur du joueur virtuel
	*/
	public String mode() {
		// TODO Auto-generated method stub
		return "Agressif";
	}
	
	/*
	* Cette methode va retourner l'id de la carte joué par joueur virtuel
	* L'id de la carte est choisi en basant sur le type de carte existe dans la main
	*@param joueur
	*/
	@Override
	public int pose_carte(JoueurVirtuel joueur) {
		// TODO Auto-generated method stub
		int id = 0;
		int a=0;
		for(int i=0;i< joueur.getLaMain().getListeCartesMain().size();i++){	
			Carte c= joueur.getLaMain().getListeCartesMain().get(i);
			if(c.getType()=="Apocalypse"){
				c.getUtilisable(joueur);
				if (c.utilisee()==true){
						id= c.getIdCarte();
						a+=1;
						break;
					}
			}
		}
		if(a==0){
		for(int i=0;i< joueur.getLaMain().getListeCartesMain().size();i++){	
			Carte c= joueur.getLaMain().getListeCartesMain().get(i);
			if(c.getType()=="DeusEx"){
				c.getUtilisable(joueur);
				if (c.utilisee()==true){
						id= c.getIdCarte();
						a+=1;
						break;
					}
			}	
		}
		if(a==0){
		for(int i=0;i< joueur.getLaMain().getListeCartesMain().size();i++){	
			Carte c= joueur.getLaMain().getListeCartesMain().get(i);
			if(c.getType()=="GuideSpirituel"){
				c.getUtilisable(joueur);
				if (c.utilisee()==true){
						id= c.getIdCarte();
						a+=1;
						break;
					}
			}
		}
		
		if(a==0){
		for(int i=0;i< joueur.getLaMain().getListeCartesMain().size();i++){	
			Carte c= joueur.getLaMain().getListeCartesMain().get(i);
			if(c.getType()=="Croyant"){//il va prendre le premier carte deusex trouvÃ© dans la liste
				c.getUtilisable(joueur);
				if (c.utilisee()==true){
						id= c.getIdCarte();
						break;
					}
			}
		}	
		}
		return id;
		}
		else{ return id;}
		}
		else{return id;}
		
	}	
	
}
