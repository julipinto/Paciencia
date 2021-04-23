package models;

import java.util.ArrayList;

public abstract class ListaDeCartas {
  public ArrayList<Carta> cartas;

  public ListaDeCartas(ArrayList<Carta> cartas) {
    this.cartas = cartas;
  }

  public ListaDeCartas(){
    cartas = new ArrayList<Carta>();
  }

  public ArrayList<Carta> fatiar(int fromIndex, int toIndex) {
    ArrayList<Carta> fatia = new ArrayList<Carta>(this.cartas.subList(fromIndex, toIndex + 1));
    return fatia;
  }
}
