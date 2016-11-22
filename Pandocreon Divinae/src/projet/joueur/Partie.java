package projet.joueur;

import projet.cartes.Carte;
import projet.cartes.StockCarte;
import projet.joueur.DeCosmogonie.face;

import java.util.ArrayList;
import java.util.Scanner;

public class Partie {

	private Partie partie;
	static Scanner scan = new Scanner(System.in);
	private static int nbrJoueurs;
	private static int tours=1;
	protected static ArrayList <Joueur> listeJoueur = new ArrayList <Joueur>(); 
	
	
	private Partie partie(){
		return partie;
		
	}
	
	public Partie getInstance(){
		return partie;
	}
	
	public boolean estTermine(){
		return true;
	}
	
	public static ArrayList<Joueur> getListeJoueur(){
		return listeJoueur;
	}
	public static int setNbrJoueurs(){
		
		int a=7;
		while(a>5){//pour eviter l'utilisateur de mettre joueurs virtuels plus de 6
			System.out.println("Combien de joueur que vous voulez jouer avec (max 5 joueurs) ?");
			a = scan.nextInt();
		}
		return a;
	}
//	public JV creerJV(){
		
//	}
	
//	public Strategie setStrategie(){
		
//	}
	
	public void donnerDivinite(){
		
	}
	
	public static void main(String[] args) {
		StockCarte s = new StockCarte();
		DeCosmogonie de= new DeCosmogonie();
		JoueurPhysique phy = new JoueurPhysique();
		listeJoueur.add(phy);
//		Scanner reponse = new Scanner(System.in);
	//	System.out.println("Vous voulez commencer le jeu (O/N)? ");  // Je ne vois pas l'int�r�t d'avoir ces �tapes...
	//	String rep=reponse.nextLine();
	//	if(rep.equals("O")){
			nbrJoueurs=setNbrJoueurs();
			System.out.println("Bonjour, "+ JoueurPhysique.setNom()+ " vous avez choisi " + nbrJoueurs + " joueurs virtuels � jouer avec.");
			System.out.print("Votre Divinit� est ");
			phy.piocheDivinite();
			Main m1 = new Main();
			phy.setLaMain(m1);
		//	while(tours<4){//juste pour visualiser le nombre de points qu'il va gagner à chaque tour
				System.out.println("Tour " + tours);
				System.out.println("Lancement le d� de Cosmogonie...");
				for (int i=0;i<listeJoueur.size();i++){
					de.donnerPtAction(listeJoueur.get(i)); // J'ai chang� le placement de tes codes et les mis dans la m�thode donnerPtAction afon de pourvoir appliquer � tous les joueurs
				}
				s.distribuerCartes(m1);
				int id;
				while (phy.getLaMain().getListeCartesMain().size()>0){
					phy.informer();
					System.out.println("Mettez l'ID de la carte que vous voulez d�fausser! Si vous ne vouslez pas d�fausser plus de carte, tapez 0!");
					id = scan.nextInt();
				if (id==0){
					break;
				}
				else {
					for(int i =0;i<phy.getLaMain().getListeCartesMain().size();i++){
						if (id==phy.getLaMain().getListeCartesMain().get(i).getIdCarte()){
							phy.defausserCarte(phy.getLaMain().getListeCartesMain().get(i));
							break;
						}
					}
				}
				}
				s.distribuerCartes(m1);
				phy.choisirCarte();
			//	tours++;
			}
			
	//	}
	//	else{
		//	System.out.print("Lancer le jeu");
	//	}
		
		
		
		
//	}
		

}
