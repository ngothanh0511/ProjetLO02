package projet.joueur;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import projet.cartes.*;


public class JoueurPhysique extends Joueur{

	public JoueurPhysique( Integer id, Integer ptJour, Integer ptNuit, Integer ptNeant, Integer ptPriere) {
		super(id, ptJour, ptNuit, ptNeant, ptPriere);
		// TODO Auto-generated constructor stub
		this.id = id;
		this.ptActionJour = ptJour;
		this.ptActionNuit = ptNuit;
		this.ptActionNeant = ptNeant;
		this.ptPriere = ptPriere;
		this.typeJoueur= "Joueur Physique";
	}



	static Scanner scan = new Scanner(System.in);
	static Scanner nom = new Scanner(System.in);
	
	
	
	public void commencerJeu(){
		
	}
	
	public void abandonnerJeu(){
		
	}
	
	public void choisirMode(){
		
	}
	
	public static String setNom(){
		System.out.println("Mettez votre nom : ");
		return nom.nextLine();
		
	}
	
	public void informer(){
		System.out.print("Vous avez: ");
		System.out.print(ptActionJour + " points Action Jour, ");
		System.out.print(ptActionNuit + " points Action Nuit, ");
		System.out.println(ptActionNeant + " points Action Neant");
		System.out.println("Vous avez gagné: " + ptPriere+" points Prières");
		System.out.println("Vous avez dans la main les cartes suivantes:");
		  for (int i=0; i< laMain.getListeCartesMain().size(); i++){
			   System.out.println(laMain.getListeCartesMain().get(i).afficherCarte());
		   }
	}
	
	public static int setNbrJoueurs(){
		
		int a=7;
		while(a>5){//pour eviter l'utilisateur de mettre joueurs virtuels plus de 6
			System.out.println("Combien de joueur que vous voulez jouer avec (max 5 joueurs) ?");
			a = scan.nextInt();
		}
		return a;
	}
	
	public void sauvegarderJeu(){
		
	}
	
	
	public GuideSpirituel choisirGuideSpirituelASacrifier(){
		int a;
		GuideSpirituel carte = null;
		System.out.println("Mettez l'ID de la carte à sacrifier:");
		a = scan.nextInt();
		for (int i=0; i< laMain.getListeCartesMain().size();i++){
			if(a==laMain.getListeCartesMain().get(i).getIdCarte()){
				carte= (GuideSpirituel) laMain.getListeCartesMain().get(i);
				break;
			}
		}
		return carte;
	}
	
	public CarteCroyants choisirCarteCroyantsASacrifier(){
		int a;
		CarteCroyants carte = null;
		System.out.println("Mettez l'ID de la carte à sacrifier:");
		a = scan.nextInt();
		for (int i=0; i< laMain.getListeCartesMain().size();i++){
			if(a==laMain.getListeCartesMain().get(i).getIdCarte()){
				carte= (CarteCroyants) laMain.getListeCartesMain().get(i);
				break;
			}
		}
		return carte; 
	}
	
