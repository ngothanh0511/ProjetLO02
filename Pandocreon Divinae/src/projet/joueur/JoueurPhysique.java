package projet.joueur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import projet.cartes.*;
import projet.vueGraphique.Principal;

/**
 * Cette classe représente le joueur physique dans le jeu
 * 
 *
 */
public class JoueurPhysique extends Joueur{
	/**
	 * Constructeur de la classe JoueurPhysique
	 * @param id
	 * @param ptJour
	 * @param ptNuit
	 * @param ptNeant
	 * @param ptPriere
	 */
	public JoueurPhysique( Integer id, Integer ptJour, Integer ptNuit, Integer ptNeant, Integer ptPriere) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.ptActionJour = ptJour;
		this.ptActionNuit = ptNuit;
		this.ptActionNeant = ptNeant;
		this.ptPriere = ptPriere;
		this.typeJoueur= "Joueur Physique";
	}


	private boolean estJoueSonTour = false;
	private int a =0;
	public int geta(){
		return a;
	}
	public void seta(int value){
		a = value;
	}
	static Scanner scan = new Scanner(System.in);
	static Scanner nom = new Scanner(System.in);
	//private static int nbrJoueurs;
	/**
	 * Le joueur physique saisit son nom
	 * @return
	 */
	public static String setNom(){
		System.out.println("Mettez votre nom : ");
		return nom.nextLine();
		
	}
	/**
	 * Setter de l'attribue estJoueSonTour
	 * @param value
	 */
	public void setEstJoueSonTour(boolean value){
		this.estJoueSonTour = value;
	}
	/**
	 * Getter de l'attribue estJoueSonTour
	 * @return
	 */
	public boolean getEstJoueSonTour(){
		return estJoueSonTour;
	}
	/**
	 * L'affichage des informations nécessaires pour le joueur physique
	 */
	public void informer(){
		System.out.println("");
		System.out.print("Vous ( divinite d'origin "+this.getOriginDivin()+" :rang "+Partie.getNumRang(this)+") avez: ");
		System.out.print(ptActionJour + " points Action Jour, ");
		System.out.print(ptActionNuit + " points Action Nuit, ");
		System.out.println(ptActionNeant + " points Action Neant");
		System.out.println("Vous avez gagné: " + ptPriere+" points Prières");
		if(this.laMain.getlistePaireGuideVsCroyants().isEmpty()==false){
			System.out.println("Vous possedez:");
			for (int i=0;i<this.laMain.getlistePaireGuideVsCroyants().size();i++){
				System.out.println("");
				System.out.println(this.laMain.getlistePaireGuideVsCroyants().get(i).get(0).afficherCarte()+" qui rattache:");
				for(int j=1;j<this.laMain.getlistePaireGuideVsCroyants().get(i).size();j++){
					System.out.println(this.laMain.getlistePaireGuideVsCroyants().get(i).get(j).afficherCarte());
				}
			}
			}
		if(Tapis.getListeCartesCroyants().isEmpty()==false){
		System.out.println("\nLes cartes Croyants disponible à récupérer sur le tapis sont:");
		for (int i=0; i< Tapis.getListeCartesCroyants().size();i++){
			System.out.println(Tapis.getListeCartesCroyants().get(i).afficherCarte());
		}
		}
		System.out.println("\nVous avez dans la main les cartes suivantes:");
		  for (int i=0; i< laMain.getListeCartesMain().size(); i++){
			   System.out.println(laMain.getListeCartesMain().get(i).afficherCarte());
		   }
	}
	
