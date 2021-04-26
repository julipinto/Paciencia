package models;

public class Carta{
  public final String naipe;
  public final String valor;
  public final String simbolo;
  public final String cor;
  public boolean face;
  public final int peso;

  public Carta(String naipe, String valor, String simbolo, String cor, int peso) {
    this.naipe = naipe;
    this.valor = valor;
    this.simbolo = simbolo;
    this.cor = cor;
    this.peso = peso;
    this.face = false;
  }

  public void mostrarCarta(){
    this.face = true;
  }

  public void esconderCartat(){
    this.face = false;
  }

  public int medirtDistancia(Carta carta, boolean considerarNaipe){
    if(carta.naipe != this.naipe && considerarNaipe){
      return -99;
    }
    else{
      return peso - this.peso;
    }
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

  @Override
  public String toString() {
    if(this.face){
      if(valor.equals("10")){
        //diminuir um espaço para não quebrar no console com as cartas 10
        return "[" + valor + " de " + simbolo + " ]";
      }
      return "[ " + valor + " de " + simbolo + " ]";
    }else{
      return "[   XX   ]";
    }
    
  }

}
