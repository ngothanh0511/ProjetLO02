package projet.joueur;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import projet.cartes.*;


public class JoueurPhysique extends Joueur{

	static Scanner scan = new Scanner(System.in);
	static Scanner nom = new Scanner(System.in);
	private static int nbrJoueurs;
	
	
	public void piocheDivinite(){
		String resDiv;
		int Div = new Random().nextInt(divinite.values().length);
		resDiv=divinite.values()[Div].name();//pour aggreger le nom du variable utilisÃ©
		
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
	
	public void setOriginDivin(String originDivin) {
	       this.originDivin = originDivin;
	    }

	public String getOriginDivin() {
	       return originDivin;
	}
	
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
	
	public void defausserCarte(){
		int i;
		while (laMain.getListeCartesMain().size()>0){
			MontrerLaMain();
			System.out.println("Mettez ID de la carte que vous voulez défausser! Tapez 0 si vous ne voulez pas défausser votre cartes!");
			i= scan.nextInt();
			if (i==0){
				break;
			}
			else{
				for(int k=0;k<laMain.getListeCartesMain().size();k++){
					if (i==laMain.getListeCartesMain().get(k).getIdCarte()){
						StockCarte.getStock().add(laMain.getListeCartesMain().get(k));
						laMain.getListeCartesMain().remove(k);
					}
				}
			}
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
	public  void MontrerLaMain(){
		   System.out.println("Vous avez dans la main les cartes suivantes:");
		  for (int i=0; i< laMain.getListeCartesMain().size(); i++){
		  // 	for (Iterator<Carte> it = laMain.getListeCartesMain().iterator(); it.hashNext();)
		   			
			   System.out.println(laMain.getListeCartesMain().get(i).afficherCarte());
		   }
	   }
	
	
	public void choisirCarte(){
		int id;
		while (laMain.getListeCartesMain().size() >0){
			MontrerLaMain();
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
	
	public void sacrifierCarteCroyants(CarteCroyants carte){
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
					if ((Arrays.asList(carte.getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[0]) == false) &&
							((Arrays.asList(carte.getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[1]) == false)) &&
							((Arrays.asList(carte.getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[2]) == false))){
						for (int j =0; j< Partie.listeJoueur.get(i).getLaMain().getListeCartesMain().size();j++){
							for (int k =0; k<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().size();k++ ){
								for (int h=1; h<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k).size();h++){
									Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k).get(h).setSacrifiable(false);
								}
								
							}
						}
					}
				}
			}
			
		}
		else if (carte.getFamilleCapaciteSpeciale() == "F_3"){
			int a;
			System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
			a = scan.nextInt();
			for (int i=0; i< Partie.listeJoueur.size();i++){
				if( a == Partie.listeJoueur.get(i).getIdJoueur()){
					if ((Arrays.asList(carte.getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[0]) == false) &&
							((Arrays.asList(carte.getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[1]) == false)) &&
							((Arrays.asList(carte.getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[2]) == false))){
						for (int j =0; j< Partie.listeJoueur.get(i).getLaMain().getListeCartesMain().size();j++){
							if (Partie.listeJoueur.get(i).getLaMain().getListeCartesMain().get(j).getType() == "GuideSpirituel"){
								Partie.listeJoueur.get(i).getLaMain().getListeCartesMain().get(j).setSacrifiable(false);
							}
							for (int k =0; k<Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().size();k++ ){
									Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k).get(0).setSacrifiable(false);
							}
						}
					}
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
				}
			}
		}
		 
		}
	
	public void sacrifierGuideSpirituel(GuideSpirituel carte){
		if (carte.getFamilleCapaciteSpeciale()== "F_3"){
			int a;
			System.out.println("Mettez l'ID du joueur que vous vouslez appliquer cet effet sur");
			a = scan.nextInt();
			for (int i=0; i< Partie.listeJoueur.size();i++){
				if( a == Partie.listeJoueur.get(i).getIdJoueur()){
					if ((Arrays.asList(carte.getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[0]) == true) ||
							((Arrays.asList(carte.getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[1]) == true)) ||
							((Arrays.asList(carte.getDogmes()).contains(Partie.listeJoueur.get(i).dogmesDivin[2]) == true))){
						GuideSpirituel carteSacrifie;
						for (int k =0; k< Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().size();k++){
							if(Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k).size()>
									Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k+1).size()){
								Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().add(k+2,Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(k));
								Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().remove(k);
							}
						}
						Partie.listeJoueur.get(i).sacrifierGuideSpirituel((GuideSpirituel) Partie.listeJoueur.get(i).getLaMain().getlistePaireGuideVsCroyants().get(0).get(0));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
	}

}
