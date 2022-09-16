package TrabalhoCarrinhos;

import java.util.Random;

public class Rodas {
    
    private boolean calibragem;

    public Rodas() {

        Random r = new Random();
        int i = r.nextInt(2);

        if(i == 1) {calibragem = true;}
        else{calibragem = false;}
    }

    public void setCalibragem(boolean calibragem) {

        this.calibragem = calibragem;
    }

    public boolean getCalibragem() {

        return calibragem;
    }

    public String toString() {

        String res;

        if(calibragem == true) {res = "está";}
        else {res = "não está";}
 
        return "O roda " + res + " calibrada";
    }
}
