package projet.joueur;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
	private static int nbrJoueurs;
	
	
	public void piocheDivinite(){
		String resDiv;
		/*int Div = new Random().nextInt(divinite.values().length);
		resDiv=divinite.values()[Div].name();//pour aggreger le nom du variable utilisÃƒÂ©
		*/
		resDiv=divinite.get(1);
		
		if(resDiv=="Yarstur"|| resDiv=="Drinded" || resDiv=="Brewalen"){
			originDivin="Jour";
			System.out.println(resDiv + " d'origine " + originDivin);
		}
		if(resDiv=="PuiTara" || resDiv=="Llewella" || resDiv=="Killinstred"){
			originDivin="Nuit";
			System.out.println(resDiv + " d'origine " + originDivin);
		}
		if(resDiv=="Gorpa" || resDiv=="Romtec"){
			originDivin="Crepuscule";
			System.out.println(resDiv + " d'origine " + originDivin);
		}
		if(resDiv=="Shingua" || resDiv=="Gwengbelen"){
			originDivin="Aube";
			System.out.println(resDiv + " d'origine " + originDivin);
		}
		
	};
	
	
	
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
			informer();
			for(int i=1;i<Partie.listeJoueur.size();i++){
				System.out.println("");
				System.out.print("Joueur_"+(i+1));
				Partie.listeJoueur.get(i).informer();
			}
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
		choisirCarte();
	}
	
	public void choisirCarte(){
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
						laMain.getListeCartesMain().get(i).activerFonctionCarte(this);
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
		}
		}
		
	}
	
	public void activerCapaciteSpeciale(Carte carte, StockCarte s){
		int a;
		switch (carte.getFamilleCapaciteSpeciale()){
		case ("F_1") :
			if (carte.getOrigine() =="Jour"){
				ptActionJour += 1;
			}
			else if (carte.getOrigine() =="Nuit"){
				ptActionNuit += 1;
			}
			else {
				ptActionNeant +=1;
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
						for (int j =0; j< Partie.listeJoueur.get(i).getLaMain().getListeCartesMain().size();j++){
							if (Partie.listeJoueur.get(i).getLaMain().getListeCartesMain().get(j).getType() == "GuideSpirituel"){
								Partie.listeJoueur.get(i).getLaMain().getListeCartesMain().get(j).setSacrifiable(false);
							}
							for (int k =0; k<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().size();k++ ){
									Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k).get(0).setSacrifiable(false);
							}
						}
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
			break;
		case "F_11":
			if(Partie.nbrJoueurs>3){
				if(Partie.getEliminant().typeJoueur=="Joueur Physique"){
					System.out.println("Vous êtes éliminé car le joueur qui gagne le moins points de Prières");
					Partie.listeJoueur.remove(Partie.getEliminant()); 
					Partie.nbrJoueurs-=1;
					System.exit(1);
				}
				else if(Partie.getEliminant().typeJoueur=="Joueur Virtuel"){
					System.out.println("Le Joueur_"+Partie.getEliminant().id+" est éliminé car il est le joueur qui gagne le moins points de Prières");
					Partie.listeJoueur.remove(Partie.getEliminant());
					Partie.nbrJoueurs -=1;
					for(int i =0; i< Partie.listeJoueur.indexOf(this);i++){
						Partie.listeJoueur.set(Partie.listeJoueur.size()-1, Partie.listeJoueur.get(0));
					}
					Partie.tourDeJeu(s);
				}
				
				
			}
			else if(Partie.nbrJoueurs<4){
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
					}
					else if (origine=="Nuit"){
						ptActionNuit+=pt;
					}
					else if(origine == "Neant"){
						ptActionNeant += pt;
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
					}
					break;
				}
			}
			break;
		case "F_29":
			System.out.println("Choisissez un des Guides Spirituels d'un autre joueur, et l'un des votres. Lancez le dé de Cosmogonie. Sur Jour, le Guide adverse est sacrifié, sur Nuit le votre est sacrifié, sur Néant rien ne se passe.");
			System.out.println("Lancement du dé....");
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
		case "F_14":
			for (int i=0; i< Partie.listeJoueur.size();i++){
				if(Arrays.asList(Partie.listeJoueur.get(i).getDogmesDivin()).contains("Chaos")== false){
					
				}
			}
		}
		}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
	}

}
