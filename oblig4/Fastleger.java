class Fastleger extends Lege implements avtale{
  private int avtaleNr;   //contract number for a doctor
  Fastleger(int avtNummer, String inputNavn){
    super(inputNavn);
    this.avtaleNr = avtNummer;
  }

  //get method for the contract number
  public int getAvtNumber(){
    return avtaleNr;
  }
}
