package errors;

public class GameDidntFoundException extends Exception {
  public GameDidntFoundException() {
  }

  public GameDidntFoundException(String message) {
      super(message);
  }
}
