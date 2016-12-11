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
 * Cette classe repr�sente la strat�gie Agressif du joueur virtuel
 *
 */
public class Agressif implements Strategy{

	
	public String mode() {
		// TODO Auto-generated method stub
		return "Agressif";
	}

	@Override
	public int pose_carte(JoueurVirtuel joueur) {
		// TODO Auto-generated method stub
		int id = 0;
		int a=0;
		for(int i=0;i< joueur.getLaMain().getListeCartesMain().size();i++){	
			Carte c= joueur.getLaMain().getListeCartesMain().get(i);
			if(c.getType()=="Apocalypse"){//il va prendre le premier carte deusex trouvé dans la liste
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
			if(c.getType()=="DeusEx"){//il va prendre le premier carte deusex trouvé dans la liste
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
			if(c.getType()=="GuideSpirituel"){//il va prendre le premier carte deusex trouvé dans la liste
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
			if(c.getType()=="Croyant"){//il va prendre le premier carte deusex trouvé dans la liste
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
