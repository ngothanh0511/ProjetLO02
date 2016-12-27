/**
 * 
 */
package projet.joueur;

import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.*;

/**
 * @author sweet
 *
 */
public class JeuView extends JFrame{
	
	JFrame frame;
	private JLabel textJoueur = new JLabel("Combien de joueur ?");
	private JTextField nbJoueur = new JTextField(10);
	private JLabel textNom = new JLabel("Mettez votre nom :");
	private JTextField nomJoueur = new JTextField(10);
	private JLabel modeDuJeu = new JLabel("Choisissez mode du jeu ");
	private JRadioButton facileBox = new JRadioButton();
	private JRadioButton difficileBox = new JRadioButton();
	private JButton verifier = new JButton("OK");
	ButtonGroup group = new ButtonGroup();
	
	JeuView(){
		JPanel jeuPanel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,200);
		
		
		group.add(facileBox);
		facileBox.setText("Facile");
		
		group.add(difficileBox);
		difficileBox.setText("Difficile");
		
		jeuPanel.add(textJoueur);
		jeuPanel.add(nbJoueur);
		jeuPanel.add(textNom);
		jeuPanel.add(nomJoueur);
		jeuPanel.add(modeDuJeu);
		jeuPanel.add(facileBox);
		jeuPanel.add(difficileBox);
		jeuPanel.add(verifier);
		
		this.add(jeuPanel);
	}
	
	public String getNomJoueur(){
		return nomJoueur.getText();
		
	}
	
	public int getNbJoueur(){
		return Integer.parseInt(nbJoueur.getText());
		
	}
	
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
	
	
	void addVerifListener(ActionListener listenClique){
		verifier.addActionListener(listenClique);
		//facileBox.addActionListener(listenClique);
		//difficileBox.addActionListener(listenClique);
	}
	
	public void setReponse(int nb, String name, String mod){
		Object[] options = {"Annuler",
        "Continuer"};
		int n = JOptionPane.showOptionDialog(
			    frame,
			    "Bonjour " + name + " vous avez choisi le mode " + mod + " et " + nb +" joueurs virtuel à jouer avec",
			    "Confirmation",
			    JOptionPane.YES_NO_OPTION,
			    JOptionPane.QUESTION_MESSAGE,
			    null,
			    options,
			    options[0]
			    );
	}
	
	public static void main(String[] args) {
	    	
	    	JeuView theView = new JeuView();
	        Partie thePartie = new Partie();
	        JeuControlleur cont = new JeuControlleur(theView,thePartie);
	        theView.setVisible(true);
	        
	    }
	
}
