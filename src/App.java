import models.Baralho;
import models.factories.BaralhoFactory;
import models.factories.JogoFactory;
import utils.Jogo;

public class App {
    public static void main(String[] args) throws Exception {
        BaralhoFactory baralhoFactory = new BaralhoFactory();
        boolean embaralhado = true;
        Baralho baralho = baralhoFactory.gerarBaralho(embaralhado);
        
        String option = "paciencia";
        Jogo jogo = JogoFactory.gerar(option, baralho);
        jogo.jogar();
    }
}
