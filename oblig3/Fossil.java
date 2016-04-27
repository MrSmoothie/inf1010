//Import java text utility for decimals
import java.text.DecimalFormat;

//class for all fossil cars
class Fossil extends Bil{
  protected double co2;

  //contructor setting car number and co2 realse
  Fossil(String bilnr, double co2Inn){
    super(bilnr);
    co2 = co2Inn;
  }

  //method for returning the co2 release
  public String getCo2(){
    DecimalFormat df = new DecimalFormat("#.##");
    return df.format(co2);
  }

  //method for printing information about the car
  public void skrivUt(){
    System.out.println("-------------------------------------");
    System.out.printf("Bilnummeret til bilen er %s.\nDen slipper ut %s co2.", getBilNr(), getCo2());
    System.out.println("-------------------------------------");
  }
}
