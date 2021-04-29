package errors;
import utils.AnyKey;

public class ErrorHandler {
  static public void exception(Exception e){    
    System.out.println("\u001B[33m" + "[ATENÇÃO]: " + e.getMessage() + "\u001B[0m");
    AnyKey.pressToContinue();
  }
}

