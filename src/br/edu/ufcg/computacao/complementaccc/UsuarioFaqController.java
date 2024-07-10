package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Classe responsável por controlar os métodos de usuários e do FAQ. 
 * Ela contem os atributos admin, estudantes e perguntasFrequentes.
 * @author Isaque Esdras Rocha - Matricula: 123110685
 */
public class UsuarioFaqController {
	
	/**
	 * Atributo sobre o administrador cadastrado no sistema.
	 */
	private Admin admin;
	
	/*
	 * Atributo sobre os estudantes cadastrados no sistema.
	 */
	private HashMap<String, Estudante> estudantes;
	
	/*
	 * Atributo sobre as perguntas frequentes e suas respostas cadastras no sistema.
	 */
	private ArrayList<Faq> perguntasFrequentes;
	
	/*
	 * Construtor da classe UsuarioFaqController.
	 * O sistema começa com um adminstrador padrão já cadastrado, ele possui o nome "Admin", o cpf "00000000000" 
	 * e a senha "12345678".
	 */
	public UsuarioFaqController() {
		this.estudantes = new HashMap<>();
		this.admin = new Admin("Admin","00000000000",12345678);
		this.perguntasFrequentes = new ArrayList<>();
	}
	
	/**
	 * Método responsável por retonar um estudante cadastrado no sistema
	 * @param cpf - CPF do estudante que será retornado
	 * @return Um estudante
	 */
	public Estudante getEstudante(String cpf) {
		return this.estudantes.get(cpf);
	}
	
