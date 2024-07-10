package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe que define um admin e estende a classe Usuario.
 * @author Isaque Esdras Rocha - Matricula: 123110685
 */
public class Admin extends Usuario {

	/**
	 * Construtor do admin
	 * @param nome - Nome do admin
	 * @param cpf - CPF do admin
	 * @param senha - Senha do admin
	 */
	public Admin(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
	}
	
	/**
	 * Sobreescreve o metodo toString,atualizando a representação em String da classe Admin
	 * @return uma string no formato: "Administrador: Nome-do-Admin, CPF: CPF-do-Admin"
	 */
	@Override
	public String toString() {
		return String.format("Administrador: %s, CPF: %s.", super.nome, super.cpf);
	}


}
