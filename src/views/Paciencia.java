package views;

import java.util.InputMismatchException;

import controllers.PacienciaController;
import errors.ErrorHandler;
import errors.MovimentoInvalidoException;
import models.Baralho;
import models.Carta;
import models.paciencia.Fileira;
import models.paciencia.Remanecente;
import utils.Jogo;

public class Paciencia extends Jogo {
  private PacienciaController controller;
  private boolean restartGame;

  public Paciencia(Baralho baralho){
    super(baralho);
    controller = new PacienciaController(baralho);
  }
 
  @Override
  public void jogar() {

    do {
      restartGame = false;
      fluxoDeJogo();
    } while (restartGame);
  }

  public void fluxoDeJogo(){
    controller.separarCartas();
    boolean continuar = true;
    do {
      printarJogo();
      continuar = menuRodada();

    } while (continuar);
  }

  public void printarJogo(){
    imprimirSeparador(103, true);
    imprimirFundacoes();
    imprimirRemanecentes();
    imprimirFileiras();
    imprimirSeparador(103, true);
    pularLinha();
  }

  public void imprimirSeparador(int count, boolean tracejado){
    String c = " ";
    if(tracejado){
      c = "-";
    }
    System.out.print(c.repeat(count));
  }
  
  public void imprimirFundacoes(){
    pularLinha();
    int lengthFundacoes = controller.fundacoes.length;
    int count = 42;
    imprimirSeparador(count, false);
    for(int i = 0; i < lengthFundacoes; i++){
      System.out.print(" FUNDAÇÃO (" + (i + 7) + ") |");
    }
    pularLinha();

    imprimirSeparador(count, false);
    for(int i = 0; i < lengthFundacoes; i++){
      if(controller.fundacoes[i] == null){
        System.out.print(" [          ] |");
      }else {
        System.out.print(" [    XX    ] |");
      }      
    }
    pularLinha();
  }

  public void pularLinha(){
    System.out.println("");
  }

  public void imprimirRemanecentes(){
    Remanecente remanecente = controller.remanecente;
    int lengthMonteDeCompra = remanecente.lenMonteDeCompra();
    if(lengthMonteDeCompra == 0){
      System.out.println("\nMONTE DE COMPRA:  [        ] | (0 Cartas)");
    }else{
      System.out.println("\nMONTE DE COMPRA:  [   XX   ]  | (" + lengthMonteDeCompra + " Cartas)");
    }

    int lengthCartasCompradas = remanecente.lenCartasCompradas();
    Carta ultimaCartaComprada = remanecente.getUltimaCartaComprada();
    if(ultimaCartaComprada == null){
      System.out.println("CARTAS COMPRADAS: [        ]  | (0 Cartas)");
    }else{
      System.out.println("CARTAS COMPRADAS: " + ultimaCartaComprada.toString() + "  | (" + lengthCartasCompradas + " Cartas)");
    }
  }

  public void imprimirFileiras(){
    System.out.println("\nFILEIRAS: ");
    imprimirIndicesFileiras();
    for(int i = 0; i < controller.maiorFileira; i++){
      for(Fileira fileira : controller.fileiras){
        if(fileira.length() > i){
          Carta carta = fileira.get(i);
          System.out.print(carta.toString() + "  |  ");
        }
        else{
          System.out.print("            |  ");
        }
      }
      pularLinha();
    }
  }

  public void imprimirIndicesFileiras(){
    System.out.print("    (0)");
    System.out.print("            (1)");
    System.out.print("            (2)");
    System.out.print("            (3)");
    System.out.print("            (4)");
    System.out.print("            (5)");
    System.out.println("            (6)");
  }


  public boolean menuRodada(){
    System.out.println("\nSelecione uma opção");
    System.out.println("1 - Comprar carta");
    System.out.println("2 - Mover carta");
    System.out.println("3 - Exibir Jogo");
    System.out.println("4 - Reiniciar partida");
    System.out.println("5 - Finalizar o jogo");
    int resposta = this.input.nextInt();
    return opcoesRodada(resposta);
  }

