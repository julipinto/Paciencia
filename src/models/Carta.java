package models;

public class Carta{
  private final String naipe;
  private final String valor;
  private final String simbolo;
  private boolean face;
  private final int peso;

  public Carta(String naipe, String valor, String simbolo) {
    this.naipe = naipe;
    this.valor = valor;
    this.simbolo = simbolo;
    this.face = false;
    this.peso = this.convertValorToPeso(valor);
  }

  public String getNaipe() {
    return naipe;
  }

  public String getValor() {
    return valor;
  }

  public int getPeso() {
    return peso;
  }

  public String getSimbolo() {
    return simbolo;
  }

  public boolean isFace() {
    return face;
  }

  public void setFace(boolean face) {
    this.face = face;
  }

  public int convertValorToPeso(String valor){
    switch (valor) {
      case "K":
          return 13;
      case "Q":
          return 12;
      case "J":
          return 11;
      case "A":
          return 1;
      default:
          return Integer.parseInt(valor);
    }
  } 

  public int getDistancia(Carta carta, boolean considerarNaipe){
    if(carta.getNaipe() != naipe && considerarNaipe){
      return -99;
    }
    else{
      return peso - carta.getPeso();
    }
  }
  
  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Carta){
      Carta nova = (Carta) obj;
      if(naipe.equals(nova.getNaipe()) && this.valor.equals(nova.getValor())){
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return valor + " de " + simbolo;
  }

}
