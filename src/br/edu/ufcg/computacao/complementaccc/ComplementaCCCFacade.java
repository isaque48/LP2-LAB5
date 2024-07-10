package br.edu.ufcg.computacao.complementaccc;

public class ComplementaCCCFacade {
	UsuarioFaqController ufc;
	AtividadeComplementarController acc;
	
	public ComplementaCCCFacade() {
		this.ufc = new UsuarioFaqController();
		this.acc = new AtividadeComplementarController(this.ufc);
	}
	
	public boolean criarEstudante(String nome, String cpf, int senha, String matricula) {
		return ufc.criarEstudante(nome,cpf,senha,matricula);
	}
	public String[] exibirEstudantes(String cpf, int senha){
		//ADMIN
		return ufc.exibirEstudantes(cpf, senha);
	}
	public boolean alterarEstudante(String cpf, int senha, String tipoAlteracao, String novoValor) {
		return ufc.alterarEstudante(cpf, senha, tipoAlteracao, novoValor);
	}
	public String exibirAdmin(String cpf, int senha){
		return ufc.exibirAdmin(cpf, senha);
		//ADMIN
	}
	public boolean configurarNovoADMIN(String cpf, int senhaAtual, String nomeNovo, String cpfNovo, int senhaNova){
		return ufc.configurarNovoADMIN(cpf, senhaAtual, nomeNovo, cpfNovo, senhaNova);
		//ADMIN
	}
	public boolean configurarSenhaADMIN(String cpf, int senhaAtual, int senhaNova){
		return ufc.configurarSenhaADMIN(cpf, senhaAtual, senhaNova);
		//ADMIN
	}
	
	public boolean adicionarItemFAQ(String cpf, int senha, String pergunta) {
		return ufc.adicionarItemFAQ(cpf, senha, pergunta);
		//ADMIN
	}
	public boolean adicionarItemFAQ(String cpf, int senha, String pergunta, String resposta) {
		return ufc.adicionarItemFAQ(cpf, senha, pergunta, resposta);
		//ADMIN
	}
	public boolean alteraRespostaItem(String cpf, int senha, int itemIndex, String resposta) {
		return ufc.alteraRespostaItem(cpf, senha, itemIndex, resposta);
		//ADMIN
	}
	public String[] listarFAQ() {
		return ufc.listarFAQ();
	}
	public String[] listarFAQPorDestaque() {
		return ufc.listarFAQPorDestaque();
	}
	public boolean destacarItem(int itemIndex) {
		return ufc.destacarItem(itemIndex);
	}
	public boolean atribuirTagsItemFAQ(String cpf, int senha,int itemIndex, String[] tags) {
		return ufc.atribuirTagsItemFAQ(cpf, senha, itemIndex, tags);
		//ADMIN
	}
	public String[] buscarItemFAQ(String[] tags) {
		return ufc.buscarItemFAQ(tags);
	}
	
	public String criarAtividadeMonitoriaEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		return acc.criarAtividadeMonitoriaEmEstudante(cpf, senha, tipo, unidadeAcumulada, disciplina);
	}
	public boolean alterarDescricaoAtividade(String cpf, int senha, String codigoAtividade, String descricao) {
		return acc.alterarDescricaoAtividade(cpf, senha, codigoAtividade, descricao);
	}
	public boolean alterarComprovacaoAtividade(String cpf, int senha, String codigoAtividade, String linkComprovacao) {
		return acc.alterarComprovacaoAtividade(cpf, senha, codigoAtividade, linkComprovacao);
	}
	public String criarAtividadePesquisaExtensaoEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		return acc.criarAtividadePesquisaExtensaoEmEstudante(cpf, senha, tipo, unidadeAcumulada, disciplina);
	}
	public String criarAtividadeEstagioEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		return acc.criarAtividadeEstagioEmEstudante(cpf, senha, tipo, unidadeAcumulada, disciplina);
	}
	public String criarAtividadePublicacaoEmEstudante(String cpf, int senha, String tipo, String tituloArtigo, String doi, String qualis) {
		return acc.criarAtividadePublicacaoEmEstudante(cpf, senha, tipo, tituloArtigo, doi, qualis);
	}
	public double creditosAtividade(String cpf, int senha, String codigoAtividade) {
		return acc.creditosAtividade(cpf, senha, codigoAtividade);
	}
	public int criarRelatorioCompleto(String cpf, String senha) {
		return acc.criarRelatorioCompleto(cpf, senha);
	}
	public int criarRelatorioResumido(String cpf, String senha) {
		return acc.criarRelatorioResumido(cpf, senha);
	}
	public int criarRelatorioPorATV(String cpf, String senha, String tipoAtividade) {
		return acc.criarRelatorioResumidoPorATV(cpf, senha, tipoAtividade);
	}
	public String exibirRelatorio(String cpf, String senha, int indexRelatorio) {
		return acc.exibirRelatorio(cpf, senha, indexRelatorio);
	}

}
