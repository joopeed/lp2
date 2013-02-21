package lp2.lab07;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LivroTest {

	Livro lotr; 
	
	@Before
	public void setUp() throws Exception {
		lotr = new Livro("1", "1", "Lord of the rings", "first book of the series",
				"Tolkien", "1954", "Fantasy");
	}


	@Test
	public void testLivro() {
		assertEquals("Tolkien",lotr.getAutor());
	}

	@Test
	public void testGetAutor() {
		assertEquals("Tolkien",lotr.getAutor());
	}

	@Test
	public void testSetAutor() {
		lotr.setAutor("JRRTolkien");
		assertEquals("JRRTolkien",lotr.getAutor());
	}

	@Test
	public void testGetAno() {
		assertEquals("1954",lotr.getAno());
	}

	@Test
	public void testSetAno() {
		lotr.setAno("1955");
		assertEquals("1955",lotr.getAno());
	}

	@Test
	public void testGetGenero() {
		assertEquals("Fantasy",lotr.getGenero());
	}

	@Test
	public void testSetGenero() {
		lotr.setGenero("Fantasy/Mithology");
		assertEquals("Fantasy/Mithology",lotr.getGenero());
	}

}
