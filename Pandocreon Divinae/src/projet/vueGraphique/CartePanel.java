package projet.vueGraphique;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import projet.cartes.Carte;
import projet.joueur.Partie;


public class CartePanel extends JPanel {
	
private static final long serialVersionUID = 1L;
	
	/** Dimension large constante qui s'utilise quand la place est large */
	protected static final Dimension DIMENSION_LARGE = new Dimension(130,185);
	
	/** Dimension large constante qui s'utilise quand la place est petite. */
	protected static final Dimension DIMENSION_PETITE = new Dimension(50,65);
	
	/** Source d'image. */ 
	private String source;
	private Carte carte;
	/**
	 * Instantialiser un nouveau carteAllie panel.
	 *
	 * @param carte the carte
	 */
	public CartePanel(Carte carte) {
		
		
		this.carte = carte;
	//	if (carte== null) {
			this.source = "images\\c0.jpg";
	/*	}
		else { 
			int id = carte.getIdCarte();
			this.source = "images\\c"+id+".jpg";
		}*/
			
	} 

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		Image background = new ImageIcon(source).getImage();
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	}
}
