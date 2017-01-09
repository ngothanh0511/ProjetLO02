package projet.cartes;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

import projet.joueur.Joueur;
import projet.joueur.Partie;
import projet.vueGraphique.Principal;


/**
 * La classe GuideSpirituel repr�sente les cartes Guide Spirituel dans le jeu
 * 
 *
 */
public class GuideSpirituel extends Carte {
	static Scanner scan = new Scanner(System.in);
	private Integer nbrCartesCroyantsRattaches =0; // le nombre de cartes Croyants qu'elle rattache en ce moment
	private String [] dogmes= new String[2];
	private Integer nbrCartesCroyants;
	
	/**
	 * Constructeur par d�faut d'une carte Guide Spirituel
	 * @param nom: nom de la carte
	 * @param idCarte: id de la carte
	 * @param type : type de la carte
	 * @param origine : origine de la carte
	 * @param dogmes : dogmes de la carte
	 * @param nbrCartesCroyants : nombre maximal de cartes Croyants que la carte Guide Spirituel peut rattacher
	 * @param capaciteSpeciale : capacit� sp�ciale de la carte
	 */
	public GuideSpirituel (String nom, Integer idCarte, String type, String origine, String [] dogmes, Integer nbrCartesCroyants, String familleCapaciteSpeciale ){
		this.nom = nom;
		this.idCarte = idCarte;
		this.type = "GuideSpirituel";
		this.origine = origine;
		this.dogmes = dogmes;
		this.nbrCartesCroyants = nbrCartesCroyants;
		this.familleCapaciteSpeciale = familleCapaciteSpeciale;
	}
	/**
	 * La m�thode active la fonctionne de la carte Guide Spirituel quand elle est utilis�e
	 */
	public void activerFonctionCarte(Joueur joueur, StockCarte s){
		
		if(joueur.getTypeJoueur()=="Joueur Physique"){
		System.out.println("Les cartes Croyants disponible � r�cup�rer sont:");
		for (int i=0; i< Tapis.getListeCartesCroyants().size();i++){
			System.out.println(Tapis.getListeCartesCroyants().get(i).afficherCarte());
		}
//		Principal.getInstance().getDetail().setText(Principal.getInstance().getDetail().getText()+"\n Choisissez la carte Croyant que vous voulez r�cup�rer!");
		JOptionPane.showMessageDialog(null,"Choisissez les cartes Croyant que vous voulez r�cup�rer!");
		for (int k = 0;k<nbrCartesCroyants;k++){
			Partie.getInstance().setClickCarteCroyant(false) ;
			System.out.println("Choisir la carte Croyant que vous voulez r�cup�rer!"
					+ " Si vous ne voulez pas rattacher une autre carte Croyants, tapez 0!");
	//		int R = JOptionPane.showConfirmDialog(null,"Choisissez une carte Croyant � r�cup�rer?");
     //       if(R == 0){
		
            
            
 //       	Partie.getInstance().setClickCarteCroyant(false);
//			int i;
//			i = scan.nextInt();
//		}
		}
	/*	for(int j=0; j<Tapis.getListeCartesCroyants().size();j++){
			if(Tapis.getListeCartesCroyants().get(j).getEstChoisi()){
				int id= Tapis.getListeCartesCroyants().get(j).getIdCarte();
				recupererCarteCroyant(joueur,id);
			}
		} */
		}
		else if(joueur.getTypeJoueur()=="Joueur Virtuel"){
			ArrayList<Carte> PairGuideVsCroyants = new ArrayList<Carte>();
			PairGuideVsCroyants.add(this);
			for(int j=0; j<this.nbrCartesCroyants;j++){
				if(Tapis.getListeCartesCroyants().isEmpty()==false){
			for(int i=0;i<Tapis.getListeCartesCroyants().size();i++){
				if(Arrays.asList(Tapis.getListeCartesCroyants().get(i).dogmes).contains(this.dogmes[0])
						||Arrays.asList(Tapis.getListeCartesCroyants().get(i).dogmes).contains(this.dogmes[1])){
					PairGuideVsCroyants.add(Tapis.getListeCartesCroyants().get(i));
					System.out.println("Le Joueur "+joueur.getIdJoueur()+" vient de rattacher la carte Croyants c_"
							+ Tapis.getListeCartesCroyants().get(i).getIdCarte());
					Tapis.getListeCartesCroyants().remove(i);
					nbrCartesCroyantsRattaches +=1;
					break;
				}
			}
				}
			}
			if(PairGuideVsCroyants.size()>1){
				joueur.getLaMain().getlistePaireGuideVsCroyants().add(PairGuideVsCroyants);
				}
			joueur.calculerPtPrieres();
			System.out.println("Le Joueur "+joueur.getIdJoueur()+" a " + joueur.getPtPriere() +" points Pri�res");
			if (nbrCartesCroyantsRattaches == 0){
				estUtilisable = false;
			}
		}
		
		}
		
