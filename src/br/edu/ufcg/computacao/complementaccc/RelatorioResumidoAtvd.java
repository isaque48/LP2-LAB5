package br.edu.ufcg.computacao.complementaccc;

import java.util.HashMap;

/**
 * Classe que define um Relatorio Resumido por Atividade, estendendo a classe Relatorio.
 * @author Isaque Esdras Rocha - Matricula: 123110685
 */
public class RelatorioResumidoAtvd extends Relatorio {
	
	/**
	 * Atributo do tipo do relatorio(monitoria,estagio,publicação ou pesquisa)
	 */
	private String tipo;

	/**
	 * Construtor da classe RelatorioResumidoAtvd
	 * @param nome - Nome do estudante
	 * @param cpf - CPF do estudante
	 * @param matricula - Matricula do estudante
	 * @param atvd - Lista de atividades do estudante
	 * @param tipo - Tipo da atividade complementar
	 */
	public RelatorioResumidoAtvd(String nome, String cpf ,String matricula,HashMap<String, AtividadeComplementarAbstract> atvd, String tipo) {
		super(nome, matricula, cpf, atvd);
		this.tipo = tipo;
	}

	/**
	 * Método que sobrescreve o método abstrato relatorioFormatado, retornando a string que representa um Relatorio Resumido por Atividade.
	 * @return Uma string no formato: "Estudante: Nome-Do-Estudante, CPF: CPF-Do-Estudante, Matrícula: Matrícula-Do-Estudante
	 *                                 Atividades de Tipo-da-Atividade: Quantidade-De-Creditos-Acumulados créditos acumulados de Quantidade-Máxima-De-Creditos créditos possíveis"
	 * Caso alguma das atividades que precisam de uma duração minima, para acumular créditos, nao tenha atingido essa duração, no retorno irá aparecer "NÃO ATINGIU AINDA O VALOR MÍNIMO DE CRÉDITOS" 
	 * no lugar da quantidade de creditos acumulados. Caso tenha sido fornecido um tipo de atividade complementar que não existe no sistema irá retornar uma string vazia.
	 */
	@Override
	public String relatorioFormatado() {
		if(this.tipo.toUpperCase().equals("MONITORIA")) {
			return super.toString() + String.format("Atividades de Monitoria: %s créditos acumulados de 16 créditos possíveis.", super.somaCreditosMonitoria());
		}
		
		if(this.tipo.toUpperCase().equals("PERIÓDICO") || this.tipo.toUpperCase().equals("CONFERÊNCIA")) {
			return super.toString() + String.format("Atividades de Publicação: %s créditos acumulados de 16 créditos possíveis.", super.somaCreditosPublicacao());
		}
		
		if(this.tipo.toUpperCase().equals("ESTAGIO") && super.somaCreditosEstagio() == 0) {
			return super.toString() + String.format("Atividades de Estagio: NÃO ATINGIU AINDA O VALOR MÍNIMO DE CRÉDITOS de 18 créditos possíveis.");
		}
		
		if(this.tipo.toUpperCase().equals("ESTAGIO")) {
			return super.toString() + String.format("Atividades de Estagio: %s créditos acumulados de 18 créditos possíveis", super.somaCreditosEstagio());
		}
		
		if(this.tipo.toUpperCase().equals("PESQUISA_EXTENSÃO") && super.somaCreditosPesquisa() == 0) {
			return super.toString() + String.format("Atividades de Pesquisa e Extensão: NÃO ATINGIU AINDA O VALOR MÍNIMO DE CRÉDITOS de 18 créditos possíveis.");
		}
		
		if(this.tipo.toUpperCase().equals("PESQUISA_EXTENSÃO")) {
			return super.toString() + String.format("Atividades de Pesquisa e Extensão: %s créditos acumulados de 18 créditos possíveis.", super.somaCreditosPesquisa());
		}
		
		return "";
	}
	
	

}
