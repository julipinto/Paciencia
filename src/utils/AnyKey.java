package utils;

public class AnyKey {
  private AnyKey(){}

  static public void pressToContinue(){
    System.out.print("Digite qualquer tecla para continuar");
    try{
      System.in.read();
    }catch(Exception e){}
  }
}
