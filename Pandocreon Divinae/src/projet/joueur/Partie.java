package projet.joueur;
import projet.cartes.Carte;
import projet.cartes.StockCarte;
import projet.joueur.DeCosmogonie;
import projet.vueGraphique.Principal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Observable;
import java.util.Random;
import java.util.Scanner;
/**
 * Cette classe représente la partie qui générer le jeu
 */
public class Partie extends Observable implements Serializable {
	static private final long serialVersionUID = 6L;
	static Scanner scan = new Scanner(System.in);
	protected static int nbrJoueurs=0;
	protected static int tours=1;
	public static int jeton=1;
	protected static ArrayList <Joueur> listeJoueur = new ArrayList <Joueur>(); 
	protected static ArrayList <Joueur> rangJoueur = new ArrayList<Joueur>();
	protected static Random r = new Random();
	static int high=2;
	static int low=1;
	
	private static  JoueurPhysique phy;
	private static StockCarte s;
	
	
	
	/**
	 * Getter de l'attribue StockCarte
	 * @return
	 */
	public StockCarte getStockCarte(){
		return s;
	}
	
	private static boolean estJoueSonTour;
	public void setEstJoueSonTour(boolean value){
		estJoueSonTour = value;
	}
	public boolean getEstJoueSonTour(){
		return estJoueSonTour;
	}
	
	private Carte carteChoisie;
	public Carte getCarteChoisie(){
		return carteChoisie;
	}
	public void setCarteChoisie(Carte carte){
		carteChoisie = carte;
	}
	
	private boolean clickCarteCroyant;
    public boolean isClickCarteCroyant() {
		return clickCarteCroyant;
	}
	public void setClickCarteCroyant(boolean clickCarteCroyant) {
		this.clickCarteCroyant = clickCarteCroyant;
	}
	
	private static Partie partie = new Partie();
	/**
	 * La méthode static qui retourne l'instance unique de la classe Partie
	 * @return
	 */
	public static Partie getInstance(){
		return partie;
	}
	public void setInstance(Partie instance){
		partie = instance;
	}
	/**
	 * Setter de l'attribute rangJoueur
	 */
	public static void setRangJoueur(){
		for(int i=1;i<rangJoueur.size();i++){
			for(int j=0;j<rangJoueur.size()-1;j++){
				if(rangJoueur.get(j).ptPriere<rangJoueur.get(j+1).ptPriere){
					Joueur gagnant = rangJoueur.get(j);
					rangJoueur.set(j, rangJoueur.get(j+1));
					rangJoueur.set(j+1, gagnant);
				}
			}
		}
	}
	/**
	 * Retouner le joueur qui a le moins points de Prières
	 * @return
	 */
	public static Joueur getEliminant(){
		setRangJoueur();
		if(rangJoueur.get(rangJoueur.size()-1).ptPriere==rangJoueur.get(rangJoueur.size()-2).ptPriere){
			return null;
		}
		else{
		return rangJoueur.get(rangJoueur.size()-1);
		}
	}
	/**
	 * Retourner le joueur qui a le plus points de Prières
	 * @return
	 */
	public static Joueur getGagnant(){
		setRangJoueur();
		if(rangJoueur.get(0).ptPriere==rangJoueur.get(1).ptPriere){
			return null;
		}
		else{
		return rangJoueur.get(0);
		}
	}
	
	public  JoueurPhysique getJPhysique(){
		return phy;
	}
//	public boolean estTermine(){
//		return true;
//	}
	/**
	 * Getter de l'attribute listeJoueur
	 * @return
	 */
	public ArrayList<Joueur> getListeJoueur(){
		return listeJoueur;
	}
	/**
	 * Getter de l'attribute rangJoueur
	 * @return
	 */
	public ArrayList<Joueur> getRangJoueur(){
		return rangJoueur;
	}
	
	public static int getNumRang(Joueur joueur){
		int rep = 0;
		for(int i=0;i<rangJoueur.size();i++){
			if(rangJoueur.get(i).getIdJoueur()==joueur.getIdJoueur()){
				rep= i+1;
			}
		}
		
		return rep;
		
	}
	
	public int getNbrJoueur(){
		return nbrJoueurs;
	}
	/**
	 * Setter de l'attribute nbrJoueurs
	 */
	public void setNbrJoueurs(int a){
		
			nbrJoueurs += a;
			phy = new JoueurPhysique(1,0,0,0,0);
			listeJoueur.add(phy);
			rangJoueur.add(phy);
			Main m1 = new Main();
			phy.setLaMain(m1);
			for (int i=0;i<a;i++){
				JoueurVirtuel joueur = new JoueurVirtuel(i+2,0,0,0,0);
				listeJoueur.add(joueur);
				rangJoueur.add(joueur);
				Main m2 = new Main();
				joueur.setLaMain(m2);
			updateVue();
		}
	}
	
	public void setNiveau(String mode){
		for (int i=1;i<listeJoueur.size();i++){
			if(listeJoueur.get(i).getTypeJoueur()=="Joueur Virtuel"){
		switch (mode){
		case ("F"):
			((JoueurVirtuel) listeJoueur.get(i)).setTypeDif("f");
		//	((JoueurVirtuel) listeJoueur.get(i)).setMode(new Defenssif());
			
			break;
		case ("D"):
			((JoueurVirtuel) listeJoueur.get(i)).setTypeDif("d");
//			((JoueurVirtuel) listeJoueur.get(i)).setMode(new Agressif());
			
			//reponse.close();
			break;
		}
	}
		}
	}
//	public JV creerJV(){
		
//	}
	
//	public Strategie setStrategie(){
		
//	}
	
