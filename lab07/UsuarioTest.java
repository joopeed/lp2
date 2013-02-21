package lp2.lab07;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	Usuario joao, joaoAgain;
	Item casaco;
	
	@Before
	public void setUp() throws Exception {
		joao = new Usuario("1", "Joao");
		casaco = new Item("1", "1","casaco", "meu casaco",  "casaco");
	}

	@Test
	public void testUsuario() {
		assertEquals("Joao", joao.getNome());
		assertEquals("1", joao.getID());
	}

	@Test
	public void testAddItem() {
		joao.addItem(casaco);
		assertTrue(joao.temItem("1"));
	}

	@Test
	public void testRemoveItem() throws Exception {
		joao.addItem(casaco);
		joao.removeItem("1");
		assertFalse(joao.temItem("1"));
		try{
			joao.removeItem("2");
			fail("Deveria quebrar");
		} catch(Exception e){
			assertEquals("Item nao existente na biblioteca", e.getMessage());
		}
	}

	@Test
	public void testPesquisaItem() {
		ArrayList<Item> teste = new ArrayList<Item>();
		teste.add(casaco);
		joao.addItem(casaco);
		assertEquals(teste,joao.pesquisaItem("casaco"));
	}

	@Test
	public void testGetItem() throws Exception {
		joao.addItem(casaco);
		assertEquals(casaco, joao.getItem("1"));
	}

	@Test
	public void testTemItem() {
		joao.addItem(casaco);
		assertTrue(joao.temItem("1"));
	}

	@Test
	public void testTemMontante() throws Exception {
		joao.addItem(new Dinheiro("3","1", 2.00));
		assertTrue(joao.temMontante(2));
	}

	@Test
	public void testGetMontanteoTotal() throws Exception {
		joao.addItem(new Dinheiro("3","1", 2.00));
		assertEquals(2,joao.getMontanteTotal(), 0.1);
	}

	@Test
	public void testRetiraMontante() throws Exception {
		joao.addItem(new Dinheiro("3","1", 2.00));
		joao.retiraMontante(1);
		assertEquals(1,joao.getMontanteTotal(), 0.1);
	}

	@Test
	public void testListaItensDisponiveis() {
		ArrayList<Item> teste = new ArrayList<Item>();
		teste.add(casaco);
		joao.addItem(casaco);
		assertEquals(teste,joao.listaItensDisponiveis());
	}

	@Test
	public void testGetID() {
		assertEquals("1", joao.getID());
	}

	@Test
	public void testSetID() {
		try{
			joao.setID("");
			fail("Nao deveria chegar aqui");
		} catch(Exception e){
			assertEquals("ID invalida", e.getMessage());
		}
		try{
			joao.setID("123");
		} catch(Exception e){
			fail("quebrou e nao deveria");
		}
	}

	@Test
	public void testGetNome() {
		assertEquals("Joao", joao.getNome());
		
	}

	@Test
	public void testSetNome() {
		try{
			joao.setNome("");
			fail("Nao deveria chegar aqui");
		} catch(Exception e){
			assertEquals("nome invalido", e.getMessage());
		}
		try{
			joao.setNome("Joao Pedro");
		} catch(Exception e){
			fail("quebrou e nao deveria");
		}
	}

	@Test
	public void testEqualsObject() throws Exception {
		joaoAgain = new Usuario("1", "Joao");
		assertEquals(joaoAgain, joao);
	}

}
