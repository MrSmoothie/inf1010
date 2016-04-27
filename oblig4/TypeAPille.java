//class for type A pills
class TypeAPille extends Legemiddel implements Pille{

  //variables to store information about the medisine
  protected int narkotisk;
  protected int mgPerPille;

  //constructor to insert data nad initilize the variables.
  TypeAPille(String navn, int prisInn, int virkestoffInn, int narkotiskInn, int mgPerPilleInn){
    super(navn, prisInn, virkestoffInn);
    this.narkotisk = narkotiskInn;
    this.mgPerPille = mgPerPilleInn;
  }

  //get methods
  public int getMgPerPille(){
    return mgPerPille;
  }

  public int getNarkotisk(){
    return narkotisk;
  }
}
