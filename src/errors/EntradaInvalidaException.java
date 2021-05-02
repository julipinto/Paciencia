package errors;

public class EntradaInvalidaException extends Exception {
  public EntradaInvalidaException() {
  }

  public EntradaInvalidaException(String message) {
      super("ENTRADA INVÁLIDA: " + message);
  }
}