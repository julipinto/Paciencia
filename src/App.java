import models.Baralho;
import models.BaralhoFactory;
import models.JogoFactory;
import utils.Jogo;

public class App {
    public static void main(String[] args) throws Exception {
        String option = "paciencia";
        BaralhoFactory baralhoFactory = new BaralhoFactory();
        Baralho baralho = baralhoFactory.gerarBaralho();
        Jogo jogo = JogoFactory.gerar(option, baralho);
        jogo.jogar();
    }
}
