package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsarioFaqControllerTeste {

	UsuarioFaqController ufc;
	
	@BeforeEach
	void criaController() {
		this.ufc = new UsuarioFaqController();
	}
	
	@Test
	void criarEstudanteValidoTeste() {
		assertTrue(ufc.criarEstudante("Isaque", "000.000.000-00", 12345678, "123110000"));
	}
	
	@Test
	void criarEstudanteCPFRepetidoTeste() {
		ufc.criarEstudante("Duda", "000.000.000-00", 12345678, "123110111");
		assertFalse(ufc.criarEstudante("Isaque", "000.000.000-00", 12345678, "123110000"));
	}
	
	@Test
	void criarEstudanteArgumentosNulosTeste() {
		try{
			ufc.criarEstudante(null, null, 12345678 , null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo!", erro.getMessage());
		}
	}
	
	@Test
	void criarEstudanteArgumentosVaziosTeste() {
		try{
			ufc.criarEstudante("", "", 12345678 , "");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void criarEstudanteSenhaInválidaTeste() {
		try{
			ufc.criarEstudante("Isaque", "000.000.000-00", 1234567, "123110000");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void criarEstudanteSenhaInválida2Teste() {
		try{
			ufc.criarEstudante("Isaque", "000.000.000-00", 123456789, "123110000");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void exibirEstudantesValidoTeste() {
		ufc.criarEstudante("Isaque", "000.000.000-00", 12345678, "123110000");
		ufc.criarEstudante("Duda", "000.000.000-01", 12345678, "123110111");
		
		assertEquals("Estudante: Duda, CPF: 000.000.000-01, Matrícula: 123110111.", ufc.exibirEstudantes("00000000000", 12345678)[0]);
		assertEquals("Estudante: Isaque, CPF: 000.000.000-00, Matrícula: 123110000.", ufc.exibirEstudantes("00000000000", 12345678)[1]);
	}
	
	@Test
	void exibirEstudanteCpfAdminErradoTeste() {
		ufc.criarEstudante("Isaque", "000.000.000-00", 12345678, "123110000");
		ufc.criarEstudante("Duda", "000.000.000-01", 12345678, "123110111");
		
		assertEquals(1, ufc.exibirEstudantes("11111111111", 12345678).length);
		assertEquals(null, ufc.exibirEstudantes("11111111111", 12345678)[0]);
	}
	
	@Test
	void exibirEstudanteSenhaAdminErradoTeste() {
		ufc.criarEstudante("Isaque", "000.000.000-00", 12345678, "123110000");
		ufc.criarEstudante("Duda", "000.000.000-01", 12345678, "123110111");
		
		assertEquals(1, ufc.exibirEstudantes("00000000000", 12345679).length);
		assertEquals(null, ufc.exibirEstudantes("00000000000", 12345679)[0]);
	}
	
	@Test
	void exibirEstudanteCPFAdminVazioTeste() {
		try{
			ufc.exibirEstudantes("", 12345678);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void exibirEstudanteSenhaAdminInvalidaTeste() {
		try{
			ufc.exibirEstudantes("00000000000", 1234567);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void exibirEstudanteSenhaAdminInvalidaTeste2() {
		try{
			ufc.exibirEstudantes("00000000000", 123456789);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void exibirEstudanteCPFAdminNuloTeste() {
		try{
			ufc.exibirEstudantes(null, 12345678);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo!", erro.getMessage());
		}
	}
	
	@Test
	void alterarEstudanteNomeTeste() {
		ufc.criarEstudante("Isaque", "000.000.000-00", 12345678, "123110000");
		assertTrue(ufc.alterarEstudante("000.000.000-00", 12345678, "nome", "Esdras"));
	}
	
	@Test
	void alterarEstudanteMatriculaTeste() {
		ufc.criarEstudante("Isaque", "000.000.000-00", 12345678, "123110000");
		assertTrue(ufc.alterarEstudante("000.000.000-00", 12345678, "matrícula", "123110011"));
	}
	
	@Test
	void alterarEstudanteSenhaTeste() {
		ufc.criarEstudante("Isaque", "000.000.000-00", 12345678, "123110000");
		assertTrue(ufc.alterarEstudante("000.000.000-00", 12345678, "senha", "12345688"));
	}
	
	@Test
	void alterarEstudanteCPFInvalidoTeste() {
		ufc.criarEstudante("Isaque", "000.000.000-00", 12345678, "123110000");
		assertFalse(ufc.alterarEstudante("000.000.000-11", 12345678, "senha", "12345688"));
	}
	
	@Test
	void alterarEstudanteSenhaAtalInvalidoTeste() {
		ufc.criarEstudante("Isaque", "000.000.000-00", 12345678, "123110000");
		assertFalse(ufc.alterarEstudante("000.000.000-00", 12345688, "senha", "12345688"));
	}
	
	@Test
	void alterarEstudanteTipoAlteracaoInvalidoTeste() {
		ufc.criarEstudante("Isaque", "000.000.000-00", 12345678, "123110000");
		assertFalse(ufc.alterarEstudante("000.000.000-00", 12345678, "cpf", "000.000.000-11"));
	}
	
	@Test
	void alterarEstudanteArgumentosVaziosTeste() {
		ufc.criarEstudante("Isaque", "000.000.000-00", 12345678, "123110000");
		try{
			ufc.alterarEstudante("", 12345678, "", "");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void alterarEstudanteArgumentosNulosTeste() {
		ufc.criarEstudante("Isaque", "000.000.000-00", 12345678, "123110000");
		try{
			ufc.alterarEstudante(null, 12345678, null, null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo!", erro.getMessage());
		}
	}
	
	@Test
	void alterarEstudanteSenhaInvalidaTeste() {
		ufc.criarEstudante("Isaque", "000.000.000-00", 12345678, "123110000");
		try{
			ufc.alterarEstudante("", 123456789, "", "");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void alterarEstudanteSenhaInvalidaTeste2() {
		ufc.criarEstudante("Isaque", "000.000.000-00", 12345678, "123110000");
		try{
			ufc.alterarEstudante("", 1234567, "", "");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void exibirAdminValidoTeste() {
		assertEquals("Administrador: Admin, CPF: 00000000000.", ufc.exibirAdmin("00000000000", 12345678));
	}
	
	@Test
	void exibirAdminCpfErradoTeste() {
		assertEquals("", ufc.exibirAdmin("00000000011", 12345678));
	}
	
	@Test
	void exibirAdminSenhaErradaTeste() {
		assertEquals("", ufc.exibirAdmin("00000000000", 12345688));
	}
	
	@Test
	void exibirAdminCPFVazioTeste() {
		try{
			ufc.exibirAdmin("", 12345688);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void exibirAdminSenhaInvalidaTeste() {
		try{
			ufc.exibirAdmin("00000000000", 1234567);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void exibirAdminSenhaInvalidaTeste2() {
		try{
			ufc.exibirAdmin("00000000000", 123456789);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void exibirAdminCPFNuloTeste() {
		try{
			ufc.exibirAdmin(null, 12345688);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo!", erro.getMessage());
		}
	}
	
	@Test
	void configurarNovoADMINValidoTeste() {
		assertTrue(ufc.configurarNovoADMIN("00000000000", 12345678, "Isaque", "000.000.000-00", 12345678));
	}
	
	@Test
	void configurarNovoADMINCpfAtualIncorretoTeste() {
		assertFalse(ufc.configurarNovoADMIN("00000000001", 12345678, "Isaque", "000.000.000-00", 12345678));
	}
	
	@Test
	void configurarNovoADMINSenhaAtualIncorretoTeste() {
		assertFalse(ufc.configurarNovoADMIN("00000000000", 12345688, "Isaque", "000.000.000-00", 12345678));
	}
	
	@Test
	void configurarNovoADMINArgumentosNuloTeste() {
		try{
			ufc.configurarNovoADMIN(null, 12345678, null, null, 12345678);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo!", erro.getMessage());
		}
	}
	
	@Test
	void configurarNovoADMINArgumentosVaziosTeste() {
		try{
			ufc.configurarNovoADMIN("", 12345678, "", "", 12345678);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void configurarNovoADMINSenhaAtualInvalidaTeste1() {
		try{
			ufc.configurarNovoADMIN("00000000000", 1234567, "Isaque", "000.000.000-00", 12345678);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void configurarNovoADMINSenhaAtualInvalidaTeste2() {
		try{
			ufc.configurarNovoADMIN("00000000000", 123456789, "Isaque", "000.000.000-00", 12345678);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void configurarNovoADMINSenhaNovaInvalidaTeste1() {
		try{
			ufc.configurarNovoADMIN("00000000000", 12345678, "Isaque", "000.000.000-00", 1234567);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void configurarNovoADMINSenhaNovaInvalidaTeste2() {
		try{
			ufc.configurarNovoADMIN("00000000000", 12345678, "Isaque", "000.000.000-00", 123456789);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void configurarSenhaADMINValidoTeste() {
		assertTrue(ufc.configurarSenhaADMIN("00000000000", 12345678, 12345688));
	}
	
	@Test
	void configurarSenhaADMINCPFErradoTeste() {
		assertFalse(ufc.configurarSenhaADMIN("00000000001", 12345678, 12345688));
	}
	
	@Test
	void configurarSenhaADMINSenhaAtualErradaTeste() {
		assertFalse(ufc.configurarSenhaADMIN("00000000001", 12345677, 12345688));
	}
	
	@Test
	void configurarSenhaADMINSenhaAtualInvalidaTeste1() {
		try{
			ufc.configurarSenhaADMIN("00000000000", 1234567, 12345688);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void configurarSenhaADMINSenhaAtualInvalidaTeste2() {
		try{
			ufc.configurarSenhaADMIN("00000000000", 123456789, 12345688);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void configurarSenhaADMINSenhaNovaInvalidaTeste1() {
		try{
			ufc.configurarSenhaADMIN("00000000000", 12345678, 1234567);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void configurarSenhaADMINSenhaNovaInvalidaTeste2() {
		try{
			ufc.configurarSenhaADMIN("00000000000", 12345678, 123456789);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void configurarSenhaADMINCPFVazioTeste() {
		try{
			ufc.configurarSenhaADMIN("", 12345678, 12345678);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void configurarSenhaADMINCPFNuloTeste() {
		try{
			ufc.configurarSenhaADMIN(null, 12345678, 12345678);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo!", erro.getMessage());
		}
	}
	
	@Test
	void adicionaItemFAQValidoTeste() {
		assertTrue(ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste"));
	}
	
	@Test
	void adicionaItemFAQPerguntaRepetidaTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste");
		assertFalse(ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste"));
	}
	
	@Test
	void adicionaItemFAQCPFAdminErradoTeste() {
		assertFalse(ufc.adicionarItemFAQ("00000000001", 12345678, "Pergunta Teste"));
	}
	
	@Test
	void adicionaItemFAQSenhaAdminErradoTeste() {
		assertFalse(ufc.adicionarItemFAQ("00000000000", 12345688, "Pergunta Teste"));
	}
	
	@Test
	void adicionaItemFAQArgumentosNulosTeste() {
		try{
			ufc.adicionarItemFAQ(null, 12345678, null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo!", erro.getMessage());
		}
	}
	
	@Test
	void adicionaItemFAQArgumentosInvalidosTeste() {
		try{
			ufc.adicionarItemFAQ("", 12345678, "");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void adicionaItemFAQSenhaInvalidaTeste() {
		try{
			ufc.adicionarItemFAQ("00000000000", 1234567, "Pergunta Teste");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void adicionaItemFAQRespostaValidoTeste() {
		assertTrue(ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste","Resposta Teste"));
	}
	
	@Test
	void adicionaItemFAQRespostaComPerguntaRepetidaTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste","Resposta Teste");
		assertFalse(ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste","Resposta Teste"));
	}
	
	@Test
	void adicionaItemFAQRespostaCPFAdminErradoTeste() {
		assertFalse(ufc.adicionarItemFAQ("00000000001", 12345678, "Pergunta Teste","Resposta Teste"));
	}
	
	@Test
	void adicionaItemFAQRespostaSenhaAdminErradoTeste() {
		assertFalse(ufc.adicionarItemFAQ("00000000000", 12345677, "Pergunta Teste","Resposta Teste"));
	}
	
	@Test
	void adicionaItemFAQRespostaSenhaAdminInvalidaTeste() {
		try{
			ufc.adicionarItemFAQ("00000000000", 1234567, "Pergunta Teste","Resposta Teste");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void adicionaItemFAQRespostaArgumentosVaziosTeste() {
		try{
			ufc.adicionarItemFAQ("", 1234567, "","");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void adicionaItemFAQRespostaArgumentosNulosTeste() {
		try{
			ufc.adicionarItemFAQ(null, 1234567, null,null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo!", erro.getMessage());
		}
	}
	
	@Test
	void alterarRespostaItemValidoTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste");
		assertTrue(ufc.alteraRespostaItem("00000000000", 12345678, 0, "Resposta Teste"));
	}
	
	@Test
	void alterarRespostaItemIndexErradoTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste");
		assertFalse(ufc.alteraRespostaItem("00000000000", 12345678, 1, "Resposta Teste"));
	}
	
	@Test
	void alterarRespostaItemCPFAdminErradoTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste");
		assertFalse(ufc.alteraRespostaItem("00000000001", 12345678, 0, "Resposta Teste"));
	}
	
	@Test
	void alterarRespostaItemSenhaAdminErradoTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste");
		assertFalse(ufc.alteraRespostaItem("00000000000", 12345688, 0, "Resposta Teste"));
	}
	
	@Test
	void alterarRespostaItemArgumentosNulosTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste");
		try{
			ufc.alteraRespostaItem(null, 12345688, 0, null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo!", erro.getMessage());
		}
	}
	
	@Test
	void alterarRespostaItemArgumentosVaziosTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste");
		try{
			ufc.alteraRespostaItem("", 12345688, 0, "");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void alterarRespostaItemSenhaInvalidaTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste");
		try{
			ufc.alteraRespostaItem("00000000000", 1234567, 0, "Resposta Teste");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void listarFaqTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste");
		assertEquals("Pergunta: Pergunta Teste; Resposta: *Resposta não cadastrada*",ufc.listarFAQ()[0]);
	}
	
	@Test
	void listarFaqComRespostaTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste","Resposta Teste");
		assertEquals("Pergunta: Pergunta Teste; Resposta: Resposta Teste",ufc.listarFAQ()[0]);
	}
	
	@Test
	void destacarItemFaqTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste","Resposta Teste");
		assertTrue(ufc.destacarItem(0));
	}
	
	@Test
	void destacarItemFaqIndexErradoTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste","Resposta Teste");
		assertFalse(ufc.destacarItem(1));
	}
	
	@Test
	void listarFaqPorDestaqueTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste","Resposta Teste");
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste2","Resposta Teste2");
		
		ufc.destacarItem(1);
		ufc.destacarItem(1);
		
		assertEquals("Pergunta: Pergunta Teste2; Resposta: Resposta Teste2",ufc.listarFAQPorDestaque()[0]);
		assertEquals("Pergunta: Pergunta Teste; Resposta: Resposta Teste",ufc.listarFAQPorDestaque()[1]);
	}
	
	
	@Test
	void adicionaTagTeste1() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste");
		String[] tags = {"teste1"};
		assertTrue(ufc.atribuirTagsItemFAQ("00000000000", 12345678, 0, tags));
	}
	
	@Test
	void adicionaTagTeste2() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste");
		String[] tags = {"teste1","teste2"};
		assertTrue(ufc.atribuirTagsItemFAQ("00000000000", 12345678, 0, tags));
	}
	
	@Test
	void adicionaTagTeste3() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste");
		String[] tags = {"teste1","teste2","teste3"};
		assertTrue(ufc.atribuirTagsItemFAQ("00000000000", 12345678, 0, tags));
	}
	
	@Test
	void adicionaTagTamanhoListaInvalidaTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste");
		String[] tags = {"teste1","teste2","teste3","teste4"};
		assertFalse(ufc.atribuirTagsItemFAQ("00000000000", 12345678, 0, tags));
	}
	
	@Test
	void adicionaTagCPFAdminErradoTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste");
		String[] tags = {"teste1","teste2","teste3","teste4"};
		assertFalse(ufc.atribuirTagsItemFAQ("00000000001", 12345678, 0, tags));
	}
	
	@Test
	void adicionaTagSenhaAdminErradoTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste");
		String[] tags = {"teste1","teste2","teste3","teste4"};
		assertFalse(ufc.atribuirTagsItemFAQ("00000000000", 12345677, 0, tags));
	}
	
	@Test
	void adicionaTagSenhaInvalidaTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste");
		String[] tags = {"teste1","teste2","teste3"};
		
		try{
			ufc.atribuirTagsItemFAQ("00000000000", 1234567, 0, tags);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void adicionaTagArgumentosVaziosTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste");
		String[] tags = {"","",""};
		
		try{
			ufc.atribuirTagsItemFAQ("", 1234567, 0, tags);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void adicionaTagArgumentosNulosTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste");
		String[] tags = {null,null,null};
		
		try{
			ufc.atribuirTagsItemFAQ(null, 1234567, 0, tags);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo!", erro.getMessage());
		}
	}
	
	@Test
	void buscarItemFAQTeste() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste", "Resposta Teste");
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste2", "Resposta Teste2");
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste3", "Resposta Teste3");
		String[] tags = {"teste1","teste2","teste3"};
		String[] tags2 = {"teste2"};
		String[] tags3 = {"teste3"};
		
		ufc.atribuirTagsItemFAQ("00000000000", 12345678, 0, tags);
		ufc.atribuirTagsItemFAQ("00000000000", 12345678, 1, tags2);
		ufc.atribuirTagsItemFAQ("00000000000", 12345678, 2, tags3);
		
		String[] tagBuscada = {"teste2"};
		assertEquals("Pergunta: Pergunta Teste; Resposta: Resposta Teste",ufc.buscarItemFAQ(tagBuscada)[0]);
		assertEquals("Pergunta: Pergunta Teste2; Resposta: Resposta Teste2",ufc.buscarItemFAQ(tagBuscada)[1]);
	}
	
	@Test
	void buscarItemFAQTeste2() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste", "Resposta Teste");
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste2", "Resposta Teste2");
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste3", "Resposta Teste3");
		String[] tags = {"teste1","teste2","teste3"};
		String[] tags2 = {"teste2"};
		String[] tags3 = {"teste3"};
		
		ufc.atribuirTagsItemFAQ("00000000000", 12345678, 0, tags);
		ufc.atribuirTagsItemFAQ("00000000000", 12345678, 1, tags2);
		ufc.atribuirTagsItemFAQ("00000000000", 12345678, 2, tags3);
		
		String[] tagBuscada = {"teste2","teste4","teste5","teste6"};
		assertEquals("Pergunta: Pergunta Teste; Resposta: Resposta Teste",ufc.buscarItemFAQ(tagBuscada)[0]);
		assertEquals("Pergunta: Pergunta Teste2; Resposta: Resposta Teste2",ufc.buscarItemFAQ(tagBuscada)[1]);
	}
	
	@Test
	void buscarItemFAQTeste3() {
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste", "Resposta Teste");
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste2", "Resposta Teste2");
		ufc.adicionarItemFAQ("00000000000", 12345678, "Pergunta Teste3", "Resposta Teste3");
		String[] tags = {"teste1","teste2","teste3"};
		String[] tags2 = {"teste2"};
		String[] tags3 = {"teste3"};
		
		ufc.atribuirTagsItemFAQ("00000000000", 12345678, 0, tags);
		ufc.atribuirTagsItemFAQ("00000000000", 12345678, 1, tags2);
		ufc.atribuirTagsItemFAQ("00000000000", 12345678, 2, tags3);
		
		String[] tagBuscada = {"teste4","teste6"};
		assertEquals(0,ufc.buscarItemFAQ(tagBuscada).length);
	}

}
