package TrabalhoCarrinhos;

import java.util.Random;

public class Roda {

                                                        //Atributos
    private Boolean calibragem;

                                                        //Construtor
    public Roda() {

        Random rn = new Random();
        this.setCalibragem(rn.nextBoolean());
    }

                                                        //Getters
    public Boolean getCalibragem() {

        return this.calibragem;
    }

                                                        //Setters
    public void setCalibragem(Boolean val) {
        
        this.calibragem = val; 
    }

                                                        //toString
    public String toString() {

        return "A roda está calibrada? " + this.getCalibragem();
    }
}
