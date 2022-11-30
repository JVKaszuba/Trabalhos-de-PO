
import java.util.Scanner;

public class UsaSimulador {
    public static void main(String[] args) {
    
        Scanner teclado = new Scanner(System.in);

        int opc = 0;

        do{ 
            Simulador2.Menu(opc);
            System.out.print("\nEscolha: ");     
            opc = teclado.nextInt();

            System.out.println();
            if(opc < 0 || opc > 13){
                do{
                    System.out.print("Opcao invalida, Digite outra: ");
                    opc = teclado.nextInt();
                }while(opc < 0 || opc > 13);
            }
            if(opc == 13)
                Simulador2.Menu(opc);
                
        }while(opc != 13);
        teclado.close();   

    }
}
