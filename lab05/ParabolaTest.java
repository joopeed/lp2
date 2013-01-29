package lp2.lab05;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParabolaTest {

	Parabola p1;
	Parabola p2;
	
	@Before
	public void setUp() throws Exception {
		p1 = new Parabola(1,0,0);
		p2 = new Parabola(1,1,1);
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
	}

	@Test
	public void testBelongsToParabola() {
		assertTrue(p1.belongsToParabola(new Point(1,1)));
		assertTrue(p1.belongsToParabola(new Point(2,4)));
		assertTrue(p1.belongsToParabola(new Point(4,16)));
		assertFalse(p1.belongsToParabola(new Point(2,1)));
	}

	@Test
	public void testConcavity() {
		assertEquals(1,p1.concavity(),0);
	}

	@Test
	public void testEquationRoots() {
		double[] roots = {-0.0};
		System.out.println(Arrays.toString(p2.equationRoots()));
		System.out.println(p2.equationRoots().length);
		assertTrue(Arrays.equals(roots, p1.equationRoots()));
	}

	@Test
	public void testToString() {
		
	}

}
