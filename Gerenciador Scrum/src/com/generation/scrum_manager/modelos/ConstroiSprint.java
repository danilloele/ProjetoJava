package com.generation.scrum_manager.modelos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConstroiSprint {
    public static Sprint[] constroiSprint(int tamanhoDoBacklog){
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.err.println("Antes de iniciar a Sprint certifique-se de ter confirmado o backlog.");
        System.out.println();
        System.out.println("Informe o número de Sprints que deseja criar de acordo com o backlog.");
        int numeroSprints = scan.nextInt();

        while (numeroSprints > tamanhoDoBacklog){
            System.out.println("O número de sprints não pode exceder o número de user stories");
            System.out.println("informe um valor válido para a construção das sprints: ");
            numeroSprints = scan.nextInt();
        }
        Sprint[] sprints = new Sprint[numeroSprints];
        for (int i = 0; i < sprints.length; i++) {
            sprints[i] = new Sprint();
        }
        return sprints;
    }

    public static void populaSprint(Sprint[] sprints, ArrayList<UserStory> backlog){
        Scanner scan = new Scanner(System.in);
        int transfere = 0;
        for (int i = 0; i < sprints.length; i++){
            scan.nextLine();
            //populando o Sprint
            int value = backlog.size();
            System.out.println("Existem " + value + " user Stories no backlog");
            try {
                System.out.println("De acordo com a ordem prioritária, quantas funcionalidades deseja "
                        + "transferir do backlog para a sprint " + (i+1) + ".");
                transfere = scan.nextInt();
            }catch (InputMismatchException inputMismatchException) {
                System.err.println("Erro: você não inseriu um valor numérico inteiro.");
            }

            int forCont = 1;
            for (int j = 0; j < transfere; j++){
                scan.nextLine();
                System.out.println();
                for(UserStory user: backlog) {
                    System.out.println(user.getNome());
                    System.out.println(user.getPrioridade());
                    System.out.println();
                }
                System.out.println("De acordo com a lista do backlog acima," +
                        "\n informe o nome da " +forCont +"ª user story que deseja transferir para a sprint " + (i+1) + "?");
                System.out.println("digite o nome da user story: ");
                String envia = scan.nextLine();
                int aux = 0;
                for(int k = 0;k < backlog.size();k++) {
                    if(envia.equalsIgnoreCase(backlog.get(k).getNome())) {
                        aux = k;
                    }
                }
                sprints[i].atualiza(backlog.get(aux),backlog);
                forCont++;
            }
        }
    }
}

