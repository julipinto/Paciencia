import controllers.CartaController;
import utils.ConfiguracaoBaralho;

public class App {
    public static void main(String[] args) throws Exception {
        ConfiguracaoBaralho config = new ConfiguracaoBaralho();
        CartaController controller = new CartaController(config);
    }
}
