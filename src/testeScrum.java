import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class testeScrum {

	public static void main(String[] args) { 
		Scanner scan = new Scanner(System.in);
		//inicia o array (conjunto) de User Stories vazio
		//semelhante a um array[]
		ArrayList <Base> backLog = new ArrayList<>();
		int senha=0;
		System.out.print("Informe o nome do Projeto: ");
		String nomeProjeto = scan.nextLine();
		
		//solicita os dados do respons�vel
		//solicita o nome do Scrum Master
		System.out.println("Informe os dados do respons�vel: ");
		System.out.print("Informe o Nome: ");
		String nomeRes = scan.nextLine();
		scan.nextLine();
		
		//solicita a fun��o do Scrum Master
		System.out.print("Informe a fun��o: ");
		String funcaoRes = scan.nextLine();
		
		//solicita a senha
		System.out.print("Informe a senha: ");
		int senhaRes = scan.nextInt();
		
		//constroi o 'objeto' respons�vel
		Pessoa dev = new Pessoa (nomeRes, funcaoRes, senhaRes);
		
		//solicita uma resposta do usu�rio para iniciar a constru��o do backlog
		int op;
		System.out.println("*****************************************");
		System.out.println("_____Iniciar a constru��o do BackLog_____");
		System.out.println("*****************************************");
		
		//o valor solicitado precisa ser um n�mero
		//ou haver� um erro
		System.out.println("Deseja construir uma nova user story ?");
		System.out.println("digite 1: sim");
		System.out.println("Caso tenha se enganado, digite qualquer valor:");
		op = scan.nextInt();
		
		
		//valida e inicia o backlog com uma user story inicial
		switch(op) {
		
			case 1->{
				//solicita os dados para valida��o
				System.out.println("�timo! digite a senha do respons�vel: ");
				senha = scan.nextInt();
		
				//verifica os dados e constroi a user story 
				if(senha == dev.getCodAcesso()) {
					//condicional do loop
					int continuar = 0;
					
					//iniciando um loop para a constru��oo do backlog
						do{
						System.out.println("***********************************");
						System.out.println("__Adicionando uma nova user story__");
						System.out.println("***********************************");
						
						//solicita o nome ou a fun��o da user story 
						scan.nextLine();
						System.out.println("Informe o que faz a user story: ");
						String nome = scan.nextLine();
						
						//solicita a mensagem de descri��o da user story 
						scan.nextLine();
						System.out.println("Informe como a user story executar� o processo: ");
						String mensagem = scan.nextLine();
						
						//define o n�vel de prioridade/dificuldade exigida para a constru��o
						//da user story
						scan.nextLine();
						System.out.println("\nOs n�veis de prioridade v�o de 1 a 10");
						System.out.println("(Do maior para o menor.)");
						System.out.println("De acordo com a dificuldade da fun��o.");
						System.out.println("Defina uma prioridade inicial para a user story: ");
						
						int prioridade = scan.nextInt();
						
						//constroi a user story e adiciona ao backlog
						Base story = new Base(nomeProjeto, dev,nome,mensagem,prioridade, 0);
						backLog.add(story);
						System.out.println("user story adicionada ao backlog.");
						
						//solicita a confirma��o do usu�rio para continuar
						System.out.println("Deseja adicionar mais user stories ao backlog?");
						System.out.println("Se deseja adicionar, digite 0");
						System.out.println("Se n�o, digite 1");
						System.out.print("digite aqui: ");
						scan.nextLine();
						continuar = scan.nextInt();
						System.out.println(continuar);
						
					}while(continuar != 1); 
				}
				
			
				else{
					System.out.println("Senha incorreta.");
				}
				
			}
			default -> {
				System.out.println("Adeus!");
			}
		}
		
		Collections.sort(backLog, new Base());
		
		if(op == 1 && senha == dev.getCodAcesso()) {
		// final do backlog
		// inicio da constru��o das sprints
		
		System.out.println("***********************************");
		System.out.println("__Deseja iniciar os sprints?__");
		System.out.println("***********************************");
		System.out.println("Se sim, digite 1: ");
		System.out.println("Se n�o, digite 0:");
		System.out.println("Digite aqui:");
		int op2= scan.nextInt();
		
		if(op2 != 1)
		{
			System.out.println("Adeus!");
			
		}
		else
		{
			
			// transferencia do backlog para sprint
			switch(op2)
			{
			case 1 ->
			{
			// constru��o da sprint	
				System.out.println("Comece a constru��o da sprint: ");
				
				Sprint[] sprints= { new Sprint()};
				
				int cont=0;
				
				System.out.println("De acordo com a ordem priorit�ria, quantas funcionalidades deseja"
						+ "transferir do backlog para a sprint 1?");
					int transfere= scan.nextInt();

					while (backLog.size()-1 > transfere)
					{
						System.out.println("N�o h� funcionalidades dispon�veis para transfer�ncia!"
							+ "insira um n�mero menor de funcionalidades. ");
						System.out.println("De acordo com a ordem priorit�ria, quantas funcionalidades deseja"
							+ "transferir do backlog para a sprint 1?");
						transfere= scan.nextInt();
	
					}	
				
					cont += sprints[0].size();
					
					for (int i = 0; i < transfere; i++)
					{
						sprints[0].adicionaUserStory(backLog.get(i));
					}
					
	
				while(cont != sprints[0].size()*3)
				{
			
					sprints[0].getList();
					
					System.out.println("De acordo com os dados acima, informe o status da Sprint: ");
					
					for (int i= 0; i< sprints[0].size(); i++)
					{
						System.out.println("Qual o status da User Story " +(i+1)+ "?");
						System.out.println("\n1- A fazer"
								+ "\n2- Em andamento"
								+ "\n3- Feito");
						int val= scan.nextInt();
						sprints[0].getBase(i).setEstado(val);
					}
					
					
					for (int i= 0; i< sprints[0].size(); i++)
					{
						cont += sprints[0].getBase(i).getEstado();
					}
					System.out.println(cont);
					if (cont != sprints[0].size()*3)
					{
						cont = 0;
					}

				}
			}
				
	
			default ->
			{
				System.out.println("Op��o in�vlida!");
				
			}
			
			
			
			}
		}
		
		}
		else {
		System.out.println("Processo finalizado. Obrigado!");
		scan.close();
		}
		
		System.out.println("Processo finalizado. Obrigado!");
		scan.close();
	}
	
	
}
