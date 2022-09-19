package TrabalhoCarrinhos;

import java.util.Random;

public class Carro {
//Atributos
    private int id;
    private int distanciaPercorrida;
    private float combustivel;
    private float valorVenda;
    private int quantRoda;
    private RodaGui[] roda = new RodaGui[4];
    private Boolean ipva;

//Construtor
    public Carro(int quant) {
        Random rn = new Random();
        this.setId(rn.nextInt(5));                                
        this.setIpva(rn.nextBoolean());                 //Gera o valor do ipva, pago ou nao;
        this.setCombustivel(2.5f);          //Inicia o Combustivel em 2.5L;
        this.setValorVenda(rn.nextFloat(1000f));      //Gera o Valor de Venda;
        this.quantRoda = quant;

        //RodaGui roda[] = new RodaGui[4];    //Gera as rodas, sorteando se estao calibradas;
        for(int i = 0; i < this.quantRoda; i++) {
            this.roda[i] = new RodaGui();
           // System.out.println(this.roda[i]);
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

    private void setId(int i) {
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