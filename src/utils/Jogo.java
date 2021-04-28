package utils;

import java.util.Scanner;

import errors.JogoNaoEncontradoException;
import models.Baralho;

abstract public class Jogo {
  public Baralho baralho;
  public Scanner input; 

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

  public void pressAnyKeyToContinue(){
    System.out.print("Digite qualquer tecla para continuar");
    try{
      System.in.read();
    }catch(Exception e){}
  }
}
