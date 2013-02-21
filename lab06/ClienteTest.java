package lp2.lab06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

	Cliente joao, badengo, dongo;
	
	@Before
	public void setUp() throws Exception {
		joao = new Cliente("Joao Pedro", "729273923", "Esperanca");
		badengo = new Cliente("Badengo da Silva","122324","Seattle");
		dongo = new Cliente("Dongo Lucas", "12671831", "Campina Grande");
	}


	@Test
	public void testCliente() {
		assertEquals("Joao Pedro",joao.getNome());
		assertEquals("729273923",joao.getCpf());
		assertEquals("Esperanca",joao.getCidade());
	}

	@Test
	public void testGetNome() {
		assertEquals("Joao Pedro",joao.getNome());
		assertEquals("Badengo da Silva",badengo.getNome());
		assertEquals("Dongo Lucas",dongo.getNome());
	}

	@Test
	public void testSetNome() {
		joao.setNome("Joao Badengo");
		assertEquals("Joao Badengo",joao.getNome());
		badengo.setNome("Badengo Pedro");
		assertEquals("Badengo Pedro",badengo.getNome());
		dongo.setNome("Dongo da Silva");
		assertEquals("Dongo da Silva",dongo.getNome());
	}

	@Test
	public void testGetCpf() {
		assertEquals("729273923",joao.getCpf());
		assertEquals("122324",badengo.getCpf());
		assertEquals("12671831",dongo.getCpf());
	}

	@Test
	public void testSetCpf() {
	try{
	joao.setCpf("4567890");
	assertEquals("4567890",joao.getCpf());
	badengo.setCpf("4567890");
	assertEquals("4567890",badengo.getCpf());
	dongo.setCpf("4567890");
	assertEquals("4567890",dongo.getCpf());
	} catch(Exception e){
		fail("Nao deveria ter quebrado");
	}
	try{
		joao.setCpf("");
		fail("Deveria ter quebrado");
	} catch(Exception e){
		assertEquals("CPF invalido", e.getMessage());
	}
	}

	@Test
	public void testGetCidade() {
		assertEquals("Esperanca",joao.getCidade());
		assertEquals("Seattle",badengo.getCidade());
		assertEquals("Campina Grande",dongo.getCidade());
	}

	@Test
	public void testSetCidade() {
		joao.setCidade("Seattle");
		assertEquals("Seattle",joao.getCidade());
		badengo.setCidade("Seattle");
		assertEquals("Seattle",badengo.getCidade());
		dongo.setCidade("Seattle");
		assertEquals("Seattle",dongo.getCidade());
	}

	@Test
	public void testGetCupom() {
		assertEquals("CL13NT3N0V0",joao.getCupom());
		assertEquals("CL13NT3N0V0",badengo.getCupom());
		assertEquals("CL13NT3N0V0",dongo.getCupom());
	}

	@Test
	public void testSetCupom() {
		joao.setCupom("20ANOSDALOJA");
		assertEquals("20ANOSDALOJA",joao.getCupom());
		badengo.setCupom("20ANOSDALOJA");
		assertEquals("20ANOSDALOJA",badengo.getCupom());
		dongo.setCupom("20ANOSDALOJA");
		assertEquals("20ANOSDALOJA",dongo.getCupom());
	}

	@Test
	public void testFechaCesta() throws Exception {
		joao.adicionaProdutoNaCesta(new Produto("2323", "Alface", 25, 0.89));
		double[] valores = joao.fechaCesta();
		assertEquals(0.89, valores[0], 0.1);
		assertEquals(25, valores[1], 0.05);
	}

	@Test
	public void testAdicionaProdutoNaCesta() throws Exception {
		joao.adicionaProdutoNaCesta(new Produto("2323", "Alface", 25, 0.89));
		try{
		joao.adicionaProdutoNaCesta(new Produto("2323", "Alface", 25, 0.89));
		fail("Deveria ter quebrado");
		} catch(Exception e){
			assertEquals("Produto já está na cesta", e.getMessage());
		}
	}

	@Test
	public void testRemoveProdutodaCesta() {
		try{
		joao.removeProdutodaCesta(new Produto("2323", "Alface", 25, 0.89));
		fail("Deveria ter quebrado");
		} catch(Exception e){
			assertEquals("Cesta vazia", e.getMessage());
		}
	}

	@Test
	public void testEqualsObject() throws Exception {
		dongo = new Cliente("Dongo igual a Joao", "729273923", "Esperanca");
		assertTrue(dongo.equals(joao));
	}

	@Test
	public void testToString() {
		assertEquals("Joao Pedro",joao.toString());
		assertEquals("Badengo da Silva",badengo.toString());
		assertEquals("Dongo Lucas",dongo.toString());
	}

}
