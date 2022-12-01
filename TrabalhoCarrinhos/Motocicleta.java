public class Motocicleta extends VeiculoMotorizado {

    public Motocicleta(int id) {
        super(id, 2, 'M', (float) (500*0.75));

    }

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
        if(getCombustivel() < 0.25){
            flag = 99;
            System.out.println("Veiculo "+ this.getId() + " não possui gasolina sufuciente. ");
        }
        if(flag == 0){
            this.setDistanciaPercorrida(getDistanciaPercorrida() + 10);  //Acrescenta Distancia Percorrida;
            this.setCombustivel(getCombustivel() - (float) 0.25);       //Gasta a gasolina para andar
        }
        
    }

    @Override
    public void desenhaVeiculo() {
        System.out.print("   ,_oo\n");
        System.out.print(".-/c-//::\n");  
        System.out.print("(_)'==(_)\n");
        
    }
    
}
