package lp2.lab06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProdutoTest {

	Produto gelol, pao;
	
	@Before
	public void setUp() throws Exception {
		gelol = new Produto("2323", "Gelol", 23, 54.00);
		pao = new Produto("2322", "pao", 1, 1.00);
	}

	@Test
	public void testProduto() {
		assertEquals("2323", gelol.getCodigo());
		assertEquals("Gelol", gelol.getDescricao());
		assertEquals(23, gelol.getPrazo());
		assertEquals(54.00, gelol.getPreco(), 0.5);
		
	}


	@Test
	public void testGetPrazo() throws Exception {
		gelol.setPrazo(16);
		assertEquals(16, gelol.getPrazo());
		gelol.setPrazo(0);
		assertEquals(0, gelol.getPrazo());
	}


	@Test
	public void testSetPreco() throws Exception {
		gelol.setPreco(12.00);
		assertEquals(12, gelol.getPreco(),0.05);
		gelol.setPreco(12.00);
		assertEquals(12, gelol.getPreco(),0.05);
	}

	@Test
	public void testEqualsObject() {
		assertFalse(gelol.equals(pao));
	}
}
