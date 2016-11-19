package projet.joueur;

import java.util.ArrayList;

import projet.cartes.Carte;

public class Main {

	    	private int nbrCartes=0;
	    	private ArrayList <Carte> listeCartesMain = new ArrayList <Carte> ();
	    	private ArrayList<ArrayList<Carte>> listePaireGuideVsCroyants = new ArrayList<ArrayList<Carte>>();
	    	public int getNbrCartes(){
	    		return nbrCartes;
	    	}
	    	public ArrayList<Carte> getListeCartesMain(){
	    		return listeCartesMain;
	    	}
	    	public ArrayList<ArrayList<Carte>> getlistePaireGuideVsCroyants(){
	    		return listePaireGuideVsCroyants;
	    	}
	    }

