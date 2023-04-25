package ilu2;

import java.util.Arrays;

public class Welcome {
	private static int positionMaj=0;
	private static int positionMin=0;
	
	public static String welcome(String input) {	
	StringBuilder affiche = new StringBuilder();
	
	String[][] listerange = splitListCarac(input);
	String[] nomMaj = listerange[1]; // l'indice 1 correspond à la liste des mots en lettre CAPITAL 
	String[] nomMin = listerange[0]; // l'indice 0 correspond à la liste des mots soit tout en mininuscule ou avec seulement une MAJ
	
	if (input.trim()=="") {
		return printVide(affiche).toString();
	}
	if (nomMin[0]!=null) {
		trieMin(nomMin, affiche);
		
	}
	if (nomMaj[0]!=null) {
		trieMaj(nomMin, nomMaj, affiche);
	}
	return affiche.toString();
	}
	
	public static StringBuilder printVide(StringBuilder affiche) {
		affiche.append("Hello, my friend");
		return affiche;
	}
	
	public static void printMinuscule(StringBuilder affiche, String[] nomMin, int[] listNbrRepet ) {
		affiche.append("Hello");
		for (int i=0; i< nomMin.length && nomMin[i]!=null; i++) {
			String firstcarc = nomMin[i].substring(0,1); 
			String restcarac = nomMin[i].substring(1); 
			
			if(listNbrRepet[i]==1) {
				if (i==positionMin-1 && i!=0) {
					affiche.append(" and "+firstcarc.toUpperCase()+restcarac);break;
				}
				affiche.append(", "+firstcarc.toUpperCase()+restcarac);
			}
			else {
				if (i==positionMin-1 && i!=0) {
					affiche.append(" and "+firstcarc.toUpperCase()+restcarac+" (x"+listNbrRepet[i]+")");break;
				}
				affiche.append(", "+firstcarc.toUpperCase()+restcarac+" (x"+listNbrRepet[i]+")");
			}
		} 
	}
	
	public static void printMajuscule(StringBuilder affiche, String[] nomMin, String[] nomMaj, int[] listNbrRepet ) {
		if (nomMin[0]==null) {
			affiche.append("HELLO");}
		else {
			affiche.append(". AND HELLO");			}
			
		for (int i=0; i< nomMaj.length && nomMaj[i]!=null; i++) {
			if (listNbrRepet[i]==1) {
				if (i==positionMaj-1 && i!=0) {
					affiche.append(" AND "+nomMaj[i]);break;
				}
				affiche.append(", "+nomMaj[i]);
			}
			else {
				if (i==positionMaj-1 && i!=0) {
					affiche.append(" AND "+nomMaj[i]+" (x"+listNbrRepet[i]+")");break;
				}
				affiche.append(", "+nomMaj[i]+" (x"+listNbrRepet[i]+")");
			}
		}
		affiche.append(" !");
	}
	
	public static String[][] splitListCarac(String input) {
		String[] listemots = input.split(",");
		String[][] listerange = new String[2][listemots.length];
		int positionMaj=0;
		int positionMin=0;
		
		for (int i = 0; i < listemots.length; i++) {  /* Split input en 2*/
			if (listemots[i].toUpperCase().equals(listemots[i])) {
				listerange[1][positionMaj]=listemots[i].trim();
				positionMaj++;
			}
			else {
				listerange[0][positionMin]=listemots[i].trim();
				positionMin++;
			}
			
		}
		return listerange;
	}
	
	public static int nbrRepetition(String[] liste, String nom) {
		int nbr=0;
		for (int i = 0; i < liste.length; i++) {
			if (nom.equals(liste[i])) {
				nbr++;
				}
			}
		return nbr;
	}
	
	public static void trieMaj(String[] nomMin, String[] list, StringBuilder affiche) {
		int[] listNbrRepet = new int[list.length];
		String[] listNomSansDoublond = new String[list.length];
		positionMaj=0;
		
		for (int i = 0; i < list.length && list[i]!=null; i++) {
			if (!inListe(listNomSansDoublond, list[i])) {
				listNbrRepet[positionMaj]= nbrRepetition(list, list[i]);
				listNomSansDoublond[positionMaj]= list[i]; 
				positionMaj++;
			}
		}
		printMajuscule( affiche, nomMin, listNomSansDoublond, listNbrRepet );
	}
	
	public static void trieMin(String[] list, StringBuilder affiche) {
		int[] listNbrRepet = new int[list.length];
		String[] listNomSansDoublond = new String[list.length];
		positionMin=0;
		
		for (int i = 0; i < list.length && list[i]!=null; i++) {
			if (!inListe(listNomSansDoublond, list[i])) {
				listNbrRepet[positionMin]= nbrRepetition(list, list[i]);
				listNomSansDoublond[positionMin]= list[i]; 
				positionMin++;
			}
		}
		printMinuscule(affiche, listNomSansDoublond, listNbrRepet);

	}
	
	public static boolean inListe(String[] liste, String nom) {
		for (int i = 0; i < liste.length; i++) {
			if (nom.equals(liste[i])) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		StringBuilder affiche = new StringBuilder();
		String[][] listerange = splitListCarac("bob, JERRY, amy, bob, JERRY, bob");
		String[] nomMaj = listerange[1]; // l'indice 1 correspond à la liste des mots en lettre CAPITAL 
		String[] nomMin = listerange[0]; 
		Welcome.trieMin(nomMin, affiche);
//		Welcome.trie(nomMin);


	}
}
