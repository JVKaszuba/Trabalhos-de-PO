package TrabalhoCarrinhos;

import java.util.Random;

public class Carro {
//Atributos
    private int id;
    private int distanciaPercorrida;
    private float combustivel;
    private float valorVenda;
    private RodaGui roda[];
    private Boolean ipva;

//Construtor
    public Carro(RodaGui roda[]) {
        Random rn = new Random();   
        this.setId();                                   //Gera um ID unico com limite de ate 20 carros;
        this.setIpva(rn.nextBoolean());                 //Gera o valor do ipva, pago ou nao;
        this.setCombustivel(2.5f);          //Inicia o Combustivel em 2.5L;
        this.setValorVenda(rn.nextFloat(1000f));      //Gera o Valor de Venda;
        this.roda = roda;

        //RodaGui roda[] = new RodaGui[4];    //Gera as rodas, sorteando se estao calibradas;
        for(int i = 0; i<4; i++){
            System.out.println("calibragem: " + this.roda[0].getCalibragem());
        }            
            
        
    }
//Getters
    public int getId() {
        return this.id;
    }
    public int getDistanciaPercorrida() {
        return this.distanciaPercorrida;
    }
    /*public  Boolean getRodas(int num) {

        return this.roda[0].getCalibragem();
    }*/
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

    private void setId() {
        Random rn = new Random();  //PRECISA VERIFICAR SE EH UNICO;
        int i = rn.nextInt(5);
        this.id = i;

    }
    /*private void setDistanciaPercorrida(int distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }
   / private void setRodas(Rodas[] rodas) {
        this.rodas = rodas;
    }*/
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
        System.out.println();
        System.out.println("ID: " + this.getId());
        System.out.println("Distancia: " + this.getDistanciaPercorrida() + " Km");
        System.out.println("Combustivel: " + this.getCombustivel() + " L");
        System.out.println("Valor de venda: " + this.getValorVenda());

        if(this.getIpva())
            System.out.println("IPVA: Pago");
        else
            System.out.println("IPVA: Nao Pago");

            //System.out.print("Roda: " +  " " + this.roda[0].getCalibragem());    
    }

}