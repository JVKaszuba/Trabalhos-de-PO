package TrabalhoCarrinhos;

import java.util.Scanner;

public class UsaSimulador {  
    
    public static void main(String[] args) {
        
        Simulador simulado = new Simulador();
        Scanner teclado = new Scanner(System.in);

            int opc=0;

            //erro de validação nas funções para  0 < n > 19 (tamanho do vetor) car[num];
            do{ 
                simulado.usaMenu(opc);
                System.out.print("\nEscolha: ");
                opc = teclado.nextInt();

                if(opc < 0 || opc > 13){
                    do{
                        System.out.print("Opcao invalida, Digite outra: ");
                        opc = teclado.nextInt();
                    }while(opc < 0 || opc > 13);
                }
                
            }while(opc !=13);
            teclado.close();   

    }
}
