package projet.joueur;

import projet.vueGraphique.Principal;

/**
 * Cette classe représente le dé de Cosmogonie
 * 
 *
 */
public class DeCosmogonie {
	
	private static String resFace;
	//private static int faceAleatoire = new Random().nextInt(face.values().length); //Ã§a va nous donner la face du dÃ© alÃ©atoirement
	
	//public enum face{//donne les valeurs aux joueurs 
	//	Jour,Nuit,Neant
	//}
	protected  String [] face = {"Jour","Nuit","Neant"};
	/**
	 * Retourner la face du dé de Cosmogonie
	 * @return
	 */
	public String  getFace(){
		 return face[0];
		//return face.values()[faceAleatoire];
	}
	/**
	 * Informer le résultat du dé de Cosmogonie
	 */
	public void resultatLancement(){  // j'ai changé cette méthode à static afin de débugger un bug
		
		 resFace=face[0];//pour aggreger le nom du variable utilisÃ©
		//System.out.println( resFace);
		System.out.println("Resultat du lancement: face " + resFace);
		Principal.getInstance().getDetail().setText(Principal.getInstance().getDetail().getText()+"\n Resultat du lancement: face " + resFace);
		//return resFace.name();
		
	}
	/**
	 * Donner les points d'Action à chaque joueur 
	 * @param resLance : le résultat du lancement de dé Cosmogonie
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
