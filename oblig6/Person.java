//class for all people in the software, containg their name or more if needed.
abstract class Person implements Lik{
  String navn;
  Person(String input){
    this.navn = input;
  }

  public String toString(){
    return navn;
  }
  public String getNavn(){
    return navn;
  }

  public boolean samme(String input){
    return navn == input;
  }
}
