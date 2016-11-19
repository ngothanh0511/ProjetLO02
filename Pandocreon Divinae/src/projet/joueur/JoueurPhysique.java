package projet.joueur;
import java.util.Random;
import java.util.Scanner;



public class JoueurPhysique extends Joueur{

	static Scanner scan = new Scanner(System.in);
	static Scanner nom = new Scanner(System.in);
	private static int nbrJoueurs;
	
	private String originDivin;//nouveau attribut
	
	public void piocheDivinite(){
		String resDiv;
		int Div = new Random().nextInt(divinite.values().length);
		resDiv=divinite.values()[Div].name();//pour aggreger le nom du variable utilisé
		
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
		   System.out.println("Vous avez les cartes suivantes:");
		  for (int i=0; i< laMain.getListeCartesMain().size(); i++){
		  // 	for (Iterator<Carte> it = laMain.getListeCartesMain().iterator(); it.hashNext();)
		   			
			   System.out.println(laMain.getListeCartesMain().get(i).afficherCarte());
		   }
	   }
	
	
	public void choisirCarte(){
		int id;
		System.out.println("Mettez l'id de la carte � jouer: ");
		id = scan.nextInt();
		for (int i=0; i<laMain.getListeCartesMain().size(); i++){
			if (laMain.getListeCartesMain().get(i).getIdCarte()==id){
				laMain.getListeCartesMain().get(i).getUtilisable(this);
				if (laMain.getListeCartesMain().get(i).utilisee()==true){
					System.out.println("Vous avez jou� la carte c_ "+ laMain.getListeCartesMain().get(i).getIdCarte());
					laMain.getListeCartesMain().get(i).activerFonctionCarte(this);
					laMain.getListeCartesMain().get(i).calculerPtAction(this);
					laMain.getListeCartesMain().remove(i);
				}
				else {
					System.out.println("La carte que vous choissiez n'est pas utilisable!");
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
	}

}
