package projet.vueGraphique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import projet.cartes.Carte;
import projet.cartes.StockCarte;
//import projet.controlleur.CarteJV;
import projet.controlleur.Controlleur;
import projet.joueur.JoueurPhysique;
import projet.joueur.JoueurVirtuel;
import projet.joueur.Main;

public class JoueurVirtuelPanel extends JPanel {
	
		protected Main laMain;
		private JButton voirCarte;
		private Controlleur controlleur;
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;

		/** Dimension large constante qui s'utilise quand la place est large. */
		private static final Dimension DIMENSION_LARGE = new Dimension(210,210);

		/** Dimension large constante qui s'utilise quand la place est PETITE. */
		private static final Dimension DIMENSION_PETITE = new Dimension(150, 120);
		
		private JoueurVirtuel jv;
		public JoueurVirtuelPanel(JoueurVirtuel joueur) {
			this.setBackground(new java.awt.Color(255, 255, 255));
			this.setPreferredSize(new Dimension(257, 294));
			this.setMaximumSize(DIMENSION_LARGE);
			this.setMinimumSize(DIMENSION_PETITE);
			this.setOpaque(false);
			jv = joueur;
			drawJoueur(jv);
			drawCarteJoueur(jv);
			voirCarte.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Button_on_click_voirCarte(e);
	            }
	        }); 
		}

		public static ImageIcon setBackground(String source, int width, int height) {
			BufferedImage img = null;
			try {
				img = ImageIO.read(new File(source));
			} catch (IOException e) {
				e.printStackTrace();
			}

			Image dimg0 = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(dimg0);
			return imageIcon;
		}

		public void drawJoueur(JoueurVirtuel joueur) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			//JLabel nom = new JLabel(joueur.getNom());
			voirCarte = new JButton(joueur.getNom());
			//nom.setFont(new Font("Arial", Font.BOLD,15));
			//nom.setSize(new Dimension(230, 30));
			//this.add(nom, BorderLayout.NORTH);
			this.add(getVoirCarte(), BorderLayout.WEST);
	
	
		}
		
		public void drawCarteJoueur(JoueurVirtuel joueur) {
			this.setLayout(new FlowLayout());
			CarteJV carteDivin= new CarteJV(joueur.getJoueurDivinite());
			this.add(carteDivin,BorderLayout.WEST);
		}

		private JButton getVoirCarte() {
	        return voirCarte;
	    }
		
		public void Button_on_click_voirCarte(ActionEvent e){
			//this.setLayout(new FlowLayout());
			JFrame jf = new JFrame();
			jf.setSize(new Dimension(900, 300));
	        jf.getContentPane().setLayout(new FlowLayout());
            
	        
			if(jv.getLaMain().getlistePaireGuideVsCroyants().isEmpty()==false){
				for (int i = 0; i < jv.getLaMain().getlistePaireGuideVsCroyants().size(); i++) {
					
					for(int j=0; j<jv.getLaMain().getlistePaireGuideVsCroyants().get(i).size();j++){
						Carte carte = jv.getLaMain().getlistePaireGuideVsCroyants().get(i).get(j);
						CarteJV cartePanel= new CarteJV(carte);
						jf.getContentPane().add(cartePanel);
					}
					
				}
			}
			jf.setVisible(true);
	    }   
		
		
}

