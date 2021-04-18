import models.Baralho;
import models.JogoFactotry;
import utils.Jogo;

public class App {
    public static void main(String[] args) throws Exception {
        Baralho baralho = new Baralho();
        String option = "paciencia";
        Jogo jogo = JogoFactotry.gerar(option, baralho);
        //CartaController controller = new CartaController(baralho);
    }
}
