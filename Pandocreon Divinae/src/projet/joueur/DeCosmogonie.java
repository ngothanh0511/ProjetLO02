package projet.joueur;
import java.util.Random;
public class DeCosmogonie {
	
	private static face resFace;
	private static int faceAleatoire = new Random().nextInt(face.values().length); //Ã§a va nous donner la face du dÃ© alÃ©atoirement
	
	public enum face{//donne les valeurs aux joueurs 
		Jour,Nuit,Neant
	}
	

	public static String resultatLancement(){  // j'ai changé cette méthode à static afin de débugger un bug
		
		resFace=face.values()[faceAleatoire];//pour aggreger le nom du variable utilisÃ©
		//System.out.println( resFace);
		return resFace.name();
		
	}
	
	public void donnePtActionJour(){
		
		
	}
	
	public void donnePtActionNuit(){
		
	}

	public void donnePtActionNeant(){
	
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
