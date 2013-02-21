package lp2.lab06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CestaTest {
	
	Cesta pequena;
	Cesta grande;
	Cesta cheia;
	Cesta vazia;

	@Before
	public void setUp() throws Exception {
		pequena = new Cesta();
		pequena.add( new Produto("1212", "Teste", 15, 8.99) );
		grande = new Cesta();
		grande.add( new Produto("1212", "Teste", 15, 8.99) );
		grande.add( new Produto("1213", "Teste", 25, 10) );
		cheia = new Cesta();
		cheia.add( new Produto("1212", "Teste", 15, 8.99) );
		cheia.add( new Produto("1213", "Teste", 15, 8.99) );
		cheia.add( new Produto("1214", "Teste", 18, 8.99) );
		cheia.add( new Produto("1215", "Teste", 15, 8.99) );
		cheia.add( new Produto("1216", "Teste", 15, 8.99) );
		vazia = new Cesta();
	}


	@Test
	public void testCesta() {
		assertEquals(8.99,pequena.getValorTotal(),0.05);
		assertEquals(15,pequena.getPrazoFinal(),0.05);
	}

	@Test
	public void testGetValorTotal() throws Exception {
		assertEquals(8.99, pequena.getValorTotal(), 0.05);
		assertEquals(18.99, grande.getValorTotal(), 0.05);
	}

	@Test
	public void testGetPrazoFinal()throws Exception {
		assertEquals(15, pequena.getPrazoFinal(), 0.05);
		assertEquals(25, grande.getPrazoFinal(), 0.05);
	}

	@Test
	public void testAdd(){
		try {
			cheia.add( new Produto("1217", "Teste", 15, 8.99) );
			fail("Não quebrou quando deveria");
		} catch (Exception e){
			assertEquals("Cesta cheia", e.getMessage());
		}
		try {
			pequena.add( new Produto("1212", "Teste", 15, 8.99) );
			fail("Nao quebrou quando deveria");
		} catch (Exception e){
			assertEquals("Produto já está na cesta", e.getMessage());
		}
	}

	@Test
	public void testRemove() {
		try {
			vazia.remove( new Produto("1217", "Teste", 15, 8.99) );
			fail("Não quebrou quando deveria");
		} catch (Exception e){
			assertEquals("Cesta vazia", e.getMessage());
		}
		try {
			cheia.remove( new Produto("1233", "Teste", 15, 8.99) );
			fail("Nao quebrou quando deveria");
		} catch (Exception e){
			assertEquals("Produto não está na cesta", e.getMessage());
		}
	}

}
