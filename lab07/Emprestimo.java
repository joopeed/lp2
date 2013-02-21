package lp2.lab07;

import java.util.Calendar;

/**
 * 
 * Representa um emprestimo ocorrido e guarda informação sobre
 * @author João Pedro Leôncio <joopeeds@gmail.com>
 *
 */
public class Emprestimo {

	private Calendar data;
	private String emprestadorID, emprestadoID, itemID;
	private boolean ativo;
	
	
	/**
	 * Inicializa um novo emprestimo com a data e hora corrente
	 * @param emprestadorID
	 * 		Id do usuario que esta a emprestar o item
	 * @param emprestadoID
	 * 		Id do usuario a quem o item foi emprestado
	 * @param itemID
	 * 		ID do item emprestado
	 * @throws Exception
	 * 		Caso qualquer dos parametros do construtor sejam invalidos
	 */
	public Emprestimo(String emprestadorID, String emprestadoID, String itemID) throws Exception{
		this(Calendar.getInstance(),emprestadorID, emprestadoID, itemID);

	}
	/**
	 * Inicializa um novo emprestimo 
	 * @param data
	 * 		Data em que o emprestimo ocorreu
	 * @param emprestadorID
	 * 		Id do usuario que esta a emprestar o item
	 * @param emprestadoID
	 * 		Id do usuario a quem o item foi emprestado
	 * @param itemID
	 * 		ID do item emprestado
	 * @throws Exception
	 * 		Caso qualquer dos parametros do construtor sejam invalidos
	 */
	public Emprestimo(Calendar data, String emprestadorID, String emprestadoID, String itemID) throws Exception{
		if ( emprestadorID.length() == 0 ) throw new Exception("ID do emprestador invalida");
		if ( emprestadoID.length() == 0 ) throw new Exception("ID do emprestado invalida");
		if ( itemID.length() == 0 ) throw new Exception("ID do item invalida");
		this.data = data;
		this.itemID = itemID;
		this.emprestadorID = emprestadorID;
		this.emprestadoID = emprestadoID;
		this.ativo = true;

	}
	
	/**
	 * Recupera a data e hora do emprestimo
	 * @return
	 */
	public Calendar getData() {
		return data;
	}

	/**
	 * Recupera o Id do usuario que esta a emprestar o item
	 * @return Id
	 */
	public String getEmprestadorID() {
		return emprestadorID;
	}

	/**
	 * Recupera o Id do usuario que recebe o item emprestado
	 * @return Id
	 */
	public String getEmprestadoID() {
		return emprestadoID;
	}

	/**
	 * Recupera o Id do item emprestado
	 * @return Id
	 */
	public String getItemID() {
		return itemID;
	}

	
	/**
	 * Retorna se o emprestimo esta ativo 
	 * @return
	 */
	public boolean ehAtivo(){
		return ativo;
	}
	/**
	 * Seta o emprestimo com quitado (nao ativo)
	 */
	public void setQuitado(){
		this.ativo = false;
	}
	
	
}
