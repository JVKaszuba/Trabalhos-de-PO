import java.util.Arrays;

public abstract class Veiculo {
    private int id;
    private int distanciaPercorrida;
    private int quatRodas;
    private Roda Rodas[] = new Roda[quatRodas];

    //Construtor;
    public Veiculo(int id, int quatRodas) {
        this.setId(id);
        this.setDistanciaPercorrida(0); 
        this.setQuatRodas(quatRodas);
        for(int i = 0; i < quatRodas; i++)                      
            this.roda[i] = new Roda(); 
    }

    //Getters;
    public int getId() {
        return this.id;
    }
    public int getDistanciaPercorrida() {
        return this.distanciaPercorrida;
    }
    public int getQuatRodas() {
        return this.quatRodas;
    }
    public  Boolean getRodas(int num) {
        return this.roda[num].getCalibragem();
    }


    //Setters;
    public void setId(int id) {
        this.id = id;
    }
    public void setDistanciaPercorrida(int distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }
    public void setQuatRodas(int quatRodas) {
        this.quatRodas = quatRodas;
    }


    //Metodos;
    public abstract void mover();
    public abstract void desenhaCarro();

    public void calibraPneu(int npneu) {

        if(roda[npneu].getCalibragem() == false) {roda[npneu].setCalibragem(true);}
    }

    public void esvaziaPneu(int npneu) {

        if(roda[npneu].getCalibragem() == true) {roda[npneu].setCalibragem(false);}
    }

    public String toString() {
        return "Veiculo [id=" + id + ", distanciaPerc=" + distanciaPercorrida + ", Rodas=" + Arrays.toString(Rodas)
                + ", quatRodas=" + quatRodas + "]";
    }
    public void calibraVeiculo(int quatRodas) {

        for(int i = 0; i < quatRodas; i++) {this.calibraPneu(i);}
    }

    public void esvaziaVeiculo(int quatRodas) {

        for(int i = 0; i < quatRodas; i++) {this.esvaziaPneu(i);}
    }

}
