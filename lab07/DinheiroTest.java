package lp2.lab07;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DinheiroTest {

	Dinheiro teste;
	
	@Before
	public void setUp() throws Exception {
		teste = new Dinheiro("1","1", 3.99);
	}

	@Test
	public void testDinheiro() {
		assertEquals(4, teste.getValor(), 0.1);
	}

	@Test
	public void testGetValor() {
		assertEquals(4, teste.getValor(), 0.1);
	}

	@Test
	public void testSetValor() throws Exception {
		teste.setValor(4);
		assertEquals(4, teste.getValor(), 0.1);
		try{
			teste.setValor(-1);
			fail("nao deveria chegar aqui");
		} catch(Exception e){
			assertEquals("Valor nao pode ser negativo", e.getMessage());
		}
	}

}
