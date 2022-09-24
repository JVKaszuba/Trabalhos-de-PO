package TrabalhoCarrinhos;

public class Simulador {
    
    private Carro[] car = new Carro[20];
    private static int quantCar = 0;

    public Simulador() {

        setQuantCar();
        setCar();
    }

//Getters

    public int getQuantCar() {

        return quantCar;
    }

//Setters

    private static void setQuantCar() {
        
        quantCar++;
    }

    private void setCar() {

        car[getQuantCar()] = new Carro(getQuantCar());
    }
    private Carro getCar(int num){
        return car[num];
    }
//Funções
    public void usaMenu(int val){
            switch(val) {
            case 0:
                System.out.println();
                System.out.println("\tSimulador de Corrida de Veículos\n");
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
            case 1: 
                if(this.getQuantCar() > 20){
                    System.out.println("Numero max atingido. ");
                    break;
                }
                    
                else{
                    setCar();
                    setQuantCar();
                    System.out.println("Veiculo adicionado. ");
                    
                }
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
                for(int i =1; i <getQuantCar(); i++){
                    System.out.println();
                    getCar(i).status();
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
