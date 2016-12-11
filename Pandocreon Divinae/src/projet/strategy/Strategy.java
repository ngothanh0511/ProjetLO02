package projet.strategy;

import projet.cartes.StockCarte;
import projet.joueur.JoueurVirtuel;
/**
 * Cette interface représente la stratégie que le joueur virtuel va joueur pendant le jeu
 *
 */
public interface Strategy {
	String mode();
	int pose_carte(JoueurVirtuel joueur);
}
