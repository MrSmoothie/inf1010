class Test{
  public static void main(String[] args){
    Legemiddel seritide = new TypeAMikstur("Seritide", 200, 80, 3000, 30);
    Resept res1 = new Resept(seritide, "forberg", "Rein", 3, "blaa");
    Resept res2 = new Resept(seritide, "forberg", "Rein", 3, "blaa");
    Resept res3 = new Resept(seritide, "forberg", "Rein", 3, "blaa");
    Resept res4 = new Resept(seritide, "forberg", "Rein", 3, "hvit");
    System.out.println(res4.getMiddel().getNavn() + " blir hentet pa respt nummer: " + res4.getResNr() + ". \nDen er skrevet ut av " + res4.getLege() + " til pasient: " + res4.getPasient() + ".\nMedisinen koster: " + res4.getPris() + "!");
  }
}
