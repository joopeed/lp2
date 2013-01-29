package lp2.lab05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Matematicae is a project developed in January, 2013 for the LP2 course at UFCG
 * @author João Pedro Leôncio <joopeeds@gmail.com>
 *	
 */


public class Matematicae {

	private static Scanner sc = new Scanner(System.in);
	private final static String nL = System.getProperty("line.separator");
	
	
	final static int LINE = 1;
	final static int PARABOLA = 2;
	final static int POLYGON = 3;
	final static int AP = 4;
	final static int GP = 5;
	final static int MATRIX = 6;
	final static int EXIT = 0;
	final static int BACK = 0;

	public static void main(String[] args) {

		String welcome = "Matematicae © 2013 Joopeed@UFCG/DSC/LP2" + nL
				+ "Hello! Welcome to me. How may I help you?" + nL;

		String mainMenu = "I know about (only :/) these things. Choose one:"
				+ nL + "1 <<< Straight lines and first degree equations" + nL
				+ "2 <<< Parabolas and second degree equations" + nL
				+ "3 <<< Polygons" + nL + "4 <<< Arithmetic progressions" + nL
				+ "5 <<< Geometric progressions" + nL + "6 <<< Matrices" + nL
				+ "Type the number of the chosen option:" + nL;
		String lineMenu = "Hmm. What do you want to know about" + nL
				+ "this straight line?" + nL
				+ "1 << Find the y value from a given x" + nL
				+ "2 << Determine which side of a line my point lies" + nL
				+ "or if it belongs to the line" + nL
				+ "0 << back to previous menu" + nL
				+ "Type the number of the chosen option:" + nL;
		String parabolaMenu = "Good. What do you want to know about" + nL
				+ "this parabola?" + nL
				+ "1 << Find the y value from a given x" + nL
				+ "2 << Find the equation roots" + nL
				+ "0 << back to previous menu" + nL
				+ "Type the number of the chosen option:" + nL;
		String polygonMenu = "Vish, this is painful. What do you want" + nL
				+ "to know about this polygon?" + nL
				+ "1 << Determine whether a point belongs to this polygon" + nL
				+ "2 << Calculate the area of the polygon" + nL
				+ "3 << Calculate the perimeter of the polygon" + nL
				+ "0 << back to previous menu" + nL
				+ "Type the number of the chosen option:" + nL;
		String apMenu = "Good. What do you want to know about" + nL
				+ "this arithmetic progression?" + nL
				+ "1 << Calculate the n-th term of the AP" + nL
				+ "2 << Calculate the sum of the first n terms" + nL
				+ "3 << Calculate the sum of the first terms between n and m"
				+ nL + "4 << See the first n terms" + nL
				+ "0 << back to previous menu" + nL
				+ "Type the number of the chosen option:" + nL;
		String gpMenu = "Good. What do you want to know about" + nL
				+ "this geometric progression?" + nL
				+ "1 << Calculate the n-th term of the GP" + nL
				+ "2 << Calculate the sum of the first n terms" + nL
				+ "3 << Calculate the sum of the first terms between n and m"
				+ nL + "4 << See the first n terms" + nL
				+ "0 << back to previous menu" + nL
				+ "Type the number of the chosen option:" + nL;
		String matrixMenu = "Wow. What do you want to know about this matrix?"
				+ nL
				+ "1 << Verify whether the matrix is an identity matrix"
				+ nL
				+ "2 << Verify whether the matrix is upper or/and lower triangular matrix"
				+ nL + "3 << Verify whether the matrix is symmetric" + nL
				+ "4 << Calculate the inverse matrix" + nL
				+ "5 << Transpose the matrix" + nL
				+ "6 << Calculate the determinant of the matrix" + nL
				+ "7 << Multiply the matrix by a scalar" + nL
				+ "8 << Multiply this matrix by other one" + nL
				+ "9 << Sum this matrix with other one" + nL
				+ "10 << Subtract this matrix from other one" + nL
				+ "0 << back to previous menu" + nL
				+ "Type the number of the chosen option:" + nL;
		
		System.out.println(welcome + mainMenu);
		int option = readInt();
		int opt;

		while (option != EXIT) {

			switch (option) {
			case LINE:
				
				System.out
						.println("Now, type an equation for me to recognize...");
				Line eq = readLineEquation();
				System.out.println("Hmm! I guess you are talking about " + eq);
				System.out.println("Is it correct? Say yes or not, please");
				while (true) {
					String correct = readLine();
					if (correct.equals("yes")) {
						System.out.println("Good! I'm not so bad...");
						break;
					} else if (correct.equals("not")) {
						System.out
								.println("I'm sorry. So type the a of the equation (y=ax+b)");
						double a = readDouble();
						System.out
								.println("Then type the b of the equation (y=ax+b)");
						double b = readDouble();
						eq = new Line(a, b);
						break;
					} else {
						System.out.println("Say yes or not!");
					}
				}
				System.out.println(lineMenu);
				opt = readInt();
				while (opt != BACK) {

					switch (opt) {
					case 1:
						System.out.println("Ok, type a x");
						Double x = readDouble();
						System.out.println("The y is " + eq.calculateY(x));
						break;
					case 2:
						System.out
								.println("Ok, type a point in this form (x,y)");
						readLine();
						Point pt1 = readPoint();
						if (eq.belongsToLine(pt1))
							System.out.println(pt1 + " belongs to the line");
						else if (eq.isAbove(pt1))
							System.out.println(pt1 + " is above the line");
						else if (eq.isBelow(pt1))
							System.out.println(pt1 + " is below the line");
						break;
					}
					System.out.println(lineMenu);
					opt = readInt();

				}
				
				
				
				
				break;
			case PARABOLA:
				System.out
						.println("Now, type an equation for me to recognize...");
				readLine();
				Parabola eq2 = readParabola();
				System.out.println("Hmm! I guess you are talking about " + eq2);
				System.out.println("Is it correct? Say yes or not, please");
				while (true) {
					String correct = readLine();
					if (correct.equals("yes")) {
						System.out.println("Good! I'm not so bad...");
						break;
					} else if (correct.equals("not")) {
						System.out
								.println("I'm sorry. So type the a of the equation (y=ax²+bx+c)");
						double a = readDouble();
						System.out
								.println("Then type the b of the equation (y=ax²+bx+c)");
						double b = readDouble();
						System.out
								.println("Then type the c of the equation (y=ax²+bx+c)");
						double c = readDouble();

						eq2 = new Parabola(a, b, c);
						break;
					} else {
						System.out.println("Say yes or not!");
					}
				}

				System.out.println(parabolaMenu);
				opt = readInt();
				while (opt != BACK) {

					switch (opt) {
					case 1:
						System.out.println("Ok, type a x");
						Double x = readDouble();
						System.out.println("The y is " + eq2.calculateY(x));
						break;
					case 2:
						double[] roots = eq2.equationRoots();
						if (roots.length == 2) {
							System.out.println("The equation roots are "
									+ roots[0] + " and " + roots[1]);
						} else if (roots.length == 1) {
							System.out.println("The equation root is "
									+ roots[0]);
						} else
							System.out.println("There is no real root");
						break;
					}

					System.out.println(parabolaMenu);
					opt = readInt();
				}
				break;
			case POLYGON:
				System.out.println("Type the sequence of vertices "
						+ "in this form (x,y) in the same line");
				ArrayList<Point> vertices = new ArrayList<Point>();
				Pattern patterny = Pattern
						.compile("\\s*\\((\\d*\\.?\\d*),(\\d*\\.?\\d*)\\)\\s*");
				double x = 0;
				double y = 0;
				readLine();
				Matcher matchery = patterny.matcher(readLine());
				while (matchery.find()) {
					String xs = matchery.group(1);
					String ys = matchery.group(2);
					if (!xs.equals(""))
						x = Double.parseDouble(xs.replaceAll(" ", ""));
					if (!ys.equals(""))
						y = Double.parseDouble(ys.replaceAll(" ", ""));
					vertices.add(new Point(x, y));
				}

				Point[] vert = (Point[]) vertices.toArray(new Point[vertices
						.size()]);
				if (vert.length < 3) {
					System.out
							.println("The number of vertices must be greater than 2");
					continue;
				}
				Polygon pol = new Polygon(vert);
				System.out.println(polygonMenu);
				opt = readInt();
				while (opt != BACK) {

					switch (opt) {
					case 1:
						System.out
								.println("Ok, type a point in this form (x,y)");
						readLine();
						Point pt1 = readPoint();
						if (pol.isInside(pt1))
							System.out.println(pt1 + " is inside the polygon");
						else
							System.out.println(pt1
									+ " is not inside the polygon");
						break;
					case 2:
						System.out.println("The area of the polygon is "
								+ String.format("%.2f", pol.area()) + " units");
						break;
					case 3:
						System.out.println("The perimeter of the polygon is "
								+ String.format("%.2f", pol.perimeter()));
						break;
					}

					System.out.println(polygonMenu);
					opt = readInt();
				}
				break;
			case AP:
				System.out.println("Type the first term");
				double a1 = readDouble();
				System.out.println("Type the ratio");
				double ar = readDouble();
				AP ap = new AP(a1, ar);

				System.out.println(apMenu);
				opt = readInt();
				while (opt != BACK) {

					int na, ma;
					switch (opt) {
					case 1:
						System.out
								.println("Type the n of the term that you want to know");
						na = readInt();
						System.out.println("The " + na + "th term is "
								+ ap.calculateNth(na));
						break;
					case 2:
						System.out
								.println("Type the n of the terms that you want to sum");
						na = readInt();
						System.out.println("This sum is " + ap.sumUntilNth(na));
						break;
					case 3:
						System.out.println("Type n, the lower limit to sum");
						na = readInt();
						System.out.println("Type m, the upper limit to sum");
						ma = readInt();
						System.out.println("This sum between " + na + " and "
								+ ma + " is " + ap.calculateBetween(na, ma));
						break;
					case 4:
						System.out
								.println("How many terms do you want to see?");
						na = readInt();
						double[] terms = ap.getAP(na);
						System.out.println(Arrays.toString(terms));
						break;
					}

					System.out.println(apMenu);
					opt = readInt();
				}
				break;
			case GP:
				System.out.println("Type the first term");
				double g1 = readDouble();
				System.out.println("Type the ratio");
				double gr = readDouble();
				GP gp = new GP(g1, gr);
				System.out.println(gpMenu);
				opt = readInt();
				while (opt != BACK) {

					int gn, gm;
					switch (opt) {
					case 1:
						System.out
								.println("Type the n of the term that you want to know");
						gn = readInt();
						System.out.println("The " + gn + "th term is "
								+ gp.calculateNth(gn));
						break;
					case 2:
						System.out
								.println("Type the n of the terms that you want to sum");
						gn = readInt();
						System.out.println("This sum is " + gp.sumUntilNth(gn));
						break;
					case 3:
						System.out.println("Type n, the lower limit to sum");
						gn = readInt();
						System.out.println("Type m, the upper limit to sum");
						gm = readInt();
						System.out.println("This sum between " + gn + " and "
								+ gm + " is " + gp.calculateBetween(gn, gm));
						break;
					case 4:
						System.out
								.println("How many terms do you want to see?");
						gn = readInt();
						double[] terms = gp.getGP(gn);
						System.out.println(Arrays.toString(terms));
						break;
					}

					System.out.println(gpMenu);
					opt = readInt();
				}
				break;
			case MATRIX:
				Matrix m;
				while (true) {
					System.out.println("How many lines does your matrix have?");
					int lin = readInt();
					System.out
							.println("How many columns does your matrix have?");
					int col = readInt();
					
					try {
						readLine();
						m = readMatrix(lin, col);
					} catch (Exception e) {
						System.out
								.println("You typed a wrong number of columns. Please do it again from scratch");
						continue;
					}
					if (!m.isValid()) {
						System.out
								.println("You typed a wrong number of columns. Please do it again from scratch");
						continue;
					}
					break;
				}
				

				boolean show = false;
				System.out.println(matrixMenu);
				opt = readInt();
				while (opt != BACK) {
					if (show) {
						System.out.println(matrixMenu);
						opt = readInt();
					}
					switch (opt) {
					case 1:
						if (!m.isSquare()) {
							System.out
									.println("This operation is for square matrices.");
							show = true;
							continue;
						}
						if (m.isIdentity())
							System.out
									.println("This matrix is an identity matrix");
						else
							System.out
									.println("This matrix is not an identity matrix");
						break;
					case 2:

						if (m.isLowerTriangular() && m.isUpperTriangular())
							System.out
									.println("This matrix is upper and lower triangular matrix");
						else if (m.isLowerTriangular())
							System.out
									.println("This matrix is a lower triangular matrix");
						else if (m.isUpperTriangular())
							System.out
									.println("This matrix is an upper triangular matrix");
						break;
					case 3:
						if (!m.isSquare()) {
							System.out
									.println("This operation is for square matrices.");
							show = true;
							continue;
						}
						if (m.isSymmetric())
							System.out
									.println("This matrix is an symmetric matrix");
						else
							System.out
									.println("This matrix is not an symmetric matrix");
						break;
					case 4:
						if (!m.isSquare()) {
							System.out
									.println("This operation is for square matrices.");
							show = true;
							continue;
						}
						System.out.println("The inverse matrix is:");
						printMatrix(m);
						break;
					case 5:
						System.out.println("The transposed matrix is:");
						printMatrix(m);
						break;
					case 6:
						if (!m.isSquare()) {
							System.out
									.println("This operation is for square matrices.");
							show = true;
							continue;
						}
						System.out.println("The determinant is: "
								+ String.format("%.1f", m.determinant()));
						break;
					case 7:
						System.out.println("Type a scalar to multiply:");
						double scalar = readDouble();
						System.out.println("Result:");
						printMatrix(m.scalarMultiply(scalar));
						break;
					case 8:
						Matrix m2;
						while (true) {
							System.out
									.println("How many lines does your matrix have to multiply?");
							int linn = readInt();
							System.out
									.println("How many columns does your matrix have to multiply?");
							int coln = readInt();
							try {
								m2 = readMatrix(linn, coln);

							} catch (Exception e) {
								System.out
										.println("You typed a wrong number of columns. Please do it again from scratch");
								continue;
							}
							if (!(m.getArrayMatrix()[0].length == m2.getArrayMatrix().length)) {
								System.out.println("You typed a matrix that doesn't have the right dimensions. Try Again");
								continue;
							}
							break;
						}
						System.out.println("Result:");
						printMatrix(m.multiply(m2)); 

						break;
					case 9:
						Matrix m3;
						while (true) {
							System.out
									.println("How many lines does your matrix have to sum ?");
							int linn = readInt();
							System.out
									.println("How many columns does your matrix have to sum ?");
							int coln = readInt();
							try {
								m3 = readMatrix(linn, coln);

							} catch (Exception e) {
								System.out
										.println("You typed a wrong number of columns. Please do it again from scratch");
								continue;
							}
							
							if (! m.hasSameDimensions(m3)) {
								System.out.println("You typed a matrix that doesn't have the same dimensions");
								continue;
							}
							break;
						}
						System.out.println("Result:");
						printMatrix(m.sum(m3)); 

						break;
					case 10:
						Matrix m4;
						while (true) {
							System.out
									.println("How many lines does your matrix to subtract have?");
							int linn = readInt();
							System.out
									.println("How many columns does your matrix to subtract have?");
							int coln = readInt();
							try {
								m4 = readMatrix(linn, coln);

							} catch (Exception e) {
								System.out
										.println("You typed a wrong number of columns. Please do it again from scratch");
								continue;
							}
							
							if (! m.hasSameDimensions(m4)) {
								System.out.println("You typed a matrix that doesn't have the same dimensions");
								continue;
							}
							break;
						}
						System.out.println("Result:");
						printMatrix(m.subtract(m4)); 

						break;

					}

					System.out.println(matrixMenu);
					opt = readInt();
				}

			}

			System.out.println(welcome + mainMenu);
			option = readInt();

		}

	}

