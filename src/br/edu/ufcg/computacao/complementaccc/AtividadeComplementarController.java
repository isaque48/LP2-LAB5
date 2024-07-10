package br.edu.ufcg.computacao.complementaccc;

import java.util.HashMap;

/**
 * Classe responsável por controlar os metodos que envolvem atividades e relatorios. Ela possue como atributos userFaqControll e geradorIndexRelatorio.
 * @author Isaque Esdras Rocha - Matricula: 123110685
 */

public class AtividadeComplementarController {

	/*
	 * Atributo que associa com o controlador de usario e faq, para poder acessar as informações dos estudantes.
	 */
	private UsuarioFaqController userFaqControll;
	
	/**
	 * Atributo que irá gerar o index dos relatorios dos estudantes
	 */
	private int geradorIndexRelatorio;
	
	/**
	 * Construtor da classe AtividadeComplementarController. O geradorIndexRelatorio começa zerado.
	 * @param controller - Controlador da classe UsuarioFaqController
	 */
	public AtividadeComplementarController(UsuarioFaqController controller) {
		this.userFaqControll = controller;
		this.geradorIndexRelatorio = 0;
	}
	
	/**
	 * Método que cria uma atividade de monitoria e a adiciona ao estudante.
	 * @param cpf - CPF do estudante
	 * @param senha - Senha do estudante
	 * @param tipo - Tipo da atividade, no caso monitoria
	 * @param unidadeAcumulada - Número de periodos em que a monitoria foi realizada
	 * @param disciplina - Disciplina que o estudante será monitor
	 * @return o codigo que representa a atividade, caso ela tenha sido criada e adicionada com sucesso no estudante;
	 * "Estudante não cadastrado" caso nao exista um estudante com o cpf fornecido;
	 * "Senha incorreta" caso a senha fornecida não seja a mesma senha do estudante
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumento sejam strings vazias ou a senha fornecida não possua 8 digitos.
	 */
	public String criarAtividadeMonitoriaEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		if(cpf == null || tipo == null || disciplina == null) {
			throw new NullPointerException("Argumento Nulo");
		}
		
