package projet.vueGraphique;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.border.*;

import projet.cartes.Carte;
import projet.cartes.Tapis;
import projet.controlleur.Controlleur;
import projet.joueur.Joueur;
import projet.joueur.JoueurPhysique;
import projet.joueur.JoueurVirtuel;
import projet.joueur.Partie;

import java.util.*;
import java.io.*;

public class Principal extends JFrame implements Observer {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * La mÃ©thode static qui retourne l'instance unique de la classe Partie
	 * @return
	 */
	
	
	
    
    private JButton TerminerSonTour  =  new JButton("Passer tour");
    private JButton JouerCarte = new JButton("Jouer/Sacrifier carte");
    JButton Stop      = new JButton("Quitter le jeu");
    JButton Npartie   = new JButton("Nouvelle Partie");
    private JButton DefausserCarte = new JButton("Defausser votre carte");
    private JButton voirCarte= new JButton("VOUS");

    javax.swing.Timer T;
    JoueurPhysique P1;
    
    
    JTextArea Detail = new JTextArea(4,5);
    JTextArea resume = new JTextArea();
    JScrollPane scroll = new JScrollPane(Detail,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    public JTextArea getDetail(){
    	return Detail;
    }
    private Controlleur controlleur;
    JoueurPhysiquePanel jpPanel = new JoueurPhysiquePanel(P1, controlleur );
    TapisPanel tapis = new TapisPanel();
    CarteTapis[] carteTapis = new CarteTapis[10];
    JoueurVirtuelPanel[] jvPanel = new JoueurVirtuelPanel[6];
    ArrayList<Object> data= new ArrayList<Object>();
    String title[] = {"Rang","Joueur","Divinite","Points Prieres","Action Jour","Action Nuit","Action Neant"};
    
    //////
    
    private JFrame frame;
	/**
	 * Attribut de la classe DomaineCentre permettant d'indiquer la Parie du jeu.
	 *
	 * 
	 */
	
	
	JoueurPhysiquePanel panel_bas;
	/**
	 * Attribut de la classe DomaineCentre permettant d'indiquer les Panel qui prÃ©sente les informations du joueur virtuel.
	 *
	 * 
	 */
	JoueurVirtuelPanel[] panel_virtuel = new JoueurVirtuelPanel[6];
	/**
	 * Attribut de la classe DomaineCentre permettant d'indiquer les Panel qui prÃ©sente des panels poubelles.
	 *
	 * 
	 */
	JPanel[] panel_poubelle = new JPanel[2];
	/**
	 * Attribut de la classe DomaineCentre permettant d'indiquer le Panel en haut.
	 *
	 * 
	 */
	JPanel Panel_haut = new JPanel();
	/**
	 * Attribut de la classe DomaineCentre permettant d'indiquer le Panel en Centre.
	 *
	 * 
	 */
	TapisPanel panel_centre;
	/**
	 * Attribut de la classe DomaineCentre permettant d'indiquer le fond du jeu qui prÃ©sente le saison en cour.
	 *
	 * 
	 */
	JLabel fond;

    
   // Player P2;
   // Carte C1;
  //  Carte C2;
  //  Hand H1 = new Hand();
   // Hand H2 = new Hand();
    
    int numetape;
    private final int mode ;
    public int getMode(){
    	return mode;
    }
    private int nbrComponants;
    public int getNbrComponants(){
    	return nbrComponants;
    }
    
	
    public JButton getJouerCarte() {
		return JouerCarte;
	}
	public void setJouerCarte(JButton jouerCarte) {
		JouerCarte = jouerCarte;
	}
	public JButton getTerminerSonTour() {
		return TerminerSonTour;
	}
	public void setTerminerSonTour(JButton terminerSonTour) {
		TerminerSonTour = terminerSonTour;
	}
	public JButton getDefausserCarte() {
		return DefausserCarte;
	}
	public void setDefausserCarte(JButton defausserCarte) {
		DefausserCarte = defausserCarte;
	}
	boolean d;
    protected int action;
    public int getAction(){
    	return action;
    }
    public void setAction(int value){
    	action = value;
    }
    public CarteTapis[] getCarteTapis(){
    	return carteTapis;
    }
    public TapisPanel getTapis(){
    	return tapis;
    }
    public JoueurPhysiquePanel getJPPanel(){
    	return jpPanel;
    }
    public JPanel getPanelHaut(){
    	return Panel_haut;
    }
    public JTextArea getResume(){
    	return resume;
    }

    private static Principal instance;
    private JTextField textField;
    private JTable table;
    public static Principal getInstance() {
    	if (instance == null) {
			instance = new Principal();
		}
		return instance;
	}
    
    public Controlleur getControlleur(){
    	return controlleur;
    }
    public void setControlleur(Controlleur controlleur) {
		this.controlleur = controlleur;
	/*	controlleur.getModel().setNbrJoueurs(this.nbrComponants);
		if(this.mode==1){
		controlleur.getModel().setNiveau("F");
	}
		else if (this.mode ==2){
			controlleur.getModel().setNiveau("D");
		}
		*/
    }
    
    
    private Principal(){
        super("  Jeu de carte - Pandocreon Divinae");

        this.setSize(1400,750);
        setLocation(0,0);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);
        this.mode=Debut.getMode();
        this.nbrComponants = Debut.getNbrJoueur();
 //   	this.setControlleur(Partie.getInstance(), this);
  //  	P1 = this.controlleur.getModel().getJPhysique();
        //positionnement des composants
 //       GridBagLayout Gridbag = new GridBagLayout();
  //      GridBagConstraints Constraints = new GridBagConstraints();
   //     JPanel pane = new JPanel();
  //      pane.setSize(300,750);
  //      pane.setLayout(Gridbag);
    	getContentPane().setLayout(null);
       	
    	
    	
    	resume.setForeground(Color.RED);
    	resume.setBounds(768, 570, 435, 140);
    	getContentPane().add(resume);
    	
   /* 	Npartie.setBounds(1213, 591, 131, 41);
    	getContentPane().add(Npartie);  */
    	
    	
    	Stop.setBounds(1213, 653, 131, 41);
    	getContentPane().add(Stop);
    	
    	getDefausserCarte().setBounds(1213, 220, 131, 41);
    	getContentPane().add(getDefausserCarte());
    	
    	
    	getJouerCarte().setBounds(1213, 287, 131, 41);
    	getContentPane().add(getJouerCarte());
    	
    	getTerminerSonTour().setBounds(1213, 354, 131, 41);
    	getContentPane().add(getTerminerSonTour());
    	
    	voirCarte.setBounds(10, 429, 80, 29);
    	getContentPane().add(voirCarte);
		
    	
    	
    	jpPanel.setBounds(100, 362, 1103, 185);
    	getContentPane().add(jpPanel);
    	
    	Panel_haut.setBounds(10, 11, 1334, 170);
    	getContentPane().add(Panel_haut);
    	
    	tapis.setBounds(10, 178, 1193, 185);
    	getContentPane().add(tapis);
    ///	getContentPane().add(); */
    	
    	JLabel lblRsum = new JLabel("Resume");
    	lblRsum.setForeground(Color.BLACK);
    	lblRsum.setFont(new Font("Tahoma", Font.BOLD, 13));
    	lblRsum.setBounds(768, 543, 64, 22);
    	getContentPane().add(lblRsum);
    	getContentPane().add(scroll);
    	scroll.setBounds(new Rectangle(10, 570, 748, 140));
    	            Detail.setTabSize(10);
    	//      getContentPane().add(Detail);
    	      
    	      
    	//      Detail.setBounds(10, 541, 739, 152);
    	      //      pane.setBackground(bg);
    	            Detail.setFont(new Font("DialogInput",Font.BOLD,12));
    	            Detail.setText("la partie va commencer :\n");
    	            
    	            
    	            
    	            
        Color bg = new Color(255,255,255);
              
              
              
 
        
       
        
        
        //gestion du jeu
        
        d = false;
               
 /*       P1 = J.getPlayer(1);
        P2 = J.getPlayer(2);
        J.initFichier();
        P1.addHand();
        P2.addHand();
               
        Detail.setText(Detail.getText()+"la partie : ");
    //    Detail.setText(Detail.getText()+J.getFichier());
        
        //gestion du timer
        ActionListener taskPerformer = new ActionListener() {
              public void actionPerformed(ActionEvent evt) {
                  Button_on_click(evt);;
              }
          };
        
        
  /*      switch(type){
            case 1:
                Csuivant.setEnabled(false);
                numetape = 1;
                break;
            case 2:
                Psuivante.setEnabled(false);
                break;
            case 3:
                    
                    Csuivant.setEnabled(false);
                    Psuivante.setEnabled(false);
                    T = new javax.swing.Timer(1000,taskPerformer);
                    numetape = 1;
                    T.start();
                
                break;        
        }
        
        */
         
    	

		
		
		
        
        //gestion des evenement sur les composant
        Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlleur.Button_on_click_Stop(e);
            }
        });
        
  /*      Npartie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlleur.Button_on_click_NPartie(e);
            }
        }); */
        JouerCarte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controlleur.Button_on_click_JouerCarte(e);
            }
        });
        TerminerSonTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controlleur.Button_on_click_TerminerSonTour(e);
            }
        });
        
        DefausserCarte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controlleur.Button_on_click_DefausserCarte(e);
            }
        }); 
        
        voirCarte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controlleur.Button_on_click_voirCarte(e);
            }
        }); 
        
        
        //gestion des evenements sur la fenetre
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                dispose();
            }
            public void windowClosed(WindowEvent evt) {
                
            }
        });
        
        
    }
    
     
    public void initComposant() {
		tapis.removeAll();
		jpPanel.removeAll();
		jpPanel.drawCarteJoueur(controlleur.getModel().getJPhysique());
		this.drawCarteCroyants();
		this.setVisible(true);
		resume.removeAll();
		resume.setText(controlleur.info());
		Panel_haut.removeAll();
		for (int i = 0; i < controlleur.getModel().getListeJoueur().size(); i++) {
			if(controlleur.getModel().getListeJoueur().get(i).getTypeJoueur()=="Joueur Virtuel" ){
			jvPanel[i] = new JoueurVirtuelPanel((JoueurVirtuel) controlleur.getModel().getListeJoueur().get(i));
			jvPanel[i].setOpaque(false);
			Panel_haut.add(jvPanel[i]);
		}
		}
	} 
    
	public void drawCarteCroyants() {
		if(Tapis.getListeCartesCroyants().isEmpty()==false){
		for (int i = 0; i < Tapis.getListeCartesCroyants().size(); i++) {
			carteTapis[i] = new CarteTapis(Tapis.getListeCartesCroyants().get(i));
			tapis.add(carteTapis[i]);
		}
		}
		else{ tapis.removeAll();}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		initComposant();
	}
}
