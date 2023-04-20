package ilu2;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Trim;

public class Welcome {

	public static String welcome(String input) {
	
		if (input.trim()=="") {
			return "Hello, my friends";
		}
		return "Hello, Bob";
	}
}
