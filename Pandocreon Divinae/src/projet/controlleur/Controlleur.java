package projet.controlleur;


import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;


import projet.cartes.Tapis;
import projet.joueur.Partie;
import projet.vueGraphique.Debut;
import projet.vueGraphique.Principal;

public class Controlleur {

	private Partie model;
	private Principal vue;
	private Thread t;

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
	/*	public void Button_on_click_NPartie(ActionEvent e){
			
            vue.setVisible(false);   
            vue.dispose();
            Debut D = new Debut(this);
            D.setVisible(true); 
		
            
        } */
	
	
    
        	
        
     
	public void Button_on_click_DefausserCarte(ActionEvent e){
        	JOptionPane.showMessageDialog(null,"Choisissez la carte que vous voulez défausser! Sinon, choisissez Jouer/Sacrifier Carte ");
            vue.getDefausserCarte().setEnabled(false);
        	vue.setAction(1);
            
        }    
	public void Button_on_click_JouerCarte(ActionEvent e){ 
 
        	model.getStockCarte().distribuerCartes(model.getJPhysique().getLaMain());
        	JOptionPane.showMessageDialog(null,"Choisissez la carte que vous voulez jouer ou sacrifier! \n Si vous avez fini votre tour, choisissez Passer Tour  ");

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
        	vue.getDetail().setText(vue.getDetail().getText()+"    \n  Vous avez termine votre tour! ");
        	JOptionPane.showMessageDialog(null,"Vous avez termine votre tour!");
			model.setEstJoueSonTour(true);


			
        }
	
	
	public String info(){
		StringBuffer sb= new StringBuffer(" Vous :                  Divinite "+this.getModel().getJPhysique().getJoueurDivinite()+"       Rang :"+Partie.getNumRang(this.getModel().getJPhysique())+"       Points Prieres: "+ this.getModel().getJPhysique().getPtPriere()
				+" \n Points d'Action :   "+this.getModel().getJPhysique().getPtActionJour()+" JOUR     "+this.getModel().getJPhysique().getPtActionNuit()+" NUIT     "+this.getModel().getJPhysique().getPtActionNeant()+" NEANT\n" );
		for (int i=1; i<this.getModel().getListeJoueur().size();i++){
			sb.append("\n Joueur "+this.getModel().getListeJoueur().get(i).getIdJoueur()+": Divinite "+this.getModel().getListeJoueur().get(i).getJoueurDivinite()+"        Rang:"+Partie.getNumRang(this.getModel().getListeJoueur().get(i))+"    Points Prieres: "+ this.getModel().getListeJoueur().get(i).getPtPriere());
		}
		return sb.toString();
	}
            
	 public static void main(String arg[]){    
		 Controlleur c = new Controlleur();
		 c.init();	
	    }    
        
	 public void init(){
		 
	        this.model = Partie.getInstance();
			if (!this.isReadyToPlay()) {
				Debut D = new Debut(this);
		        D.setVisible(true);
			}
			Principal main = Principal.getInstance();
			main.setVisible(false);
			this.vue= main;
			this.vue.setControlleur(this);
			this.model.addObserver(main);
			while (!(this.isReadyToPlay())) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
			if (this.isReadyToPlay()) {
				this.model.commencer();
			}
	 }
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
