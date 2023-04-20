import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ilu2.Welcome;

class TDDtest {
	
	
	@Test
	void testEx1() {
		assertEquals(Welcome.welcome("bob"), "Hello, Bob");
	}

	@Test
	void testEx2() {
		assertEquals(Welcome.welcome("  "),"Hello, my friends");
		assertEquals(Welcome.welcome(""),"Hello, my friends");
	}
	@Test
	void testEx3() {
		assertEquals(Welcome.welcome("JERRY"), "HELLO, JERRY !");
	}
}
