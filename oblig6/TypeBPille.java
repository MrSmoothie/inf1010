//class for type B pills.
class TypeBPille extends Legemiddel implements Pille{
  //variables to store information about the medisine
  protected int vanedannende;
  protected int antPiller;

  //constructor to insert data nad initilize the variables.
  TypeBPille(String navn, int prisInn, int virkestoffInn, int vanedannendeInn, int ant){
    super(navn, prisInn, virkestoffInn);
    this.vanedannende = vanedannendeInn;
    this.antPiller = ant;
  }

  //get methods
  public int getAntPiller(){
    return antPiller;
  }

  public int getVanedannende(){
    return vanedannende;
  }
}