	private static void printMatrix(Matrix m) {
		double[][] mx = m.getArrayMatrix();
		for (int i = 0; i < mx.length; i++) {
			for (int j = 0; j < mx[0].length; j++) {
				System.out.print(String.format("%.1f", mx[i][j]) + " ");
			}
			System.out.print(nL);
		}

	}

	private static Matrix readMatrix(int lin, int col) throws Exception {
		System.out.println("Type the elements of the matrix line after line");
		
		double[][] ma = new double[lin][col];
		for (int i = 0; i < lin; i++) {
			for (int j = 0; j < col; j++) {
				ma[i][j] = readDouble();
			}
		}

		return new Matrix(ma);

	}

	private static Line readLineEquation() {
		Pattern patterny = Pattern.compile("\\s*y\\s*=\\s*");
		Pattern patterna = Pattern
				.compile("([\\+-]?\\d*\\.?\\d*)\\s*\\*?\\s*x\\s*");
		Pattern patternb = Pattern.compile("([\\+-]?\\s*\\d*\\.?\\d*(?!x))");
		readLine();
		String equation = readLine();
		double a = 0;
		double b = 0;
		Matcher matchery = patterny.matcher(equation);
		if (matchery.find()) {
			int start = matchery.start();
			int end = matchery.end();
			equation = equation.replace(equation.substring(start, end), "");
		}
		Matcher matchera = patterna.matcher(equation);
		if (matchera.find()) {
			String as = matchera.group(1);
			if (!as.equals(""))
				a = Double.parseDouble(as.replaceAll("\\+", ""));
			else if (equation.contains("x") && as.equals(""))
				a = 1;
			int start = matchera.start();		
			int end = matchera.end();

			equation = equation.replace(equation.substring(start, end), "");

			// System.out.println(equation+"   >"+start+ ","+end);
		}

		Matcher matcherb = patternb.matcher(equation);
		if (matcherb.find()) {
			String bs = matcherb.group(1);
			if (!bs.equals(""))
				b = Double.parseDouble(bs.replaceAll(" ", ""));

		}
		return new Line(a, b);
	}

