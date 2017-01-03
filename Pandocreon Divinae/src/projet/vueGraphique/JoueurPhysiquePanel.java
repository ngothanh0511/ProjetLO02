package projet.vueGraphique;



import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import projet.cartes.Carte;
import projet.cartes.StockCarte;
import projet.controlleur.Controlleur;
import projet.joueur.JoueurPhysique;



public class JoueurPhysiquePanel extends JPanel {
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
	public JoueurPhysiquePanel( JoueurPhysique P1, Controlleur control) {

		this.setBackground(new java.awt.Color(255, 255, 255));
		this.setPreferredSize(DIMENSION_LARGE);
		this.setMaximumSize(DIMENSION_LARGE);
		this.setMinimumSize(DIMENSION_PETITE);
		this.controlleur = control;
		this.setOpaque(false);
//		drawCarteJoueur(P1);
		
	}

	/**
	 * Draw joueur.
	 *
	 * @param joueur
	 *            the joueur
	 */
	public void drawCarteJoueur(JoueurPhysique joueur) {
		this.setLayout(new FlowLayout());
		if(joueur.getLaMain().getListeCartesMain().isEmpty()==false){
		for (int i = 0; i < joueur.getLaMain().getListeCartesMain().size(); i++) {
			Carte carte = joueur.getLaMain().getListeCartesMain().get(i);
			CarteJP cartePanel= new CarteJP(carte);
			this.add(cartePanel); 
			
		}
		}
	}
}
  
