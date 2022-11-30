import java.util.Random;

public abstract class VeiculoMotorizado extends Veiculo {
    //Atributos Static;
    private static float gastoMoto;
    private static float gastoPasseio;
    private static float gastoEsporte;

    //Atributos;
    private float combustivel;
    private Boolean IPVA;
    private float valorIPVA;
    Random rn;
    //Construtor;
        public VeiculoMotorizado(int id, int quantRodas, String string) {
            super(id, quantRodas);
            this.setCombustivel(2.5f);
            this.IPVA = rn.nextBoolean();
            this.setValorIPVA(500); //FAZER CALCULOS PARA CADA VEICULO;
    }

    //Getters;
    public static float getGastoEsporte() {
         return gastoEsporte;
     }
    public static float getGastoPasseio() {
        return gastoPasseio;
    }
    public static float getGastoMoto() {
        return gastoMoto;
    }
    public float getCombustivel() {
        return this.combustivel;
    }
    public Boolean getIPVA() {
        return this.IPVA;
    }
    public float getValorIPVA() {
        return this.valorIPVA;
    }

    //Setters;
    public static void setGastoEsporte(float gastoEsporte) {
        VeiculoMotorizado.gastoEsporte = gastoEsporte;
    }   
    public static void setGastoPasseio(float gastoPasseio) {
        VeiculoMotorizado.gastoPasseio = gastoPasseio;
    }
    public static void setGastoMoto(float gastoMoto) {
        VeiculoMotorizado.gastoMoto = gastoMoto;
    }
    public void setCombustivel(float combustivel) {
        this.combustivel = combustivel;
    }
    public void setValorIPVA(float valor) {
        this.combustivel = valor; //FAZER OS CALCULOS PRA CADA;
    }

    //Metodos
    public abstract void ValorIPVA();
    public void abastece(float quantComb) {

        float quantMax = 55 - this.combustivel;

        if(quantComb <= quantMax) 
            this.combustivel += quantComb;
        
        else 
            this.combustivel += quantMax;
        
    }

    public String toString() {
        return "VeiculoMotorizado [combustive=" + combustivel + ", valorIPVA=" + valorIPVA + "]";
    }
    public void pagaIPVA() {

        if(this.IPVA == false) {this.IPVA = true;}
    }
    
}
