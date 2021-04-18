package utils;

import models.Baralho;

abstract public class Jogo {
  private Baralho baralho;

  public Jogo(Baralho baralho){
    this.baralho = baralho;
  }

  public Baralho getBaralho(){
    return baralho;
  }
}
