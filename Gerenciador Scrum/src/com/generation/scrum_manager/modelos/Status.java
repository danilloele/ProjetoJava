package com.generation.scrum_manager.modelos;

import java.util.Scanner;

public class Status {
    public static void status(Sprint[] sprints){
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < sprints.length; i++) {
            for (int j = 0; j < sprints[i].size(); j++) {
                sprints[i].getList();

                while (3 != sprints[i].getBase(j).getEstado()){
                    System.out.println("Qual o status da User Story " +(j+1)+ "?");
                    System.out.println("""
                            1- A fazer
                            2- Em andamento
                            3- Feito""");
                    int val= scan.nextInt();
                    sprints[i].getBase(j).setEstado(val);
                }
            }
        }
    }
}
