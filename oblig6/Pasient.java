//class for all patient
class Pasient extends Person{
  //variables to store information about the patient.
  private static int antPasienter;
  protected int pasientNr = 0;
  protected int postNr;
  protected String adresse;
  protected String fnr; 

  //constructor to initilize and count the total number of patients made.
  Pasient(String navnInn, String adresseInn, String fNrI, int postNrInn){
    super(navnInn);
    pasientNr = antPasienter;
    antPasienter++;
    this.postNr = postNrInn;
    this.adresse = adresseInn;
    this.fnr = fNrI;
  }

  //get methods
  public int getPasientNr(){
    return pasientNr;
  }
  public int getPostNr(){
    return postNr;
  }
  public String getFnr(){
    return fnr;
  }
  public String getAdresse(){
    return adresse;
  }
}
