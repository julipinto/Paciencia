package models.paciencia;

import java.util.ArrayList;

import models.Carta;
import utils.ListaDeCartas;

public class Fileira extends ListaDeCartas{
  public int qtdCartasViradas;

  public Fileira(ArrayList<Carta> cartas) {
    super(cartas);
    qtdCartasViradas = 1;
  }  
  
}
