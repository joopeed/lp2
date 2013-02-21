package lp2.lab07;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilmeTest {

	Filme filme1;
	
	@Before
	public void setUp() throws Exception {
		filme1 = new Filme("1", "1", "Catch me if you can", "com tom hanks","Spielberg","Tom Hanks e Leonardo", "2003", "Drama");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFilme() {
		assertEquals("Spielberg", filme1.getDiretor());
	}

	@Test
	public void testGetDiretor() {
		assertEquals("Spielberg", filme1.getDiretor());
	}

	@Test
	public void testSetDiretor() {

		filme1.setDiretor("Steven");
		assertEquals("Steven",filme1.getDiretor());
	}

	@Test
	public void testGetElenco() {
		assertEquals("Tom Hanks e Leonardo", filme1.getElenco());
	}

	@Test
	public void testSetElenco() {
		filme1.setElenco("Tom hanks, leornardo dicrapio...");
		assertEquals("Tom hanks, leornardo dicrapio...",filme1.getElenco());
	}

	@Test
	public void testGetAno() {
		assertEquals("2003", filme1.getAno());
	}

	@Test
	public void testSetAno() {
		filme1.setAno("1955");
		assertEquals("1955",filme1.getAno());
	}

	@Test
	public void testGetGenero() {
		assertEquals("Drama", filme1.getGenero());
	}

	@Test
	public void testSetGenero() {
		filme1.setGenero("Drama/Comedia");
		assertEquals("Drama/Comedia",filme1.getGenero());
	}

}
