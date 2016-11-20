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
	private Integer nbrCartesCroyantsRattaches =0; // le nombre de cartes Croyants qu'elle rattache en ce moment
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
		System.out.println("Les cartes Croyants disponible à récupérer sont:");
		for (int i=0; i< Tapis.getListeCartesCroyants().size();i++){
			System.out.println(Tapis.getListeCartesCroyants().get(i).afficherCarte());
		}
		for (int k = 1;k<nbrCartesCroyants;k++){
			System.out.println("Choisir la carte Croyant que vous voulez récupérer!"
					+ " Si vous ne voulez pas rattacher une autre carte Croyants, tapez 0!");
			int i;
			i = scan.nextInt();
			if (i==0){
				break;
			}
			else{
				for (int j =0; j< Tapis.getListeCartesCroyants().size(); j++){
					if (i== Tapis.getListeCartesCroyants().get(j).getIdCarte()){ 
						if ((Arrays.asList(Tapis.getListeCartesCroyants().get(j).dogmes).contains(this.dogmes[0]))
								|| (Arrays.asList(Tapis.getListeCartesCroyants().get(j).dogmes).contains(this.dogmes[1]))){
							PairGuideVsCroyants.add(Tapis.getListeCartesCroyants().get(j));
							System.out.println("Vous venez de rattacher la carte Croyants c_"
									+ Tapis.getListeCartesCroyants().get(j).getIdCarte());
							Tapis.getListeCartesCroyants().remove(j);
							joueur.getLaMain().getlistePaireGuideVsCroyants().add(PairGuideVsCroyants);
							nbrCartesCroyantsRattaches +=1;
							joueur.calculerPtPrieres();
							System.out.println("Vous avez " + joueur.getPtPriere() +" points Prières");
							
						}
					
					else {
						System.out.println("Votre carte Guide Spirituel ne peut pas rattacher cette carte Croyants! "
							+ "Choisir la carte Croyants qui possède au moins un dogme en commun avec votre carte Guide Spirituel");
					}
				}
				}
			}
		}
		if (nbrCartesCroyantsRattaches == 0){
			estUtilisable = false;
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
