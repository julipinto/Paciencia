package views;

import java.util.ArrayList;

import controllers.PacienciaController;
import errors.EntradaInválidaException;
import errors.ErrorHandler;
import errors.MovimentoInvalidoException;
import models.Baralho;
import models.Carta;
import models.paciencia.Fileira;
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
    controller.inicializarPartida();
    boolean continuar = true;
    do {
      printarJogo();
      continuar = menuRodada();

      if(controller.venceuOJogo()){
        continuar = parabenizar();
      }

    } while (continuar);
  }

  public boolean parabenizar(){
    imprimirSeparador(103, true);
    pularLinha();
    imprimirSeparador(103, true);
    pularLinha();
    pularLinha();
    System.out.println("PARABÉNS, VOCÊ VENCEU O JOGO!");
    pularLinha();
    pularLinha();
    imprimirSeparador(103, true);
    pularLinha();
    imprimirSeparador(103, true);
    pularLinha();
    pularLinha();
    System.out.println("Você deseja jogar uma nova partida?");
    int resposta = this.inputInt();
    if(resposta == 1){
      baralho.embaralhar();
      return true;
    }
    return false;
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
    int lengthFundacoes = controller.qtdFundacoes();
    int count = 42;
    imprimirSeparador(count, false);
    for(int i = 0; i < lengthFundacoes; i++){
      System.out.print(" FUNDAÇÃO (" + (i + 7) + ") |");
    }
    pularLinha();

    imprimirSeparador(count, false);
    for(int i = 0; i < lengthFundacoes; i++){
      if(controller.fundacaoIndexIsEmpty(i)){
        System.out.print(" [          ] |");
      }else {
        System.out.print("  " + controller.getUltitmaCartaFundacaoIndex(i) + "  |");
      }      
    }
    pularLinha();
  }

  public void pularLinha(){
    System.out.println("");
  }

  public void imprimirRemanecentes(){
    int lengthMonteDeCompra = controller.lenMonteDeCompra();
    pularLinha();
    if(lengthMonteDeCompra == 0){
      System.out.println("MONTE DE COMPRA:  [        ]  | (0 Cartas)");
    }else{
      System.out.println("MONTE DE COMPRA:  [   XX   ]  | (" + lengthMonteDeCompra + " Cartas)");
    }

    int lengthCartasCompradas = controller.lenCartasCompradas();
    Carta ultimaCartaComprada = controller.getUltimaCartaComprada();
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
    System.out.println("1 - Comprar carta / Recarregar Monte de Compra");
    System.out.println("2 - Mover carta(s)");
    System.out.println("3 - Exibir Jogo");
    System.out.println("4 - Reiniciar partida");
    System.out.println("5 - Finalizar o jogo");
    int resposta = this.inputInt();
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
      case 3: {
        return true;
      }
      case 4: {
        int restartBaralho = menuRestartarJogo();
        return opcoesRestartarJogo(restartBaralho);
      }
      case 5: {
        System.exit(0);
        return false;
      }
      case -99: {
        try {
          throw new EntradaInválidaException("Entrada não suportada");
        } catch (EntradaInválidaException e) {
          ErrorHandler.exception(e);
          return true;
        }
      }
      default:
        return true;
    }
    return true;
  }

  public int menuRestartarJogo(){
    System.out.println("Você deseja:");
    System.out.println("1 - Recomeçar essa partida");
    System.out.println("2 - Nova partida");
    System.out.println("3 - CANCELAR");
    int resposta = this.inputInt();
    return resposta;
  }

  public boolean opcoesRestartarJogo(int resposta){
    if(resposta == 3){
      restartGame = false;
      return true;
    }
    restartGame = true;
    if(resposta == 2){
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
    int resposta = this.inputInt();
    return resposta;
  }

  public void moverCarta(int resposta){
    if(resposta < 8 && resposta >= 0){
      printarJogo();
      if(resposta == 7){
        moverCartaDoMonteComprado();
      }
      else{
        moverCartaDasFileiras(resposta);
      }
    }
  }

  public void moverCartaDoMonteComprado(){
    Carta aMover = null;
    try {
      aMover = controller.popCartasCompradas();
      System.out.println("\nCarta: " + aMover);
    } catch (MovimentoInvalidoException e) {
      ErrorHandler.exception(e);
    }

    if(aMover != null){
      int destino = menuDestinoMoverCarta(true);
      
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

  public void moverCartaDasFileiras(int indexFileira){
    Fileira fileira = controller.fileiras[indexFileira];

    int indiceASerMovido;

    if(fileira.qtdCartasViradas() == 1){
      indiceASerMovido = fileira.getUltimoIndex();
      System.out.println("\nCarta: " + fileira.getUltimaCarta().toString());

    }else{
      try {
        indiceASerMovido = fromIndexFileiraASerMovido(fileira, indexFileira);
      } catch (MovimentoInvalidoException e) {
        ErrorHandler.exception(e);
        return;
      }
    }
    
    ArrayList<Carta> aMover = fileira.fatiarAPartirDe(indiceASerMovido);

    if(aMover.size() == 1){
      int destino = menuDestinoMoverCarta(true);

      if(destino == indexFileira){
        fileira.forcarAddVarias(aMover);
        return;
      }


      if(destino >= 0 && destino <= 10){
        try {
          controller.moveUma(aMover.get(0), destino);
        } catch (MovimentoInvalidoException e) {
          fileira.forcarAddVarias(aMover);
          ErrorHandler.exception(e);
        }
      }
      
    }else{
      int destino = menuDestinoMoverCarta(false);

      if(destino == indexFileira){
        fileira.forcarAddVarias(aMover);
        return;
      }

      if(destino >= 0 && destino <= 6){

        try {
          controller.moveVarias(aMover, destino);
        } catch (MovimentoInvalidoException e) {
          fileira.forcarAddVarias(aMover);
          ErrorHandler.exception(e);
        }
      }else if(destino >= 7 && destino <= 10) {
        try {
          throw new MovimentoInvalidoException("Várias cartas não podem ser movimentadas para as fundações");
        } catch (MovimentoInvalidoException e) {
          fileira.forcarAddVarias(aMover);
          ErrorHandler.exception(e);
        }
      }
    }

    fileira.checkUltimaCarta();
  }

  public int fromIndexFileiraASerMovido(Fileira fileira, int indexFileira) throws MovimentoInvalidoException{
    System.out.println("\nA partir de qual carta da fileira " + indexFileira +" você deseja mover?");
    int[] indexes = fileira.indexPrimeiraEUltimaCartaVirada();
    int aux = indexes[0];
    for(Carta c: fileira.getCartasViradas()){
      System.out.println(aux + " - " + c.toString());
      aux++;
    }

    int indiceASerMovido = this.inputInt();

    if(indiceASerMovido < indexes[0] || indiceASerMovido > indexes[1]){
      throw new MovimentoInvalidoException("O índice da fileira " + indexFileira + " deve estar entre os índices " + indexes[0] + " e " + indexes[1]);
    }

    printarJogo();
    System.out.print("\nCartas: ");
    System.out.print(fileira.get(indiceASerMovido));
    for(int i = indiceASerMovido + 1; i <= indexes[1]; i ++){
      System.out.print(" + " + fileira.get(i));
    }
    pularLinha();

    return indiceASerMovido;
  }

  public int menuDestinoMoverCarta(boolean incluirFundacao){
    System.out.println("Para onde você deseja mover a(s) carta(s)?");
    System.out.println("[0 ~ 6] - Fileira (Digite o número correspondente ao índice da fileira");
    if(incluirFundacao){
      System.out.println("[7 ~ 10] - Fundação (Digite o número correspondente ao índice da fundação");
    }
    System.out.println("Qualquer outra tecla para cancelar");

    return this.inputInt();
  }
}
