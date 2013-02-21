package lp2.lab07;

/**
 * Representa um album musical
 * @author João Pedro Leôncio <joopeeds@gmail.com>
 *
 */

public class Album extends Item {
	 
	private String artista, ano, genero;
	
	
	/**
	 * Inicializa um novo album musical
	 * @param ID
	 * 		Id do album
	 * @param IDdono
	 * 		Id do dono
	 * @param nome
	 * 		Nome do Album
	 * @param descricao
	 * 		Descricao do album
	 * @param artista
	 * 		Artista do album
	 * @param ano
	 * 		Ano do album
	 * @param genero
	 * 		Genero do album
	 * @throws Exception
	 * 		Caso os Ids, nome ou descricao sejam invalidos
	 */
	public Album(String ID, String IDdono, String nome, String descricao, String artista, String ano, String genero) throws Exception {
		super(ID, IDdono, nome, descricao, "Album");
		this.artista = artista;
		this.ano = ano;
		this.genero = genero;
	}


	
	/**
	 * Recupera o artista do album
	 * @return String
	 */
	public String getArtista() {
		return artista;
	}


	
	/**
	 * Altera o artista do album
	 * @param artista
	 * 		Artista do album
	 */
	public void setArtista(String artista) {
		this.artista = artista;
	}

	
	/**
	 * Recupera o ano do album
	 * @return ano
	 */
	public String getAno() {
		return ano;
	}
	
	/**
	 * Altera o ano do album
	 * @param ano
	 * 		O ano do album
	 */
	public void setAno(String ano) {
		this.ano = ano;
	}


	/**
	 * Recupera o genero do album
	 * @return genero
	 */
	public String getGenero() {
		return genero;
	}


	/**
	 * Altera o genero do album
	 * @param genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

}
