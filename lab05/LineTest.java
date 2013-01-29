package lp2.lab05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LineTest {
	
	Point p1,p2,p3,p4;
	Line diagonal, anyLine, diagonal2, vertical;

	@Before
	public void setUp() throws Exception {
		
		
		//lines without points
		double a = 1;
		double b = 0;
		diagonal = new Line(a,b);
		double m = 2;
		double n = 3;
		anyLine = new Line(m,n);
		
		//lines with points
		p1 = new Point(-1,-1);
		p2 = new Point(1,1);
		diagonal2 = new Line(p1,p2);
		p3 = new Point(3,0);
		p4 = new Point(3,3);
		vertical = new Line(p3,p4);
		
		
		
		
	}

	@After
	public void tearDown() throws Exception {
		diagonal = null;
		anyLine = null;
		diagonal2 = null;
		vertical = null;
		
	}

	@Test
	public void testSlope() {
		assertEquals("slope() problem", diagonal.slope(), 0, 0);
		assertEquals("slope() problem", anyLine.slope(), 3, 0);
		assertEquals("slope() problem", diagonal2.slope(), 0,0);
		assertEquals("slope() problem", vertical.slope(), Double.POSITIVE_INFINITY ,0);
		
	}
	
	@Test
	public void testIsVertical() {
		assertFalse("isVertical() problem", diagonal.isVertical());
		assertFalse("isVertical() problem", anyLine.isVertical());
		assertFalse("isVertical() problem", diagonal2.isVertical());
		assertTrue("isVertical() problem", vertical.isVertical());
	}
	@Test
	public void testBelongstoLine() {
		assertTrue("belongsToLine() didnt return True for 1st", diagonal.belongsToLine(new Point(5,5)));
		assertTrue("belongsToLine() didnt return True for 2nd", anyLine.belongsToLine(new Point(1,5)));
		assertTrue("belongsToLine() didnt return True for 3th", diagonal2.belongsToLine(new Point(5,5)));
		assertTrue("belongsToLine() didnt return True for 4th", vertical.belongsToLine(new Point(3,5)));
		
		assertFalse("belongsToLine() didnt return False for 1st", diagonal.belongsToLine(new Point(1,5)));
		assertFalse("belongsToLine() didnt return False for 2nd", anyLine.belongsToLine(new Point(2,5)));
		assertFalse("belongsToLine() didnt return False for 3th", diagonal2.belongsToLine(new Point(1,5)));
		assertFalse("belongsToLine() didnt return False for 4th", vertical.belongsToLine(new Point(5,5)));
		
	}
	@Test
	public void testIsAbove() {
		assertTrue("isAbove() didnt return True for 1st", diagonal.isAbove(new Point(0,1)));
		assertTrue("isAbove() didnt return True for 2nd", anyLine.isAbove(new Point(0,5)));
		assertTrue("isAbove() didnt return True for 3th", diagonal2.isAbove(new Point(0,1)));
		assertTrue("isAbove() didnt return True for 4th", vertical.isAbove(new Point(5,0)));
		
		assertFalse("isAbove() didnt return False for 1st", diagonal.isAbove(new Point(1,0)));
		assertFalse("isAbove() didnt return False for 2nd", anyLine.isAbove(new Point(0,0)));
		assertFalse("isAbove() didnt return False for 3th", diagonal2.isAbove(new Point(1,0)));
		assertFalse("isAbove() didnt return False for 4th", vertical.isAbove(new Point(0,0)));
	}
	@Test
	public void testIsBelow() {
		assertTrue("isBelow() didnt return True for 1st", diagonal.isBelow(new Point(1,0)));
		assertTrue("isBelow() didnt return True for 2nd", anyLine.isBelow(new Point(0,0)));
		assertTrue("isBelow() didnt return True for 3th", diagonal2.isBelow(new Point(1,0)));
		assertTrue("isBelow() didnt return True for 4th", vertical.isBelow(new Point(0,0)));
		
		assertFalse("isBelow() didnt return False for 1st", diagonal.isBelow(new Point(0,1)));
		assertFalse("isBelow() didnt return False for 2nd", anyLine.isBelow(new Point(0,5)));
		assertFalse("isBelow() didnt return False for 3th", diagonal2.isBelow(new Point(0,1)));
		assertFalse("isBelow() didnt return False for 4th", vertical.isBelow(new Point(5,0)));
	}
	@Test
	public void testIsLeft(){
		assertTrue("isLeft() didnt return True for 1st", diagonal.isLeft(new Point(-1,0)));
		assertTrue("isLeft() didnt return True for 3th", diagonal2.isLeft(new Point(-1,0)));
		assertTrue("isLeft() didnt return True for 4th", vertical.isLeft(new Point(0,0)));
		
		
		assertFalse("isLeft() didnt return False for 1st", diagonal.isLeft(new Point(1,0)));
		assertFalse("isLeft() didnt return False for 2nd", anyLine.isLeft(new Point(2,0)));
		assertFalse("isLeft() didnt return False for 3th", diagonal2.isLeft(new Point(1,0)));
		assertFalse("isLeft() didnt return False for 4th", vertical.isLeft(new Point(5,0)));
	}
	@Test
	public void testIsRight(){
		assertTrue("isRight() didnt return True for 1st", diagonal.isRight(new Point(1,0)));
		assertTrue("isRight() didnt return True for 2nd", anyLine.isRight(new Point(2,0)));
		assertTrue("isRight() didnt return True for 3th", diagonal2.isRight(new Point(1,0)));
		assertTrue("isRight() didnt return True for 4th", vertical.isRight(new Point(5,0)));
		
		
		assertFalse("isRight() didnt return False for 1st", diagonal.isRight(new Point(-1,0)));
		assertFalse("isRight() didnt return False for 2nd", anyLine.isRight(new Point(0,4)));
		assertFalse("isRight() didnt return False for 3th", diagonal2.isRight(new Point(-1,0)));
		assertFalse("isRight() didnt return False for 4th", vertical.isRight(new Point(0,0)));
	}
	
	@Test
	public void testCalculateY() {
		assertEquals("calculateY() problem", diagonal.calculateY(1), 1, 0);
		assertEquals("calculateY() problem", anyLine.calculateY(1), 5, 0);
		assertEquals("calculateY() problem", diagonal2.calculateY(1), 1, 0);
	}
	@Test
	public void testCalculateX() {
		assertEquals("calculateX() problem", diagonal.calculateX(-1), -1, 0);
		assertEquals("calculateX() problem", anyLine.calculateX(5), 1, 0);
		assertEquals("calculateX() problem", diagonal2.calculateX(1), 1, 0);
	}
	
	@Test
	public void testEquationRoot(){
		assertEquals("equationRoot() problem", diagonal.equationRoot(), 0, 0);
		assertEquals("equationRoot() problem", anyLine.equationRoot(), -1.5, 0);
		assertEquals("equationRoot() problem", diagonal2.equationRoot(), 0, 0);
		assertEquals("equationRoot() problem", vertical.equationRoot(), 0, 0);
	}
	@Test
	public void testToString(){
		assertEquals("toString() problem", diagonal.toString(), "y = x");
		assertEquals("toString() problem", anyLine.toString(), "y = 2.0x +3.0");
		assertEquals("toString() problem", diagonal2.toString(), "y = x");
		assertEquals("toString() problem", vertical.toString(), "x = 3.0");
	}
	
	

}
