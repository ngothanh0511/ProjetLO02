package projet.cartes;

import java.util.Collections;
import java.util.Scanner;

import projet.joueur.Joueur;
import projet.joueur.Partie;

/**
 * La classe DeusEx représente les cartes Deus Ex dans le jeu
 * @author Tung NGO
 *
 */
public class DeusEx extends Carte {
	static Scanner scan = new Scanner(System.in);
	/**
	 * Constructeur par défaut d'une carte Deus Ex
	 * @param nom: nom de la carte
	 * @param idCarte : id de la carte
	 * @param type: type de la carte
	 * @param origine: origine de la carte
	 * @param capacitespeciale : capacité spéciale de la carte
	 */
	
	public DeusEx (String nom, Integer idCarte, String type, String origine, String familleCapacitespeciale){
		this.nom= nom;
		this.idCarte = idCarte;
		this.type = type;
		this.origine = origine;
		this.familleCapaciteSpeciale = familleCapacitespeciale;
	}
	
	public void activerFonctionCarte(Joueur joueur){
		if (familleCapaciteSpeciale == "F_4"){
			int a;
			System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
			a = scan.nextInt();
			for (int i=0; i< Partie.getListeJoueur().size();i++){
				if( a == Partie.getListeJoueur().get(i).getIdJoueur()){
					Collections.shuffle(Partie.getListeJoueur().get(i).getLaMain().getListeCartesMain());
					joueur.getLaMain().getListeCartesMain().add(Partie.getListeJoueur().get(i).getLaMain().getListeCartesMain().get(0));
					joueur.getLaMain().getListeCartesMain().add(Partie.getListeJoueur().get(i).getLaMain().getListeCartesMain().get(1));
					joueur.getLaMain().getListeCartesMain().add(Partie.getListeJoueur().get(i).getLaMain().getListeCartesMain().get(2));
					Partie.getListeJoueur().get(i).getLaMain().getListeCartesMain().remove(0);
					Partie.getListeJoueur().get(i).getLaMain().getListeCartesMain().remove(0);
					Partie.getListeJoueur().get(i).getLaMain().getListeCartesMain().remove(0);
				}
			}
		}
	}
	
	public String afficherCarte(){
		return ("c_"+idCarte+": "+"Carte "+type+" "+nom+" d'origine "+origine+", capacité "+familleCapaciteSpeciale);
	}	
	
	

}
