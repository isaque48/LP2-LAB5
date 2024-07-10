package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Classe abstrata responsável por criar o tipo relatorio. Ela possui os atributos nome,matricula,cpf,atvd.
 * @author Isaque Esdras Rocha - Matricula: 123110685
 */
public abstract class Relatorio {
	/**
	 * Atributo do nome do estudante que será usado no relatorio
	 */
	protected String nome;
	
	/**
	 * Atributo da matricula do estudante que será usado no relatorio
	 */
	protected String matricula;
	
	/**
	 * Atributo do cpf do estudante que será usado no relatorio
	 */
	protected String cpf;
	
	/**
	 * Atributo das atividades complementares do estudante que será usado no relatorio
	 */
	protected HashMap<String,AtividadeComplementarAbstract> atvd;
	
	/**
	 * Construtor da classe relatorio
	 * @param nome - Nome do estudante
	 * @param matricula - Matricula do estudante
	 * @param cpf - CPF do estudante
	 * @param atvd - Lista de atividades do estudante
	 */
	public Relatorio(String nome,String matricula,String cpf, HashMap<String,AtividadeComplementarAbstract> atvd ) {
		this.nome = nome;
		this.matricula = matricula;
		this.cpf = cpf;
		this.atvd = atvd;
	}
	
	/**
	 * Método que organiza a lista de atividades do estudante, por ordem alfabética dos tipos.
	 * @return A lista de atividades do estudante com os tipos em ordem alfabética.
	 */
	public String[] atividadesOrdenados() {
		String[] saida = new String[this.atvd.size()];
		ArrayList<AtividadeComplementarAbstract> atvdLista = new ArrayList<>(this.atvd.values());
		
		for(AtividadeComplementarAbstract atv : atvdLista) {
			if(atv.getTipo().toUpperCase().equals("MONITORIA")){
				atv.setTipo("Monitoria");
			}
			
			if(atv.getTipo().toUpperCase().equals("ESTAGIO")) {
				atv.setTipo("Estagio");
			}
			
			if(atv.getTipo().toUpperCase().equals("PESQUISA_EXTENSÃO")) {
				atv.setTipo("Pesquisa_Extensão");
			}
		}
		
		Collections.sort(atvdLista);
		
		for(int i = 0; i < atvdLista.size(); i++) {
			saida[i] = atvdLista.get(i).toString() + "\n";
		}
		
		return saida;
	}
	
	/**
	 * Método responsável por somar todos os creditos de todas as ativades de estagio do estudante
	 * @return o número de creditos acumulados pelo estudante nos estagios
	 */
	public double somaCreditosEstagio() {
		double creditosEstagio = 0;
		int tempoEstagio = 0;
		
		for(AtividadeComplementarAbstract atv : this.atvd.values()) {
			if(atv.getTipo().toUpperCase().equals("ESTAGIO")) {
				creditosEstagio += atv.calculaCreditos();
				tempoEstagio += atv.getUnidadeContababilizada();
			}
		}
		
		if(tempoEstagio < 300) {
			return 0;
		}
		
		if(creditosEstagio > 18) {
			return 18;
		}
		
		return Math.floor(creditosEstagio);
	}
	
	/**
	 * Método responsável por somar todos os creditos das monitorias realizadas pelo estudante
	 * @return o número de creditos acumulados pelas monitorias
	 */
	public double somaCreditosMonitoria() {
		double creditosMonitoria = 0;
		
		for(AtividadeComplementarAbstract atv : this.atvd.values()) {
			if(atv.getTipo().toUpperCase().equals("MONITORIA")) {
				creditosMonitoria += atv.calculaCreditos();
			}
		}
		
		if(creditosMonitoria > 16) {
			return 16;
		}
		
		return creditosMonitoria;
	}
	
	/**
	 * Método responsável por somar todos os creditos adquiridos pelas publicações de artigos do estudante
	 * @return o número de creditos acumulados pela publicação de artigos
	 */
	public double somaCreditosPublicacao() {
		double creditosPublicacao = 0;
		
		for(AtividadeComplementarAbstract atv : this.atvd.values()) {
			if(atv.getTipo().toUpperCase().equals("PERIÓDICO") || atv.getTipo().toUpperCase().equals("CONFERÊNCIA")) {
				creditosPublicacao += atv.calculaCreditos();
			}
		}
		
		if(creditosPublicacao > 16) {
			return 16;
		}
		
		return creditosPublicacao;
	}
	
	/**
	 * Método responsável por somar todos os creditos adquiridos pelas atividades de pesquisa do estudante
	 * @return o número de creditos acumulados pelas atividades de pesquisa
	 */
	public double somaCreditosPesquisa() {
		double creditosPesquisa = 0;
		int tempoPesquisa = 0;
		
		for(AtividadeComplementarAbstract atv : this.atvd.values()) {
			if(atv.getTipo().toUpperCase().equals("PESQUISA_EXTENSÃO")) {
				creditosPesquisa += atv.calculaCreditos();
				tempoPesquisa += atv.getUnidadeContababilizada();
			}
		}
		
		if(tempoPesquisa < 12) {
			return 0;
		}
		
		if(creditosPesquisa > 18) {
			return 18;
		}
		
		return Math.floor(creditosPesquisa);
	}
	
	/**
	 * Método abstrato que formata o relatorio para o jeito que será pedido nos controladores
	 * @return o relatorio formatado
	 */
	public abstract String relatorioFormatado();
	
	/**
	 * Sobrescreve o método toString, atualizando a representação em String da classe Relatorio.
	 * @return Uma string no formato: "Estudante: Nome-Do-Estudante, CPF: CPF-Do-Estudante, Matrícula: Matrícula-Do-Estudante"
	 */
	@Override
	public String toString() {
		return String.format("Estudante: %s; CPF: %s; Matricula: %s\n", this.nome,this.cpf,this.matricula);
	}

}
