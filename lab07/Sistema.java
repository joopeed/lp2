package lp2.lab07;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Representa o sistema que gerencia os emprestimos
 * 
 * @author João Pedro Leôncio <joopeeds@gmail.com>
 * 
 */
public class Sistema {

	private int proximoUsuario = 1000;
	private int proximoItem = 1000;
	private ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	/**
	 * Verifica se um usuario existe no sistema pelo seu id
	 * 
	 * @param ID
	 * @return boolean
	 */
	public int existeUsuario(String ID) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getID().equals(ID))
				return i;
		}
		return -1;
	}

	/**
	 * Cadastra um novo usuario no sistema
	 * 
	 * @param nome
	 * @throws Exception
	 *             Caso o nome seja invalido
	 */
	public void cadastraUsuario(String nome) throws Exception {
		usuarios.add(new Usuario(String.format("%06d", proximoUsuario), nome));
		proximoUsuario++;
	}

	/**
	 * Cadastra um novo item generico
	 * 
	 * @param IDdono
	 *            Id do dono original do item
	 * @param nome
	 *            Nome do item
	 * @param descricao
	 *            Descricao do item
	 * @param tipo
	 *            Tipo do item
	 * @throws Exception
	 *             Caso o usuario ou paremetros seja invalidos
	 */
	public void cadastraItem(String IDdono, String nome, String descricao,
			String tipo) throws Exception {
		int userIndex = existeUsuario(IDdono);
		if (userIndex == -1)
			throw new Exception("Usuario nao existe");
		usuarios.get(userIndex).addItem(
				new Item(String.format("%06d", proximoItem), IDdono, nome,
						descricao, tipo));
		proximoItem++;
	}

	/**
	 * Cria um novo album musical na colecao de alguem
	 * 
	 * @param IDdono
	 *            Id do dono do album
	 * @param nome
	 *            Nome do album
	 * @param descricao
	 *            Descricao do album
	 * @param artista
	 *            Artista do album
	 * @param ano
	 *            Ano do album
	 * @param genero
	 *            Genero do album
	 * @throws Exception
	 *             Caso o dono, nome ou descricao sejam invalidos
	 */

	public void cadastraAlbum(String IDdono, String nome, String descricao,
			String artista, String ano, String genero) throws Exception {
		int userIndex = existeUsuario(IDdono);
		if (userIndex == -1)
			throw new Exception("Usuario nao existe");
		usuarios.get(userIndex).addItem(
				new Album(String.format("%06d", proximoItem), IDdono, nome,
						descricao, artista, ano, genero));
		proximoItem++;
	}

	/**
	 * Cria um novo album musical na colecao de alguem
	 * 
	 * @param IDdono
	 *            Id do dono do filme
	 * @param nome
	 *            Nome do filme
	 * @param descricao
	 *            Descricao do filme
	 * @param diretor
	 *            Diretor do filme
	 * @param elenco
	 *            Elenco do filme
	 * @param ano
	 *            Ano do filme
	 * @param genero
	 *            Genero do filme
	 * @throws Exception
	 *             Caso o dono, nome ou descricao sejam invalidos
	 */

	public void cadastraFilme(String IDdono, String nome, String descricao,
			String diretor, String elenco, String ano, String genero)
			throws Exception {
		int userIndex = existeUsuario(IDdono);
		if (userIndex == -1)
			throw new Exception("Usuario nao existe");
		usuarios.get(userIndex).addItem(
				new Filme(String.format("%06d", proximoItem), IDdono, nome,
						descricao, diretor, elenco, ano, genero));
		proximoItem++;
	}

	/**
	 * Cadastra um novo Livro
	 * 
	 * @param IDdono
	 *            Id do dono do livro
	 * @param nome
	 *            Nome do livro
	 * @param descricao
	 *            Descricao do livro
	 * @param autor
	 *            Autor do livro
	 * @param ano
	 *            Ano de publicacao do livro
	 * @param genero
	 *            Genero do livro
	 * @throws Exception
	 *             Caso o dono, nome ou descricao sejam invalidos
	 */
	public void cadastraLivro(String IDdono, String nome, String descricao, String autor, String ano, String genero)
			throws Exception {
		int userIndex = existeUsuario(IDdono);
		if (userIndex == -1)
			throw new Exception("Usuario nao existe");
		usuarios.get(userIndex).addItem(
				new Livro(String.format("%06d", proximoItem), IDdono, nome,
						descricao, autor, ano, genero));
		proximoItem++;
	}

	/*
	 * Pesquisar por emprestimos(Data, usuario, livro), usuarios(ID, nome) e
	 * Itens: sobrecarga pra o tipo ou sem
	 */

	/**
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Emprestimo> encontraEmprestimoPorData(Calendar data)
			throws Exception {
		ArrayList<Emprestimo> encontrados = new ArrayList<Emprestimo>();
		for (Emprestimo it : emprestimos) {
			if (it.getData().equals(data))
				encontrados.add(it);
		}
		if (encontrados.size() == 0)
			throw new Exception("Emprestimo nao encontrado");
		else
			return encontrados;
	}

	/**
	 * @param usuarioID
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Emprestimo> encontraEmprestimoPorUsuario(String usuarioID)
			throws Exception {
		ArrayList<Emprestimo> encontrados = new ArrayList<Emprestimo>();
		for (Emprestimo it : emprestimos) {
			if (it.getEmprestadorID().equals(usuarioID))
				encontrados.add(it);
		}
		if (encontrados.size() == 0)
			throw new Exception("Emprestimo nao encontrado");
		else
			return encontrados;
	}

	/**
	 * @param itemID
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Emprestimo> encontraEmprestimoPorItem(String itemID)
			throws Exception {
		ArrayList<Emprestimo> encontrados = new ArrayList<Emprestimo>();
		for (Emprestimo it : emprestimos) {
			if (it.getItemID().equals(itemID))
				encontrados.add(it);
		}
		if (encontrados.size() == 0)
			throw new Exception("Emprestimo nao encontrado");
		else
			return encontrados;
	}

	/*
	 * 
	 * Emprestar item (Id to Id, ItemId) verificar existencias...
	 */

	/**
	 * Empresta um item de um usuario a outro
	 * 
	 * @param EmprestadorID
	 *            Id do usuario emprestador
	 * @param EmprestadoID
	 *            Id do usuario que recebe o item
	 * @param ItemID
	 *            Id do item
	 * @throws Exception
	 *             Caso algum dos parametros sejam inexistentes
	 * 
	 */
	public void empresta(String EmprestadorID, String EmprestadoID,
			String ItemID) throws Exception {
		int EmprestadorIndex = existeUsuario(EmprestadorID);
		int EmprestadoIndex = existeUsuario(EmprestadoID);
		if (EmprestadorIndex == -1)
			throw new Exception("Usuario nao existe");
		if (EmprestadoIndex == -1)
			throw new Exception("Usuario nao existe");
		if (!usuarios.get(EmprestadorIndex).temItem(ItemID))
			throw new Exception("Item nao existe");
		if (!(usuarios.get(EmprestadorIndex).getItem(ItemID).getIdDono().equals(EmprestadorID)))
			throw new Exception("Item nao pertence ao usuario");

		usuarios.get(EmprestadoIndex).addItem(
				usuarios.get(EmprestadorIndex).removeItem(ItemID));

		emprestimos.add(new Emprestimo(EmprestadorID, EmprestadoID, ItemID));
	}

	/**
	 * Devolve um item de um usuario a outro
	 * 
	 * @param EmprestadorID
	 *            Id do usuario emprestador
	 * @param EmprestadoID
	 *            Id do usuario que recebe o item
	 * @param ItemID
	 *            Id do item
	 * @throws Exception
	 *             Caso algum dos parametros sejam inexistentes
	 * 
	 */
	public void devolve(String EmprestadorID, String EmprestadoID, String ItemID)
			throws Exception {
		int EmprestadorIndex = existeUsuario(EmprestadorID);
		int EmprestadoIndex = existeUsuario(EmprestadoID);
		
		if (EmprestadorIndex == -1)
			throw new Exception("Usuario nao existe");
		if (EmprestadoIndex == -1)
			throw new Exception("Usuario nao existe");
		if (!usuarios.get(EmprestadoIndex).temItem(ItemID))
			throw new Exception("Item nao existe");
		usuarios.get(EmprestadorIndex).addItem(usuarios.get(EmprestadoIndex).removeItem(ItemID));
		encontraEmprestimo(EmprestadorID, EmprestadoID, ItemID).setQuitado();
	}

	public ArrayList<Item> listaItensDisponiveis(String usuarioID) throws Exception{
		int usuarioIndex = existeUsuario(usuarioID);
		if (usuarioIndex == -1)
			throw new Exception("Usuario nao existe");
		return usuarios.get(usuarioIndex).listaItensDisponiveis();
		
	}
	
	
	private Emprestimo encontraEmprestimo(String EmprestadorID,
			String EmprestadoID, String ItemID) throws Exception {
		for (Emprestimo it : emprestimos)
			if (it.getEmprestadorID().equals(EmprestadorID)
					&& it.getEmprestadoID().equals(EmprestadoID)
					&& it.getItemID().equals(ItemID) && it.ehAtivo())
				return it;
		throw new Exception("Emprestimo nao existe");
	}

}
