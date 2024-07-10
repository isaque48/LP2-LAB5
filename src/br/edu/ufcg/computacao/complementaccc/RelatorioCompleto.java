package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Classe que define um Relatorio Completo, estendendo a classe Relatorio.
 * @author Isaque Esdras Rocha - Matricula: 123110685
 */
public class RelatorioCompleto extends Relatorio{
	/**
	 * Construtor da classe RelatorioCompleto
	 * @param nome - Nome do estudante
	 * @param cpf - CPF do estudante
	 * @param matricula - Matricula do estudante
	 * @param atvd - Lista de atividades do estudante
	 */
	public RelatorioCompleto(String nome,String cpf,String matricula,HashMap<String, AtividadeComplementarAbstract> atvd) {
		super(nome, matricula, cpf, atvd);
	}

	/**
	 * Método que sobrescreve o método abstrato relatorioFormatado, retornando a string que representa um Relatorio Completo
	 * @return Uma string com os dados do estudante seguido da representação textual de todas as atividades complementares 
	 * cadastradas pelo estudante, em ordem alfabética dos tipos das atividades
	 */
	@Override
	public String relatorioFormatado() {
		String saida = "";
		
		for(String texto : atividadesOrdenados()) {
			saida += texto;
		}
		return super.toString() + saida;
	}
}
