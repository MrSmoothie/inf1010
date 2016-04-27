//class for prescriptions.
class Resept{
  //variables to store information about the prescription
  private static Integer middelNr;
  private Legemiddel legemiddel;
  private String lege;
  private String pasient;
  private int reit;
  private String farge;
  private int resNr;

  //constructor to initilize the variables and insert data.
    Resept(Legemiddel inputMiddel, String legeInn, String pasientInn, int doserInn, String fargeInn){
      if(middelNr == null){
        middelNr = 0;
      }else{
        middelNr++;
      }

      this.lege = legeInn;
      this.pasient = pasientInn;
      this.reit = doserInn;
      this.legemiddel = inputMiddel;
      this.farge = fargeInn;
      this.resNr = middelNr;
    }

    //get methods
    public int getPris(){
      if(getFarge().toUpperCase().equals("HVIT")){
        return legemiddel.getPris();
      }
      return 0;
    }

    public String getLege(){
      return lege;
    }

    public String getPasient(){
      return pasient;
    }

    public String getFarge(){
      return farge;
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
}
