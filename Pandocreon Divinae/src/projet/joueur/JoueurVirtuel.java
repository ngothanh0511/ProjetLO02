package projet.joueur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import projet.cartes.Carte;
import projet.cartes.CarteCroyants;
import projet.cartes.GuideSpirituel;
import projet.cartes.StockCarte;
import projet.cartes.Tapis;
import projet.strategy.*;

public class JoueurVirtuel extends Joueur {
	static Scanner nom = new Scanner(System.in);
	Random r = new Random();
	static int k=2;
	public Strategy strat;//instantiated Strategy de joueur
	String typDiff;
	
	public String tryStrat(){
		return strat.mode();
	}
	
	public int try_pose_carte(){
		return strat.pose_carte(this);
	}
	
	public void try_defausser_carte(JoueurVirtuel joueur, StockCarte s){
		 strat.defausser_carte(joueur, s);
	}
	
	public void setMode(Strategy newStrat){
		strat=newStrat;
	}
	
	public void setTypeDif(String str) {
		// TODO Auto-generated method stub
		typDiff=str;
	}
	
	public String getTypeDif(){
		return typDiff;
	}
	
	public JoueurVirtuel(Integer id, Integer ptJour, Integer ptNuit, Integer ptNeant, Integer ptPriere) {
		super(id, ptJour, ptNuit, ptNeant, ptPriere);
		// TODO Auto-generated constructor stub
		this.id = id;
		this.ptActionJour = ptJour;
		this.ptActionNuit = ptNuit;
		this.ptActionNeant = ptNeant;
		this.ptPriere = ptPriere;
		this.typeJoueur = "Joueur Virtuel";
		this.typDiff=typDiff;
	}

	static Scanner nom = new Scanner(System.in);
	protected ArrayList<Joueur> cibleAttaque = new ArrayList<Joueur>();
	Random r = new Random();
	

	public void informer() {
		System.out.print(" a: ");
		System.out.print(ptActionJour + " points Action Jour, ");
		System.out.print(ptActionNuit + " points Action Nuit, ");
		System.out.println(ptActionNeant + " points Action Neant ");
		System.out.println("Il a gagné: " + ptPriere + " points Prières");
		if(laMain.getlistePaireGuideVsCroyants().isEmpty()==false){
		System.out.println("Il possède:");
		for (int i=0;i<laMain.getlistePaireGuideVsCroyants().size();i++){
			for(int j=1;j<laMain.getlistePaireGuideVsCroyants().get(i).size();j++){
				System.out.println("");
				System.out.println(laMain.getlistePaireGuideVsCroyants().get(i).get(0).afficherCarte()+" qui rattache:");
				System.out.println(laMain.getlistePaireGuideVsCroyants().get(i).get(j).afficherCarte());
			}
		}
		}
	}

	public static String setNom() {
		System.out.println("Mettez votre nom : ");
		return nom.nextLine();

	}

	public CarteCroyants choisirCarteCroyantsASacrifier() {
		for (int h = 2; h < laMain.getlistePaireGuideVsCroyants().size(); h++) {
			for (int j = 1; j < laMain.getlistePaireGuideVsCroyants().get(0).size(); j++) {
				if (laMain.getlistePaireGuideVsCroyants().get(0).get(j).getNbrCroyants() > laMain
						.getlistePaireGuideVsCroyants().get(0).get(j + 1).getNbrCroyants()) {
					laMain.getlistePaireGuideVsCroyants().get(0).add(j + 2,
							laMain.getlistePaireGuideVsCroyants().get(0).get(j));
					laMain.getlistePaireGuideVsCroyants().get(0).remove(j);
				}
			}
		}
		return (CarteCroyants) laMain.getlistePaireGuideVsCroyants().get(0).get(1);
	}

	public CarteCroyants choisirCarteCroyantsASacrifierDeEnemie(Joueur joueur) {
		for (int h = 2; h < joueur.getLaMain().getlistePaireGuideVsCroyants().size(); h++) {
			for (int j = 1; j < joueur.getLaMain().getlistePaireGuideVsCroyants().get(0).size(); j++) {
				if (joueur.getLaMain().getlistePaireGuideVsCroyants().get(0).get(j).getNbrCroyants() > joueur
						.getLaMain().getlistePaireGuideVsCroyants().get(0).get(j + 1).getNbrCroyants()) {
					joueur.getLaMain().getlistePaireGuideVsCroyants().get(0).add(j + 2,
							joueur.getLaMain().getlistePaireGuideVsCroyants().get(0).get(j));
					joueur.getLaMain().getlistePaireGuideVsCroyants().get(0).remove(j);
				}
			}
		}
		return (CarteCroyants) joueur.getLaMain().getlistePaireGuideVsCroyants().get(0)
				.get(joueur.getLaMain().getlistePaireGuideVsCroyants().get(0).size() - 1);
	}

