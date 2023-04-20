package ilu2;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Trim;

public class Welcome {

	public static String welcome(String input) {
	StringBuilder affiche = new StringBuilder();
	
		if (input.trim()=="") {
			affiche.append("Hello, my friends");
		}
		else if (input.toUpperCase().equals(input)) {
			affiche.append("HELLO, "+input+" !");
		}
		
		else {
		affiche.append("Hello, Bob");
		}
		return affiche.toString();
	}
}
