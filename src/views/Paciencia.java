package views;
import java.util.ArrayList;

import controllers.PacienciaController;
import models.Baralho;
import models.Carta;
import models.paciencia.Fileira;
import utils.Jogo;

public class Paciencia extends Jogo {
  private PacienciaController controller;

  public Paciencia(Baralho baralho){
    super(baralho);
    controller = new PacienciaController(baralho);
  }
 
  @Override
  public void jogar() {
    boolean res = false;

    do {
      res = fluxoDeJogo();
    } while (res);
  }

  public boolean fluxoDeJogo(){
    controller.separarCartas();
    printarJogo();
    return false;
  }

  public void printarJogo(){
    // for(int i = 0; i < fundacoes.length; i++){
    //   if(fundacoes[i] == null){
    //     System.out.println("FUNDAÇÃO " + i + ": [   ]");
    //   }else {
    //     System.out.println("FUNDAÇÃO " + i + ": [ X ]");
    //   }
    // }
    // System.out.print("REMANECENTES: ");
    // remanecentes.printarBaralho();

    // for(int i = 0; i < fileiras.length; i++){
    //   System.out.print("FUNDAÇÃO " +  i + ": ");
    //   fileiras[i].printarBaralho();
    // }

    for(int i = 0; i < controller.fundacoes.length; i++){
      if(controller.fundacoes[i] == null){
        System.out.println("FUNDAÇÃO " + i + ": [   ]");
      }else {
        System.out.println("FUNDAÇÃO " + i + ": [ X ]");
      }      
    }

    
    System.out.print("REMANECENTES: ");
      
    for(Carta c : controller.remanecente.monteDeCompra){
      System.out.print(c.toString() + " | ");
    }

    System.out.println("\nFileiras: ");

    for(Fileira fileira : controller.fileiras){
      for(Carta c : fileira.cartas){
        System.out.print(c.toString() + " | ");
      }
      System.out.println("");
    }
  }


  public void menuRodada(){
    System.out.println("Selecione uma opção");
    System.out.println("1 - Mover Carta");
    System.out.println("2 - Exibir Jogo");
    System.out.println("3 - Alterar Quantidade de cartas a virar do estoque");
    System.out.println("4 - Reiniciar");
    System.out.println("5 - Finalizar");
    int resposta = this.input.nextInt();
  }
}
