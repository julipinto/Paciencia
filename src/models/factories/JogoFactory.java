package models.factories;

import errors.JogoNaoEncontradoException;
import models.Baralho;
import models.Jogo;
import views.Paciencia;

abstract public class JogoFactory {
  
  public static Jogo gerar(String option, Baralho baralho) throws JogoNaoEncontradoException {
    switch (option) {
      case "paciencia":
        return new Paciencia(baralho);
      default:
        throw new JogoNaoEncontradoException("O jogo não existe");
    }
  }
  
}
