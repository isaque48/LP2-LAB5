package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que define um estudante e estende a classe Usuario. Ela possui os atributos matricula,atividades e relatorios.
 * @author Isaque Esdras Rocha - Matricula: 123110685
 */
public class Estudante extends Usuario implements Comparable<Estudante>{
	/**
	 * Atributo da matricula do estudante
	 */
	private String matricula;
	
	/**
	 * Atributo das atividades complementares do estudante
	 */
	private HashMap<String,AtividadeComplementarAbstract> atividades;
	
	/**
	 * Atributo dos relatorios do estudante
	 */
	private ArrayList<Relatorio> relatorios;

	/**
	 * Construtor da classe Estudante.
	 * @param nome - Nome do estudante
	 * @param cpf - CPF do estudante
	 * @param senha - Senha do estudante
	 * @param matricula - Matricula do estudante
	 */
	public Estudante(String nome, String cpf, int senha, String matricula) {
		super(nome, cpf, senha);
		this.matricula = matricula;
		this.atividades = new HashMap<>();
		this.relatorios = new ArrayList<>();
	}
	
	/*
	 * Método que seta a matricula do estudante
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	/**
	 * Método que pega a matricula do estudante
	 * @return a matricula do estudante
	 */
	public String getMatricula() {
		return this.matricula;
	}
	
	/**
	 * Método que pega a lista de atividades do estudante
	 * @return a lista de atividades complementares do estudante
	 */
	public HashMap<String,AtividadeComplementarAbstract> getListaAtividades(){
		return this.atividades;
	}
	
	/**
	 * Método que adiciona uma atividade na lista de atividades complementares do estudante
	 * @param codigo - Codigo da atividade, no formato: CPF-do-Estudante_Número-Da-Atividade (Número esse que é a ordem em que a atividade foi cadastrada)
	 * @param atvd - Atividade que será adicionada à lista de atividades do estudante
	 */
	public void adicionaAtividade(String codigo, AtividadeComplementarAbstract atvd) {
		this.atividades.put(codigo,atvd);
	}
	
	/**
	 * Método que pega um atividade complementar da lista das atividades do estudante
	 * @param codigo - Codigo da atividade
	 * @return uma atividade complementar
	 */
	public AtividadeComplementarAbstract getAtividade(String codigo) {
		return this.atividades.get(codigo);
	}
	
	/**
	 * Metodo que pega o tamanho da lista de atividades complementares
	 * @return o tamanho da lista de atividades
	 */
	public int getTamanhoListaAtividade() {
		return this.atividades.size();
	}
	
	/**
	 * Método que adiciona um relatorio à lista de relatorios
	 * @param relatorioAdicionado - Relatorio que será adicionado
	 */
	public void adicionaRelatorio(Relatorio relatorioAdicionado) {
		this.relatorios.add(relatorioAdicionado);
	}
	
	/**
	 * Método que pega um relatorio da lista de relatorios
	 * @param index - Indíce do relatorio na lista dos relatorios
	 * @return um relatorio
	 */
	public Relatorio getRelatorio(int index) {
		return this.relatorios.get(index);
	}
	
	/**
	 * Sobrescreve o método toString, atualizando a representação em String da classe Estudante.
	 * @return Uma string no formato: "Estudante: Nome-Do-Estudante, CPF: CPF-Do-Estudante, Matrícula: Matrícula-Do-Estudante"
	 */
	@Override
	public String toString() {
		return String.format("Estudante: %s, CPF: %s, Matrícula: %s.", super.nome, super.cpf, this.matricula);
	}

	/**
	 * Sobrescreve o método equals, utilizando o cpf do estudante como parametro para determinar se os estudantes são iguais.
	 * @return true, caso os estudantes sejam iguais, ou false, caso os estudantes nao sejam iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (!(obj instanceof Estudante)){
			return false;
		}
		
		Estudante aluno = (Estudante) obj;
		
		return super.cpf.equals(aluno.cpf);
	}
	
	/**
	 * Sobrescreve o método hashCode, utilizando o cpf do estudante para determinar o hashCode da classe.
	 * @return hashcode gerado apartir do cpf do estudante.
	 */
	@Override
	public int hashCode() {
		return super.cpf.hashCode();
	}

	/**
	 * Sobrescreve o método CompareTo, comparando os nomes dos estudantes por ordem alfabética
	 */
	@Override
	public int compareTo(Estudante o) {
		return super.nome.compareTo(o.nome);
	}
}
