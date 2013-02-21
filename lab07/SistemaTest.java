package lp2.lab07;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SistemaTest {

	Sistema sys;
	
	@Before
	public void setUp() throws Exception {
		sys = new Sistema();
		sys.cadastraUsuario("Joao");
		sys.cadastraFilme("001000","Catch me if you can", "com tom hanks","Spielberg","Tom Hanks e Leonardo", "2003", "Drama");
		
	}


	@Test
	public void testCadastraUsuario() {
		try {
			sys.cadastraUsuario("");
			fail("Nao deveria chegar aqui");
		} catch (Exception e) {
			assertEquals("nome invalido",e.getMessage());
		}
	}

	@Test
	public void testCadastraItem() {
		try {
			sys.cadastraItem("001003","GuardaChuvas", "Pra proteger de chuva",
					"Guarda-Chuva");
			fail("Nao deveria chegar aqui");
		} catch (Exception e) {
			assertEquals("Usuario nao existe", e.getMessage());
		}
	}

	@Test
	public void testCadastraAlbum() {
		try {
			sys.cadastraAlbum("001003","Time Flies", "album de 2010",
					"Oasis", "2010", "Rock");
			fail("Nao deveria chegar aqui");
		} catch (Exception e) {
			assertEquals("Usuario nao existe", e.getMessage());
		}
	}

	@Test
	public void testCadastraFilme() {
		try {
			sys.cadastraFilme("001003","Catch me if you can", "com tom hanks","Spielberg","Tom Hanks e Leonardo", "2003", "Drama");

			fail("Nao deveria chegar aqui");
		} catch (Exception e) {
			assertEquals("Usuario nao existe", e.getMessage());
		}
	}

	@Test
	public void testCadastraLivro() {
		try {
			sys.cadastraLivro("001003","Lord of the rings", "first book of the series",
					"Tolkien", "1954", "Fantasy");
			fail("Nao deveria chegar aqui");
		} catch (Exception e) {
			assertEquals("Usuario nao existe", e.getMessage());
		}
	}

	
	@Test
	public void testEmpresta() throws Exception {
		sys.cadastraUsuario("Maria");
		try{
		sys.empresta("001000", "001001", "001000");
		} catch(Exception e){
			fail("nao deveria quebrar");
			
		}
		
		
	}

	@Test
	public void testDevolve() throws Exception {
		sys.cadastraUsuario("Maria");
		try{
		sys.empresta("001000", "001001", "001000");
		} catch(Exception e){
			
			fail("nao deveria quebrar");
		}
		try{
			sys.devolve("001000", "001001", "001000");
			
		} catch(Exception e){
			System.out.println(e.getMessage());
				fail("nao deveria quebrar");
		}
	}

	@Test
	public void testListaItensDisponiveis() throws Exception {
		ArrayList<Item> teste = new ArrayList<Item>();
		Filme filme1 = new Filme("001000", "123", "Catch me if you can", "com tom hanks","Spielberg","Tom Hanks e Leonardo", "2003", "Drama");
		teste.add(filme1);
		assertEquals(teste, sys.listaItensDisponiveis("001000"));
	}

}
