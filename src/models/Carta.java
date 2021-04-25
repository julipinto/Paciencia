package models;

public class Carta{
  private final String naipe;
  private final String valor;
  private final String simbolo;
  private final String cor;
  private boolean face;
  private final int peso;

  public Carta(String naipe, String valor, String simbolo, String cor, int peso) {
    this.naipe = naipe;
    this.valor = valor;
    this.simbolo = simbolo;
    this.cor = cor;
    this.peso = peso;
    this.face = false;
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
