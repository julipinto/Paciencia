package models.factories;

import errors.JogoNaoEncontradoException;
import models.Baralho;
import models.Jogo;
import views.Paciencia;

abstract public class JogoFactory {
  
  
  /** Gera um Jogo genérico a partir das configurações 
   * @param option nome do jogo
   * @param baralho baralho gerado externamente
   * @return Jogo retorna um Jogo genérico implementado
   * @throws JogoNaoEncontradoException
   */
  public static Jogo gerar(String option, Baralho baralho) throws JogoNaoEncontradoException {
    switch (option) {
      case "paciencia":
        return new Paciencia(baralho);
      default:
        throw new JogoNaoEncontradoException("O jogo não existe");
    }
  }
  
}
