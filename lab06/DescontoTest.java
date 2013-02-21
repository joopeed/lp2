package lp2.lab06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DescontoTest {

	Desconto unico;
	
	@Before
	public void setUp() throws Exception {
		unico = new Desconto("NOVO", 0.8);
	}


	@Test
	public void testGetCodigo() {
		assertEquals("NOVO",unico.getCodigo());
	}

	@Test
	public void testSetCodigo() {
		unico.setCodigo("FOI");
		assertEquals("FOI", unico.getCodigo());
	}

	@Test
	public void testGetDesconto() {
		assertEquals(0.8,unico.getDesconto(),0.1);
	}

	@Test
	public void testSetDesconto() {
		try{
		unico.setDesconto(2);
		fail("Deveria ter quebrado");
		} catch(Exception e){
			assertEquals("Desconto deve ser entre 0 e 1", e.getMessage());
		}
	}

	@Test
	public void testEqualsObject() throws Exception {
		Desconto outro = new Desconto("NOVO", 0.5);
		assertTrue(outro.equals(unico));
	}

	@Test
	public void testToString() {
		assertEquals("Codigo: NOVO Valor: 0.8",unico.toString());
	}

}
