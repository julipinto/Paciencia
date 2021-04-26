package models;

import java.util.ArrayList;

import utils.ListaDeCartas;

public class Baralho extends ListaDeCartas{
  public int length;

  public Baralho(ArrayList<Carta> cartas) {
    super(cartas);
    this.length = cartas.size();
  }

  public Baralho(){}

  public void embaralhar(){}

  public void printarBaralho(){
    for(Carta c : this.cartas){
      System.out.print(c.toString() + " | ");
    }
    System.out.println("");
    for(Carta c : this.cartas){
      System.out.print("---------");
    }  
    System.out.print("-----------");                 
    System.out.println();
  }

}
