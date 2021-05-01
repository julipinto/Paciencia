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

  
  /** 
   * Esse método cria uma cópia de uma parte da lista de cartas a partir de um index inicial 
   * até um index final.
   * @param fromIndex
   * @param toIndex
   * @return ArrayList<Carta>
   */
  public ArrayList<Carta> subLista(int fromIndex, int toIndex) {
    ArrayList<Carta> subLista = new ArrayList<Carta>(this.cartas.subList(fromIndex, toIndex + 1));
    return subLista;
  }

  
  /** 
   * Esse método remove os fromIndex ultimos ítems da lista de cartas e os devolve
   * @param fromIndex
   * @return ArrayList<Carta>
   */
  public ArrayList<Carta> fatiarAPartirDe(int fromIndex){
    ArrayList<Carta> fatia = new ArrayList<Carta>(this.cartas.subList(fromIndex, length()));
    this.cartas.subList(fromIndex, length()).clear();
    return fatia;
  }

  public int length() {
    return cartas.size();
  }

  public Carta getUltimaCarta(){
    if(!isEmpty()){
      return this.cartas.get(this.getUltimoIndex());
    }
    return null;
  }

  public Carta getPrimeiraCarta(){
    return this.cartas.get(0);
  }

  public Carta get(int index){
    return this.cartas.get(index);
  }

  
  /** 
   * @param carta
   */
  public void addUmaCartaNoFinal(Carta carta){
    this.cartas.add(carta);
  }

  
  /** 
   * @param cartas
   */
  public void addVariasCartasNoFinal(ArrayList<Carta> cartas){
    this.cartas.addAll(cartas);
  }

  public int getUltimoIndex(){
    return this.length() - 1;
  }

  public boolean isEmpty(){
    return this.cartas.isEmpty();
  }
}
