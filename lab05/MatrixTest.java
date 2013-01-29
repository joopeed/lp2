package lp2.lab05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MatrixTest {

	Matrix matriz1;
	Matrix matriz2;
	Matrix matriz3;
	Matrix matriz4;
	Matrix matriz5;
	
	@Before
	public void setUp() throws Exception {
		double[][] m1 = {{1,2},{3,4}};
		matriz1 = new Matrix(m1);
		double[][] m2 = {{1,0},{0,1}};
		matriz2 = new Matrix(m2);
		double[][] m3 = {{1,2},{3,4},{5,6},{7,8}};
		matriz3 = new Matrix(m3);
		double[][] m4 = {{1,0,0},{0,1,0},{0,0,1}};
		matriz4 = new Matrix(m4);
		double[][] m5 = {{1,0,0},{3,1,0},{3,3,1}};
		matriz5 = new Matrix(m5);
	}

	@After
	public void tearDown() throws Exception {
		matriz1 = null;
		matriz2 = null;
	}
	@Test
	public void testGetArrayMatrix() {
		double[][] m1 = {{1,2},{3,4}};
		assertArrayEquals(m1, matriz1.getArrayMatrix());
	}

	@Test
	public void testIsIdentity() {
		assertTrue("isIdentity()", matriz2.isIdentity());
		assertFalse("isIdentity()", matriz1.isIdentity());
		assertTrue("isIdentity()", matriz4.isIdentity());
		assertFalse("isIdentity()", matriz5.isIdentity());
	}

	@Test
	public void testIsSymmetric() {
		assertTrue("isSymmetric()", matriz2.isSymmetric());
		assertFalse("isSymmetric()", matriz1.isSymmetric());
		assertTrue("isSymmetric()", matriz4.isSymmetric());
	}

	@Test
	public void testIsUpperTriangular() {
		assertTrue("isUpperTrianular() 1", matriz2.isUpperTriangular());
		assertTrue("isUpperTrianular() 2", matriz4.isUpperTriangular());
		assertTrue("isUpperTrianular() 3", matriz5.isUpperTriangular());
		assertFalse("isUpperTrianular() 4", matriz1.isUpperTriangular());
		assertFalse("isUpperTrianular() 5", matriz3.isUpperTriangular());
	}

	@Test
	public void testIsLowerTriangular() {
		assertTrue("isLowerTrianular()", matriz2.isLowerTriangular());
		assertTrue("isLowerTrianular()", matriz4.isLowerTriangular());
		assertFalse("isLowerTrianular()", matriz3.isLowerTriangular());
	}

	@Test
	public void testTranspose() {
		double[][] m3t = {{1,3,5,7},{2,4,6,8}};
		assertArrayEquals(m3t, matriz3.transpose().getArrayMatrix());
		
	}

	@Test
	public void testDeterminant() {
		assertEquals("determinant",-2,matriz1.determinant(),0);
		assertEquals("determinant",1,matriz2.determinant(),0);
		assertEquals("determinant",1,matriz4.determinant(),0);
		assertEquals("determinant",1,matriz5.determinant(),0);
	}

	@Test
	public void testScalarMultiply() {
		double[][] m3m = {{10,20},{30,40},{50,60},{70,80}};
		assertArrayEquals(m3m, matriz3.scalarMultiply(10).getArrayMatrix());
	}

	@Test
	public void testSum() {
		double[][] m3s = {{2,0,0},{3,2,0},{3,3,2}};
		assertArrayEquals(m3s, matriz4.sum(matriz5).getArrayMatrix());
		
	}

	@Test
	public void testSubtract() {
		double[][] m3s = {{0,0,0},{-3,0,0},{-3,-3,0}};
		assertArrayEquals(m3s, matriz4.subtract(matriz5).getArrayMatrix());
	}

	@Test
	public void testMultiply() {
		assertArrayEquals(matriz1.getArrayMatrix(), matriz1.multiply(matriz2).getArrayMatrix());
		assertArrayEquals(matriz5.getArrayMatrix(), matriz4.multiply(matriz5).getArrayMatrix());
		
	}
	@Test
	public void testCofactor() {
		assertEquals("cofactor()",4,matriz1.cofactor(0,0),0);
	}

	@Test
	public void testCofactorMatrix() {
		double[][] m1 = {{4,-3},{-2,1}};
		assertArrayEquals(m1, matriz1.cofactorMatrix().getArrayMatrix());
	}

	@Test
	public void testInverse() {
		double[][] m1 = {{-2,1},{1.5,-0.5}};
		assertArrayEquals(m1, matriz1.inverse().getArrayMatrix());
	}
	
	

}
