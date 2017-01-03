package projet.joueur;

import projet.vueGraphique.Principal;

/**
 * Cette classe repr�sente le d� de Cosmogonie
 * 
 *
 */
public class DeCosmogonie {
	
	private static String resFace;
	//private static int faceAleatoire = new Random().nextInt(face.values().length); //ça va nous donner la face du dé aléatoirement
	
	//public enum face{//donne les valeurs aux joueurs 
	//	Jour,Nuit,Neant
	//}
	protected  String [] face = {"Jour","Nuit","Neant"};
	/**
	 * Retourner la face du d� de Cosmogonie
	 * @return
	 */
	public String  getFace(){
		 return face[0];
		//return face.values()[faceAleatoire];
	}
	/**
	 * Informer le r�sultat du d� de Cosmogonie
	 */
	public void resultatLancement(){  // j'ai chang� cette m�thode � static afin de d�bugger un bug
		
		 resFace=face[0];//pour aggreger le nom du variable utilisé
		//System.out.println( resFace);
		System.out.println("Resultat du lancement: face " + resFace);
		Principal.getInstance().getDetail().setText(Principal.getInstance().getDetail().getText()+"\n Resultat du lancement: face " + resFace);
		//return resFace.name();
		
	}
	/**
	 * Donner les points d'Action � chaque joueur 
	 * @param resLance : le r�sultat du lancement de d� Cosmogonie
	 * @param joueur
	 */
	public void donnerPtAction(String resLance, Joueur joueur){
		
		switch (resLance){
		case "Jour":
			if(joueur.getOriginDivin()=="Jour"){
				
				int tot=joueur.getPtActionJour()+2;
				joueur.setPtActionJour(tot);
			}
			else if(joueur.getOriginDivin()=="Aube"){
				int tot=joueur.getPtActionJour()+1;
				joueur.setPtActionJour(tot);
				
			}
			break;
		case "Nuit":
			if(joueur.getOriginDivin()=="Nuit"){
				int tot=joueur.getPtActionNuit()+2;
				joueur.setPtActionNuit(tot);
			}
			else if(joueur.getOriginDivin()==("Crepuscule")){
				int tot=joueur.getPtActionNuit()+1;
				joueur.setPtActionNuit(tot);
			}
			break;
		case "Neant":
			if(joueur.getOriginDivin()=="Aube"||joueur.getOriginDivin()=="Crepuscule"){
				int tot=joueur.getPtActionNeant()+1;
				joueur.setPtActionNeant(tot);
			}
			break;
		}
		
	}
}
