package controllers;

import java.util.ArrayList;

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

  public PacienciaController(Baralho baralho) {
    this.baralho = baralho;
  }


  public void separarCartas(){
    int somaDeCartasDasFileiras = dividirFileiras();
    gerarRemanecente(somaDeCartasDasFileiras);
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
    return sum;
  }

  private void gerarRemanecente(int fromIndex){
    ArrayList<Carta> restoDoBaralho = this.baralho.fatiar(fromIndex, this.baralho.length -1);
    this.remanecente = new Remanecente(restoDoBaralho);
  }

}
