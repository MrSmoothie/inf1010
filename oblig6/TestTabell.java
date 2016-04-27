//testing class
class TestTabell{
  public static void main(String[] args) {
    Tabell<String> beholder = new Tabell<String>(10);

    for(int i = 0; i<10; i++){
      beholder.setInn("Dette er index: " + i, i);
    }


    System.out.println("--------------------------------------");
    for(String x: beholder){
      System.out.println(x.toString());
    }
    System.out.println("--------------------------------------");
    System.out.println(beholder.getObj(5));
    System.out.println("--------------------------------------");
  }
}
