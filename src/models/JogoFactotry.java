package models;

import errors.JogoNaoEncontradoException;
import utils.Jogo;

abstract public class JogoFactotry {
  
  public static Jogo gerar(String option, Baralho baralho) throws JogoNaoEncontradoException {
    switch (option) {
      case "paciencia":
        return new Paciencia(baralho);
      default:
        throw new JogoNaoEncontradoException("O jogo não existe");
    }
  }
  
}
