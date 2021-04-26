package utils;

import java.util.ArrayList;

import models.Carta;

public class ListaDeCartas {
  public ArrayList<Carta> cartas;
  public int length;

  public ListaDeCartas(ArrayList<Carta> cartas) {
    this.cartas = cartas;
    this.length = cartas.size();
  }

  public ListaDeCartas(){
    cartas = new ArrayList<Carta>();
  }

  public ArrayList<Carta> fatiar(int fromIndex, int toIndex) {
    ArrayList<Carta> fatia = new ArrayList<Carta>(this.cartas.subList(fromIndex, toIndex + 1));
    return fatia;
  }

  public Carta getUltimaCarta(){
    return this.cartas.get(length);
  }

  public Carta get(int index){
    return this.cartas.get(index);
  }
}
