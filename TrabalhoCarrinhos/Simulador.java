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

        //car[quantCar] = new Carro();
    }


}
