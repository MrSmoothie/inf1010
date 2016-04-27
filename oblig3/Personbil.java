//class for all passenger cars
class Personfossilbil extends Fossil{
  protected int antPlasser;

  //constructor for setting the car number, co2 realse and number of passenger seats.
  Personfossilbil(String bilnr, double co2, int antPlasserInn){
    super(bilnr,co2);
    antPlasser = antPlasserInn;
  }

  //method for returning the number of passenger seats.
  public int getAntPlasser(){
    return antPlasser;
  }

  //method for printing out information about the car.
  public void skrivUt(){
    System.out.println("-------------------------------------");
    System.out.printf("Bilnummeret til bilen er %s.\nDen slipper ut %s co2.\nBilen har plass til %d\n", getBilNr(), getCo2(), getAntPlasser());
    System.out.println("-------------------------------------");
  }

}
