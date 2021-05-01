package controllers;

import java.util.ArrayList;

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
  public int maiorFileira;

  public PacienciaController(Baralho baralho) {
    this.baralho = baralho;
    inicializarFundacoes();
  }

  private void inicializarFundacoes(){
    for(int i=0; i <= 3; i++){
      fundacoes[i] = new Fundacao();
    }
  }

  public boolean venceuOJogo(){
    int count = 0;
    for(Fundacao f: fundacoes){
      count += f.length();
    }
    return count == baralho.length();
  }


  public void inicializarPartida(){
    separarCartas();
    inicializarFundacoes();
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
      ArrayList<Carta> subLista = this.baralho.subLista(sum, sum + i);
      subLista.get(i).mostrarCarta();
      this.fileiras[i] = new Fileira(subLista);
      int qtd = i + 1;
      sum += qtd;
    }
    maiorFileira = 7;
    return sum;
  }

  private void gerarRemanecente(int fromIndex){
    ArrayList<Carta> restoDoBaralho = this.baralho.subLista(fromIndex, this.baralho.length() -1);
    this.remanecente = new Remanecente(restoDoBaralho);
  }

  public Carta popCartasCompradas() throws MovimentoInvalidoException{
    return this.remanecente.popCartasCompradas();
  }

  public void addCartaCompradas(Carta c){
    this.remanecente.cartasCompradas.add(c);
  }

  public void moveUma(Carta aMover, int destino) throws MovimentoInvalidoException{
    if(destino >= 0 && destino <= 6){
      fileiras[destino].addUma(aMover);
      maiorFileira = calculaMaiorFileira();
    }else if(destino >= 7 && destino <= 10){
      fundacoes[destino - 7].inserirCarta(aMover);
    }
  }

  public void moveVarias(ArrayList<Carta> cartas, int destino) throws MovimentoInvalidoException{
    if(destino >= 0 && destino <= 6){
      fileiras[destino].addVarias(cartas);
      maiorFileira = calculaMaiorFileira();
    }
  }

  public int calculaMaiorFileira(){
    int maior = 0;
    for (Fileira f: this.fileiras){
      if(f.length() > maior){
        maior = f.length();
      }
    }
    return maior;
  }

  public int qtdFundacoes() {
    return fundacoes.length;
  }

  public boolean fundacaoIndexIsEmpty(int index) {
    return fundacoes[index].isEmpty();
  }

  public Carta getUltitmaCartaFundacaoIndex(int index) {
    return fundacoes[index].getUltimaCarta();
  }

  public int lenMonteDeCompra() {
    return remanecente.lenMonteDeCompra();
  }

  public int lenCartasCompradas() {
     return remanecente.lenCartasCompradas();
  }

  public Carta getUltimaCartaComprada(){
    return remanecente.getUltimaCartaComprada();
  }

}
