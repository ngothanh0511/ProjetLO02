package projet.joueur;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import projet.cartes.*;


public class JoueurPhysique extends Joueur{

	public JoueurPhysique(Integer id, Integer ptJour, Integer ptNuit, Integer ptNeant, Integer ptPriere) {
		super(id, ptJour, ptNuit, ptNeant, ptPriere);
		// TODO Auto-generated constructor stub
		this.id = id;
		this.ptActionJour = ptJour;
		this.ptActionNuit = ptNuit;
		this.ptActionNeant = ptNeant;
		this.ptPriere = ptPriere;
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
					defausserCarte(laMain.getListeCartesMain().get(i));
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
	
	public void activerCapaciteSpeciale(Carte carte){
		if (carte.getFamilleCapaciteSpeciale()== "F_1") {
			if (carte.getOrigine() =="Jour"){
				ptActionJour += 1;
			}
			else if (carte.getOrigine() =="Nuit"){
				ptActionNuit += 1;
			}
			else {
				ptActionNeant +=1;
			}
		
		}
		else if (carte.getFamilleCapaciteSpeciale() == "F_2"){
			int a;
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
			
		}
		else if (carte.getFamilleCapaciteSpeciale() == "F_3"){
			int a;
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
		}
		else if (carte.getFamilleCapaciteSpeciale() == "F_4"){
			int a;
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
		}
		else if (carte.getFamilleCapaciteSpeciale() == "F_5"){
			switch (carte.getOrigine()){
			case "Jour":
				int a;
				System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
				a = scan.nextInt();
				for (int i=0; i< Partie.listeJoueur.size();i++){
					if( a == Partie.listeJoueur.get(i).getIdJoueur()){
						CarteCroyants carteSacrifier = Partie.listeJoueur.get(i).choisirCarteCroyantsASacrifier();
						Partie.listeJoueur.get(i).sacrifierCarte(carteSacrifier);
						break;
					}
			}
				break;
			case "Neant":
				for (int i=0; i< Partie.listeJoueur.size();i++){
					if( Partie.listeJoueur.get(i).getIdJoueur()!= id){
						CarteCroyants carteSacrifier = Partie.listeJoueur.get(i).choisirCarteCroyantsASacrifier();
						Partie.listeJoueur.get(i).sacrifierCarte(carteSacrifier);
						break;
					}
			}
				break;
		}
		}
		else if (carte.getFamilleCapaciteSpeciale() == "F_6"){
			int a;
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
								StockCarte.getStock().add(Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k).get(0));
								break;
							}
							Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().remove(k);
							break;
						}
					}
				}
			}
		}
		else if (carte.getFamilleCapaciteSpeciale()== "F_30"){
			int a;
			System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
			a = scan.nextInt();
			for (int i=0; i< Partie.listeJoueur.size();i++){
				if( a == Partie.listeJoueur.get(i).getIdJoueur()){
					if ((Arrays.asList(((GuideSpirituel) carte).getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[0]) == true) ||
							((Arrays.asList(((GuideSpirituel) carte).getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[1]) == true)) ||
							((Arrays.asList(((GuideSpirituel) carte).getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[2]) == true))){
						GuideSpirituel carteSacrifier = Partie.listeJoueur.get(i).choisirGuideSpirituelASacrifier();
						Partie.listeJoueur.get(i).sacrifierCarte(carteSacrifier);
					}
				}
			}
		}
		else if (carte.getFamilleCapaciteSpeciale()== "F_7"){
			DeCosmogonie de = new DeCosmogonie();
			System.out.println("Lancement le dé de Cosmogonie...");
			de.resultatLancement();
			String resLance= de.getFace() ;
			for (int i=0;i<Partie.listeJoueur.size();i++){
				de.donnerPtAction(resLance, Partie.listeJoueur.get(i)); // J'ai changé le placement de tes codes et les mis dans la méthode donnerPtAction afon de pourvoir appliquer à tous les joueurs
			}
		}
		else if (carte.getFamilleCapaciteSpeciale()== "F_8"){
			
		}
		}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
	}

}
