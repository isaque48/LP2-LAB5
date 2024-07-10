package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe que define uma Atividade de Publicação de Artigo, estendendo a classe AtividadeComplementarAbstract. Possui os atributos titulo, doi e qualis.
 * @author Isaque Esdras Rocha - Matricula: 123110685
 */
public class AtividadePublicacao extends AtividadeComplementarAbstract {
	
	/**
	 * Atributo do titulo do artigo
	 */
	private String titulo;
	
	/**
	 * Atributo do identificador digital do objeto (artigo)
	 */
	private String doi;
	
	/**
	 * Atributo sobre a classificação do artigo 
	 */
	private String qualis;

	/**
	 * Construtor da classe AtividadePublicacao
	 * @param codigo - Código da atividade
	 * @param tipo - Tipo da publicação, no caso conferência ou periódigo
	 * @param titulo - Titulo do artigo
	 * @param doi - Identificador digital do artigo
	 * @param qualis - Classificação do artigo
	 */
	public AtividadePublicacao(String codigo, String tipo, String titulo, String doi, String qualis) {
		super(codigo, tipo, 16, 1);
		this.titulo = titulo;
		this.doi = doi;
		this.qualis = qualis;
	}

	/**
	 * Metodo que calcula a quantidade de creditos obtidos por realizar uma publicação de um artigo
	 * @return a quantidade de creditos gerados pela publicação de um artigo
	 */
	@Override
	public double calculaCreditos() {
		if((this.tipo.toUpperCase().equals("PERIÓDICO"))) {
			if(this.qualis.toUpperCase().equals("A1")) {
				return 4;
			}
			
			if(this.qualis.toUpperCase().equals("A2")) {
				return 4;
			}
			
			if(this.qualis.toUpperCase().equals("A3")) {
				return 3;
			}
			
			if(this.qualis.toUpperCase().equals("A4") || this.qualis.toUpperCase().equals("B1") ) {
				return 1;
			}
			
		}
		
		if((this.tipo.toUpperCase().equals("CONFERÊNCIA"))) {
			if(this.qualis.toUpperCase().equals("A1")) {
				return 3;
			}
			
			if(this.qualis.toUpperCase().equals("A2")) {
				return 3;
			}
			
			if(this.qualis.toUpperCase().equals("A3")) {
				return 2;
			}
			
			if(this.qualis.toUpperCase().equals("A4") || this.qualis.toUpperCase().equals("B1") ) {
				return 1;
			}
		}
		
		return 0;
	}

}
