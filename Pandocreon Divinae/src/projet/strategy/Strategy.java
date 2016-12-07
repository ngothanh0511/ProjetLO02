package projet.strategy;

import projet.cartes.StockCarte;
import projet.joueur.JoueurVirtuel;

public interface Strategy {
	String mode();
	int pose_carte(JoueurVirtuel joueur);
}
