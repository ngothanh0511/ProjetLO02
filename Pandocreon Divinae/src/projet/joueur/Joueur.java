package projet.joueur;

import projet.cartes.GuideSpirituel;

public  abstract class Joueur {

	private int id;
	private String nom;
	public enum divinite {
		Romtec,Gorpa,Shingua,Gwengbelen,PuiTara,Llewella,Killinstred,Yarstur,Drinded,Brewalen
	}
	protected String originDivin;
	protected String [] dogmesDivin= new String[3];
	protected int ptActionJour=0;
	protected int ptActionNuit=0;
	protected int ptActionNeant=0;
	private int ptPriere=0;
	private enum capaciteSpeciale{}
	private boolean disponibiliteCapacite;
	protected Main laMain;
	
	public String[] getDogmesDivin(){
		return dogmesDivin;
	}
	
	
	public int getIdJoueur(){
		return id;
	}
	public int getPtActionJour() {
		return ptActionJour;
	}

	public void setPtActionJour(int ptActionJour) {
		this.ptActionJour = ptActionJour;
	}
	
	public int getPtActionNuit() {
		return ptActionNuit;
	}

	public void setPtActionNuit(int ptActionNuit) {
		this.ptActionNuit = ptActionNuit;
	}
	
	public int getPtActionNeant() {
		return ptActionNeant;
	}

	public void setPtActionNeant(int ptActionNeant) {
		this.ptActionNeant = ptActionNeant;
	}
	
	public void calculerPtPrieres(){
		for (int i =0; i<this.laMain.getlistePaireGuideVsCroyants().size();i++){
			for (int j=1; j<this.laMain.getlistePaireGuideVsCroyants().get(i).size();j++){
				ptPriere += this.laMain.getlistePaireGuideVsCroyants().get(i).get(j).getNbrCroyants();
			}
		}
	}
	
	public abstract void piocheDivinite();
	
	public void defausserCarte(){
		
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
    
   public abstract void sacrifierGuideSpirituel(GuideSpirituel carte);
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
