package projet.vueGraphique;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.*;

import projet.controlleur.Controlleur;
import projet.joueur.Partie;
 

public class Debut extends JFrame{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int mode; 
    String S;
    Principal P;
    Controlleur controlleur;
    Font police = new Font("Arial", Font.BOLD, 14);
    JLabel modeJeuLabel = new JLabel("Choix du mode de jeu :");
    JRadioButton jRadioButton1 = new JRadioButton(" Facile.");
    JRadioButton jRadioButton2 = new JRadioButton(" Difficile.");
    ButtonGroup  buttonGroup1  = new ButtonGroup();
    JButton      btok          = new JButton("ok");
    JButton      btnQuit       = new JButton("annuler");
	JLabel nombreJoueurLabel = new JLabel("Nombre de componants: "); 
	JComboBox comboBox_1 = new JComboBox();
	private JTextField textField;
	private static int nbrComponants;
	
    public Debut(Controlleur controlleur) {
    	this.controlleur= controlleur;
        this.mode = 1;
        
        //global
        this.setSize(500,320);
        this.setLocation(400,200);
        this.setTitle("::jeu de carte - Pandocreon Divinae::");
        this.getContentPane().setLayout(null);
        modeJeuLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        //les composants
        // label 1
        modeJeuLabel.setBounds(new Rectangle(30, 196, 150, 20));
        //les zones de choix
        //choix 1
        jRadioButton1.setSelected(true);
        jRadioButton1.setBounds(new Rectangle(182, 199, 150, 15));
        jRadioButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                radioButtons_itemStateChanged(e);
            }
        });
        //choix 2
        jRadioButton2.setBounds(new Rectangle(182, 217, 150, 15));
        jRadioButton2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                radioButtons_itemStateChanged(e);
            }
        });
        //les bouttons
        //ok
        btok.setBounds(new Rectangle(263, 247, 98, 23));
        btok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Button_on_click(e);
            }
        });
        //annuler
        btnQuit.setBounds(new Rectangle(386, 247, 98, 23));
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Button_on_click(e);
            }
        });
        
        //ajout des composants
        this.getContentPane().add(modeJeuLabel, null);
        this.getContentPane().add(jRadioButton1,null);
        this.getContentPane().add(jRadioButton2,null);
        this.buttonGroup1.add(this.jRadioButton1);
        this.buttonGroup1.add(this.jRadioButton2);
        this.getContentPane().add(this.btnQuit);
        this.getContentPane().add(this.btok);
        
        JLabel lblBienvenueDuJeu = new JLabel("Bienvenue du jeu Pandocreo Divinae");
        lblBienvenueDuJeu.setForeground(Color.GREEN);
        lblBienvenueDuJeu.setFont(new Font("Copperplate Gothic Bold", Font.BOLD | Font.ITALIC, 15));
        lblBienvenueDuJeu.setBounds(68, 4, 360, 55);
        getContentPane().add(lblBienvenueDuJeu);
        
        JLabel lblVotreNom = new JLabel("Votre age :");
        lblVotreNom.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblVotreNom.setBounds(30, 113, 90, 17);
        getContentPane().add(lblVotreNom);
        
        textField = new JTextField();
        textField.setBounds(187, 66, 119, 30);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        JLabel label = new JLabel("Votre nom :");
        label.setFont(new Font("Tahoma", Font.BOLD, 13));
        label.setBounds(30, 74, 90, 17);
        getContentPane().add(label);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19 ", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40"}));
        comboBox.setBounds(187, 112, 40, 20);
        getContentPane().add(comboBox);
        
        JLabel label_1 = new JLabel("Nombre componants :");
        label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        label_1.setBounds(30, 152, 144, 17);
        getContentPane().add(label_1);
        
        
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
        comboBox_1.setBounds(187, 151, 40, 20);
        getContentPane().add(comboBox_1);
        

		
        
        
        
        //gestion des événements sur la fenétre
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                dispose();
            }
            public void windowClosed(WindowEvent evt) {
                
            }
        });
    }
    
   
   
   /**
    * renvoie le choix du mode de jeu
    */
    public static int getMode(){
        return mode;
    }
    
   
    public  void charger(String s) throws IOException{
        Partie obj = null;
        try{
            ObjectInputStream load = new ObjectInputStream(new FileInputStream(s));
            obj = (Partie) load.readObject();
            load.close();
            System.out.println(obj);
            P = Principal.getInstance();
            obj.setInstance(obj);
            obj.addObserver(P);
            controlleur.setModel(obj);
            obj.updateVue();
        	P.setVisible(true);
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Impossible de charger");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    /**
     * gére les évenement sur les composants de la fenétre.
     */
    
    void radioButtons_itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        if (source == jRadioButton1) this.mode = 1;
        if (source == jRadioButton2) this.mode = 2;
    }
    
    //gestion des evenement sur les boutons
    void Button_on_click(ActionEvent e){
        Object source = e.getSource();
        if(source == btok){
            
            this.setVisible(false);   
            this.dispose();
 /*           int R = JOptionPane.showConfirmDialog(null,"voulez vous charger une partie?");
            if(R == 0){
                S = JOptionPane.showInputDialog(null,"Entrez votre partie sous forme 11112222....(au min 20 chiffre 1-5)");
                try {
					charger(S);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
        //    	controlleur.setReadyToPlay(true);
            }
            else{  */
            	this.setNbrJoueur();
            	P = Principal.getInstance();
            	P.setVisible(true);
            	Partie.getInstance().setNbrJoueurs(nbrComponants);
            	if(mode==1){
            	Partie.getInstance().setNiveau("F");
            	}
            	else if(mode ==2){
                	Partie.getInstance().setNiveau("D");

            	}
            	controlleur.setReadyToPlay(true);
 //      }
        }
        if(source == btnQuit){
            this.setVisible(false);   
            this.dispose();
        } 
    }
    public void setNbrJoueur() {
		this.nbrComponants = this.comboBox_1.getSelectedIndex() +1;
	}

	public static int getNbrJoueur() {
		return nbrComponants;
	}
}