		public void recupererCarteCroyant(Joueur joueur, int i){
			if(this.nbrCartesCroyantsRattaches<this.nbrCartesCroyants){
			ArrayList<Carte> PairGuideVsCroyants = new ArrayList<Carte>();
			PairGuideVsCroyants.add(this);
			if (i==0){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
			else{
				for (int j =0; j< Tapis.getListeCartesCroyants().size(); j++){
					
					if (i== Tapis.getListeCartesCroyants().get(j).getIdCarte()){ 
						if ((Arrays.asList(Tapis.getListeCartesCroyants().get(j).dogmes).contains(this.dogmes[0]))
								|| (Arrays.asList(Tapis.getListeCartesCroyants().get(j).dogmes).contains(this.dogmes[1]))){
							PairGuideVsCroyants.add(Tapis.getListeCartesCroyants().get(j));
							System.out.println("Vous venez de rattacher la carte Croyants "
									+ Tapis.getListeCartesCroyants().get(j).getNom());
							JOptionPane.showMessageDialog(null,"Vous venez de rattacher la carte Croyants "
									+ Tapis.getListeCartesCroyants().get(j).getNom());
							Tapis.getListeCartesCroyants().remove(j);
							nbrCartesCroyantsRattaches +=1;
							Partie.getInstance().updateVue();
						}
					
					else {
						System.out.println("Votre carte Guide Spirituel ne peut pas rattacher cette carte Croyants! "
							+ "Choisir la carte Croyants qui poss�de au moins un dogme en commun avec votre carte Guide Spirituel");
						JOptionPane.showMessageDialog(null,"Votre carte Guide Spirituel ne peut pas rattacher cette carte Croyants! "
								+ "Choisir la carte Croyants qui poss�de au moins un dogme en commun avec votre carte Guide Spirituel");
					}
				}
				}
			}
		
		if(PairGuideVsCroyants.size()>1){
		joueur.getLaMain().getlistePaireGuideVsCroyants().add(PairGuideVsCroyants);
		}
		joueur.calculerPtPrieres();
		System.out.println("Vous avez " + joueur.getPtPriere() +" points Pri�res");
		if (nbrCartesCroyantsRattaches == 0){
			estUtilisable = false;
		}
		Partie.getInstance().updateVue();
			}
			else{ 
				System.out.println("Votre carte Guide Spirituel ne peut plus rattacher des cartes Croyants! ");
				JOptionPane.showMessageDialog(null," Votre carte Guide Spirituel ne peut plus rattacher des cartes Croyants!");

			}
	}
	
	/**
	 * La m�thode affiche les attributes de la carte Guide Spirituel
	 */
	public String afficherCarte(){
		return ("c_"+idCarte+" :"+" Carte "+type+" "+nom+" d'origine "+origine+", dogmes:{"+dogmes[0]+","+
				dogmes[1]+"}, capacit�"+familleCapaciteSpeciale+" et peut rattacher "+nbrCartesCroyants+" cartes Croyants");
	}
	/**
	 * Getter de l'attribute dogmes
	 * @return
	 */
	public String [] getDogmes() {
		return dogmes;
	}	
	
	

}
