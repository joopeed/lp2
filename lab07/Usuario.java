package lp2.lab07;

import java.util.ArrayList;

/**
 * Representa um usuario do sistema
 * @author João Pedro Leôncio <joopeeds@gmail.com>
 *
 */
public class Usuario {

	private String ID, nome;
	private ArrayList <Item> biblioteca = new ArrayList<Item>();
	
	/**
	 * Inicializa um novo usuario
	 * @param ID
	 * 		Id do usuario no sistema
	 * @param nome
	 * 		Nome do usuario
	 * @throws Exception
	 * 		Caso o Id ou nome sejam invalidos
	 */
	public Usuario(String ID, String nome) throws Exception{
		setID(ID);
		setNome(nome);
	}
	
	/**
	 * Adiciona um item na biblioteca deste usuario
	 * @param item
	 */
	public void addItem(Item item){
		biblioteca.add(item);
	}
	
	/**
	 * Remove um item da biblioteca deste usuario pelo id
	 * @param ID
	 * 		Id do item a ser removido
	 * @return Item
	 * 		Item removido
	 * @throws Exception
	 * 		Caso o Id seja inexistente na colecao do usuario
	 */
	public Item removeItem(String ID) throws Exception {
		if(!temItem(ID)) throw new Exception("Item nao existente na biblioteca");
		for(int i=0; i < biblioteca.size(); i++){
			if(biblioteca.get(i).getID().equals(ID)) {
				Item retorno = biblioteca.get(i);
				biblioteca.remove(i);
				return retorno;
			}
		}
		return null;
	}
	
	
	/**
	 * Busca itens do usuario com um determinado nome
	 * @param nome
	 * @return ArrayList<Item> Os itens com esse nome
	 */
	public ArrayList<Item> pesquisaItem(String nome){
		ArrayList<Item> encontrados  = new ArrayList<Item>();
		for(Item it: biblioteca)
			if(nome.equals(it.getNome())) encontrados.add(it);
		return encontrados;
	}
	
	/**
	 * Retorna um item com determinado id
	 * @param ID
	 * 		Id do item
	 * @return Item
	 * @throws Exception
	 * 		Caso o Id seja inexistente na colecao do usuario
	 */
	public Item getItem(String ID) throws Exception{
		for(Item it: biblioteca)
			if(it.getID().equals(ID)) return it;
		throw new Exception("Item nao existe");
	}
	
	/**
	 * Verifica se um item existe na colecao pelo id
	 * @param ID
	 * @return boolean
	 */
	public boolean temItem(String ID){
		for(Item it:biblioteca){
			if(it.getID().equals(ID)) return true;
		}
		return false;
	}
	
	/**
	 * Verifica se o usuario possui um montante em dinheiro
	 * @param montante
	 * @return boolean
	 */
	public boolean temMontante(double montante){
		double soma = 0;
		for(Item it:biblioteca){
			if(it.getTipo().equals("Dinheiro")) {
				soma += ((Dinheiro)it).getValor();
			}
		}
		return soma >= montante;
	}
	
	/**
	 * Recupera o total em dinheiro com o usuario
	 * @return double
	 */
	public double getMontanteTotal(){
		double soma = 0;
		for(Item it:biblioteca){
			if(it.getTipo().equals("Dinheiro")) {
				soma += ((Dinheiro) it).getValor();
			}
		}
		return soma;
	}
	
	/**
	 * Retira montante do usuario
	 * @param montante
	 * @throws Exception
	 * 		Caso o usuario nao possua esse montante
	 */
	public void retiraMontante(double montante) throws Exception{
		if(!temMontante(montante)) throw new Exception("Usuario nao tem esse montante");
		for(int i = biblioteca.size() -1 ; i > -1; i--){
			if(montante <=0) break;
			if(biblioteca.get(i).getTipo().equals("Dinheiro")) {
				double valorDoItem = ((Dinheiro) biblioteca.get(i)).getValor();
				if( valorDoItem <= montante ){
					montante -= valorDoItem;
					biblioteca.remove(i);
				} else ((Dinheiro) biblioteca.get(i)).setValor(valorDoItem-montante);
			}
		}
	}
	
	
	public ArrayList<Item> listaItensDisponiveis(){
		ArrayList<Item> disponiveis = new ArrayList<Item>();
		for(Item i: biblioteca)
			if(i.getIdDono().equals(getID())) disponiveis.add(i);
		return disponiveis;
	}
	public ArrayList<Item> listaItens(){
		return biblioteca;
	}
	
	
	/**
	 * Recupera Id do usuario
	 * @return
	 */
	public String getID() {
		return ID;
	}

	/**
	 * Altera o Id do usuario
	 * @param ID
	 * 		Id do usuario
	 * @throws Exception
	 * 		Caso o Id seja invalido
	 */
	public void setID(String ID) throws Exception {
		if ( ID.length() == 0 ) throw new Exception("ID invalida");
		this.ID = ID;
	}

	/**
	 * Recupera o nome do usuario
	 * @return String
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do usuario
	 * @param nome
	 * @throws Exception
	 * 		Caso o nome do usuario seja invalido
	 */
	public void setNome(String nome) throws Exception {
		if ( nome.length() == 0 ) throw new Exception("nome invalido");
		this.nome = nome;
	}
	
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Usuario)) return false;
		return ((Usuario) obj ).getID().equals(this.getID());
	}
	
}
