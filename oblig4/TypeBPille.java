//class for type B pills.
class TypeBPille extends Legemiddel implements Pille{
  //variables to store information about the medisine
  protected int vanedannende;
  protected int mgPerPille;

  //constructor to insert data nad initilize the variables.
  TypeBPille(String navn, int prisInn, int virkestoffInn, int vanedannendeInn, int mgPerPilleInn){
    super(navn, prisInn, virkestoffInn);
    this.vanedannende = vanedannendeInn;
    this.mgPerPille = mgPerPilleInn;
  }

  //get methods
  public int getMgPerPille(){
    return mgPerPille;
  }

  public int getVanedannende(){
    return vanedannende;
  }
}
