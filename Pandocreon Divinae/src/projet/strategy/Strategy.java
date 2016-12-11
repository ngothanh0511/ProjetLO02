package projet.strategy;

import projet.cartes.StockCarte;
import projet.joueur.JoueurVirtuel;
/**
 * Cette interface repr�sente la strat�gie que le joueur virtuel va joueur pendant le jeu
 *
 */
public interface Strategy {
	String mode();
	int pose_carte(JoueurVirtuel joueur);
}
