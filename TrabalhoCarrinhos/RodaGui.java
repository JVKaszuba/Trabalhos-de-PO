package TrabalhoCarrinhos;

import java.util.Random;

public class RodaGui {
//Atributos
    private Boolean calibragem;

//Construtor
    public RodaGui(){
        Random rn = new Random();
        this.setCalibragem(rn.nextBoolean());
    }
//Getters
    public Boolean getCalibragem(){
        return this.calibragem;
    }
//Setters
    private void setCalibragem(Boolean val){
        this.calibragem = val; 
    }
}
