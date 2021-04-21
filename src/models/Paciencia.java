package models;
import controllers.CartasController;
import utils.Jogo;

public class Paciencia extends Jogo {
  CartasController cartasController;
  private Baralho[] fundacoes;

  public Paciencia(Baralho baralho){
    super(baralho);
    cartasController = new CartasController();
  }

  @Override
  public void jogar() {
    Baralho novo = cartasController.fatiarBaralho(this.baralho, 0, 1);
    novo.printarBaralho();
  }


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
