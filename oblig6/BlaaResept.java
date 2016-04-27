//class for blue Prescriptions
class BlaaResept extends Resept{
  BlaaResept(Legemiddel inputMiddel, String legeInn, int pasientInn, int doserInn){
    super(inputMiddel, legeInn, pasientInn, doserInn); //sending information to the superclass Prescription
  }

  //Returning the price in 0 because its a blue Prescription.
  public int getPris(){
    return 0;
  }
}
