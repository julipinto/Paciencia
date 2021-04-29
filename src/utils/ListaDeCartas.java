package utils;

import java.util.ArrayList;

import models.Carta;

public class ListaDeCartas {
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

  public int length() {
    return cartas.size();
  }

  public Carta getUltimaCarta(){
    return this.cartas.get(this.length() -1);
  }

  public Carta getPrimeiraCarta(){
    return this.cartas.get(0);
  }

  public Carta get(int index){
    return this.cartas.get(index);
  }

  public void addUmaCartaNoFinal(Carta carta){
    this.cartas.add(carta);
  }

  public void addVariasCartasNoFinal(ArrayList<Carta> cartas){
    this.cartas.addAll(cartas);
  }
}
