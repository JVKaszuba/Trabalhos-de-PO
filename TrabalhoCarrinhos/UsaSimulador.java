package TrabalhoCarrinhos;

import java.util.Scanner;

public class UsaSimulador {
    
    public static void main(String[] args) {
        
        Simulador teste = new Simulador();
        Scanner ops = new Scanner(System.in);
        int num;
        menu();

        for(int i = 0; i < 5; i++) {System.out.print(" ");}
        System.out.print("    ____\n");
        for(int i = 0; i < 5; i++) {System.out.print(" ");}
        System.out.print(" __/  |_ \\_\n");
        for(int i = 0; i < 5; i++) {System.out.print(" ");}
        System.out.print("|  _     _ ``.\n");
        for(int i = 0; i < 5; i++) {System.out.print(" ");}
        System.out.print("'-(_)---(_)--'\n\n\n");
        
        do {
            
            num = ops.nextInt();

            switch(num) {

            case 1: 

                if(teste.getQuantCar() != 20);
                break;

            case 2:

                break;
            
            case 3:

                break;

            case 4:

                break;

            case 5:

                break;

            case 6:

                break;

            case 7:

                break;

            case 8:

                break;

            case 9:

                break;

            case 10:

                break;

            case 11:

                break;
                    
            case 12:

                break;

            case 13:

                break;
            }


        } while(num != 13);

        ops.close();
    }

    public static void menu() {

        System.out.println("\tSimulador de Corrida de Veículos\n");
        System.out.println("1 - Incluir veículo");
        System.out.println("2 - Remover veículo");
        System.out.println("3 - Abastecer veículo");
        System.out.println("4 - Movimentar um veículo");
        System.out.println("5 - Movimentar todos os veículos");
        System.out.println("6 - Imprimir todos os dados de um veículo");
        System.out.println("7 - Imprimir todos os dados de todos os veículos");
        System.out.println("8 - Esvaziar/Calibrar um pneu específico");
        System.out.println("9 - Esvaziar/Calibrar todos os pneus de um veículo específico");
        System.out.println("10 - Imprimir pista de corrida");
        System.out.println("11 - Gravar veículos em arquivo");
        System.out.println("12 - Ler veículos do arquivo");
        System.out.println("13 - Sair da aplicação");

    }
}
