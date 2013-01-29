package lp2.lab05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PolygonTest {

	Polygon triangle;
	Polygon any;
	Polygon any2;
	Polygon square;
	Polygon square2;
	
	@Before
	public void setUp(){
		Point[] vertices_triangle = {new Point(0,0),new Point(1,1),new Point(2,0)};
		triangle = new Polygon(vertices_triangle);
		Point[] vertices_any = {new Point(0,0),new Point(0,2),new Point(3,2),new Point(3,0),
				new Point(2,0),new Point(2,1),new Point(1,1),new Point(1,0)};
		any = new Polygon(vertices_any);
		Point[] vertices_square = {new Point(0,0),new Point(0,1),new Point(1,1),new Point(1,0)};
		square = new Polygon(vertices_square);
		Point[] vertices_square2 = {new Point(0,0),new Point(1,0),new Point(1,1),new Point(0,1)};
		square2 = new Polygon(vertices_square2);
		Point[] vertices_any2 = {new Point(0,0),new Point(1,0),new Point(1,1),new Point(2,1),
				new Point(2,0),new Point(3,0),new Point(3,2),new Point(0,2)};
		any2 = new Polygon(vertices_any2);
		
		
	}
	@After
	public void tearDown(){
		triangle = null;
		triangle = null;
		any = null;
		any2 = null;
		square = null;
		square2 = null;
		
		
	}
	
	
	
	
	@Test
	public void testIsInside() {
		assertTrue("isInside() problem", triangle.isInside(new Point(2,0)));
		assertTrue("isInside() problem", triangle.isInside(new Point(1,0.5)));
		assertFalse("isInside() problem", triangle.isInside(new Point(2,2)));
		assertTrue("isInside() problem", any.isInside(new Point(0.5,1)));
		assertTrue("isInside() problem", square.isInside(new Point(0.5,0.5)));
		assertTrue("isInside() problem", square.isInside(new Point(0,0)));
		assertTrue("isInside() problem", square.isInside(new Point(1,1)));
		assertFalse("isInside() problem", square.isInside(new Point(1.2,1)));
		assertFalse("isInside() problem", square.isInside(new Point(-1,1)));
	}
	@Test
	public void testPerimeter() {
		assertEquals("perimeter() problem", 2*Math.sqrt(2)+2, triangle.perimeter(),0);
		assertEquals("perimeter() problem", 12, any.perimeter(),0);
		assertEquals("perimeter() problem", 12, any2.perimeter(),0);
		assertEquals("perimeter() problem", 4, square.perimeter(),0);
		
	}
	@Test
	public void testArea() {
		assertEquals("area() problem", 1, triangle.area(),0);
		assertEquals("area() problem", 5, any.area(),0);
		assertEquals("area() problem", 1, square.area(),0);
		assertEquals("area() problem", 1, square2.area(),0);
	}

}
