package models;

import java.util.InputMismatchException;
import java.util.Scanner;

import errors.JogoNaoEncontradoException;

abstract public class Jogo {
  public Baralho baralho;
  private Scanner input; 

  public Jogo(Baralho baralho){
    this.baralho = baralho;
    this.input = new Scanner(System.in);
  }
  
  
  /**  Inicia o jogo (Deve ser implementado pelas classes filhas)
   * @throws JogoNaoEncontradoException
   */
  public void jogar() throws JogoNaoEncontradoException{
    throw new JogoNaoEncontradoException("Esse jogo não foi implementado");
  }

  
  /** Pega o input digitado pelo usuário já tratado como inteiro
   * @return int entrada, -99 caso o usuário não digitou um número inteiro
   */
  public int inputInt(){
    try {
      int nextInt = input.nextInt();
      return nextInt;
    } catch (InputMismatchException e) {
      this.input.next();
      return -99;
    }
  }
}
