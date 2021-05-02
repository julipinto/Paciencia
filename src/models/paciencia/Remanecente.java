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

  public int getModoJogo() {
    return this.modoJogo;
  }

  public void setModoJogo(int modoJogo) {
    this.modoJogo = modoJogo;
  }
  
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

  public Carta popCartasCompradas() throws MovimentoInvalidoException{
    if(cartasCompradas.isEmpty()) {
      throw new MovimentoInvalidoException("O monte de cartas compradas está vazio");
    }
    return cartasCompradas.cartas.remove(cartasCompradas.getUltimoIndex());
  }

  public int lenMonteDeCompra(){
    return monteDeCompra.length();
  }
  public int lenCartasCompradas(){
    return cartasCompradas.length();
  }

  public Carta getUltimaCartaComprada() { 
    if(cartasCompradas.isEmpty()){
      return null;
    }
    return cartasCompradas.getUltimaCarta();
  }

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