	/**
	 * Método responsável por criar um estudante e cadastra-lo no sistema.
	 * @param nome - Nome do estudante
	 * @param cpf - CPF do estudante
	 * @param senha - Senha para o estudante
	 * @param matricula - Matricula do estudante
	 * @return true, caso o estudante tenha sido criado e cadastrado com sucesso no sistema, ou false, caso o estudante já exista no sistema.
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumento sejam strings vazias ou a senha não fornecida possua 8 digitos.
	 */
	public boolean criarEstudante(String nome, String cpf, int senha, String matricula) {
		if(nome == null || cpf == null || matricula == null) {
			throw new NullPointerException("Argumento Nulo!");
		}
		
		if(nome.trim().equals("") || cpf.trim().equals("") || matricula.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(senha > 99999999 || senha < 10000000) { // Para certificar que a senha terá 8 digitos
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(this.estudantes.containsKey(cpf)) {
			return false;
		}
		
		estudantes.put(cpf, new Estudante(nome,cpf,senha,matricula));
		return true;
	}
	
	/**
	 * Método responsável por retornar a lista de estudantes cadastrados no sistema.
	 * @param cpf - CPF do administrador.
	 * @param senha - Senha do administrador.
	 * @return Uma lista com todos os estudantes cadastrados no sistema em ordem alfabética, ou uma lista vazia, caso o CPF do administrador ou a senha do administrador
	 * fornecidas no método não sejam iguais ao do adminstrador cadastrado no sistema.
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumento sejam strings vazias ou a senha fornecida não possua 8 digitos.
	 */
	public String[] exibirEstudantes(String cpf, int senha) {
		if(cpf == null) {
			throw new NullPointerException("Argumento Nulo!");
		}
		
		if(cpf.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(senha > 99999999 || senha < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		String[] saida = new String[estudantes.size()];
		
		if(!(admin.getCpf().equals(cpf) && admin.getSenha() == senha)) {
			return new String[1];
		}
		
		ArrayList<Estudante> estudantesDuplicado = new ArrayList<>(this.estudantes.values());
		
		Collections.sort(estudantesDuplicado);
		
		for(int i = 0 ; i < estudantesDuplicado.size(); i++) {
			saida[i] = estudantesDuplicado.get(i).toString();
		}
		
		return saida;
	}
	
	/**
	 * Método responsável por alterar um atributo de um estudante. (Não ficou mt claro no lab oq agt deveria deixar mudar no estudante, então eu deixei mudar todos os atributos menos o cpf do estudante).
	 * @param cpf - CPF do estudante
	 * @param senha - Senha do estudante
	 * @param tipoAlteracao - Qual atributo será alterado no estudante (nome/matricula/senha)
	 * @param novoValor - Novo valor do atributo que será alterado no estudante.
	 * @return true, caso a alteração tenha sido realizada com sucesso, ou false, caso não exista um estudante cadastrado no sistema com o cpf fornecido ou a senha fornecida não seja
	 * igual a senha do estudante cadastrado ou tente alterar outro atributo que nao seja o nome/matricula/senha. 
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumento sejam strings vazias ou a senha fornecida não possua 8 digitos.
	 */
	public boolean alterarEstudante(String cpf, int senha, String tipoAlteracao, String novoValor) {
		if(cpf == null || tipoAlteracao == null || novoValor == null) {
			throw new NullPointerException("Argumento Nulo!");
		}
		
		if(cpf.trim().equals("") || tipoAlteracao.trim().equals("") || novoValor.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(senha > 99999999 || senha < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(this.estudantes.get(cpf) == null) {
			return false;
		}
		
		if(!(this.estudantes.get(cpf).getSenha() == senha)) {
			return false;
		}
		
		if(tipoAlteracao.toUpperCase().equals("SENHA")) {
			int senhaNova = Integer.parseInt(novoValor);
			this.estudantes.get(cpf).alteraSenha(senhaNova);
			return true;
		}
		
		if(tipoAlteracao.toUpperCase().equals("NOME")) {
			this.estudantes.get(cpf).alteraNome(novoValor);
			return true;
		}
		
		if(tipoAlteracao.toUpperCase().equals("MATRÍCULA")) {
			this.estudantes.get(cpf).setMatricula(novoValor);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Método responsável por retonar uma representação textual do administrador cadastrado no sistema.
	 * @param cpf - CPF do administrador
	 * @param senha - Senha do administrador
	 * @return Uma representação textual do administrador, ou uma string vazia caso o cpf ou a senha fornecidos no metodo não sejam iguais
	 * ao do administrador cadastro no sistema.
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumento sejam strings vazias ou a senha fornecida não possua 8 digitos.
	 */
	
	public String exibirAdmin(String cpf, int senha) {
		if(cpf == null) {
			throw new NullPointerException("Argumento Nulo!");
		}
		
		if(cpf.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(senha > 99999999 || senha < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(!(admin.getCpf().equals(cpf) && admin.getSenha() == senha)) {
			return "";
		}
		
		return admin.toString();
	}
	
	/**
	 * Método responsável por criar um novo administrador para o sistema.
	 * @param cpf - CPF do administrador atual
	 * @param senhaAtual - Senha do administrador atual
	 * @param nomeNovo - Nome do novo administrador
	 * @param cpfNovo - CPF do novo administrador
	 * @param senhaNova - Senha do novo adminstrador
	 * @return true, caso o novo adminstrador tenha sido criado com sucesso, ou false, caso o cpf atual ou a senha atual fornecidos no metodo
	 * não sejam iguais ao do administrador atual.
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumentos sejam strings vazias ou alguma das senhas fornecidas não possuam 8 digitos.
	 */
	public boolean configurarNovoADMIN(String cpf, int senhaAtual, String nomeNovo, String cpfNovo, int senhaNova) {
		if(cpf == null || nomeNovo == null || cpfNovo == null) {
			throw new NullPointerException("Argumento Nulo!");
		}
		
		if(cpf.trim().equals("") || nomeNovo.trim().equals("") || cpfNovo.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(senhaAtual > 99999999 || senhaAtual < 10000000 || senhaNova > 99999999 || senhaNova < 10000000) {
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(!(admin.getCpf().equals(cpf) && admin.getSenha() == senhaAtual)) {
			return false;
		}
		
		this.admin = new Admin(nomeNovo, cpfNovo,senhaNova);
		return true;
	}
	
	/**
	 * Método responsável por mudar a senha do adminstrador
	 * @param cpf - CPF do administrador
	 * @param senhaAtual - Senha atual do administrador
	 * @param senhaNova - Senha nova que será cadastrada para o administrador
	 * @return true, caso a senha tenha sido alterada com sucesso, ou false, caso o cpf ou a senha fornecidos no método
	 * não sejam iguais ao do admisntrador cadastrado no sistema.
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumentos sejam strings vazias ou alguma das senhas fornecidas não possuam 8 digitos.
	 */
	public boolean configurarSenhaADMIN(String cpf, int senhaAtual, int senhaNova) {
		if(cpf == null) {
			throw new NullPointerException("Argumento Nulo!");
		}
		
		if(cpf.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(senhaAtual > 99999999 || senhaAtual < 10000000 || senhaNova > 99999999 || senhaNova < 10000000) {
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(!(admin.getCpf().equals(cpf) && admin.getSenha() == senhaAtual)) {
			return false;
		}
		
		admin.alteraSenha(senhaNova);
		return true;
	}
	
	/**
	 * Método responsável por criar um pergunta e cadastra-lo no sistema de perguntasFrequentes.
	 * @param cpf - CPF do administrador
	 * @param senha - Senha do administrador
	 * @param pergunta - Pergunta que será cadastrada no sistema
	 * @return true, caso a pergunta tenha sido cadastrada com sucesso, ou false, caso a pergunta já tenha sido cadastrada no sistema
	 * ou caso o cpf ou a senha do admin fornecidas no metodo não sejam iguais ao do admin cadastrado no sistema.
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumentos sejam strings vazias ou a senha fornecida não possua 8 digitos.
	 */
	public boolean adicionarItemFAQ(String cpf, int senha, String pergunta) {
		if(cpf == null || pergunta == null) {
			throw new NullPointerException("Argumento Nulo!");
		}
		
		if(cpf.trim().equals("") || pergunta.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(senha > 99999999 || senha < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(!(admin.getCpf().equals(cpf) && admin.getSenha() == senha)) {
			return false;
		}
		
		Faq novoFaq = new Faq(pergunta);
		
		if(this.perguntasFrequentes.contains(novoFaq)) {
			return false;
		}
		
		this.perguntasFrequentes.add(novoFaq);
		return true;
	}
	
	/**
	 * Método responsável por cadastar uma pergunta e uma resposta no sistema de perguntasFrequentes
	 * @param cpf - CPF do admin
	 * @param senha - Senha do admin
	 * @param pergunta - Pergunta que será cadastrada no sistema
	 * @param resposta - Resposta da pergunta que será cadastrada no sistema
	 * @return true, caso a pergunta e a resposta tenham sido cadastradas com sucesso, ou false, caso a pergunta já exista no sistema ou o cpf ou senha
	 * fornecidos no metodo não sejam iguais ao do adminstrador cadastrado no sistema.
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumentos sejam strings vazias ou a senha fornecida não possua 8 digitos. 
	 */
	public boolean adicionarItemFAQ(String cpf, int senha, String pergunta, String resposta) {
		if(cpf == null || pergunta == null) {
			throw new NullPointerException("Argumento Nulo!");
		}
		
		if(cpf.trim().equals("") || pergunta.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(senha > 99999999 || senha < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(!(admin.getCpf().equals(cpf) && admin.getSenha() == senha)) {
			return false;
		}
		
		Faq novoFaq = new Faq(pergunta,resposta);
		
		if(this.perguntasFrequentes.contains(novoFaq)) {
			return false;
		}
		
		this.perguntasFrequentes.add(novoFaq);
		return true;
	}
	
	/**
	 * Método responsavel por alterar uma resposta de uma pergunta cadastrada no sistema de perguntasFrequentes
	 * @param cpf - CPF do admin
	 * @param senha - Senha do admin
	 * @param itemIndex - Indice do item na lista de perguntasFrequentes
	 * @param resposta - Nova reposta para a pergunta
	 * @return true, caso a resposta tenha sido alterada com sucesso, ou false, caso nao exista uma pergunta no indice fornecido no metodo ou caso
	 * a senha e o cpf fornecidos no metodo nao sejam iguais ao do admin.
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumentos sejam strings vazias ou a senha fornecida não possua 8 digitos.
	 */
	public boolean alteraRespostaItem(String cpf, int senha, int itemIndex, String resposta) {
		if(cpf == null || resposta == null) {
			throw new NullPointerException("Argumento Nulo!");
		}
		
		if(cpf.trim().equals("") || resposta.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(senha > 99999999 || senha < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(!(admin.getCpf().equals(cpf) && admin.getSenha() == senha)) {
			return false;
		}
		
		if(itemIndex > this.perguntasFrequentes.size() - 1) {
			return false;
		}
		
		Faq pergunta = this.perguntasFrequentes.get(itemIndex);
		pergunta.alteraResposta(resposta);
		return true;
	}
	
	/**
	 * Método responsável por listar todas as perguntas cadastradas no sistema
	 * @return - Uma lista com todas as perguntas cadastradas do sistema
	 */
	public String[] listarFAQ() {
		String[] saida = new String[this.perguntasFrequentes.size()];
		
		for(int index = 0; index < this.perguntasFrequentes.size(); index++) {
			saida[index] = this.perguntasFrequentes.get(index).toString();
		}
		
		return saida;
	}
	
	/**
	 * Método responsável por listar todas as perguntas cadastras no sistema na ordem das com maior destaque até as com menor destaque
	 * @return Uma lista com as perguntas do sistema ordenadas por destaque
	 */
	public String[] listarFAQPorDestaque() {
		String[] saida = new String[this.perguntasFrequentes.size()];
		ArrayList<Faq> perguntasFrequentesCopia = new ArrayList<>(this.perguntasFrequentes);
		Collections.sort(perguntasFrequentesCopia, new ComparadorItemFaq());
		
		for(int index = 0; index < perguntasFrequentesCopia.size(); index++) {
			saida[index] = perguntasFrequentesCopia.get(index).toString();
		}
		
		return saida;
	}
	
	/**
	 * Método responsálve por aumentar o destaque de uma pergunta cadastrada no sistema
	 * @param itemIndex - Indíce da pergunta na lista das perguntasFrequentes
	 * @return true, caso a pergunta tenha sido destacada com sucesso, ou false, caso não exista uma pergunta no indice fornecido
	 */
	public boolean destacarItem(int itemIndex) {
		if(itemIndex > this.perguntasFrequentes.size() - 1) {
			return false;
		}
		
		Faq pergunta = this.perguntasFrequentes.get(itemIndex);
		pergunta.aumentaDestaque();
		return true;
	}
	
	/**
	 * Método responsável por atribuir uma lista de até 3 tags para uma pergunta do sistema.
	 * @param cpf - CPF do admin
	 * @param senha - Senha do admin
	 * @param itemIndex - Indíce da pergunta na lista de perguntasFrequentes
	 * @param tags - Lista de tags que será atribuido a pergunta
	 * @return true, caso as tags tenham sido atribuidas com sucesso, ou false, caso o tamanho da lista de tags seja maior que 3 ou caso
	 * a senha e o cpf fornecidos no metodo nao sejam iguais aos do admin
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumentos sejam strings vazias ou a senha fornecida não possua 8 digitos.
	 */
	public boolean atribuirTagsItemFAQ(String cpf, int senha, int itemIndex, String[] tags) {
		if(cpf == null) {
			throw new NullPointerException("Argumento Nulo!");
		}
		
		if(cpf.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(senha > 99999999 || senha < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido!");
		}
		
		if(!(admin.getCpf().equals(cpf) && admin.getSenha() == senha)) {
			return false;
		}
		
		if(tags.length > 3) {
			return false;
		}
		
		for(String teste : tags) {
			if(teste == null) {
				throw new NullPointerException("Argumento Nulo!");
			}
			
			if(teste.trim().equals("")) {
				throw new IllegalArgumentException("Argumento Inválido!");
			}
		}
		
		Faq pergunta = this.perguntasFrequentes.get(itemIndex);
		pergunta.adicionaTag(tags);
		return true;
	}
	
	/**
	 * Método responsável por listar todas as perguntas cadastras no sistema que possuam pelomenos uma tag de uma lista de tags que será fornecida.
	 * @param tags - Lista de tags 
	 * @return Uma lista com todas as perguntas que possuem pelomenos uma das tags fornecidas.
	 */
	
	public String[] buscarItemFAQ(String[] tags) {
		ArrayList<Faq> faqTemporario = new ArrayList<>();
		for(String tagTemp : tags) {
			for(int i = 0; i < this.perguntasFrequentes.size(); i++) {
				if(this.perguntasFrequentes.get(i).verificaExistenciaTag(tagTemp) && !(faqTemporario.contains(this.perguntasFrequentes.get(i)))) {
					faqTemporario.add(this.perguntasFrequentes.get(i));
				}
			}
		}
		
		String[] saida = new String[faqTemporario.size()];
		for(int ind = 0; ind < faqTemporario.size(); ind++){
			saida[ind] = faqTemporario.get(ind).toString();
		}
		
		return saida;
	}
	
	
}
