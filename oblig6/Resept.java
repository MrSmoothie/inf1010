//class for prescriptions.
class Resept{
  //variables to store information about the prescription
  private static Integer middelNr;
  private Legemiddel legemiddel;
  private String lege;
  private int pasient;
  private int reit;
  private int resNr;

  //constructor to initilize the variables and insert data.
  Resept(Legemiddel inputMiddel, String legeInn, int pasientInn, int doserInn){
    if(middelNr == null){
      middelNr = 0;
    }else{
      middelNr++;
    }

    this.lege = legeInn;
    this.pasient = pasientInn;
    this.reit = doserInn;
    this.legemiddel = inputMiddel;
    this.resNr = middelNr;
  }


  public String getLege(){
    return lege;
  }

  public int getPasient(){
    return pasient;
  }


  public int getReit(){
    return reit;
  }

  public int getResNr(){
    return resNr;
  }

  public Legemiddel getMiddel(){
    return legemiddel;
  }

  public int getPris(){
    return 0;
  }
}
