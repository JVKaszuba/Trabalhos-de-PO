import java.util.Scanner;

public class Simulador2 {
    private static Veiculo[] veic = new Veiculo[20];
    private static int quantCar = 0;

    public static int getQuantCar() {

        return quantCar;
    }
    private static int setCar(char Tipo) {
        int i;
        for( i=0; i<20; i++)            //Cria um carro com posição(i) = ID, se não houver outro no lugar; 
            if(veic[i]==null)
                break;
        if(Tipo == 'E'){
             veic[i] = new Esportivo(i);
        }         
        AddCar();
		return i;
    }
    private static void AddCar() {

        quantCar++;
    }
    public static void Menu(int val){
        Scanner teclado = new Scanner(System.in);
        int num, i, npneu, dd;
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
				
                System.out.println("Escolha um Tipo (B, M, C, E)");
					      											//Verifica se o carro existe; 
					Tipo = teclado.next().charAt(0);
					setCar(Tipo);
					/*if(num < 0 || num > 19 || car[num] == null){
						System.out.println("Valor invalido. ");
						dd = 99;
					}*/
							
				if(getQuantCar() > 19){
					System.out.println("Numero max atingido. ");
					break;
				}
				else
					System.out.println("Veiculo adicionado com ID: " + setCar(Tipo));

			break;
            }
    }
}
