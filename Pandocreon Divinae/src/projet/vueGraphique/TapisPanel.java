package projet.vueGraphique;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import projet.cartes.Carte;
import projet.cartes.StockCarte;
import projet.cartes.Tapis;
import projet.controlleur.Controlleur;
import projet.joueur.JoueurPhysique;
import projet.joueur.Partie;

public class TapisPanel extends JPanel{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant DIMENSION_LARGE. */
	private static final Dimension DIMENSION_LARGE = new Dimension(1300, 265);

	/** The Constant DIMENSION_PETITE. */
	private static final Dimension DIMENSION_PETITE = new Dimension(1300, 175);

	/** The controlleur. */
	private Controlleur controlleur;
	/**
	 * Instantiates a new joueur actuel panel.
	 *
	 * @param joueur
	 *            the joueur
	 * @param control
	 *            the control
	 */
	public TapisPanel() {
		this.setLayout(new FlowLayout());
		this.setBackground(new java.awt.Color(255, 255, 255));
		this.setPreferredSize(DIMENSION_LARGE);
		this.setMaximumSize(DIMENSION_LARGE);
		this.setMinimumSize(DIMENSION_PETITE);
		this.setOpaque(false);
	}

}
