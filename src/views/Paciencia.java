package views;

import controllers.PacienciaController;
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
    int count = 51;
    imprimirSeparador(count, false);
    for(int i = 0; i < lengthFundacoes; i++){
      System.out.print(" FUNDAÇÃO " + i + " |");
    }
    pularLinha();

    imprimirSeparador(count, false);
    for(int i = 0; i < lengthFundacoes; i++){
      if(controller.fundacoes[i] == null){
        System.out.print(" [        ] |");
      }else {
        System.out.print(" [   XX   ] |");
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
    // System.out.println("Selecione uma opção");
    // System.out.println("1 - Mover Carta");
    // System.out.println("2 - Exibir Jogo");
    // System.out.println("3 - Alterar Quantidade de cartas a virar do estoque");
    // System.out.println("4 - Reiniciar");
    // System.out.println("5 - Finalizar");
    // int resposta = this.input.nextInt();
    System.out.println("\nSelecione uma opção");
    System.out.println("1 - Comprar carta");
    System.out.println("2 - Mover carta");
    System.out.println("3 - Exibir Jogo");

    System.out.println("4 - Reiniciar partida");
    System.out.println("5 - Finalizar o jogo");
    int resposta = this.input.nextInt();
    switch (resposta) {
      case 1: {
        controller.remanecente.comprarCarta();
      }
        break;
      case 2: {
        moverCarta();
      }
      break;
      case 4: {
        restartGame = true;
        System.out.println("Você deseja reembaralhar o baralho?");
        System.out.println("1 - SIM");
        System.out.println("2 - NÃO");
        int restartBaralho = this.input.nextInt();
        if(restartBaralho == 1){
          controller.virarCartas();
          baralho.embaralhar();
        }
        return false;
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

  public void moverCarta(){
    System.out.println("\nEscolha o monte de onde você deseja mover a carta");
    System.out.println("[0 ~ 6] - Fileira (Digite o número correspondente ao índice da fileira");
    System.out.println("7 - Cartas Compradas");
    System.out.println("8 - Voltar ao menu");
    int resposta = this.input.nextInt();
    System.out.println(resposta < 8 || resposta >= 0);
    if(resposta < 8 && resposta >= 0){
      if(resposta == 7){
        //move do monte
      }
      else {
        imprimirFileiras();
        System.out.println("\nA partir de qual carta da fileira " + resposta +" você deseja mover?");
        Fileira f = controller.fileiras[resposta];
        int indiceASerMovido;
        for(int i = 0; i < f.length(); i++){
          Carta c = f.get(i);
          if(c.face == true){
            System.out.println(i + " - " + f.get(i));
          }
        }
        indiceASerMovido = this.input.nextInt();
          if(indiceASerMovido < 0 || indiceASerMovido > f.length());
      }
    }

  }
}
