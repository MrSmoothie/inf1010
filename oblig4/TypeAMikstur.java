//method for typeA mixtures.
class TypeAMikstur extends Legemiddel implements Mikstur{
  //variables to store information about the medisine
  protected int narkotisk;
  protected int cm3PerTube;

  //constructor to insert data nad initilize the variables.
  TypeAMikstur(String navn, int prisInn, int virkestoffInn, int narkotiskInn, int cm3PerTubeInn){
    super(navn, prisInn, virkestoffInn);
    this.narkotisk = narkotiskInn;
    this.cm3PerTube = cm3PerTubeInn;
  }

  //get methods
  public int getCm3PerTube(){
    return cm3PerTube;
  }

  public int getNarkotisk(){
    return narkotisk;
  }
}
