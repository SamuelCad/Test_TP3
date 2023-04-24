package ilu2;

import java.io.Console;
import java.util.Stack;

public class Welcome {

	public static String welcome(String input) {	
	StringBuilder affiche = new StringBuilder();
	String[][] listerange = splitListCarac(input);

	String[] nomMaj = listerange[1]; // l'indice 1 correspond à la liste des mots en lettre CAPITAL 
	String[] nomMin = listerange[0]; // l'indice 0 correspond à la liste des mots soit tout en mininuscule ou avec seulement une MAJ
	
	if (input.trim()=="") {
		return printVide(affiche).toString();
	}
	if (nomMin[0]!=null) {
		printMinuscule(affiche, nomMin);
	}
	if (nomMaj[0]!=null) {
		printMajuscule(affiche, nomMin, nomMaj);
	}
	return affiche.toString();
	}
	
	
	public static StringBuilder printVide(StringBuilder affiche) {
		affiche.append("Hello, my friends");
		return affiche;
	}
	
	public static void printMinuscule(StringBuilder affiche, String[] nomMin ) {
		affiche.append("Hello");
		for (int i=0; i< nomMin.length && nomMin[i]!=null; i++) {
			String firstcarc = nomMin[i].substring(0,1); 
			String restcarac = nomMin[i].substring(1); 
			affiche.append(", "+firstcarc.toUpperCase()+restcarac);
		}
	}
	
	public static void printMajuscule(StringBuilder affiche, String[] nomMin, String[] nomMaj) {
		if (nomMin[0]==null) {
			affiche.append("HELLO");
		}
		else {
			affiche.append(". AND HELLO");			
		}
		for (int i=0; i< nomMaj.length && nomMaj[i]!=null; i++) {
			affiche.append(", "+nomMaj[i]);
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
	
	public static void main(String[] args) {
		System.out.println(Welcome.welcome("Amy, BOB, Jerry"));
//		System.out.println(java.util.Arrays.deepToString(splitListCarac("Amy, BOB, Jerry")));

	}
}
