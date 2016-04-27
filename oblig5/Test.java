class Test{
  public static void main(String[] args) {
    Lenkeliste<String> liste = new Lenkeliste<>();


    liste.leggTil("Beta");
    liste.leggTil("Alpha");
    liste.leggTil("Ceta");

    System.out.println(liste.fjernMinste());
    System.out.println(liste.fjernMinste());
    System.out.println(liste.fjernMinste());
  }
}
