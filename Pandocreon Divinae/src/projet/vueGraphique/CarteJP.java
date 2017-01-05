package projet.vueGraphique;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import projet.cartes.Carte;
import projet.joueur.Partie;

public class CarteJP extends CartePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CarteJP(Carte carte) {
		
		super(carte);
		int id = carte.getIdCarte();
		this.setPreferredSize(DIMENSION_LARGE);
		this.setMaximumSize(DIMENSION_LARGE);
		this.setMinimumSize(DIMENSION_PETITE);
		this.source = "images\\c"+id+".jpg";
		addMouseListener (new MouseAdapter(){
		
		
				private Color background;

		        @Override
		        public void mousePressed(MouseEvent e) {
		            background = getBackground();
		            setBackground(Color.RED);
		            repaint();
		        }

		        @Override
		        public void mouseReleased(MouseEvent e) {
		            setBackground(background);
		        }
		        public void mouseClicked(MouseEvent e) {
				switch (Principal.getInstance().action) {
				case 1 :
					Partie.getInstance().getJPhysique().defausserCarte(carte, Partie.getInstance().getStockCarte());
					Partie.getInstance().updateVue();
					break;
				case 2 :
					Partie.getInstance().getJPhysique().choisirCarte(carte, Partie.getInstance().getStockCarte());
					break;
				}
			}
		});	
	}
}
