//class for all patient
class Pasient extends Person{
  //variables to store information about the patient.
  private static int antPasienter;
  protected int pasientNr;
  protected int postNr;
  protected String adresse;

  //constructor to initilize and count the total number of patients made.
  Pasient(String navnInn, String adresseInn, int fNr, int postNrInn){
    super(navnInn);
    antPasienter++;
    pasientNr = antPasienter;
    this.postNr = postNrInn;
    this.adresse = adresseInn;
  }

  //get methods
  public int getPasientNr(){
    return pasientNr;
  }
  public int getPostNr(){
    return postNr;
  }
  public String getAdresse(){
    return adresse;
  }
}
