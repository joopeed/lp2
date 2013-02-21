package lp2.lab06;
/**
 * Representa um desconto
 * que possui um codigo de identificacao e um valor relacionado
 * @author Joao Pedro Leoncio <joopeeds@gmail.com>
 *
 */

public class Desconto {

	private String codigo;
	private double desconto;
	/**
	 *  
	 * @param codigo
	 * 		Codigo do Desconto
	 * @param desconto
	 * 		Valor do Desconto
	 */
	public Desconto(String codigo, double desconto) throws Exception{
		this.codigo = codigo;
		this.setDesconto(desconto);
	}
	/**
	 * Recupera o codigo do desconto
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * Altera do codigo do desconto
	 * @param codigo
	 * 		Novo codigo de desconto
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * Recupera o valor do desconto
	 * @return valor
	 */
	
	public double getDesconto() {
		return desconto;
	}
	/**
	 * Altera o valor do desconto
	 * @param desconto
	 * 		Novo valor do desconto
	 * @throws Exception caso o valor recebido seja menor que zero
	 */

	public void setDesconto(double desconto) throws Exception {
		if(desconto < 0 || desconto >1) throw new Exception("Desconto deve ser entre 0 e 1"); 
		this.desconto = desconto;
	}
	
	/**
	 * Verifica se um desconto eh igual a outro. 
	 * Um desconto eh igual a outro se possui o memso codigo
	 */
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Desconto)) return false;
		return ((Desconto) obj ).getCodigo().equals(this.getCodigo());
	}
	/**
	 * Retorna a representacao string do desconto
	 * @return string que representa o desconto
	 */
	@Override
	public String toString(){
		return "Codigo: "+codigo+" Valor: "+ desconto;
		
	}
	
	
	
}