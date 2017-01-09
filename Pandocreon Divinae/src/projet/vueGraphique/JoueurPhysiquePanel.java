package projet.vueGraphique;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import projet.cartes.Carte;
import projet.cartes.StockCarte;
import projet.controlleur.Controlleur;
import projet.joueur.JoueurPhysique;
import projet.joueur.JoueurVirtuel;



public class JoueurPhysiquePanel extends JPanel {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant DIMENSION_LARGE. */
	private static final Dimension DIMENSION_LARGE = new Dimension(1300, 265);

	/** The Constant DIMENSION_PETITE. */
	private static final Dimension DIMENSION_PETITE = new Dimension(1300, 175);

	/** The controlleur. */
	private Controlleur controlleur;
	private JButton voirCarte= new JButton("VOUS");
	StockCarte s = new StockCarte();
	JoueurPhysique jp;
	JFrame jf = new JFrame();
	/**
	 * Instantiates a new joueur actuel panel.
	 *
	 * @param joueur
	 *            the joueur
	 * @param control
	 *            the control
	 */
	public JoueurPhysiquePanel( JoueurPhysique P1, Controlleur control) {
		this.setLayout(new BorderLayout());
		this.setBackground(new java.awt.Color(255, 255, 255));
		this.setPreferredSize(DIMENSION_LARGE);
		this.setMaximumSize(DIMENSION_LARGE);
		this.setMinimumSize(DIMENSION_PETITE);
		this.controlleur = control;
		this.setOpaque(false);
//		drawJoueur(P1);
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
		this.add(voirCarte);
		voirCarte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Button_on_click_voirCarte(e);
            }
        }); 
		if(joueur.getLaMain().getListeCartesMain().isEmpty()==false){
		for (int i = 0; i < joueur.getLaMain().getListeCartesMain().size(); i++) {
			Carte carte = joueur.getLaMain().getListeCartesMain().get(i);
			CarteJP cartePanel= new CarteJP(carte);
			this.add(cartePanel); 
			
		}
		}
		
	}
	

	
	public void Button_on_click_voirCarte(ActionEvent e){
		//this.setLayout(new FlowLayout());
		jp= Principal.getInstance().getControlleur().getModel().getJPhysique();
		
		jf.setSize(new Dimension(900, 300));
        jf.getContentPane().setLayout(new FlowLayout());
        
        
		if(jp.getLaMain().getlistePaireGuideVsCroyants().isEmpty()==false){
			for (int i = 0; i < jp.getLaMain().getlistePaireGuideVsCroyants().size(); i++) {
				
				for(int j=0; j<jp.getLaMain().getlistePaireGuideVsCroyants().get(i).size();j++){
					Carte carte = jp.getLaMain().getlistePaireGuideVsCroyants().get(i).get(j);
					CarteJP cartePanel= new CarteJP(carte);
					jf.getContentPane().add(cartePanel);
				}
				
			}
		}
		jf.setVisible(true);
    }   
}
  
