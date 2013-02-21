package lp2.lab07;

/**
 * Representa um item dinheiro que possui um valor
 * @author João Pedro Leôncio <joopeeds@gmail.com>
 *
 */
public class Dinheiro extends Item {
	 
	private double valor;
	
	
	/**
	 * Inicializa um novo dinheiro
	 * @param id
	 * 		Id do dinheiro
	 * @param idDono
	 * 		Id do dono do dinheiro
	 * @param valor
	 * 		Valor desse dinheiro
	 * @throws Exception
	 * 		Caso o id do dono seja invalido
	 */
	public Dinheiro(String id, String idDono, double valor) throws Exception {
		super(id, idDono, "Dinheiro", "Dinheiro", "Dinheiro");
		this.valor = valor;
	}


	/**
	 * Recupera o valor em dinheiro do dinheiro
	 * @return
	 */
	public double getValor() {
		return valor;
	}
	
	/**
	 * Altera o valor do dinheiro
	 * @param valor
	 * @throws Exception
	 */
	public void setValor(double valor) throws Exception{
		if(valor < 0) throw new Exception("Valor nao pode ser negativo");
		this.valor = valor;
	}


	




	
}
