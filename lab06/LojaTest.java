package lp2.lab06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LojaTest {

	Loja loja;
	
	@Before
	public void setUp() throws Exception {
		loja = new Loja();
		Loja.cadastraDesconto("NOVO", 0.8);
		loja.cadastraCliente("Joao", "56789", "Seattle");
		loja.cadastraProduto("2323", "Gelol", 23, 54.00);
	}


	@Test
	public void testValidaDesconto() {
		assertEquals(0.8,Loja.validaDesconto("NOVO"),0.1);
	}

	@Test
	public void testFechaCompra() throws Exception {
		double[] valores = loja.fechaCompra(new Cliente("Joao", "56789", "Seattle"));
		assertEquals(54, valores[0], 0.1);
		assertEquals(23, valores[1], 0.1);
	}
	
	@Test
	public void testCadastros() {
		try{
			loja.cadastraCliente("Joao", "56789", "Seattle");
			fail("Deveria quebrar");
			} catch(Exception e){
				assertEquals("Cliente já cadastrado", e.getMessage());
			}
		try{
		loja.cadastraProduto("2323", "Gelol", 23, 54.00);
		fail("Deveria quebrar");
		} catch(Exception e){
			assertEquals("Produto já cadastrado", e.getMessage());
		}
	}


}
