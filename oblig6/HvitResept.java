//class for white Prescriptions.
class HvitResept extends Resept{
  HvitResept(Legemiddel inputMiddel, String legeInn, int pasientInn, int doserInn){
    super(inputMiddel, legeInn, pasientInn, doserInn);
  }

  //returning the price because its a Prescription.
  public int getPris(){
    return getMiddel().getPris();
  }
}
