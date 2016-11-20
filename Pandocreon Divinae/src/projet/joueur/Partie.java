package projet.joueur;

import projet.cartes.StockCarte;
import projet.joueur.DeCosmogonie.face;

import java.util.Scanner;

public class Partie {

	private Partie partie;
	static Scanner scan = new Scanner(System.in);
	private static int nbrJoueurs;
	private static int tours=1;
	private static int tot=0;
	
	
	private Partie partie(){
		return partie;
		
	}
	
	public Partie getInstance(){
		return partie;
	}
	
	public boolean estTermine(){
		return true;
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
		JoueurPhysique phy = new JoueurPhysique();
//		Scanner reponse = new Scanner(System.in);
	//	System.out.println("Vous voulez commencer le jeu (O/N)? ");  // Je ne vois pas l'intérêt d'avoir ces étapes...
	//	String rep=reponse.nextLine();
	//	if(rep.equals("O")){
			nbrJoueurs=setNbrJoueurs();
			System.out.println("Bonjour, "+ JoueurPhysique.setNom()+ " vous avez choisi " + nbrJoueurs + " joueurs virtuels à jouer avec.");
			System.out.print("Votre Divinité est ");
			phy.piocheDivinite();
			Main m1 = new Main();
			phy.setLaMain(m1);
		//	while(tours<4){//juste pour visualiser le nombre de points qu'il va gagner Ã  chaque tour
				System.out.println("Tour " + tours);
				System.out.println("Lancement le"+ tours +" ieme dé de Cosmogonie...");
				System.out.println("Resultat du lancement: face " + DeCosmogonie.resultatLancement());
				String resLance= DeCosmogonie.resultatLancement();
				if(resLance.equals("Jour")){
					if(phy.getOriginDivin().equals("Jour")){
						
						tot=tot+2;
						phy.setPtActionJour(tot);
					}
					if(phy.getOriginDivin().equals("Aube")){
						tot=tot+1;
						phy.setPtActionJour(tot);
						
					}
					System.out.println("Vous avez maintenant " + phy.getPtActionJour()+ " points jour ");
				}
				if(resLance.equals("Nuit")){
					if(phy.getOriginDivin().equals("Nuit")){
						tot=tot+2;
						phy.setPtActionNuit(tot);
					}
					if(phy.getOriginDivin().equals("Crepuscule")){
						tot=tot+1;
						phy.setPtActionNuit(tot);
					}
					System.out.println("Vous avez maintenant " + phy.getPtActionNuit()+ " points nuit");
				}
				if(resLance.equals("Neant")){
					if(phy.getOriginDivin().equals("Aube")||phy.getOriginDivin().equals("Crepuscule")){
						tot=tot+1;
						phy.setPtActionNeant(tot);
					}
					System.out.println("Vous avez maintenant " + phy.getPtActionNeant()+ " points neant");
				}
				s.distribuerCartes(m1);
				phy.defausserCarte();
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
