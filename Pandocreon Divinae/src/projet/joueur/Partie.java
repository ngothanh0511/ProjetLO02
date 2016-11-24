package projet.joueur;

import projet.cartes.Carte;
import projet.cartes.StockCarte;
import projet.joueur.DeCosmogonie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Partie {

	static Scanner scan = new Scanner(System.in);
	private static int nbrJoueurs=1;
	protected static int tours=1;
	protected static ArrayList <Joueur> listeJoueur = new ArrayList <Joueur>(); 
	
	
	private  Partie(){
		
	}
	
	private static Partie partie = new Partie();
	
	public static Partie getInstance(){
		return partie;
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
			nbrJoueurs += a;
			for (int i=0;i<a;i++){
				JoueurVirtuel joueur = new JoueurVirtuel(i+2,0,0,0,0);
				listeJoueur.add(joueur);
				Main m2 = new Main();
				joueur.setLaMain(m2);
			}
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
		for (int i=0;i<(nbrJoueurs);i++){
			de.donnerPtAction(resLance, listeJoueur.get(i)); // J'ai changé le placement de tes codes et les mis dans la méthode donnerPtAction afon de pourvoir appliquer à tous les joueurs
		}
		for(int i=0;i<nbrJoueurs;i++){
			listeJoueur.get(0).jouerSonTour(s );
		listeJoueur.add(listeJoueur.get(0));
		listeJoueur.remove(0);
		}
		tours+=1;
		tourDeJeu(s);
	}
	
	public static void main(String[] args) {
		StockCarte s = new StockCarte();
		JoueurPhysique phy = new JoueurPhysique(1,0,0,0,0);
		listeJoueur.add(phy);
		Scanner reponse = new Scanner(System.in);
	//	System.out.println("Vous voulez commencer le jeu (O/N)? ");  // Je ne vois pas l'intérêt d'avoir ces étapes...
	//	String rep=reponse.nextLine();
	//	if(rep.equals("O")){
			setNbrJoueurs();
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
