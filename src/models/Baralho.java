package models;

import java.util.ArrayList;
import java.util.Collections;

import utils.ListaDeCartas;

public class Baralho extends ListaDeCartas{
  public int length;

  public Baralho(ArrayList<Carta> cartas) {
    super(cartas);
    this.length = cartas.size();
  }

  public Baralho(){}

  public void embaralhar(){
    Collections.shuffle(cartas);
  }

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
