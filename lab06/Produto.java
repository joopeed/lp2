package lp2.lab06;
/**
 * Representa um produto que possui um codigo que o identifica,
 * uma descricao, prazo de entrega e preco
 * 
 * @author Joao Pedro Leoncio <joopeeds@gmail.com>
 *
 */
public class Produto {

	private String codigo, descricao;
	private int prazo;
	private double preco;

	
	/**
	 * 
	 * @param codigo
	 *     O codigo de identificacao do produto
	 * @param descricao
	 * 	   A descricao do produto
	 * @param prazo
	 * 	   O prazo de entrega
	 * @param preco
	 * 	   O preco do produto
	 * @throws Exception Caso o preco ou o prazo sejam negativos
	 */
	public Produto(String codigo, String descricao, int prazo, double preco) throws Exception {
		this.codigo = codigo;
		this.descricao = descricao;
		this.setPrazo(prazo);
		this.setPreco(preco);
	}
	
	/**
	 * Recupera o codigo do produto
	 * @return o codigo do produto
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 *  Altera o codigo do produto
	 * @param codigo
	 * 		Novo codigo do produto
	 */

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Recupera a descricao do produto
	 * @return descricao do produto
	 */

	public String getDescricao() {
		return descricao;
	}

	/**
	 *  Altera a descricao do produto
	 * @param descricao
	 * 		Nova descricao do Produto
	 */
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Recupera o prazo de entrega do produto
	 * @return Prazo de entrega
	 */
	public int getPrazo() {
		return prazo;
	}

	/**
	 * Altera o prazo de entrega do produto
	 * @param prazo
	 * 		Novo prazo de entrega
	 * @throws Exception caso o valor recebido seja menor que zero
	 */
	public void setPrazo(int prazo) throws Exception {
		if(prazo < 0) throw new Exception("Prazo deve ser positivo");
		this.prazo = prazo;
	}

	/**
	 * Recupera o preco do produto
	 * @return preco do produto
	 */
	public double getPreco() {
		return preco;
	}
	/**
	 * Altera o preco do produto
	 * @param preco
	 * 		Novo preco do produto
	 * @throws Exception caso o valor recebido seja menor que zero
	 */
	
	public void setPreco(double preco) throws Exception {
		if(preco < 0) throw new Exception("Preco deve ser positivo");
		this.preco = preco;
	}
	/**
	 * Testa a igualdade de um produto com outro. 
	 * Dois produtos sao iguais se possuirem o mesmo codigo
	 * @param objeto
     *            O objeto a comparar com este produto.
     * @return true se o objeto for igual a este produto, false caso
     *         contrário.
	 */
    
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Produto)) return false;
		return ((Produto) obj ).getCodigo().equals(this.getCodigo());
	}
	
	/**
	 *  Representa o produto numa string
	 *  @return a string de representação do produto
	 */
	@Override
	public String toString(){
		return descricao;
	}
	
}