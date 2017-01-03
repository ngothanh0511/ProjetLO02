package projet.joueur;

import java.util.List;
import java.util.Arrays;

import projet.cartes.Carte;
import projet.cartes.CarteCroyants;
import projet.cartes.GuideSpirituel;
import projet.cartes.StockCarte;
import projet.cartes.Tapis;
import projet.strategy.Strategy;
/**
 * Cette classe représente le joueur général de jeu
 * 
 *
 */
public abstract class Joueur {

	protected int id;
	private String nom;
	protected static List<String> divinite = Arrays.asList("Romtec", "Gorpa", "Shingua", "Gwengbelen", "PuiTara",
			"Llewella", "Killinstred", "Yarstur", "Drinded", "Brewalen");
	protected String originDivin;
	protected String[] dogmesDivin = new String[3];
	protected int ptActionJour = 0;
	protected int ptActionNuit = 0;
	protected int ptActionNeant = 0;
	protected int ptPriere = 0;
	protected String typeJoueur;
	static int k = 0;
	private String joueurDivinite;


//	private boolean disponibiliteCapacite;
	protected Main laMain;
	protected boolean peutRecevoirPtAction = true;
	protected static Carte carteJouee;
	protected boolean estAttaquable;
	/**
	 * Setter de l'attribute estAttaquable
	 * @param value
	 */
	public void setAttaquable(boolean value) {
		this.estAttaquable = value;
	}
	/**
	 * Setter de l'attribute joueurDivinite
	 * @param value
	 */
	public void setJoueurDivinite(String value){
		this.joueurDivinite = value;
	}
	/**
	 * Getter de l'attribute joueurDivinite
	 * @param value
	 */
	public String getJoueurDivinite(){
		return joueurDivinite;
	}
	
