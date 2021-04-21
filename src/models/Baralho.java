package models;

import java.util.ArrayList;

public class Baralho {
  private ArrayList<Carta> cartas;

  public Baralho(ArrayList<Carta> cartas) {
    this.cartas = cartas;
  }

  public Baralho(){}

  public void embaralhar(){}

  public void printarBaralho(){
    for(Carta c : cartas){
      System.out.print(c.toString() + " | ");
    }
    System.out.println("");
    for(Carta c : cartas){
      System.out.print("---------");
    }  
    System.out.print("-----------");                 
    System.out.println();
  }

  public ArrayList<Carta> getCartas(){
    return cartas;
  }

  public void setCartas(ArrayList<Carta> cartas) {
    this.cartas = cartas;
  }
  
}
