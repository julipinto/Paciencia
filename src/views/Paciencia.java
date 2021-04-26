package views;

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
    boolean continuar = true;
    do {
      printarJogo();
      int resposta = menuRodada();
      switch (resposta) {
        case 1: {
          controller.remanecente.comprarCarta();
        }
          break;
      
        default:
        continuar = false;
          break;
      }

    } while (continuar);
    return continuar;
  }

  public void printarJogo(){
    for(int i = 0; i < controller.fundacoes.length; i++){
      if(controller.fundacoes[i] == null){
        System.out.println("FUNDAÇÃO " + i + ": [   ]");
      }else {
        System.out.println("FUNDAÇÃO " + i + ": [ X ]");
      }      
    }

    
    System.out.print("MONTE DE COMPRA: ");
      
    for(Carta c : controller.remanecente.monteDeCompra){
      System.out.print(c.toString() + " | ");
    }
    System.out.println("");

    Carta ultimaCartaComprada = controller.remanecente.getUltimaCartaComprada();
    if(ultimaCartaComprada == null){
      System.out.println("CARTAS COMPRADAS: [   ]");
    }else{
      System.out.println("CARTAS COMPRADAS: " + ultimaCartaComprada.toString());
    }
    

    System.out.println("\nFileiras: ");

    for(Fileira fileira : controller.fileiras){
      for(Carta c : fileira.cartas){
        System.out.print(c.toString() + " | ");
      }
      System.out.println("");
    }
  }


  public int menuRodada(){
    // System.out.println("Selecione uma opção");
    // System.out.println("1 - Mover Carta");
    // System.out.println("2 - Exibir Jogo");
    // System.out.println("3 - Alterar Quantidade de cartas a virar do estoque");
    // System.out.println("4 - Reiniciar");
    // System.out.println("5 - Finalizar");
    // int resposta = this.input.nextInt();
    System.out.println("Selecione uma opção");
    System.out.println("1 - Comprar carta");
    return this.input.nextInt();
  }
}
