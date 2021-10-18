package com.generation.scrum_manager.modelos;
import java.util.Comparator;

public class UserStory implements Comparator<UserStory>{
	
	//Atributos
	private String projeto;
	private String responsavel;//scrum master
	private String especificacao;
	private String nome; //nome da funcionalidade
	private String mensagem; //como a funcionalidade manipula os dados
	private int prioridade; //Nível de dificuldade da user story 1 a 5
	private int estado; //em qual momento a user story se encontra
						//( - a fazer, 2 - fazendo, 3 - finalizada/revisar)
	
	public UserStory(String projeto, String responsavel, String especificacao, String mensagem, int prioridade, String nome)
	{
		this.projeto= projeto;
		this.responsavel= responsavel;
		this.especificacao = especificacao;
		this.mensagem= mensagem;
		this.prioridade= prioridade;
		this.nome = nome;

	}
	public UserStory() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	public String getEspecificacao() {
		return especificacao;
	}
	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}
	
	public String infoBase()
	{
		return "\nNome: " + getNome() +"\nProjeto: " +getProjeto()+ "\nResponsável: " +getResponsavel()
		+ "\nFuncionalidade: " +getNome()+ "\nComo faz: " +getMensagem() + "\nNível de prioridade: " +getPrioridade()
		+ "\nEstado: " +getEstado();
	}

	@Override
	public int compare(UserStory o1, UserStory o2) {
		return Integer.compare(o2.prioridade, o1.prioridade);
	}

}
