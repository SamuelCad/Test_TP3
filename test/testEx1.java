import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ilu2.Welcome;

class testEx1 {
	
	
	@Test
	void testEx1() {
		assertEquals(Welcome.welcome("bob"), "Hello, Bob");
	}

}
