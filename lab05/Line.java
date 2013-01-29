/**
 * 
 */
package lp2.lab05;
/**
 * 
 * @author João Pedro Leôncio <joopeeds@gmail.com>
 *
 */
public class Line {
	

	private double a = 0;
	private double b = 0;
	private double upper_limit = 0;
	private double lower_limit = 0;
	private boolean vertical = false;
		
	public Line (double a, double b){ 
			this.a = a;
			this.b = b;	
	}
	
	public Line (Point p1, Point p2){ // overloading
		double cantBeZero = p2.getX() - p1.getX();
		if ( cantBeZero != 0 ){
			this.a = - ( p1.getY() - p2.getY() ) / cantBeZero ;
			this.b = - ( p1.getX() * p2.getY() - p2.getX() * p1.getY() ) / cantBeZero ;	
			upper_limit = Math.max(p1.getY(), p2.getY());
			lower_limit = Math.min(p1.getY(), p2.getY());
		} else {
			this.a = 0;
			this.b = p1.getX();
			this.vertical = true;
			upper_limit = Math.max(p1.getX(), p2.getX());
			lower_limit = Math.min(p1.getX(), p2.getX());
		}	
	}
	
	public double slope(){
		if (this.isVertical()) return Double.POSITIVE_INFINITY;
		else return b;
	}
	
	public double getA(){
		if (this.isVertical()) return Double.POSITIVE_INFINITY;
		else return a;
	}
	
	
	public boolean belongsToLine(Point pt){ 
		if (this.isVertical()) return pt.getX() == this.b;
		else return pt.getY() == this.calculateY(pt.getX());
	}
	
	public boolean isVertical(){
		return this.vertical;
	}
	
	public boolean isAbove(Point pt){
		if (this.isVertical()) return pt.getX() > this.b;
		else return pt.getY() > this.calculateY(pt.getX());
		
	}
	public boolean isBelow(Point pt){
		if (this.isVertical()) return pt.getX() < this.b;
		else return pt.getY() < this.calculateY(pt.getX());
		
	}

	public boolean isLeft(Point pt){
		if (this.isVertical()) {
			return pt.getX() < this.b; 
		}
		else if( this.a != 0 && pt.getY() <= this.upper_limit && pt.getY() >= this.lower_limit ) {
			return calculateX(pt.getY()) >= pt.getX(); 
		}
		else {
			return false; 
		}
	}
	public double upperLimit(){
		return this.upper_limit;
	}
	
	public double lowerLimit(){
		return this.lower_limit;
	}
	public boolean isRight(Point pt){
		if (this.isVertical()) return pt.getX() > this.b;
		else if( this.a != 0 ) return calculateX(pt.getY()) < pt.getX();
		else return false;
	}
	
	public double calculateY(double x){
		if (this.isVertical()) return Double.POSITIVE_INFINITY;
		else return x*a + b;
	}
	public double calculateX(double y){
		if (this.isVertical()) return b;
		else return (y-b)/a;
	}
	
	public double equationRoot(){
		if (this.isVertical()) return 0;
		else return -b/a;
	}
	
	@Override
	public String toString(){
		String a_s = String.format("%.1f", a);
		String b_s = String.format("%.1f", b);
		if (b>0) b_s = "+"+b_s;
		if (this.isVertical()) return "x = "+ b;
		else {
			if(a==1){
				if(b!=0)
					return "y = x "+b_s;
				else
					return "y = x";
				
			} else if(a==0){
				return "y = "+b_s;
			} else
				return "y = "+a_s+"x "+ b_s;
		}
		
	}

}
