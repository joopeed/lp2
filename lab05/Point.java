package lp2.lab05;

/**
 * 
 * @author João Pedro Leôncio <joopeeds@gmail.com>
 *
 */


public class Point {
	private double x = 0;
	private double y = 0;
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;	
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	@Override
	public String toString(){
		return "("+x+","+y+")";
	}

	
	
}
