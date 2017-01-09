package projet.cartes;

import java.util.ArrayList;

import javax.swing.JOptionPane;
/**
 * La classe Tapis repr�sente le tapis du jeu
 * 
 *
 */
public class Tapis {
	/**
	 * La liste des cartes Croyants d�pos�es au centre du tapis
	 */
	private static ArrayList <CarteCroyants> ListeCartesCroyants = new ArrayList <CarteCroyants> ();
	private static ArrayList <CarteCroyants> ListeCartesCroyantsIndisponible = new ArrayList <CarteCroyants> (); 
	/**
	 * Le tapis re�oit la carte Croyant quand elle est utilis�e
	 * @param c
	 */
	public static void recevoirCartes(CarteCroyants c){
		ListeCartesCroyantsIndisponible.add(c);
		
	}
	/**
	 * Getter de l'attribute ListeCartesCroyants
	 * @return
	 */
	public static ArrayList <CarteCroyants> getListeCartesCroyants(){
		return ListeCartesCroyants;
	}
	
//	public static int getCartesCroyantes(){
//		return ListeCartesCroyantsIndisponible.size();
//	}
	/**
	 * Getter de l'attribute ListeCartesCroyantsIndisponible
	 * @return
	 */
	public static ArrayList <CarteCroyants> getListeCartesCroyantsIndisponible(){
		return ListeCartesCroyantsIndisponible;
	}

}
