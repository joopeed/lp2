package lp2.lab05;
/**
 * 
 * @author João Pedro Leôncio <joopeeds@gmail.com>
 *
 */


public class AP {

	private double initial = 0;
	private double difference = 0; 
	private double[] ap = new double[1000000];
	
	
	public AP(double initial, double difference) {
		this.initial = initial;
		this.difference = difference;
		this.ap[0] = initial;
	}
	
	public double calculateNth(int n){
		if(n-1 > 0) {
			return calculateNth(n-1) + this.difference;
		}
		else return ap[n-1];
	}
	public double sumUntilNth(int n){
		return n*(this.initial + this.calculateNth(n))/2;
	}
	public double calculateBetween(int n, int m){
		return this.sumUntilNth(m) - this.sumUntilNth(n-1);
	}
	public double[] getAP(int n){
		double[] query = new double[n]; 
		for(int i=0;i<n;i++)
			query[i] = this.calculateNth(i+1);
		return query;
	}
	
	
	
}
