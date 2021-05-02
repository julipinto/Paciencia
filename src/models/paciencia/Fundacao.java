package models.paciencia;

import java.util.ArrayList;

import errors.MovimentoInvalidoException;
import models.Carta;
import models.ListaDeCartas;

public class Fundacao extends ListaDeCartas {

  public Fundacao() {
    cartas = new ArrayList<Carta>();
  }

  public void inserirCarta(Carta carta) throws MovimentoInvalidoException{
    if(confereFundacaoVazia(carta)){
      throw new MovimentoInvalidoException("A carta inicial de uma fundação deve ser Ás");
    }

    if(!confereInsercao(carta)){
      throw new MovimentoInvalidoException("Somente a carta seguinte do mesmo naipe pode ser inserida");
    }

    this.cartas.add(carta);
  }

  private boolean confereFundacaoVazia(Carta carta){
    return (this.isEmpty() && !carta.valor.equals("A"));
  }

  private boolean confereInsercao(Carta carta){
    if(this.isEmpty()) return true;
    return this.getUltimaCarta().distanciaMesmoNaipe(carta) == 1;
  }
  
}
