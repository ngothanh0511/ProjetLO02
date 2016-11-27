/**
 * 
 */
package projet.strategy;

import projet.cartes.Carte;
import projet.cartes.StockCarte;
import projet.joueur.JoueurVirtuel;
import projet.joueur.Partie;

/**
 * @author sweet
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
		for(int i=0;i< joueur.getLaMain().getListeCartesMain().size();i++){	
			Carte c= joueur.getLaMain().getListeCartesMain().get(i);
			if(c.getType()=="DeusEx"){//il va prendre le premier carte deusex trouvé dans la liste
				if(c.getOrigine()=="Jour"){
					if(joueur.getPtActionJour()>0){
						//joueur.setPtActionJour(joueur.getPtActionJour()-1);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					
				}
				if(c.getOrigine().equals("Nuit")){
					if(joueur.getPtActionNuit()>0){
						//joueur.setPtActionNuit(joueur.getPtActionNuit()-1);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					
				}
				if(c.getOrigine().equals("Neant")){
					if(joueur.getPtActionNeant()>0){
						//joueur.setPtActionNeant(joueur.getPtActionNeant()-1);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					if(joueur.getPtActionJour()>1){
						//joueur.setPtActionJour(joueur.getPtActionJour()-2);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					if(joueur.getPtActionNuit()>1){
						//joueur.setPtActionNuit(joueur.getPtActionNuit()-2);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					
					
				}
			}
			if(c.getType()=="Croyants"){//il va prendre le premier carte deusex trouvé dans la liste
				if(c.getOrigine()=="Jour"){
					if(joueur.getPtActionJour()>0){
						//joueur.setPtActionJour(joueur.getPtActionJour()-1);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					
				}
				if(c.getOrigine().equals("Nuit")){
					if(joueur.getPtActionNuit()>0){
						//joueur.setPtActionNuit(joueur.getPtActionNuit()-1);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					
				}
				if(c.getOrigine().equals("Neant")){
					if(joueur.getPtActionNeant()>0){
						//joueur.setPtActionNeant(joueur.getPtActionNeant()-1);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					if(joueur.getPtActionJour()>1){
						//joueur.setPtActionJour(joueur.getPtActionJour()-2);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					if(joueur.getPtActionNuit()>1){
						//joueur.setPtActionNuit(joueur.getPtActionNuit()-2);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					
					
				}
			}
			if(c.getType()=="DeusEx"){//il va prendre le premier carte deusex trouvé dans la liste
				if(c.getOrigine()=="Jour"){
					if(joueur.getPtActionJour()>0){
						//joueur.setPtActionJour(joueur.getPtActionJour()-1);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					
				}
				if(c.getOrigine().equals("Nuit")){
					if(joueur.getPtActionNuit()>0){
						//joueur.setPtActionNuit(joueur.getPtActionNuit()-1);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					
				}
				if(c.getOrigine().equals("Neant")){
					if(joueur.getPtActionNeant()>0){
						//joueur.setPtActionNeant(joueur.getPtActionNeant()-1);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					if(joueur.getPtActionJour()>1){
						//joueur.setPtActionJour(joueur.getPtActionJour()-2);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					if(joueur.getPtActionNuit()>1){
						//joueur.setPtActionNuit(joueur.getPtActionNuit()-2);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					
					
				}
				else{
					id= c.getIdCarte();
				}
			}
			else{//il va prendre le premier carte deusex trouvé dans la liste
				if(c.getOrigine()=="Jour"){
					if(joueur.getPtActionJour()>0){
						//joueur.setPtActionJour(joueur.getPtActionJour()-1);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					
				}
				if(c.getOrigine().equals("Nuit")){
					if(joueur.getPtActionNuit()>0){
						//joueur.setPtActionNuit(joueur.getPtActionNuit()-1);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					
				}
				if(c.getOrigine().equals("Neant")){
					if(joueur.getPtActionNeant()>0){
						//joueur.setPtActionNeant(joueur.getPtActionNeant()-1);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					if(joueur.getPtActionJour()>1){
						//joueur.setPtActionJour(joueur.getPtActionJour()-2);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					if(joueur.getPtActionNuit()>1){
						//joueur.setPtActionNuit(joueur.getPtActionNuit()-2);
						id= c.getIdCarte();
						//joueur.getLaMain().getListeCartesMain().remove(i);
					}
					
					
				}
				else{
					id= c.getIdCarte();
				}
			}

		}
		return id;
		
		
	}

}
