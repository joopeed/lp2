package lp2.lab05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PointTest {


	Point p, q;
	double xP, yP, xQ, yQ;
	
	@Before
	public void setUp() throws Exception {
		xP = 0;
		yP = 0;
		
		xQ = 3;
		yQ = 0;
		
		p = new Point(xP, yP);
		q = new Point(xQ, yQ);
	}

	@After
	public void tearDown() throws Exception {
		p = null;
		q = null;
	}

	@Test
	public void testingValues() {
		double x = 0;
		double y = 0;
		
		Point ponto = new Point(x, y);
		
		assertEquals("GetX() problem", ponto.getX(), x, 0);
		assertEquals("GetY() problem", ponto.getY(), y, 0);
	}

	@Test
	public void testGetX() {
		assertEquals("GetX() problem",p.getX(), xP, 0);
		assertEquals("GetX() problem",q.getX(), xQ, 0);
	}

	@Test
	public void testGetY() {
		assertEquals("GetY() problem", p.getY(), yP, 0);
		assertEquals("GetY() problem", q.getY(), yQ, 0);
	}

	@Test
	public void testToString() {
		
		assertEquals("toString() problem", p.toString(), "(0.0,0.0)");
		assertEquals("toString() problem", q.toString(), "(3.0,0.0)");
	}
	
	
	

}
