package models.paciencia;

import java.util.ArrayList;

import errors.MovimentoInvalidoException;
import models.Carta;
import utils.ListaDeCartas;

public class Fileira extends ListaDeCartas {
  public int qtdCartasViradas;

  public Fileira(ArrayList<Carta> cartas) {
    super(cartas);
  }

  public void addUma(Carta carta) throws MovimentoInvalidoException {
    if(verificaCartaK(carta)){
      throw new MovimentoInvalidoException("A carta K só pode ser inserida a uma fileira vazia, e uma fileira vazia só pode ser inserida uma carta K");
    }

    if(podeSerAdicionadaAFileira(carta)){
      throw new MovimentoInvalidoException("A carta não pode ser adicionada.");
    }

    this.addUmaCartaNoFinal(carta);
    qtdCartasViradas += 1;
  }

  public void addVarias(ArrayList<Carta> cartas) throws MovimentoInvalidoException{
    Carta primeiraCarta = cartas.get(0);

    if(verificaCartaK(primeiraCarta)){
      throw new MovimentoInvalidoException("A carta K só pode ser inserida a uma fileira vazia, e uma fileira vazia só pode ser inserida uma carta K");
    }

    if(podeSerAdicionadaAFileira(primeiraCarta)){
      throw new MovimentoInvalidoException("A carta não pode ser adicionada.");
    }

    this.addVariasCartasNoFinal(cartas);
  }

  public void forcarAddVarias(ArrayList<Carta> cartas){
    this.addVariasCartasNoFinal(cartas);
  }

  private boolean podeSerAdicionadaAFileira(Carta carta) throws MovimentoInvalidoException {
    if(!isEmpty()){
      int distancia = carta.distanciaEntreCores(this.getUltimaCarta());
      return distancia != 1;
    }
    return false;
  }

  private boolean verificaCartaK(Carta carta){ 
    return (this.isEmpty() ^ carta.valor.equals("K"));
  }

  public ArrayList<Carta> getCartasViradas(){
    ArrayList<Carta> cartas = new ArrayList<>();
    for(Carta carta : this.cartas){
      if(carta.face == true) {
        cartas.add(carta);
      }
    }
    return cartas;
  }

  public int[] indexPrimeiraEUltimaCartaVirada(){
    int primeiro = -1;
    int ultimo = this.getUltimoIndex();

    for(int index = 0; primeiro == -1; index ++){
      if(this.get(index).face == true){
        primeiro = index;
      }
    }

    int[] indexes = new int[2];
    indexes[0] = primeiro;
    indexes[1] = ultimo;

    return indexes;
  }
  
  public int qtdCartasViradas(){
    int soma = 0;
    for(Carta c: this.cartas){
      if(c.face == true){
        soma+= 1;
      }
    }
    return soma;
  }

  public void checkUltimaCarta(){
    if(!this.isEmpty()){
      Carta ultimaCarta = this.getUltimaCarta();
      ultimaCarta.mostrarCarta();
    }
  }
}
