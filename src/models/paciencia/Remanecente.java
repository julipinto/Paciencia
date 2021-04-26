package models.paciencia;

import java.util.ArrayList;

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

  public Carta getUltimaCartaComprada() { 
    if(cartasCompradas.size() == 0){
      return null;
    }
    return cartasCompradas.get(cartasCompradas.size() -1);
  }
}
