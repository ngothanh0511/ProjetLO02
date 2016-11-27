package projet.joueur;
import java.util.List;
import java.util.Arrays;

import projet.cartes.Carte;
import projet.cartes.CarteCroyants;
import projet.cartes.GuideSpirituel;
import projet.cartes.StockCarte;
import projet.cartes.Tapis;
import projet.strategy.Strategy;

public  abstract class Joueur {

	protected int id;
	private String nom;
	protected static List<String> divinite = Arrays.asList("Romtec","Gorpa","Shingua","Gwengbelen","PuiTara","Llewella","Killinstred","Yarstur","Drinded","Brewalen");
	protected String originDivin;
	protected String [] dogmesDivin= new String[3];
	protected int ptActionJour=0;
	protected int ptActionNuit=0;
	protected int ptActionNeant=0;
	protected int ptPriere=0;
	protected String typeJoueur;
	private enum capaciteSpeciale{}
	private boolean disponibiliteCapacite;
	protected Main laMain;
	protected boolean peutRecevoirPtAction = true;
	public Strategy strat;//instantiated Strategy de joueur
	
	public String tryStrat(){
		return strat.mode();
	}
	
	public void setMode(Strategy newStrat){
		strat=newStrat;
	}
	
	public String[] getDogmesDivin(){
		return dogmesDivin;
	}
	
	public void setOriginDivin(String originDivin) {
	       this.originDivin = originDivin;
	    }

	public String getOriginDivin() {
	       return originDivin;
	}
	
	public int getIdJoueur(){
		return id;
	}
	public int getPtActionJour() {
		return ptActionJour;
	}

	public void setPtActionJour(int ptActionJour) {
		if(peutRecevoirPtAction==true){
		this.ptActionJour = ptActionJour;
		}
		else{
			System.out.println("Joueur_"+id+" ne peut pas recevoir points Actions dans ce tour!");
		}
	}
	
	public int getPtActionNuit() {
		return ptActionNuit;
	}

	public void setPtActionNuit(int ptActionNuit) {
		if(peutRecevoirPtAction==true){
			this.ptActionNuit = ptActionNuit;
			}
			else{
				System.out.println("Joueur_"+id+" ne peut pas recevoir points Actions dans ce tour!");
			}
	}
	
	public int getPtActionNeant() {
		return ptActionNeant;
	}

	public void setPtActionNeant(int ptActionNeant) {
		if(peutRecevoirPtAction==true){
			this.ptActionNeant = ptActionNeant;
			}
			else{
				System.out.println("Joueur_"+id+" ne peut pas recevoir points Actions dans ce tour!");
			}
	}
	
	public void calculerPtPrieres(){
		for (int i =0; i<this.laMain.getlistePaireGuideVsCroyants().size();i++){
			for (int j=1; j<this.laMain.getlistePaireGuideVsCroyants().get(i).size();j++){
				ptPriere += this.laMain.getlistePaireGuideVsCroyants().get(i).get(j).getNbrCroyants();
			}
		}
	}
	
	public Joueur(Integer id, Integer ptJour, Integer ptNuit, Integer ptNeant, Integer ptPriere){
		this.id = id;
		this.ptActionJour = ptJour;
		this.ptActionNuit = ptNuit;
		this.ptActionNeant = ptNeant;
		this.ptPriere = ptPriere;
		
	}
	public abstract void piocheDivinite();
	
	public void defausserCarte(Carte c, StockCarte s){
		s.getStock().add(c);
		laMain.getListeCartesMain().remove(c);
	}
	
	
    public int getPtPriere(){
		return ptPriere;
	}
	
    public boolean estElimine(){
		return false;
		
	}
    
    public boolean estGagne(){
		return true;
	}
    
    public void activerCapacite(){
		
	}
    
    public void passerTour(){
		
	}
    
    public Main getLaMain(){
		return laMain;
	}
    
   public void setLaMain(Main laMain){
	   this.laMain = laMain;
   }
   
   public void afficherListePairGuideVsCroyants(){
	   for (int i =0; i<laMain.getlistePaireGuideVsCroyants().size();i++){
		   System.out.println("Paire "+i+" :");
		   for (int j =0; j<laMain.getlistePaireGuideVsCroyants().get(i).size();j++){
			   System.out.println(laMain.getlistePaireGuideVsCroyants().get(i).get(j).afficherCarte());
		   }
	   }
   }
   
   public abstract void jouerSonTour(StockCarte s);
   public abstract void activerCapaciteSpeciale(Carte carte, StockCarte s);
   
   public void sacrifierCarte(Carte carte, StockCarte s){
	   activerCapaciteSpeciale(carte,s);
	   s.getStock().add(carte);
	   if (carte.getType()=="Croyant"){
		   for (int i=0;i<laMain.getlistePaireGuideVsCroyants().size();i++){
			   if((laMain.getlistePaireGuideVsCroyants().get(i)).contains(carte)==true){
				   laMain.getlistePaireGuideVsCroyants().get(i).remove(carte);
				   if (laMain.getlistePaireGuideVsCroyants().get(i).size()<2){
					   s.getStock().add(laMain.getlistePaireGuideVsCroyants().get(i).get(0));
					   laMain.getlistePaireGuideVsCroyants().get(i).remove(0);
				   }
				   break;
			   }
		   }
		   
	   }
	   else if (carte.getType()=="GuideSpirituel"){
		   for(int i=0;i<laMain.getlistePaireGuideVsCroyants().size();i++){
			   if((laMain.getlistePaireGuideVsCroyants().get(i)).contains(carte)==true){
				   for (int j=1;j<laMain.getlistePaireGuideVsCroyants().get(i).size();j++){
					   Tapis.getListeCartesCroyants().add((CarteCroyants) laMain.getlistePaireGuideVsCroyants().get(i).get(j));
				   }
				   laMain.getlistePaireGuideVsCroyants().remove(i);
				   break;
			   }
		   }
	   }
   }
    
   public abstract GuideSpirituel choisirGuideSpirituelASacrifier();
   public abstract CarteCroyants choisirCarteCroyantsASacrifier();
   
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public abstract void informer();

}
