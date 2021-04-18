package controllers;

import java.util.ArrayList;

import models.Carta;
import utils.ConfiguracaoBaralho;

public class CartaController {

  public CartaController(ConfiguracaoBaralho config) {
    ArrayList<Carta> cartas = config.gerarBaralho();
    for(Carta c: cartas){
      System.out.println(c.toString());
    }
  }

}
