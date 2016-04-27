//Class for electric cars
class El extends Bil{
  protected int batteri;

  //constrcutor setting battery size and car number.
  El(String bilnr, int kW){
    super(bilnr);
    this.batteri = kW;
  }

  //method for returning the battery size.
  public int getBatteri(){
    return batteri;
  }

  //method for printing out information about the car. 
  public void skrivUt(){
    System.out.println("-------------------------------------");
    System.out.printf("Bilnummeret til bilen er %s.\nDen har et batteri på %d kw.", getBilNr(), getBatteri());
    System.out.println("-------------------------------------");
  }
}
