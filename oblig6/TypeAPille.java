//class for type A pills
class TypeAPille extends Legemiddel implements Pille{

  //variables to store information about the medisine
  protected int narkotisk;
  protected int antPiller;

  //constructor to insert data nad initilize the variables.
  TypeAPille(String navn, int prisInn, int virkestoffInn, int narkotiskInn, int antall){
    super(navn, prisInn, virkestoffInn);
    this.narkotisk = narkotiskInn;
    this.antPiller = antall;
  }

  //get methods
  public int getAntPiller(){
    return antPiller;
  }

  public int getNarkotisk(){
    return narkotisk;
  }
}
