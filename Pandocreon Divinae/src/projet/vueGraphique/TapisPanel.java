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
	StockCarte s = new StockCarte();
	/**
	 * Instantiates a new joueur actuel panel.
	 *
	 * @param joueur
	 *            the joueur
	 * @param control
	 *            the control
	 */
	public TapisPanel() {

		this.setBackground(new java.awt.Color(255, 255, 255));
		this.setPreferredSize(DIMENSION_LARGE);
		this.setMaximumSize(DIMENSION_LARGE);
		this.setMinimumSize(DIMENSION_PETITE);
		this.setOpaque(false);
		drawCarteCroyants();
	}

	/**
	 * Draw joueur.
	 *
	 * @param joueur
	 *            the joueur
	 */
	public void drawCarteCroyants() {
		this.setLayout(new FlowLayout());
		if(Tapis.getListeCartesCroyants().isEmpty()==false){
		for (int i = 0; i < Tapis.getListeCartesCroyants().size(); i++) {
			Carte carte = Tapis.getListeCartesCroyants().get(i);
			CarteJV cartePanel= new CarteJV(carte);
//			cartePanel.addMouseListener(controlleur.jouerCarteAllie(carte));
			this.add(cartePanel);
		}
		}
	}
}
