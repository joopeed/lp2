package lp2.lab07;


/**
 * Representa um item generico
 * @author João Pedro Leôncio <joopeeds@gmail.com>
 *
 */
public class Item {

	protected String ID, nome, descricao, IDdono, tipo;
	
	/**
	 * Inicializa um novo item generico
	 * @param ID
	 * 		Id do item
	 * @param IDdono
	 * 		Id do dono do item
	 * @param nome
	 * 		Nome do item
	 * @param descricao
	 * 		Descricao do item
	 * @param tipo
	 * 		Tipo do item
	 * @throws Exception
	 * 		Caso qualquer dos argumentos sejam invalidos
	 */
	public Item(String ID, String IDdono, String nome, String descricao, String tipo) throws Exception {
		setID(ID);
		setNome(nome);
		setDescricao(descricao);
		setIdDono(IDdono);
		setTipo(tipo);
	}
	

	/**
	 * Recupera o Nome do item
	 * @return String
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do usuario
	 * @param nome
	 * 		Nome do usuario
	 */
	public void setNome(String nome) throws Exception {
		if ( nome.length() == 0 ) throw new Exception("nome invalido");
		this.nome = nome;
	}
	
	/**
	 * Altera o Id do item
	 * @param ID
	 * 		Id do item
	 * @throws Exception
	 * 		Caso o id seja invalido
	 */
	public void setID(String ID) throws Exception{
		if ( ID.length() == 0 ) throw new Exception("ID invalida");
		this.ID = ID;
	}
	
	/**
	 * Altera o tipo do item
	 * @param tipo
	 * 		Tipo do item
	 * @throws Exception
	 *  	Caso o tipo seja invalido
	 */
	public void setTipo(String tipo) throws Exception{
		if ( tipo.length() == 0 ) throw new Exception("tipo invalido");
		this.tipo = tipo;
	}
	
	/**
	 * Altera descricao do item
	 * @param descricao
	 * 		Descricao do item
	 * @throws Exception
	 * 	Caso a descricao seja invalida
	 */
	public void setDescricao(String descricao) throws Exception{
		if ( descricao.length() == 0 ) throw new Exception("Descricao invalida");
		this.descricao = descricao;
	}
	
	/**
	 * 	Altera o id do dono do item
	 * @param IDdono
	 * 		Id do dono do item
	 * @throws Exception
	 * 		Caso o Id seja invalido
	 */
	public void setIdDono(String IDdono) throws Exception{
		if ( IDdono.length() == 0 ) throw new Exception("ID invalida");
		this.IDdono = IDdono;
	}
	/**
	 * Recupera a descricao
	 * @return String
	 */
	public String getDescricao(){
		return descricao;
	}
	/**
	 * Recupera o Id do dono
	 * @return String
	 */
	public String getIdDono(){
		return IDdono;
	}
	/**
	 * Recupera o Id do item
	 * @return String
	 */
	public String getID(){
		return ID;
	}
	/**
	 * Recupera o tipo do item
	 * @return String
	 */
	public String getTipo(){
		return tipo;
	}
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Item)) return false;
		return ((Item) obj ).getID().equals(this.getID());
	}
	
	@Override
	public String toString(){
		return getID() +" "+getNome();
	}
}
