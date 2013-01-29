package lp2.lab05;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class APTest {
	
	AP ap;

	@Before
	public void setUp() throws Exception {
		ap = new AP(1,1);
	}

	@After
	public void tearDown() throws Exception {
		ap = null;
	}

	
	public void testCalculateNth(){
		assertEquals("CalculateNth() problem", 1, ap.calculateNth(1),0);
		assertEquals("CalculateNth() problem", 2, ap.calculateNth(2),0);
		assertEquals("CalculateNth() problem", 5, ap.calculateNth(5),0);
		
	}
	@Test
	public void testSumUntilNth(){
		assertEquals("sumUntilNth() problem", 1, ap.sumUntilNth(1),0);
		assertEquals("sumUntilNth() problem", 6, ap.sumUntilNth(3),0);
		assertEquals("sumUntilNth() problem", 15, ap.sumUntilNth(5),0);
		
	}
	@Test
	public void testCalculateBetween(){
		assertEquals("calculateBetween() problem", 9, ap.calculateBetween(4,5),0);
		assertEquals("calculateBetween() problem", 14, ap.calculateBetween(2,5),0);
		
		
	}

	@Test
	public void testGetAP() {
		double[] exp = {1,2,3,4,5};
		assertTrue("GetAP() problem",  Arrays.equals(exp, ap.getAP(5))); //FIXME
	}

}