	public  void updateVue() {
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Un tour de jeu
	 * @param s
	 */
	public  void tourDeJeu(StockCarte s){
		estJoueSonTour= false;
		DeCosmogonie de = new DeCosmogonie();
		System.out.println("***********************************Tour " + tours+"*************************");
		System.out.println("Lancement le d� de Cosmogonie...");
		Principal.getInstance().getDetail().setText(Principal.getInstance().getDetail().getText()+"\n ***********************************Tour " + tours+"*************************"
				+ "\n Lancement le d� de Cosmogonie...");
		Collections.shuffle(Arrays.asList(de.face));
		de.resultatLancement();
		String resLance= de.getFace();
		for (int i=0;i<(listeJoueur.size());i++){
			de.donnerPtAction(resLance, listeJoueur.get(i)); 
		}
		updateVue();
		for(int i=0;i<listeJoueur.size();i++){
			listeJoueur.get(0).jouerSonTour(s );
 			listeJoueur.add(listeJoueur.get(0));
			listeJoueur.remove(0);
			updateVue();
		}

		listeJoueur.add(listeJoueur.get(0));
		listeJoueur.remove(0);
		updateVue();
		for(int i=0; i<listeJoueur.size();i++){ 
			listeJoueur.get(i).peutRecevoirPtAction = true;
		}
		setRangJoueur();
		/// RÃ©initialiser Carte.estSacrifiable = true
		for (int j=0; j<listeJoueur.size();j++){
			for(int k=0; k<listeJoueur.get(j).laMain.getlistePaireGuideVsCroyants().size();k++){
				for(int h=0;h<listeJoueur.get(j).laMain.getlistePaireGuideVsCroyants().get(k).size();h++){
					listeJoueur.get(j).laMain.getlistePaireGuideVsCroyants().get(k).get(h).setSacrifiable(true);
				}
			}
		}
		tours+=1;
		System.out.println("----------------------------------------Recapitulatif du tour---------------------------------------");
		for(int i=0;i<listeJoueur.size();i++){
			if(listeJoueur.get(i).typeJoueur=="Joueur Virtuel"){
			System.out.println("");
			System.out.print("Joueur_"+(listeJoueur.get(i).id));
			listeJoueur.get(i).informer();
			}
		}
		StockCarte.getStockCarte();
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("");
		if(tours==25){//c'est pour arreter le jeu sinon ça va être trop long
			System.out.println(" Le jouer "+getGagnant().getIdJoueur() +" a gagne le jeu!! Felicitations!!!");
			System.exit(1);
		}
		
		tourDeJeu(s); 
		
		
	}
	
//	public static void main(String[] args) {
	public  void commencer(){
	//	this.addObserver(Principal.getInstance());
	    s = new StockCarte();
	/*    int a=Principal.getInstance().getNbrComponants();
	    nbrJoueurs += a;
		phy = new JoueurPhysique(1,0,0,0,0);
		listeJoueur.add(phy);
		rangJoueur.add(phy);
		Main m1 = new Main();
		phy.setLaMain(m1);
		for (int i=0;i<a;i++){
			JoueurVirtuel joueur = new JoueurVirtuel(i+2,0,0,0,0);
			listeJoueur.add(joueur);
			rangJoueur.add(joueur);
			Main m2 = new Main();
			joueur.setLaMain(m2);
		
	}
		
		if (Principal.getInstance().getMode()==1){
		this.setNiveau("F");
		}
		else if (Principal.getInstance().getMode()==2){
			this.setNiveau("D");
		} */
		
//		Scanner reponse = new Scanner(System.in);
		/*		int a=7;
		while(a>5 || a<=0){//pour eviter l'utilisateur de mettre joueurs virtuels plus de 6
			System.out.println("Combien de joueur que vous voulez jouer avec (max 5 joueurs) ?");
			a = scan.nextInt();
			} 
			setNbrJoueurs(a); */
/*		String mode;
			System.out.println("Choisissez le mode de jeu (Facile(F)/Difficile(D))? ");
			mode = reponse.nextLine();
			setNiveau(mode);
//		System.out.println(((JoueurVirtuel) listeJoueur.get(1)).getTypeDif());
			System.out.println("Bonjour, "+ JoueurPhysique.setNom()+ " vous avez choisi " + nbrJoueurs + " joueurs virtuels à  jouer avec."); */
	    Collections.shuffle(Joueur.divinite);	
	    System.out.print("Votre Divinite est "); 
			phy.piocheDivinite();
			
			for (int i=1;i<listeJoueur.size();i++){
				System.out.print("Divinite de Joueur_"+listeJoueur.get(i).id +" est ");
				listeJoueur.get(i).piocheDivinite();
			}
			for (int i=0;i<listeJoueur.size();i++){
				s.distribuerCartes(listeJoueur.get(i).getLaMain());
			}
			updateVue();
			tourDeJeu(s);
	//		phy.jouerSonTour(s);
	//		phy.commencerTour();
		
		
	}
	
	public void sauvegarder(String s) throws FileNotFoundException, IOException
    {
        try{
            ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(s));
            save.writeObject(this);
            save.close();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Impossible de sauvegarder");
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
	
	
		
	

}
