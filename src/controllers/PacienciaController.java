package controllers;

import java.util.ArrayList;
import java.util.Iterator;

import errors.MovimentoInvalidoException;
import models.Baralho;
import models.Carta;
import models.paciencia.Fileira;
import models.paciencia.Fundacao;
import models.paciencia.Remanecente;

public class PacienciaController {
  public Fundacao fundacoes[] = new Fundacao[4];
  public Fileira fileiras[] = new Fileira[7];
  public Remanecente remanecente;
  public Baralho baralho;
  //ATUALIZAR A VARIÁVEL TODA VEZ QUE ADICIONAR CARTAS
  public int maiorFileira;

  public PacienciaController(Baralho baralho) {
    this.baralho = baralho;
  }


  public void separarCartas(){
    int somaDeCartasDasFileiras = dividirFileiras();
    gerarRemanecente(somaDeCartasDasFileiras);
  }

  public void virarCartas(){
    for(Carta c : baralho.cartas){
      c.esconderCartat();
    }
  }


  private int dividirFileiras(){
    int sum = 0;
    for(int i = 0; i < 7; i++){
      ArrayList<Carta> fatia = this.baralho.fatiar(sum, sum + i);
      fatia.get(i).mostrarCarta();
      this.fileiras[i] = new Fileira(fatia);
      int qtd = i + 1;
      sum += qtd;
    }
    maiorFileira = 7;
    return sum;
  }

  private void gerarRemanecente(int fromIndex){
    ArrayList<Carta> restoDoBaralho = this.baralho.fatiar(fromIndex, this.baralho.length -1);
    this.remanecente = new Remanecente(restoDoBaralho);
  }

  public Carta popCartasCompradas() throws MovimentoInvalidoException{
    return this.remanecente.popCartasCompradas();
  }

  public void addCartaCompradas(Carta c){
    this.remanecente.cartasCompradas.add(c);
  }

  public void moveUma(Object aMover, int destino) throws MovimentoInvalidoException{
    if(destino >= 0 && destino <= 6){
      fileiras[destino].addUma((Carta) aMover);
      if(fileiras[destino].length() > maiorFileira){
        maiorFileira = fileiras[destino].length();
      }
    }
  }

}
