package lp2.lab05;
/**
 * 
 * @author João Pedro Leôncio <joopeeds@gmail.com>
 *
 */
public class GP {
	
	private double initial = 0;
	private double ratio = 0;
	private double[] gp = new double[1000000];
	
	public GP(double initial, double ratio){
		this.initial = initial;
		this.ratio = ratio;
		this.gp[0] = initial;
		
	}
	
	public double calculateNth(int n){
		if(n - 1 > 0) {
			return calculateNth(n-1) * this.ratio;
		}
		else return gp[n-1];
	}
	public double sumUntilNth(int n){
		return this.initial*(1 - this.calculateNth(n+1))/ (1 - this.ratio);
	}
	public double calculateBetween(int n, int m){
		return this.sumUntilNth(m) - this.sumUntilNth(n-1);
	}
	public double[] getGP(int n){
		double[] query = new double[n]; 
		for(int i=0;i<n;i++)
			query[i] = this.calculateNth(i+1);
		return query;
	}
	
	

	
	
}
