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
						break;
					}
					
				}
				if(c.getOrigine().equals("Nuit")){
					if(joueur.getPtActionNuit()>0){
						id= c.getIdCarte();
						break;
					}
					
				}
				if(c.getOrigine().equals("Neant")){
					if(joueur.getPtActionNeant()>0){
						id= c.getIdCarte();
						break;
					}
					if(joueur.getPtActionJour()>1){
						id= c.getIdCarte();
						break;
					}
					if(joueur.getPtActionNuit()>1){
						id= c.getIdCarte();
						break;
					}
					
					
				}
			}
			}
		}
		else{
			for(int i=0;i< joueur.getLaMain().getListeCartesMain().size();i++){	
				Carte c= joueur.getLaMain().getListeCartesMain().get(i);
				if(c.getType()=="Croyant"){//il va prendre le premier carte deusex trouvé dans la liste
					if(c.getOrigine()=="Jour"){
						if(joueur.getPtActionJour()>0){
							id= c.getIdCarte();
							break;
						}
						
					}
					if(c.getOrigine().equals("Nuit")){
						if(joueur.getPtActionNuit()>0){
							id= c.getIdCarte();
							break;
						}
						
					}
					if(c.getOrigine().equals("Neant")){
						if(joueur.getPtActionNeant()>0){
							id= c.getIdCarte();
							break;
						}
						if(joueur.getPtActionJour()>1){
							id= c.getIdCarte();
							break;
						}
						if(joueur.getPtActionNuit()>1){
							id= c.getIdCarte();
							break;
						}
						
						
					}
					//break;
				}
				if(c.getType()=="DeusEx"){//il va prendre le premier carte deusex trouvé dans la liste
					if(c.getOrigine()=="Jour"){
						if(joueur.getPtActionJour()>0){
							id= c.getIdCarte();
							break;
						}
						
					}
					if(c.getOrigine().equals("Nuit")){
						if(joueur.getPtActionNuit()>0){
							id= c.getIdCarte();
							break;
						}
						
					}
					if(c.getOrigine().equals("Neant")){
						if(joueur.getPtActionNeant()>0){
							id= c.getIdCarte();
							break;
						}
						if(joueur.getPtActionJour()>1){
							id= c.getIdCarte();
							break;
						}
						if(joueur.getPtActionNuit()>1){
							id= c.getIdCarte();
							break;
						}
						
						
					}
					if(c.getOrigine().equals("None")){
						id=c.getIdCarte();
						break;
					}
					
				}
				
				if(c.getType()=="Apocalypse"){//il va prendre le premier carte deusex trouvé dans la liste
					if(c.getOrigine()=="Jour"){
						if(joueur.getPtActionJour()>0){
							id= c.getIdCarte();
							break;
						}
						
					}
					if(c.getOrigine().equals("Nuit")){
						if(joueur.getPtActionNuit()>0){
							id= c.getIdCarte();
							break;
						}
						
					}
					if(c.getOrigine().equals("Neant")){
						if(joueur.getPtActionNeant()>0){
							id= c.getIdCarte();
							break;
						}
						if(joueur.getPtActionJour()>1){
							id= c.getIdCarte();
							break;
						}
						if(joueur.getPtActionNuit()>1){
							id= c.getIdCarte();
							break;
						}
						
						
					}
				}
				
				}
		}
		return id;
		
	}

	@Override
	public void defausser_carte(JoueurVirtuel joueur, StockCarte s) {
		// TODO Auto-generated method stub
ArrayList <Integer> liste_carte_def = new ArrayList <Integer>();
		
		for(int i=0;i< joueur.getLaMain().getListeCartesMain().size();i++){	
			String c= joueur.getLaMain().getListeCartesMain().get(i).getOrigine();
			 
			if(joueur.getOriginDivin()=="Aube" || joueur.getOriginDivin()=="Jour"){
				if(c=="Nuit" || c=="Crepuscule"){ // je mets Neant ici cgetLaMain().getListeCartesMain().get(i)ar origin aube peut avoir les point d'action Neant
					//joueur.defausserCarte(joueur.getLaMain().getListeCartesMain().get(i), s);//c!="Aube" || c!="Jour" || c!="None" || c!="Neant"
					liste_carte_def.add(joueur.getLaMain().getListeCartesMain().get(i).getIdCarte());
				}
				
			}
			
			if(joueur.getOriginDivin()=="Nuit" || joueur.getOriginDivin()=="Crepuscule"){
				if(c=="Jour" || c=="Aube"){//c'est la meme cas
					//joueur.defausserCarte(joueur.getLaMain().getListeCartesMain().get(i), s);
					liste_carte_def.add(joueur.getLaMain().getListeCartesMain().get(i).getIdCarte());
				}
				
			}
			
		}
		for(int j=0;j<liste_carte_def.size();j++){
			for(int i=0;i< joueur.getLaMain().getListeCartesMain().size();i++){
				if(joueur.getLaMain().getListeCartesMain().get(i).getIdCarte()==liste_carte_def.get(j)){
					joueur.defausserCarte(joueur.getLaMain().getListeCartesMain().get(i), s);
				}
			}
		}
	}



}
