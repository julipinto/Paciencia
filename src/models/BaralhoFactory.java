package models;

import java.util.ArrayList;
import java.util.Collections;

public class BaralhoFactory {
  private final String[] naipes = {"espadas", "copas", "paus", "ouros"};
  private final String[] simbolos = {"♠", "♣", "♥", "♦"};
  private final String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
  private int quantidadeDeBaralhos = 1;
  private Baralho baralho;
  
  public BaralhoFactory(){}
  
  public BaralhoFactory(int quantidadeDeBaralhos) {
    this.quantidadeDeBaralhos = quantidadeDeBaralhos;
  }
  
  public Baralho gerarBaralho(boolean embaralhado){
    ArrayList<Carta> cartas = new ArrayList<Carta>();

    for(int i = 0; i < quantidadeDeBaralhos; i++){
        for(int j = 0; j < naipes.length; j++){
          String naipe = naipes[j];
          String simbolo = simbolos[j];

          for(String valor : valores){
            cartas.add(new Carta(naipe, valor, simbolo));
          }
        }
    }

    if(embaralhado){
      Collections.shuffle(cartas);
    }
    
    this.baralho = new Baralho(cartas);

    return baralho;
  }

  public Baralho getBaralho() {
    return baralho;
  }  
}
