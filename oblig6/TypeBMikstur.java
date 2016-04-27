//class for type B mixtures
class TypeBMikstur extends Legemiddel implements Mikstur{
  //variables to store information about the medisine
  protected int vanedannende;
  protected int cm3PerTube;

  //constructor to insert data nad initilize the variables.
  TypeBMikstur(String navn, int prisInn, int virkestoffInn, int vanedannendeInn, int cm3PerTubeInn){
    super(navn, prisInn, virkestoffInn);
    this.vanedannende = vanedannendeInn;
    this.cm3PerTube = cm3PerTubeInn;
  }

  //get methods
  public int getCm3PerTube(){
    return cm3PerTube;
  }

  public int getVanedannende(){
    return vanedannende;
  }
}
