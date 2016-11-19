package projet.joueur;


public  abstract class Joueur {

	private int id;
	private String nom;
	public enum divinite {
		JOUR,AUBE,NUIT,CRESPUSCULE
	}
	private int ptActionJour=0;
	private int ptActionNuit=0;
	private int ptActionNeant=0;
	private int ptPriere=0;
	private enum capaciteSpeciale{}
	private boolean disponibiliteCapacite;
	protected Main laMain;
	
	public void setPtActionJour(int PtActionJour){
		ptActionJour = PtActionJour;
	}
	
	public Main getLaMain(){
		return laMain;
	}
	
	public int getPtActionJour(){
		return ptActionJour;
	}
	
	public void setPtActionNuit(int PtActionNuit){
		ptActionNuit = PtActionNuit;
	}
	public int getPtActionNuit(){
		return ptActionNuit;
	}
	public void setPtActionNeant(int PtActionNeant){
		ptActionNeant = PtActionNeant;
	}
	public int getPtActionNeant(){
		return ptActionNeant;
	}
	
	
	public abstract void lancerDeCosmogonie();
	
	public abstract void piocheDivinite();
	
	public void defausserCarte(){
		
	}
	
	public void utiliserCarte(){
		
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
    
   public void setLaMain(Main laMain){
	   this.laMain = laMain;
   }
    
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
