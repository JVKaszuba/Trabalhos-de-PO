import java.util.Scanner;

public class Simulador2 {
    private static Veiculo[] veic = new Veiculo[20];
    private static int quantCar = 0;

    
    private static int setCar(char Tipo) {
        int i;
        for( i=0; i<20; i++)            //Cria um carro com posição(i) = ID, se não houver outro no lugar; 
            if(veic[i]==null)
                break;

        switch (Tipo){
            case 'B':
                veic[i] = new Bicileta(i);
            break;
            case 'M':
                veic[i] = new Motocicleta(i);
            break;
            case 'C':
                veic[i] = new CarroPasseio(i);
            break;
            case 'E':
                veic[i] = new Esportivo(i);
            break;
        }
        AddCar();
		return i;
    }
    public static int getQuantCar() {

        return quantCar;
    }
    private static void AddCar() {

        quantCar++;
    }
    private static Veiculo getCar(int num){
        return veic[num];
}
    private static void RemoveCar(int num) {

    veic[num] = null;
    quantCar--;
}
    
    public static void Menu(int val){
        Scanner teclado = new Scanner(System.in);
        int i, dd, num, npneu;
        float num2;

        char Tipo;
            switch(val) {
            case 0:                                                 //Caso base;
                
                System.out.println();
                System.out.println("\tSimulador de Corrida de Veículos\n");
                System.out.println("00 - Menu");
                System.out.println("01 - Incluir veículo");
                System.out.println("02 - Remover veículo");
                System.out.println("03 - Abastecer veículo");
                System.out.println("04 - Movimentar um veículo");
                System.out.println("05 - Movimentar todos os veículos por tipo");
                System.out.println("06 - Movimentar todos os veículos");
                System.out.println("07 - Imprimir todos os dados de todos os veículos");
                System.out.println("08 - Imprimir dados de veículos por tipo");
                System.out.println("09 - Esvaziar/Calibrar um pneu específico");
                System.out.println("10 - Calibrar todos os pneus de veículos por tipo");
                System.out.println("11 - Esvaziar todos os pneus de veículos por tipo");
                System.out.println("12 - Imprimir pista de corrida");
                System.out.println("13 - Gravar veículos em arquivos");
                System.out.println("14 - Ler veículos em arquivos");
                System.out.println("15 - Sair da aplicação");
                

            break;
			case 1:                                                 //Adiciona um veiculo;
                do{

                    dd = 0;    
                    System.out.print("Escolha um Tipo (B, M, C, E): ");											//Verifica se o carro existe; 
                    Tipo = teclado.next().toUpperCase().charAt(0);

                    if( Tipo !='B' && Tipo !='M' && Tipo !='C' && Tipo !='E' ){ //Verifica se o Tipo eh valido
                            System.out.println("Valor invalido. ");
                            dd = 99;
                        }
                        
                }while(dd == 99);
					
				if(getQuantCar() > 19){
					System.out.println("Numero max atingido. ");                //Verifica se tem o Maximo de veiculos
					break;
				}
				else
					System.out.println("Veiculo adicionado com ID: " + setCar(Tipo));   //Adiciiona o Veiculo

			break;
            case 2:                                                 //Remove um veiculo;
				
				if(quantCar == 0){									//Verifica se não há veiculos;
					System.out.println("Não há carros na Pista. ");	
					break;
				}
				do{       											//Verifica se o veiculo existe;
					dd = 0;
					System.out.print("\nQual o ID do veiculo: ");   
					num = teclado.nextInt();

					if(num < 0 || num > 19 || veic[num] == null){
						System.out.println("Valor invalido. ");
						dd = 99;
					}
							
				}while(dd == 99);
				
				System.out.println("Veiculo com ID " + veic[num].getId() + " removido. ");  //Remove o veiculo
				RemoveCar(num);
					
			break;
            case 3:                                                 //Abastece um veiculo;
				if(quantCar == 0){									//Verifica se não há veiculos;
					System.out.println("Não há carros na Pista. ");
					break;
				}    
				do{        											//Verifica se o veiculo existe e se tem combustivel;
					
					dd = 0;
					System.out.print("\nQual o ID do veiculo: ");   
					num = teclado.nextInt();

					if(num < 0 || num > 19 || veic[num] == null || veic[num] instanceof Bicileta){
						System.out.println("Valor invalido. ");
						dd = 99;
					}
							
				}while(dd == 99);
				
				do{ 												//Valida para abastecer valores positivos

					dd = 0;
					System.out.print("Quantidade de gasolina em L: ");
					num2 = teclado.nextFloat();
					if(num2 < 0){
						System.out.println("Valor invalido. ");
						dd = 99;
					}

				}while(dd == 99);
                
				if(((VeiculoMotorizado) veic[num]).getCombustivel() + num2 > 55)
					num2 = 55 - ((VeiculoMotorizado) veic[num]).getCombustivel();

                ((VeiculoMotorizado) veic[num]).abastece(num2);
				System.out.println("Veiculo com ID " + veic[num].getId() + " abastecido com " + num2 + " Litros de gasolina ");                         

			break;
            case 4:														//Faz um veiculo andar;
				
				if(quantCar == 0){										//Verifica se não há carros;
					System.out.println("Não há carros na Pista. ");
					break;
				}
				do{       												//Verifica se o carro existe;
							
					System.out.print("\nQual o ID do veiculo: ");   
					num = teclado.nextInt();

					if(veic[num] == null)                            
						System.out.println("Valor invalido. ");
						
				}while(veic[num]==null);

				veic[num].mover();

			break;
            case 5:													//Movimenta todos os veiculos
                

				if(quantCar == 0){									//Verifica se não há carros;
					System.out.println("Não há carros na Pista. ");
					break;
                }

                do{

                    dd = 0;    
                    System.out.print("Escolha um Tipo (B, M, C, E): ");											//Verifica se o carro existe; 
                    Tipo = teclado.next().toUpperCase().charAt(0);

                    if( Tipo !='B' && Tipo !='M' && Tipo !='C' && Tipo !='E' ){
                            System.out.println("Valor invalido. ");
                            dd = 99;
                        }
                        
                }while(dd == 99);

				for( i = 0; i < 20; i++)
						if(getCar(i) != null && getCar(i).getTipo() == Tipo)				//Caso o carro exista, ele anda;
							veic[i].mover();
		
			break;
            case 6:													//Movimenta todos os veiculos
			
				if(quantCar == 0){									//Verifica se não há carros;
					System.out.println("Não há carros na Pista. ");
					break;
				}	
				for( i = 0; i < 20; i++)
						if(getCar(i) != null)					//Caso o carro exista, ele anda;
							veic[i].mover();
		
			break;
            case 7:                                                 //Imprime os Status de todos os veiculos;
			
				if(quantCar == 0){									//Verifica se não há carros;
					System.out.println("Não há carros na Pista. ");
					break;
				}    
				for(i = 0; i < 20; i++){
						if(getCar(i) != null){						//Caso o carro exista, imprime o Status;
							System.out.println("\n===== Status =====");
							System.out.println(getCar(i).toString());
                            
						}    
					}
					
			break;
            case 8:                                                 //Imprime os Status de todos os veiculos;
			
				if(quantCar == 0){									//Verifica se não há carros;
					System.out.println("Não há carros na Pista. ");
					break;
				}
                do{

                    dd = 0;    
                    System.out.print("Escolha um Tipo (B, M, C, E): ");											//Verifica se o carro existe; 
                    Tipo = teclado.next().toUpperCase().charAt(0);

                    if( Tipo !='B' && Tipo !='M' && Tipo !='C' && Tipo !='E' ){
                            System.out.println("Valor invalido. ");
                            dd = 99;
                        }
                        
                }while(dd == 99);
				for(i = 0; i < 20; i++){
						if(getCar(i) != null && getCar(i).getTipo() == Tipo){						//Caso o carro exista, imprime o Status;
							System.out.println("\n===== Status =====");
							System.out.println(getCar(i).toString());
                            
						}    
					}
					
			break;
            case 9:                                                 //Esvaziar/Calibrar Pneu;
			
            if(quantCar == 0){									//Verifica se não há carros;
                System.out.println("Não há carros na Pista. ");
                break;
            }    
            do{       											//Verifica se o carro existe;
                        
                dd = 0;
                System.out.print("\nQual o ID do veiculo: ");   
                num = teclado.nextInt();

                if(num < 0 || num > 19 || veic[num] == null){
                    System.out.println("Valor invalido. ");
                    dd = 99;
                }
                        
            }while(dd == 99);
            
            do{    												//Escolhe entre Calibrar/Esvaziar;
                System.out.print("\nCalibrar(1) ou Esvaziar(0): ");
                dd = teclado.nextInt();
                if(dd < 0 || dd > 1)                            
                    System.out.print("Valor invalido. ");

            }while(dd < 0 || dd > 1);

                int numax;
                if(veic[num].getTipo() == 'B' ||veic[num].getTipo() == 'M')
                    numax = 2;
                else
                    numax = 4;
                
            if(dd == 1){										//Calibra o Pneu;
                do{
                    System.out.print("\nQual o numero do pneu: ");
                    npneu = teclado.nextInt();                  //Escolhe qual Pneu fazer a operação;
                    if(npneu < 0 || npneu > numax)
                        System.out.print("Valor invalido. ");

                }while(npneu < 0 || npneu > numax-1);
                
                veic[num].calibraPneu(npneu);                   
            }
            else{                                             	//Esvazia o Pneu;
                do{
                    System.out.print("\nQual o numero do pneu: ");
                    npneu = teclado.nextInt();              	//Escolhe qual Pneu fazer a operação;
                    if(npneu < 0 || npneu > numax)                                   
                        System.out.print("Valor invalido. ");

                }while(npneu < 0 || npneu> numax-1);
                
                veic[num].esvaziaPneu(npneu);                
            }
        
            break;
            case 10:                                                 //Esvaziar/Calibrar veiculo;
				
				if(quantCar == 0){									//Verifica se não há carros;
					System.out.println("Não há carros na Pista. ");
					break;
				}    
				do{
                    dd = 0;    
                    System.out.print("Escolha um Tipo (B, M, C, E): ");											//Verifica se o carro existe; 
                    Tipo = teclado.next().toUpperCase().charAt(0);

                    if( Tipo !='B' && Tipo !='M' && Tipo !='C' && Tipo !='E' ){
                            System.out.println("Valor invalido. ");
                            dd = 99;
                        }
                        
                }while(dd == 99);

                if(Tipo == 'B' || Tipo == 'M')
                    numax = 2;
                else
                    numax = 4;

                for(i = 0; i < 20; i++){
                    if(getCar(i) != null && getCar(i).getTipo() == Tipo){	
                        
                        veic[i].calibraVeiculo(numax);
                        System.out.println(getCar(i).toString());
                        
                    }    
                }

			break;
            case 11:                                                 //Esvaziar/Calibrar veiculo;
				
				if(quantCar == 0){									//Verifica se não há carros;
					System.out.println("Não há carros na Pista. ");
					break;
				}    
				do{
                    dd = 0;    
                    System.out.print("Escolha um Tipo (B, M, C, E): ");											//Verifica se o carro existe; 
                    Tipo = teclado.next().toUpperCase().charAt(0);

                    if( Tipo !='B' && Tipo !='M' && Tipo !='C' && Tipo !='E' ){
                            System.out.println("Valor invalido. ");
                            dd = 99;
                        }
                        
                }while(dd == 99);

                if(Tipo == 'B' || Tipo == 'M')
                    numax = 2;
                else
                    numax = 4;

                for(i = 0; i < 20; i++){
                    if(getCar(i) != null && getCar(i).getTipo() == Tipo){	
					
                        veic[i].esvaziaVeiculo(numax);
                        System.out.println(getCar(i).toString());
                        
                    }    
                }

			break;
            case 12:
				
				if(quantCar == 0){									//Verifica se não há carros;
					System.out.println("Não há carros na Pista. ");
					break;
				}

				for(i = 0; i < 20; i++) {							//Imprime todos os carros na pista		
					if(veic[i] != null) {	
						veic[i].desenhaVeiculo();
					}		
				}

			break;
            case 13:
            case 14:

			case 15:
            System.out.println("Fim ");
            teclado.close();
            break;
            }
    }
}
