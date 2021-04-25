package views;
import java.util.ArrayList;

import models.Baralho;
import models.Carta;
import models.paciencia.Fileira;
import models.paciencia.Fundacao;
import models.paciencia.Remanecente;
import utils.Jogo;

public class Paciencia extends Jogo {
  // private Baralho fundacoes[] = new Baralho[4];
  private Fundacao fundacoes[] = new Fundacao[4];
  private Fileira fileiras[] = new Fileira[7];
  private Remanecente remanecente;

  public Paciencia(Baralho baralho){
    super(baralho);
  }
 
  @Override
  public void jogar() {
    boolean res = false;

    do {
      res = fluxoDeJogo();
    } while (res);
  }

  public boolean fluxoDeJogo(){
    int somaDeCartasDasFileiras = dividirFileiras();
    gerarRemanecente(somaDeCartasDasFileiras);
    printarJogo();

    return false;
  }

  private int dividirFileiras(){
    int sum = 0;
    for(int i = 0; i < 7; i++){
      ArrayList<Carta> fatia = this.baralho.fatiar(sum, sum + i);
      this.fileiras[i] = new Fileira(fatia);
      int qtd = i + 1;
      sum += qtd;
    }
    return sum;
  }

  private void gerarRemanecente(int fromIndex){
    ArrayList<Carta> restoDoBaralho = this.baralho.fatiar(fromIndex, this.baralho.length -1);
    this.remanecente = new Remanecente(restoDoBaralho);
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
