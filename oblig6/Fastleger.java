//class for doctors
class Fastleger extends Lege implements Avtale{
  String avtnr;
  Fastleger(String inputNavn, String avtale){
    super(inputNavn);
    this.avtnr = avtale;
  }

  //get method for the contract number
  public String getAvtNumber(){
    return avtnr;
  }

  //method for making a contract.
  public void lagAvtale(String input){
    this.avtnr = input;
  }

}