	public void jouerSonTour(StockCarte s){
		s.distribuerCartes(laMain);
		int id;
		while (laMain.getListeCartesMain().size()>0){
			for(int i=0;i<Partie.listeJoueur.size();i++){
				if(Partie.listeJoueur.get(i).typeJoueur=="Joueur Virtuel"){
				System.out.println("");
				System.out.print("Joueur_"+(i+1));
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
		choisirCarte(s);
	}
	
	public void choisirCarte(StockCarte s){
		int id;
		while (laMain.getListeCartesMain().size() >0){
			informer();
		System.out.println("Mettez l'id de la carte à jouer! Tapez 0 si vous voulez terminer votre tour! ");
		id = scan.nextInt();
		if (id == 0){
			for (int i = 0; i< Tapis.getListeCartesCroyantsIndisponible().size();i++){
				Tapis.getListeCartesCroyants().add(Tapis.getListeCartesCroyantsIndisponible().get(i));
				Tapis.getListeCartesCroyantsIndisponible().remove(i);
			}
			break;
		}
		else{
			for (int i=0; i<laMain.getListeCartesMain().size(); i++){
				if (laMain.getListeCartesMain().get(i).getIdCarte()==id){
					laMain.getListeCartesMain().get(i).getUtilisable(this);
					if (laMain.getListeCartesMain().get(i).utilisee()==true){
						System.out.println("Vous avez joué la carte c_ "+ laMain.getListeCartesMain().get(i).getIdCarte());
						carteJouee = laMain.getListeCartesMain().get(i);
						laMain.getListeCartesMain().get(i).activerFonctionCarte(this,s);
						laMain.getListeCartesMain().get(i).calculerPtAction(this);
						if (laMain.getListeCartesMain().get(i).utilisee()== true){
							laMain.getListeCartesMain().remove(i);
						}
						
					}
					else {
						System.out.println("La carte que vous choissiez n'est pas utilisable!");
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
		}
		}
		
	}
	
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
					System.out.println("Mettez l'ID de la carte Guide Spirituel qui contient les cartes Croyants seront défaussées:");
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
							System.out.println("Toutes les cartes Croyants de la carte Guide Spirituel "+Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k).get(0).getNom()+" du Joueur_"+Partie.listeJoueur.get(i).id+" ont été défaussées");
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
			System.out.println("Lancement le dé de Cosmogonie...");
			de.resultatLancement();
			String resLance= de.getFace() ;
			for (int i=0;i<Partie.listeJoueur.size();i++){
				de.donnerPtAction(resLance, Partie.listeJoueur.get(i)); // J'ai changé le placement de tes codes et les mis dans la méthode donnerPtAction afon de pourvoir appliquer à tous les joueurs
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
					System.out.println("Joueur_"+a+" possède les cartes Croyants suivant: ");
					for (int j=0;j<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().size();j++){
						for (int k=1; k<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j).size();k++){
					System.out.println(Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j).get(k).afficherCarte());
						}
					}
					System.out.println("Mettez l'ID de la carte Croyants que vous voulez bénéficer sa capacité spéciale:");
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
				Partie.listeJoueur.get(i).peutRecevoirPtAction= false;
			}
			System.out.println("Jusqu'à la fin du tour, plus aucun joueur ne reçoit de points d'Action");
			break;
		case "F_11":
			if(Partie.listeJoueur.size()>3){
				if(Partie.getEliminant().typeJoueur=="Joueur Physique"){
					System.out.println("Vous êtes éliminé car le joueur qui gagne le moins points de Prières");
					Partie.listeJoueur.remove(Partie.getEliminant()); 
					Partie.rangJoueur.remove(Partie.getEliminant());
					Partie.nbrJoueurs-=1;
					System.exit(1);
				}
				else if(Partie.getEliminant().typeJoueur=="Joueur Virtuel"){
					System.out.println("Le Joueur_"+Partie.getEliminant().id+" est éliminé car il est le joueur qui gagne le moins points de Prières");
					Partie.listeJoueur.remove(Partie.getEliminant());
					Partie.nbrJoueurs -=1;
					for(int i =0; i< Partie.listeJoueur.indexOf(this);i++){
						Partie.listeJoueur.add(Partie.listeJoueur.get(0));
						Partie.listeJoueur.remove(0);
					}
					Partie.tourDeJeu(s);
				}
				
				
			}
			else if(Partie.listeJoueur.size()<4){
				if(Partie.getGagnant().typeJoueur=="Joueur Physique"){
					System.out.println("Félicitation! Vous êtes gagné !");
				}
				else if(Partie.getGagnant().typeJoueur=="Joueur Virtuel"){
					System.out.println("Joueur_"+Partie.getGagnant().id+" est gagné car il est le joueur qui gagne le plus points Prières.");
				}
				System.exit(1);
			}
			break;
		case "F_12":
			System.out.println("Choisir l'origine pour les points Action gagnés (Jour,Nuit,Neant):");
			for(int i=0;i<laMain.getlistePaireGuideVsCroyants().size();i++){
				if(laMain.getlistePaireGuideVsCroyants().get(i).contains(carte)){
					Integer pt= laMain.getlistePaireGuideVsCroyants().get(i).size()-1;
					String origine = scan.nextLine();
					if(origine=="Jour"){
						ptActionJour+= pt;
						System.out.println("Vous avez reçu "+pt+"points d'Action Jour");
					}
					else if (origine=="Nuit"){
						ptActionNuit+=pt;
						System.out.println("Vous avez reçu "+pt+"points d'Action Nuit");
					}
					else if(origine == "Neant"){
						ptActionNeant += pt;
						System.out.println("Vous avez reçu "+pt+"points d'Action Néant");
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
						System.out.println("Toutes les cartes Croyants d'origine Néant du joueur "+Partie.listeJoueur.get(i).getIdJoueur()+" ont été sacrifiées");
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
						System.out.println("Le Joueur "+Partie.listeJoueur.get(i).id+" reprend dans sa main la carte Guide Spirituel "+carteGuide.getNom()+". Les Croyants qui y étaient attachés sont défaussés.");
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
					System.out.println("Mettez l'ID de votre carte Guide Spirituel que vous voulez échanger:");
					int b = scan.nextInt();
					for(int j=0;j<laMain.getlistePaireGuideVsCroyants().size();j++){
						if (laMain.getlistePaireGuideVsCroyants().get(j).get(0).getIdCarte()==b){
							System.out.println("Mettez l'ID de la carte Guide Spirituel de Joueur_"+a+" que vous voulez échanger:");
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
			System.out.println("Choisir la face du dé Cosmogonie que vous souhaitez (Jour,Nuit,Neant):");
			String face = scan.nextLine();
			for(int i=0;i<Partie.listeJoueur.size();i++){
				DeCosmogonie de1= new DeCosmogonie();
				de1.donnerPtAction(face, Partie.listeJoueur.get(i));
			}
			for(int i =0; i< Partie.listeJoueur.indexOf(this);i++){
				Partie.listeJoueur.set(Partie.listeJoueur.size()-1, Partie.listeJoueur.get(0));
			}
			Partie.tourDeJeu(s);
			break;
		case "F_21":
			System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
			a = scan.nextInt();
			for (int i=0; i< Partie.listeJoueur.size();i++){
				if( a == Partie.listeJoueur.get(i).getIdJoueur()){
					System.out.println("Mettez l'ID de la carte Guide Spirituel de Joueur_"+a+" que vous voulez défausser:");
					int b=scan.nextInt();
					for(int j=0;j<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().size();j++){
						if(b==Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j).get(0).getIdCarte()){
							if(Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j).get(0).getOrigine()!= carte.getOrigine()){
								System.out.println("La carte Guide Spirituel "+Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j).get(0).getNom()+" du Joueur "+Partie.listeJoueur.get(i).id+" est défaussée. Les Croyants y attachés reviennent au centre de la table.");
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
							System.out.println("Vous avez volé la carte Guide Spirituel "+Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(j).get(0).getNom()+" et ses Croyants de Joueur "+Partie.listeJoueur.get(i).id);

							break;
						}
					}
					break;
				}
			}
			break;
		case "F_25":
			System.out.println("Mettez l'ID de la carte Croyants ou Guide Spirituel que vous voulez bénéficer sa capacité spéciale:");
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
					System.out.println("La capacité spéciale de la carte "+carteJouee.getNom()+" est annuléé");
				}
				break;
			case "Influence Nuit":
				if(carteJouee.getOrigine()=="Jour"|| carteJouee.getOrigine()=="Neant"){
					carteJouee.setAnnule(true);
					System.out.println("La capacité spéciale de la carte "+carteJouee.getNom()+" est annuléé");
				}
				break;
			case "Influence Neant":
				if(carteJouee.getOrigine()=="Jour"|| carteJouee.getOrigine()=="Nuit"){
					carteJouee.setAnnule(true);
					System.out.println("La capacité spéciale de la carte "+carteJouee.getNom()+" est annuléé");
				}
				break;
			case "Influence Nulle":
				carteJouee.setAnnule(true);
				System.out.println("La capacité spéciale de la carte "+carteJouee.getNom()+" est annuléé");
				break;
			} 
		}
		}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
	}

}
