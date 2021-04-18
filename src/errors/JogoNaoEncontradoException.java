package errors;

public class JogoNaoEncontradoException extends Exception {
  public JogoNaoEncontradoException() {
  }

  public JogoNaoEncontradoException(String message) {
      super(message);
  }
}
