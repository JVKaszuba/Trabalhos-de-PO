import java.util.Random;

public abstract class VeiculoMotorizado extends Veiculo {
    //Atributos Static;
    private static double gastoMoto = 0.25;
    private static double gastoPasseio = 0.75;
    private static double gastoEsporte = 2.3;

    //Atributos;
    private float combustivel;
    private Boolean IPVA;
    private float valorIPVA;
    //Construtor;
        public VeiculoMotorizado(int id, int quantRodas, char string, float valorIPVA) {
            super(id, quantRodas, string);
            final Random rn = new Random();
            this.setCombustivel(2.5f);
            this.IPVA = rn.nextBoolean();
            this.valorIPVA = valorIPVA;
        }

    //Getters;
    public static double  getGastoEsporte() {
         return gastoEsporte;
     }
    public static double  getGastoPasseio() {
        return gastoPasseio;
    }
    public static double  getGastoMoto() {
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

    //
    public void setCombustivel(float combustivel) {
        this.combustivel = combustivel;
    }

    //Metodos
  
    public void abastece(float quantComb) {

        float quantMax = 55 - this.combustivel;

        if(quantComb <= quantMax) 
            this.combustivel += quantComb;
        
        else 
            this.combustivel += quantMax;
        
    }

    @Override
    public String toString() {
        return super.toString() + "\nCombustivel = " + combustivel + "\nIPVA = " + IPVA + "\nValorIPVA = " + valorIPVA;
    }

    public void pagaIPVA() {

        if(this.IPVA == false) {this.IPVA = true;}
    }
    
}
