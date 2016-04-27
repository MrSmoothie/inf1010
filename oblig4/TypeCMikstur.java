//class for type c mixtures
class TypeCMikstur extends Legemiddel implements Mikstur{
  //variable to store information about the medisine
  protected int cm3PerTube;

  //constructor to insert data nad initilize the variables.
  TypeCMikstur(String navn, int prisInn, int virkestoffInn, int cm3PerTubeInn){
    super(navn, prisInn, virkestoffInn);
    this.cm3PerTube = cm3PerTubeInn;
  }

  //get method
  public int getCm3PerTube(){
    return cm3PerTube;
  }
}
