package ilu2;

import java.util.Arrays;

public class Welcome {
	private static int positionMajTrie=0;
	private static int positionMinTrie=0;
	
	public static String welcome(String input) {	
	StringBuilder affiche = new StringBuilder();
	
	String[][] listerange = splitListCarac(input);
	String[] nomMaj = listerange[1]; // l'indice 1 correspond à la liste des mots en lettre CAPITAL 
	String[] nomMin = listerange[0]; // l'indice 0 correspond à la liste des mots soit tout en mininuscule ou avec seulement une MAJ
	
	if (input.trim()=="") {
		return printVide(affiche);
	}
	if (nomMin[0]!=null) {
		trieMinuscule(nomMin, affiche);
	}
	if (nomMaj[0]!=null) {
		trieMajuscule(nomMin, nomMaj, affiche);
	}
	return affiche.toString();
	}
	
	private static String printVide(StringBuilder affiche) {
		affiche.append("Hello, my friend");
		return affiche.toString();
	}
	
	/*
	 * Cette méthode affiche la première partie de la phrase en minuscule
	 */
	private static void printMinuscule(StringBuilder affiche, String[] nomMin, int[] listNbrRepet ) {
		affiche.append("Hello");
		for (int i=0; i< nomMin.length && nomMin[i]!=null; i++) {
			String firstcarc = nomMin[i].substring(0,1); 
			String restcarac = nomMin[i].substring(1); 
			
			if(listNbrRepet[i]==1) {
				if (i==positionMinTrie-1 && i!=0) {
					affiche.append(" and "+firstcarc.toUpperCase()+restcarac);break;
				}
				affiche.append(", "+firstcarc.toUpperCase()+restcarac);
			}
			else {
				if (i==positionMinTrie-1 && i!=0) {
					affiche.append(" and "+firstcarc.toUpperCase()+restcarac+" (x"+listNbrRepet[i]+")");break;
				}
				affiche.append(", "+firstcarc.toUpperCase()+restcarac+" (x"+listNbrRepet[i]+")");
			}
		} 
	}
	
	/*
	 * Cette méthode affiche la seconde partie de la phrase en Majuscule
	 */
	private static void printMajuscule(StringBuilder affiche, String[] nomMin, String[] nomMaj, int[] listNbrRepet ) {
		if (nomMin[0]==null) {
			affiche.append("HELLO");}
		else {
			affiche.append(". AND HELLO");}
			
		for (int i=0; i< nomMaj.length && nomMaj[i]!=null; i++) { 
			if (listNbrRepet[i]==1) {
				if (i==positionMajTrie-1 && i!=0) {
					affiche.append(" AND "+nomMaj[i]);break;
				}
				affiche.append(", "+nomMaj[i]);
			}
			else {
				if (i==positionMajTrie-1 && i!=0) {
					affiche.append(" AND "+nomMaj[i]+" (x"+listNbrRepet[i]+")");break;
				}
				affiche.append(", "+nomMaj[i]+" (x"+listNbrRepet[i]+")");
				}
			}
		affiche.append(" !");
		}
	
	/*
	 * Cette méthode crée 2 listes, une liste sans doublon de mots en Minuscule et une liste avec 
	 * le nombre d'apparition d'un mot dans la liste principale
	 */
	private static void trieMinuscule(String[] list, StringBuilder affiche) {
		int[] listNbrRepet = new int[list.length];
		String[] listNomSansDoublond = new String[list.length];
		positionMinTrie=0;
		
		for (int i = 0; i < list.length && list[i]!=null; i++) {
			if (!inListe(listNomSansDoublond, list[i])) {
				listNbrRepet[positionMinTrie]= nbrRepetition(list, list[i]);
				listNomSansDoublond[positionMinTrie]= list[i]; 
				positionMinTrie++;
			}
		}
		printMinuscule(affiche, listNomSansDoublond, listNbrRepet);
		
	}
	
	/*
	 * Cette méthode crée 2 listes, une liste sans doublon de mots en Majuscule et une liste avec 
	 * le nombre d'apparition d'un mot dans la liste principale
	 */
	private static void trieMajuscule(String[] nomMin, String[] list, StringBuilder affiche) {
		int[] listNbrRepet = new int[list.length];
		String[] listNomSansDoublond = new String[list.length];
		positionMajTrie=0;
		
		for (int i = 0; i < list.length && list[i]!=null; i++) {
			if (!inListe(listNomSansDoublond, list[i])) {
				listNbrRepet[positionMajTrie]= nbrRepetition(list, list[i]);
				listNomSansDoublond[positionMajTrie]= list[i]; 
				positionMajTrie++;
			}
		}
		printMajuscule( affiche, nomMin, listNomSansDoublond, listNbrRepet );
	}
	
	/*
	 * Sépare la liste en 2 sous-listes, une sous-liste qui contient les mots en capital 
	 * et une autre  sous-liste avec les mots en minuscules.
	 * Cette méthode retourne une liste string, de sous-liste string
	 */
	private static String[][] splitListCarac(String input) {
		String[] listemots = input.split(",");
		String[][] listerange = new String[2][listemots.length];
		int positionMaj=0;
		int positionMin=0;
		int indiceMaj = 1;
		int indiceMin = 0;
		
		for (int i = 0; i < listemots.length; i++) {  
			if (listemots[i].toUpperCase().equals(listemots[i])) 
			{
				listerange[indiceMaj][positionMaj]=listemots[i].trim();
				positionMaj++;
			}
			else {
				listerange[indiceMin][positionMin]=listemots[i].trim();
				positionMin++;
			}
		}
		return listerange;
	}
	
	/*
	 * Cette méthode retourne le nombre de fois qu'un mot apparaît dans une liste.
	 */
	private static int nbrRepetition(String[] liste, String nom) {
		int nbr=0;
		for (int i = 0; i < liste.length; i++) {
			if (nom.equals(liste[i])) {
				nbr++;
				}
			}
		return nbr;
	}
	
	/*
	 * Cette méthode renvoit un booléan pour savoir si un mot est présent dans une liste. 
	 */
	private static boolean inListe(String[] liste, String nom) {
		boolean bool = false;
		for (int i = 0; i < liste.length; i++) {
			if (nom.equals(liste[i])) {
				bool = true;
			}
		}
		return bool;
	}


}
