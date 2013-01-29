/**
 * 
 */
package lp2.lab05;
/**
 * 
 * @author João Pedro Leôncio <joopeeds@gmail.com>
 *
 */
public class Parabola {
	private double a = 0;
	private double b = 0;
	private double c = 0;
	
	public Parabola(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double calculateY(double x){
		return a*x*x + b*x + c;
	}
	
	public boolean belongsToParabola(Point pt){
		return pt.getY() == a*pt.getX()*pt.getX() + b*pt.getX() + c;
	
	}
	public double concavity(){ //think about this method, is really a good habit to use an int as a return?
		if (a > 0) return 1;
		else return -1;
	}
	public double[] equationRoots(){
		double delta = b*b - 4*a*c;
		double[] raizes;
		if (delta > 0) {
			raizes = new double[2];
			raizes[0] =  ((-b + (double) Math.sqrt(delta))/ 2*a);
			raizes[1] =  ((-b - (double) Math.sqrt(delta))/ 2*a);
		}
		else if(delta == 0) {
			raizes = new double[1];
			raizes[0] =  (-b) / 2*a;
		}
		else {
			raizes = new double[0];
		}
		return raizes;	
	}
	@Override
	public String toString(){
		return a+"x² + "+b+"x + "+c;
	}
}
