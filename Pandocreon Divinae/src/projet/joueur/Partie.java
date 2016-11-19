package projet.joueur;

import projet.cartes.StockCarte;
import projet.joueur.DeCosmogonie.face;

import java.util.Scanner;

public class Partie {

	private Partie partie;
	static Scanner scan = new Scanner(System.in);
	private static int nbrJoueurs;
	private int tours;
	
	
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
		Scanner reponse = new Scanner(System.in);
		System.out.println("Vous voulez commencer le jeu (O/N)? ");
		String rep=reponse.nextLine();
		if(rep.equals("O")){
			nbrJoueurs=setNbrJoueurs();
			System.out.println("Bonjour, "+ JoueurPhysique.setNom()+ " vous avez choisi " + nbrJoueurs + " joueurs virtuels  à  jouer avec.");
			System.out.print("Votre Divinité est ");
			phy.piocheDivinite();
			System.out.println("Lancement du dé de Cosmogonie...");
			System.out.println("Resultat du lancement: " + DeCosmogonie.resultatLancement());
			
			face resLance= DeCosmogonie.resultatLancement();
			if(resLance.equals(face.Jour)){		//J'ai changé le type de l'attribue reslance à face afin de débugger le bug
				if(phy.getOriginDivin().equals("Jour")){
					phy.setPtActionJour(2);
				}
				if(phy.getOriginDivin().equals("Aube")){
					phy.setPtActionJour(1);
				}
				System.out.println("Vous avez maintenantt " + phy.getPtActionJour()+ " points jour ");
			}
			if(resLance.equals(face.Nuit)){
				if(phy.getOriginDivin().equals("Nuit")){
					phy.setPtActionNuit(2);
				}
				if(phy.getOriginDivin().equals("Crepuscule")){
					phy.setPtActionNuit(1);
				}
				System.out.println("Vous avez maintenantt " + phy.getPtActionNuit()+ " points nuit");
			}
			if(resLance.equals(face.Neant)){
				if(phy.getOriginDivin().equals("Aube")&&phy.getOriginDivin().equals("Crepuscule")){
					phy.setPtActionNeant(1);
					System.out.println("Vous avez maintenantt " + phy.getPtActionNeant()+ " points neant");
				}

			}
			
		}
		else{
			System.out.print("Lancer le jeu");
		}
		
		Main m1 = new Main();
		phy.setLaMain(m1);
		s.distribuerCartes(m1);
		while (phy.laMain.getListeCartesMain().size() >0){
			phy.MontrerLaMain();
			phy.choisirCarte();
		}
		
		
	}

}
