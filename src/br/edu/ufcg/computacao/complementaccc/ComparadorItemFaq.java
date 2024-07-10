package br.edu.ufcg.computacao.complementaccc;

import java.util.Comparator;

/**
 * Classe responsável por definir um comparador para a classe Faq
 * @author Isaque Esdras Rocha - Matricula: 123110685
 */
public class ComparadorItemFaq implements Comparator<Faq>{

	/**
	 * Sobrescreve o metodo compare, utilizando a quantidade de destaques como fator de comparação
	 * @return 0, caso as quantidades de destaques sejam iguais;
	 * -1, caso a quantidade de destaque do faq o1 seja maior que do o2; 
	 * 1, caso a quantidade de destaque do faq o1 é menor que do o2
	 */
	@Override
	public int compare(Faq o1, Faq o2) {
		if(o1.getDestaques() > o2.getDestaques()) {
			return -1;
		}
		
		if(o1.getDestaques() < o2.getDestaques()) {
			return 1;
		}
		
		return 0;
	}

}
