//class for type c pills
class TypeCPille extends Legemiddel implements Pille{

  //variable to store information about the medisine
  protected int mgPerPille;

  //constructor to insert data nad initilize the variables.
  TypeCPille(String navn, int prisInn, int virkestoffInn, int mgPerPilleInn){
    super(navn, prisInn, virkestoffInn);
    this.mgPerPille = mgPerPilleInn;
  }

  //get method
  public int getMgPerPille(){
    return mgPerPille;
  }
}
