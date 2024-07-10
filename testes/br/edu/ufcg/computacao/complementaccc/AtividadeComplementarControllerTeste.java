package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AtividadeComplementarControllerTeste {
	UsuarioFaqController ufc;
	AtividadeComplementarController acc;
	
	@BeforeEach
	void criaController() {
		this.ufc = new UsuarioFaqController();
		this.acc = new AtividadeComplementarController(this.ufc);
		ufc.criarEstudante("Isaque", "000.000.000-00", 12345678, "123110111");
	}
		
	@Test
	void criaAtividadeMonitoriaEmEstudanteValidoTeste() {
		assertEquals("000.000.000-00_1", acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "Monitoria", 2, "LP2"));
	}
	
	@Test
	void criaAtividadeMonitoriaEmEstudanteEstudanteNaoExistenteTeste() {
		assertEquals("Estudante não cadastrado", acc.criarAtividadeMonitoriaEmEstudante("000.000.000-01", 12345678, "Monitoria", 2, "LP2"));
	}
	
	@Test
	void criaAtividadeMonitoriaEmEstudanteSenhaEstudanteErradaTeste() {
		assertEquals("Senha incorreta", acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345688, "Monitoria", 2, "LP2"));
	}
	
	@Test
	void criaAtividadeMonitoriaEmEstudanteArgumentosNulosTeste() {
		try{
			acc.criarAtividadeMonitoriaEmEstudante(null, 12345688, null, 2, null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}
	
	@Test
	void criaAtividadeMonitoriaEmEstudanteArgumentosVaziosTeste() {
		try{
			acc.criarAtividadeMonitoriaEmEstudante("", 12345688, "", 2, "");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void criaAtividadeMonitoriaEmEstudanteSenhaInvalidaTeste() {
		try{
			acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 1234567, "Monitoria", 2, "LP2");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void criaAtividadeMonitoriaEmEstudanteUnidadeAcumuladaInvalidaTeste() {
		try{
			acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "Monitoria", -1, "LP2");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void alteraDescricaoAtividadeValidoTeste() {
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "Monitoria", 2, "LP2");
		assertTrue(acc.alterarDescricaoAtividade("000.000.000-00", 12345678, "000.000.000-00_1", "Descrição Monitoria"));
	}
	
	@Test
	void alteraDescricaoAtividadeEstudanteNaoExistenteTeste() {
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "Monitoria", 2, "LP2");
		assertFalse(acc.alterarDescricaoAtividade("000.000.000-01", 12345678, "000.000.000-00_1", "Descrição Monitoria"));
	}
	
	@Test
	void alteraDescricaoAtividadeSenhaEstudanteIncorretaTeste() {
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "Monitoria", 2, "LP2");
		assertFalse(acc.alterarDescricaoAtividade("000.000.000-00", 12345688, "000.000.000-00_1", "Descrição Monitoria"));
	}
	
	@Test
	void alteraDescricaoAtividadeComAtividadeNaoExistenteTeste() {
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "Monitoria", 2, "LP2");
		assertFalse(acc.alterarDescricaoAtividade("000.000.000-00", 12345678, "000.000.000-00_2", "Descrição Monitoria"));
	}
	
	@Test
	void alteraDescricaoAtividadeArgumentosNulosTeste() {
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "Monitoria", 2, "LP2");
		
		try {
			acc.alterarDescricaoAtividade(null, 12345678, null, null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo", erro.getMessage());
		}
	}
	
	@Test
	void alteraDescricaoAtividadeArgumentosVaziosTeste() {
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "Monitoria", 2, "LP2");
		
		try {
			acc.alterarDescricaoAtividade("", 12345678, "", "");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void alteraDescricaoAtividadeSenhaEstudanteInvalidaTeste() {
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "Monitoria", 2, "LP2");
		
		try {
			acc.alterarDescricaoAtividade("000.000.000-00", 1234567, "000.000.000-00_1", "Descrição LP2");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void alteraComprovacaoAtividadeValidoTeste() {
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "Monitoria", 2, "LP2");
		
		assertTrue(acc.alterarComprovacaoAtividade("000.000.000-00", 12345678, "000.000.000-00_1", "www.linkcomprovacao.com.br"));
	}
	
	@Test
	void alteraComprovacaoAtividadeEstudanteNaoExistenteTeste() {
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "Monitoria", 2, "LP2");
		
		assertFalse(acc.alterarComprovacaoAtividade("000.000.000-01", 12345678, "000.000.000-00_1", "www.linkcomprovacao.com.br"));
	}
	
	@Test
	void alteraComprovacaoAtividadeSenhaEstudanteIncorretaTeste() {
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "Monitoria", 2, "LP2");
		
		assertFalse(acc.alterarComprovacaoAtividade("000.000.000-00", 12345688, "000.000.000-00_1", "www.linkcomprovacao.com.br"));
	}

	@Test
	void alteraComprovacaoAtividadeComAtividadeNaoExistenteTeste() {
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "Monitoria", 2, "LP2");
		
		assertFalse(acc.alterarComprovacaoAtividade("000.000.000-00", 12345678, "000.000.000-00_2", "www.linkcomprovacao.com.br"));
	}

	@Test
	void alteraComprovacaoAtividadeArgumentosNulosTeste() {
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "Monitoria", 2, "LP2");
		
		try {
			acc.alterarComprovacaoAtividade(null, 12345678, null, null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo", erro.getMessage());
		}
	}
	
	@Test
	void alteraComprovacaoAtividadeArgumentosVaziosTeste() {
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "Monitoria", 2, "LP2");
		
		try {
			acc.alterarComprovacaoAtividade("", 12345678, "", "");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void alteraComprovacaoAtividadeSenhaInvalidaTeste() {
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "Monitoria", 2, "LP2");
		
		try {
			acc.alterarComprovacaoAtividade("000.000.000-00", 1234567, "000.000.000-00_1", "www.linkcomprovacao.com.br");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void criaAtividadePesquisaExtensaoEmEstudanteValidoTeste() {
		assertEquals("000.000.000-00_1",acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "Pesquisa_Extensão", 2, "LP2"));
	}
	
	@Test
	void criaAtividadePesquisaExtensaoEmEstudanteComEstudanteNaoExistenteTeste() {
		assertEquals("Estudante não cadastrado",acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-01", 12345678, "Pesquisa_Extensão", 2, "LP2"));
	}
	
	@Test
	void criaAtividadePesquisaExtensaoEmEstudanteSenhaIncorretaTeste() {
		assertEquals("Senha incorreta",acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345688, "Pesquisa_Extensão", 2, "LP2"));
	}
	
	@Test
	void criaAtividadePesquisaExtensaoEmEstudanteArgumentosNulosTeste() {
		try {
			acc.criarAtividadePesquisaExtensaoEmEstudante(null, 12345678, null, 2, null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo", erro.getMessage());
		}
	}
	
	@Test
	void criaAtividadePesquisaExtensaoEmEstudanteArgumentosVaziosTeste() {
		try {
			acc.criarAtividadePesquisaExtensaoEmEstudante("", 12345678, "", 2, "");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void criaAtividadePesquisaExtensaoEmEstudanteSenhaInvalidaTeste() {
		try {
			acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 1234567, "Pesquisa_Extensão", 2, "LP2");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void criaAtividadePesquisaExtensaoEmEstudanteUnidadeAcumuladaInvalidaTeste() {
		try {
			acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "Pesquisa_Extensão", -1, "LP2");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void criaAtividadeEstagioEmEstudanteValidoTeste() {
		assertEquals("000.000.000-00_1",acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "Estagio", 2, "LP2"));
	}
	
	@Test
	void criaAtividadeEstagioEmEstudanteComEstudanteNaoExistenteTeste() {
		assertEquals("Estudante não cadastrado",acc.criarAtividadeEstagioEmEstudante("000.000.000-01", 12345678, "Estagio", 2, "LP2"));
	}
	
	@Test
	void criaAtividadeEstagioEmEstudanteSenhaIncorretaTeste() {
		assertEquals("Senha incorreta",acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345688, "Estagio", 2, "LP2"));
	}
	
	@Test
	void criaAtividadeEstagioEmEstudanteArgumentosNulosTeste() {
		try {
			acc.criarAtividadeEstagioEmEstudante(null, 12345678, null, 2, null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo", erro.getMessage());
		}
	}
	
	@Test
	void criaAtividadeEstagioEmEstudanteArgumentosVaziosTeste() {
		try {
			acc.criarAtividadeEstagioEmEstudante("", 12345678, "", 2, "");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void criaAtividadeEstagioEmEstudanteSenhaInvalidaTeste() {
		try {
			acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 1234567, "Estagio", 2, "LP2");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void criaAtividadeEstagioEmEstudanteUnidadeAcumuladaInvalidaTeste() {
		try {
			acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "Estagio", -1, "LP2");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void criaAtividadePublicacaoEmEstudanteValidaTeste(){
		assertEquals("000.000.000-00_1",acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Artigo LP2", "001Artigo", "a3"));
	}
	
	@Test
	void criaAtividadePublicacaoEmEstudanteValidaTeste2(){
		assertEquals("000.000.000-00_1",acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Artigo LP2", "001Artigo", "a3"));
	}
	
	@Test
	void criaAtividadePublicacaoEmEstudanteComEstudanteNaoExistenteTeste(){
		assertEquals("Estudante não cadastrado",acc.criarAtividadePublicacaoEmEstudante("000.000.000-01", 12345678, "periódico", "Artigo LP2", "001Artigo", "a3"));
	}
	
	@Test
	void criaAtividadePublicacaoEmEstudanteSenhaIncorretaTeste(){
		assertEquals("Senha incorreta",acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345688, "periódico", "Artigo LP2", "001Artigo", "a3"));
	}
	
	@Test
	void criaAtividadePublicacaoEmEstudanteArgumentosNulosTeste() {
		try {
			acc.criarAtividadePublicacaoEmEstudante(null, 12345678, null, null, null, null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo", erro.getMessage());
		}
	}

	@Test
	void criaAtividadePublicacaoEmEstudanteArgumentosVaziosTeste() {
		try {
			acc.criarAtividadePublicacaoEmEstudante("", 12345678, "", "", "", "");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void criaAtividadePublicacaoEmEstudanteSenhaInvalidaTeste() {
		try {
			acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 1234567, "conferência", "Artigo LP2", "001Artigo", "a3");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void creditosAtividadeMonitoriaTeste() {
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "Monitoria", 2, "LP2");
		assertEquals(8,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadeMonitoriaMaximoTeste() {
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "Monitoria", 5, "LP2");
		assertEquals(16,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadePublicacaoConferenciaTeste() {
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Artigo Teste", "001Artigo", "a1");
		assertEquals(3,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadePublicacaoConferenciaTeste2() {
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Artigo Teste", "001Artigo", "a2");
		assertEquals(3,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadePublicacaoConferenciaTeste3() {
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Artigo Teste", "001Artigo", "a3");
		assertEquals(2,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadePublicacaoConferenciaTeste4() {
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Artigo Teste", "001Artigo", "a4");
		assertEquals(1,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadePublicacaoConferenciaTeste5() {
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Artigo Teste", "001Artigo", "b1");
		assertEquals(1,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadePublicacaoPeriodicoTeste() {
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Artigo Teste", "001Artigo", "a1");
		assertEquals(4,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadePublicacaoPeriodicoTeste2() {
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Artigo Teste", "001Artigo", "a2");
		assertEquals(4,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadePublicacaoPeriodicoTeste3() {
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Artigo Teste", "001Artigo", "a3");
		assertEquals(3,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadePublicacaoPeriodicoTeste4() {
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Artigo Teste", "001Artigo", "a4");
		assertEquals(1,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadePublicacaoPeriodicoTeste5() {
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Artigo Teste", "001Artigo", "b1");
		assertEquals(1,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadeEstagioTeste() {
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "Estagio", 300, "LP2");
		assertEquals(5,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}

	@Test
	void creditosAtividadeEstagioCreditosFracaoTeste() {
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "Estagio", 250, "LP2");
		assertEquals(4.16666666666666667,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadeEstagioCreditosMaximosTeste() {
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "Estagio", 1080, "LP2");
		assertEquals(18,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadeEstagioCreditosMaximosTeste2() {
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "Estagio", 1100, "LP2");
		assertEquals(18,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}

	@Test
	void creditosAtividadePesquisaTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 12, "LP2");
		assertEquals(10,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadePesquisaCreditosMaximoTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 22, "LP2");
		assertEquals(18,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}

	@Test
	void creditosAtividadePesquisaCreditosMaximoTeste2() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 23, "LP2");
		assertEquals(18,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadePesquisaCreditosFracaoTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		assertEquals(8.333333333333334,acc.creditosAtividade("000.000.000-00", 12345678, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadeEstudanteNaoExistenteTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		assertEquals(-1,acc.creditosAtividade("000.000.000-01", 12345678, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadeSenhaEstudanteIncorretaTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		assertEquals(-1,acc.creditosAtividade("000.000.000-00", 12345688, "000.000.000-00_1"));
	}
	
	@Test
	void creditosAtividadeComAtividadeNaoExistenteTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		assertEquals(-1,acc.creditosAtividade("000.000.000-00", 12345688, "000.000.000-00_2"));
	}

	@Test
	void creditosAtividadesArgumentosNulosTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		try {
			acc.creditosAtividade(null, 12345678, null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}

	@Test
	void creditosAtividadesArgumentosVaziosTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		try {
			acc.creditosAtividade("", 12345678, "");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void creditosAtividadesSenhaInvalidaTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		try {
			acc.creditosAtividade("000.000.000-00", 1234567, "000.000.000-00_1");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void criarRelatorioCompletoValidoTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		assertEquals(0,acc.criarRelatorioCompleto("000.000.000-00", "12345678"));
	}
	
	@Test
	void criarRelatorioCompletoComEstudanteNaoExistenteTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		assertEquals(-1,acc.criarRelatorioCompleto("000.000.000-01", "12345678"));
	}
	
	@Test
	void criarRelatorioCompletoComSenhaIncorretaTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		assertEquals(-1,acc.criarRelatorioCompleto("000.000.000-00", "12345688"));
	}
	
	@Test
	void criarRelatorioCompletoComSenhaInvalidaTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		
		try {
			acc.criarRelatorioCompleto("000.000.000-00", "1234567");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void criarRelatorioCompletoComArgumentosVaziosTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		
		try {
			acc.criarRelatorioCompleto("", "");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void criarRelatorioCompletoComArgumentosNulosTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		
		try {
			acc.criarRelatorioCompleto(null, null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo", erro.getMessage());
		}
	}
	
	@Test
	void criarRelatorioResumidoValidoTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		assertEquals(0,acc.criarRelatorioResumido("000.000.000-00", "12345678"));
	}
	
	@Test
	void criarRelatorioResumidoComEstudanteNaoExistenteTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		assertEquals(-1,acc.criarRelatorioResumido("000.000.000-01", "12345678"));
	}
	
	@Test
	void criarRelatorioResumidoComSenhaIncorretaTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		assertEquals(-1,acc.criarRelatorioResumido("000.000.000-00", "12345688"));
	}
	
	@Test
	void criarRelatorioResumidoComSenhaInvalidaTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		
		try {
			acc.criarRelatorioResumido("000.000.000-00", "1234567");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void criarRelatorioResumidoComArgumentosVaziosTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		
		try {
			acc.criarRelatorioResumido("", "");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void criarRelatorioResumidoComArgumentosNulosTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		
		try {
			acc.criarRelatorioResumido(null, null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo", erro.getMessage());
		}
	}
	
	@Test
	void criarRelatorioResumidoPorATVValidoTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		
		assertEquals(0,acc.criarRelatorioResumidoPorATV("000.000.000-00", "12345678", "pesquisa_extensão"));
	}
	
	@Test
	void criarRelatorioResumidoPorATVComEstudanteNaoExistenteTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		
		assertEquals(-1,acc.criarRelatorioResumidoPorATV("000.000.000-01", "12345678", "pesquisa_extensão"));
	}
	
	@Test
	void criarRelatorioResumidoPorATVComSenhaIncorretaTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		
		assertEquals(-1,acc.criarRelatorioResumidoPorATV("000.000.000-00", "12345688", "pesquisa_extensão"));
	}
	
	@Test
	void criarRelatorioResumidoPorATVComSenhaInvalidaTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		
		try {
			acc.criarRelatorioResumidoPorATV("000.000.000-00", "1234567", "pesquisa_extensão");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void criarRelatorioResumidoPorATVComArgumentosVaziosTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		
		try {
			acc.criarRelatorioResumidoPorATV("", "", "");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void criarRelatorioResumidoPorATVComArgumentosNulosTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		
		try {
			acc.criarRelatorioResumidoPorATV(null, null, null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo", erro.getMessage());
		}
	}
	
	@Test
	void exibirRelatorioComEstudanteNaoExistenteTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		acc.criarRelatorioCompleto("000.000.000-00", "12345678");
		
		assertEquals("",acc.exibirRelatorio("000.000.000-01", "12345678", 0));
	}
	
	@Test
	void exibirRelatorioComSenhaIncorretaTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		acc.criarRelatorioCompleto("000.000.000-00", "12345678");
		
		assertEquals("",acc.exibirRelatorio("000.000.000-00", "12345677", 0));
	}
	
	@Test
	void exibirRelatorioComArgumentosNulosTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		acc.criarRelatorioCompleto("000.000.000-00", "12345678");
		
		try {
			acc.exibirRelatorio(null, null, 0);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo", erro.getMessage());
		}
	}
	
	@Test
	void exibirRelatorioComArgumentosVaziosTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		acc.criarRelatorioCompleto("000.000.000-00", "12345678");
		
		try {
			acc.exibirRelatorio("", "", 0);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void exibirRelatorioComSenhaInvalidaTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		acc.criarRelatorioCompleto("000.000.000-00", "12345678");
		
		try {
			acc.exibirRelatorio("000.000.000-00", "1234567", 0);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido", erro.getMessage());
		}
	}
	
	@Test
	void exibirRelatorioCompletoTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 12, "LP2");
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "monitoria", 2, "LP2");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Titulo Artigo", "001doi", "a3");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Titulo Artigo2", "001doi", "a2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 300, "LP2");
		acc.criarRelatorioCompleto("000.000.000-00", "12345678");
		
		assertEquals("Estudante: Isaque; CPF: 000.000.000-00; Matricula: 123110111\n"
				+ "Atividade do Tipo: Estagio\nDescrição: null\nCreditos Acumulados: 5.0\n"
				+ "\nAtividade do Tipo: Monitoria\nDescrição: null\nCreditos Acumulados: 8.0\n"
				+ "\nAtividade do Tipo: Pesquisa_Extensão\nDescrição: null\nCreditos Acumulados: 10.0\n"
				+ "\nAtividade do Tipo: Publicação\nDescrição: null\nCreditos Acumulados: 2.0\n"
				+ "\nAtividade do Tipo: Publicação\nDescrição: null\nCreditos Acumulados: 4.0\n\n", acc.exibirRelatorio("000.000.000-00", "12345678", 0));
	}
	
	@Test
	void exibirRelatorioCompletoSemAtingirTempoMinimoTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 10, "LP2");
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "monitoria", 2, "LP2");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Titulo Artigo", "001doi", "a3");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Titulo Artigo2", "001doi", "a2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 290, "LP2");
		acc.criarRelatorioCompleto("000.000.000-00", "12345678");
		
		assertEquals("Estudante: Isaque; CPF: 000.000.000-00; Matricula: 123110111\n"
				+ "Atividade do Tipo: Estagio\nDescrição: null\nCreditos Acumulados: 4.833333333333333\n"
				+ "\nAtividade do Tipo: Monitoria\nDescrição: null\nCreditos Acumulados: 8.0\n"
				+ "\nAtividade do Tipo: Pesquisa_Extensão\nDescrição: null\nCreditos Acumulados: 8.333333333333334\n"
				+ "\nAtividade do Tipo: Publicação\nDescrição: null\nCreditos Acumulados: 2.0\n"
				+ "\nAtividade do Tipo: Publicação\nDescrição: null\nCreditos Acumulados: 4.0\n\n", acc.exibirRelatorio("000.000.000-00", "12345678", 0));
	}
	
	@Test
	void exibirRelatorioResumidoTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 12, "LP2");
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "monitoria", 2, "LP2");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Titulo Artigo", "001doi", "a3");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Titulo Artigo2", "001doi", "a2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 300, "LP2");
		acc.criarRelatorioResumido("000.000.000-00", "12345678");
		
		assertEquals("Estudante: Isaque; CPF: 000.000.000-00; Matricula: 123110111\n"
				+ "Atividades de Estagio: 5.0 créditos acumulados de 18 créditos possíveis;"
				+ "\nAtividades de Monitoria: 8.0 créditos acumulados de 16 créditos possíveis;"
				+ "\nAtividades de Pesquisa e Extensão: 10.0 créditos acumulados de 18 créditos possíveis;"
				+ "\nAtividades de Publicação: 6.0 créditos acumulados de 16 créditos possíveis.", acc.exibirRelatorio("000.000.000-00", "12345678", 0));
	}
	
	@Test
	void exibirRelatorioResumidoEstagioHorasMinimasDivididasTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 12, "LP2");
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "monitoria", 2, "LP2");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Titulo Artigo", "001doi", "a3");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Titulo Artigo2", "001doi", "a2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 140, "LP2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 160, "LP2");
		acc.criarRelatorioResumido("000.000.000-00", "12345678");
		
		assertEquals("Estudante: Isaque; CPF: 000.000.000-00; Matricula: 123110111\n"
				+ "Atividades de Estagio: 5.0 créditos acumulados de 18 créditos possíveis;"
				+ "\nAtividades de Monitoria: 8.0 créditos acumulados de 16 créditos possíveis;"
				+ "\nAtividades de Pesquisa e Extensão: 10.0 créditos acumulados de 18 créditos possíveis;"
				+ "\nAtividades de Publicação: 6.0 créditos acumulados de 16 créditos possíveis.", acc.exibirRelatorio("000.000.000-00", "12345678", 0));
	}
	
	@Test
	void exibirRelatorioResumidoEstagioNaoAtingiuHorasMinimasTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 12, "LP2");
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "monitoria", 2, "LP2");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Titulo Artigo", "001doi", "a3");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Titulo Artigo2", "001doi", "a2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 140, "LP2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 140, "LP2");
		acc.criarRelatorioResumido("000.000.000-00", "12345678");
		
		assertEquals("Estudante: Isaque; CPF: 000.000.000-00; Matricula: 123110111\n"
				+ "Atividades de Estagio: NÃO ATINGIU AINDA O VALOR MÍNIMO DE CRÉDITOS de 18 créditos possíveis;"
				+ "\nAtividades de Monitoria: 8.0 créditos acumulados de 16 créditos possíveis;"
				+ "\nAtividades de Pesquisa e Extensão: 10.0 créditos acumulados de 18 créditos possíveis;"
				+ "\nAtividades de Publicação: 6.0 créditos acumulados de 16 créditos possíveis.", acc.exibirRelatorio("000.000.000-00", "12345678", 0));
	}
	
	@Test
	void exibirRelatorioResumidoPesquisaMesesDivididosTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 6, "LP2");
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 6, "LP2");
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "monitoria", 2, "LP2");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Titulo Artigo", "001doi", "a3");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Titulo Artigo2", "001doi", "a2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 150, "LP2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 150, "LP2");
		acc.criarRelatorioResumido("000.000.000-00", "12345678");
		
		assertEquals("Estudante: Isaque; CPF: 000.000.000-00; Matricula: 123110111\n"
				+ "Atividades de Estagio: 5.0 créditos acumulados de 18 créditos possíveis;"
				+ "\nAtividades de Monitoria: 8.0 créditos acumulados de 16 créditos possíveis;"
				+ "\nAtividades de Pesquisa e Extensão: 10.0 créditos acumulados de 18 créditos possíveis;"
				+ "\nAtividades de Publicação: 6.0 créditos acumulados de 16 créditos possíveis.", acc.exibirRelatorio("000.000.000-00", "12345678", 0));
	}
	
	@Test
	void exibirRelatorioResumidoPesquisaNaoAtingiuMesesMinimosTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 6, "LP2");
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 4, "LP2");
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "monitoria", 2, "LP2");
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "monitoria", 1, "FMCC");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Titulo Artigo", "001doi", "a3");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Titulo Artigo2", "001doi", "a2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 150, "LP2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 150, "LP2");
		acc.criarRelatorioResumido("000.000.000-00", "12345678");
		
		assertEquals("Estudante: Isaque; CPF: 000.000.000-00; Matricula: 123110111\n"
				+ "Atividades de Estagio: 5.0 créditos acumulados de 18 créditos possíveis;"
				+ "\nAtividades de Monitoria: 12.0 créditos acumulados de 16 créditos possíveis;"
				+ "\nAtividades de Pesquisa e Extensão: NÃO ATINGIU AINDA O VALOR MÍNIMO DE CRÉDITOS de 18 créditos possíveis;"
				+ "\nAtividades de Publicação: 6.0 créditos acumulados de 16 créditos possíveis.", acc.exibirRelatorio("000.000.000-00", "12345678", 0));
	}
	
	@Test
	void exibirRelatorioResumidoPesquisaEstagioNaoAtingiuTempoMinimosTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 6, "LP2");
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 4, "LP2");
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "monitoria", 2, "LP2");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Titulo Artigo", "001doi", "a3");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Titulo Artigo2", "001doi", "a2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 150, "LP2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 100, "LP2");
		acc.criarRelatorioResumido("000.000.000-00", "12345678");
		
		assertEquals("Estudante: Isaque; CPF: 000.000.000-00; Matricula: 123110111\n"
				+ "Atividades de Estagio: NÃO ATINGIU AINDA O VALOR MÍNIMO DE CRÉDITOS de 18 créditos possíveis;"
				+ "\nAtividades de Monitoria: 8.0 créditos acumulados de 16 créditos possíveis;"
				+ "\nAtividades de Pesquisa e Extensão: NÃO ATINGIU AINDA O VALOR MÍNIMO DE CRÉDITOS de 18 créditos possíveis;"
				+ "\nAtividades de Publicação: 6.0 créditos acumulados de 16 créditos possíveis.", acc.exibirRelatorio("000.000.000-00", "12345678", 0));
	}
	
	@Test
	void exibirRelatorioResumidoPorATVEstagioSemAtigirCreditosTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 6, "LP2");
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 4, "LP2");
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "monitoria", 2, "LP2");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Titulo Artigo", "001doi", "a3");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Titulo Artigo2", "001doi", "a2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 150, "LP2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 100, "LP2");
		acc.criarRelatorioResumidoPorATV("000.000.000-00", "12345678","estagio");
		
		assertEquals("Estudante: Isaque; CPF: 000.000.000-00; Matricula: 123110111\n"
				+ "Atividades de Estagio: NÃO ATINGIU AINDA O VALOR MÍNIMO DE CRÉDITOS de 18 créditos possíveis.", acc.exibirRelatorio("000.000.000-00", "12345678", 0));
	}
	
	@Test
	void exibirRelatorioResumidoPorATVEstagioTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 6, "LP2");
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 4, "LP2");
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "monitoria", 2, "LP2");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Titulo Artigo", "001doi", "a3");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Titulo Artigo2", "001doi", "a2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 150, "LP2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 250, "LP2");
		acc.criarRelatorioResumidoPorATV("000.000.000-00", "12345678","estagio");
		
		assertEquals("Estudante: Isaque; CPF: 000.000.000-00; Matricula: 123110111\n"
				+ "Atividades de Estagio: 6.0 créditos acumulados de 18 créditos possíveis", acc.exibirRelatorio("000.000.000-00", "12345678", 0));
	}
	
	@Test
	void exibirRelatorioResumidoPorATVMonitoriaTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 6, "LP2");
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 4, "LP2");
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "monitoria", 2, "LP2");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Titulo Artigo", "001doi", "a3");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Titulo Artigo2", "001doi", "a2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 150, "LP2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 250, "LP2");
		acc.criarRelatorioResumidoPorATV("000.000.000-00", "12345678","monitoria");
		
		assertEquals("Estudante: Isaque; CPF: 000.000.000-00; Matricula: 123110111\n"
				+ "Atividades de Monitoria: 8.0 créditos acumulados de 16 créditos possíveis.", acc.exibirRelatorio("000.000.000-00", "12345678", 0));
	}
	
	@Test
	void exibirRelatorioResumidoPorATVPublicacaoConferenciaTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 6, "LP2");
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 4, "LP2");
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "monitoria", 2, "LP2");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Titulo Artigo", "001doi", "a3");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Titulo Artigo2", "001doi", "a2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 150, "LP2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 250, "LP2");
		acc.criarRelatorioResumidoPorATV("000.000.000-00", "12345678","conferência");
		
		assertEquals("Estudante: Isaque; CPF: 000.000.000-00; Matricula: 123110111\n"
				+ "Atividades de Publicação: 6.0 créditos acumulados de 16 créditos possíveis.", acc.exibirRelatorio("000.000.000-00", "12345678", 0));
	}
	
	@Test
	void exibirRelatorioResumidoPorATVPublicacaoPeriodicoTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 6, "LP2");
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 4, "LP2");
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "monitoria", 2, "LP2");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Titulo Artigo", "001doi", "a3");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Titulo Artigo2", "001doi", "a2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 150, "LP2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 250, "LP2");
		acc.criarRelatorioResumidoPorATV("000.000.000-00", "12345678","periódico");
		
		assertEquals("Estudante: Isaque; CPF: 000.000.000-00; Matricula: 123110111\n"
				+ "Atividades de Publicação: 6.0 créditos acumulados de 16 créditos possíveis.", acc.exibirRelatorio("000.000.000-00", "12345678", 0));
	}
	
	@Test
	void exibirRelatorioResumidoPorATVPesquisaTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 6, "LP2");
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 8, "LP2");
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "monitoria", 2, "LP2");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Titulo Artigo", "001doi", "a3");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Titulo Artigo2", "001doi", "a2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 150, "LP2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 250, "LP2");
		acc.criarRelatorioResumidoPorATV("000.000.000-00", "12345678","pesquisa_extensão");
		
		assertEquals("Estudante: Isaque; CPF: 000.000.000-00; Matricula: 123110111\n"
				+ "Atividades de Pesquisa e Extensão: 11.0 créditos acumulados de 18 créditos possíveis.", acc.exibirRelatorio("000.000.000-00", "12345678", 0));
	}
	
	@Test
	void exibirRelatorioResumidoPorATVPesquisaSemAtingirTempoMinimoTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 6, "LP2");
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 2, "LP2");
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "monitoria", 2, "LP2");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Titulo Artigo", "001doi", "a3");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Titulo Artigo2", "001doi", "a2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 150, "LP2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 250, "LP2");
		acc.criarRelatorioResumidoPorATV("000.000.000-00", "12345678","pesquisa_extensão");
		
		assertEquals("Estudante: Isaque; CPF: 000.000.000-00; Matricula: 123110111\n"
				+ "Atividades de Pesquisa e Extensão: NÃO ATINGIU AINDA O VALOR MÍNIMO DE CRÉDITOS de 18 créditos possíveis.", acc.exibirRelatorio("000.000.000-00", "12345678", 0));
	}
	
	@Test
	void exibirRelatorioResumidoPorATVSemEspecificarTipoTeste() {
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 6, "LP2");
		acc.criarAtividadePesquisaExtensaoEmEstudante("000.000.000-00", 12345678, "pesquisa_extensão", 4, "LP2");
		acc.criarAtividadeMonitoriaEmEstudante("000.000.000-00", 12345678, "monitoria", 2, "LP2");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "conferência", "Titulo Artigo", "001doi", "a3");
		acc.criarAtividadePublicacaoEmEstudante("000.000.000-00", 12345678, "periódico", "Titulo Artigo2", "001doi", "a2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 150, "LP2");
		acc.criarAtividadeEstagioEmEstudante("000.000.000-00", 12345678, "estagio", 250, "LP2");
		acc.criarRelatorioResumidoPorATV("000.000.000-00", "12345678","");
		
		assertEquals("", acc.exibirRelatorio("000.000.000-00", "12345678", 0));
	}
}
