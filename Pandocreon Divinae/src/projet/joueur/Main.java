package projet.joueur;

import java.util.ArrayList;

import projet.cartes.Carte;
/**
 * Cette classe représente la main du joueur
 *
 *
 */
public class Main {

	    	private int nbrCartes=0;
	    	private ArrayList <Carte> listeCartesMain = new ArrayList <Carte> ();
	    	private ArrayList<ArrayList<Carte>> listePaireGuideVsCroyants = new ArrayList<ArrayList<Carte>>();
	    	/**
	    	 * setter de l'attribute nbrCartes
	    	 */
	    	public void setNbrCartes(){
	    		nbrCartes = listeCartesMain.size();
	    	}
	    	/**
	    	 * Getter de l'attribute nbrCartes
	    	 * @return
	    	 */
	    	public int getNbrCartes(){
	    		return nbrCartes;
	    	}
	    	/**
	    	 * Getter de l'attribute listeCartesMain
	    	 * @return
	    	 */
	    	public ArrayList<Carte> getListeCartesMain(){
	    		return listeCartesMain;
	    	}
	    	/**
	    	 * Getter de l'attribute listePaireGuideVsCroyants
	    	 * @return
	    	 */
	    	public ArrayList<ArrayList<Carte>> getlistePaireGuideVsCroyants(){
	    		return listePaireGuideVsCroyants;
	    	}
	    }

