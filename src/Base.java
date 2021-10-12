import java.util.Comparator;

public class Base implements Comparator<Base>{
	
	//Atributos
	private String projeto;
	private Pessoa responsavel;//scrum master
	private String nome; //nome da funcionalidade
	private String mensagem; //como a funcionalidade manipula os dados
	private int prioridade; //Nível de dificuldade da user story
	private int estado; //em qual momento a user story se encontra
						//( - a fazer, 2 - fazendo, 3 - finalizada/revisar)
	
	public Base(String projeto, Pessoa responsavel, String nome, String mensagem, int prioridade, int estado)
	{
		this.projeto= projeto;
		this.responsavel= responsavel;
		this.nome= nome;
		this.mensagem= mensagem;
		this.prioridade= prioridade;
		this.estado= estado;
	}
	public Base() {
		
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

	public Pessoa getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Pessoa responsavel) {
		this.responsavel = responsavel;
	}
	
	public String infoBase()
	{
		return "\nProjeto: " +getProjeto()+ "\nResponsável: " +getResponsavel()
		+ "\nFuncionalidade: " +getNome()+ "\nComo faz: " +getMensagem() + "\nNível de prioridade: " +getPrioridade()
		+ "\nEstado: " +getEstado();
	}

	@Override
	public int compare(Base o1, Base o2) {
		if(o1.prioridade > o2.prioridade) {
			return -1;
		} else if (o1.prioridade < o2.prioridade){
			return 1;
		}
		else return 0;
	}

}
