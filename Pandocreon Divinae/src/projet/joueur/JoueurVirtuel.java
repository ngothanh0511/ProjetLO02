package projet.joueur;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import projet.cartes.Carte;
import projet.cartes.CarteCroyants;
import projet.cartes.GuideSpirituel;
import projet.cartes.StockCarte;
import projet.cartes.Tapis;
import projet.strategy.*;

public class JoueurVirtuel extends Joueur{

	static Scanner nom = new Scanner(System.in);
	Random r = new Random();
	static int k=2;
	public Strategy strat;//instantiated Strategy de joueur
	String typDiff;
	
	public String tryStrat(){
		return strat.mode();
	}
	
	public int try_pose_carte(){
		return strat.pose_carte(this);
	}
	
	public void try_defausser_carte(JoueurVirtuel joueur, StockCarte s){
		 strat.defausser_carte(joueur, s);
	}
	
	public void setMode(Strategy newStrat){
		strat=newStrat;
	}
	
	public void setTypeDif(String str) {
		// TODO Auto-generated method stub
		typDiff=str;
	}
	
	public String getTypeDif(){
		return typDiff;
	}
	
	
	public JoueurVirtuel(Integer id, Integer ptJour, Integer ptNuit, Integer ptNeant, Integer ptPriere, Strategy strat, String typDiff) {
		super(id, ptJour, ptNuit, ptNeant, ptPriere);
		// TODO Auto-generated constructor stub
		//strat=new Normal();
		this.strat=strat;
		this.id =id;
		this.ptActionJour=ptJour;
		this.ptActionNuit= ptNuit;
		this.ptActionNeant = ptNeant;
		this.ptPriere = ptPriere;
		this.typeJoueur = "Joueur Virtuel";
		this.typDiff=typDiff;
		
	}
	
	
	
	public void lancerDeCosmogonie(){
		//if(lancerDeCosmogonie()=='DIVIN_joueur_appartient')
		//donne pts d'actions correspondant
		
	}
	
	public void informer(){
		System.out.print(" a: ");
		System.out.print(ptActionJour + " points Action Jour, ");
		System.out.print(ptActionNuit + " points Action Nuit, ");
		System.out.println(ptActionNeant + " points Action Neant ");
		System.out.println("Il a gagné: " + ptPriere+" points Prières");
		
	}
	
	public static String setNom(){
		System.out.println("Mettez votre nom : ");
		return nom.nextLine();
		
	}
	
	public void piocheDivinite(){
		String resDiv;
		//int choice = r.nextInt(divinite.size());
		//int Div = new Random().nextInt(divinite.values().length);
		//resDiv=divinite.values()[Div].name();//pour aggreger le nom du variable utilisÃƒÂ©
		resDiv=divinite.get(k);
		
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
		k++;
		
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
		//recuperer pts d'actions (appel la mÃƒÂ©thode lancerDeCosmogonie)
		//mettre les pts d'action dans la variable ptActionJour/nuit/neant
	}

	@Override
	public void jouerSonTour(StockCarte s) {
		// TODO Auto-generated method stub
		s.distribuerCartes(laMain);
		System.out.println(tryStrat());
		/*for (int i=0; i< laMain.getListeCartesMain().size(); i++){
			   System.out.println(laMain.getListeCartesMain().get(i).afficherCarte());
		}*/
		try_defausser_carte(this, s);
		s.distribuerCartes(laMain);
		choisirCarte();
		
		
	}
	
	public void choisirCarte(){
		
		//Collections.shuffle(laMain.getListeCartesMain());//c'est un truc pour essayer, on peut le supprimer 
		
		int id=try_pose_carte();
		for (int i=0; i<laMain.getListeCartesMain().size(); i++){
			if (laMain.getListeCartesMain().get(i).getIdCarte()==id){
				laMain.getListeCartesMain().get(i).getUtilisable(this);
				if (laMain.getListeCartesMain().get(i).utilisee()==true){
					System.out.println("JV_" +this.getIdJoueur()+" joué la carte c_ "+ laMain.getListeCartesMain().get(i).getIdCarte());
					laMain.getListeCartesMain().get(i).activerFonctionCarte(this);
					laMain.getListeCartesMain().get(i).calculerPtAction(this);
					if (laMain.getListeCartesMain().get(i).utilisee()== true){
						laMain.getListeCartesMain().remove(i);
					}
					
				}
				
			}
			else{
				//System.out.println("marche pas");
				id=try_pose_carte();
			}
		}
		
			
		
		informer();
		System.out.println("**********************************");
		//compt--;
		//}
		
	}
	

	@Override
	public void activerCapaciteSpeciale(Carte carte, StockCarte s) {
		// TODO Auto-generated method stub
		
	}

	

}
