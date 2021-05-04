package models.paciencia;

import java.util.ArrayList;

import errors.MovimentoInvalidoException;
import models.Carta;
import models.ListaDeCartas;

public class Remanecente {
  public ListaDeCartas monteDeCompra;
  public ListaDeCartas cartasCompradas;
  public int modoJogo;

  public Remanecente(ArrayList<Carta> cartas) {
    for(Carta carta: cartas){
      carta.mostrarCarta();
    }
    this.monteDeCompra = new ListaDeCartas(cartas);
    this.cartasCompradas = new ListaDeCartas();
  }

  
  /** 
   * @return int
   */
  public int getModoJogo() {
    return this.modoJogo;
  }

  
  /** 1 para o modo de pegar 1 carta por vez
   * 3 para o modo de pegar 3 cartas por vez
   * @param modoJogo
   */
  public void setModoJogo(int modoJogo) {
    this.modoJogo = modoJogo;
  }
  
  /**
   * Compra carta do monte de compra para o monte comprado
   */
  public void comprarCarta(){
    if(monteDeCompra.length() > 0) {
      ArrayList<Carta> fatia;
      if(monteDeCompra.length() > modoJogo)
        fatia = monteDeCompra.fatiarAPartirDe(monteDeCompra.length() - modoJogo);
      else
        fatia = monteDeCompra.fatiarAPartirDe(0);

      cartasCompradas.addVariasCartasNoFinal(fatia);
    }else{
      cartasCompradas.reverse();
      monteDeCompra = cartasCompradas;
      cartasCompradas = new ListaDeCartas();
    }
  }

  
  /** Remove a ultima carta da lista e a devolve
   * @return Carta
   * @throws MovimentoInvalidoException
   */
  public Carta popCartasCompradas() throws MovimentoInvalidoException{
    if(cartasCompradas.isEmpty()) {
      throw new MovimentoInvalidoException("O monte de cartas compradas está vazio");
    }
    return cartasCompradas.cartas.remove(cartasCompradas.getUltimoIndex());
  }

  
  /** 
   * @return tamanho da lista de monte de compra
   */
  public int lenMonteDeCompra(){
    return monteDeCompra.length();
  }
  
  /** 
   * @return tamanho da lista de monte de cartas compradas
   */
  public int lenCartasCompradas(){
    return cartasCompradas.length();
  }

  
  /** 
   * @return Pega a ultima carta da lista de cartas compradas
   */
  public Carta getUltimaCartaComprada() { 
    if(cartasCompradas.isEmpty()){
      return null;
    }
    return cartasCompradas.getUltimaCarta();
  }

  
  /** Pega para vizualização a(s) ultima(s) carta(s) comprada(S)
   * Caso o modoJogo seja 1 ele retorna 1 carta por vez
   * Caso o modoJogo seja 3 ele retorna 3 carta por vez
   * @return ArrayList<Carta>
   */
  public ArrayList<Carta> getCartasCompradas() {
    ArrayList<Carta> cartas = null;
    int ultimoIndex = cartasCompradas.getUltimoIndex();
    if(modoJogo == 1){
      cartas = cartasCompradas.subLista(ultimoIndex, ultimoIndex);
    }else if(modoJogo == 3){
      cartas = cartasCompradas.subLista(ultimoIndex - 2, ultimoIndex);
    }

    return cartas;
  }

}