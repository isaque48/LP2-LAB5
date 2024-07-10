package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe abstrata que define uma AtividadeComplementar, ela possui os atributos descricao,linkDocumentacao,tipo,
 * codigo,creditosMax e unidadeAcumulada.
 * @author Isaque Esdras Rocha - Matricula: 123110685 
 */
public abstract class AtividadeComplementarAbstract implements Comparable<AtividadeComplementarAbstract>{
	/**
	 * Atributo sobre a descricao de uma atividade complemetnar
	 */
	protected String descricao;
	
	/**
	 * Atributo sobre o link de comprovação da atividade complemetnar
	 */
	protected String linkDocumentacao;
	
	/**
	 * Atributo sobre o tipo da atividade complementar
	 */
	protected String tipo;
	
	/**
	 * Atributo sobre o codigo que representa a atividade
	 */
	protected String codigo;
	
	/**
	 * Atributo sobre a quantidade maxima de creditos que a atividade pode gerar
	 */
	protected double creditosMax;
	
	/**
	 * Atributo sobre a quantidade de tempo em que a atividade será realizada
	 */
	protected int unidadeAcumulada;
	
	/**
	 * Construtor da classe AtividadeComplementar
	 * @param codigo - Codigo da atividade
	 * @param tipo - Tipo da atividade
	 * @param creditosMax - Numero de creditos maximos da atividade
	 * @param unidadeAcumulada - Tempo que a atividade será realizada
	 */
	public AtividadeComplementarAbstract(String codigo, String tipo,double creditosMax, int unidadeAcumulada) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.creditosMax = creditosMax;
		this.unidadeAcumulada = unidadeAcumulada;
	}
	
	/**
	 * Metodo abstrato que calcula a quantidade de creditos gerada pela atividade
	 * @return a quantidade de creditos gerada pela atividade
	 */
	public abstract double calculaCreditos();
	
	/**
	 * Método que pega a unidade contabilizada da atividade, ou seja, o tempo que a atividade é realizada
	 * @return a unidade contabilizada
	 */
	public int getUnidadeContababilizada() {
		return this.unidadeAcumulada;
	}
	
	/**
	 * Metodo para pegar o codigo da atividade
	 * @return o codigo da atividade
	 */
	public String getCodigo() {
		return this.codigo;
	}
	
	/**
	 * Método para pegar o tipo da atividade
	 * @return o tipo da atividade
	 */
	public String getTipo() {
		return this.tipo;
	}

	/**
	 * Metodo para definir uma descrição
	 * @param descricao - Descrição que será definida para a classe
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Método para definir um Tipo
	 * @param tipo - tipo que será definido
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Método para definir um link de comprovação da atividade
	 * @param linkDocumentacao - Link que será definido para a classe
	 */
	public void setLinkDocumentacao(String linkDocumentacao) {
		this.linkDocumentacao = linkDocumentacao;
	}
	
	/**
	 * Sobrescreve o método toString, atualizando a representação em String da classe AtividadeComplementarAbstract.
	 * @return Uma string no formato: "Atividade do Tipo: Tipo-Da-Atividade
	 * 				   Descrição: Descrição-Da-Atividade
	 * 				   Creditos Acumulados: Creditos-Gerados-Pela-Atividade"
	 */
	@Override
	public String toString() {
		if(this.tipo.toUpperCase().equals("PERIÓDICO") || this.tipo.toUpperCase().equals("CONFERÊNCIA")) {
			return String.format("Atividade do Tipo: Publicação\nDescrição: %s\nCreditos Acumulados: %s\n", this.descricao,calculaCreditos());
		}
		
		return String.format("Atividade do Tipo: %s\nDescrição: %s\nCreditos Acumulados: %s\n", this.tipo,this.descricao,calculaCreditos());
	}
	
	/**
	 * Sobrescreve o metodo compareTo, comparando os tipos das atividades por ordem alfabética
	 */
	@Override
	public int compareTo(AtividadeComplementarAbstract o1) {
		
		return this.tipo.compareTo(o1.tipo);
	}
}
