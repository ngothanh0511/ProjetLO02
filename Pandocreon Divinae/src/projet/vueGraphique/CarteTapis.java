package projet.vueGraphique;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import projet.cartes.Carte;
import projet.joueur.Partie;

public class CarteTapis extends CartePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CarteTapis(Carte carte) {
		super(carte);
		this.setPreferredSize(DIMENSION_LARGE);
		this.setMaximumSize(DIMENSION_LARGE);
		this.setMinimumSize(DIMENSION_PETITE);
		
	}
}

