package models;

import java.util.ArrayList;
import java.util.Collections;

import utils.ListaDeCartas;

public class Baralho extends ListaDeCartas{
  public Baralho(ArrayList<Carta> cartas) {
    super(cartas);
  }

  public Baralho(){}

  public void embaralhar(){
    Collections.shuffle(cartas);
  }

}
