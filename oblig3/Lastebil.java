//Import java text utility for decimals
import java.text.DecimalFormat;

//class for all trailers
class Lastebil extends Fossil{
  protected double nyttevekt;

  //constructor setting the car number, co2 realse and maxload.
  Lastebil(String bilnr, double co2, double nyttevektInn){
    super(bilnr,co2);
    nyttevekt = nyttevektInn;
  }

  //method returning the maxload.
  public String getNytteVekt(){
    DecimalFormat df = new DecimalFormat("#.##");
    return df.format(nyttevekt);
  }

  //method printing out information about the trailer.
  public void skrivUt(){
    System.out.println("-------------------------------------");
    System.out.printf("Bilnummeret til bilen er %s.\nDen slipper ut %s co2.\nBilen har en nyttevekt på %f", getBilNr(), getCo2(), getNytteVekt());
    System.out.println("-------------------------------------");
  }
}
