package projet.joueur;
import java.util.Random;
import java.util.Scanner;

public class JoueurVirtuel extends Joueur{

	static Scanner nom = new Scanner(System.in);
	private String originDivin;
	
	public void lancerDeCosmogonie(){
		//if(lancerDeCosmogonie()=='DIVIN_joueur_appartient')
		//donne pts d'actions correspondant
		
	}
	
	public static String setNom(){
		System.out.println("Mettez votre nom : ");
		return nom.nextLine();
		
	}
	
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeCosmogonie.resultatLancement();
		//recuperer pts d'actions (appel la méthode lancerDeCosmogonie)
		//mettre les pts d'action dans la variable ptActionJour/nuit/neant
	}

}
