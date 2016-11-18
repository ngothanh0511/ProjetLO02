package projet.joueur;

import projet.cartes.StockCarte;

public class Partie {

	private Partie partie;
	private int tours;
	static Scanner scan = new Scanner(System.in);
	private static int nbrJoueurs;
	
	
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
		JoueurPhysique j1 = new JoueurPhysique();
		Main m1 = new Main();
		j1.setLaMain(m1);
		s.distribuerCartes(m1);
		j1.getLaMain();
		while (j1.laMain.getListeCartesMain().size() >0){
			j1.choisirCarte();
		}
		
		JoueurPhysique phy = new JoueurPhysique();
		Scanner reponse = new Scanner(System.in);
		System.out.println("Vous voulez commencer le jeu (O/N)? ");
		String rep=reponse.nextLine();
		if(rep.equals("O")){
			nbrJoueurs=setNbrJoueurs();
			System.out.println("Bonjour, "+ JoueurPhysique.setNom()+ " vous avez choisi " + nbrJoueurs + " joueurs virtuels  à jouer avec.");
			System.out.print("Votre Divinité est ");
			phy.piocheDivinite();
			System.out.println("Lancement du dé...");
			System.out.print("Resultat du lancement: " + DeCosmogonie.resultatLancement());
			
			String resLance= DeCosmogonie.resultatLancement();
			
		}
		else{
			System.out.print("Lancer le jeu");
		}

		
	}

}
