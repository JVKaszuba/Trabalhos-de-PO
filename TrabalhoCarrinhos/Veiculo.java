import java.io.Serializable;

public abstract class Veiculo implements Serializable{
    private int id;
    private int distanciaPercorrida;
    private int quatRodas;
    private Roda roda[] = new Roda[4];
    private char tipo;

    //Construtor;
    public Veiculo(int id, int quatRodas, char tipo) {
        this.setId(id);
        this.setDistanciaPercorrida(0); 
        this.setQuatRodas(quatRodas);
        for(int i = 0; i < quatRodas; i++)                      
            this.roda[i] = new Roda(); 
        this.setTipo(tipo);
    }

    //Getters;
    public char getTipo(){
        return this.tipo;
    }
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
    public void setTipo(char tipo){
        this.tipo = tipo;
    }
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
    public abstract void desenhaVeiculo();


    public void calibraPneu(int npneu) {

        if(roda[npneu].getCalibragem() == false) {roda[npneu].setCalibragem(true);}
    }

    public void esvaziaPneu(int npneu) {

        if(roda[npneu].getCalibragem() == true) {roda[npneu].setCalibragem(false);}
    }
    
    public String toString() {
    return  "Tipo = " + tipo + "\nID = " + id + "\nDistanciaPercorrida = " + distanciaPercorrida + "\nQuatRodas = " + quatRodas;
    }

    public void calibraVeiculo(int quatRodas) {

        for(int i = 0; i < quatRodas; i++) {this.calibraPneu(i);}
    }

    public void esvaziaVeiculo(int quatRodas) {

        for(int i = 0; i < quatRodas; i++) {this.esvaziaPneu(i);}
    }

}
