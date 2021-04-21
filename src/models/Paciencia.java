package models;
import controllers.CartasController;
import utils.Jogo;

public class Paciencia extends Jogo {
  CartasController cartasController;
  private Baralho [] fundacoes;
  private Baralho fileiras[] = new Baralho[7];
  private Baralho remanecentes;

  public Paciencia(Baralho baralho){
    super(baralho);
    cartasController = new CartasController();
  }

  @Override
  public void jogar() {
    dividirBaralho();
    for(int i = 0; i < fileiras.length; i++){
      System.out.print("FUNDAÇÃO " +  i + ": ");
      fileiras[i].printarBaralho();
    }
    // Baralho novo = cartasController.fatiarBaralho(this.baralho, 0, 1);
    // novo.printarBaralho();
  }

  private void dividirBaralho(){
    int sum = 0;
    for(int i = 0; i < 7; i++){
      Baralho novo = cartasController.fatiarBaralho(this.baralho, sum, sum + i);
      fileiras[i] = novo;
      int qtd = i + 1;
      sum += qtd;

    }
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
