public class CarroPasseio extends VeiculoMotorizado implements IPVA{
    
    //Construtor;
    public CarroPasseio(int id) {
        super(id, 4, 'C');
    }

    //Metodos;
    @Override
    public void mover() {
        int flag = 0;
        for(int i = 0; i < 4; i++){
            if(this.getRodas(i) == false) {
                System.out.println("Veiculo "+ this.getId() + " as rodas não estão calibradas. ");       //  Verifica se as rodas estão calibradas;
                flag = 99;
                break;
            }
        }
        if(getIPVA() == false){
            flag = 99;
            System.out.println("Veiculo "+ this.getId() + " o IPVA não está pago. ");
        }
        if(getCombustivel() < 0.75*5){                                                                //Verifica se tem gasolina sufuciente
            flag = 99;
            System.out.println("Veiculo "+ this.getId() + " não possui gasolina sufuciente. ");
        }
        if(flag == 0){
            this.setDistanciaPercorrida(getDistanciaPercorrida() + 5);                                //Acrescenta Distancia Percorrida;
            this.setCombustivel(getCombustivel() - (float) 0.75*5);                                   //Gasta a gasolina para andar
        }
        else
            System.out.println("Não foi possivel mover. ");
    }

    @Override
    public void desenhaVeiculo() {
        System.out.print("    ____\n");
        System.out.print(" __/  |_ \\_\n");
        System.out.print("|  _     _``-.\n");
        System.out.print("'-(_)---(_)--'\n\n\n");
        
    }

    @Override
    public double calcularIPVA() {
        return valor_Base * cte_Passeio;
    }
    
}
