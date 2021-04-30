package errors;

public class EntradaInválidaException extends Exception {
  public EntradaInválidaException() {
  }

  public EntradaInválidaException(String message) {
      super("ENTRADA INVÁLIDA: " + message);
  }
}