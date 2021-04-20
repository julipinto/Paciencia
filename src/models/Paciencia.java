package models;
import utils.Jogo;

public class Paciencia extends Jogo{

  public Paciencia(Baralho baralho){
    super(baralho);
  }

  @Override
  public void jogar() {
    particionarBaralho();
  }

  public void particionarBaralho(){}

  public void menuRodada(){
    System.out.println("Selecione uma opção");
    System.out.println("1 - Mover Carta");
    System.out.println("2 - Exibir Jogo");
    System.out.println("3 - Alterar Quantidade de cartas a virar do estoque");
    System.out.println("4 - Reiniciar");
    System.out.println("5 - Finalizar");
    int resposta = this.input.nextInt();
  }
}
