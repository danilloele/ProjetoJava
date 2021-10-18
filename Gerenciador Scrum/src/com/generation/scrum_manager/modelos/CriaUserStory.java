package com.generation.scrum_manager.modelos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta classe é responsável pela construção de objetos(user stories) do tipo Base,
 * e foi implementada para facilitar o processo de construção do backlog.
 * Pois observando a inviabilidade da aplicação direta na classe de execução (Main)
 * devido ao excesso de informação contida nesta classe (Main) sem o uso deste construtor.
 *
 * A classe é constituída por métodos estáticos que fazem a solicitação de cada informação(atributo)
 * a ser aplicado na construção da User Story.
 *
 * A classe inicialmente, será composta por 7 métodos(funções) das quais 6 são private,
 * e são chamados pelo único método 'public' que constrói o objeto(user story)
 * com base nos dados obtidos através dos métodos private.
 *
 * os métodos não solicitam parametros.
 */
public class CriaUserStory {

    public static String nomeProjeto() throws InputMismatchException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Qual o nome do projeto?");
        String nome = scan.nextLine();
        return nome;
    }
    private static String nomeResponsavel() throws InputMismatchException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Quem está adicionando a user story? ");
        String nome = scan.nextLine();
        return nome;
    }

    private static String nomeDaFeat(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe o nome da user story de forma reduzida: ");
        String nome = scan.nextLine();
        return nome;
    }

    private static String funcaoResumida(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o objetivo da user story.");
        String objetivo = scan.nextLine();
        return objetivo;
    }

    private static int prioridade() throws InputMismatchException{
        Scanner scan = new Scanner(System.in);
        System.out.println("De acordo com a dificuldade da função.");
        System.out.println("Defina uma prioridade inicial para a user story.");
        System.out.println("\nOs níveis de prioridade vão de 1 a 5");
        int prioridade = scan.nextInt();
        if(prioridade > 5 || prioridade < 1){
            prioridade = 3;
        }
        return prioridade;
    }

    private static String logicaDaUsrStory(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe COMO a user story executará o processo:");
        String logica = scan.nextLine();
        return logica;
    }

    public static UserStory criaUserStory(String nomeProjeto){//parameter pode ser desnecessário
        String nomeResp = nomeResponsavel();
        String nomeFeat =  nomeDaFeat();
        String func = funcaoResumida();
        int prioridade = prioridade();
        String funcao = logicaDaUsrStory();
        UserStory userStory = new UserStory(nomeProjeto,nomeResp,func,funcao,prioridade,nomeFeat);
        return userStory;
    }

    public static boolean valida() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Você realmente deseja adicionar a user story ? s/n: ");
        String valida = scan.nextLine();

        boolean b = valida.equalsIgnoreCase("S") || valida.equalsIgnoreCase("N");
        return b;
    }
}
