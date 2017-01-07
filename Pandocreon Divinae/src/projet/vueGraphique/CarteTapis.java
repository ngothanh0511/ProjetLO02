package projet.vueGraphique;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import projet.cartes.Carte;
import projet.cartes.GuideSpirituel;
import projet.joueur.Partie;

public class CarteTapis extends CartePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CarteTapis(Carte carte) {
		super(carte);
		int id = carte.getIdCarte();
		this.setPreferredSize(DIMENSION_LARGE);
		this.setMaximumSize(DIMENSION_LARGE);
		this.setMinimumSize(DIMENSION_PETITE);
		this.source = "images\\c"+id+".jpg";
		this.addMouseListener(new MouseAdapter(){ 
	        public void mouseClicked(MouseEvent e) {
	        		carte.setEstChoisi(true);
	        		Principal.getInstance().getControlleur().getModel().setClickCarteCroyant(true);
	        		((GuideSpirituel) Principal.getInstance().getControlleur().getModel().getCarteChoisie()).recupererCarteCroyant(Partie.getInstance().getJPhysique(),id);
	        	}
		
	});	
	}
}

