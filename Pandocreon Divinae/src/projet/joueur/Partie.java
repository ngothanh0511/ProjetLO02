package projet.joueur;

import projet.cartes.Carte;
import projet.cartes.StockCarte;
import projet.joueur.DeCosmogonie.face;

import java.util.ArrayList;
import java.util.Collections;
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
		Collections.shuffle(Joueur.divinite); //pour donner la divinité aleatoirement
//		Scanner reponse = new Scanner(System.in);
	//	System.out.println("Vous voulez commencer le jeu (O/N)? ");  // Je ne vois pas l'intérêt d'avoir ces étapes...
	//	String rep=reponse.nextLine();
	//	if(rep.equals("O")){
			nbrJoueurs=setNbrJoueurs();
			for (int i=0;i<nbrJoueurs;i++){
				listeJoueur.add(new JoueurVirtuel());
			}
			System.out.println("Bonjour, "+ phy.setNom()+ " vous avez choisi " + nbrJoueurs + " joueurs virtuels à jouer avec.");
	
			System.out.print("Votre Divinité est ");
			phy.piocheDivinite();
			
			for(int i=1;i<(nbrJoueurs+1);i++){
				System.out.println("");
				System.out.println("La divinité de Joueur_" + i);
				listeJoueur.get(i).piocheDivinite();
				System.out.println("");
				JoueurVirtuel.k++; //pour eviter d'avoir meme divinite
			}
			Main m1 = new Main();
			Main m2 = new Main();
			phy.setLaMain(m1);
			listeJoueur.get(1).setLaMain(m2);//pour demonstrer le JV
		//	while(tours<4){//juste pour visualiser le nombre de points qu'il va gagner Ã  chaque tour
				System.out.println("Tour " + tours);
				System.out.println("Lancement le dé de Cosmogonie...");
				System.out.println("Resultat du lancement: face " + de.resultatLancement());
				for (int i=0;i<listeJoueur.size();i++){
					de.donnerPtAction(listeJoueur.get(i)); // J'ai changé le placement de tes codes et les mis dans la méthode donnerPtAction afon de pourvoir appliquer à tous les joueurs
				}
				s.distribuerCartes(m1);
				s.distribuerCartes(m2);// c'est pour tester la fonctionnalite
				int id;
				while (phy.getLaMain().getListeCartesMain().size()>0){
					phy.informer();
					listeJoueur.get(1).informer();
					System.out.println("Mettez l'ID de la carte que vous voulez défausser! Si vous ne vouslez pas défausser plus de carte, tapez 0!");
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
