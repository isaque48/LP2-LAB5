package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UsuarioTeste {

	@Test
	void alteraSenhaQuantidadeDigitosInvalidoTeste() {
		Usuario user = new Usuario("Isaque","000.000.000-00",12345678);
		try {
			user.alteraSenha(1234567);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}
	
	@Test
	void alteraSenhaQuantidadeDigitosInvalidoTeste2() {
		Usuario user = new Usuario("Isaque","000.000.000-00",12345678);
		try {
			user.alteraSenha(123456789);
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido!", erro.getMessage());
		}
	}


}