	public GuideSpirituel choisirGuideSpirituelASacrifier() {
		for (int h = 1; h < laMain.getlistePaireGuideVsCroyants().size(); h++) {
			for (int k = 0; k < laMain.getlistePaireGuideVsCroyants().size(); k++) {
				if (laMain.getlistePaireGuideVsCroyants().get(k).size() > laMain.getlistePaireGuideVsCroyants()
						.get(k + 1).size()) {
					laMain.getlistePaireGuideVsCroyants().add(k + 2, laMain.getlistePaireGuideVsCroyants().get(k));
					laMain.getlistePaireGuideVsCroyants().remove(k);
				}
			}
		}
		return (GuideSpirituel) laMain.getlistePaireGuideVsCroyants().get(0).get(0);
	}

	public GuideSpirituel choisirGuideSpirituelASacrifierDeEnemie(Joueur joueur) {
		for (int h = 1; h < joueur.getLaMain().getlistePaireGuideVsCroyants().size(); h++) {
			for (int k = 0; k < joueur.getLaMain().getlistePaireGuideVsCroyants().size(); k++) {
				if (joueur.getLaMain().getlistePaireGuideVsCroyants().get(k).size() > joueur.getLaMain()
						.getlistePaireGuideVsCroyants().get(k + 1).size()) {
					joueur.getLaMain().getlistePaireGuideVsCroyants().add(k + 2,
							joueur.getLaMain().getlistePaireGuideVsCroyants().get(k));
					joueur.getLaMain().getlistePaireGuideVsCroyants().remove(k);
				}
			}
		}
		return (GuideSpirituel) joueur.getLaMain().getlistePaireGuideVsCroyants()
				.get(joueur.getLaMain().getlistePaireGuideVsCroyants().size() - 1).get(0);
	}

	public void getCibleAttaque() {
		for (int i = 0; i < Partie.rangJoueur.size(); i++) {
			if (Partie.rangJoueur.get(i).estAttaquable == true) {
				cibleAttaque.add(Partie.rangJoueur.get(i));
			}
		}
		System.out.println("Le Joueur "+id+" choisit de appliquer la capacité spéciale de sa carte sur joueur "+cibleAttaque.get(0).id);
	}

	@Override
	public void jouerSonTour(StockCarte s) {
		// TODO Auto-generated method stub
		s.distribuerCartes(laMain);
		System.out.println(tryStrat());
		/*for (int i=0; i< laMain.getListeCartesMain().size(); i++){
			   System.out.println(laMain.getListeCartesMain().get(i).afficherCarte());
		}*/
		try_defausser_carte(this, s);
		s.distribuerCartes(laMain);
		choisirCarte();
		
		
	}
	
	public void choisirCarte(){
		
		//Collections.shuffle(laMain.getListeCartesMain());//c'est un truc pour essayer, on peut le supprimer 
		
		int id=try_pose_carte();
		for (int i=0; i<laMain.getListeCartesMain().size(); i++){
			if (laMain.getListeCartesMain().get(i).getIdCarte()==id){
				laMain.getListeCartesMain().get(i).getUtilisable(this);
				if (laMain.getListeCartesMain().get(i).utilisee()==true){
					System.out.println("JV_" +this.getIdJoueur()+" jouÃ© la carte c_ "+ laMain.getListeCartesMain().get(i).getIdCarte());
					laMain.getListeCartesMain().get(i).activerFonctionCarte(this);
					laMain.getListeCartesMain().get(i).calculerPtAction(this);
					if (laMain.getListeCartesMain().get(i).utilisee()== true){
						laMain.getListeCartesMain().remove(i);
					}
					
				}
				
			}
			else{
				//System.out.println("marche pas");
				id=try_pose_carte();
			}
		}
		
			
		
		informer();
		System.out.println("**********************************");
		//compt--;
		//}
		
	}

