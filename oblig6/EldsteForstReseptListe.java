//class for storing Prescriptions with oldes Prescriptions first in the list. 
class EldsteForstReseptListe extends EnkelReseptListe{
  public void leggTil(Resept e){
    Node midlertidig = new Node(e);
    if(first == true){
      slutt = midlertidig;
      start = midlertidig;
      first = false;
    }else{
      slutt.forran = midlertidig;
      slutt = midlertidig;
    }
    antall++;
  }
}
