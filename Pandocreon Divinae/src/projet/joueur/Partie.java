package projet.joueur;

import projet.cartes.Carte;
import projet.cartes.GuideSpirituel;
import projet.cartes.StockCarte;
import projet.cartes.Tapis;
import projet.joueur.DeCosmogonie;
import projet.strategy.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Partie {

	static Scanner scan = new Scanner(System.in);
	protected static int nbrJoueurs=0;
	//protected static int nbrJV=0;
	protected static int tours=1;
	public static int jeton=1;
	protected static ArrayList <Joueur> listeJoueur = new ArrayList <Joueur>(); 
	protected static Random r = new Random();
	static int high=2;
	static int low=1;
	
	private  Partie(){
		
	}
	
	private static Partie partie = new Partie();
	
	public static Partie getInstance(){
		return partie;
	}
	
	public static Joueur getEliminant(){
		Joueur eliminant = listeJoueur.get(0);
		for (int i=1; i<listeJoueur.size();i++){
			if (listeJoueur.get(i).ptPriere< eliminant.ptPriere){
				eliminant = listeJoueur.get(i);
			}
		}
		return eliminant;
	}
	
	public static Joueur getGagnant(){
		Joueur gagnant = listeJoueur.get(0);
		for (int i=1; i<listeJoueur.size();i++){
			if (listeJoueur.get(i).ptPriere> gagnant.ptPriere){
				gagnant = listeJoueur.get(i);
			}
		}
		return gagnant;
	}
	public boolean estTermine(){
		return true;
	}
	
	public static ArrayList<Joueur> getListeJoueur(){
		return listeJoueur;
	}
	public static void setNbrJoueurs(){
		
		int a=7;
		
		while(a>5){//pour eviter l'utilisateur de mettre joueurs virtuels plus de 6
			System.out.println("Combien de joueur que vous voulez jouer avec (max 5 joueurs) ?");
			a = scan.nextInt();
		}
		nbrJoueurs += a;//il faut qu'on met ça dehors de while, sinon il y aura des bugs
		for (int i=0;i<a;i++){//pareil comme ci dessus
			JoueurVirtuel joueur = new JoueurVirtuel(i+2,0,0,0,0,new Normal());//JV normal par defaut changement a cause de strategy
			listeJoueur.add(joueur);
			Main m2 = new Main();
			joueur.setLaMain(m2);
		}
	}
//	public JV creerJV(){
		
//	}
	
//	public Strategie setStrategie(){
		
//	}
	
	public void donnerDivinite(){
		
	}
	
	public static  void tourDeJeu(StockCarte s){
		DeCosmogonie de = new DeCosmogonie();
		System.out.println("Tour " + tours);
		System.out.println("Lancement le dé de Cosmogonie...");
		Collections.shuffle(Arrays.asList(de.face));
		de.resultatLancement();
		String resLance= de.getFace();
		for (int i=0;i<(nbrJoueurs+1);i++){//changement
			de.donnerPtAction(resLance, listeJoueur.get(i)); // J'ai changé le placement de tes codes et les mis dans la méthode donnerPtAction afon de pourvoir appliquer à tous les joueurs
		}
		
		int iterations = nbrJoueurs+2;//chaque tour, la personne suivante qui lance le dé
		for (int i = 0; i < iterations - 1; i++) {
		    int value = (i + (tours-1)) % (iterations - 1);//on cherche le modulo afin de repeter la valeur 
			int Result = r.nextInt(high-low +1) + 1;
			if(value!=0){    
				if(Result==1){
			    	((JoueurVirtuel) listeJoueur.get(value)).setMode(new Agressif());
			    }
			    if(Result==2){
			    	((JoueurVirtuel) listeJoueur.get(value)).setMode(new Defenssif());
			    }
			}
		    System.out.println(value + " ");
		    listeJoueur.get(value).jouerSonTour(s);
		        
		}
		
		//for(int i=0;i<nbrJoueurs+1;i++){//changement
		//	listeJoueur.get(i).jouerSonTour(s );//ici chaque joueur va jouer son tour
		//listeJoueur.add(listeJoueur.get(i));
		//listeJoueur.remove(i);
		//}
		
		
		for(int i=0; i<nbrJoueurs+1;i++){//changement
			listeJoueur.get(i).peutRecevoirPtAction = true;
		}
		/// Réinitialiser Carte.estSacrifiable = true
		tours+=1;
		tourDeJeu(s);
	}
	
	public static void main(String[] args) {
		StockCarte s = new StockCarte();
		Collections.shuffle(Joueur.divinite);
		Tapis tap = new Tapis(); 
		JoueurPhysique phy = new JoueurPhysique(1,0,0,0,0);
		listeJoueur.add(phy);
		setNbrJoueurs();
		Scanner reponse = new Scanner(System.in);
		
		System.out.println("Choisissez la difficulté de Joueurs Virtuels (Facile(F)/Difficile(D))? ");
		switch (reponse.nextLine()){
		case ("F"):
			System.out.println("Changement en mode agressif....");
			for (int i=1;i<listeJoueur.size();i++){
				((JoueurVirtuel) listeJoueur.get(i)).setMode(new Defenssif());
			}
			break;
		case ("D"):
			System.out.println("Changement en mode agressif....");
			for (int i=1;i<listeJoueur.size();i++){
				((JoueurVirtuel) listeJoueur.get(i)).setMode(new Agressif());
			}
			//reponse.close();
			break;
		}
			
	//	Scanner reponse = new Scanner(System.in);
	//	System.out.println("Vous voulez commencer le jeu (O/N)? ");  // Je ne vois pas l'intérêt d'avoir ces étapes...
	//	String rep=reponse.nextLine();
	//	if(rep.equals("O")){
			
			System.out.println("Bonjour, "+ JoueurPhysique.setNom()+ " vous avez choisi " + nbrJoueurs + " joueurs virtuels à jouer avec.");
			System.out.print("Votre Divinité est ");
			phy.piocheDivinite();
			Main m1 = new Main();
			phy.setLaMain(m1);
			for (int i=1;i<listeJoueur.size();i++){
				System.out.print("Divinité de Joueur_"+listeJoueur.get(i).id +" est ");
				listeJoueur.get(i).piocheDivinite();
			}
			for (int i=0;i<listeJoueur.size();i++){
				s.distribuerCartes(listeJoueur.get(i).getLaMain());
			}
			
			/************************************************************/
			System.out.println(((JoueurVirtuel) listeJoueur.get(2)).tryStrat());
			
			
			/***********************************************/
			
			
			tourDeJeu(s);
		
		
	}
		
	
}
