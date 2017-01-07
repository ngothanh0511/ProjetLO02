package projet.vueGraphique;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import projet.cartes.Carte;


public class CarteJV extends JPanel{
	
private static final long serialVersionUID = 1L;
	
	/** Dimension large constante qui s'utilise quand la place est large */
	protected static final Dimension DIMENSION_LARGE = new Dimension(100,120);
	
	/** Dimension large constante qui s'utilise quand la place est petite. */
	protected static final Dimension DIMENSION_PETITE = new Dimension(50,65);
	
	/** Source d'image. */ 
	protected String source;
	private Carte carte;
	/**
	 * Instantialiser un nouveau carteAllie panel.
	 *
	 * @param carte the carte
	 */
	
	public CarteJV(String  nomDivinite) {
		this.setPreferredSize(DIMENSION_LARGE);
		this.setMaximumSize(DIMENSION_LARGE);
		this.setMinimumSize(DIMENSION_PETITE);
		this.source = "images\\"+nomDivinite+".jpg";
		
	}
	public CarteJV(Carte carte) {
		
		//super(carte);
		int id = carte.getIdCarte();
		this.setPreferredSize(DIMENSION_LARGE);
		this.setMaximumSize(DIMENSION_LARGE);
		this.setMinimumSize(DIMENSION_PETITE);
		this.source = "images\\c"+id+".jpg";
		}
	
	public void paintComponent(Graphics g) {
		Image background = new ImageIcon(source).getImage();
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
		/*
		super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(90));
        g2d.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        g2d.setTransform(old);*/
        //g2d.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        //things you draw after here will not be rotated
	}

}
