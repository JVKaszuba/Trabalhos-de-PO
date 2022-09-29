package TrabalhoCarrinhos;

import java.util.Scanner;

public class Simulador {
    
    private static Carro[] car = new Carro[20];
    private static int quantCar = 0;

    public Simulador() {

        //AddCar(); //está dando conflito, pois inicia somando 1 em quantCar sem o usuario ter pedido;
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
    private void setCar() {
        int i;
        for( i=0; i<20; i++)            //Cria um carro com posição(i) = ID, se não houver outro no lugar; 
            if(car[i]==null)
                break;
                    
        car[i] = new Carro(i);
        AddCar();
    }

//Funções
    private static void AddCar() {

        quantCar++;
    }
    private static void RemoveCar(int num) {

        car[num] = null;
        quantCar--;
    }


    public void usaMenu(int val){
            Scanner teclado = new Scanner(System.in);
			int num, i, npneu, dd;
			float num2;

			    switch(val) {
			    case 0:                                                 //Caso base;
			        System.out.println();
			        System.out.println("\tSimulador de Corrida de Veículos\n");
			        System.out.println("00 - Menu");
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
			            System.out.println("Veiculo adicionado");
			            
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
				do{       
			            
					System.out.print("\nQual o ID do veiculo: ");   
					num = teclado.nextInt();

					if(car[num] == null)                            //Verifica se o carro existe;
						System.out.println("Valor invalido. ");
						
				}while(car[num]==null);
					car[num].andaCarro();
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

			        System.out.println("\n===== Status =====");
			        getCar(num).status();
			    break;

			    case 7:                                                 //Imprime os Status de todos os veiculos;
			        for( i=0; i<20; i++){
			            if(getCar(i) != null){
			                System.out.println("\n===== Status =====");
			                getCar(i).status();
			            }    
			        }
			            
			    break;

			    case 8:                                                 //Esvaziar/Calibrar Pneu;
			        do{       
			                    
			            System.out.print("\nQual o ID do veiculo: ");   
			            num = teclado.nextInt();
			            
			            if(car[num] == null)                            //Verifica se o carro existe;
			                System.out.println("Valor invalido. ");

			        }while(car[num]==null);
			        
			        do{    
			            System.out.print("\nCalibrar(1) ou Esvaziar(0): ");
			            dd = teclado.nextInt();
			            if(dd < 0 || dd > 1)                            //Escolhe entre Calibrar/Esvaziar;
			                System.out.print("Valor invalido. ");

			        }while(dd < 0 || dd > 1);
			            
			        if(dd==1){                                           //Calibra o Pneu
			            do{
			                System.out.print("\nQual o numero do pneu: (0-3)");
			                npneu = teclado.nextInt();                  //Escolhe qual Pneu fazer a operação;
			                if(npneu < 0 || npneu > 4)
			                    System.out.print("Valor invalido. ");
			            }while(npneu < 0 || npneu > 3);
			            
			            car[num].calibraPneu(npneu);                   
			        }
			        else{                                             //Esvazia o Pneu;
			            do{
			                System.out.print("\nQual o numero do pneu: (0-3)");
			                npneu = teclado.nextInt();               //Escolhe qual Pneu fazer a operação;
			                if(npneu < 0 || npneu > 4)                                   
			                    System.out.print("Valor invalido. ");
			                }while(npneu < 0 || npneu> 3);
			            
			            car[num].esvaziaPneu(npneu);                
			        }
			    
			    break;

			    case 9:                                                 //Esvaziar/Calibrar veiculo;
			        do{       
			                        
			            System.out.print("\nQual o ID do veiculo: ");   
			            num = teclado.nextInt();
			            
			            if(car[num] == null)                            //Verifica se o Veiculo existe;
			                System.out.println("Valor invalido. ");

			        }while(car[num]==null);
			        do{    
			            System.out.print("\nCalibrar(1) ou Esvaziar(0): ");
			            dd = teclado.nextInt();
			            if(dd < 0 || dd > 1)                            //Escolhe entre Calibrar/Esvaziar;
			                System.out.print("Valor invalido. ");

			        }while(dd < 0 || dd > 1);
			        if(dd == 1 )                                        //Calibra o Veiculo;
			            car[num].calibraCarro();
			        else                                                //Esvazia o Veiculo
			            car[num].esvaziaCarro();

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

