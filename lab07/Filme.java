package lp2.lab07;

/**
 * Representa um item do tipo filme
 * @author João Pedro Leôncio <joopeeds@gmail.com>
 *
 */

public class Filme extends Item {
	 
	private String diretor, elenco, ano, genero;
	
	
	/**
	 * Inicializa um novo Filme
	 * @param id
	 * 		Id do Filme no sistema
	 * @param idDono
	 * 		Id do dono original do item
	 * @param nome
	 * 		Nome do Filme
	 * @param descricao
	 * 		Descricao do filme
	 * @param diretor
	 * 		Diretor do filme
	 * @param elenco
	 * 		Elenco do filme
	 * @param ano
	 * 		Ano do filme
	 * @param genero
	 * 		Genero do filme
	 * @throws Exception
	 * 		Caso os Ids, nome ou descricao sejam invalidos
	 */
	public Filme(String id, String idDono, String nome, String descricao, String diretor, String elenco, String ano, String genero) throws Exception {
		super(id, idDono, nome, descricao, "Filme");
		this.diretor = diretor;
		this.elenco = elenco;
		this.ano = ano;
		this.genero = genero;
	}


	/**
	 * Recupera o diretor do filme
	 * @return diretor
	 */
	public String getDiretor() {
		return diretor;
	}


	/**
	 * Altera o diretor do filme
	 * @param diretor
	 * 		O nome do diretor do filme
	 */
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}


	/**
	 * @return
	 */
	public String getElenco() {
		return elenco;
	}


	/**
	 * @param elenco
	 */
	public void setElenco(String elenco) {
		this.elenco = elenco;
	}


	
	/**
	 * Recupera o ano do filme
	 * @return ano
	 */
	public String getAno() {
		return ano;
	}


	/**
	 * Altera o ano do filme
	 * @param ano
	 * 		O ano do filme
	 */
	public void setAno(String ano) {
		this.ano = ano;
	}


	/**
	 * Recupera o genero do filme
	 * @return genero
	 */
	public String getGenero() {
		return genero;
	}


	/**
	 * Altera o genero do filme
	 * @param genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}


	
}
