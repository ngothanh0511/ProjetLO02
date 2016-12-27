package projet.joueur;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;

public class JeuControlleur {
	private JeuView v;
	private Partie p;
	
	public JeuControlleur(JeuView laVue,Partie laPartie){
		this.v=laVue;
		this.p=laPartie;
		this.v.addVerifListener(new VerificationListener());
		
		
	}
	
	class VerificationListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int nbJ;
			String nom,mode;
			ButtonGroup buttonGroup = v.group;
			nbJ= v.getNbJoueur();
			nom = v.getNomJoueur();
			mode = v.getSelectedButtonText(buttonGroup);
			try{
				
				v.setReponse(nbJ, nom, mode);
			}catch(NumberFormatException e){
				System.out.println("Hi");
			}
			
		}
		
	}
}
