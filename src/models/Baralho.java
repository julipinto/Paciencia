package models;

import java.util.ArrayList;

public class Baralho {
  private ArrayList<Carta> cartas;

  public Baralho(ArrayList<Carta> cartas) {
    this.cartas = cartas;
  }

  public void embaralhar(){}

  public void printarBaralho(){
    for(Carta c : cartas){
      System.out.println(c.toString());
    }
  }
  
}
