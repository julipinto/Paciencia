package models;

import java.util.ArrayList;
import java.util.Collections;

public class Baralho extends ListaDeCartas{
  public Baralho(ArrayList<Carta> cartas) {
    super(cartas);
  }

  public Baralho(){}

  /**
   * Embaralha o baralho
   */
  public void embaralhar(){
    Collections.shuffle(cartas);
  }

}
