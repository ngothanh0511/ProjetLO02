package projet.controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import projet.cartes.Carte;
import projet.cartes.StockCarte;
import projet.cartes.Tapis;
import projet.joueur.Partie;
import projet.vueGraphique.Debut;
import projet.vueGraphique.Principal;

public class Controlleur {

	private Partie model;
	private Principal vue;
	private Thread t;
	private StockCarte s;

	public Controlleur() {
		
	}
	
	private boolean readyToPlay = false;

	
	public void Button_on_click_Stop(ActionEvent e){
            int reponse = JOptionPane.showConfirmDialog(null,"voulez-vous quitter le jeu?");
            if(reponse == 0){
                vue.setVisible(false);   
                vue.dispose();
            }    
        }
	public void Button_on_click_NPartie(ActionEvent e){
            vue.setVisible(false);   
            vue.dispose();
            Debut D = new Debut(this);
            D.setVisible(true);
        }
    
        	
        
     
	public void Button_on_click_DefausserCarte(ActionEvent e){
        	vue.getDetail().setText(vue.getDetail().getText()+"\n Choisissez la carte que vous voulez défausser! Sinon, choisissez Jouer/Sacrifier Carte ");
            vue.getDefausserCarte().setEnabled(false);
        	vue.setAction(1);
            
        }    
	public void Button_on_click_JouerCarte(ActionEvent e){ 
 
        	model.getStockCarte().distribuerCartes(model.getJPhysique().getLaMain());
        	vue.getDetail().setText(vue.getDetail().getText()+"\n  Choisissez la carte que vous voulez jouer ou sacrifier! \n Si vous avez fini votre tour, choisissez Passer Tour ");
        	vue.getJouerCarte().setEnabled(false);
        	vue.getDefausserCarte().setEnabled(false);
        	vue.setAction(2);
        }
	public void Button_on_click_TerminerSonTour(ActionEvent e){  
		vue.getJouerCarte().setEnabled(false);
    	vue.getDefausserCarte().setEnabled(false);
    	vue.getTerminerSonTour().setEnabled(false);
        	for (int i = 0; i< Tapis.getListeCartesCroyantsIndisponible().size();i++){
				Tapis.getListeCartesCroyants().add(Tapis.getListeCartesCroyantsIndisponible().get(i));
				Tapis.getListeCartesCroyantsIndisponible().remove(i);
        	}
        	vue.getDetail().setText(vue.getDetail().getText()+"    \n  Vous avez terminé votre tour! ");
			model.setEstJoueSonTour(true);

/*			model.getJPhysique().seta(model.getJPhysique().geta()+1);
			
			model.getJPhysique().jouerSonTour(model.getStockCarte()); */
			
        }
	
	public String info(){
		StringBuffer sb= new StringBuffer(" Vous :                  Divinité "+this.getModel().getJPhysique().getJoueurDivinite()+"       Rang :"+Partie.getNumRang(this.getModel().getJPhysique())+"       Points Prières: "+ this.getModel().getJPhysique().getPtPriere()
				+" \n Points d'Action :   "+this.getModel().getJPhysique().getPtActionJour()+" JOUR     "+this.getModel().getJPhysique().getPtActionNuit()+" NUIT     "+this.getModel().getJPhysique().getPtActionNeant()+" NEANT\n" );
		for (int i=1; i<this.getModel().getListeJoueur().size();i++){
			sb.append("\n Joueur "+this.getModel().getListeJoueur().get(i).getIdJoueur()+": Divinité "+this.getModel().getListeJoueur().get(i).getJoueurDivinite()+"        Rang:"+Partie.getNumRang(this.getModel().getListeJoueur().get(i))+"    Points Prières: "+ this.getModel().getListeJoueur().get(i).getPtPriere());
		}
		return sb.toString();
	}
            
	 public static void main(String arg[]){    
	    	
		 	Controlleur c = new Controlleur();
	        c.model = Partie.getInstance();
			if (!c.isReadyToPlay()) {
				Debut D = new Debut(c);
		        D.setVisible(true);
			}
			Principal main = Principal.getInstance();
			main.setVisible(false);
			c.vue= main;
			c.vue.setControlleur(c);
			c.model.addObserver(main);
			while (!(c.isReadyToPlay())) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
			if (c.isReadyToPlay()) {
				c.model.commencer();
			}
	    }    
        
  /*      if(source == Csuivant){
            
                this.setVisible(false);   
                this.dispose();
                Debut D = new Debut();
                D.setVisible(true);
            }
        }
        if(source == T){
            
            
          }
          if(source == this.ChFichier){
                  
                  
    }

/*	public ActionListener nextButton() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				vue.setNbrJoueur();
				vue.setNiveau();

				model.setNbrJoueurs(vue.getNbrJoueur());
				if (vue.getNiveau()==0){
				model.setNiveau("F");
				}
				else if(vue.getNiveau()==1){
					model.setNiveau("D");
				}
				// else s'affiche un pop-up qui demande de choisir le niveau box

				String nomJoueurPhys = vue.getNomJoueurPhysTextField()
						.getText();
				int ageJoueurPhys = vue.getAgeJoueurPhysComboBox()
						.getSelectedIndex() + 4;
				

				t = new Thread(model);
				t.start();
			}
		};
	}

	public MouseListener jouerCarte(Carte carte) {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.getJPhysique().choisirCarte(carte,s);
	//			model.getManche().setHasChanged(true);
				}
		//	}
		};
	}

/*	public MouseListener jouerCarteAllie(CarteAllie carte) {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1 && model.getTourJoueur() == 0) {
					JoueurPhysique joueur = (JoueurPhysique) model
							.getListJoueur().get(0);
					String[] adversaire = new String[model.getNbrJoueurTotal() - 1];
					for (int i = 0; i < model.getNbrJoueurTotal() - 1; i++) {
						adversaire[i] = model.getListJoueur().get(i + 1)
								.getNom();
					}
					JOptionPane jop3 = new JOptionPane();
					int rang2 = jop3.showOptionDialog(null,
							"Veuillez indiquer une adversaire !",
							"Taupe Geant !", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, adversaire,
							adversaire[model.getNbrJoueurTotal() - 2]);
					joueur.setAdversaire(model.getListJoueur().get(rang2 + 1));

				}
			}
		};
	} */

	public Partie getModel() {
		return model;  
	}

	public Thread getThread() {
		return t;
	}
	public boolean isReadyToPlay() {
		return readyToPlay;
	}
	public void setReadyToPlay(boolean readyToPlay) {
		this.readyToPlay = readyToPlay;
	}

	
}