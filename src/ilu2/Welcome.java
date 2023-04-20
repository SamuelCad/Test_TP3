package ilu2;

import java.io.Console;
import java.util.Stack;

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
		String[] listemots = input.split(",");
		affiche.append("Hello");
		for (int i = 0; i < listemots.length; i++) {
			String firtcarc = listemots[i].substring(0,1); 
			String restcarac = listemots[i].substring(1); 
			affiche.append(", "+firtcarc.toUpperCase()+restcarac);
		}
	}
	return affiche.toString();
	}
	

}
