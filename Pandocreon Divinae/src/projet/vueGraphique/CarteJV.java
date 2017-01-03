package projet.vueGraphique;

import projet.cartes.Carte;

public class CarteJV extends CartePanel {

	public CarteJV(Carte carte) {
		super(carte);
		this.setPreferredSize(DIMENSION_PETITE);
		this.setMaximumSize(DIMENSION_LARGE);
		this.setMinimumSize(DIMENSION_PETITE);
		// TODO Auto-generated constructor stub
	}

}
