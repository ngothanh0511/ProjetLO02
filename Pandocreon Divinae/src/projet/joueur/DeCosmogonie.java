package projet.joueur;
import java.util.Random;
public class DeCosmogonie {
	
	private  face resFace;
	private  int faceAleatoire = new Random().nextInt(face.values().length); //Ã§a va nous donner la face du dÃ© alÃ©atoirement
	
	public enum face{//donne les valeurs aux joueurs 
		Jour,Nuit,Neant
	}
	

	public  String resultatLancement(){  // j'ai changé cette méthode à static afin de débugger un bug
		
		resFace=face.values()[faceAleatoire];//pour aggreger le nom du variable utilisÃ©
		//System.out.println( resFace);

		return resFace.name();
		
	}
	
	public void donnerPtAction(Joueur joueur){
		//System.out.println("Resultat du lancement: face " + resultatLancement());
		String resLance= resultatLancement();
		switch (resLance){
		case "Jour":
			if(joueur.getOriginDivin().equals("Jour")){
				
				int tot=joueur.getPtActionJour()+2;
				joueur.setPtActionJour(tot);
			}
			else if(joueur.getOriginDivin().equals("Aube")){
				int tot=joueur.getPtActionJour()+1;
				joueur.setPtActionJour(tot);
				
			}
			break;
		case "Nuit":
			if(joueur.getOriginDivin().equals("Nuit")){
				int tot=joueur.getPtActionNuit()+2;
				joueur.setPtActionNuit(tot);
			}
			else if(joueur.getOriginDivin().equals("Crepuscule")){
				int tot=joueur.getPtActionNuit()+1;
				joueur.setPtActionNuit(tot);
			}
			break;
		case "Neant":
			if(joueur.getOriginDivin().equals("Aube")||joueur.getOriginDivin().equals("Crepuscule")){
				int tot=joueur.getPtActionNeant()+1;
				joueur.setPtActionNeant(tot);
			}
			break;
		}
		
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			   
		/**if(resFace==face.JOUR){
			 jjj
		}
		
		if(resFace==face.NUIT){
			
		}
		
		if(resFace==face.NEANT){
			
		}**/

	}

}
