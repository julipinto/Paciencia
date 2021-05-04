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

  
  /** Retorna se o Jogar venceu o jogo
   * @return boolean
   */
  public boolean venceuOJogo(){
    int count = 0;
    for(Fundacao f: fundacoes){
      count += f.length();
    }
    return count == baralho.length();
  }


  /**
   * Separa as cartas entre as fileiras e o remanecente e inicializa as fundações
   */
  public void inicializarPartida(){
    separarCartas();
    inicializarFundacoes();
  }


  public void separarCartas(){
    int somaDeCartasDasFileiras = dividirFileiras();
    gerarRemanecente(somaDeCartasDasFileiras);
  }

  public void esconderTodasAsCartas(){
    for(Carta c : baralho.cartas){
      c.esconderCarta();
    }
  }


  
  /** gera as fileiras a partir das sublistas do baralho
   * @return int
   */
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

  
  /** gera o remanecente a partir do resto do baralho
   * @param fromIndex
   */
  private void gerarRemanecente(int fromIndex){
    ArrayList<Carta> restoDoBaralho = this.baralho.subLista(fromIndex, this.baralho.length() -1);
    this.remanecente = new Remanecente(restoDoBaralho);
  }

  
  /** Remove a ultima carta da lista de cartas compradas e a devolve
   * @return Carta
   * @throws MovimentoInvalidoException
   */
  public Carta popCartasCompradas() throws MovimentoInvalidoException{
    return this.remanecente.popCartasCompradas();
  }

  
  /** 
   * @param c
   */
  public void addCartaCompradas(Carta c){
    this.remanecente.cartasCompradas.cartas.add(c);
  }

  
  /** Move uma carta aMover para um destino
   * @param aMover
   * @param destino
   * @throws MovimentoInvalidoException
   */
  public void moveUma(Carta aMover, int destino) throws MovimentoInvalidoException{
    if(destino >= 0 && destino <= 6){
      fileiras[destino].addUma(aMover);
      maiorFileira = calculaMaiorFileira();
    }else if(destino >= 7 && destino <= 10){
      fundacoes[destino - 7].inserirCarta(aMover);
    }
  }

  
  /** Move várias cartas para um destino
   * @param cartas
   * @param destino
   * @throws MovimentoInvalidoException
   */
  public void moveVarias(ArrayList<Carta> cartas, int destino) throws MovimentoInvalidoException{
    if(destino >= 0 && destino <= 6){
      fileiras[destino].addVarias(cartas);
      maiorFileira = calculaMaiorFileira();
    }
  }

  
  /** Calcula qual a maior fileira
   * @return int
   */
  public int calculaMaiorFileira(){
    int maior = 0;
    for (Fileira f: this.fileiras){
      if(f.length() > maior){
        maior = f.length();
      }
    }
    return maior;
  }

  
  /** Retorna a quantidade de fundações
   * @return int
   */
  public int qtdFundacoes() {
    return fundacoes.length;
  }

  
  /** Fundação no index está vazio
   * @param index
   * @return boolean
   */
  public boolean fundacaoIndexIsEmpty(int index) {
    return fundacoes[index].isEmpty();
  }

  
  /** Pega ultima carta da fundação index
   * @param index
   * @return Carta
   */
  public Carta getUltitmaCartaFundacaoIndex(int index) {
    return fundacoes[index].getUltimaCarta();
  }

  
  /** 
   * @return tamanho da lista de monte de compra
   */
  public int lenMonteDeCompra() {
    return remanecente.lenMonteDeCompra();
  }

  
  /** 
   * @return tamanho da lista de monte de cartas compradas
   */
  public int lenCartasCompradas() {
     return remanecente.lenCartasCompradas();
  }

  
  /** 
   * @return Ultima carta que foi comprada
   */
  public Carta getUltimaCartaComprada(){
    return remanecente.getUltimaCartaComprada();
  }

  
  /** 
   * @param modo
   */
  public void setModoJogo(int modo){
    remanecente.setModoJogo(modo);
  }

  
  /** 
   * @return pega as cartas compradas de acordo ao modo de jogo
   */
  public ArrayList<Carta> getCartasCompradas() {
    return remanecente.getCartasCompradas();
  }

}