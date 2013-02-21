package lp2.lab07;

/**
 * Representa um livro
 * @author João Pedro Leôncio <joopeeds@gmail.com>
 *
 */
public class Livro extends Item {

	private String autor, ano, genero;

	/**
	 * Inicializa um novo livro
	 * @param ID
	 * 		Id do livro
	 * @param IDdono
	 * 		Id do dono
	 * @param nome
	 * 		Nome do livro
	 * @param descricao
	 * 		Descricao do livro
	 * @param autor
	 * 		Autor do livro
	 * @param ano
	 * 		Ano do livro
	 * @param genero
	 * 		Genero do livro
	 * @throws Exception
	 * 		Caso os Ids, nome ou descricao sejam invalidos
	 */
	public Livro(String ID, String IDdono, String nome, String descricao,
			String autor, String ano, String genero) throws Exception {
		super(ID, IDdono, nome, descricao, "Livro");
		this.autor = autor;
		this.ano = ano;
		this.genero = genero;
	}

	/**
	 * Recupera o autor do livro
	 * @return
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Altera o autor do livro
	 * @param autor
	 * 		Autor do livro
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}


	/**
	 * Recupera o ano do livro
	 * @return ano
	 */
	public String getAno() {
		return ano;
	}


	/**
	 * Altera o ano do livro
	 * @param ano
	 * 		O ano do livro
	 */
	public void setAno(String ano) {
		this.ano = ano;
	}

	/**
	 * Recupera o genero do livro
	 * @return genero
	 */
	public String getGenero() {
		return genero;
	}


	/**
	 * Altera o genero do livro
	 * @param genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}


}
