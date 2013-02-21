package lp2.lab07;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlbumTest {

	Album cd;
	
	@Before
	public void setUp() throws Exception {
		cd = new Album("1", "1", "Time Flies", "Album of Oasis", "Oasis","2010", "Rock");
	}


	@Test
	public void testAlbum() {
		assertEquals("Oasis", cd.getArtista());
	}

	@Test
	public void testGetArtista() {
		assertEquals("Oasis", cd.getArtista());
	}

	@Test
	public void testSetArtista() {
		cd.setArtista("Oasissss");
		assertEquals("Oasissss",cd.getArtista());
	}

	@Test
	public void testGetAno() {
		assertEquals("2010", cd.getAno());
	}

	@Test
	public void testSetAno() {
		cd.setAno("2011");
		assertEquals("2011",cd.getAno());
	}

	@Test
	public void testGetGenero() {
		assertEquals("Rock", cd.getGenero());
	}

	@Test
	public void testSetGenero() {
		cd.setGenero("Rockzao");
		assertEquals("Rockzao",cd.getGenero());
	}

}
