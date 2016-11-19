package projet.cartes;
import projet.joueur.*;
import java.util.ArrayList;
import java.util.Collections;

import projet.joueur.Joueur;
/**
 * La classe StockCarte représente une collection de toutes les cartes d'Action dans le jeu
 * @author Tung NGO
 *
 */
public class StockCarte {
	protected ArrayList <Carte> stock = new ArrayList <Carte>();
	/**
	 * Constructeur par défaut de la classe StockCarte
	 * A la construction, le stock Carte contient 80 cartes d'Action
	 */
	public StockCarte(){
		CarteCroyants c_1 = new CarteCroyants("Moines", 1, TypeCarte.Croyant, Origine.Jour,new String[] {"Hunmain", "Nature", "Mystique"}, 2, CapaciteSpeciale.Cap_1);
		CarteCroyants c_2 = new CarteCroyants("Moines", 2, TypeCarte.Croyant, Origine.Jour,new String[] {"Hunmain", "Chaos", "Mystique"}, 2, CapaciteSpeciale.Cap_1);
		CarteCroyants c_3 = new CarteCroyants("Moines", 3, TypeCarte.Croyant, Origine.Jour,new String[] {"Chaos", "Symboles", "Mystique"}, 2, CapaciteSpeciale.Cap_1);
		CarteCroyants c_4 = new CarteCroyants("Moines", 4, TypeCarte.Croyant, Origine.Jour,new String[] {"Symboles", "Nature", "Mystique"}, 2, CapaciteSpeciale.Cap_1);
		CarteCroyants c_5 = new CarteCroyants("Moines", 5, TypeCarte.Croyant, Origine.Jour,new String[] {"Chaos", "Nature", "Mystique"}, 2, CapaciteSpeciale.Cap_1);
		CarteCroyants c_6 = new CarteCroyants("Travailleurs", 6, TypeCarte.Croyant, Origine.Jour,new String[] {"Hunmain", "Chaos", "Symboles"}, 2, CapaciteSpeciale.Cap_2);
		CarteCroyants c_7 = new CarteCroyants("Travailleurs", 7, TypeCarte.Croyant, Origine.Jour,new String[] {"Hunmain", "Nature", "Symboles"}, 2, CapaciteSpeciale.Cap_3);
		CarteCroyants c_8 = new CarteCroyants("Travailleurs", 8, TypeCarte.Croyant, Origine.Jour,new String[] {"Hunmain", "Chaos", "Mystique"}, 2, CapaciteSpeciale.Cap_4);
		CarteCroyants c_9 = new CarteCroyants("Ermite", 9, TypeCarte.Croyant, Origine.Jour,new String[] {"Chaos", "Nature", "Mystique"}, 1, CapaciteSpeciale.Cap_5);
		CarteCroyants c_10 = new CarteCroyants("Ermite", 10, TypeCarte.Croyant, Origine.Jour,new String[] {"Symboles", "Nature", "Mystique"}, 1, CapaciteSpeciale.Cap_5);
		CarteCroyants c_11 = new CarteCroyants("Intégristes", 11, TypeCarte.Croyant, Origine.Jour,new String[] {"Hunmain", "Nature", "Chaos"}, 1, CapaciteSpeciale.Cap_6);
		CarteCroyants c_12 = new CarteCroyants("Guerriers Saints", 12, TypeCarte.Croyant, Origine.Jour,new String[] {"Symboles", "Nature", "Mystique"}, 4, CapaciteSpeciale.Cap_7);
		CarteCroyants c_13 = new CarteCroyants("Diplomates", 13, TypeCarte.Croyant, Origine.Jour,new String[] {"Hunmain", "Chaos", "Symboles"}, 4, CapaciteSpeciale.Cap_8);
		CarteCroyants c_14 = new CarteCroyants("Démons", 14, TypeCarte.Croyant, Origine.Nuit,new String[] {"Hunmain", "Nature", "Mystique"}, 2, CapaciteSpeciale.Cap_9);
		CarteCroyants c_15 = new CarteCroyants("Démons", 15, TypeCarte.Croyant, Origine.Nuit,new String[] {"Hunmain", "Chaos", "Mystique"}, 2, CapaciteSpeciale.Cap_9);
		CarteCroyants c_16 = new CarteCroyants("Démons", 16, TypeCarte.Croyant, Origine.Nuit,new String[] {"Symboles", "Chaos", "Mystique"}, 2, CapaciteSpeciale.Cap_9);
		CarteCroyants c_17 = new CarteCroyants("Démons", 17, TypeCarte.Croyant, Origine.Nuit,new String[] {"Symboles", "Nature", "Mystique"}, 2, CapaciteSpeciale.Cap_9);
		CarteCroyants c_18 = new CarteCroyants("Démons", 18, TypeCarte.Croyant, Origine.Nuit,new String[] {"Chaos", "Nature", "Mystique"}, 2, CapaciteSpeciale.Cap_9);
		CarteCroyants c_19 = new CarteCroyants("Alchimistes", 19, TypeCarte.Croyant, Origine.Nuit,new String[] {"Symboles", "Nature", "Chaos"}, 2, CapaciteSpeciale.Cap_10);
		CarteCroyants c_20 = new CarteCroyants("Alchimistes", 20, TypeCarte.Croyant, Origine.Nuit,new String[] {"Chaos", "Nature", "Mystique"}, 2, CapaciteSpeciale.Cap_11);
		CarteCroyants c_21 = new CarteCroyants("Alchimistes", 21, TypeCarte.Croyant, Origine.Nuit,new String[] {"Symboles", "Nature", "Chaos"}, 2, CapaciteSpeciale.Cap_4);
		CarteCroyants c_22 = new CarteCroyants("Vampire", 22, TypeCarte.Croyant, Origine.Nuit,new String[] {"Hunmain", "Nature", "Symboles"}, 1, CapaciteSpeciale.Cap_5);
		CarteCroyants c_23 = new CarteCroyants("Vampire", 23, TypeCarte.Croyant, Origine.Nuit,new String[] {"Hunmain", "Chaos", "Mystique"}, 1, CapaciteSpeciale.Cap_5);
		CarteCroyants c_24 = new CarteCroyants("Lycantbropes", 24, TypeCarte.Croyant, Origine.Nuit,new String[] {"Hunmain", "Nature", "Chaos"}, 4, CapaciteSpeciale.Cap_12);
		CarteCroyants c_25 = new CarteCroyants("Pillards", 25, TypeCarte.Croyant, Origine.Nuit,new String[] {"Symboles", "Nature", "Mystique"}, 4, CapaciteSpeciale.Cap_13);
		CarteCroyants c_26 = new CarteCroyants("Illusionnistes", 26, TypeCarte.Croyant, Origine.Nuit,new String[] {"Hunmain", "Chaos", "Symboles"}, 4, CapaciteSpeciale.Cap_14);
		CarteCroyants c_27 = new CarteCroyants("Esprits", 27, TypeCarte.Croyant, Origine.Neant,new String[] {"Hunmain", "Nature", "Mystique"}, 2, CapaciteSpeciale.Cap_15);
		CarteCroyants c_28 = new CarteCroyants("Esprits", 28, TypeCarte.Croyant, Origine.Neant,new String[] {"Hunmain", "Chaos", "Mystique"}, 2, CapaciteSpeciale.Cap_15);
		CarteCroyants c_29 = new CarteCroyants("Esprits", 29, TypeCarte.Croyant, Origine.Neant,new String[] {"Symboles", "Chaos", "Mystique"}, 2, CapaciteSpeciale.Cap_15);
		CarteCroyants c_30 = new CarteCroyants("Esprits", 30, TypeCarte.Croyant, Origine.Neant,new String[] {"Symboles", "Nature", "Mystique"}, 2, CapaciteSpeciale.Cap_15);
		CarteCroyants c_31 = new CarteCroyants("Esprits", 31, TypeCarte.Croyant, Origine.Neant,new String[] {"Nature", "Chaos", "Mystique"}, 2, CapaciteSpeciale.Cap_15);
		CarteCroyants c_32 = new CarteCroyants("Aliénés", 32, TypeCarte.Croyant, Origine.Neant,new String[] {"Hunmain", "Chaos", "Symboles"}, 2, CapaciteSpeciale.Cap_2);
		CarteCroyants c_33 = new CarteCroyants("Aliénés", 33, TypeCarte.Croyant, Origine.Neant,new String[] {"Hunmain", "Nature", "Symboles"}, 2, CapaciteSpeciale.Cap_3);
		CarteCroyants c_34 = new CarteCroyants("Aliénés", 34, TypeCarte.Croyant, Origine.Neant,new String[] {"Hunmain", "Chaos", "Mystique"}, 2, CapaciteSpeciale.Cap_4);
		CarteCroyants c_35 = new CarteCroyants("Revenant", 35, TypeCarte.Croyant, Origine.Neant,new String[] {"Hunmain", "Nature", "Mystique"}, 1, CapaciteSpeciale.Cap_8);
		CarteCroyants c_36 = new CarteCroyants("Révolutionnaires", 36, TypeCarte.Croyant, Origine.Neant,new String[] {"Hunmain", "Chaos", "Symboles"}, 1, CapaciteSpeciale.Cap_16);
		CarteCroyants c_37 = new CarteCroyants("Nibillistes", 37, TypeCarte.Croyant, Origine.Neant,new String[] {"Symboles", "Chaos", "Mystique"}, 4, CapaciteSpeciale.Cap_17);
		GuideSpirituel c_38 = new GuideSpirituel("Martyr", 38, TypeCarte.GuideSpirituel, Origine.Jour,new String[] {"Hunmain", "Nature"}, 2, CapaciteSpeciale.Cap_18); 
		GuideSpirituel c_39 = new GuideSpirituel("Martyr", 39, TypeCarte.GuideSpirituel, Origine.Nuit,new String[] {"Hunmain", "Symboles"}, 2, CapaciteSpeciale.Cap_18); 
		GuideSpirituel c_40 = new GuideSpirituel("Martyr", 40, TypeCarte.GuideSpirituel, Origine.Neant,new String[] {"Chaos", "Nature"}, 2, CapaciteSpeciale.Cap_18); 
		GuideSpirituel c_41 = new GuideSpirituel("Clerc", 41, TypeCarte.GuideSpirituel, Origine.Jour,new String[] {"Hunmain", "Chaos"}, 2, CapaciteSpeciale.Cap_19); 
		GuideSpirituel c_42 = new GuideSpirituel("Clerc", 42, TypeCarte.GuideSpirituel, Origine.Nuit,new String[] {"Symboles", "Nature"}, 2, CapaciteSpeciale.Cap_19); 
		GuideSpirituel c_43 = new GuideSpirituel("Clerc", 43, TypeCarte.GuideSpirituel, Origine.Neant,new String[] {"Mystique", "Nature"}, 2, CapaciteSpeciale.Cap_19); 
		GuideSpirituel c_44 = new GuideSpirituel("Clerc", 44, TypeCarte.GuideSpirituel, Origine.Jour,new String[] {"Chaos", "Nature"}, 2, CapaciteSpeciale.Cap_19); 
		GuideSpirituel c_45 = new GuideSpirituel("Clerc", 45, TypeCarte.GuideSpirituel, Origine.Nuit,new String[] {"Symboles", "Mystique"}, 2, CapaciteSpeciale.Cap_19); 
		GuideSpirituel c_46 = new GuideSpirituel("Clerc", 46, TypeCarte.GuideSpirituel, Origine.Neant,new String[] {"Chaos", "Symboles"}, 2, CapaciteSpeciale.Cap_19); 
		GuideSpirituel c_47 = new GuideSpirituel("Clerc", 47, TypeCarte.GuideSpirituel, Origine.Jour,new String[] {"Chaos", "Mystique"}, 2, CapaciteSpeciale.Cap_19); 
		GuideSpirituel c_48 = new GuideSpirituel("Clerc", 48, TypeCarte.GuideSpirituel, Origine.Nuit,new String[] {"Hunmain", "Nature"}, 2, CapaciteSpeciale.Cap_19); 
		GuideSpirituel c_49 = new GuideSpirituel("Shaman", 49, TypeCarte.GuideSpirituel, Origine.Nuit,new String[] {"Symboles", "Nature"}, 3, CapaciteSpeciale.Cap_20); 
		GuideSpirituel c_50 = new GuideSpirituel("Anarchiste", 50, TypeCarte.GuideSpirituel, Origine.Neant,new String[] {"Hunmain", "Chaos"}, 3, CapaciteSpeciale.Cap_21); 
		GuideSpirituel c_51 = new GuideSpirituel("Paladin", 51, TypeCarte.GuideSpirituel, Origine.Jour,new String[] {"Hunmain", "Mystique"}, 3, CapaciteSpeciale.Cap_22); 
		GuideSpirituel c_52 = new GuideSpirituel("Ascète", 52, TypeCarte.GuideSpirituel, Origine.Nuit,new String[] {"Hunmain", "Symboles"}, 1, CapaciteSpeciale.Cap_23); 
		GuideSpirituel c_53 = new GuideSpirituel("Devin", 53, TypeCarte.GuideSpirituel, Origine.Neant,new String[] {"Mystique", "Nature"}, 1, CapaciteSpeciale.Cap_24); 
		GuideSpirituel c_54 = new GuideSpirituel("Exorciste", 54, TypeCarte.GuideSpirituel, Origine.Jour,new String[] {"Chaos", "Mystique"}, 1, CapaciteSpeciale.Cap_25); 
		GuideSpirituel c_55 = new GuideSpirituel("Sorcier", 55, TypeCarte.GuideSpirituel, Origine.Nuit,new String[] {"Mystique", "Symboles"}, 3, CapaciteSpeciale.Cap_26); 
		GuideSpirituel c_56 = new GuideSpirituel("Tyran", 56, TypeCarte.GuideSpirituel, Origine.Neant,new String[] {"Chaos", "Symboles"}, 3, CapaciteSpeciale.Cap_27); 
		GuideSpirituel c_57 = new GuideSpirituel("Messie", 57, TypeCarte.GuideSpirituel, Origine.Jour,new String[] {"Hunmain", "Mystique"}, 3, CapaciteSpeciale.Cap_28); 
		DeusEx c_58= new DeusEx("Colère Divine", 58, TypeCarte.DeusEx, Origine.Jour, CapaciteSpeciale.Cap_29);
		DeusEx c_59= new DeusEx("Colère Divine", 59, TypeCarte.DeusEx, Origine.Nuit, CapaciteSpeciale.Cap_30);
		DeusEx c_60= new DeusEx("Stase", 60, TypeCarte.DeusEx, Origine.Jour, CapaciteSpeciale.Cap_31);
		DeusEx c_61= new DeusEx("Ordre Céleste", 61, TypeCarte.DeusEx, Origine.Jour, CapaciteSpeciale.Cap_32);
		DeusEx c_62= new DeusEx("Fourberie", 62, TypeCarte.DeusEx, Origine.Nuit, CapaciteSpeciale.Cap_33);
		DeusEx c_63= new DeusEx("Diversion", 63, TypeCarte.DeusEx, Origine.Nuit, CapaciteSpeciale.Cap_34);
		DeusEx c_64= new DeusEx("Concentration", 64, TypeCarte.DeusEx, Origine.Neant, CapaciteSpeciale.Cap_32);
		DeusEx c_65= new DeusEx("Trou Noir", 65, TypeCarte.DeusEx, Origine.Neant, CapaciteSpeciale.Cap_17);
		DeusEx c_66= new DeusEx("Phoenix", 66, TypeCarte.DeusEx, Origine.Neant, CapaciteSpeciale.Cap_35);
		DeusEx c_67= new DeusEx("Influence Jour", 67, TypeCarte.DeusEx, Origine.None, CapaciteSpeciale.Cap_36);
		DeusEx c_68= new DeusEx("Influence Nuit", 68, TypeCarte.DeusEx, Origine.None, CapaciteSpeciale.Cap_37);
		DeusEx c_69= new DeusEx("Influence Néant", 69, TypeCarte.DeusEx, Origine.None, CapaciteSpeciale.Cap_38);
		DeusEx c_70= new DeusEx("Influence Nulle", 70, TypeCarte.DeusEx, Origine.None, CapaciteSpeciale.Cap_39);
		DeusEx c_71= new DeusEx("Influence Nulle", 71, TypeCarte.DeusEx, Origine.None, CapaciteSpeciale.Cap_39);
		DeusEx c_72= new DeusEx("Transe", 72, TypeCarte.DeusEx, Origine.None, CapaciteSpeciale.Cap_40);
		DeusEx c_73= new DeusEx("Miroir", 73, TypeCarte.DeusEx, Origine.None, CapaciteSpeciale.Cap_41);
		DeusEx c_74= new DeusEx("Bouleversement", 74, TypeCarte.DeusEx, Origine.None, CapaciteSpeciale.Cap_8);
		DeusEx c_75= new DeusEx("Inquisition", 75, TypeCarte.DeusEx, Origine.None, CapaciteSpeciale.Cap_42);
		Apocalypse c_76= new Apocalypse("Apocalypse", 76, TypeCarte.Apocalypse, Origine.Jour, CapaciteSpeciale.Cap_18);
		Apocalypse c_77= new Apocalypse("Apocalypse", 77, TypeCarte.Apocalypse, Origine.Nuit, CapaciteSpeciale.Cap_18);
		Apocalypse c_78= new Apocalypse("Apocalypse", 78, TypeCarte.Apocalypse, Origine.Neant, CapaciteSpeciale.Cap_18);
		Apocalypse c_79= new Apocalypse("Apocalypse", 79, TypeCarte.Apocalypse, Origine.None, CapaciteSpeciale.Cap_18);
		Apocalypse c_80= new Apocalypse("Apocalypse", 80, TypeCarte.Apocalypse, Origine.None, CapaciteSpeciale.Cap_18);
		stock.add(c_1);
		stock.add(c_2);
		stock.add(c_3);
		stock.add(c_4);
		stock.add(c_5);
		stock.add(c_6);
		stock.add(c_7);
		stock.add(c_8);
		stock.add(c_9);
		stock.add(c_10);
		stock.add(c_11);
		stock.add(c_12);
		stock.add(c_13);
		stock.add(c_14);
		stock.add(c_15);
		stock.add(c_16);
		stock.add(c_17);
		stock.add(c_18);
		stock.add(c_19);
		stock.add(c_20);
		stock.add(c_21);
		stock.add(c_22);
		stock.add(c_23);
		stock.add(c_24);
		stock.add(c_25);
		stock.add(c_26);
		stock.add(c_27);
		stock.add(c_28);
		stock.add(c_29);
		stock.add(c_30);
		stock.add(c_31);
		stock.add(c_32);
		stock.add(c_33);
		stock.add(c_34);
		stock.add(c_35);
		stock.add(c_36);
		stock.add(c_37);
		stock.add(c_38);
		stock.add(c_39);
		stock.add(c_40);
		stock.add(c_41);
		stock.add(c_42);
		stock.add(c_43);
		stock.add(c_44);
		stock.add(c_45);
		stock.add(c_46);
		stock.add(c_47);
		stock.add(c_48);
		stock.add(c_49);
		stock.add(c_50);
		stock.add(c_51);
		stock.add(c_52);
		stock.add(c_53);
		stock.add(c_54);
		stock.add(c_55);
		stock.add(c_56);
		stock.add(c_57);
		stock.add(c_58);
		stock.add(c_59);
		stock.add(c_60);
		stock.add(c_61);
		stock.add(c_62);
		stock.add(c_63);
		stock.add(c_64);
		stock.add(c_65);
		stock.add(c_66);
		stock.add(c_67);
		stock.add(c_68);
		stock.add(c_69);
		stock.add(c_70);
		stock.add(c_71);
		stock.add(c_72);
		stock.add(c_73);
		stock.add(c_74);
		stock.add(c_75);
		stock.add(c_76);
		stock.add(c_77);
		stock.add(c_78);
		stock.add(c_79);
		stock.add(c_80);
		
	}
	/**
	 * 
	 * @return : return la liste des cartes dans le stock actuellement
	 */
	public ArrayList<Carte> getStock(){ 
		return stock;
	}
	/**
	 * Compléter la main de joueur à 7 cartes
	 */
	public void distribuerCartes(Main laMain){
		Collections.shuffle(this.getStock());
		
		for (int i=1; i< (8- laMain.getNbrCartes()); i++ ){
			laMain.getListeCartesMain().add(stock.get(0));
			stock.remove(0);
			
		}
		
	}
	public static void main (String[] args){
		
		
	}
	

}
