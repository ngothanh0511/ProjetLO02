package projet.joueur;
import java.util.Random;
public class DeCosmogonie {
	
	static face resFace;
	static int faceAleatoire = new Random().nextInt(face.values().length); //ça va nous donner la face du dé aléatoirement
	
	public enum face{//donne les valeurs aux joueurs 
		JOUR,NUIT,NEANT
	}

	public static void resultatLancement(){
		
		resFace=face.values()[faceAleatoire];//pour aggreger le nom du variable utilisé
		System.out.println( resFace);
		
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