	@Override
	public void activerCapaciteSpeciale(Carte carte, StockCarte s) {
		switch (carte.getFamilleCapaciteSpeciale()) {
		case ("F_1"):
			if (carte.getOrigine() == "Jour") {
				ptActionJour += 1;
				System.out.println("Le Joueur_"+id+" a reçu 1 point d'Action Jour");
			} else if (carte.getOrigine() == "Nuit") {
				ptActionNuit += 1;
				System.out.println("Le Joueur_"+id+" a reçu 1 point d'Action Nuit");
			} else {
				ptActionNeant += 1;
				System.out.println("Le Joueur_"+id+" a reçu 1 point d'Action Néant");
			}
			break;

		case ("F_2"):
			for (int i = 0; i < Partie.rangJoueur.size(); i++) {
				if ((Arrays.asList(((CarteCroyants) carte).getDogmes())
						.contains(Partie.rangJoueur.get(i).dogmesDivin[0]) == false)
						&& ((Arrays.asList(((CarteCroyants) carte).getDogmes())
								.contains(Partie.rangJoueur.get(i).dogmesDivin[1]) == false))
						&& ((Arrays.asList(((CarteCroyants) carte).getDogmes())
								.contains(Partie.rangJoueur.get(i).dogmesDivin[2]) == false))) {
					Partie.rangJoueur.get(i).setAttaquable(true);
				}
			}
			getCibleAttaque();
			if (cibleAttaque.isEmpty() == false) {
				for (int k = 0; k < cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().size(); k++) {
					for (int h = 1; h < cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(k)
							.size(); h++) {
						cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(k).get(h)
								.setSacrifiable(false);
						
					}

				}
				if(cibleAttaque.get(0).typeJoueur=="Joueur Physique"){
					System.out.println("Le Joueur_"+id+" a appliqué la capcité spéciale de la carte "+ carte.getNom()+" sur vous");
					System.out.println("Vous ne pourrez pas sacrifie vos cartes Croyants durant ce tour");
				}
				else {
				System.out.println("Le joueur_"+cibleAttaque.get(0).getIdJoueur()+" ne pourra pas sacrifier ses cartes Croyants durant ce tour");
				}
				} else {
				carte.setSacrifiable(false);
			}
			break;
		case ("F_3"):

			for (int i = 0; i < Partie.rangJoueur.size(); i++) {
				if ((Arrays.asList(((CarteCroyants) carte).getDogmes())
						.contains(Partie.rangJoueur.get(i).dogmesDivin[0]) == false)
						&& ((Arrays.asList(((CarteCroyants) carte).getDogmes())
								.contains(Partie.rangJoueur.get(i).dogmesDivin[1]) == false))
						&& ((Arrays.asList(((CarteCroyants) carte).getDogmes())
								.contains(Partie.rangJoueur.get(i).dogmesDivin[2]) == false))) {
					Partie.rangJoueur.get(i).setAttaquable(true);
				}
			}
			getCibleAttaque();
			if (cibleAttaque.isEmpty() == false) {
				
					for (int k = 0; k < cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().size(); k++) {
						cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(k).get(0)
								.setSacrifiable(false);
					}
					if(cibleAttaque.get(0).typeJoueur=="Joueur Physique"){
						System.out.println("Le Joueur_"+id+" a appliqué la capcité spéciale de la carte "+ carte.getNom()+" sur vous");
						System.out.println("Vous ne pourrez pas sacrifie vos cartes Guide Spirituel durant ce tour");
					}
					else {
					System.out.println("Le joueur_"+cibleAttaque.get(0).getIdJoueur()+" ne pourra pas sacrifier ses cartes Croyants durant ce tour");
					}				
			} else {
				carte.setSacrifiable(false);
			}
			break;
		case ("F_4"):
			for (int i = 0; i < Partie.rangJoueur.size(); i++) {
				Partie.rangJoueur.get(i).setAttaquable(true);
			}
			getCibleAttaque();
			Collections.shuffle(cibleAttaque.get(0).getLaMain().getListeCartesMain());
			laMain.getListeCartesMain().add(cibleAttaque.get(0).getLaMain().getListeCartesMain().get(0));
			laMain.getListeCartesMain().add(cibleAttaque.get(0).getLaMain().getListeCartesMain().get(1));
			cibleAttaque.get(0).getLaMain().getListeCartesMain().remove(0);
			cibleAttaque.get(0).getLaMain().getListeCartesMain().remove(0);
			if (carte.getType() == "DeusEx") {
				laMain.getListeCartesMain().add(cibleAttaque.get(0).getLaMain().getListeCartesMain().get(0));
				cibleAttaque.get(0).getLaMain().getListeCartesMain().remove(0);
				if(cibleAttaque.get(0).typeJoueur=="Joueur Physique"){
					System.out.println("Le Joueur_"+id+" a appliqué la capcité spéciale de la carte "+ carte.getNom()+" sur vous");
					System.out.println("Le Joueur_"+id+"a pris 3 cartes dans votre main");
				}
				else {
				System.out.println("Le Joueur_"+id+"a pris 3 cartes du Joueur_"+cibleAttaque.get(0).id);
			}
			}
			else {
				if(cibleAttaque.get(0).typeJoueur=="Joueur Physique"){
					System.out.println("Le Joueur_"+id+" a appliqué la capcité spéciale de la carte "+ carte.getNom()+" sur vous");
					System.out.println("Le Joueur_"+id+"a pris 2 cartes dans votre main");
				}
				else {
				System.out.println("Le Joueur_"+id+"a pris 2 cartes du Joueur_"+cibleAttaque.get(0).id);}
			}
			break;

		case ("F_5"):
			for (int i = 0; i < Partie.rangJoueur.size(); i++) {	
				Partie.rangJoueur.get(i).setAttaquable(true);
			}
			getCibleAttaque();
			switch (carte.getOrigine()) {
			case "Jour":
				if(cibleAttaque.get(0).typeJoueur=="Joueur Physique"){
					System.out.println("Le Joueur_"+id+" a appliqué la capcité spéciale de la carte "+ carte.getNom()+" sur vous");
					System.out.println("Vous devez sacrifier une de votre cartes Croyants");
				}
				CarteCroyants carteSacrifier = cibleAttaque.get(0).choisirCarteCroyantsASacrifier();
				cibleAttaque.get(0).sacrifierCarte(carteSacrifier, s);
				
				break;
			case "Neant":
				for (int i = 0; i < Partie.listeJoueur.size(); i++) {
					if (Partie.listeJoueur.get(i).getIdJoueur() != id) {
						if(Partie.listeJoueur.get(i).typeJoueur=="Joueur Physique"){
							System.out.println("Le Joueur_"+id+" a appliqué la capcité spéciale de la carte "+ carte.getNom()+" sur vous");
							System.out.println("Vous devez sacrifier une de votre cartes Croyants");
						}
						CarteCroyants carteSacrifier1 = Partie.listeJoueur.get(i).choisirCarteCroyantsASacrifier();
						Partie.listeJoueur.get(i).sacrifierCarte(carteSacrifier1, s);

					}
				}
				break;
			}
			break;
		case ("F_6"):
			for (int i = 0; i < Partie.rangJoueur.size(); i++) {
				Partie.rangJoueur.get(i).setAttaquable(true);
			}
			getCibleAttaque();
			for (int i = 0; i < cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().size(); i++) {
				if(cibleAttaque.get(0).typeJoueur=="Joueur Physique"){
					System.out.println("Le Joueur_"+id+" a appliqué la capcité spéciale de la carte "+ carte.getNom()+" sur vous");
				}
				if (choisirGuideSpirituelASacrifierDeEnemie(cibleAttaque.get(0)).getIdCarte() == cibleAttaque.get(0)
						.getLaMain().getlistePaireGuideVsCroyants().get(i).get(0).getIdCarte()) {
					for (int h = 1; h < cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(i)
							.size(); h++) {
						Tapis.getListeCartesCroyants().add(((CarteCroyants) cibleAttaque.get(0).getLaMain()
								.getlistePaireGuideVsCroyants().get(i).get(h)));

					}
					switch (carte.getOrigine()) {
					case "Jour":
						cibleAttaque.get(0).getLaMain().getListeCartesMain()
								.add(cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(i).get(0));
						break;
					case "Nuit":
						s.getStock().add(cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(i).get(0));
						break;
					}
					cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().remove(i);
					if(cibleAttaque.get(0).typeJoueur=="Joueur Physique"){
						System.out.println("Toutes les cartes Croyants de votre carte Guide Spirituel "+choisirGuideSpirituelASacrifierDeEnemie(cibleAttaque.get(0)).getNom()+" ont été défaussées");
					}
					else {System.out.println("Toutes les cartes Croyants de la carte Guide Spirituel "+choisirGuideSpirituelASacrifierDeEnemie(cibleAttaque.get(0)).getNom()+" du Joueur_"+cibleAttaque.get(0).id+" ont été défaussées");
					}
					break;
				}
			}
			break;

		case ("F_30"):

			for (int i = 0; i < Partie.rangJoueur.size(); i++) {
				if ((Arrays.asList(((GuideSpirituel) carte).getDogmes())
						.contains(Partie.rangJoueur.get(i).dogmesDivin[0]) == true)
						|| ((Arrays.asList(((GuideSpirituel) carte).getDogmes())
								.contains(Partie.rangJoueur.get(i).dogmesDivin[1]) == true))
						|| ((Arrays.asList(((GuideSpirituel) carte).getDogmes())
								.contains(Partie.rangJoueur.get(i).dogmesDivin[2]) == true))) {
					Partie.rangJoueur.get(i).setAttaquable(true);
				}
			}
			getCibleAttaque();
			if (cibleAttaque.isEmpty() == false) {
				if(cibleAttaque.get(0).typeJoueur=="Joueur Physique"){
					System.out.println("Le Joueur_"+id+" a appliqué la capcité spéciale de la carte "+ carte.getNom()+" sur vous");
					System.out.println("Vous devez sacrifier une de votre cartes Guide Spirituel");
				}
				GuideSpirituel carteSacrifier = cibleAttaque.get(0).choisirGuideSpirituelASacrifier();
				cibleAttaque.get(0).sacrifierCarte(carteSacrifier, s);
			}

			break;
		case ("F_7"):
			DeCosmogonie de = new DeCosmogonie();
			System.out.println("Lancement le dé de Cosmogonie...");
			de.resultatLancement();
			String resLance = de.getFace();
			for (int i = 0; i < Partie.listeJoueur.size(); i++) {
				de.donnerPtAction(resLance, Partie.listeJoueur.get(i)); 
			}
			break;
		case ("F_8"):

			for (int i = (Partie.listeJoueur.indexOf(this)) + 1; i < Partie.listeJoueur.size(); i++) {
				Partie.listeJoueur.get(i).setAttaquable(true);
			}
			getCibleAttaque();
			if (cibleAttaque.isEmpty() == false) {
				if(cibleAttaque.get(0).typeJoueur=="Joueur Physique"){
						System.out.println("Le Joueur_"+id+" a appliqué la capcité spéciale de la carte "+ carte.getNom()+" sur vous");
						System.out.println("Vous pedrez votre points d'Action à ce joueur");
				}
				int ptJour = ptActionJour + cibleAttaque.get(0).getPtActionJour();
				setPtActionJour(ptJour);
				cibleAttaque.get(0).setPtActionJour(0);
				int ptNuit = ptActionNuit + cibleAttaque.get(0).getPtActionNuit();
				setPtActionJour(ptNuit);
				cibleAttaque.get(0).setPtActionNuit(0);
				int ptNeant = ptActionNeant + cibleAttaque.get(0).getPtActionNeant();
				setPtActionJour(ptNeant);
				cibleAttaque.get(0).setPtActionNeant(0);
			} 
			break;
		case ("F_9"):
			for (int i = 0; i < Partie.rangJoueur.size(); i++) {
				if (Partie.rangJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().isEmpty() == false) {
					Partie.rangJoueur.get(i).setAttaquable(true);
				}
			}
			getCibleAttaque();
			System.out.println("Le Joueur "+id+ "bénéficiera la capacité spéciale de la carte"+cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(0).get(0).getNom()+" du Joueur "+cibleAttaque.get(0).id );
			activerCapaciteSpeciale(cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(0).get(0), s);
			break;
		case "F_10":
			for (int i = 0; i < Partie.listeJoueur.size(); i++) {
				Partie.listeJoueur.get(i).peutRecevoirPtAction = false;
			}
			System.out.println("Jusqu'à la fin du tour, plus aucun joueur ne reçoit de points d'Action");
			break;
		case "F_11":
			if (Partie.listeJoueur.size() > 3) {
				if (Partie.getEliminant().typeJoueur == "Joueur Physique") {
					System.out.println("Vous êtes éliminé car le joueur qui gagne le moins points de Prières");
					Partie.listeJoueur.remove(Partie.getEliminant());
					Partie.nbrJoueurs -= 1;
					System.exit(1);
				} else if (Partie.getEliminant().typeJoueur == "Joueur Virtuel") {
					System.out.println("Le Joueur_" + Partie.getEliminant().id
							+ " est éliminé car il est le joueur qui gagne le moins points de Prières");
					Partie.listeJoueur.remove(Partie.getEliminant());
					Partie.nbrJoueurs -= 1;
					for (int i = 0; i < Partie.listeJoueur.indexOf(this); i++) {
						Partie.listeJoueur.add(Partie.listeJoueur.get(0));
						Partie.listeJoueur.remove(0);
					}
					Partie.tourDeJeu(s);
				}

			} else if (Partie.listeJoueur.size() < 4) {
				if (Partie.getGagnant().typeJoueur == "Joueur Physique") {
					System.out.println("Félicitation! Vous êtes gagné !");
				} else if (Partie.getGagnant().typeJoueur == "Joueur Virtuel") {
					System.out.println("Joueur_" + Partie.getGagnant().id
							+ " est gagné car il est le joueur qui gagne le plus points Prières.");
				}
				System.exit(1);
			}
			break;
		case "F_12":
			for (int i = 0; i < laMain.getlistePaireGuideVsCroyants().size(); i++) {
				if (laMain.getlistePaireGuideVsCroyants().get(i).contains(choisirGuideSpirituelASacrifier())) {
					Integer pt = laMain.getlistePaireGuideVsCroyants().get(i).size() - 1;
					if (originDivin == "Jour") {
						ptActionJour += pt;
						System.out.println("Le Joueur "+id+" a reçu "+pt+"points d'Action Jour");
					} else if (originDivin == "Nuit") {
						ptActionNuit += pt;
						System.out.println("Le Joueur "+id+" a reçu "+pt+"points d'Action Nuit");
					} else if (originDivin == "Aube" || originDivin == "Crepuscule") {
						ptActionNeant += pt;
						System.out.println("Le Joueur "+id+" a reçu "+pt+"points d'Action Néant");
					}
					break;

				}

			}
			break;
		case "F_13":
			for (int i = 0; i < Partie.listeJoueur.size(); i++) {
				if (Arrays.asList(Partie.listeJoueur.get(i).getDogmesDivin()).contains("Humain")) {
					int a =0;
					for(int h=0;h<Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().size();h++){
						for(int l=1;l<Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(h).size();l++){
							if(Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(h).get(l).getOrigine()=="Neant"){
								a+=1;
							}
						}
					}
					if(a!=0){
					Partie.listeJoueur.get(i).setAttaquable(true);
					}
				}
			}
			getCibleAttaque();
			if (cibleAttaque.isEmpty() == false) {
				for (int j = 0; j < cibleAttaque.get(0).laMain.getlistePaireGuideVsCroyants().size(); j++) {
					for (int k = 1; k < cibleAttaque.get(0).laMain.getlistePaireGuideVsCroyants().get(j).size(); k++) {
						if (cibleAttaque.get(0).laMain.getlistePaireGuideVsCroyants().get(j).get(k)
								.getOrigine() == "Neant") {
							cibleAttaque.get(0).sacrifierCarte(
									cibleAttaque.get(0).laMain.getlistePaireGuideVsCroyants().get(j).get(k), s);
						}
					}
				}
				System.out.println("Toutes les cartes Croyants d'origine Néant du joueur "+cibleAttaque.get(0).getIdJoueur()+" ont été sacrifiées");

			} 
			break;
		case "F_14":
			for (int i = 0; i < Partie.listeJoueur.size(); i++) {
				for (int j = 0; j < Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().size(); j++) {
					for (int k = 0; k < Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j)
							.size(); k++) {
						if ((Arrays
								.asList(Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j).get(0))
								.contains("Chaos") == false)
								|| (Arrays.asList(Partie.listeJoueur.get(i).getDogmesDivin())
										.contains("Chaos") == false)) {
							Partie.listeJoueur.get(i).setAttaquable(true);
						}
					}
				}
			}
			getCibleAttaque();
			if (cibleAttaque.isEmpty() == false) {
				if (Arrays.asList(cibleAttaque.get(0).dogmesDivin).contains("Chaos")) {
					cibleAttaque.get(0)
							.sacrifierCarte(cibleAttaque.get(0).laMain.getlistePaireGuideVsCroyants().get(0).get(0), s);
				} else {
					for (int k = 0; k < cibleAttaque.get(0).laMain.getlistePaireGuideVsCroyants().get(k).size(); k++) {
						if (Arrays.asList(cibleAttaque.get(0).laMain.getlistePaireGuideVsCroyants().get(k).get(0))
								.contains("Chaos") == false) {
							cibleAttaque.get(0).sacrifierCarte(
									cibleAttaque.get(0).laMain.getlistePaireGuideVsCroyants().get(k).get(0), s);
						}
					}

				}
			} 
			break;
		case "F_15":
			Iterator<CarteCroyants> it = Tapis.getListeCartesCroyants().iterator();
			while (it.hasNext()) {
				if ((Arrays.asList(((CarteCroyants) it).getDogmes()).contains("Nature"))
						&& ((((CarteCroyants) it).getOrigine() == "Nuit")
								|| (((CarteCroyants) it).getOrigine() == "Neant"))) {
					s.getStock().add((CarteCroyants) it);
					it.next();
					it.remove();
				}

			}
			Iterator<CarteCroyants> it1 = Tapis.getListeCartesCroyantsIndisponible().iterator();
			while (it1.hasNext()) {
				if ((Arrays.asList(((CarteCroyants) it1).getDogmes()).contains("Nature"))
						&& ((((CarteCroyants) it1).getOrigine() == "Nuit")
								|| (((CarteCroyants) it1).getOrigine() == "Neant"))) {
					s.getStock().add((CarteCroyants) it1);
					it1.next();
					it1.remove();
				}

			}
			break;
		case "F_16":
			if (carte.getType() == "GuideSpirituel") {
				for (int i = 0; i < Partie.listeJoueur.size(); i++) {
					if (Arrays.asList(Partie.listeJoueur.get(i).dogmesDivin).contains("Humain")
							|| Arrays.asList(Partie.listeJoueur.get(i).dogmesDivin).contains("Symboles")) {
						Partie.listeJoueur.get(i).setAttaquable(true);
					}
				}
			} else if (carte.getType() == "DeusEx") {
				for (int i = 0; i < Partie.listeJoueur.size(); i++) {
					Partie.listeJoueur.get(i).setAttaquable(true);
				}
			}
			getCibleAttaque();
			if (Partie.rangJoueur.isEmpty() == false) {
				for (int l = 1; l < 3; l++) {
					cibleAttaque.get(0).sacrifierCarte(choisirCarteCroyantsASacrifierDeEnemie(cibleAttaque.get(0)), s);
				}
			} 
			break;
		case "F_17":
			for (int i = 0; i < Partie.listeJoueur.size(); i++) {
				if ((Arrays.asList(Partie.listeJoueur.get(i).dogmesDivin).contains("Mystique")
						&& Arrays.asList(Partie.listeJoueur.get(i).dogmesDivin).contains("Chaos"))
						|| (Partie.listeJoueur.get(i).originDivin == "Nuit")) {
					Partie.listeJoueur.get(i).setAttaquable(true);
				}
			}
			getCibleAttaque();
			if (cibleAttaque.isEmpty() == false) {
				Carte carteGuide = cibleAttaque.get(0).choisirGuideSpirituelASacrifier();
				System.out.println("Le Joueur "+cibleAttaque.get(0).id+" reprend dans sa main la carte Guide Spirituel "+carteGuide.getNom()+". Les Croyants qui y étaient attachés sont défaussés.");
				cibleAttaque.get(0).laMain.getListeCartesMain().add(carteGuide);
				for (int j = 0; j < cibleAttaque.get(0).laMain.getlistePaireGuideVsCroyants().size(); j++) {
					if (cibleAttaque.get(0).laMain.getlistePaireGuideVsCroyants().get(j).get(0)
							.getIdCarte() == carteGuide.getIdCarte()) {
						for (int k = 1; k < cibleAttaque.get(0).laMain.getlistePaireGuideVsCroyants().get(j)
								.size(); k++) {
							s.getStock().add(cibleAttaque.get(0).laMain.getlistePaireGuideVsCroyants().get(j).get(k));
						}
						cibleAttaque.get(0).laMain.getlistePaireGuideVsCroyants().remove(j);
						break;
					}

				}
			} else {
				carte.setSacrifiable(false);
			}
			break;
		case "F_18":
			for (int i = 0; i < Partie.listeJoueur.size(); i++) {
				if (Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().isEmpty() == false) {
					Partie.listeJoueur.get(i).setAttaquable(true);
				}
			}
			getCibleAttaque();
			Carte maCarte = choisirGuideSpirituelASacrifier();
			Carte enemieCarte = choisirGuideSpirituelASacrifierDeEnemie(cibleAttaque.get(0));
			System.out.println("Le Joueur "+id+" a choisi de échanger sa carte "+maCarte.getNom()+" avec la carte "+enemieCarte.getNom()+" du Joueur "+cibleAttaque.get(0).id);
			for (int k = 0; k < cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().size(); k++) {
				if (cibleAttaque.get(0).laMain.getlistePaireGuideVsCroyants().get(k).get(0).getIdCarte() == enemieCarte
						.getIdCarte()) {
					laMain.getlistePaireGuideVsCroyants()
							.add(cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(k));
					cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().remove(k);
					break;
				}
			}
			for (int k = 0; k < laMain.getlistePaireGuideVsCroyants().size(); k++) {
				if (laMain.getlistePaireGuideVsCroyants().get(k).get(0).getIdCarte() == maCarte.getIdCarte()) {
					cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants()
							.add(laMain.getlistePaireGuideVsCroyants().get(k));
					laMain.getlistePaireGuideVsCroyants().remove(k);
					break;
				}
			}
			break;
		case "F_19":
			Iterator<CarteCroyants> it2 = Tapis.getListeCartesCroyants().iterator();
			while (it2.hasNext()) {
				if ((Arrays.asList(((CarteCroyants) it2).getDogmes()).contains("Mystique"))) {
					s.getStock().add((CarteCroyants) it2);
					it2.next();
					it2.remove();
				}

			}
			Iterator<CarteCroyants> it3 = Tapis.getListeCartesCroyantsIndisponible().iterator();
			while (it3.hasNext()) {
				if ((Arrays.asList(((CarteCroyants) it3).getDogmes()).contains("Mystique"))) {
					s.getStock().add((CarteCroyants) it3);
					it3.next();
					it3.remove();
				}

			}
			break;
		case "F_20":
			String face = null;
			if (originDivin == "Jour") {
				face = "Jour";
				System.out.println("Le Joueur "+id+" pose le dé de Cosmogonie sur la face Jour.");
			} else if (originDivin == "Nuit") {
				face = "Nuit";
				System.out.println("Le Joueur "+id+" pose le dé de Cosmogonie sur la face Nuit.");

			} else if (originDivin == "Aube" || originDivin == "Crepuscule") {
				face = "Neant";
				System.out.println("Le Joueur "+id+" pose le dé de Cosmogonie sur la face Néant.");

			}
			for (int i = 0; i < Partie.listeJoueur.size(); i++) {
				DeCosmogonie de1 = new DeCosmogonie();
				de1.donnerPtAction(face, Partie.listeJoueur.get(i));
			}
			for (int i = 0; i < Partie.listeJoueur.indexOf(this); i++) {
				Partie.listeJoueur.set(Partie.listeJoueur.size() - 1, Partie.listeJoueur.get(0));
			}
			Partie.tourDeJeu(s);
			break;
		case "F_21":
			for (int i = 0; i < Partie.listeJoueur.size(); i++) {
				for (int j = 0; j < Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().size(); j++) {
					if (Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j).get(0)
							.getOrigine() != carte.getOrigine()) {
						Partie.listeJoueur.get(i).setAttaquable(true);
						break;
					}
				}
			}
			getCibleAttaque();
			for (int j = 0; j < cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().size(); j++) {
				if (cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(j).get(0).getOrigine() != carte
						.getOrigine()) {
					System.out.println("La carte Guide Spirituel "+cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(j).get(0).getNom()+" du Joueur "+cibleAttaque.get(0).id+" est défaussée. Les Croyants y attachés reviennent au centre de la table.");
					for (int k = 1; k < cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(j)
							.size(); k++) {
						Tapis.getListeCartesCroyants().add((CarteCroyants) cibleAttaque.get(0).getLaMain()
								.getlistePaireGuideVsCroyants().get(j).get(k));
					}
					s.getStock().add(cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(j).get(0));
					cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().remove(j);
					break;
				}

			}

			break;
		case "F_23":
			for (int i = 0; i < Partie.getListeJoueur().size(); i++) {
				if(Partie.getListeJoueur().get(i).laMain.getlistePaireGuideVsCroyants().isEmpty()== false){
				Partie.getListeJoueur().get(i).setAttaquable(true);
				}
			}
			getCibleAttaque();
			for (int j = 0; j < cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().size(); j++) {
				if (choisirGuideSpirituelASacrifierDeEnemie(cibleAttaque.get(0)).getIdCarte() == cibleAttaque.get(0)
						.getLaMain().getlistePaireGuideVsCroyants().get(j).get(0).getIdCarte()) {
					laMain.getlistePaireGuideVsCroyants()
							.add(cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(j));
					cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().remove(j);
					System.out.println("Le Joueur "+id+" a volé la carte Guide Spirituel "+cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(j).get(0).getNom()+" et ses Croyants de Joueur "+cibleAttaque.get(0).id);
					break;
				}
			}
			break;
		case "F_25":
			System.out.print("Le Joueur "+id+" bénéficie la capacité spéciale de sa carte "+laMain.getlistePaireGuideVsCroyants().get(0).get(0).getNom());
			activerCapaciteSpeciale(laMain.getlistePaireGuideVsCroyants().get(0).get(0), s);
			
			break;
		case "F_26":
			switch (carte.getNom()) {
			case "Influence Jour":
				if (carteJouee.getOrigine() == "Nuit" || carteJouee.getOrigine() == "Neant") {
					carteJouee.setAnnule(true);
					System.out.println("La capacité spéciale de la carte "+carteJouee.getNom()+" est annuléé");
				}
				break;
			case "Influence Nuit":
				if (carteJouee.getOrigine() == "Jour" || carteJouee.getOrigine() == "Neant") {
					carteJouee.setAnnule(true);
					System.out.println("La capacité spéciale de la carte "+carteJouee.getNom()+" est annuléé");
				}
				break;
			case "Influence Neant":
				if (carteJouee.getOrigine() == "Jour" || carteJouee.getOrigine() == "Nuit") {
					carteJouee.setAnnule(true);
					System.out.println("La capacité spéciale de la carte "+carteJouee.getNom()+" est annuléé");
				}
				break;
			case "Influence Nulle":
				carteJouee.setAnnule(true);
				System.out.println("La capacité spéciale de la carte "+carteJouee.getNom()+" est annuléé");
				break;
			}
			break;
		}

	}
}
