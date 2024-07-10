package br.edu.ufcg.computacao.complementaccc;

/**
 * Superclasse que define um usurio. Ela possui os atributos nome,cpf e senha
 * @author Isaque Esdras Rocha - Matricula: 123110685
 */
public class Usuario {
	/*
	 *Atributo sobre o nome do usuario
	 */
	protected String nome;
	
	/*
	 * Atributo do cpf do usuario
	 */
	protected String cpf;
	
	/*
	 * Atributo da senha do usuario
	 */
	protected int senha;
	
	/**
	 * Construtor da classe usuario
	 * @param nome - Nome do usuario
	 * @param cpf - CPF do usuario
	 * @param senha - Senha do usuario
	 */
	public Usuario(String nome, String cpf, int senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}
	
	/**
	 * Método responsável por alterar a senha do usuario
	 * @param senhaNova - Nova senha do usuario
	 * @throws IllegalArgumentExcpetion caso a nova senha fornecida não possua 8 digitos
	 */
	public void alteraSenha(int senhaNova) {
		if(senhaNova > 99999999 || senhaNova < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		this.senha = senhaNova;
	}
	
	/**
	 * Método que altera o nome do usuario
	 * @param nome - Novo nome do usuario
	 */
	public void alteraNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo que pega o nome do usuario
	 * @return o nome do usuario
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo que pega o cpf do usuario
	 * @return o cpf do usuario
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Metodo para pegar a senha do usuario
	 * @return a senha do usuario
	 */
	public int getSenha() {
		return senha;
	}
	
}
