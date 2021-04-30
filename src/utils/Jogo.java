package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import errors.JogoNaoEncontradoException;
import models.Baralho;

abstract public class Jogo {
  public Baralho baralho;
  private Scanner input; 

  public Jogo(Baralho baralho){
    this.baralho = baralho;
    this.input = new Scanner(System.in);
  }

  public Baralho getBaralho(){
    return baralho;
  }

  public void jogar() throws JogoNaoEncontradoException{
    throw new JogoNaoEncontradoException("Esse jogo não foi implementado");
  }

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
