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
		divinite resDiv;
		int Div = new Random().nextInt(divinite.values().length);
		resDiv=divinite.values()[Div];//pour aggreger le nom du variable utilisé
		
		if(resDiv.equals("Yarstur")&& resDiv.equals("Drinded")&&resDiv.equals("Brewalen")){
			originDivin="Jour";
			System.out.println(resDiv + " d'origine " + originDivin);
		}
		if(resDiv.equals("PuiTara")&& resDiv.equals("Llewella")){
			originDivin="Nuit";
		}
		if(resDiv.equals("Gorpa")&& resDiv.equals("Romtec")){
			originDivin="Crepuscule";
		}
		else{
			originDivin="Aube";
		}
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeCosmogonie.resultatLancement();
		//recuperer pts d'actions (appel la méthode lancerDeCosmogonie)
		//mettre les pts d'action dans la variable ptActionJour/nuit/neant
	}

}
