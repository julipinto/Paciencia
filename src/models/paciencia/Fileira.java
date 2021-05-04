package models.paciencia;

import java.util.ArrayList;

import errors.MovimentoInvalidoException;
import models.Carta;
import models.ListaDeCartas;

public class Fileira extends ListaDeCartas {

  public Fileira(ArrayList<Carta> cartas) {
    super(cartas);
  }

  
  /** Adiciona uma carta na fileira
   * @param carta
   * @throws MovimentoInvalidoException
   */
  public void addUma(Carta carta) throws MovimentoInvalidoException {
    if(verificaCartaK(carta)){
      throw new MovimentoInvalidoException("A carta K só pode ser inserida a uma fileira vazia, e uma fileira vazia só pode ser inserida uma carta K");
    }

    if(podeSerAdicionadaAFileira(carta)){
      throw new MovimentoInvalidoException("A carta não pode ser adicionada.");
    }

    this.addUmaCartaNoFinal(carta);
  }

  
  /** Adiciona um array de cartas a fileira
   * @param cartas
   * @throws MovimentoInvalidoException
   */
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

  
  /** Força a inserção de cartas na filera sem passar pelas regras de negocio dela
   * @param cartas
   */
  public void forcarAddVarias(ArrayList<Carta> cartas){
    this.addVariasCartasNoFinal(cartas);
  }

  
  /** Pega a ultima carta da fileira atual e verifica se a carta tem distância 1
   * @param carta
   * @return boolean
   * @throws MovimentoInvalidoException
   */
  private boolean podeSerAdicionadaAFileira(Carta carta) throws MovimentoInvalidoException {
    if(!isEmpty()){
      int distancia = carta.distanciaEntreCores(this.getUltimaCarta());
      return distancia != 1;
    }
    return false;
  }

  
  /** Verificação para o critério da carta K só poder ser adicionada numa fileira vazia
   * ou a fileira vazia só poder receber uma carta K
   * @param carta
   * @return boolean
   */
  private boolean verificaCartaK(Carta carta){ 
    return (this.isEmpty() ^ carta.valor.equals("K"));
  }

  
  /** 
   * @return ArrayList<Carta> Lista das cartas que estão viradas nessa fileira
   */
  public ArrayList<Carta> getCartasViradas(){
    ArrayList<Carta> cartas = new ArrayList<>();
    for(Carta carta : this.cartas){
      if(carta.face == true) {
        cartas.add(carta);
      }
    }
    return cartas;
  }

  
  /** Pega índice da primeira e da ultima carta que estão viradas na fileira
   * Ex: [x][x][x][V][V][V] (V == carta virada) -> return [3, 5]  
   * @return int[]
   */
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
  
  
  /** pega a quantidade de cartas viradas na fileira
   * @return int
   */
  public int qtdCartasViradas(){
    int soma = 0;
    for(Carta c: this.cartas){
      if(c.face == true){
        soma+= 1;
      }
    }
    return soma;
  }

  /**
   * Checa se a ultima carta da fileira está virada para poder ser virada automaticamente 
   */
  public void checkUltimaCarta(){
    if(!this.isEmpty()){
      Carta ultimaCarta = this.getUltimaCarta();
      ultimaCarta.mostrarCarta();
    }
  }
}
