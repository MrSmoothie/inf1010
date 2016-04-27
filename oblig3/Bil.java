//importing java utility for decimal numbers.
import java.text.DecimalFormat;

//class for all cars
class Bil{
  protected String bilNr;

  //constructor setting car number
  Bil(String bilNrInn){
      bilNr = bilNrInn;
  }

  //method for returning the car number
  public String getBilNr(){
    return bilNr;
  }

  //method for printing out information about the car. 
  public void skrivUt(){
    System.out.println("-------------------------------------");
    System.out.printf("Bilnummeret til bilen er %s.", getBilNr());
    System.out.println("-------------------------------------");
  }
}
