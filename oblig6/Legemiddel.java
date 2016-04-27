//main class for medisin
class Legemiddel{
  //variables to store information about the product
  private static int antMidler = -1;
  protected String navn;
  protected int pris;
  protected int middelNr;
  protected int virkestoff;

  //constructor initializing the variables above.
  Legemiddel(String navnInn, int prisInn, int virkestoffInn){
    this.navn = navnInn;
    this.pris = prisInn;
    antMidler++;  //increasing the total number of medisins created.
    this.middelNr = antMidler;
    this.virkestoff = virkestoffInn;
  }

  //get methods
  public String getNavn(){
    return navn;
  }

  public int getPris(){
    return pris;
  }

  public int getMiddelNr(){
    return middelNr;
  }
  public int getVirkestoff(){
    return virkestoff;
  }
}
