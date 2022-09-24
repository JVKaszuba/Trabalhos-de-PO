package TrabalhoCarrinhos;

import java.util.Scanner;

public class UsaCarro {
    public static void main(String[] args) {

        System.out.print("Numero de carros: ");
        Scanner teclado = new Scanner(System.in);
        int n = teclado.nextInt();

        Carro carros[] = new Carro[n];
        int list[] = new int[n];
        
            System.out.print("Número de rodas: ");
           // teclado = new Scanner(System.in);
            int rodas = teclado.nextInt();
        
        for(int i = 0; i < n; i++) {

            carros[i] = new Carro(rodas);
            list[i] = carros[i].getId();

            //teste para gerar id unico
            if(i>0)
                for(int j=0; j<i; j++){
                    if((carros[i].getId() == list[j])){
                        System.out.println(" ok " +carros[i].getId() + " "+list[j]);
                        carros[i] = new Carro(rodas);
                        j=0;
                    }
                }
            //carros[i].status();
            
            System.out.println(carros[i].getId());
        }  
        teclado.close();
        }
    }

