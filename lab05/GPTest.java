package lp2.lab05;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GPTest {
	
	GP gp;
	GP gp2;

	@Before
	public void setUp() throws Exception {
		gp = new GP(1,2);
		gp2 = new GP(1,0.5);
	}

	@After
	public void tearDown() throws Exception {
		
	}
	@Test
	public void testCalculateNth(){
		assertEquals("CalculateNth() problem", 1, gp.calculateNth(1),0);
		assertEquals("CalculateNth() problem", 2, gp.calculateNth(2),0);
		assertEquals("CalculateNth() problem", 16, gp.calculateNth(5),0);
		
	}
	@Test
	public void testSumUntilNth(){
		assertEquals("sumUntilNth() problem", 1, gp.sumUntilNth(1),0);
		assertEquals("sumUntilNth() problem", 7, gp.sumUntilNth(3),0);
		assertEquals("sumUntilNth() problem", 31, gp.sumUntilNth(5),0);
		
	}
	@Test
	public void testCalculateBetween(){
		assertEquals("calculateBetween() problem", 24, gp.calculateBetween(4,5),0);
		assertEquals("calculateBetween() problem", 14, gp.calculateBetween(2,4),0);
		
		
	}
	
	@Test
	public void testGetGP() {
		double[] test = {1, 2, 4, 8, 16};
		assertTrue("GetGP() problem",  Arrays.equals(test, gp.getGP(5)));
		double[] test2 = {1, 0.5, 0.25, 0.125, 0.0625};
		assertTrue("GetGP() problem",  Arrays.equals(test2, gp2.getGP(5)));
		
	}

}
