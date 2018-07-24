package Helpers;

import static org.junit.Assert.*;

import org.junit.Test;

public class hashTest {

	@Test
	public void test() {
		HashMap test = new HashMap();
				
		test.put(1, 2);
		
		int output = test.get(2);
		
		assertEquals(2, output);

		
	}

}
