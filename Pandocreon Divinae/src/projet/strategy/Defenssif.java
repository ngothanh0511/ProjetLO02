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
 * Cette classe représente la stratégie Défenssif du joueur virtuel
 *
 */
public class Defenssif implements Strategy{
	/*
	* Cette methode va retourner le mode de jouer du joueur virtuel
	*/
	@Override
	public String mode() {
		// TODO Auto-generated method stub
		return "Defenssif";
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
			if(c.getType()=="Apocalypse"){//il va prendre le premier carte deusex trouvÃ© dans la liste
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
			if(c.getType()=="GuideSpirituel"){//il va prendre le premier carte deusex trouvÃ© dans la liste
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
						a+=1;
						break;
					}
			}
		}
		
		if(a==0){
		for(int i=0;i< joueur.getLaMain().getListeCartesMain().size();i++){	
			Carte c= joueur.getLaMain().getListeCartesMain().get(i);
			if(c.getType()=="DeusEx"){//il va prendre le premier carte deusex trouvÃ© dans la liste
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
