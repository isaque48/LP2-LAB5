package br.edu.ufcg.computacao.complementaccc;

import java.util.Objects;

/**
 * Classe que define o tipo Faq, ela possui os atributos pergunta,resposta,destaques e tags.
 * @author Isaque Esdras Rocha - Matricula: 123110685
 */
public class Faq{
	/*
	 * Atributo sobre a pergunta do faq
	 */
	private String pergunta;
	
	/**
	 * Atributo sobre a resposta da pergunta
	 */
	private String resposta;
	
	/**
	 * Atributo da quantidade de destaques que foi dado a pergunta
	 */
	private int destaques;
	
	/**
	 * Atributo das tags que foi dada para a pergunta, cada pergunta só pode ter no maximo 3 tags
	 */
	private String[] tags;
	
	/**
	 * Contrutor da classe Faq, onde recebe apenas a pergunta. Começa com o número de destaques zerados.
	 * @param pergunta - Pergunta cadastrada no faq
	 */
	public Faq(String pergunta) {
		this.pergunta = pergunta;
		this.destaques = 0;
		this.tags = new String[3];
	}
	
	/**
	 * Contrutor da classe Faq, recebendo a pergunta e sua resposta. Começa com o número de destaques zerados.
	 * @param pergunta - Pergunta cadastrada no faq
	 * @param resposta - Reposta para a pergunta cadastrada
	 */
	public Faq(String pergunta,String resposta) {
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.destaques = 0;
		this.tags = new String[3];;
	}
	
	/**
	 * Método para alterar a resposta do Faq.
	 * @param respostaNova - Nova resposta para o faq
	 */
	public void alteraResposta(String respostaNova) {
		this.resposta = respostaNova;
	}
	
	/**
	 * Método que aumenta o número do destaque em 1 unidade.
	 */
	public void aumentaDestaque() {
		this.destaques += 1;
	}
	
	/**
	 * Sobrescreve o método toString, atualizando a representação em String da classe Faq.
	 * @return Uma string no formato: "Pergunta: Pergunta-Cadastrada; Resposta: Resposta-Para-A-Pergunta", caso a resposta tenha sido cadastrada,
	 * ou "Pergunta: Pergunta-Cadastrada; Resposta: *Resposta não cadastrada*", caso a resposta nao tenha sido cadastrada ainda.
	 * 
	 */
	@Override
	public String toString() {
		if(this.resposta == null) {
			return String.format("Pergunta: %s; Resposta: *Resposta não cadastrada*", this.pergunta);
		}
		
		return String.format("Pergunta: %s; Resposta: %s", this.pergunta, this.resposta);
	}
	
	/**
	 * Método para pegar o numero de destaques da pergunta
	 * @return - O numero de destaques
	 */
	public int getDestaques() {
		return this.destaques;
	}
	
	/**
	 * Métotodo para adicionar tags para a pergunta do Faq
	 * @param tag - Lista com os tags que serão adicionados ao faq
	 */
	public void adicionaTag(String[] tag) {
		this.tags = tag;
	}
	
	/**
	 * Metodo que verifica se existe uma tag especifica na lista de tags da pergunta
	 * @param tag - Tag que será verificada a existencia na lista
	 * @return true, caso a tag exista na lista, ou false, caso a tag não exista na lista
	 */
	public boolean verificaExistenciaTag(String tag) {
		int contador = 0;
		for(String tagTemporaria : this.tags) {
			if(!(tagTemporaria == null) && tagTemporaria.equals(tag)) {
				contador++;
			}
		}
		
		if(contador > 0) {
			return true;
		}
		
		return false;
	}

	/**
	 * Sobrescreve o método hashCode, utilizando a pergunta do faq para determinar o hashCode da classe.
	 * @return hashcode gerado apartir da pergunta do faq.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(pergunta);
	}

	/**
	 * Sobrescreve o método equals, utilizando a pergunta do faq como parametro para determinar se os faqs são iguais.
	 * @return true, caso as faqs sejam iguais, ou false, caso as faqs nao sejam iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faq other = (Faq) obj;
		return Objects.equals(pergunta.toUpperCase(), other.pergunta.toUpperCase());
	}	
}
