/**
 * 
 */
package projet.strategy;

import projet.cartes.Carte;
import projet.cartes.Tapis;
import projet.joueur.JoueurVirtuel;

/**
 * @author sweet
 *
 */
public class Defenssif implements Strategy{

	@Override
	public String mode() {
		// TODO Auto-generated method stub
		return "Defenssif";
	}

	@Override
	public int pose_carte(JoueurVirtuel joueur) {
		// TODO Auto-generated method stub
		int id = 0;
		if(Tapis.getCartesCroyantes()>0){
		for(int i=0;i< joueur.getLaMain().getListeCartesMain().size();i++){	
			Carte c= joueur.getLaMain().getListeCartesMain().get(i);
			if(c.getType()=="GuideSpirituel"){//il va prendre le premier carte deusex trouvé dans la liste
				if(c.getOrigine()=="Jour"){
					if(joueur.getPtActionJour()>0){
						id= c.getIdCarte();
					}
					
				}
				if(c.getOrigine().equals("Nuit")){
					if(joueur.getPtActionNuit()>0){
						id= c.getIdCarte();
					}
					
				}
				if(c.getOrigine().equals("Neant")){
					if(joueur.getPtActionNeant()>0){
						id= c.getIdCarte();
					}
					if(joueur.getPtActionJour()>1){
						id= c.getIdCarte();
					}
					if(joueur.getPtActionNuit()>1){
						id= c.getIdCarte();
					}
					
					
				}
			}
			}
		}
		else{
			for(int i=0;i< joueur.getLaMain().getListeCartesMain().size();i++){	
				Carte c= joueur.getLaMain().getListeCartesMain().get(i);
				if(c.getType()=="Croyants"){//il va prendre le premier carte deusex trouvé dans la liste
					if(c.getOrigine()=="Jour"){
						if(joueur.getPtActionJour()>0){
							id= c.getIdCarte();
						}
						
					}
					if(c.getOrigine().equals("Nuit")){
						if(joueur.getPtActionNuit()>0){
							id= c.getIdCarte();
						}
						
					}
					if(c.getOrigine().equals("Neant")){
						if(joueur.getPtActionNeant()>0){
							id= c.getIdCarte();
						}
						if(joueur.getPtActionJour()>1){
							id= c.getIdCarte();
						}
						if(joueur.getPtActionNuit()>1){
							id= c.getIdCarte();
						}
						
						
					}
				}
				if(c.getType()=="DeusEx"){//il va prendre le premier carte deusex trouvé dans la liste
					if(c.getOrigine()=="Jour"){
						if(joueur.getPtActionJour()>0){
							id= c.getIdCarte();
						}
						
					}
					if(c.getOrigine().equals("Nuit")){
						if(joueur.getPtActionNuit()>0){
							id= c.getIdCarte();
						}
						
					}
					if(c.getOrigine().equals("Neant")){
						if(joueur.getPtActionNeant()>0){
							id= c.getIdCarte();
						}
						if(joueur.getPtActionJour()>1){
							id= c.getIdCarte();
						}
						if(joueur.getPtActionNuit()>1){
							id= c.getIdCarte();
						}
						
						
					}
					if(c.getOrigine().equals("None")){
						id=c.getIdCarte();
					}
				}
				else{
					id=c.getIdCarte();
				}
				break;
				}
		}
		return id;
		
	}



}