	/**
	 * Getter de l'attribute typeJoueur
	 * @return
	 */
	public String getTypeJoueur(){
		return typeJoueur;
	}
	/**
	 * Getter de l'attribute dogmesDivin
	 * @return
	 */
	public String[] getDogmesDivin() {
		return dogmesDivin;
	}
	/**
	 * Setter de l'attribute originDivin
	 * @param originDivin
	 */
	public void setOriginDivin(String originDivin) {
		this.originDivin = originDivin;
	}
	/**
	 * Getter de l'attribute originDivin
	 * @return
	 */
	public String getOriginDivin() {
		return originDivin;
	}
	/**
	 * Getter de l'attribute id
	 * @return
	 */
	public int getIdJoueur() {
		return id;
	}
	/**
	 * Getter de l'attribute ptActionJour
	 * @return
	 */
	public int getPtActionJour() {
		return ptActionJour;
	}
	/**
	 * Setter de l'attribute ptActionJour
	 * @param ptActionJour
	 */
	public void setPtActionJour(int ptActionJour) {
		if (peutRecevoirPtAction == true) {
			this.ptActionJour = ptActionJour;
		} else {
			System.out.println("Joueur_" + id + " ne peut pas recevoir points Actions dans ce tour!");
		}
	}
	/**
	 * Getter de l'attribute ptActionNuit
	 * @return
	 */
	public int getPtActionNuit() {
		return ptActionNuit;
	}
	/**
	 * Setter de l'attribute ptActionNuit
	 * @param ptActionNuit
	 */
	public void setPtActionNuit(int ptActionNuit) {
		if (peutRecevoirPtAction == true) {
			this.ptActionNuit = ptActionNuit;
		} else {
			System.out.println("Joueur_" + id + " ne peut pas recevoir points Actions dans ce tour!");
		}
	}
	/**
	 * Getter de l'attribute ptActionNeant
	 * @return
	 */
	public int getPtActionNeant() {
		return ptActionNeant;
	}
	/**
	 * Setter de l'attribute ptActionNeant
	 * @param ptActionNeant
	 */
	public void setPtActionNeant(int ptActionNeant) {
		if (peutRecevoirPtAction == true) {
			this.ptActionNeant = ptActionNeant;
		} else {
			System.out.println("Joueur_" + id + " ne peut pas recevoir points Actions dans ce tour!");
		}
	}
	/**
	 * Calculer les points Prières de chaque joueur en fonction des Croyants qu'il a récupéré
	 */
	public void calculerPtPrieres() {
		this.ptPriere=0;
		for (int i = 0; i < this.laMain.getlistePaireGuideVsCroyants().size(); i++) {
			for (int j = 1; j < this.laMain.getlistePaireGuideVsCroyants().get(i).size(); j++) {
				this.ptPriere += ((CarteCroyants) this.laMain.getlistePaireGuideVsCroyants().get(i).get(j)).getNbrCroyants();
			}
		}
	}
	/**
	 * Chaque joueur pioche une Divinité quelconque
	 */
	public void piocheDivinite() {
		String resDiv;
		resDiv = divinite.get(k);
		this.setJoueurDivinite(resDiv);
		if (resDiv == "Yarstur" || resDiv == "Drinded" || resDiv == "Brewalen") {
			originDivin = "Jour";
			System.out.println(resDiv + " d'origine " + originDivin);
		}
		if (resDiv == "PuiTara" || resDiv == "Llewella" || resDiv == "Killinstred") {
			originDivin = "Nuit";
			System.out.println(resDiv + " d'origine " + originDivin);
		}
		if (resDiv == "Gorpa" || resDiv == "Romtec") {
			originDivin = "Crepuscule";
			System.out.println(resDiv + " d'origine " + originDivin);
		}
		if (resDiv == "Shingua" || resDiv == "Gwengbelen") {
			originDivin = "Aube";
			System.out.println(resDiv + " d'origine " + originDivin);
		}
		k++;

	};
	/**
	 * L'action défausser carte de joueur
	 * @param c
	 * @param s
	 */
	public void defausserCarte(Carte c, StockCarte s) {
		s.getStock().add(c);
		laMain.getListeCartesMain().remove(c);
		Partie.getInstance().updateVue();
	}
	/**
	 * Getter de l'attribute ptPriere
	 * @return
	 */
	public int getPtPriere() {
		return ptPriere;
	}
	/**
	 * Permettre de savoir si le joueur est éliminé 
	 * @return
f	 */
	public boolean estElimine() {
		return false;

	}
	/**
	 * Permettre de savoir si le joueur est le gagnant
	 * @return
	 */
	public boolean estGagne() {
		return true;
	}
	/**
	 * Getter de l'attribute laMain
	 * @return
	 */
	public Main getLaMain() {
		return laMain;
	}
	/**
	 * Setter de l'attribute laMain
	 * @param laMain
	 */
	public void setLaMain(Main laMain) {
		this.laMain = laMain;
	}
	/**
	 * La méthode affiche toutes les cartes Guide Spirituel et ses cartes Croyants que le joueur possède
	 */
	public void afficherListePairGuideVsCroyants() {
		for (int i = 0; i < laMain.getlistePaireGuideVsCroyants().size(); i++) {
			System.out.println("Paire " + i + " :");
			for (int j = 0; j < laMain.getlistePaireGuideVsCroyants().get(i).size(); j++) {
				System.out.println(laMain.getlistePaireGuideVsCroyants().get(i).get(j).afficherCarte());
			}
		}
	}
	/**
	 * La méthode abstract de l'action jouer un tour du joueur
	 * @param s
	 */
	public abstract void jouerSonTour(StockCarte s);
	/**
	 * La méthode abstract qui active la capacité spéciale d'une carte quand elle est utilisée pour une carte DeuxEx ou Apocalypse
	 * ou quand elle est sacrifiée pour une carte Croyant ou Guide Spirituel
	 * @param carte
	 * @param s
	 */
	public abstract void activerCapaciteSpeciale(Carte carte, StockCarte s);
	/**
	 * L'action sacrifier de'une carte Croyant ou Guide Spirituel
	 * @param carte
	 * @param s
	 */
	public void sacrifierCarte(Carte carte, StockCarte s) {
		if (carte.getSacrifiable() != false) {
			if (carte.getAnnule() != false) {
				if(typeJoueur=="Joueur Physique"){
					System.out.println("Vous sacrifiez la carte "+carte.getNom());
				}
				else{ System.out.println("Le Joueur "+id+"sacrifie la carte "+carte.getNom()); }
				activerCapaciteSpeciale(carte, s);
					s.getStock().add(carte);
					if (carte.getType() == "Croyant") {
						for (int i = 0; i < laMain.getlistePaireGuideVsCroyants().size(); i++) {
							if ((laMain.getlistePaireGuideVsCroyants().get(i)).contains(carte) == true) {
								laMain.getlistePaireGuideVsCroyants().get(i).remove(carte);
								if (laMain.getlistePaireGuideVsCroyants().get(i).size() < 2) {
									s.getStock().add(laMain.getlistePaireGuideVsCroyants().get(i).get(0));
									laMain.getlistePaireGuideVsCroyants().get(i).remove(0);
								}
								break;
							}
						}

					} else if (carte.getType() == "GuideSpirituel") {
						for (int i = 0; i < laMain.getlistePaireGuideVsCroyants().size(); i++) {
							if ((laMain.getlistePaireGuideVsCroyants().get(i)).contains(carte) == true) {
								for (int j = 1; j < laMain.getlistePaireGuideVsCroyants().get(i).size(); j++) {
									Tapis.getListeCartesCroyants()
											.add((CarteCroyants) laMain.getlistePaireGuideVsCroyants().get(i).get(j));
								}
								laMain.getlistePaireGuideVsCroyants().remove(i);
								break;
							}
						}
					
					
						
					}
				
			}
		}
	}
	public abstract GuideSpirituel choisirGuideSpirituelASacrifier();

	public abstract CarteCroyants choisirCarteCroyantsASacrifier();
	public abstract void informer();
	public abstract void choisirCarte(Carte c,StockCarte s);

}


