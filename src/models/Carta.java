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

  /**
   * Seta o face para true
   */
  public void mostrarCarta(){
    this.face = true;
  }

  /**
   * Seta o face para false
   */
  public void esconderCarta(){
    this.face = false;
  }

  
  /** Mede a distância entre a carta atual e a carta passada por parâmetro
   * ex: a distancia entre a carta 10 e a carta J é 1
   * @param carta
   * @return int
   */
  private int distancia(Carta carta){
    return carta.peso - this.peso;
  }

  
  /** Mede a distância levando em consideração cores alternadas
   * @param carta
   * @return int
   * @throws MovimentoInvalidoException
   */
  public int distanciaEntreCores(Carta carta) throws MovimentoInvalidoException{
    if(this.cor.equals(carta.cor)){
      throw new MovimentoInvalidoException("As cartas tem a mesma cor");
    }
    return distancia(carta);
  }

  
  /** Mede distância levando em consideração ser do mesmo naipe
   * @param carta
   * @return int
   * @throws MovimentoInvalidoException
   */
  public int distanciaMesmoNaipe(Carta carta) throws MovimentoInvalidoException{
    if(!this.naipe.equals(carta.naipe)){
      throw new MovimentoInvalidoException("As cartas não tem o mesmo naipe");
    }
    return distancia(carta);
  }

  
  /** Caso a carta esteja virada para cima ela recebe os caracteres para ser pintada no terminal
   * @param content
   * @return String
   */
  private String consoleCarta(String content){
    if(face){
      return ansiTerminalColor[0] + "[" + content + "]" + ansiTerminalColor[1];
    }else {
      return "[" + content + "]";
    }
  }

  
  /** retorna a carta já formatada como [ Valor de Símbolo ]
   * @return String
   */
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
