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
	private static ArrayList <CarteCroyants> ListeCartesCroyants = new ArrayList <CarteCroyants> ();
	private static ArrayList <CarteCroyants> ListeCartesCroyantsIndisponible = new ArrayList <CarteCroyants> (); 
	public static void recevoirCartes(CarteCroyants c){
		ListeCartesCroyantsIndisponible.add(c);
		System.out.println("La carte c_ "+ c.getIdCarte() +" est bien ajout� au centre de la table!");
	}
	public static ArrayList <CarteCroyants> getListeCartesCroyants(){
		return ListeCartesCroyants;
	}
	public static int getCartesCroyantes(){
		return ListeCartesCroyantsIndisponible.size();
	}
	
	public static ArrayList <CarteCroyants> getListeCartesCroyantsIndisponible(){
		return ListeCartesCroyantsIndisponible;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
