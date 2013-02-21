package lp2.lab07;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class EmprestimoTest {

	Emprestimo emp;
	
	@Before
	public void setUp() throws Exception {
		emp = new Emprestimo("1", "2", "1");
	}
	@Test
	public void testEmprestimoStringStringString() {
		assertEquals("1", emp.getEmprestadorID());
		assertEquals("2", emp.getEmprestadoID());
		assertEquals("1", emp.getItemID());
	}

	@Test
	public void testEmprestimoCalendarStringStringString() throws Exception {
		Calendar teste = Calendar.getInstance();
		emp = new Emprestimo(teste, "1","1", "1");
		assertEquals(teste, emp.getData());
		assertEquals("1", emp.getEmprestadorID());
		assertEquals("1", emp.getEmprestadoID());
		assertEquals("1", emp.getItemID());
	}

	@Test
	public void testGetData() throws Exception {
		Calendar teste = Calendar.getInstance();
		emp = new Emprestimo(teste, "1","1", "1");
		assertEquals(teste, emp.getData());
	}

	@Test
	public void testGetEmprestadorID() {
		assertEquals("1", emp.getEmprestadorID());
		
	}

	@Test
	public void testGetEmprestadoID() {
		assertEquals("2", emp.getEmprestadoID());
		
	}

	@Test
	public void testGetItemID() {
		assertEquals("1", emp.getItemID());
	}

	@Test
	public void testEhAtivo() {
		assertTrue(emp.ehAtivo());
	}

	@Test
	public void testSetQuitado() {
		emp.setQuitado();
		assertFalse(emp.ehAtivo());
	}

}
