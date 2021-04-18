package utils;

import errors.JogoNaoEncontradoException;
import models.Baralho;

abstract public class Jogo {
  private Baralho baralho;

  public Jogo(Baralho baralho){
    this.baralho = baralho;
  }

  public Baralho getBaralho(){
    return baralho;
  }

  public void jogar() throws JogoNaoEncontradoException{
    throw new JogoNaoEncontradoException("Esse jogo não foi implementado");
  }
}