	private static Parabola readParabola() {

		Pattern patterny = Pattern.compile("\\s*y\\s*=\\s*");
		Pattern patterna = Pattern
				.compile("([\\+-]?\\d*\\.?\\d*)\\s*\\*?\\s*x(?:\\s*²|\\s*\\^\\s*2)\\s*");
		Pattern patternb = Pattern
				.compile("([\\+-]?\\d*\\.?\\d*)\\s*\\*?\\s*x\\s*");
		Pattern patternc = Pattern.compile("([\\+-]?\\s*\\d*\\.?\\d*(?!x))");
		String equation = readLine();
		double a = 0;
		double b = 0;
		double c = 0;
		Matcher matchery = patterny.matcher(equation);
		if (matchery.find()) {
			int start = matchery.start();
			int end = matchery.end();
			equation = equation.replace(equation.substring(start, end), "");
		}

		Matcher matchera = patterna.matcher(equation);
		if (matchera.find()) {
			String as = matchera.group(1);
			if (!as.equals(""))
				a = Double.parseDouble(as.replaceAll("\\+", ""));
			else if (equation.contains("x²") && as.equals(""))
				a = 1;
			int start = matchera.start();
			int end = matchera.end();

			equation = equation.replace(equation.substring(start, end), "");

			// System.out.println(equation+"   >"+start+ ","+end);
		}

		Matcher matcherb = patternb.matcher(equation);
		if (matcherb.find()) {
			String bs = matcherb.group(1);
			if (!bs.equals(""))
				b = Double.parseDouble(bs.replaceAll("\\+", ""));
			else if (equation.contains("x") && !equation.contains("²")
					&& bs.equals(""))
				b = 1;
			int start = matcherb.start();
			int end = matcherb.end();

			equation = equation.replace(equation.substring(start, end), "")
					.replaceAll("\\+", "");

			// System.out.println(equation+"   >"+start+ ","+end);
		}

		Matcher matcherc = patternc.matcher(equation);
		if (matcherc.find()) {
			String cs = matcherc.group(1);
			if (!cs.equals(""))
				c = Double.parseDouble(cs.replaceAll(" ", "0"));

		}
		return new Parabola(a, b, c);

	}

	private static Point readPoint() {
		String pt = readLine();
		Pattern patterny = Pattern
				.compile("\\s*\\(\\s*(\\d?\\.?\\d*)\\s*,\\s*(\\d?\\.?\\d*)\\s*\\)\\s*");
		double x = 0;
		double y = 0;
		Matcher matchery = patterny.matcher(pt);
		if (matchery.find()) {
			String xs = matchery.group(1);
			String ys = matchery.group(2);
			if (!xs.equals(""))
				x = Double.parseDouble(xs.replaceAll(" ", ""));
			if (!ys.equals(""))
				y = Double.parseDouble(ys.replaceAll(" ", ""));
		}
		return new Point(x, y);

	}

	private static String readLine() {
		return sc.nextLine();
	}

	private static double readDouble() {
		while (!sc.hasNextDouble()) {
			sc.next();
		}
		return sc.nextDouble();
	}

	private static int readInt() {
		while (!sc.hasNextInt()) {
			sc.next();
		}
		return sc.nextInt();
	}
	
	
	
	
	

}
