package lp2.lab06;

/**
 * Representa um cliente que possui uma cesta,
 * pode adicionar produtos e remove-los dela. 
 * Eh identificado pelo seu CPF
 * @author Joao Pedro Leoncio <joopeeds@gmail.com>
 */

public class Cliente {
	private String nome;
	private String cpf;
	private String cidade;
	private String[] cuponsUsados;
	private String cupom;
	private Cesta cesta;
	
	/**
	 * 
	 * @param nome
	 * 		O nome do cliente
	 * @param cpf
	 * 		CPF do cliente
	 * @param cidade
	 * 		Cidade do cliente
	 * @throw Exception Caso o CPF seja invalido
	 */
	
	public Cliente(String nome, String cpf, String cidade) throws Exception {
		this.nome = nome;
		setCpf(cpf);
		this.cidade = cidade;
		this.cuponsUsados = new String[0];
		this.cupom = "CL13NT3N0V0";
		this.cesta = new Cesta();

	}

	/**
	 * Recupera o nome do cliente
	 * @return nome do cliente
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Altera o nome do cliente
	 * @param nome
	 * 		Novo nome do cliente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Recupera o CPF do cliente
	 * @return cpf do cliente
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * Altera o CPF do cliente
	 * @param cpf
	 * 		Novo CPF do cliente
	 * @throw Exception Caso o CPF seja invalido
	 */
	public void setCpf(String cpf) throws Exception {
		if(cpf.equals("")) throw new Exception("CPF invalido");
		this.cpf = cpf;
	}
	/**
	 * Recupera a cidade do cliente
	 * @return cidade
	 */
	public String getCidade() {
		return cidade;
	}
	/**
	 * Altera cidade do cliente
	 * @param cidade
	 * 		Nova cidade do cliente
	 */
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	/**
	 * Recupera o codigo de desconto do cliente
	 * @return cupom
	 * 		O codigo de desconto do cliente
	 */
	public String getCupom() {
		return cupom;
	}
	/**
	 * Altera o codigo de desconto do cliente
	 * @param cupom
	 * 		Novo codigo de desconto do cliente
	 */
	public void setCupom(String cupom) {
		this.cupom = cupom;
		
	}
	/**
	 * Fecha a cesta de compras do cliente
	 * @return array com ValorTotal, PrazoFinal
	 */
	
	public double[] fechaCesta(){
		double[] valoresDaCesta = new double[2];
		if(!temDescontoUsado()){
			valoresDaCesta[0] = cesta.getValorTotal()*(1-Loja.validaDesconto(getCupom()));
			usaCupom(getCupom());
		}
		valoresDaCesta[1] = cesta.getPrazoFinal();
		cesta = new Cesta();
		return valoresDaCesta;
	}
	/**
	 * Coloca cupom na lista de cupons ja usados pelo cliente
	 * e que nao podem mais ser utilizados
	 * @param cupom
	 */
	
	private void usaCupom(String cupom){
		String[] used = new String[cuponsUsados.length+1];
		for(int i = 0; i < cuponsUsados.length; i++) used[i] = cuponsUsados[i];
		used[cuponsUsados.length] = cupom;
		this.cuponsUsados = used;
	}
	/**
	 * Verifica se o desconto ja foi usado alguma vez pelo cliente
	 * @return True se usado, False se não
	 */
	
	private boolean temDescontoUsado(){
		for(int i = 0; i < cuponsUsados.length; i++)
			if ( cupom.equals(cuponsUsados[i]) ) return true;
		return false;
	}
	
	/**
	 * Adiciona um produto na cesta do cliente
	 * @param Produto a ser adicionado
	 * @throws Exception Excecao caso o produto ja exista na cesta ou a cesta esteja completa
	 */
	public void adicionaProdutoNaCesta(Produto it) throws Exception{
		cesta.add(it);
	}
	/**
	 * Remove um produto da cesta do cliente
	 * @param Produto a ser removido
	 * @throws Exception Excecao caso o produto não exista na cesta
	 */
	public void removeProdutodaCesta(Produto it) throws Exception{
		cesta.remove(it);
	}
	
	/**
	 * Testa a igualdade do cliente com outro cliente. 
	 * Um cliente eh igual a outro se tiver o mesmo CPF
	 * @return True se iguais, False se diferentes 
	 */
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Cliente )) return false;
		return ((Cliente) obj ).getCpf().equals(this.getCpf());
		
	}
	/**
	 * Retorna a representacao em string do cliente
	 * @return string que representa o cliente
	 */
	
	@Override
	public String toString(){
		return nome;
	}
	
}