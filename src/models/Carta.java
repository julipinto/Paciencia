package models;

public class Carta{
  private final String naipe;
  private final String valor;
  private final int peso;

  public Carta(String naipe, String valor) {
    this.naipe = naipe;
    this.valor = valor;
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

  @Override
  public boolean equals(Object obj) {
    Carta nova = (Carta) obj;
    if(naipe.equals(nova.getNaipe()) && this.valor.equals(nova.getValor())){
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return valor + " de " + naipe;
  }

}
