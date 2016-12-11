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
/**
 * Cette classe représente le joueur virtuel du jeu
 * 
 *
 */
public class JoueurVirtuel extends Joueur {
	static Scanner nom = new Scanner(System.in);
	Random r = new Random();
	static int k=2;
	protected Strategy strat;//instantiated Strategy de joueur
	String typDiff;
	protected ArrayList<Joueur> cibleAttaque = new ArrayList<Joueur>();
	
	/**
	 * Retourner le mode de stratégie du joueur Virtuel
	 * @return
	 */
	public String tryStrat(){
		return strat.mode();
	}
	/**
	 * L'action pose carte du joueur Virtuel
	 * @return
	 */
	public int try_pose_carte(){
		return strat.pose_carte(this);
	}
	/**
	 * L'action défausser carte du joueur Virtuel
	 * @param s
	 */
	public void defausser_carte( StockCarte s) {
		// TODO Auto-generated method stub
		
	//	ArrayList <Integer> liste_carte_def = new ArrayList <Integer>();
		
		for(int i=0;i< laMain.getListeCartesMain().size();i++){	
			String c= laMain.getListeCartesMain().get(i).getOrigine();
			//String d=laMain.getListeCartesMain().get(i).getType();
			Carte d=this.getLaMain().getListeCartesMain().get(i);
			 
			if(originDivin=="Aube" || originDivin=="Jour"){
				if(c=="Nuit"){ // je mets Neant ici cgetLaMain().getListeCartesMain().get(i)ar origin aube peut avoir les point d'action Neant
				//	liste_carte_def.add(joueur.getLaMain().getListeCartesMain().get(i).getIdCarte());
					this.defausserCarte(laMain.getListeCartesMain().get(i), s);
				}
				
			}
			
			else if(originDivin=="Nuit" || originDivin=="Crepuscule"){
				if(c=="Jour" ){//c'est la meme cas	
					//liste_carte_def.add(joueur.getLaMain().getListeCartesMain().get(i).getIdCarte());
					this.defausserCarte(laMain.getListeCartesMain().get(i), s);
				}
				
			}
			
		}
		
	}
	