/*	public static int setNbrJoueurs(){
		
		int a=7;
		while(a>5){//pour eviter l'utilisateur de mettre joueurs virtuels plus de 6
			System.out.println("Combien de joueur que vous voulez jouer avec (max 5 joueurs) ?");
			a = scan.nextInt();
		}
		return a;
	}*/
	/**
	 * L'action choisir une carte Guide Spirituel à sacrifier quand le joueur est obligé à sacrifier 
	 * suite à la capacité spéciale d'un autre carte qui est activée par un opponant
	 */
	public GuideSpirituel choisirGuideSpirituelASacrifier(){
		int a;
		GuideSpirituel carte = null;
		System.out.println("Mettez l'ID de la carte à  sacrifier:");
		a = scan.nextInt();
		for (int i=0; i< laMain.getListeCartesMain().size();i++){
			if(a==laMain.getListeCartesMain().get(i).getIdCarte()){
				carte= (GuideSpirituel) laMain.getListeCartesMain().get(i);
				break;
			}
		}
		return carte;
	}
	/**
	 * L'action choisir une carte Croyants à sacrifier quand le joueur est obligé à sacrifier 
	 * suite à la capacité spéciale d'un autre carte qui est activée par un opponant
	 */
	public CarteCroyants choisirCarteCroyantsASacrifier(){
		int a;
		CarteCroyants carte = null;
		System.out.println("Mettez l'ID de la carte à  sacrifier:");
		a = scan.nextInt();
		for (int i=0; i< laMain.getListeCartesMain().size();i++){
			if(a==laMain.getListeCartesMain().get(i).getIdCarte()){
				carte= (CarteCroyants) laMain.getListeCartesMain().get(i);
				break;
			}
		}
		return carte; 
	}
	/**
	 * Le joueur joue son tour
	 */
	public void jouerSonTour(StockCarte s){
	//	s.distribuerCartes(laMain);
		Principal.getInstance().getJouerCarte().setEnabled(true);
		Principal.getInstance().getDefausserCarte().setEnabled(true);
		Principal.getInstance().getTerminerSonTour().setEnabled(true);
		Principal.getInstance().getDetail().setText(Principal.getInstance().getDetail().getText()+" \n Votre tour, Choisissez une action!");
		while(Partie.getInstance().getEstJoueSonTour()==false){
		/*		Principal.getInstance().getJouerCarte().addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Principal.getInstance().getControlleur().Button_on_click_JouerCarte(e);
	            }
	        });
			Principal.getInstance().getTerminerSonTour().addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	    //        	Principal.getInstance().getControlleur().Button_on_click_TerminerSonTour(e);
	      //      	Principal.getInstance().getTerminerSonTour().setEnabled(true);
	           	for (int i = 0; i< Tapis.getListeCartesCroyantsIndisponible().size();i++){
	    				Tapis.getListeCartesCroyants().add(Tapis.getListeCartesCroyantsIndisponible().get(i));
	    				Tapis.getListeCartesCroyantsIndisponible().remove(i);
	            	}
	            	Principal.getInstance().getDetail().setText(Principal.getInstance().getDetail().getText()+"    \n  Vous avez terminé votre tour! ");
	    			Partie.getInstance().setEstJoueSonTour(true);              }
	        });
			Principal.getInstance().getDefausserCarte().addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Principal.getInstance().getControlleur().Button_on_click_DefausserCarte(e);
	            }
	        });  */
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		int id;
		
	/*	while (laMain.getListeCartesMain().size()>0){
			/*for(int i=0;i<Partie.listeJoueur.size();i++){
				if(Partie.listeJoueur.get(i).typeJoueur=="Joueur Virtuel"){
				System.out.println("");
				System.out.print("Joueur_"+(Partie.listeJoueur.get(i).id));
				Partie.listeJoueur.get(i).informer();
				}
			}
			informer();
			System.out.println("Mettez l'ID de la carte que vous voulez défausser! Si vous ne vouslez pas défausser plus de carte, tapez 0!");
			id = scan.nextInt();
		if (id==0){
			break;
		}
		else {
			for(int i =0;i<laMain.getListeCartesMain().size();i++){
				if (id==laMain.getListeCartesMain().get(i).getIdCarte()){
					defausserCarte(laMain.getListeCartesMain().get(i),s);
					break;
				}
			} 
		}
		}
		s.distribuerCartes(laMain);
		choisirCarte(s); */
		
		/// GRAPHIQUE
/*		if (estJoueSonTour==false){
		//	Partie.getInstance().updateVue();
			Principal.getInstance().setVisible(true);
		}
		else {
			passerTour();
	} */
		
	}
	
public void commencerTour(){
	DeCosmogonie de = new DeCosmogonie();
	System.out.println("***********************************Tour " + Partie.tours+"*************************");
	System.out.println("Lancement le dé de Cosmogonie...");
	Collections.shuffle(Arrays.asList(de.face));
	de.resultatLancement();
	String resLance= de.getFace();
	for (int i=0;i<(Partie.getInstance().getListeJoueur().size());i++){
		de.donnerPtAction(resLance, Partie.getInstance().getListeJoueur().get(i)); 
	}
	for(int j=0;j<Partie.getInstance().getListeJoueur().size();j++){
		if(Partie.getInstance().getListeJoueur().get(0).getTypeJoueur()=="Joueur Physique"){
			break;
		}
		Partie.getInstance().getListeJoueur().get(0).jouerSonTour(Partie.getInstance().getStockCarte());
		Partie.getInstance().getListeJoueur().add(Partie.getInstance().getListeJoueur().get(0));
		Partie.getInstance().getListeJoueur().remove(0);
		a++;
		}
		jouerSonTour(Partie.getInstance().getStockCarte());
}
	public void terminerTour(){
		estJoueSonTour = false;
		Partie.getInstance().getListeJoueur().add(Partie.getInstance().getListeJoueur().get(0));
		Partie.getInstance().getListeJoueur().remove(0);
		a=0;
	for(int j=0;j<Partie.getInstance().getListeJoueur().size();j++){
		Partie.getInstance().getListeJoueur().get(j).calculerPtPrieres();
		Partie.getInstance().getListeJoueur().get(j).peutRecevoirPtAction = true;
		for(int k=0; k<Partie.getInstance().getListeJoueur().get(j).getLaMain().getlistePaireGuideVsCroyants().size();k++){
			for(int h=0;h<Partie.getInstance().getListeJoueur().get(j).getLaMain().getlistePaireGuideVsCroyants().get(k).size();h++){
				Partie.getInstance().getListeJoueur().get(j).getLaMain().getlistePaireGuideVsCroyants().get(k).get(h).setSacrifiable(true);
			}
		}
	}
	Partie.setRangJoueur();
	Partie.tours+=1;
	}
	public void passerTour(){
 		for(int i=0;i<Partie.getInstance().getListeJoueur().size();i++){
 			if(a==Partie.getInstance().getListeJoueur().size()){
 				terminerTour();
 				commencerTour();
				break;
			}
 			if(Partie.getInstance().getListeJoueur().get(0).getTypeJoueur()=="Joueur Physique"){
 				break;
 			}
			Partie.getInstance().getListeJoueur().get(0).jouerSonTour(Partie.getInstance().getStockCarte());
			Partie.getInstance().getListeJoueur().add(Partie.getInstance().getListeJoueur().get(0));
			Partie.getInstance().getListeJoueur().remove(0);
			a++;
			if(a==Partie.getInstance().getListeJoueur().size()){
				
			/// RÃƒÂ©initialiser Carte.estSacrifiable = true
			terminerTour();
			commencerTour();
				break;
			}
		}
		jouerSonTour(Partie.getInstance().getStockCarte());
	}
	/** 
	 * Le joueur choisit la carte d'Action à jouer
	 */
	public void choisirCarte( Carte c, StockCarte s){
		int id= c.getIdCarte();
		boolean fin = false;
/*		while (laMain.getListeCartesMain().size() >0){
		informer();
		do{
			try{	
				Scanner rep = new Scanner(System.in);
				System.out.println("Mettez l'id de la carte à  jouer ou à  sacrifier! Tapez 0 si vous voulez terminer votre tour! ");
				id = rep.nextInt();
				fin=true;
			}catch(InputMismatchException e){
				System.out.println("L'ID INVALID!");
			}
		}while(fin==false);
		if (id == 0){
			for (int i = 0; i< Tapis.getListeCartesCroyantsIndisponible().size();i++){
				Tapis.getListeCartesCroyants().add(Tapis.getListeCartesCroyantsIndisponible().get(i));
				Tapis.getListeCartesCroyantsIndisponible().remove(i);
			}
			break;
		}
		else{*/
			for (int i=0; i<laMain.getListeCartesMain().size(); i++){
				if (laMain.getListeCartesMain().get(i).getIdCarte()==id){
					laMain.getListeCartesMain().get(i).getUtilisable(this);
					if (laMain.getListeCartesMain().get(i).utilisee()==true){
						System.out.println("Vous avez joué la carte c_ "+ laMain.getListeCartesMain().get(i).getNom());
						carteJouee = laMain.getListeCartesMain().get(i);
						laMain.getListeCartesMain().get(i).activerFonctionCarte(this,s);
						laMain.getListeCartesMain().get(i).calculerPtAction(this);
						if (laMain.getListeCartesMain().get(i).utilisee()== true){
					 		if(laMain.getListeCartesMain().get(i).getType()=="DeusEx"||laMain.getListeCartesMain().get(i).getType()=="Apocalypse"){
					 				s.getStock().add(laMain.getListeCartesMain().get(i));
					 		}
							laMain.getListeCartesMain().remove(i);
						}
						
					}
					else {
						System.out.println("La carte que vous choissiez n'est pas utilisable!");
						Principal.getInstance().getDetail().setText(Principal.getInstance().getDetail().getText()+"\n La carte que vous choissiez n'est pas utilisable!");
					}
				}
			}
			for(int i=0;i<laMain.getlistePaireGuideVsCroyants().size();i++){
				for(int j=0;j<laMain.getlistePaireGuideVsCroyants().get(i).size();j++){
					if(laMain.getlistePaireGuideVsCroyants().get(i).get(j).getIdCarte()==id){
						sacrifierCarte(laMain.getlistePaireGuideVsCroyants().get(i).get(j),s);
					}
				}
				
					
				
			}
			Partie.getInstance().updateVue();
		}
//		}
		
//	}
	/**
	 * Cette méthode active la capactié spéciale de la carte quand elle est utilisée pour une carte DeusEx et Apocalypse
	 * ou quand elle est sacrifiée pour une carte Croyants ou Guide Spirituel
	 */
	public void activerCapaciteSpeciale(Carte carte, StockCarte s){
		int a;
		switch (carte.getFamilleCapaciteSpeciale()){
		case ("F_1") :
			if (carte.getOrigine() =="Jour"){
				ptActionJour += 1;
				System.out.println("Vous avez reçu 1 point d'Action Jour");
			}
			else if (carte.getOrigine() =="Nuit"){
				ptActionNuit += 1;
				System.out.println("Vous avez reçu 1 point d'Action Nuit");
			}
			else {
				ptActionNeant +=1;
				System.out.println("Vous avez reçu 1 point d'Action Néant");
			}
			break;
		
		case ("F_2"):
			
			System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
			a = scan.nextInt();
			for (int i=0; i< Partie.listeJoueur.size();i++){
				if( a == Partie.listeJoueur.get(i).getIdJoueur()){
					if ((Arrays.asList(((CarteCroyants) carte).getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[0]) == false) &&
							((Arrays.asList(((CarteCroyants)carte).getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[1]) == false)) &&
							((Arrays.asList(((CarteCroyants)carte).getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[2]) == false))){
							for (int k =0; k<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().size();k++ ){
								for (int h=1; h<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k).size();h++){
									Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k).get(h).setSacrifiable(false);
								}
								
							}
							System.out.println("Le joueur_"+Partie.listeJoueur.get(i).getIdJoueur()+" ne pourra pas sacrifier ses cartes Croyants durant ce tour");
						
					}
					else {
						System.out.println("Cette capacité spéciale n'est pas applicable avec le joueur"+Partie.listeJoueur.get(i).getIdJoueur());
					}
					break;
				}
			
			
		}
			break;
	case ("F_3"):
			
			System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
			a = scan.nextInt();
			for (int i=0; i< Partie.listeJoueur.size();i++){
				if( a == Partie.listeJoueur.get(i).getIdJoueur()){
					if ((Arrays.asList(((CarteCroyants)carte).getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[0]) == false) &&
							((Arrays.asList(((CarteCroyants)carte).getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[1]) == false)) &&
							((Arrays.asList(((CarteCroyants)carte).getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[2]) == false))){
						
							for (int k =0; k<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().size();k++ ){
									Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k).get(0).setSacrifiable(false);
							}
							System.out.println("Le joueur"+Partie.listeJoueur.get(i).getIdJoueur()+"ne pourra pas sacrifier ses cartes Guide Spirituel durant ce tour");
					}
					else{
						System.out.println("Cette capacité spéciale n'est pas applicable avec le joueur"+Partie.listeJoueur.get(i).getIdJoueur());

					}
					
					break;
				}
			}
		break;
		case ("F_4"):
			
			System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
			a = scan.nextInt();
			for (int i=0; i< Partie.listeJoueur.size();i++){
				if( a == Partie.listeJoueur.get(i).getIdJoueur()){
					Collections.shuffle(Partie.listeJoueur.get(i).getLaMain().getListeCartesMain());
					laMain.getListeCartesMain().add(Partie.listeJoueur.get(i).getLaMain().getListeCartesMain().get(0));
					laMain.getListeCartesMain().add(Partie.listeJoueur.get(i).getLaMain().getListeCartesMain().get(1));
					Partie.listeJoueur.get(i).getLaMain().getListeCartesMain().remove(0);
					Partie.listeJoueur.get(i).getLaMain().getListeCartesMain().remove(0);
					if(carte.getType()=="DeusEx"){
						laMain.getListeCartesMain().add(Partie.listeJoueur.get(i).getLaMain().getListeCartesMain().get(0));
						Partie.listeJoueur.get(i).getLaMain().getListeCartesMain().remove(0);
						System.out.println("Vous avez pris 3 cartes dans la main de Joueur_"+Partie.listeJoueur.get(i).id);
					}
					else{					
						System.out.println("Vous avez pris 2 cartes dans la main de Joueur_"+Partie.listeJoueur.get(i).id);
					}

					break;
				}
			}
		break;
		case ("F_5"):
			switch (carte.getOrigine()){
			case "Jour":
				
				System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
				a = scan.nextInt();
				for (int i=0; i< Partie.listeJoueur.size();i++){
					if( a == Partie.listeJoueur.get(i).getIdJoueur()){
						CarteCroyants carteSacrifier = Partie.listeJoueur.get(i).choisirCarteCroyantsASacrifier();
						Partie.listeJoueur.get(i).sacrifierCarte(carteSacrifier,s);
						break;
					}
			}
				break;
			case "Neant":
				for (int i=0; i< Partie.listeJoueur.size();i++){
					if( Partie.listeJoueur.get(i).getIdJoueur()!= id){
						CarteCroyants carteSacrifier = Partie.listeJoueur.get(i).choisirCarteCroyantsASacrifier();
						Partie.listeJoueur.get(i).sacrifierCarte(carteSacrifier,s);
					break;
					}
			}
				break;
		}
		break;
		case ("F_6"):
			
			System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
			a = scan.nextInt();
			for (int i=0; i< Partie.listeJoueur.size();i++){
				if( a == Partie.listeJoueur.get(i).getIdJoueur()){
					Partie.listeJoueur.get(i).afficherListePairGuideVsCroyants();
					System.out.println("Mettez l'ID de la carte Guide Spirituel qui contient les cartes Croyants seront dÃ©faussÃ©es:");
					int b;
					b = scan.nextInt();
					for (int k=0; k<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().size();k++){
						if (b==Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k).get(0).getIdCarte()){
							for (int h=1;h<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k).size();h++){
								Tapis.getListeCartesCroyants().add(((CarteCroyants) Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k).get(h)));
								
							}
							switch (carte.getOrigine()){
							case "Jour":
								Partie.listeJoueur.get(i).getLaMain().getListeCartesMain().add(Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k).get(0));
								break;
							case "Nuit":
								s.getStock().add(Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k).get(0));
								break;
							}
							Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().remove(k);
							System.out.println("Toutes les cartes Croyants de la carte Guide Spirituel "+Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k).get(0).getNom()+" du Joueur_"+Partie.listeJoueur.get(i).id+" ont Ã©tÃ© dÃ©faussÃ©es");
							break;
						}
					}
				}
			}
			break;
		
		case ("F_30"):
			
			System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
			a = scan.nextInt();
			for (int i=0; i< Partie.listeJoueur.size();i++){
				if( a == Partie.listeJoueur.get(i).getIdJoueur()){
					if ((Arrays.asList(((GuideSpirituel) carte).getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[0]) == true) ||
							((Arrays.asList(((GuideSpirituel) carte).getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[1]) == true)) ||
							((Arrays.asList(((GuideSpirituel) carte).getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[2]) == true))){
						GuideSpirituel carteSacrifier = Partie.listeJoueur.get(i).choisirGuideSpirituelASacrifier();
						Partie.listeJoueur.get(i).sacrifierCarte(carteSacrifier,s);
					}
				}
			}
		break;
		case ("F_7"):
			DeCosmogonie de = new DeCosmogonie();
			System.out.println("Lancement le dÃ© de Cosmogonie...");
			de.resultatLancement();
			String resLance= de.getFace() ;
			for (int i=0;i<Partie.listeJoueur.size();i++){
				de.donnerPtAction(resLance, Partie.listeJoueur.get(i)); // J'ai changÃ© le placement de tes codes et les mis dans la mÃ©thode donnerPtAction afon de pourvoir appliquer Ã  tous les joueurs
			}
		break;
		case ("F_8"):
			
			System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
			a = scan.nextInt();
			for (int i= (Partie.listeJoueur.indexOf(this))+1; i<Partie.listeJoueur.size();i++){
				if( a == Partie.listeJoueur.get(i).getIdJoueur()){
					int ptJour = ptActionJour + Partie.listeJoueur.get(i).getPtActionJour();
					setPtActionJour(ptJour);
					Partie.listeJoueur.get(i).setPtActionJour(0);
					int ptNuit = ptActionNuit + Partie.listeJoueur.get(i).getPtActionNuit();
					setPtActionJour(ptNuit);
					Partie.listeJoueur.get(i).setPtActionNuit(0);
					int ptNeant = ptActionNeant + Partie.listeJoueur.get(i).getPtActionNeant();
					setPtActionJour(ptNeant);
					Partie.listeJoueur.get(i).setPtActionNeant(0);
					break;
				}
			}
		break;
		case ("F_9"):
			
			System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
			a = scan.nextInt();
			for (int i=0; i< Partie.listeJoueur.size();i++){
				if( a == Partie.listeJoueur.get(i).getIdJoueur()){
					System.out.println("Joueur_"+a+" possÃ¨de les cartes Croyants suivant: ");
					for (int j=0;j<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().size();j++){
						for (int k=1; k<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j).size();k++){
					System.out.println(Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j).get(k).afficherCarte());
						}
					}
					System.out.println("Mettez l'ID de la carte Croyants que vous voulez bÃ©nÃ©ficer sa capacitÃ© spÃ©ciale:");
					int b;
					b = scan.nextInt();
					for (int j=0;j<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().size();j++){
						for (int k=1; k<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j).size();k++){
							if(b==Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j).get(k).getIdCarte()){
								activerCapaciteSpeciale(Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j).get(k),s);
								break;
							}
						}
						
					}	
				}
			}
			break;
		case "F_10":
			for(int i=0; i< Partie.listeJoueur.size();i++){
				if(Partie.listeJoueur.get(i).id!=this.id){
				Partie.listeJoueur.get(i).peutRecevoirPtAction= false;
			}
			}
			System.out.println("Jusqu'Ã  la fin du tour, plus aucun joueur ne reÃ§oit de points d'Action");
			break;
		case "F_11":
			if(Partie.listeJoueur.size()>3){
				if(Partie.getEliminant()!= null){
				if(Partie.getEliminant().typeJoueur=="Joueur Physique"){
					System.out.println("Vous Ãªtes Ã©liminÃ© car le joueur qui gagne le moins points de PriÃ¨res");
					Partie.listeJoueur.remove(Partie.getEliminant()); 
					Partie.rangJoueur.remove(Partie.getEliminant());
					Partie.nbrJoueurs-=1;
					System.exit(1);
				}
				else if(Partie.getEliminant().typeJoueur=="Joueur Virtuel"){
					System.out.println("Le Joueur_"+Partie.getEliminant().id+" est Ã©liminÃ© car il est le joueur qui gagne le moins points de PriÃ¨res");
					Partie.listeJoueur.remove(Partie.getEliminant());
					Partie.nbrJoueurs -=1;
					s.getStock().add(carte);
					this.laMain.getListeCartesMain().remove(carte);
					for(int i =0; i< Partie.listeJoueur.indexOf(this);i++){
						Partie.listeJoueur.add(Partie.listeJoueur.get(0));
						Partie.listeJoueur.remove(0);
					}
					Partie.getInstance().tourDeJeu(s);
				}
				}
				else{ System.out.println("La carte n'a pas effect car il n'y pas le joueur qui gagne le moins points de PriÃ¨res ");}
				
			}
			else if(Partie.listeJoueur.size()<4){
				if(Partie.getGagnant()!= null){
				if(Partie.getGagnant().typeJoueur=="Joueur Physique"){
					System.out.println("FÃ©licitation! Vous Ãªtes gagnÃ© !");
				}
				else if(Partie.getGagnant().typeJoueur=="Joueur Virtuel"){
					System.out.println("Joueur_"+Partie.getGagnant().id+" est gagnÃ© car il est le joueur qui gagne le plus points PriÃ¨res.");
				}
				System.exit(1);
				}
				else{ System.out.println("La carte n'a pas effect car il n'y pas le joueur qui gagne le plus points de PriÃ¨res ");}
			}
			break;
		case "F_12":
			System.out.println("Choisir l'origine pour les points Action gagnÃ©s (Jour,Nuit,Neant):");
			for(int i=0;i<laMain.getlistePaireGuideVsCroyants().size();i++){
				if(laMain.getlistePaireGuideVsCroyants().get(i).contains(carte)){
					Integer pt= laMain.getlistePaireGuideVsCroyants().get(i).size()-1;
					String origine = scan.nextLine();
					if(origine=="Jour"){
						ptActionJour+= pt;
						System.out.println("Vous avez reÃ§u "+pt+"points d'Action Jour");
					}
					else if (origine=="Nuit"){
						ptActionNuit+=pt;
						System.out.println("Vous avez reÃ§u "+pt+"points d'Action Nuit");
					}
					else if(origine == "Neant"){
						ptActionNeant += pt;
						System.out.println("Vous avez reÃ§u "+pt+"points d'Action NÃ©ant");
					}
					break;
				
			}
			
			}
			break;
		case "F_13":
			System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
			a = scan.nextInt();
			for (int i=0; i< Partie.listeJoueur.size();i++){
				if( a == Partie.listeJoueur.get(i).getIdJoueur()){
					if(Arrays.asList(Partie.listeJoueur.get(i).getDogmesDivin()).contains("Humain")){
						for(int j=0;j<Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().size();j++){
							for(int k=1;k<Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j).size();k++){
								if(Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j).get(k).getOrigine()=="Neant"){
									Partie.listeJoueur.get(i).sacrifierCarte(Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j).get(k),s);
								}
							}
						}
						System.out.println("Toutes les cartes Croyants d'origine NÃ©ant du joueur "+Partie.listeJoueur.get(i).getIdJoueur()+" ont Ã©tÃ© sacrifiÃ©es");
					}
					break;
				}
			}
			break;
		case "F_14":
			System.out.println("Mettez l'ID de la carte Guide Spirituel que vous voulez appliquer cet effet sur");
			a =scan.nextInt();
			for (int i=0; i< Partie.listeJoueur.size();i++){
				for(int j=0;j<Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().size();j++){
					if(Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j).get(0).getIdCarte()==a){
						if((Arrays.asList(Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j).get(0)).contains("Chaos")== false)
							|| (Arrays.asList(Partie.listeJoueur.get(i).getDogmesDivin()).contains("Chaos")== false)){
							Partie.listeJoueur.get(i).sacrifierCarte(Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j).get(0), s);
						}
						break;
					}
				}
				
			}
		case "F_15":
			Iterator<CarteCroyants> it = Tapis.getListeCartesCroyants().iterator();
			while (it.hasNext()){
				if((Arrays.asList(((CarteCroyants) it).getDogmes()).contains("Nature"))&&((((CarteCroyants) it).getOrigine()=="Nuit")||(((CarteCroyants) it).getOrigine()=="Neant"))){
					s.getStock().add((CarteCroyants) it);
					it.next();
					it.remove();
				}
				
			}
			Iterator<CarteCroyants> it1 = Tapis.getListeCartesCroyantsIndisponible().iterator();
			while (it1.hasNext()){
				if((Arrays.asList(((CarteCroyants) it1).getDogmes()).contains("Nature"))&&((((CarteCroyants) it1).getOrigine()=="Nuit")||(((CarteCroyants) it1).getOrigine()=="Neant"))){
					s.getStock().add((CarteCroyants) it1);
					it1.next();
					it1.remove();
				}
				
			}
			break;
		case "F_16":
			System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
			a = scan.nextInt();
			for (int i=0; i< Partie.listeJoueur.size();i++){
				if( a == Partie.listeJoueur.get(i).getIdJoueur()){
					if(carte.getType()=="GuideSpirituel"){
					if(Arrays.asList(Partie.listeJoueur.get(i).dogmesDivin).contains("Humain") 
							||Arrays.asList(Partie.listeJoueur.get(i).dogmesDivin).contains("Symboles")){
						for(int l=1; l<3;l++){
						System.out.println("Mettez l'ID de la "+ l+" ième carte Croyants que vous voulez le Joueur_"+Partie.listeJoueur.get(i).id+" sacrifie:");
						int b= scan.nextInt();
						for (int j=0;j<Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().size();j++){
							for(int k=1;k<Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j).size();k++){
								if( b==Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j).get(k).getIdCarte()){
									Partie.listeJoueur.get(i).sacrifierCarte(Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j).get(k), s);
								}
							}
						}
					}
					}	
					else {
						System.out.println("Le joueur que vous choissiez ne possède pas dogme Humain ou Symbole!");
					}
					
					}
					else if(carte.getType()=="DeusEx"){
						for(int l=1; l<3;l++){
							System.out.println("Mettez l'ID de la "+ l+" iÃ¨me carte Croyants que vous voulez le Joueur_"+Partie.listeJoueur.get(i).id+" sacrifie:");
							int b= scan.nextInt();
							for (int j=0;j<Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().size();j++){
								for(int k=1;k<Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j).size();k++){
									if( b==Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j).get(k).getIdCarte()){
										Partie.listeJoueur.get(i).sacrifierCarte(Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j).get(k), s);
									}
								}
							}
						}
					}
					break;
				}
			} 
			break;
		case "F_17":
			System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
			a = scan.nextInt();
			for (int i=0; i< Partie.listeJoueur.size();i++){
				if( a == Partie.listeJoueur.get(i).getIdJoueur()){
					if((Arrays.asList(Partie.listeJoueur.get(i).dogmesDivin).contains("Mystique") 
							&&Arrays.asList(Partie.listeJoueur.get(i).dogmesDivin).contains("Chaos"))||(Partie.listeJoueur.get(i).originDivin =="Nuit")) {
						Carte carteGuide= Partie.listeJoueur.get(i).choisirGuideSpirituelASacrifier();
						System.out.println("Le Joueur "+Partie.listeJoueur.get(i).id+" reprend dans sa main la carte Guide Spirituel "+carteGuide.getNom()+". Les Croyants qui y Ã©taient attachÃ©s sont dÃ©faussÃ©s.");
						Partie.listeJoueur.get(i).laMain.getListeCartesMain().add(carteGuide);
						for(int j=0;j<Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().size();j++){
							if(Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j).get(0).getIdCarte()== carteGuide.getIdCarte()){
								for(int k=1;k<Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j).size();k++){
									s.getStock().add(Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().get(j).get(k));
								}
								Partie.listeJoueur.get(i).laMain.getlistePaireGuideVsCroyants().remove(j);
								break;
							}
							
						}
					}
					break;
				}	
			}	
			break;
		case "F_18":
			System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
			a = scan.nextInt();
			for (int i=0; i< Partie.listeJoueur.size();i++){
				if( a == Partie.listeJoueur.get(i).getIdJoueur()){
					System.out.println("Mettez l'ID de votre carte Guide Spirituel que vous voulez Ã©changer:");
					int b = scan.nextInt();
					for(int j=0;j<laMain.getlistePaireGuideVsCroyants().size();j++){
						if (laMain.getlistePaireGuideVsCroyants().get(j).get(0).getIdCarte()==b){
							System.out.println("Mettez l'ID de la carte Guide Spirituel de Joueur_"+a+" que vous voulez Ã©changer:");
							int c=scan.nextInt();
							for(int k=0;k<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().size();k++){
								if(c==Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k).get(0).getIdCarte()){
									laMain.getlistePaireGuideVsCroyants().add(0,laMain.getlistePaireGuideVsCroyants().get(j) );
									laMain.getlistePaireGuideVsCroyants().remove(j+1);
									laMain.getlistePaireGuideVsCroyants().add(Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k));
									Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().add(0,Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k) );
									Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().remove(k+1);
									Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().add(laMain.getlistePaireGuideVsCroyants().get(j));
									laMain.getlistePaireGuideVsCroyants().remove(0);
									Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().remove(0);
									break;
								}
							}
							break;
						}
					}
					break;
				}
			}
			break;
		case "F_19":
			Iterator<CarteCroyants> it2 =Tapis.getListeCartesCroyants().iterator();
			while (it2.hasNext()){
				if((Arrays.asList(((CarteCroyants) it2).getDogmes()).contains("Mystique"))){
					s.getStock().add((CarteCroyants) it2);
					it2.next();
					it2.remove();
				}
				
			}
			Iterator<CarteCroyants> it3 = Tapis.getListeCartesCroyantsIndisponible().iterator();
			while (it3.hasNext()){
				if((Arrays.asList(((CarteCroyants) it3).getDogmes()).contains("Mystique"))){
					s.getStock().add((CarteCroyants) it3);
					it3.next();
					it3.remove();
				}
				
			}
			break;
		case "F_20":
			System.out.println("Choisir la face du dÃ© Cosmogonie que vous souhaitez (Jour,Nuit,Neant):");
			String face = scan.nextLine();
			for(int i=0;i<Partie.listeJoueur.size();i++){
				DeCosmogonie de1= new DeCosmogonie();
				de1.donnerPtAction(face, Partie.listeJoueur.get(i));
			}
			for(int i =0; i< Partie.listeJoueur.indexOf(this);i++){
				Partie.listeJoueur.set(Partie.listeJoueur.size()-1, Partie.listeJoueur.get(0));
			}
			Partie.getInstance().tourDeJeu(s);
			break;
		case "F_21":
			System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
			a = scan.nextInt();
			for (int i=0; i< Partie.listeJoueur.size();i++){
				if( a == Partie.listeJoueur.get(i).getIdJoueur()){
					System.out.println("Mettez l'ID de la carte Guide Spirituel de Joueur_"+a+" que vous voulez dÃ©fausser:");
					int b=scan.nextInt();
					for(int j=0;j<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().size();j++){
						if(b==Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j).get(0).getIdCarte()){
							if(Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j).get(0).getOrigine()!= carte.getOrigine()){
								System.out.println("La carte Guide Spirituel "+Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j).get(0).getNom()+" du Joueur "+Partie.listeJoueur.get(i).id+" est dÃ©faussÃ©e. Les Croyants y attachÃ©s reviennent au centre de la table.");
								for(int k=1;k<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j).size();k++){
									Tapis.getListeCartesCroyants().add((CarteCroyants) Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j).get(k));
								}
								s.getStock().add(Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j).get(0));
								Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().remove(j);
							}
							break;
						}
					}
					break;
				}
			}
			break;
		case "F_23":
			System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
			a = scan.nextInt();
			for (int i=0; i< Partie.listeJoueur.size();i++){
				if( a == Partie.listeJoueur.get(i).getIdJoueur()){
					System.out.println("Mettez l'ID de la carte Guide Spirituel de Joueur_"+a+" que vous voulez voler:");
					int b=scan.nextInt();
					for(int j=0;j<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().size();j++){
						if(b==Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j).get(0).getIdCarte()){
							laMain.getlistePaireGuideVsCroyants().add(Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j));
							Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().remove(j);
							System.out.println("Vous avez volÃ© la carte Guide Spirituel "+laMain.getlistePaireGuideVsCroyants().get(laMain.getlistePaireGuideVsCroyants().size()-1).get(0).getNom()+" et ses Croyants de Joueur "+Partie.listeJoueur.get(i).id);
							this.calculerPtPrieres();
							break;
						}
					}
					break;
				}
			}
			break;
		case "F_25":
			System.out.println("Mettez l'ID de la carte Croyants ou Guide Spirituel que vous voulez bÃ©nÃ©ficer sa capacitÃ© spÃ©ciale:");
			int b;
			b = scan.nextInt();
			for (int j=0;j<laMain.getlistePaireGuideVsCroyants().size();j++){
				for (int k=0; k<laMain.getlistePaireGuideVsCroyants().get(j).size();k++){
					if(b==laMain.getlistePaireGuideVsCroyants().get(j).get(k).getIdCarte()){
						activerCapaciteSpeciale(laMain.getlistePaireGuideVsCroyants().get(j).get(k),s);
						break;
					}
				}
			}
			break; 
		case "F_26":
			switch (carte.getNom()){
			case "Influence Jour":
				if(carteJouee.getOrigine()=="Nuit"|| carteJouee.getOrigine()=="Neant"){
					carteJouee.setAnnule(true);
					System.out.println("La capacitÃ© spÃ©ciale de la carte "+carteJouee.getNom()+" est annulÃ©Ã©");
				}
				break;
			case "Influence Nuit":
				if(carteJouee.getOrigine()=="Jour"|| carteJouee.getOrigine()=="Neant"){
					carteJouee.setAnnule(true);
					System.out.println("La capacitÃ© spÃ©ciale de la carte "+carteJouee.getNom()+" est annulÃ©Ã©");
				}
				break;
			case "Influence Neant":
				if(carteJouee.getOrigine()=="Jour"|| carteJouee.getOrigine()=="Nuit"){
					carteJouee.setAnnule(true);
					System.out.println("La capacitÃ© spÃ©ciale de la carte "+carteJouee.getNom()+" est annulÃ©Ã©");
				}
				break;
			case "Influence Nulle":
				carteJouee.setAnnule(true);
				System.out.println("La capacitÃ© spÃ©ciale de la carte "+carteJouee.getNom()+" est annulÃ©Ã©");
				break;
			} 
		case "F_29":
			System.out.println("Choisissez un des Guides Spirituels d'un autre joueur, et l'un des votres. Lancez le dÃ© de Cosmogonie. Sur Jour, le Guide adverse est sacrifiÃ©, sur Nuit le votre est sacrifiÃ©, sur NÃ©ant rien ne se passe.");
			System.out.println("Lancement du dÃ©....");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DeCosmogonie dice1 = new DeCosmogonie();
			Collections.shuffle(Arrays.asList(dice1.face));
			dice1.resultatLancement();
			String resLance3= dice1.getFace();
			
			if(resLance3.equals("Jour")){
				System.out.println("Vous voulez choisir les guides spirituels de quel joueur? ");
				int h2 = scan.nextInt();
				for(int i=0;i< Partie.listeJoueur.get(h2).getLaMain().getListeCartesMain().size();i++){	
			
					if(Partie.listeJoueur.get(h2).getLaMain().getListeCartesMain().get(i).getType().equals("GuideSpirituel")){
						System.out.println(Partie.listeJoueur.get(h2).getLaMain().getListeCartesMain().get(i).afficherCarte());
					}

				}
				System.out.println("Mettez l'ID de la carte que vous voulez choisir! S'il y a rien, le joueur n'a pas de carte de type GuideSpirituel, donc, tape 0 pour continuer");
				
				GuideSpirituel carteSacrifier = Partie.listeJoueur.get(h2).choisirGuideSpirituelASacrifier();
				Partie.listeJoueur.get(h2).sacrifierCarte(carteSacrifier,s);
			}
			if(resLance3.equals("Nuit")){
				System.out.println("Vous voulez choisir quels GuideSpirituels parmi tes cartes? ");
				for(int i=0;i< Partie.listeJoueur.get(0).getLaMain().getListeCartesMain().size();i++){	
					
					if(Partie.listeJoueur.get(0).getLaMain().getListeCartesMain().get(i).getType().equals("GuideSpirituel")){
						System.out.println(Partie.listeJoueur.get(0).getLaMain().getListeCartesMain().get(i).afficherCarte());
					}

				}
				GuideSpirituel carteSacrifier = Partie.listeJoueur.get(0).choisirGuideSpirituelASacrifier();//.getLaMain().getListeCartesMain().get(idDeux)
				Partie.listeJoueur.get(0).sacrifierCarte(carteSacrifier,s);
			}
			
			break;
		}
		}
	
	
	
	

}
