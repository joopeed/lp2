package lp2.lab05;

/**
 * 
 * @author João Pedro Leôncio <joopeeds@gmail.com>
 *
 */

public class Matrix {
	
	double[][] data = new double[0][0];
	
	public Matrix(double[][] matrix){
		this.data = matrix;
	}
	
	public double[][] getArrayMatrix(){
		return this.data;
	}
	
	public boolean isIdentity(){
		for(int i = 0; i < this.data.length; i++){
			for(int j = 0; j < this.data[0].length; j++){
				if( (i==j && data[i][j]!=1) || (i!=j && data[i][j]!=0)) return false;
			}
		}
		return true;
	}	
	public boolean isSymmetric(){
		for(int i = 0; i < this.data.length; i++){
			for(int j = 0; j < this.data[0].length; j++){
				if(data[i][j] != data[j][i]) return false;
			}
		}
		return true;
	}
	
	public boolean isUpperTriangular(){
		for(int i = 0; i < this.data.length; i++){
			for(int j = 0; j < this.data[0].length; j++){
				if( i<j && data[i][j]!=0 ) return false;
				
			}
		}
		return true;
		
	}
	public boolean isLowerTriangular(){
		for(int i = 0; i < this.data.length; i++){
			for(int j = 0; j < this.data[0].length; j++){
				if( i>j && data[i][j]!=0 ) return false;
			}
		}
		return true;
	}
	public Matrix transpose(){
		int columns = this.data.length; 
		int lines = this.data[0].length;
		double[][]  transposed = new double[lines][columns];
		for(int i = 0; i < this.data.length; i++){
			for(int j = 0; j < this.data[0].length; j++){
				transposed[j][i] = data[i][j];
				
			}
		}
		return new Matrix(transposed);
	}
	public double determinant(){
		int determinant = 0;
	
		if(this.data.length == 1 && this.data[0].length == 1 ){
			return data[0][0];
		}
		if(this.data.length == 2 && this.data[0].length == 2 ){
			return data[0][0]*data[1][1]-data[1][0]*data[0][1];
		}
		for(int j = 0; j < this.data[0].length; j++){
			determinant += data[0][j] * this.cofactor(0,j);
		}
		return determinant;
			
	}
	
	public Matrix scalarMultiply(double scalar){
		int columns = this.data[0].length; 
		int lines = this.data.length;
		double[][] multiplied = new double[lines][columns];
		for(int i = 0; i < this.data.length; i++){
			for(int j = 0; j < this.data[0].length; j++){
				multiplied[i][j] = data[i][j]*scalar;
				
			}
		}
		return new Matrix(multiplied);
	}
	
	
	
	
	public boolean isValid(){
		int initial = data[0].length;
		for(int i = 0; i < this.data.length; i++){
			if(initial!=data[i].length) return false;
			initial = data[i].length;
		}
		return true;
	}
	
	public boolean isSquare(){
		return data.length == data[0].length && isValid();
	}
	
	
	
	public Matrix sum(Matrix matrix2){
		double[][] arrayMatrix2 = matrix2.getArrayMatrix();
		
		int columns = this.data[0].length; 
		int lines = this.data.length;
		double[][] summed = new double[lines][columns];
		
		
		for(int i = 0; i < this.data.length; i++){
			for(int j = 0; j < this.data[0].length; j++){
				summed[i][j] = data[i][j]+arrayMatrix2[i][j];
				
			}
		}
		return new Matrix(summed);
	}
	public Matrix subtract(Matrix matrix2){
		double[][] arrayMatrix2 = matrix2.getArrayMatrix();
		
		int columns = this.data[0].length; 
		int lines = this.data.length;
		double[][] subtracted = new double[lines][columns];
		
		
		for(int i = 0; i < this.data.length; i++){
			for(int j = 0; j < this.data[0].length; j++){
				subtracted[i][j] = data[i][j]-arrayMatrix2[i][j];
				
			}
		}
		return new Matrix(subtracted);
	}
	public Matrix multiply(Matrix m2){
		double[][] matrix2 = m2.getArrayMatrix();
		double[][] product = new double[this.data.length][matrix2[0].length];
		
		for(int i = 0; i < this.data.length; i++){
			for(int k = 0; k < matrix2[0].length; k++){
				for(int j = 0; j < this.data[0].length; j++){
					product[ i ][ k ] += data[ i ][ j ]* matrix2 [ j ][ k ];
				}
			}
		}
		return new Matrix(product);
	}
	
	public double cofactor(int ii, int jj){
		return Math.pow(-1,ii+jj)*(this.submatrix(ii,jj)).determinant();
	}
	
	public Matrix cofactorMatrix(){
		double[][] comatrix = new double[ this.data.length ][ this.data[0].length ];
		for(int i = 0; i < this.data.length; i++ ){
			for(int j = 0; j < this.data[0].length; j++ ){
				comatrix[i][j] = this.cofactor(i,j);
			}
		}
		return new Matrix(comatrix);
	}
	
	public Matrix submatrix(int ii, int jj){
		double[][] sub = new double[ this.data.length - 1 ][ this.data[0].length - 1 ];
		for(int i = 0; i < this.data.length; i++ ){
			for(int j = 0; j < this.data[0].length; j++ ){
				if(i<ii && j<jj) sub[i][j] = data[i][j];
				else if(i>ii && j<jj) sub[i-1][j] = data[i][j];
				else if(i<ii && j>jj) sub[i][j-1] = data[i][j];
				else if(i>ii && j>jj) sub[i-1][j-1] = data[i][j];
			}
		}
		
		return new Matrix(sub);
	}
	
	public Matrix inverse(){
		return this.cofactorMatrix().transpose().scalarMultiply(1/this.determinant());
	}	
	
	public boolean hasSameDimensions(Matrix m2){
		return m2.getArrayMatrix().length == data.length && m2.getArrayMatrix()[0].length == data[0].length;
	}	
	
	
	
	
	
}
