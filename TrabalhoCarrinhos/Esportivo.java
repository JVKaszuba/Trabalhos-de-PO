public class Esportivo extends VeiculoMotorizado {

    //Construtor;
    public Esportivo(int id){
        super(id, 4, 'E', (float) (500*3.15));
    }

    //Metodos;
    @Override
    public void desenhaVeiculo() {
        System.out.print("        __         \n");
        System.out.print("      ~( @\\ \\   \n");
        System.out.print("   _____]_[_/_>__   \n");
        System.out.print("  / __ \\<> |  __ \\      \n");
        System.out.print("=\\_/__\\_\\__|_/__\\_D    \n");
        System.out.print("   (__)      (__)    \n");
        
    }

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
        if(getCombustivel() < 2.3*10){                                                                  //Verifica se tem gasolina sufuciente
            flag = 99;
            System.out.println("Veiculo "+ this.getId() + " não possui gasolina sufuciente. ");
        }
        if(flag == 0){
            this.setDistanciaPercorrida(getDistanciaPercorrida() + 10);                                 //Acrescenta Distancia Percorrida;
            this.setCombustivel(getCombustivel() - (float) 2.3*10);                                     //Gasta a gasolina para andar
        }
        else
            System.out.println("Não foi possivel mover. ");
    }
}
