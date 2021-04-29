package models;

import errors.MovimentoInvalidoException;

public class Carta {
  public final String naipe;
  public final String valor;
  public final String simbolo;
  public final String cor;
  public String ansiTerminalColor[];
  public boolean face;
  public final int peso;

  public Carta(String naipe, String valor, String simbolo, String cor, String[] ansiTerminalColor, int peso) {
    this.naipe = naipe;
    this.valor = valor;
    this.simbolo = simbolo;
    this.cor = cor;
    this.ansiTerminalColor = ansiTerminalColor;
    this.peso = peso;
    this.face = false;
  }

  public void mostrarCarta(){
    this.face = true;
  }

  public void esconderCartat(){
    this.face = false;
  }

  private int distancia(Carta carta){

    return carta.peso - this.peso;
  }

  public int distanciaEntreCores(Carta carta) throws MovimentoInvalidoException{
    if(this.cor.equals(carta.cor)){
      throw new MovimentoInvalidoException("As cartas tem a mesma cor");
    }
    return distancia(carta);
  }

  public int distanciaMesmoNaipe(Carta carta){
    if(!this.naipe.equals(carta.naipe)){
      return -99;
    }
    return distancia(carta);
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Carta){
      Carta nova = (Carta) obj;
      if(naipe.equals(nova.naipe) && this.valor.equals(nova.valor)){
        return true;
      }
    }
    return false;
  }

  private String consoleCarta(String content){
    if(face){
      return ansiTerminalColor[0] + "[" + content + "]" + ansiTerminalColor[1];
    }else {
      return "[" + content + "]";
    }
  }

  @Override
  public String toString() {
    String content;
    if(this.face){
      if(valor.equals("10")){
        //diminuir um espaço para não quebrar no console com as cartas 10
        content = valor + " de " + simbolo + " ";
      }else{
        content = " " + valor + " de " + simbolo + " ";
      }
    }else{
      content = "   XX   ";
    }
    return consoleCarta(content);

  }
}
