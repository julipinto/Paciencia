package models;

import errors.JogoNaoEncontradoException;
import utils.Jogo;

public class Paciencia extends Jogo{
  private Baralho baralho;

  public Paciencia(Baralho baralho){
    super(baralho);

  }

  @Override
  public void jogar() {
    System.out.println("o jogo foi implementado");
    System.out.println(this.getBaralho());
  }

  
  

  
  
}
