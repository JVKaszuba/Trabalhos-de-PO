package TrabalhoCarrinhos;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Random;

public class Carro implements Serializable{
                                                        //Atributos
    private int id;
    private int distanciaPercorrida;
    private float combustivel;
    private float valorVenda;
    private Roda[] roda = new Roda[4];
    private Boolean ipva;

                                                        //Construtor
    public Carro(int k) {

        Random rn = new Random();

        this.setId(k);
        this.setDistanciaPercorrida(0);               //Inicia a distância percorrida;
        this.setCombustivel(2.5f);          //Inicia o Combustivel em 2.5L;
        this.setValorVenda(rn.nextFloat(1000f));        //Gera o Valor de Venda;
        for(int i = 0; i < 4; i++)                      //Gera as rodas, sorteando se estao calibradas;
            this.roda[i] = new Roda();                                  
        this.setIpva(rn.nextBoolean());                 //Gera o valor do ipva, pago ou nao;
           
    }

                                                        //Getters
    public int getId() {
        return this.id;
    }
    
    public int getDistanciaPercorrida() {
        return this.distanciaPercorrida;
    }

    public  Boolean getRodas(int num) {
        
        return this.roda[num].getCalibragem();
    }

    public float getCombustivel() {
        return this.combustivel;
    }

    public float getValorVenda() {
        return this.valorVenda;
    }

    public Boolean getIpva() {
        return this.ipva;
    }
                                                        //Setters

    private void setId(int i) {
        this.id = i;
    }

    private void setDistanciaPercorrida(int d) {
        this.distanciaPercorrida = d;
    }

    private void setCombustivel(float combustivel) {
        this.combustivel = combustivel;
    }

    private void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    private void setIpva(Boolean ipva) {
        this.ipva = ipva;
    }

                                                        //Status

    public void status(){
        DecimalFormat df1 = new DecimalFormat("#.##");
        System.out.println();
        System.out.println("ID: "               + this.getId());
        System.out.println("Distancia: "        + this.getDistanciaPercorrida() + " Km");
        System.out.println("Combustivel: "      + this.getCombustivel() + " L");
        System.out.println("Valor de venda: R$"   + df1.format(this.getValorVenda()));

        if(this.getIpva())
            System.out.println("IPVA: Pago");
        else
            System.out.println("IPVA: Nao Pago");

        System.out.println();
            
        for(int i = 0; i < 4; i++){
            if(this.getRodas(i))
                System.out.println("Roda: " + i + " Calibrada. ");
            else
                System.out.println("Roda: " + i + " Nao Calibrada. ");
        }
    }

                                                        //Métodos

    public void abastece(float quantComb) {

        float quantMax = 55 - this.combustivel;     // 55 é a capacidade do tank

        if(quantComb <= quantMax) 
            this.combustivel += quantComb;
        
        else 
            this.combustivel += quantMax;
        
    }

    public void pagaIPVA() {

        if(this.ipva == false) {this.ipva = true;}
    }

    public void calibraPneu(int npneu) {

        if(roda[npneu].getCalibragem() == false) {roda[npneu].setCalibragem(true);}
    }

    public void esvaziaPneu(int npneu) {

        if(roda[npneu].getCalibragem() == true) {roda[npneu].setCalibragem(false);}
    }

    public void calibraCarro() {

        for(int i = 0; i < 4; i++) {this.calibraPneu(i);}
    }

    public void esvaziaCarro() {

        for(int i = 0; i < 4; i++) {this.esvaziaPneu(i);}
    }

    public void andaCarro() {
        int flag = 0;
        for(int i = 0; i < 4; i++){
            if(this.getRodas(i) == false) {
                System.out.println("Veiculo "+ this.getId() + " as rodas não estão calibradas. ");       //  Verifica se as rodas estão calibradas;
                flag = 99;
                break;
            }
        }
        if(getIpva() == false){
            flag = 99;
            System.out.println("Veiculo "+ this.getId() + " o IPVA não está pago. ");
        }
        if(getCombustivel() < 0.55){
            flag = 99;
            System.out.println("Veiculo "+ this.getId() + " não possui gasolina sufuciente. ");
        }
        if(flag == 0){
            this.setDistanciaPercorrida(getDistanciaPercorrida() + 5);  //Acrescenta Distancia Percorrida;
            this.setCombustivel(getCombustivel() - (float) 0.55);       //Gasta a gasolina para andar
        }
    }

    public void desenhaCarro() {

        for(int i = 0; i < this.distanciaPercorrida; i++) {System.out.print(" ");}
        System.out.print("    ____\n");
        for(int i = 0; i < this.distanciaPercorrida; i++) {System.out.print(" ");}
        System.out.print(" __/  |_ \\_\n");
        for(int i = 0; i < this.distanciaPercorrida; i++) {System.out.print(" ");}
        System.out.print("|  _     _ ``.\n");
        for(int i = 0; i < this.distanciaPercorrida; i++) {System.out.print(" ");}
        System.out.print("'-(_)---(_)--'\n\n\n");
    }

}