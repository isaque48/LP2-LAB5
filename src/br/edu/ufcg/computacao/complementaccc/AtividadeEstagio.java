package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe que define uma Atividade de Estagio, estendendo a classe AtividadeComplementarAbstract. Possui o atributo disciplina.
 * @author Isaque Esdras Rocha - Matricula: 123110685
 */
public class AtividadeEstagio extends AtividadeComplementarAbstract {
	/**
	 * Atributo sobre a disciplina em que será estagiado.
	 */
	private String disciplina;

	/**
	 * Construtor da classe AtividadeEstagio
	 * @param codigo - Codigo da atividade
	 * @param tipo - Tipo da atividade, no caso estagio
	 * @param unidadeContabilizada - Quantidade de horas que foram estagiados
	 * @param disciplina - Disciplina que será estagiada
	 */
	public AtividadeEstagio(String codigo, String tipo, int unidadeContabilizada, String disciplina) {
		super(codigo, tipo, 18, unidadeContabilizada);
		this.disciplina = disciplina;
	}

	/**
	 * Metodo que calcula a quantidade de creditos obtidos por realizar um estagio
	 * @return a quantidade de creditos gerados pelo estagio 
	 */
	@Override
	public double calculaCreditos() {
		if(super.unidadeAcumulada < 300) {
			return (double) super.unidadeAcumulada / 60;
		}
		
		double credito = super.unidadeAcumulada / 60;
		
		if(credito > super.creditosMax) {
			return super.creditosMax;
		}
		
		return credito;
	}

}
