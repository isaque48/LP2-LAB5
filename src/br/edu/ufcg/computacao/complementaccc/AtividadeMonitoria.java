package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe que define uma Atividade de Monitoria, estendendo a classe AtividadeComplementarAbstract. Possui o atributo disciplina.
 * @author Isaque Esdras Rocha - Matricula: 123110685
 */
public class AtividadeMonitoria extends AtividadeComplementarAbstract {
	/**
	 * Atributo sobre a disciplina em que a monitoria será realizada.
	 */
	private String disciplina;

	/**
	 * Construtor da classe AtividadeMonitoria
	 * @param codigo - Codigo da atividade
	 * @param tipo - Tipo da atividade, no caso monitoria
	 * @param unidadeContabilizada - Quantidade de periodos que foi realizado a monitoria
	 * @param disciplina - Disciplina que será feita a monitoria
	 */
	public AtividadeMonitoria(String codigo, String tipo,int unidadeContabilizada, String disciplina) {
		super(codigo, tipo, 16, unidadeContabilizada);
		this.disciplina = disciplina;
	}

	/**
	 * Metodo que calcula a quantidade de creditos obtidos por realizar uma monitoria
	 * @return a quantidade de creditos gerados pela monitoria 
	 */
	@Override
	public double calculaCreditos() {
		double credito = this.unidadeAcumulada * 4;
		
		if(credito > super.creditosMax) {
			return super.creditosMax;
		}
		
		return credito;
		
	}

}
