package errors;

public class MovimentoInvalidoException extends Exception {
  public MovimentoInvalidoException() {
  }

  public MovimentoInvalidoException(String message) {
    super("MOVIMENTO INVÁLIDO: " + message);
  }
  
}
