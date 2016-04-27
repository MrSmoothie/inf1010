//testing class
class TestSortertEnkelListe{
  public static void main(String[] args) {
    Fastleger lege1 = new Fastleger("Alpha" ,"0");
    Fastleger lege3 = new Fastleger("Alpha", "0");
    Fastleger lege2 = new Fastleger("Beta", "0");
    Fastleger lege5 = new Fastleger("Ceta", "0");
    Fastleger lege4 = new Fastleger("Delta", "0");

    SortertEnkelListe<Lege, Lege> beholder = new SortertEnkelListe<Lege, Lege>();
    beholder.leggTil(lege2);
    beholder.leggTil(lege1);
    beholder.leggTil(lege4);
    beholder.leggTil(lege5);
    beholder.leggTil(lege3);

    for(Lege x: beholder){
      System.out.println(x.toString());
    }

    System.out.println(beholder.finnElement("Ceta").toString());
  }
}
