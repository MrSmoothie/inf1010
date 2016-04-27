//class for storing Prescriptions with youngest Prescriptions first in the list.
class YngsteForstReseptListe extends EnkelReseptListe{
  public void leggTil(Resept e){
    Node midlertidig = new Node(e);
    midlertidig.forran = start;
    start = midlertidig;
    if(first == true){
      slutt = midlertidig;
      first = false;
    }
    antall++;
  }
}
