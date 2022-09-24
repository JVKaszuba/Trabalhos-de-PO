package TrabalhoCarrinhos;

import java.util.Scanner;

public class UsaSimulador {
    
    public static void main(String[] args) {
        
        Simulador simulado = new Simulador();
        Scanner teclado = new Scanner(System.in);
        int i;

        /*if(true){                                  //Só para poder esconder o código com chaves
            for(i = 0; i < 5; i++) {System.out.print(" ");}
            System.out.print("    ____\n");
            for(i = 0; i < 5; i++) {System.out.print(" ");}
            System.out.print(" __/  |_ \\_\n");
            for(i = 0; i < 5; i++) {System.out.print(" ");}
            System.out.print("|  _     _ ``.\n");
            for(i = 0; i < 5; i++) {System.out.print(" ");}
            System.out.print("'-(_)---(_)--'\n\n\n");
            i=0;
        }
      */

        int opc = 0;
        // opcoẽs 1 e 7 funcionando;
        do{ 
            simulado.usaMenu(opc);
            System.out.print("\nEscolha: ");
            opc = teclado.nextInt();

            if(opc < 1 || opc > 13){               //Valida a opção escolhida
                do{
                    System.out.print("Opcao invalida, Digite outra: ");
                    opc = teclado.nextInt();
                }while(opc < 1 || opc > 13);
            }
            
        }while(opc !=13);
       
        teclado.close();
    }

}
