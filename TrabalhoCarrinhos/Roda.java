package TrabalhoCarrinhos;

import java.io.Serializable;
import java.util.Random;

public class Roda implements Serializable {

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
