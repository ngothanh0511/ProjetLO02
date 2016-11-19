package projet.cartes;

import java.util.ArrayList;
/**
 * La classe Tapis représent le tapis du jeu
 * @author Tung NGO
 *
 */
public class Tapis {
	/**
	 * La liste des cartes Croyants déposés au centre du tapis
	 */
	protected static ArrayList <CarteCroyants> ListeCartesCroyants = new ArrayList <CarteCroyants> ();
	public static void recevoirCartes(CarteCroyants c){
		ListeCartesCroyants.add(c);
		System.out.println("Les cartes Croyants en commun au centre de la table sont:");
		for (int i=0; i< ListeCartesCroyants.size();i++){
			System.out.println(ListeCartesCroyants.get(i).afficherCarte());
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tapis t = new Tapis();
		
	}

}
