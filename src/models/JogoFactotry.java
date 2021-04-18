package models;

import errors.GameDidntFoundException;
import utils.Jogo;

abstract public class JogoFactotry {
  
  public static Jogo gerar(String option, Baralho baralho) throws GameDidntFoundException {
    switch (option) {
      case "paciencia":
        return new Paciencia(baralho);
      default:
        throw new GameDidntFoundException("O jogo não existe");
    }
  }
  
}
