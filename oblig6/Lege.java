//class for all doctors
class Lege implements Comparable<Lege>, Lik{
  private String navn;
  Lege(String input){
    this.navn = input;
  }

  public String toString(){
    return navn;
  }
  public int compareTo(Lege l){
    return navn.compareTo(l.navn);
  }

  public boolean samme(String input){
    if(navn.equals(input)){
      return true;
    }
    else{
      return false;
    }
  }
}
