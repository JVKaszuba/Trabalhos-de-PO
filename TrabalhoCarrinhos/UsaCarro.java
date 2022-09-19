package TrabalhoCarrinhos;

import java.util.Scanner;

public class UsaCarro {
    public static void main(String[] args) {

        System.out.print("Numero de carros: ");
        Scanner teclado = new Scanner(System.in);
        int n = teclado.nextInt();

        Carro carros[] = new Carro[n];

        for(int i = 0; i < n; i++) {

            System.out.print("Número de rodas: ");
            teclado = new Scanner(System.in);
            int rodas = teclado.nextInt();
            teclado.close();

            carros[i] = new Carro(rodas);
            carros[i].status();
        }  

        }
        /*RodaGui roda[] = new RodaGui[4];                //Gera as rodas, sorteando se estao calibradas;
        for(int i=0; i<4; i++){
            roda[i] = new RodaGui();
            System.out.println("Roda " + i + " " + roda[i].getCalibragem());
        }*/

    }

