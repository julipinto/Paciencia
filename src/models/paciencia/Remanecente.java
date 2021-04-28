package models.paciencia;

import java.util.ArrayList;

import errors.MovimentoInvalidoException;
import models.Carta;

public class Remanecente {
  public ArrayList<Carta> monteDeCompra;
  public ArrayList<Carta> cartasCompradas;
  
  public Remanecente(ArrayList<Carta> cartas) {
    this.monteDeCompra = cartas;
    cartasCompradas = new ArrayList<Carta>();
  }
  
  public void comprarCarta(){
    if(monteDeCompra.size() > 0) {
      Carta ultima = monteDeCompra.remove(monteDeCompra.size() -1);
      ultima.mostrarCarta();
      cartasCompradas.add(ultima);
    }
  }

  public Carta popCartasCompradas() throws MovimentoInvalidoException{
    if(cartasCompradas.isEmpty()) {
      throw new MovimentoInvalidoException("O monte de cartas compradas está vazio");
    }
    return cartasCompradas.remove(cartasCompradas.size() -1);
  }

  public int lenMonteDeCompra(){
    return monteDeCompra.size();
  }
  public int lenCartasCompradas(){
    return cartasCompradas.size();
  }

  public Carta getUltimaCartaComprada() { 
    if(cartasCompradas.isEmpty()){
      return null;
    }
    return cartasCompradas.get(cartasCompradas.size() -1);
  }
}