	/**
	 * On fixe le mode de jouer de chaque joueur virtuel en referencant les modes existant dans la patron de Strategie
	 * @param str
	 */
	public void setTypeDif(String str) {
		// TODO Auto-generated method stub
		typDiff=str;
	}
	/**
	 * On récupere le type de difficulté appliqué au joueur virtuel correspondant
	 */
	public String getTypeDif(){
		return typDiff;
	}
	/**
	 * Constructeur du joueur Virtuel
	 * @param id
	 * @param ptJour
	 * @param ptNuit
	 * @param ptNeant
	 * @param ptPriere
	 */
	public JoueurVirtuel(Integer id, Integer ptJour, Integer ptNuit, Integer ptNeant, Integer ptPriere) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.ptActionJour = ptJour;
		this.ptActionNuit = ptNuit;
		this.ptActionNeant = ptNeant;
		this.ptPriere = ptPriere;
		this.typeJoueur = "Joueur Virtuel";
	}
	
	/**
	 * Affichage des informations des joueur virtuels
	 */
	public void informer() {
		System.out.print(" ( divinite "+ this.originDivin +" rang "+Partie.getNumRang(this)+") a: ");
		System.out.print(ptActionJour + " points Action Jour, ");
		System.out.print(ptActionNuit + " points Action Nuit, ");
		System.out.println(ptActionNeant + " points Action Neant ");
		System.out.println("Il a gagné: " + ptPriere + " points PriÃ¨res");
		if(laMain.getlistePaireGuideVsCroyants().isEmpty()==false){
		System.out.println("Il possÃ¨de:");
		for (int i=0;i<laMain.getlistePaireGuideVsCroyants().size();i++){
			System.out.println("");
			System.out.println(laMain.getlistePaireGuideVsCroyants().get(i).get(0).afficherCarte()+" qui rattache:");
			for(int j=1;j<laMain.getlistePaireGuideVsCroyants().get(i).size();j++){
				System.out.println(laMain.getlistePaireGuideVsCroyants().get(i).get(j).afficherCarte());
			}
		}
		}
	}
	/**
	 * Le joueur choisit la carte Croyant à sacrifier quand il est obligé à sacrifier une de ses cartes Croyants
	 */
	public CarteCroyants choisirCarteCroyantsASacrifier() {
		for (int h = 0; h < laMain.getlistePaireGuideVsCroyants().size()-1; h++) {
			for(int l=0;l<laMain.getlistePaireGuideVsCroyants().size()-1;l++){
				if(laMain.getlistePaireGuideVsCroyants().get(l).size()<laMain.getlistePaireGuideVsCroyants().get(l+1).size()){
					ArrayList <Carte> ar = laMain.getlistePaireGuideVsCroyants().get(l);
					laMain.getlistePaireGuideVsCroyants().set(l, laMain.getlistePaireGuideVsCroyants().get(l+1));
					laMain.getlistePaireGuideVsCroyants().set(l+1, ar);
			}
		}
		}
			for (int k = 1; k < laMain.getlistePaireGuideVsCroyants().get(0).size()-1; k++) {
				for(int j=1;j<laMain.getlistePaireGuideVsCroyants().get(0).size()-1;j++){
				if (((CarteCroyants) laMain.getlistePaireGuideVsCroyants().get(0).get(j)).getNbrCroyants() > ((CarteCroyants) laMain
						.getlistePaireGuideVsCroyants().get(0).get(j + 1)).getNbrCroyants()) {
					laMain.getlistePaireGuideVsCroyants().get(0).add(j + 2,
							laMain.getlistePaireGuideVsCroyants().get(0).get(j));
					laMain.getlistePaireGuideVsCroyants().get(0).remove(j);
				}
			}
		}

		return (CarteCroyants) laMain.getlistePaireGuideVsCroyants().get(0).get(1);
	}
	/**
	 * Le joueur choisir la carte Croyant de joueur opponant que il veut cette joueur sacrifie
	 * @param joueur
	 * @return
	 */
	public CarteCroyants choisirCarteCroyantsASacrifierDeEnemie(Joueur joueur) {
		for (int h = 0; h < laMain.getlistePaireGuideVsCroyants().size()-1; h++) {
			for(int l=0;l<laMain.getlistePaireGuideVsCroyants().size()-1;l++){
				if(laMain.getlistePaireGuideVsCroyants().get(l).size()<laMain.getlistePaireGuideVsCroyants().get(l+1).size()){
					ArrayList <Carte> ar = laMain.getlistePaireGuideVsCroyants().get(l);
					laMain.getlistePaireGuideVsCroyants().set(l, laMain.getlistePaireGuideVsCroyants().get(l+1));
					laMain.getlistePaireGuideVsCroyants().set(l+1, ar);
			}
		}
		}
		for (int k = 1; k < laMain.getlistePaireGuideVsCroyants().get(0).size()-1; k++) {
			for(int j=1;j<laMain.getlistePaireGuideVsCroyants().get(0).size()-1;j++){
				if (((CarteCroyants) laMain.getlistePaireGuideVsCroyants().get(0).get(j)).getNbrCroyants() > ((CarteCroyants) laMain
						.getlistePaireGuideVsCroyants().get(0).get(j + 1)).getNbrCroyants()) {
					laMain.getlistePaireGuideVsCroyants().get(0).add(j + 2,
							laMain.getlistePaireGuideVsCroyants().get(0).get(j));
					laMain.getlistePaireGuideVsCroyants().get(0).remove(j);
				}
			}
		}

		return (CarteCroyants) laMain.getlistePaireGuideVsCroyants().get(0).get(laMain.getlistePaireGuideVsCroyants().get(0).size()-1);
	}
	/**
	 * Le joueur choisit la carte Guide Spirituel à sacrifier quand il est obligé à sacrifier une de ses cartes Guide Spirituel
	 */
	public GuideSpirituel choisirGuideSpirituelASacrifier() {
		for (int h = 0; h < laMain.getlistePaireGuideVsCroyants().size()-1; h++) {
			for (int k = 0; k < laMain.getlistePaireGuideVsCroyants().size()-1; k++) {
				if (laMain.getlistePaireGuideVsCroyants().get(k).size() > laMain.getlistePaireGuideVsCroyants()
						.get(k + 1).size()) {
					laMain.getlistePaireGuideVsCroyants().add(k + 2, laMain.getlistePaireGuideVsCroyants().get(k));
					laMain.getlistePaireGuideVsCroyants().remove(k);
				}
			}
		}
		return (GuideSpirituel) laMain.getlistePaireGuideVsCroyants().get(0).get(0);
	}
	/**
	 * Le joueur choisit une carte Guide Spirituel de l'opponant qu'il veut ce joueur à sacrifier
	 * @param joueur
	 * @return
	 */
	public GuideSpirituel choisirGuideSpirituelASacrifierDeEnemie(Joueur joueur) {
		for (int h = 0; h < joueur.getLaMain().getlistePaireGuideVsCroyants().size()-1; h++) {
			for (int k = 0; k < joueur.getLaMain().getlistePaireGuideVsCroyants().size()-1; k++) {
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
	/**
	 * Getter de l'attribute cibleAttaque
	 */
	public void getCibleAttaque() {
		Partie.setRangJoueur();
		for (int i = 0; i < Partie.rangJoueur.size(); i++) {
			if(Partie.rangJoueur.get(i).id!=this.id){
			if (Partie.rangJoueur.get(i).estAttaquable == true) {
				cibleAttaque.add(Partie.rangJoueur.get(i));
			}
		}
		}
		if(cibleAttaque.isEmpty()==false){
			if(cibleAttaque.get(0).getTypeJoueur()!="Joueur Physique"){
		System.out.println("Le Joueur "+id+" choisit d'appliquer la capacitÃ© spÃ©ciale de sa carte sur joueur "+cibleAttaque.get(0).id);
	}
		}
	}
	/**
	 * Le joueur joue son tour
	 */
	public void jouerSonTour(StockCarte s) {
		// TODO Auto-generated method stub
		s.distribuerCartes(laMain);
	//	System.out.println(tryStrat()); // pour voir le mode joué par joueur virtuel
		/*if(Partie.tours>15){ //pour voir les cartes dans la main de joueur virtuel
			for (int i=0; i< laMain.getListeCartesMain().size(); i++){
				   System.out.println(laMain.getListeCartesMain().get(i).afficherCarte());
			}
		}*/
		defausser_carte(s);
		s.distribuerCartes(laMain);
		int rang = Partie.rangJoueur.indexOf(this);
		if(typDiff=="f"){
			strat= new Defenssif();
		}
		else if(typDiff=="d"){
		if(Partie.listeJoueur.size()>3){
			if(rang<3){
				strat = new Defenssif();
			}
			else{ strat = new Agressif();}
		}
		else{
			if(rang==0){
				strat = new Defenssif();
			}
			else{ strat = new Agressif();}
		}
		}
		choisirCarte(s);
		for(int i=0;i<Partie.listeJoueur.size();i++){
			Partie.listeJoueur.get(i).calculerPtPrieres();
		}
		
	}
	/**
	 * Le joueur choisit la carte d'Action à utiliser
	 */
	public void choisirCarte(StockCarte s){
		
		int id=try_pose_carte();
		for (int i=0; i<laMain.getListeCartesMain().size(); i++){ 
			if (laMain.getListeCartesMain().get(i).getIdCarte()==id){
				laMain.getListeCartesMain().get(i).getUtilisable(this);
				if (laMain.getListeCartesMain().get(i).utilisee()==true){
					System.out.println("JV_" +this.getIdJoueur()+" ( d'origine "+this.originDivin + " :rang "+Partie.getNumRang(this)+" ) "+" joue la carte c_ "+ laMain.getListeCartesMain().get(i).getIdCarte());
					laMain.getListeCartesMain().get(i).activerFonctionCarte(this,s);
					laMain.getListeCartesMain().get(i).calculerPtAction(this);
					if (laMain.getListeCartesMain().get(i).utilisee()== true){
						if(laMain.getListeCartesMain().get(i).getType()=="DeusEx"||laMain.getListeCartesMain().get(i).getType()=="Apocalypse"){
			 				s.getStock().add(laMain.getListeCartesMain().get(i));
			 		}
						laMain.getListeCartesMain().remove(i);
					}
					else if(laMain.getListeCartesMain().get(i).utilisee()== false){
						laMain.getListeCartesMain().get(i).setFonctionnable(false);
						System.out.println("Cette carte ne marche pas!");
					}
				}
				
			}
			else{
				
				id=try_pose_carte();
			}
			
		}
		for (int i = 0; i< Tapis.getListeCartesCroyantsIndisponible().size();i++){
			Tapis.getListeCartesCroyants().add(Tapis.getListeCartesCroyantsIndisponible().get(i));
			Tapis.getListeCartesCroyantsIndisponible().remove(i);
		}
			
		System.out.println("Le Joueur "+this.id+" (rang "+Partie.getNumRang(this) +") a fini son tour");

		System.out.println("**********************************");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * Activer la capacité spéciale d'une carte quand elle est utilisée pour une carte DeusEx et Apocalypse
	 * ou quand elle est sacrifiée pour une carte Guide Spirituel ou Croyants
	 */
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
				carte.setUtilisable(false);
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
						System.out.println("Le Joueur_"+id+" a appliquÃ© la capcité spéciale de la carte "+ carte.getNom()+" sur vous");
						System.out.println("Vous ne pourrez pas sacrifie vos cartes Guide Spirituel durant ce tour");
					}
					else {
					System.out.println("Le joueur_"+cibleAttaque.get(0).getIdJoueur()+" ne pourra pas sacrifier ses cartes Croyants durant ce tour");
					}				
			} else {
				carte.setSacrifiable(false);
				carte.setUtilisable(false);
			}
			break;
		case ("F_4"):
			for (int i = 0; i < Partie.rangJoueur.size(); i++) {
				if(carte.getType()=="Croyant"){
					if(Partie.rangJoueur.get(i).getLaMain().getListeCartesMain().size()>1){
						Partie.rangJoueur.get(i).setAttaquable(true);
					}
				}
				else if(carte.getType()=="DeusEx"){
					if(Partie.rangJoueur.get(i).getLaMain().getListeCartesMain().size()>2){
						Partie.rangJoueur.get(i).setAttaquable(true);
					}
				}
			}
			getCibleAttaque();
			if (cibleAttaque.isEmpty() == false) {
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
					System.out.println("Le Joueur_"+id+" a pris 3 cartes dans votre main");
				}
				else {
				System.out.println("Le Joueur_"+id+" a pris 3 cartes du Joueur_"+cibleAttaque.get(0).id);
			}
			}
			else {
				if(cibleAttaque.get(0).typeJoueur=="Joueur Physique"){
					System.out.println("Le Joueur_"+id+" a appliquÃ© la capcitÃ© spÃ©ciale de la carte "+ carte.getNom()+" sur vous");
					System.out.println("Le Joueur_"+id+" a pris 2 cartes dans votre main");
				}
				else {
				System.out.println("Le Joueur_"+id+" a pris 2 cartes du Joueur_"+cibleAttaque.get(0).id);}
			}
			}
			else {
				carte.setSacrifiable(false);
				carte.setUtilisable(false);
			}
			break;

		case ("F_5"):
			for (int i = 0; i < Partie.rangJoueur.size(); i++) {	
				if(Partie.rangJoueur.get(i).laMain.getlistePaireGuideVsCroyants().isEmpty()==false){
				Partie.rangJoueur.get(i).setAttaquable(true);
			}
			}
			getCibleAttaque();
			if (cibleAttaque.isEmpty() == false) {
			switch (carte.getOrigine()) {
			case "Jour":
				if(cibleAttaque.get(0).typeJoueur=="Joueur Physique"){
					System.out.println("Le Joueur_"+id+" a appliquÃ© la capcitÃ© spÃ©ciale de la carte "+ carte.getNom()+" sur vous");
					System.out.println("Vous devez sacrifier une de votre cartes Croyants");
				}
				CarteCroyants carteSacrifier = cibleAttaque.get(0).choisirCarteCroyantsASacrifier();
				cibleAttaque.get(0).sacrifierCarte(carteSacrifier, s);
				
				break;
			case "Neant":
				for (int i = 0; i < Partie.listeJoueur.size(); i++) {
					if (Partie.listeJoueur.get(i).getIdJoueur() != id) {
						if(Partie.listeJoueur.get(i).typeJoueur=="Joueur Physique"){
							System.out.println("Le Joueur_"+id+" a appliquÃ© la capcitÃ© spÃ©ciale de la carte "+ carte.getNom()+" sur vous");
							System.out.println("Vous devez sacrifier une de votre cartes Croyants");
						}
						CarteCroyants carteSacrifier1 = Partie.listeJoueur.get(i).choisirCarteCroyantsASacrifier();
						Partie.listeJoueur.get(i).sacrifierCarte(carteSacrifier1, s);

					}
				}
				break;
			}
			}
			else {
				carte.setSacrifiable(false);
				carte.setUtilisable(false);
			}
			break;
		case ("F_6"):
			for (int i = 0; i < Partie.rangJoueur.size(); i++) {
				if(Partie.rangJoueur.get(i).laMain.getlistePaireGuideVsCroyants().isEmpty()==false){
				Partie.rangJoueur.get(i).setAttaquable(true);
			}
			}
			getCibleAttaque();
			if (cibleAttaque.isEmpty() == false) {
			for (int i = 0; i < cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().size(); i++) {
				if(cibleAttaque.get(0).typeJoueur=="Joueur Physique"){
					System.out.println("Le Joueur_"+id+" a appliquÃ© la capcitÃ© spÃ©ciale de la carte "+ carte.getNom()+" sur vous");
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
						System.out.println("Toutes les cartes Croyants de votre carte Guide Spirituel "+choisirGuideSpirituelASacrifierDeEnemie(cibleAttaque.get(0)).getNom()+" ont Ã©tÃ© dÃ©faussÃ©es");
					}
					else {System.out.println("Toutes les cartes Croyants de la carte Guide Spirituel "+choisirGuideSpirituelASacrifierDeEnemie(cibleAttaque.get(0)).getNom()+" du Joueur_"+cibleAttaque.get(0).id+" ont Ã©tÃ© dÃ©faussÃ©es");
					}
					break;
				}
			}
			}
			else {
				carte.setSacrifiable(false);
				carte.setUtilisable(false);
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
					System.out.println("Le Joueur_"+id+" a appliquÃ© la capcitÃ© spÃ©ciale de la carte "+ carte.getNom()+" sur vous");
					System.out.println("Vous devez sacrifier une de votre cartes Guide Spirituel");
				}
				GuideSpirituel carteSacrifier = cibleAttaque.get(0).choisirGuideSpirituelASacrifier();
				cibleAttaque.get(0).sacrifierCarte(carteSacrifier, s);
			}
			else {
				carte.setSacrifiable(false);
				carte.setUtilisable(false);
			}
			break;
		case ("F_7"):
			DeCosmogonie de = new DeCosmogonie();
			System.out.println("Lancement le dÃ© de Cosmogonie...");
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
						System.out.println("Le Joueur_"+id+" a appliquÃ© la capcitÃ© spÃ©ciale de la carte "+ carte.getNom()+" sur vous");
						System.out.println("Vous pedrez votre points d'Action Ã  ce joueur");
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
			else {
				carte.setSacrifiable(false);
				carte.setUtilisable(false);
			}
			break;
		case ("F_9"):
			for (int i = 0; i < Partie.rangJoueur.size(); i++) {
				if (Partie.rangJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().isEmpty() == false) {
					Partie.rangJoueur.get(i).setAttaquable(true);
				}
			}
			getCibleAttaque();
			if (cibleAttaque.isEmpty() == false) {
			System.out.println("Le Joueur "+id+ "bÃ©nÃ©ficiera la capacitÃ© spÃ©ciale de la carte"+cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(0).get(0).getNom()+" du Joueur "+cibleAttaque.get(0).id );
			activerCapaciteSpeciale(cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(0).get(0), s);
			}
			else {
				carte.setSacrifiable(false);
				carte.setUtilisable(false);
			}
			break;
		case "F_10":
			for (int i = 0; i < Partie.listeJoueur.size(); i++) {
				if(Partie.listeJoueur.get(i).id!=this.id){
				Partie.listeJoueur.get(i).peutRecevoirPtAction = false;
			}
			}
			System.out.println("Jusqu'Ã  la fin du tour, plus aucun joueur ne reÃ§oit de points d'Action");
			break;
		case "F_11":
			Partie.setRangJoueur();
			int rang = Partie.rangJoueur.indexOf(this);
			if (Partie.listeJoueur.size() > 3) {
				if(rang==Partie.rangJoueur.size()-1){
					carte.setSacrifiable(false);
					carte.setUtilisable(false);
				}
				else{
					if(Partie.getEliminant()==null){
						carte.setSacrifiable(false);
						carte.setUtilisable(false);
					}
					else{ 
						if (Partie.getEliminant().typeJoueur == "Joueur Physique") {
					System.out.println("Vous Ãªtes Ã©liminÃ© car le joueur qui gagne le moins points de PriÃ¨res");
					Partie.listeJoueur.remove(Partie.getEliminant());
					Partie.rangJoueur.remove(Partie.getEliminant());
					Partie.nbrJoueurs -= 1;
					//System.exit(1);
				} else if (Partie.getEliminant().typeJoueur == "Joueur Virtuel") {
					System.out.println("Le Joueur_" + Partie.getEliminant().id
							+ " est Ã©liminÃ© car il est le joueur qui gagne le moins points de PriÃ¨res");
					Partie.listeJoueur.remove(Partie.getEliminant());
					Partie.rangJoueur.remove(Partie.getEliminant());
					Partie.nbrJoueurs -= 1;
					s.getStock().add(carte);
					this.laMain.getListeCartesMain().remove(carte);
					for (int i = 0; i < Partie.listeJoueur.indexOf(this); i++) {
						Partie.listeJoueur.add(Partie.listeJoueur.get(0));
						Partie.listeJoueur.remove(0);
					}
					Partie.tourDeJeu(s);
				}
					}
				}
			} else if (Partie.listeJoueur.size() < 4) {
				if(rang!=0){
					carte.setSacrifiable(false);
					carte.setUtilisable(false);
				}
				else{
					if(Partie.getGagnant()==null){
						carte.setSacrifiable(false);
						carte.setUtilisable(false);
					}
					else{
				if (Partie.getGagnant().typeJoueur == "Joueur Physique") {
					System.out.println("FÃ©licitation! Vous Ãªtes gagnÃ© !");
				} else if (Partie.getGagnant().typeJoueur == "Joueur Virtuel") {
					System.out.println("Joueur_" + Partie.getGagnant().id
							+ " est gagnÃ© car il est le joueur qui gagne le plus points PriÃ¨res.");
				}
				System.exit(1);
			}
				}
			}
			break;
		case "F_12":
			if(laMain.getlistePaireGuideVsCroyants().isEmpty()==false){
			for (int i = 0; i < laMain.getlistePaireGuideVsCroyants().size(); i++) {
				if (laMain.getlistePaireGuideVsCroyants().get(i).contains(choisirGuideSpirituelASacrifier())) {
					Integer pt = laMain.getlistePaireGuideVsCroyants().get(i).size() - 1;
					if (originDivin == "Jour") {
						ptActionJour += pt;
						System.out.println("Le Joueur "+id+" a reÃ§u "+pt+"points d'Action Jour");
					} else if (originDivin == "Nuit") {
						ptActionNuit += pt;
						System.out.println("Le Joueur "+id+" a reÃ§u "+pt+"points d'Action Nuit");
					} else if (originDivin == "Aube" || originDivin == "Crepuscule") {
						ptActionNeant += pt;
						System.out.println("Le Joueur "+id+" a reÃ§u "+pt+"points d'Action NÃ©ant");
					}
					break;

				}
			}
			}
			else {
				carte.setSacrifiable(false);
				carte.setUtilisable(false);
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
				System.out.println("Toutes les cartes Croyants d'origine NÃ©ant du joueur "+cibleAttaque.get(0).getIdJoueur()+" ont Ã©tÃ© sacrifiÃ©es");

			} 
			else {
				carte.setSacrifiable(false);
				carte.setUtilisable(false);
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
			else {
				carte.setSacrifiable(false);
				carte.setUtilisable(false);
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
					if(Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().size()>1){
					if (Arrays.asList(Partie.listeJoueur.get(i).dogmesDivin).contains("Humain")
							|| Arrays.asList(Partie.listeJoueur.get(i).dogmesDivin).contains("Symboles")) {
						Partie.listeJoueur.get(i).setAttaquable(true);
					}
				}
				}
			} else if (carte.getType() == "DeusEx") {
				for (int i = 0; i < Partie.listeJoueur.size(); i++) {
					if(Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().size()>1){
					Partie.listeJoueur.get(i).setAttaquable(true);
				}
				}
			}
			getCibleAttaque();
			if (cibleAttaque.isEmpty() == false) {
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
				System.out.println("Le Joueur "+cibleAttaque.get(0).id+" reprend dans sa main la carte Guide Spirituel "+carteGuide.getNom()+". Les Croyants qui y Ã©taient attachÃ©s sont dÃ©faussÃ©s.");
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
				carte.setUtilisable(false);
			}
			break;
		case "F_18":
			for (int i = 0; i < Partie.listeJoueur.size(); i++) {
				if (Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().isEmpty() == false) {
					Partie.listeJoueur.get(i).setAttaquable(true);
				}
			}
			getCibleAttaque();
			if (cibleAttaque.isEmpty() == false) {
			Carte maCarte = choisirGuideSpirituelASacrifier();
			Carte enemieCarte = choisirGuideSpirituelASacrifierDeEnemie(cibleAttaque.get(0));
			System.out.println("Le Joueur "+id+" a choisi de Ã©changer sa carte "+maCarte.getNom()+" avec la carte "+enemieCarte.getNom()+" du Joueur "+cibleAttaque.get(0).id);
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
			}
			else {
				carte.setSacrifiable(false);
				carte.setUtilisable(false);
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
				System.out.println("Le Joueur "+id+" pose le dÃ© de Cosmogonie sur la face Jour.");
			} else if (originDivin == "Nuit") {
				face = "Nuit";
				System.out.println("Le Joueur "+id+" pose le dÃ© de Cosmogonie sur la face Nuit.");

			} else if (originDivin == "Aube" || originDivin == "Crepuscule") {
				face = "Neant";
				System.out.println("Le Joueur "+id+" pose le dÃ© de Cosmogonie sur la face NÃ©ant.");

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
				if(Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().isEmpty()==false){
				for (int j = 0; j < Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().size(); j++) {
					if (Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j).get(0)
							.getOrigine() != carte.getOrigine()) {
						Partie.listeJoueur.get(i).setAttaquable(true);
						break;
					}
				}
			}
			}
			getCibleAttaque();
			if (cibleAttaque.isEmpty() == false) {
			for (int j = 0; j < cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().size(); j++) {
				if (cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(j).get(0).getOrigine() != carte
						.getOrigine()) {
					System.out.println("La carte Guide Spirituel "+cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(j).get(0).getNom()+" du Joueur "+cibleAttaque.get(0).id+" est dÃ©faussÃ©e. Les Croyants y attachÃ©s reviennent au centre de la table.");
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
			}
			else {
				carte.setSacrifiable(false);
				carte.setUtilisable(false);
			}
			break;
		case "F_23":
			for (int i = 0; i < Partie.getListeJoueur().size(); i++) {
				if(Partie.getListeJoueur().get(i).laMain.getlistePaireGuideVsCroyants().isEmpty()== false){
				Partie.getListeJoueur().get(i).setAttaquable(true);
				}
			}
			getCibleAttaque();
			if (cibleAttaque.isEmpty() == false) {
			for (int j = 0; j < cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().size(); j++) {
				if (choisirGuideSpirituelASacrifierDeEnemie(cibleAttaque.get(0)).getIdCarte() == cibleAttaque.get(0)
						.getLaMain().getlistePaireGuideVsCroyants().get(j).get(0).getIdCarte()) {
					laMain.getlistePaireGuideVsCroyants()
							.add(cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().get(j));
					cibleAttaque.get(0).getLaMain().getlistePaireGuideVsCroyants().remove(j);
					System.out.println("Le Joueur "+id+" a volÃ© la carte Guide Spirituel "+laMain.getlistePaireGuideVsCroyants().get(laMain.getlistePaireGuideVsCroyants().size()-1).get(0).getNom()+" et ses Croyants de Joueur "+cibleAttaque.get(0).id);
					this.calculerPtPrieres();
					break;
				}
			}
			}
			else {
				carte.setSacrifiable(false);
				carte.setUtilisable(false);
			}
			break;
		case "F_25":
			if(laMain.getlistePaireGuideVsCroyants().isEmpty()==false){
			System.out.print("Le Joueur "+id+" bÃ©nÃ©ficie la capacitÃ© spÃ©ciale de sa carte "+laMain.getlistePaireGuideVsCroyants().get(0).get(0).getNom());
			activerCapaciteSpeciale(laMain.getlistePaireGuideVsCroyants().get(0).get(0), s);
			}
			else {
				carte.setSacrifiable(false);
				carte.setUtilisable(false);
			}
			break;
		case "F_26":
			switch (carte.getNom()) {
			case "Influence Jour":
				if (carteJouee.getOrigine() == "Nuit" || carteJouee.getOrigine() == "Neant") {
					carteJouee.setAnnule(true);
					System.out.println("La capacitÃ© spÃ©ciale de la carte "+carteJouee.getNom()+" est annulÃ©Ã©");
				}
				break;
			case "Influence Nuit":
				if (carteJouee.getOrigine() == "Jour" || carteJouee.getOrigine() == "Neant") {
					carteJouee.setAnnule(true);
					System.out.println("La capacitÃ© spÃ©ciale de la carte "+carteJouee.getNom()+" est annulÃ©Ã©");
				}
				break;
			case "Influence Neant":
				if (carteJouee.getOrigine() == "Jour" || carteJouee.getOrigine() == "Nuit") {
					carteJouee.setAnnule(true);
					System.out.println("La capacitÃ© spÃ©ciale de la carte "+carteJouee.getNom()+" est annulÃ©Ã©");
				}
				break;
			case "Influence Nulle":
				carteJouee.setAnnule(true);
				System.out.println("La capacitÃ© spÃ©ciale de la carte "+carteJouee.getNom()+" est annulÃ©Ã©");
				break;
			}
			break;
		}

	}
}
