package com.generation.scrum_manager.main;

import com.generation.scrum_manager.modelos.*;
import static com.generation.scrum_manager.modelos.Status.*;
import static com.generation.scrum_manager.modelos.CriaUserStory.*;
import static com.generation.scrum_manager.modelos.ConstroiSprint.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//inicia o array (conjunto) de User Stories vazio
		//semelhante a um array[]
		ArrayList<UserStory> backLog = new ArrayList<>();

		//solicita uma resposta do usuário para iniciar a construção do backlog
		int op = 0;
		System.out.println("*****************************************");
		System.out.println("_____Iniciar a construção do BackLog_____");
		System.out.println("*****************************************");

		//o valor solicitado precisa ser um número
		//ou haverá um erro
		try {
			System.out.println("digite 1 para iniciar o backlog.");
			System.out.println("Caso tenha se enganado, digite qualquer valor.");
			op = scan.nextInt();
		} catch (InputMismatchException inputMismatchException) {
			System.err.println("O valor inserido é diferente do esperado.");
			System.err.println("A solicitação aceita apenas números inteiros.");
			System.out.println("O programa será finalizado.");
		}

		if (op == 1) {//condicional do loop
			String continuar;
			//iniciando um 'loop' para a construção do backlog

			String nomeProjeto = nomeProjeto();
			do {
				System.out.println("-----------------------------------");
				System.out.println("__Adicionando uma nova user story__");
				System.out.println("-----------------------------------");

				UserStory userStory = criaUserStory(nomeProjeto);

				//confirma a inserção da user story
				boolean valida = valida();

				if (valida) {
					//constrói a user story e adiciona ao backlog
					backLog.add(userStory);
					System.out.println("user story adicionada ao backlog.");

					//solicita a confirmação do usuário para continuar
					System.out.print("Deseja adicionar mais user stories ao backlog? s/n: ");
					continuar = scan.next();
				} else {
					//solicita a confirmação do usuário para continuar
					System.out.println("Cancelado com sucesso.");
					System.out.print("Deseja adicionar mais user stories ao backlog? s/n: ");
					continuar = scan.next();
				}
			} while (continuar.equalsIgnoreCase("s"));
		} else {
			System.out.println("Adeus!");
		}
		backLog.sort(new UserStory());
		// final do backlog
		//construção das 'sprints'
		Sprint[] sprints = ConstroiSprint.constroiSprint(backLog.size());

		// transferência do backlog para 'sprint'
		//populando as 'sprints'
		populaSprint(sprints,backLog);

		//verifica 'status'
		status(sprints);

		System.out.println("Processo finalizado. Obrigado!");
		scan.close();
	}
}