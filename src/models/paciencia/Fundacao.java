package models.paciencia;

import java.util.ArrayList;

import models.Carta;
import utils.ListaDeCartas;

public class Fundacao extends ListaDeCartas {
  boolean considerarNaipe = true;

  public Fundacao() {
    cartas = new ArrayList<Carta>();
  }

  public void inserirCarta(Carta carta){
    if(!(this.length() == 0 && carta.peso == 0)){
      // não pode inserir
      throw new Error("A carta inicial deve ser Ás");
    }

    // if(this.getUltimaCarta().medirtDistancia(carta, considerarNaipe) != 1){
    //   // não pode inserir uma carta que seja diferente da sequencia
    //   throw new Error("Não pode inserir uma carta que seja diferente da sequencia");
    // }

    this.cartas.add(carta);
  }
  
}
