package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe que define uma Atividade de Pesquisa de Extensão, estendendo a classe AtividadeComplementarAbstract. Possui o atributo disciplina.
 * @author Isaque Esdras Rocha - Matricula: 123110685
 */
public class AtividadePesquisaExtensao extends AtividadeComplementarAbstract {
	/**
	 * Atributo sobre a disciplina em que a pesquisa será realizada.
	 */
	private String disciplina;

	/**
	 * Construtor da classe AtividadePesquisaExtensao
	 * @param codigo - Codigo da atividade
	 * @param tipo - Tipo da atividade, no caso pesquisa de extensão
	 * @param unidadeContabilizada - Quantidade de meses que foi realizado a pesquisa
	 * @param disciplina - Disciplina que será feita a pesquisa
	 */
	public AtividadePesquisaExtensao(String codigo, String tipo, int unidadeContabilizada, String disciplina) {
		super(codigo, tipo, 18, unidadeContabilizada);
		this.disciplina = disciplina;
	}

	/**
	 * Metodo que calcula a quantidade de creditos obtidos por realizar uma pesquisa de extensão
	 * @return a quantidade de creditos gerados pela pesquisa 
	 */
	@Override
	public double calculaCreditos() {
		double credito = ((double) 10/12) * super.unidadeAcumulada;
		
		if(super.unidadeAcumulada < 12) {
			return credito;
		}
		
		if(credito > super.creditosMax) {
			return super.creditosMax;
		}
		
		return Math.floor(credito);
	}

}
