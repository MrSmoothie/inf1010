//class for all doctors
class Lege extends Person implements Lik{
  Lege(String input){
    super(input);
  }

  //method for comparing name of doctor, going to be used later in the software.
  public boolean samme(String input){
    if(input.equals(getNavn())){  //checking if the inputname is the same.
      return true;
    }
    return false;
  }
}
