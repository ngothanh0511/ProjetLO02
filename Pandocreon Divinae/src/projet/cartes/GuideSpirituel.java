package projet.cartes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import projet.joueur.Joueur;


/**
 * La classe GuideSpirituel représente les cartes Guide Spirituel dans le jeu
 * @author Tung NGO
 *
 */
public class GuideSpirituel extends Carte {
	static Scanner scan = new Scanner(System.in);
	private Integer nbrCartesCroyantsRattaches; // le nombre de cartes Croyants qu'elle rattache en ce moment
	private String [] dogmes= new String[2];
	private Integer nbrCartesCroyants;
	/**
	 * Constructeur par défaut d'une carte Guide Spirituel
	 * @param nom: nom de la carte
	 * @param idCarte: id de la carte
	 * @param type : type de la carte
	 * @param origine : origine de la carte
	 * @param dogmes : dogmes de la carte
	 * @param nbrCartesCroyants : nombre maximal de cartes Croyants que la carte Guide Spirituel peut rattacher
	 * @param capaciteSpeciale : capacité spéciale de la carte
	 */
	public GuideSpirituel (String nom, Integer idCarte, TypeCarte type, Origine origine, String [] dogmes, Integer nbrCartesCroyants, CapaciteSpeciale capaciteSpeciale ){
		this.nom = nom;
		this.idCarte = idCarte;
		this.type = TypeCarte.GuideSpirituel;
		this.origine = origine;
		this.dogmes = dogmes;
		this.nbrCartesCroyants = nbrCartesCroyants;
		this.capaciteSpeciale = capaciteSpeciale;
	}
	public void activerFonctionCarte(Joueur joueur){
		ArrayList<Carte> PairGuideVsCroyants = new ArrayList<Carte>();
		PairGuideVsCroyants.add(this);
		
		for (int k = 1;k<nbrCartesCroyants;k++){
			System.out.println("Choisir la carte Croyant que vous voulez récupérer!"
					+ " Si vous ne voulez pas rattacher une autre carte Croyants, tapez 0!");
			int i;
			i = scan.nextInt();
			if (i==0){
				estUtilisable = false;
			}
			else{
				for (int j =0; j< Tapis.ListeCartesCroyants.size(); j++){
					if (i== Tapis.ListeCartesCroyants.get(j).getIdCarte()){ 
						if ((Arrays.asList(Tapis.ListeCartesCroyants.get(j).dogmes).contains(this.dogmes[0]))
								|| (Arrays.asList(Tapis.ListeCartesCroyants.get(j).dogmes).contains(this.dogmes[1]))){
							PairGuideVsCroyants.add(Tapis.ListeCartesCroyants.get(j));
							Tapis.ListeCartesCroyants.remove(j);
							joueur.getLaMain().getlistePaireGuideVsCroyants().add(PairGuideVsCroyants);
							
						}
					
					else {
						System.out.println("Votre carte Guide Spirituel ne peut pas rattacher cette carte Croyants! "
							+ "Choisir la carte Croyants qui possède au moins un dogme en commun avec votre carte Guide Spirituel");
					}
				}
				}
			}
		}
	}
	
	
	public String afficherCarte(){
		return ("c_"+idCarte+" :"+"Carte "+type+" "+nom+" d'origine "+origine+", dogmes:"+dogmes[0]+","+
				dogmes[1]+", capacité"+capaciteSpeciale+" et peut rattacher "+nbrCartesCroyants+" cartes Croyants");
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
