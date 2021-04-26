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

  public Remanecente(){}
  
}
