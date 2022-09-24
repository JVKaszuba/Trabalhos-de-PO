package TrabalhoCarrinhos;

import java.util.Scanner;

public class Simulador {
    
    private static Carro[] car = new Carro[20];
    private static int quantCar = 0;

    public Simulador() {

        //AddCar();
        //setCar();
    }

//Getters

    public int getQuantCar() {

        return quantCar;
    }

    private Carro getCar(int num){
            return car[num];
    }

//Setters

//Funções
    private static void AddCar() {

        quantCar++;
    }
    private static void RemoveCar(int num) {
        car[num] = null;
        quantCar--;
    }

    private void setCar() {
        int i;
        for( i=0; i<20; i++)
            if(car[i]==null)
                break;
                
        car[i] = new Carro(i);
    }


    public void usaMenu(int val){
        Scanner teclado = new Scanner(System.in);
        int num, i;
        float num2;
            switch(val) {
            case 0:                                                 //Caso base;
                System.out.println();
                System.out.println("\tSimulador de Corrida de Veículos\n");
                System.out.println("00 - Meenu");
                System.out.println("01 - Incluir veículo");
                System.out.println("02 - Remover veículo");
                System.out.println("03 - Abastecer veículo");
                System.out.println("04 - Movimentar um veículo");
                System.out.println("05 - Movimentar todos os veículos");
                System.out.println("06 - Imprimir todos os dados de um veículo");
                System.out.println("07 - Imprimir todos os dados de todos os veículos");
                System.out.println("08 - Esvaziar/Calibrar um pneu específico");
                System.out.println("09 - Esvaziar/Calibrar todos os pneus de um veículo específico");
                System.out.println("10 - Imprimir pista de corrida");
                System.out.println("11 - Gravar veículos em arquivo");
                System.out.println("12 - Ler veículos do arquivo");
                System.out.println("13 - Sair da aplicação");
            break;
            case 1:                                                 //Adiciona um veiculo;
                if(this.getQuantCar() > 19){
                    System.out.println("Numero max atingido. ");
                    break;
                }
                    
                else{
                    setCar();
                    AddCar();
                    System.out.println("Veiculo adicionado. ");
                    
                }
            break;

            case 2:                                                 //Remove um veiculo;
            do{       
                    
                System.out.print("\nQual o ID do veiculo: ");   
                num = teclado.nextInt();

                if(car[num] == null)                            //Verifica se o carro existe;
                    System.out.println("Valor invalido. ");
                    
            }while(car[num]==null);

                RemoveCar(num);

            break;
            
            case 3:                                                 //Abastece um veiculo;
                do{       
                    
                    System.out.print("\nQual o ID do veiculo: ");   
                    num = teclado.nextInt();

                    if(car[num] == null)                            //Verifica se o carro existe;
                        System.out.println("Valor invalido. ");
                        
                }while(car[num]==null);
                
                System.out.print("Quantidade de gasolina em L: ");
                num2 = teclado.nextFloat();
                car[num].abastece(num2);                            //Abastece o carro escolhido;

            break;

            case 4:

                break;

            case 5:

                break;

            case 6:                                                 //Imprime os Status de um veiculo;
                do{       
                        
                    System.out.print("\nQual o ID do veiculo: ");   
                    num = teclado.nextInt();
                    
                    if(car[num] == null)                            //Verifica se o carro existe;
                        System.out.println("Valor invalido. ");
 
                }while(car[num]==null);

                if(getCar(num) != null){
                    System.out.println("\n===== Status =====");
                    getCar(num).status();
                }
                break;

            case 7:                                                 //Imprime os Status de todos so veiculos;
                for( i=0; i<20; i++){
                    if(getCar(i) != null){
                        System.out.println("\n===== Status =====");
                        getCar(i).status();
                    }    
                }
                    
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
            }
    }

}
