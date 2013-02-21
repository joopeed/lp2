package lp2.lab06;


/**
 * Representa uma loja em que se pode realizar operacoes
 * de compra, cadastro de clientes, descontos e produtos
 * 
 * @author Joao Pedro Leoncio <joopeeds@gmail.com>
 *
 */



public class Loja {

	private Produto[] produtos = {};
	private Cliente[] clientes = {};
	private static Desconto[] descontos = new Desconto[0];
	
	public Loja(){
		try{
			descontos = new Desconto[1];
			descontos[0] = new Desconto("CL13NT3N0V0", 0.05);
		} catch(Exception e){
			descontos = new Desconto[0];
		}
	}
	
	/**
	 * Gera uma lista dos clientes cadastrados na loja
	 * @return array de clientes
	 */
	
	public Cliente[] listaClientes(){
		return clientes;
	}
	
	/**
	 * Gera uma lista de produtos cadastrados na loja
	 * @return array de produtos
	 */
	
	public Produto[] listaProdutos(){
		return produtos;
	}
	
	/**
	 * Verifica se o codigo de desconto eh valido e existe um valor para ele na loja
	 * @param codigo
	 * @return o valor do desconto se valido, 0.0 se o desconto for invalido
	 */
	
	
	
	public static double validaDesconto(String codigo){
		if (encontraDescontoValido(codigo)==-1) return 0;
		return descontos[encontraDescontoValido(codigo)].getDesconto();
	}
	
	/**
	 * Fecha a compra de um determinado cliente
	 * @param Cliente
	 * @return array com o valor final da compra ja com desconto e prazo final de entrega
	 * @throws Exception Excecao se o cliente nao existir na loja
	 */
	
	public double[] fechaCompra(Cliente he) throws Exception {
		if (encontraCliente(he)==-1) throw new Exception("Cliente não encontrado");
		return clientes[encontraCliente(he)].fechaCesta();
	}
	
	/**
	 * Cadastra um desconto novo na loja
	 * @param codigo
	 * 		Codigo do Desconto
	 * @param desconto
	 * 		Valor decimal do desconto
	 * @throws Exception Excecao caso o desconto ja esteja cadastrado
	 */
	
	public static void cadastraDesconto(String codigo, double desconto) throws Exception {
		Desconto it = new Desconto(codigo, desconto);
		if(encontraDesconto(it)!=-1) throw new Exception("Desconto já cadastrado");
		Desconto[] novoDescontos = new Desconto[descontos.length+1];
		for (int i=0; i < descontos.length; i++) novoDescontos[i] = descontos[i];
		novoDescontos[descontos.length] = it;
		descontos = novoDescontos;
	}
	
	/**
	 * Cadastra um novo produto na loja
	 * @param codigo
	 * 		Codigo do produto
	 * @param descricao
	 * 		A Descrição do produto
	 * @param prazo
	 * 		Prazo de entrega do produto
	 * @param preco
	 * 		Preço do produto
	 * @throws Lanca excecao caso o produto ja esteja cadastrado na loja
	 */
	
	public void cadastraProduto(String codigo, String descricao, int prazo, double preco) throws Exception {
		Produto it = new Produto(codigo, descricao, prazo, preco);
		if(encontraProduto(it)!=-1) throw new Exception("Produto já cadastrado");
		Produto[] novoProdutos = new Produto[produtos.length+1];
		for (int i=0; i < produtos.length; i++) novoProdutos[i] = produtos[i];
		novoProdutos[produtos.length] = it;
		produtos = novoProdutos;
	}
	/**
	 * Cadastra um novo cliente na loja
	 * @param nome
	 * 		Nome do cliente
	 * @param cpf
	 * 		CPF do cliente
	 * @param cidade
	 * 		Cidade do cliente
	 * @throws Exception Excecao caso o cliente ja esteja cadastrado na loja
	 */
	
	public void cadastraCliente(String nome, String cpf, String cidade) throws Exception {
		Cliente he = new Cliente(nome, cpf, cidade);
		if(encontraCliente(he)!=-1) throw new Exception("Cliente já cadastrado");
		Cliente[] novoClientes = new Cliente[clientes.length+1];
		for (int i=0; i < clientes.length; i++) novoClientes[i] = clientes[i];
		novoClientes[clientes.length] = he;
		clientes = novoClientes;
	}
	/**
	 * Busca um cliente na loja
	 * @param cpf
	 * 		CPF do cliente a ser buscado
	 * @return cliente
	 * 		Cliente encontrado
	 * @throws Exception Excecao caso nao encontre o cliente
	 */
	
	public Cliente buscaCliente(String cpf) throws Exception{
		Cliente clienteABuscar = new Cliente("",cpf,"");
		if (encontraCliente(clienteABuscar)==-1) throw new Exception("Cliente não encontrado");
		return clientes[encontraCliente(clienteABuscar)];
	}
	/**
	 * Busca um produto na loja
	 * @param codigo
	 * 		Codigo do produto a ser buscado
	 * @return produto
	 * 		produto encontrado
	 * @throws Exception Excecao caso nao encontre o produto
	 */
	public Produto buscaProduto(String codigo) throws Exception{
		Produto produtoABuscar = new Produto(codigo,"",0,0);
		if (encontraProduto(produtoABuscar)==-1) throw new Exception("Produto não encontrado");
		return produtos[encontraProduto(produtoABuscar)];
	}
	/**
	 * Busca um desconto na loja
	 * @param codigo
	 * 		Codigo do desconto a ser buscado
	 * @return desconto
	 * 		desconto encontrado
	 * @throws Exception Excecao caso nao encontre o desconto
	 */
	public Desconto buscaDesconto(String codigo) throws Exception{
		Desconto descontoABuscar = new Desconto(codigo,0);
		if (encontraDesconto(descontoABuscar)==-1) throw new Exception("Desconto não encontrado");
		return descontos[encontraDesconto(descontoABuscar)];
	}
	
	private static int encontraDesconto(Desconto it){
		for (int i=0; i < descontos.length; i++){
			if (it.equals(descontos[i])) return i;
		}
		return -1;
	}
	
	private static int encontraDescontoValido(String codigo){
		for (int i=0; i < descontos.length; i++){
			if (descontos[i].getCodigo().equals(codigo)) return i;
		}
		return -1;
	}
	private int encontraProduto(Produto it){
		for (int i=0; i < produtos.length; i++){
			if (it.equals(produtos[i])) return i;
		}
		return -1;
	}
	private int encontraCliente(Cliente he){
		for (int i=0; i < clientes.length; i++){
			if (clientes[i].equals(he)) return i;
		}
		return -1;
	}
	
}