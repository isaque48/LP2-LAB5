package br.edu.ufcg.computacao.complementaccc;

import java.util.HashMap;

/**
 * Classe que define um Relatorio Resumido, estendendo a classe Relatorio.
 * @author Isaque Esdras Rocha - Matricula: 123110685
 */
public class RelatorioResumido extends Relatorio {
	/**
	 * Construtor da classe RelatorioResumido
	 * @param nome - Nome do estudante
	 * @param cpf - CPF do estudante
	 * @param matricula - Matricula do estudante
	 * @param atvd - Lista de atividades do estudante
	 */
	public RelatorioResumido(String nome,String cpf,String matricula,HashMap<String, AtividadeComplementarAbstract> atvd) {
		super(nome, matricula, cpf, atvd);
	}
	
	/**
	 * Método que sobrescreve o método abstrato relatorioFormatado, retornando a string que representa um Relatorio Resumido de todas as atividades do estudante.
	 * @return Uma string no formato: "Estudante: Nome-Do-Estudante, CPF: CPF-Do-Estudante, Matrícula: Matrícula-Do-Estudante
	 *                                 Atividades de Estagio: Quantidade-De-Creditos-Acumulados créditos acumulados de 18 créditos possíveis
	 *                                 Atividades de Monitoria: Quantidade-De-Creditos-Acumulados créditos acumulados de 16 créditos possíveis
	 *                                 Atividades de Pesquisa e Extensão: Quantidade-De-Creditos-Acumulados créditos acumulados de 18 créditos possíveis
	 *                                 Atividades de Publicação: Quantidade-De-Creditos-Acumulados créditos acumulados de 16 créditos possíveis"
	 * Caso alguma das atividades que precisam de uma duração minima, para acumular créditos, nao tenha atingido essa duração, no retorno irá aparecer "NÃO ATINGIU AINDA O VALOR MÍNIMO DE CRÉDITOS" 
	 * no lugar da quantidade de creditos acumulados.
	 */
	@Override
	public String relatorioFormatado() {
		if(somaCreditosPesquisa() == 0 && somaCreditosEstagio() == 0) {
			return super.toString() + String.format("Atividades de Estagio: NÃO ATINGIU AINDA O VALOR MÍNIMO DE CRÉDITOS de 18 créditos possíveis;"
					+ "\nAtividades de Monitoria: %s créditos acumulados de 16 créditos possíveis;"
					+ "\nAtividades de Pesquisa e Extensão: NÃO ATINGIU AINDA O VALOR MÍNIMO DE CRÉDITOS de 18 créditos possíveis;"
					+ "\nAtividades de Publicação: %s créditos acumulados de 16 créditos possíveis.", super.somaCreditosMonitoria(),super.somaCreditosPublicacao());
		}
		
		if(somaCreditosPesquisa() == 0) {
			return super.toString() + String.format("Atividades de Estagio: %s créditos acumulados de 18 créditos possíveis;"
					+ "\nAtividades de Monitoria: %s créditos acumulados de 16 créditos possíveis;"
					+ "\nAtividades de Pesquisa e Extensão: NÃO ATINGIU AINDA O VALOR MÍNIMO DE CRÉDITOS de 18 créditos possíveis;"
					+ "\nAtividades de Publicação: %s créditos acumulados de 16 créditos possíveis.", super.somaCreditosEstagio(),super.somaCreditosMonitoria(),super.somaCreditosPublicacao());
		}
		
		if(somaCreditosEstagio() == 0) {
			return super.toString() + String.format("Atividades de Estagio: NÃO ATINGIU AINDA O VALOR MÍNIMO DE CRÉDITOS de 18 créditos possíveis;"
					+ "\nAtividades de Monitoria: %s créditos acumulados de 16 créditos possíveis;"
					+ "\nAtividades de Pesquisa e Extensão: %s créditos acumulados de 18 créditos possíveis;"
					+ "\nAtividades de Publicação: %s créditos acumulados de 16 créditos possíveis.", super.somaCreditosMonitoria(),super.somaCreditosPesquisa(),super.somaCreditosPublicacao());
		}

		return super.toString() + String.format("Atividades de Estagio: %s créditos acumulados de 18 créditos possíveis;"
				+ "\nAtividades de Monitoria: %s créditos acumulados de 16 créditos possíveis;"
				+ "\nAtividades de Pesquisa e Extensão: %s créditos acumulados de 18 créditos possíveis;"
				+ "\nAtividades de Publicação: %s créditos acumulados de 16 créditos possíveis.", super.somaCreditosEstagio(),super.somaCreditosMonitoria(),super.somaCreditosPesquisa(),super.somaCreditosPublicacao());
	}

}
