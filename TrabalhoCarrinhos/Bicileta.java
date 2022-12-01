public class Bicileta extends Veiculo {

    //Construtor;
    public Bicileta(int id) {
        super(id, 2, 'B');
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
        if(flag == 0)
            this.setDistanciaPercorrida(getDistanciaPercorrida() + 2);  //Acrescenta Distancia Percorrida;
        else
            System.out.println("Não foi possivel mover. ");
    }

    @Override
    public void desenhaVeiculo() {
        System.out.print("   __o\n");    
        System.out.print(" _`\\<,_\n");
        System.out.print("(*)/ (*)\n\n\n");
        
    }
    
}
