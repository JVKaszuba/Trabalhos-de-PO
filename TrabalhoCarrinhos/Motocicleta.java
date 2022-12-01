public class Motocicleta extends VeiculoMotorizado {

    //Construtor;
    public Motocicleta(int id) {
        super(id, 2, 'M', (float) (500*0.75));

    }

    //Metodos;
    @Override
    public void mover() {
        int flag = 0;
        for(int i = 0; i < 2; i++){
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
        if(getCombustivel() < 0.25*3){                                                                      //Verifica se tem gasolina sufuciente
            flag = 99;
            System.out.println("Veiculo "+ this.getId() + " não possui gasolina sufuciente. ");
        }
        if(flag == 0){
            this.setDistanciaPercorrida(getDistanciaPercorrida() + 3);                                      //Acrescenta Distancia Percorrida;
            this.setCombustivel(getCombustivel() - (float) 0.25*3);                                         //Gasta a gasolina para andar;
        }
        else
            System.out.println("Não foi possivel mover. ");
    }

    @Override
    public void desenhaVeiculo() {
        System.out.print("   ,_oo\n");
        System.out.print(".-/c-//::\n");  
        System.out.print("(_)'==(_)\n");
        
    }
    
}
