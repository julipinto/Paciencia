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
    System.out.println("----------------------------------------");
    controller.separarCartas();
    boolean continuar = true;
    do {
      printarJogo();
      continuar = menuRodada();

    } while (continuar);
    return continuar;
  }

  public void printarJogo(){
    for(int i = 0; i < controller.fundacoes.length; i++){
      if(controller.fundacoes[i] == null){
        System.out.println("FUNDAÇÃO " + i + ": [        ]");
      }else {
        System.out.println("FUNDAÇÃO " + i + ": [   XX   ]");
      }      
    }

    int lengthMonteDeCompra = controller.remanecente.lenMonteDeCompra();
    if(lengthMonteDeCompra == 0){
      System.out.println("MONTE DE COMPRA: [        ]");
    }else{
      System.out.println("MONTE DE COMPRA: [   XX   ]  | (" + lengthMonteDeCompra + " Cartas)");
    }

    System.out.println("");

    int lengthCartasCompradas = controller.remanecente.lenCartasCompradas();
    Carta ultimaCartaComprada = controller.remanecente.getUltimaCartaComprada();
    if(ultimaCartaComprada == null){
      System.out.println("CARTAS COMPRADAS: [        ]");
    }else{
      System.out.println("CARTAS COMPRADAS: " + ultimaCartaComprada.toString() + " | (" + lengthCartasCompradas + " Cartas)");
    }
    

    System.out.println("\nFileiras: ");

    imprimirFileiras();
  }

  public void imprimirFileiras(){
    for(int i = 0; i < controller.maiorFileira; i++){
      for(Fileira fileira : controller.fileiras){
        if(fileira.length > i){
          Carta carta = fileira.get(i);
          System.out.print(carta.toString() + "  |  ");
        }
        else{
          System.out.print("            |  ");
          // System.out.print("               ");
        }
      }
      System.out.println("");
    }
  }


  public boolean menuRodada(){
    // System.out.println("Selecione uma opção");
    // System.out.println("1 - Mover Carta");
    // System.out.println("2 - Exibir Jogo");
    // System.out.println("3 - Alterar Quantidade de cartas a virar do estoque");
    // System.out.println("4 - Reiniciar");
    // System.out.println("5 - Finalizar");
    // int resposta = this.input.nextInt();
    System.out.println("Selecione uma opção");
    System.out.println("1 - Comprar carta");
    int resposta = this.input.nextInt();
    switch (resposta) {
      case 1: {
        controller.remanecente.comprarCarta();
      }
        break;
    
      default:
        return false;
    }

    return true;
  }
}
