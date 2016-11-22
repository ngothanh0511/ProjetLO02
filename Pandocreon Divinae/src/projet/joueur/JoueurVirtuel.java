package projet.joueur;
import java.util.Random;
import java.util.Scanner;

import projet.cartes.Carte;
import projet.cartes.CarteCroyants;
import projet.cartes.GuideSpirituel;
import projet.cartes.StockCarte;

public class JoueurVirtuel extends Joueur{

	static Scanner nom = new Scanner(System.in);
	
	
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
	
	public void sacrifierGuideSpirituel(GuideSpirituel carte){
		
	}
	
	public void sacrifierCarteCroyants(CarteCroyants carte){
		
	}
	
	
	public CarteCroyants choisirCarteCroyantsASacrifier(){
		for (int j=0; j<laMain.getlistePaireGuideVsCroyants().size();j++){
			if (laMain.getlistePaireGuideVsCroyants().get(j).size()>laMain.getlistePaireGuideVsCroyants().get(j+1).size()){
				laMain.getlistePaireGuideVsCroyants().add(j+2,laMain.getlistePaireGuideVsCroyants().get(j));
				laMain.getlistePaireGuideVsCroyants().remove(j);
			}
		}
		for (int j=1; j<laMain.getlistePaireGuideVsCroyants().get(0).size();j++){
			if (laMain.getlistePaireGuideVsCroyants().get(0).get(j).getNbrCroyants()>laMain.getlistePaireGuideVsCroyants().get(0).get(j+1).getNbrCroyants()){
				laMain.getlistePaireGuideVsCroyants().get(0).add(j+2,laMain.getlistePaireGuideVsCroyants().get(0).get(j));
				laMain.getlistePaireGuideVsCroyants().get(0).remove(j);
			}
		}
		return (CarteCroyants) laMain.getlistePaireGuideVsCroyants().get(0).get(1);
	}
	
	public GuideSpirituel choisirGuideSpirituelASacrifier(){
		for (int k =0; k< laMain.getlistePaireGuideVsCroyants().size();k++){
			if(laMain.getlistePaireGuideVsCroyants().get(k).size()>laMain.getlistePaireGuideVsCroyants().get(k+1).size()){
				laMain.getlistePaireGuideVsCroyants().add(k+2,laMain.getlistePaireGuideVsCroyants().get(k));
				laMain.getlistePaireGuideVsCroyants().remove(k);
			}
		}
		return (GuideSpirituel) laMain.getlistePaireGuideVsCroyants().get(0).get(0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//recuperer pts d'actions (appel la méthode lancerDeCosmogonie)
		//mettre les pts d'action dans la variable ptActionJour/nuit/neant
	}

}
