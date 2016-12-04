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
	protected static int tours=1;
	public static int jeton=1;
	protected static ArrayList <Joueur> listeJoueur = new ArrayList <Joueur>(); 
	protected static ArrayList <Joueur> rangJoueur = new ArrayList<Joueur>();
	protected static Random r = new Random();
	static int high=2;
	static int low=1;
	
	private  Partie(){
		
	}
	
	private static Partie partie = new Partie();
	
	public static Partie getInstance(){
		return partie;
	}
	
	public void setRangJoueur(){
		for(int i=0;i<rangJoueur.size();i++){
			
		}
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
			nbrJoueurs += a;
			for (int i=0;i<a;i++){
				JoueurVirtuel joueur = new JoueurVirtuel(i+2,0,0,0,0);
				listeJoueur.add(joueur);
				rangJoueur.add(joueur);
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
		for (int i=0;i<(listeJoueur.size());i++){
			de.donnerPtAction(resLance, listeJoueur.get(i)); // J'ai changé le placement de tes codes et les mis dans la méthode donnerPtAction afon de pourvoir appliquer à tous les joueurs
		}
		for(int i=0;i<listeJoueur.size();i++){
			listeJoueur.get(0).jouerSonTour(s );
			listeJoueur.add(listeJoueur.get(0));
			listeJoueur.remove(0);
		}
		listeJoueur.add(listeJoueur.get(0));
		listeJoueur.remove(0);
		for(int i=0; i<listeJoueur.size();i++){ 
			listeJoueur.get(i).peutRecevoirPtAction = true;
		}
		/// Réinitialiser Carte.estSacrifiable = true
		tours+=1;
		tourDeJeu(s);
	}
	
	public static void main(String[] args) {
		StockCarte s = new StockCarte();
		Collections.shuffle(Joueur.divinite);
		JoueurPhysique phy = new JoueurPhysique(1,0,0,0,0);
		listeJoueur.add(phy);
		rangJoueur.add(phy);
		Scanner reponse = new Scanner(System.in);
			setNbrJoueurs();
			System.out.println("Choisissez la difficultÃ© de Joueurs Virtuels (Facile(F)/Difficile(D))? ");
		for (int i=1;i<listeJoueur.size();i++){
			System.out.println("Mode Joueur" + (i+1));
			switch (reponse.nextLine()){
			case ("F"):
				((JoueurVirtuel) listeJoueur.get(i)).setTypeDif("f");
				((JoueurVirtuel) listeJoueur.get(i)).setMode(new Defenssif());
				
				break;
			case ("D"):
				((JoueurVirtuel) listeJoueur.get(i)).setTypeDif("d");
				((JoueurVirtuel) listeJoueur.get(i)).setMode(new Agressif());
				
				//reponse.close();
				break;
			}
		}
		System.out.println(((JoueurVirtuel) listeJoueur.get(1)).getTypeDif());
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
			tourDeJeu(s);
		
		
	}
		
	
}
