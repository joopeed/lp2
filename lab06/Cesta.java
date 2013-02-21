package lp2.lab06;

/**
 * Representa uma cesta em que se pode adicionar produtos, remover 
 * saber o total e prazo final da compra
 * @author Joao Pedro Leoncio <joopeeds@gmail.com>
 *
 */

public class Cesta {

	private Produto[] produtos;
	
	/**
	 * Inicializa a cesta vazia
	 */
	public Cesta(){
		this.produtos = new Produto[0];
	}
	
	/**
	 * Recupera a soma dos valores de todos os produtos na cesta
	 * @return Total
	 */
	public double getValorTotal(){
		double soma = 0;
		for(int i = 0; i < produtos.length; i++)
			soma += produtos[i].getPreco();
		return soma;
	}
	/**
	 * Recupera o maior prazo entre os produtos dentro da cesta
	 * @return prazo final
	 */
	public double getPrazoFinal(){
		double prazo = 0;
		for(int i = 0; i < produtos.length; i++)
			if ( produtos[i].getPrazo() > prazo )
				prazo = produtos[i].getPrazo();
		return prazo;
	}
	
	/**
	 * Adiciona um produto na cesta
	 * @param Produto
	 * 		Produto a ser adicionado
	 * @throws Exception Excecao se o produto ja estiver na cesta ou ela esteja cheia (5 produtos no max)
	 */
	public void add(Produto it) throws Exception{
		if (produtos.length >= 5) throw new Exception("Cesta cheia");
		if(encontraProduto(it)!=-1) throw new Exception("Produto já está na cesta");
		Produto[] novaCesta = new Produto[produtos.length+1];
		for (int i=0; i < produtos.length; i++) novaCesta[i] = produtos[i];
		novaCesta[produtos.length] = it;
		produtos = novaCesta;
	}
	/**
	 * Remove um produto da cesta
	 * @param Produto
	 *       Produto a ser removido
	 * @throws Exception Excecao caso o produto nao exista na cesta ou ela esteja vazia
	 */
	public void remove(Produto it) throws Exception{
		if (produtos.length == 0) throw new Exception("Cesta vazia");
		int indice = encontraProduto(it);
		if (indice==-1) throw new Exception("Produto não está na cesta");
		Produto[] novaCesta = new Produto[produtos.length-1];
		for (int i=0; i < produtos.length; i++) {
			if(i>indice) novaCesta[i] = produtos[i-1];
			else if (i<indice) novaCesta[i] = produtos[i];
		}
		produtos = novaCesta;
	}
	
	private int encontraProduto(Produto it){
		for (int i=0; i < produtos.length; i++){
			if (it.equals(produtos[i])) return i;
		}
		return -1;
	}
	
	
}