package models.paciencia;

import java.util.ArrayList;

import errors.MovimentoInvalidoException;
import models.Carta;
import utils.ListaDeCartas;

public class Fileira extends ListaDeCartas {
  public int qtdCartasViradas;

  public Fileira(ArrayList<Carta> cartas) {
    super(cartas);
    qtdCartasViradas = 1;
  }

  public void addUma(Carta c) throws MovimentoInvalidoException {
    int distancia = c.distanciaEntreCores(this.getUltimaCarta());

    System.out.println(distancia);
    if(distancia == 1){
      this.addUmaCartaNoFinal(c);
    }else{
      throw new MovimentoInvalidoException("A carta não pode ser adicionada.");
    }
  }
  
}