  public boolean opcoesRodada(int resposta) {
    switch (resposta) {
      case 1: {
        controller.remanecente.comprarCarta();
      }
        break;
      case 2: {
        int moverCartaOption = menuMoverCarta();
        moverCarta(moverCartaOption);
      }
      break;
      case 4: {
        int restartBaralho = menuRestartarJogo();
        return opcoesRestartarJogo(restartBaralho);
      }
      case 5: {
        System.exit(0);
        return false;
      }
      default:
        return false;
    }

    return true;
  }

  public int menuRestartarJogo(){
    System.out.println("Você deseja:");
    System.out.println("1 - Recomeçar essa partida");
    System.out.println("2 - Nova partida");
    System.out.println("3 - CANCELAR");
    int resposta = this.input.nextInt();
    return resposta;
  }

  public boolean opcoesRestartarJogo(int resposta){
    if(resposta == 3){
      restartGame = false;
      return true;
    }
    restartGame = true;
    if(resposta == 1){
      baralho.embaralhar();
    }
    controller.virarCartas();
    return false;
  }

  public int menuMoverCarta(){
    printarJogo();
    System.out.println("\nEscolha o monte de onde você deseja mover a carta");
    System.out.println("[0 ~ 6] - Fileira (Digite o número correspondente ao índice da fileira");
    System.out.println("7 - Cartas Compradas");
    System.out.println("8 - Voltar ao menu");
    return this.input.nextInt();
  }

  public void moverCarta(int resposta){
    if(resposta < 8 && resposta >= 0){
      printarJogo();
      if(resposta == 7){
        moverCartaDoMonteComprado();
      }
      else{
        moverCartaDasFileiras();
      }
    }
  }
  

  // public void moverCarta(int resposta){
  //   if(resposta < 8 && resposta >= 0){
  //     printarJogo();

  //     if(resposta == 7){
  //       //move do monte
  //       try {
  //         Carta aMover = controller.popCartasCompradas();
  //         int destino = menuDestinoMoverCarta();
  //         controller.moveUma(aMover, destino);
  //       }catch (MovimentoInvalidoException e) {
  //         System.out.println(e.getMessage());
  //         ErrorHandler.exception(e);
  //       }

  //       printarJogo();
  //       System.exit(0);

  //     }
      // else {
        // Fileira f = controller.fileiras[resposta];
        // if(f.qtdCartasViradas == 1){
        //   printarJogo();
        //   Carta c = f.getUltimaCarta();
        //   System.out.println("\nCarta: " + c.toString());
        // }else{
        //   System.out.println("\nA partir de qual carta da fileira " + resposta +" você deseja mover?");
        //   System.out.println("\nA partir de qual carta da fileira " + resposta +" você deseja mover?");
        //   int indiceASerMovido;
        //   for(int i = 0; i < f.length(); i++){
        //     Carta c = f.get(i);
        //     if(c.face == true){
        //       System.out.println(i + " - " + f.get(i));
        //     }
        //   }
        //   indiceASerMovido = this.input.nextInt();
        //     if(indiceASerMovido < 0 || indiceASerMovido > f.length());
        // }
        
        // System.out.println("Para onde deseja mover?");
        // System.exit(0);

      // }

      
      // int destino = menuDestinoMoverCarta();
      // if(destino >= 0 && destino <= 10){
      //   controller.moveUma(aMover, destino);
      // }
    // }


  // }

  public void moverCartaDoMonteComprado(){
    Carta aMover = null;
    try {
      aMover = controller.popCartasCompradas();
    } catch (MovimentoInvalidoException e) {
      ErrorHandler.exception(e);
    }

    if(aMover != null){
      int destino = menuDestinoMoverCarta();
      
      if(destino >= 0 && destino <= 10){
        try {
          controller.moveUma(aMover, destino);
        } catch (MovimentoInvalidoException e) {
          ErrorHandler.exception(e);
          controller.addCartaCompradas(aMover);
        }
      }
    }
    
  }

  public void moverCartaDasFileiras(){

  }

  public int menuDestinoMoverCarta(){
    System.out.println("Para onde você deseja mover as cartas?");
    System.out.println("[0 ~ 6] - Fileira (Digite o número correspondente ao índice da fileira");
    System.out.println("[7 ~ 10] - Fundação (Digite o número correspondente ao índice da fundação");
    System.out.println("Qualquer outra tecla para cancelar");
    try{
      return this.input.nextInt();
    }catch(InputMismatchException e){}
    return -99;
  }
}
