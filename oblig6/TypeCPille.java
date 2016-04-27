//class for type c pills
class TypeCPille extends Legemiddel implements Pille{

  //variable to store information about the medisine
  protected int antPiller;

  //constructor to insert data nad initilize the variables.
  TypeCPille(String navn, int prisInn, int virkestoffInn, int ant){
    super(navn, prisInn, virkestoffInn);
    this.antPiller = ant;
  }

  //get method
  public int getAntPiller(){
    return antPiller;
  }
}
