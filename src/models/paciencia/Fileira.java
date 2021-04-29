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

  public void addUma(Carta carta) throws MovimentoInvalidoException {
    if(this.isEmpty() && !carta.valor.equals('K')){
      throw new MovimentoInvalidoException("A carta K só pode ser adicionada numa fileira vazia");
    }
    int distancia = carta.distanciaEntreCores(this.getUltimaCarta());
    if(distancia != 1){
      throw new MovimentoInvalidoException("A carta não pode ser adicionada.");
    }

    this.addUmaCartaNoFinal(carta);
  }
  
}
