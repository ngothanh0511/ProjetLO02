package projet.joueur;
import java.util.Random;
public class DeCosmogonie {
	
	private static face resFace;
	private static int faceAleatoire = new Random().nextInt(face.values().length); //ça va nous donner la face du dé aléatoirement
	
	public enum face{//donne les valeurs aux joueurs 
		Jour,Nuit,Neant
	}
	

	public static String resultatLancement(){  // j'ai chang� cette m�thode � static afin de d�bugger un bug
		
		resFace=face.values()[faceAleatoire];//pour aggreger le nom du variable utilisé
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
