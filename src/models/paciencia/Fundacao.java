package models.paciencia;

import java.util.ArrayList;

import errors.MovimentoInvalidoException;
import models.Carta;
import models.ListaDeCartas;

public class Fundacao extends ListaDeCartas {

  public Fundacao() {
    this.cartas = new ArrayList<Carta>();
  }

  
  /** Insere a carta na fundação
   * @param carta
   * @throws MovimentoInvalidoException
   */
  public void inserirCarta(Carta carta) throws MovimentoInvalidoException{
    if(confereFundacaoVazia(carta)){
      throw new MovimentoInvalidoException("A carta inicial de uma fundação deve ser Ás");
    }

    if(!confereInsercao(carta)){
      throw new MovimentoInvalidoException("Somente a carta seguinte do mesmo naipe pode ser inserida");
    }

    this.cartas.add(carta);
  }

  
  /** Comfere se a fundação é vazia e se a carta recebida tem o valor A
   * @param carta
   * @return boolean
   */
  private boolean confereFundacaoVazia(Carta carta){
    return (this.isEmpty() && !carta.valor.equals("A"));
  }

  
  /** Confere se a ultima carta que está inserida na fundação tem a medida de distância
   * de 1 para poder ser inserida (Caso a fundação esteja vazia quer dizer que ela não caiu no tratamento
   * de erro da carta A, então pode continuar a ser inserida)
   * @param carta
   * @return boolean
   * @throws MovimentoInvalidoException
   */
  private boolean confereInsercao(Carta carta) throws MovimentoInvalidoException{
    if(this.isEmpty()) return true;
    return this.getUltimaCarta().distanciaMesmoNaipe(carta) == 1;
  }
  
}