		if(cpf.trim().equals("") || tipo.trim().equals("")|| disciplina.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(senha > 99999999 || senha < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(unidadeAcumulada < 0) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(userFaqControll.getEstudante(cpf) == null) {
			return "Estudante não cadastrado";
		}
		
		if(!(userFaqControll.getEstudante(cpf).getSenha() == senha)) {
			return "Senha incorreta";
		}
		
		
		Estudante aluno = userFaqControll.getEstudante(cpf);
		String codigo = cpf + "_" + (aluno.getTamanhoListaAtividade() + 1);
		
		
		AtividadeComplementarAbstract monitoria = new AtividadeMonitoria(codigo,tipo,unidadeAcumulada,disciplina);
		aluno.adicionaAtividade(codigo,monitoria);
		return codigo;
	}
	
	/**
	 * Método responsável por alterar a descrição de uma atividade complementar
	 * @param cpf - CPF do estudante
	 * @param senha - Senha do estudante
	 * @param codigoAtividade - Codigo da atividade que terá a descrição alterada
	 * @param descricao - Nova descrição para a atividade
	 * @return true, caso a descrição tenha sido alterada com sucesso, ou false, caso o estudante não exista no sistema ou caso
	 * a senha fornecida nao seja igual a senha do estudante ou caso a atividade não exista.
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumento sejam strings vazias ou a senha fornecida não possua 8 digitos.
	 */
	public boolean alterarDescricaoAtividade(String cpf, int senha, String codigoAtividade, String descricao) {
		if(cpf == null || codigoAtividade == null || descricao == null) {
			throw new NullPointerException("Argumento Nulo");
		}
		
		if(cpf.trim().equals("") || codigoAtividade.trim().equals("")|| descricao.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(senha > 99999999 || senha < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(userFaqControll.getEstudante(cpf) == null) {
			return false;
		}
		
		if(!(userFaqControll.getEstudante(cpf).getSenha() == senha)) {
			return false;
		}
		
		if(userFaqControll.getEstudante(cpf).getAtividade(codigoAtividade) == null) {
			return false;
		}
		
		AtividadeComplementarAbstract atvd = userFaqControll.getEstudante(cpf).getAtividade(codigoAtividade);
		atvd.setDescricao(descricao);
		return true;
	}
	
	/**
	 * Método responsável por alterar o link de comprovação da atividade complementar.
	 * @param cpf - CPF do estudante
	 * @param senha - Senha do estudante
	 * @param codigoAtividade - Código da atividade que terá a comprovação alterada
	 * @param linkComprovacao - Novo link de comprovação para a atividade
	 * @return true, caso o link de comprovação tenha sido alterado com sucesso, ou false, caso o estudante não exista ou
	 * caso a senha fornecida não seja igual a senha do estudante ou caso a atividade não exista.
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumento sejam strings vazias ou a senha fornecida não possua 8 digitos.
	 */
	public boolean alterarComprovacaoAtividade(String cpf, int senha, String codigoAtividade, String linkComprovacao) {
		if(cpf == null || codigoAtividade == null || linkComprovacao == null) {
			throw new NullPointerException("Argumento Nulo");
		}
		
		if(cpf.trim().equals("") || codigoAtividade.trim().equals("")|| linkComprovacao.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(senha > 99999999 || senha < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(userFaqControll.getEstudante(cpf) == null) {
			return false;
		}
		
		if(!(userFaqControll.getEstudante(cpf).getSenha() == senha)) {
			return false;
		}
		
		if(userFaqControll.getEstudante(cpf).getAtividade(codigoAtividade) == null) {
			return false;
		}
		
		AtividadeComplementarAbstract atvd = userFaqControll.getEstudante(cpf).getAtividade(codigoAtividade);
		atvd.setLinkDocumentacao(linkComprovacao);
		return true;
	}
	
	/**
	 * Método que cria uma atividade de pesquisa e extensão e a adiciona ao estudante.
	 * @param cpf - CPF do estudante
	 * @param senha - Senha do estudante
	 * @param tipo - Tipo da atividade, no caso pesquisa_extensão
	 * @param unidadeAcumulada - Quantidade de meses em que a pesquisa está sendo feita
	 * @param disciplina - Disciplina da pesquisa
	 * @return o codigo da atividade, caso ela tenha sido criada e adicionada ao estudante com sucesso;
	 * "Estudante não cadastrado" caso o estudante não exista no sistema;
	 * "Senha incorreta" caso a senha fornecida não seja igual a senha do estudante.
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumento sejam strings vazias ou a senha fornecida não possua 8 digitos.
	 */
	public String criarAtividadePesquisaExtensaoEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		if(cpf == null || tipo == null || disciplina == null) {
			throw new NullPointerException("Argumento Nulo");
		}
		
		if(cpf.trim().equals("") || tipo.trim().equals("")|| disciplina.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(unidadeAcumulada < 0) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(senha > 99999999 || senha < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(userFaqControll.getEstudante(cpf) == null) {
			return "Estudante não cadastrado";
		}
		
		if(!(userFaqControll.getEstudante(cpf).getSenha() == senha)) {
			return "Senha incorreta";
		}
		
		Estudante aluno = userFaqControll.getEstudante(cpf);
		String codigo = cpf + "_" + (aluno.getTamanhoListaAtividade() + 1);
		
		AtividadeComplementarAbstract pesquisa = new AtividadePesquisaExtensao(codigo,tipo,unidadeAcumulada,disciplina);
		aluno.adicionaAtividade(codigo, pesquisa);
		return codigo;
	}
	
	/**
	 * Método que cria uma atividade de estagio e a adiciona ao estudante.
	 * @param cpf - CPF do estudante
	 * @param senha - Senha do estudante
	 * @param tipo - Tipo da atividade, no caso estagio
	 * @param unidadeAcumulada - Quantidade de horas realizadas no estagio
	 * @param disciplina - Disciplina do estagio
	 * @return o codigo da atividade, caso ela tenha sido criada e adicionada ao estudante com sucesso;
	 * "Estudante não cadastrado" caso o estudante não exista no sistema;
	 * "Senha incorreta" caso a senha fornecida não seja igual a senha do estudante.
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumento sejam strings vazias ou a senha fornecida não possua 8 digitos.
	 */
	public String criarAtividadeEstagioEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		if(cpf == null || tipo == null || disciplina == null) {
			throw new NullPointerException("Argumento Nulo");
		}
		
		if(cpf.trim().equals("") || tipo.trim().equals("")|| disciplina.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(unidadeAcumulada < 0) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(senha > 99999999 || senha < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(userFaqControll.getEstudante(cpf) == null) {
			return "Estudante não cadastrado";
		}
		
		if(!(userFaqControll.getEstudante(cpf).getSenha() == senha)) {
			return "Senha incorreta";
		}
		
		Estudante aluno = userFaqControll.getEstudante(cpf);
		String codigo = cpf + "_" + (aluno.getTamanhoListaAtividade() + 1);
		
		AtividadeComplementarAbstract estagio = new AtividadeEstagio(codigo,tipo,unidadeAcumulada,disciplina);
		aluno.adicionaAtividade(codigo, estagio);
		return codigo;
	}
	
	/**
	 * Método que cria uma atividade de publicação e a adiciona ao estudante
	 * @param cpf - CPF do estudante
	 * @param senha - Senha do estudante
	 * @param tipo - tipo da atividade, no caso conferência ou periódico
	 * @param tituloArtigo - Titulo do artigo
	 * @param doi - Identificador digital do objeto (artigo)
	 * @param qualis - Classificação do artigo 
	 * @return o codigo da atividade, caso ela tenha sido criada e adicionada ao estudante com sucesso;
	 * "Estudante não cadastrado" caso o estudante não exista no sistema;
	 * "Senha incorreta" caso a senha fornecida não seja igual a senha do estudante.
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumento sejam strings vazias ou a senha fornecida não possua 8 digitos.
	 */
	public String criarAtividadePublicacaoEmEstudante(String cpf, int senha, String tipo, String tituloArtigo, String doi, String qualis) {
		if(cpf == null || tipo == null || tituloArtigo == null || doi == null || qualis == null) {
			throw new NullPointerException("Argumento Nulo");
		}
		
		if(cpf.trim().equals("") || tipo.trim().equals("")|| tituloArtigo.trim().equals("") || doi.trim().equals("") || qualis.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(senha > 99999999 || senha < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(userFaqControll.getEstudante(cpf) == null) {
			return "Estudante não cadastrado";
		}
		
		if(!(userFaqControll.getEstudante(cpf).getSenha() == senha)) {
			return "Senha incorreta";
		}
		
		Estudante aluno = userFaqControll.getEstudante(cpf);
		String codigo = cpf + "_" + (aluno.getTamanhoListaAtividade() + 1);
		
		AtividadeComplementarAbstract publicacao = new AtividadePublicacao(codigo,tipo,tituloArtigo,doi,qualis);
		aluno.adicionaAtividade(codigo, publicacao);
		return codigo;
	}
	
	/**
	 * Método responsável por mostrar a quantidade de creditos adquiridos pela realização da atividade complementar
	 * @param cpf - CPF do estudante
	 * @param senha - Senha do estudante
	 * @param codigoAtividade - Codigo que representa a atividade
	 * @return a quantidade de creditos gerados pela atividade, ou -1, caso o estudante não exista no sistema ou caso a senha fornecida
	 * nao seja igual a do estudante ou caso a atividade não exista
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumento sejam strings vazias ou a senha fornecida não possua 8 digitos.
	 */
	public double creditosAtividade(String cpf, int senha, String codigoAtividade) {
		if(cpf == null || codigoAtividade == null) {
			throw new NullPointerException("Argumento Nulo");
		}
		
		if(cpf.trim().equals("") || codigoAtividade.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(senha > 99999999 || senha < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(userFaqControll.getEstudante(cpf) == null) {
			return -1;
		}
		
		if(!(userFaqControll.getEstudante(cpf).getSenha() == senha)) {
			return -1;
		}
		
		if(userFaqControll.getEstudante(cpf).getAtividade(codigoAtividade) == null) {
			return -1;
		}
		
		Estudante aluno = userFaqControll.getEstudante(cpf);
		return aluno.getAtividade(codigoAtividade).calculaCreditos();
	}
	
	/**
	 * Método responsável por criar um relatorio completo das atividades complementares do estudante 
	 * @param cpf - CPF do estudante
	 * @param senha - Senha do estudante
	 * @return o indíce do relatorio na lista dos relatorios do estudante, ou -1, caso o estudante não exista no sistema ou caso a senha fornecida
	 * nao seja igual a do estudante
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumento sejam strings vazias ou a senha fornecida não possua 8 digitos.
	 */
	public int criarRelatorioCompleto(String cpf, String senha) {
		if(cpf == null || senha == null) {
			throw new NullPointerException("Argumento Nulo");
		}
		
		if(cpf.trim().equals("") || senha.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		int senhaConvertida = Integer.parseInt(senha);
		
		if(senhaConvertida > 99999999 || senhaConvertida < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(userFaqControll.getEstudante(cpf) == null) {
			return -1;
		}
		
		if(!(userFaqControll.getEstudante(cpf).getSenha() == senhaConvertida)) {
			return -1;
		}
		
		
		String nomeEstudante = userFaqControll.getEstudante(cpf).getNome();
		String matriculaEstudante = userFaqControll.getEstudante(cpf).getMatricula();
		HashMap<String,AtividadeComplementarAbstract> atividades = userFaqControll.getEstudante(cpf).getListaAtividades();
		
		Relatorio novoRelatorio = new RelatorioCompleto(nomeEstudante,cpf, matriculaEstudante, atividades);
		userFaqControll.getEstudante(cpf).adicionaRelatorio(novoRelatorio);
		
		this.geradorIndexRelatorio++;
		return this.geradorIndexRelatorio - 1;
	}
	
	/**
	 * Método responsável por criar um relatorio resumido das atividades complementares do estudante 
	 * @param cpf - CPF do estudante
	 * @param senha - Senha do estudante
	 * @return o indíce do relatorio na lista dos relatorios do estudante, ou -1, caso o estudante não exista no sistema ou caso a senha fornecida
	 * nao seja igual a do estudante
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumento sejam strings vazias ou a senha fornecida não possua 8 digitos.
	 */
	public int criarRelatorioResumido(String cpf, String senha) {
		if(cpf == null || senha == null) {
			throw new NullPointerException("Argumento Nulo");
		}
		
		if(cpf.trim().equals("") || senha.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		int senhaConvertida = Integer.parseInt(senha);
		
		if(senhaConvertida > 99999999 || senhaConvertida < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(userFaqControll.getEstudante(cpf) == null) {
			return -1;
		}
		
		if(!(userFaqControll.getEstudante(cpf).getSenha() == senhaConvertida)) {
			return -1;
		}
		
		
		String nomeEstudante = userFaqControll.getEstudante(cpf).getNome();
		String matriculaEstudante = userFaqControll.getEstudante(cpf).getMatricula();
		HashMap<String,AtividadeComplementarAbstract> atividades = userFaqControll.getEstudante(cpf).getListaAtividades();
		
		Relatorio novoRelatorio = new RelatorioResumido(nomeEstudante,cpf, matriculaEstudante, atividades);
		userFaqControll.getEstudante(cpf).adicionaRelatorio(novoRelatorio);
		
		this.geradorIndexRelatorio++;
		return this.geradorIndexRelatorio - 1;
	}
	
	/**
	 * Método responsável por criar um relatorio resumido de um tipo das atividades complementares do estudante 
	 * @param cpf - CPF do estudante
	 * @param senha - Senha do estudante
	 * @param tipoAtividade - O tipo da atividade que será resumida
	 * @return o indíce do relatorio na lista dos relatorios do estudante, ou -1, caso o estudante não exista no sistema ou caso a senha fornecida
	 * nao seja igual a do estudante
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumento sejam strings vazias ou a senha fornecida não possua 8 digitos.
	 */
	public int criarRelatorioResumidoPorATV(String cpf, String senha, String tipoAtividade) {
		if(cpf == null || senha == null) {
			throw new NullPointerException("Argumento Nulo");
		}
		
		if(cpf.trim().equals("") || senha.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		int senhaConvertida = Integer.parseInt(senha);
		
		if(senhaConvertida > 99999999 || senhaConvertida < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(userFaqControll.getEstudante(cpf) == null) {
			return -1;
		}
		
		if(!(userFaqControll.getEstudante(cpf).getSenha() == senhaConvertida)) {
			return -1;
		}
		
		
		String nomeEstudante = userFaqControll.getEstudante(cpf).getNome();
		String matriculaEstudante = userFaqControll.getEstudante(cpf).getMatricula();
		HashMap<String,AtividadeComplementarAbstract> atividades = userFaqControll.getEstudante(cpf).getListaAtividades();
		
		Relatorio novoRelatorio = new RelatorioResumidoAtvd(nomeEstudante,cpf, matriculaEstudante, atividades, tipoAtividade);
		userFaqControll.getEstudante(cpf).adicionaRelatorio(novoRelatorio);
		
		this.geradorIndexRelatorio++;
		return this.geradorIndexRelatorio - 1;
	}
	
	/**
	 * Método responsável por exibir um relatorio especifico do estudante
	 * @param cpf - CPF do estudante
	 * @param senha - Senha do estudante
	 * @param indexRelatorio - Indíce do relatorio na lista dos relatorios do estudante
	 * @return o relatorio da atividade, ou uma string vazia, caso o estudante não exista no sistema ou caso a senha fornecida
	 * nao seja igual a do estudante.
	 * @throws NullPointerException, caso os argumentos fornecidos no metodo sejam nulos;
	 * IllegalArgumentException, caso os argumento sejam strings vazias ou a senha fornecida não possua 8 digitos.
	 */
	public String exibirRelatorio(String cpf, String senha, int indexRelatorio) {
		if(cpf == null || senha == null) {
			throw new NullPointerException("Argumento Nulo");
		}
		
		if(cpf.trim().equals("") || senha.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		int senhaConvertida = Integer.parseInt(senha);
		
		if(senhaConvertida > 99999999 || senhaConvertida < 10000000) { 
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(userFaqControll.getEstudante(cpf) == null) {
			return "";
		}
		
		if(!(userFaqControll.getEstudante(cpf).getSenha() == senhaConvertida)) {
			return "";
		}

		return userFaqControll.getEstudante(cpf).getRelatorio(indexRelatorio).relatorioFormatado();
	}
}
