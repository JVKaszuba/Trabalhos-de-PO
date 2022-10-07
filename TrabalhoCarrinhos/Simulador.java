package TrabalhoCarrinhos;

import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class Simulador{
																		//Atributos
    private static Carro[] car = new Carro[20];
    private static int quantCar = 0;
																		//Getters
    public int getQuantCar() {

        return quantCar;
    }

    private Carro getCar(int num){
            return car[num];
    }
																		//Setters
    private int setCar() {
        int i;
        for( i=0; i<20; i++)            //Cria um carro com posição(i) = ID, se não houver outro no lugar; 
            if(car[i]==null)
                break;
                    
        car[i] = new Carro(i);
        AddCar();
		return i;
    }
																		//Métodos
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
				else
					System.out.println("Veiculo adicionado com ID: " + setCar());

			break;

			case 2:                                                 //Remove um veiculo;
				
				if(quantCar == 0){									//Verifica se não há carros;
					System.out.println("Não há carros na Pista. ");	
					break;
				}
				do{       											//Verifica se o carro existe;
					dd = 0;
					System.out.print("\nQual o ID do veiculo: ");   
					num = teclado.nextInt();

					if(num < 0 || num > 19 || car[num] == null){
						System.out.println("Valor invalido. ");
						dd = 99;
					}
							
				}while(dd == 99);
				
				System.out.println("Veiculo com ID " + car[num].getId() + " removido. ");
				RemoveCar(num);
					
			break;
			
			case 3:                                                 //Abastece um veiculo;
				
				if(quantCar == 0){									//Verifica se não há carros;
					System.out.println("Não há carros na Pista. ");
					break;
				}    
				do{        											//Verifica se o carro existe;
					
					dd = 0;
					System.out.print("\nQual o ID do veiculo: ");   
					num = teclado.nextInt();

					if(num < 0 || num > 19 || car[num] == null){
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

				if(car[num].getCombustivel() + num2 > 55)
					num2 = 55 - car[num].getCombustivel();

				car[num].abastece(num2);
				System.out.println("Veiculo com ID " + car[num].getId() + " abastecido com " + num2 + " Litros de gasolina ");                         

			break;

			case 4:														//Faz um veiculo andar;
				
				if(quantCar == 0){										//Verifica se não há carros;
					System.out.println("Não há carros na Pista. ");
					break;
				}
				do{       												//Verifica se o carro existe;
							
					System.out.print("\nQual o ID do veiculo: ");   
					num = teclado.nextInt();

					if(car[num] == null)                            
						System.out.println("Valor invalido. ");
						
				}while(car[num]==null);

				car[num].andaCarro();

			break;

			case 5:													//Movimenta todos os veiculos
			
				if(quantCar == 0){									//Verifica se não há carros;
					System.out.println("Não há carros na Pista. ");
					break;
				}	
				for( i = 0; i < 20; i++)
						if(getCar(i) != null)					//Caso o carro exista, ele anda;
							car[i].andaCarro();
		
			break;

			case 6:                                                 //Imprime os Status de um veiculo;
			
				if(quantCar == 0){									//Verifica se não há carros;
					System.out.println("Não há carros na Pista. ");
					break;
				}    
				do{       											//Verifica se o carro existe;
							
					dd = 0;
					System.out.print("\nQual o ID do veiculo: ");   
					num = teclado.nextInt();

					if(num < 0 || num > 19 || car[num] == null){
						System.out.println("Valor invalido. ");
						dd = 99;
					}
							
				}while(dd == 99);

				System.out.println("\n===== Status =====");
				getCar(num).status();
				
			break;

			case 7:                                                 //Imprime os Status de todos os veiculos;
			
				if(quantCar == 0){									//Verifica se não há carros;
					System.out.println("Não há carros na Pista. ");
					break;
				}    
				for(i = 0; i < 20; i++){
						if(getCar(i) != null){						//Caso o carro exista, imprime o Status;
							System.out.println("\n===== Status =====");
							getCar(i).status();
						}    
					}
					
			break;

			case 8:                                                 //Esvaziar/Calibrar Pneu;
			
				if(quantCar == 0){									//Verifica se não há carros;
					System.out.println("Não há carros na Pista. ");
					break;
				}    
				do{       											//Verifica se o carro existe;
							
					dd = 0;
					System.out.print("\nQual o ID do veiculo: ");   
					num = teclado.nextInt();

					if(num < 0 || num > 19 || car[num] == null){
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
					
				if(dd == 1){										//Calibra o Pneu;
					do{
						System.out.print("\nQual o numero do pneu: (0-3)");
						npneu = teclado.nextInt();                  //Escolhe qual Pneu fazer a operação;
						if(npneu < 0 || npneu > 4)
							System.out.print("Valor invalido. ");

					}while(npneu < 0 || npneu > 3);
					
					car[num].calibraPneu(npneu);                   
				}
				else{                                             	//Esvazia o Pneu;
					do{
						System.out.print("\nQual o numero do pneu: (0-3)");
						npneu = teclado.nextInt();              	//Escolhe qual Pneu fazer a operação;
						if(npneu < 0 || npneu > 4)                                   
							System.out.print("Valor invalido. ");

					}while(npneu < 0 || npneu> 3);
					
					car[num].esvaziaPneu(npneu);                
				}
			
			break;

			case 9:                                                 //Esvaziar/Calibrar veiculo;
				
				if(quantCar == 0){									//Verifica se não há carros;
					System.out.println("Não há carros na Pista. ");
					break;
				}    
				do{       											//Verifica se o Veiculo existe;
									
					dd = 0;
					System.out.print("\nQual o ID do veiculo: ");   
					num = teclado.nextInt();

					if(num < 0 || num > 19 || car[num] == null){
						System.out.println("Valor invalido. ");
						dd = 99;
					}
							
				}while(dd == 99);

				do{    

					System.out.print("\nCalibrar(1) ou Esvaziar(0): ");
					dd = teclado.nextInt();
					if(dd < 0 || dd > 1)                            //Escolhe entre Calibrar/Esvaziar;
						System.out.print("Valor invalido. ");

				}while(dd < 0 || dd > 1);

				if(dd == 1 )                                       
					car[num].calibraCarro();
				else                                              
					car[num].esvaziaCarro();

			break;

			case 10:
				
				if(quantCar == 0){									//Verifica se não há carros;
					System.out.println("Não há carros na Pista. ");
					break;
				}

				for(i = 0; i < 20; i++) {							//Imprime todos os carros na pista		
					if(car[i] != null) {	
						car[i].desenhaCarro();
					}		
				}

			break;

			case 11:

				if(quantCar == 0){
					System.out.println("Não há carros na Pista. ");
					break;
				}
				carroGravar(car);

			break;
					
			case 12:

				carroLer(car);

			break;
			
			case 13:
				System.out.println("Fim ");
				teclado.close();
			break;
			}		
		}

	private void carroLer(Carro car[]) {
		File lista = new File("Lista.dat");

		try{
			FileInputStream fin = new FileInputStream(lista);
			ObjectInputStream oin = new ObjectInputStream(fin);

			Carro[] listaArq = (Carro[])oin.readObject();
			oin.close();
			fin.close();

			for(Carro p :listaArq){
				if(p != null)
					p.status();
			}
		}
		catch(Exception ex){
		System.out.println("Erro: " + ex.toString());
		}
		
    }
	
	private void carroGravar(Carro car[]) {

		File arquivo = new File("Lista.dat");
		try{
			FileOutputStream fout = new FileOutputStream(arquivo);
			ObjectOutputStream oos = new ObjectOutputStream(fout);

			oos.writeObject(car);
			oos.flush();
			oos.close();
			fout.close();
		}
		catch(Exception ex){
			System.out.println("Erro: " + ex.toString());
		}
	}
}
