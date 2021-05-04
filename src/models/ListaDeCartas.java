package models;

import java.util.ArrayList;
import java.util.Collections;

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

  
  /** 
   * @return int tamanho do array de cartas
   */
  public int length() {
    return cartas.size();
  }

  
  /** 
   * @return Ultima carta da lista
   */
  public Carta getUltimaCarta(){
    if(!isEmpty()){
      return this.cartas.get(this.getUltimoIndex());
    }
    return null;
  }

  
  /** 
   * @return Primeira carta da lista
   */
  public Carta getPrimeiraCarta(){
    return this.cartas.get(0);
  }

  
  /** Pega uma carta pelo seu index na lista
   * @param index
   * @return Carta, null se o index for maior que ou igual ao tamanho do array
   */
  public Carta get(int index){
    if(index >= length()) return null;
    return this.cartas.get(index);
  }

  
  /** Adiciona uma carta ao final do array
   * @param carta
   */
  public void addUmaCartaNoFinal(Carta carta){
    this.cartas.add(carta);
  }

  
  /** Acidiona várias cartas ao final da lista de cartas
   * @param cartas
   */
  public void addVariasCartasNoFinal(ArrayList<Carta> cartas){
    this.cartas.addAll(cartas);
  }

  
  /** Pega o ultimo index da lista de cartas
   * @return int
   */
  public int getUltimoIndex(){
    return this.length() - 1;
  }

  
  /** 
   * @return true se a lista está vazia
   */
  public boolean isEmpty(){
    return this.cartas.isEmpty();
  }

  /**
   * Reverte a ordem da lista de cartas
   */
  public void reverse(){
    Collections.reverse(cartas);
  }
}
