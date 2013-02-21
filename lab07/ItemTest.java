package lp2.lab07;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	
	Item casaco, mouse, mesmoMouse;

	@Before
	public void setUp() throws Exception {
		casaco = new Item("1", "2","casaco", "meu casaco",  "casaco");
		mouse = new Item("2", "3","mouse", "meu mouse",  "mouse");
		mesmoMouse = new Item("2", "3","mouse", "meu mouse",  "mouse");
	}

	@Test
	public void testItem() {
		assertEquals("casaco", casaco.getNome());
		assertEquals("1", casaco.getID());
		assertEquals("meu casaco", casaco.getDescricao());
		assertEquals("2", casaco.getIdDono());
		assertEquals("casaco", casaco.getTipo());
		assertEquals("mouse", mouse.getNome());
		assertEquals("2", mouse.getID());
		assertEquals("meu mouse", mouse.getDescricao());
		assertEquals("3", mouse.getIdDono());
		assertEquals("mouse", mouse.getTipo());
	}

	@Test
	public void testGetNome() {
		assertEquals("casaco", casaco.getNome());
		assertEquals("mouse", mouse.getNome());
	}

	@Test
	public void testSetNome() {
		try{
			casaco.setNome("");
			fail("Nao deveria chegar aqui");
		} catch(Exception e){
			assertEquals("nome invalido", e.getMessage());
		}
		try{
			casaco.setNome("Casaco");
		} catch(Exception e){
			fail("quebrou e nao deveria");
		}
	}

	@Test
	public void testSetID() {
		try{
			casaco.setID("");
			fail("Nao deveria chegar aqui");
		} catch(Exception e){
			assertEquals("ID invalida", e.getMessage());
		}
		try{
			casaco.setID("123");
		} catch(Exception e){
			fail("quebrou e nao deveria");
		}
	}

	@Test
	public void testSetTipo() {
		try{
			casaco.setTipo("");
			fail("Nao deveria chegar aqui");
		} catch(Exception e){
			assertEquals("tipo invalido", e.getMessage());
		}
		try{
			casaco.setTipo("Tal");
		} catch(Exception e){
			fail("quebrou e nao deveria");
		}
	}

	@Test
	public void testSetDescricao() {
		try{
			casaco.setDescricao("");
			fail("Nao deveria chegar aqui");
		} catch(Exception e){
			assertEquals("Descricao invalida", e.getMessage());
		}
		try{
			casaco.setDescricao("meu casaco");
		} catch(Exception e){
			fail("quebrou e nao deveria");
		}
	}

	@Test
	public void testSetIDdono() {
		try{
			casaco.setIdDono("");
			fail("Nao deveria chegar aqui");
		} catch(Exception e){
			assertEquals("ID invalida", e.getMessage());
		}
		try{
			casaco.setIdDono("123");
		} catch(Exception e){
			fail("quebrou e nao deveria");
		}
	}

	@Test
	public void testGetDescricao() {
		assertEquals("meu mouse", mouse.getDescricao());
		assertEquals("meu casaco", casaco.getDescricao());
	}

	@Test
	public void testGetIdDono() {
		assertEquals("2", casaco.getIdDono());
		assertEquals("2", casaco.getIdDono());
	}

	@Test
	public void testGetID() {
		assertEquals("1", casaco.getID());
		assertEquals("2", mouse.getID());
	}

	@Test
	public void testGetTipo() {
		assertEquals("mouse", mouse.getTipo());
		assertEquals("casaco", casaco.getTipo());
	}

	@Test
	public void testEqualsObject() {
		assertEquals(mouse, mesmoMouse);
	}

}
