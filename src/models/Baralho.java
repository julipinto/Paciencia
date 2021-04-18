package models;

import java.util.ArrayList;

public class Baralho {
  private final String[] naipes = {"espadas", "copas", "paus", "ouros"};
  private final String[] simbolos = {"♠", "♣", "♥", "♦"};
  private final String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
  private int quantidade = 1;
  private ArrayList<Carta> cartas = new ArrayList<Carta>();

  public Baralho(){}

  public Baralho(int quantidade) {
    this.quantidade = quantidade;
  }

  public ArrayList<Carta> gerarBaralho(){
    for(int i = 0; i < quantidade; i++){
        for(int j = 0; j < naipes.length; j++){
          String naipe = naipes[j];
          String simbolo = simbolos[j];

          for(String valor : valores){
            cartas.add(new Carta(naipe, valor, simbolo));
          }
        }
    }
    return cartas;
  }

  public ArrayList<Carta> getCartas() {
    return cartas;
  }  
}
