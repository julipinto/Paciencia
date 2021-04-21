package controllers;

import java.util.ArrayList;

import models.Baralho;
import models.Carta;

public class CartasController {

  public Baralho fatiarBaralho(Baralho baralho, int de, int para){
    ArrayList<Carta> cartas = baralho.getCartas();
    ArrayList<Carta> fatia = new ArrayList<Carta>(cartas.subList(de, para + 1));
    return new Baralho(fatia);
  }
  
}
