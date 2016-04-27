import java.util.*;
class Brett{
  private Rute[][] brett;
  private Kolonne[] kolonner;
  private Rad[] rader;
  private Boks[] bokser;
  private int x;
  private int y;

  Brett(int strX, int strY){
    int str = strX * strY;
    x = strX;
    y = strY;
    this.brett = new Rute[str][str];
    this.kolonner = new Kolonne[str];
    this.rader = new Rad[str];
    this.bokser = new Boks[str];
  }

  public void legTilRute(char inhold, int xInt, int yInt){{}
    brett[yInt][xInt] = new Rute(inhold, xInt,yInt);
  }

  public void leggTilKolonne(){
    for(int i = 0; i < kolonner.length; i++){
      kolonner[i] = new Kolonne();
      for(int o = 0; o < kolonner.length; o++){
        kolonner[i].add(brett[o][i]);
      }
    }
  }

  public void leggTilBoks(){
    int temp = 0;
    for(int i = 0; i < bokser.length; i += 2){
      bokser[i] = new Boks();
      bokser[i+1] = new Boks();
      for(int j = 0; j < bokser.length; j++){
        Rute tempRute = brett[temp][j];
        if(tempRute != null){
          if(j<y){
            bokser[i].add(tempRute);
          }else{
            bokser[i+1].add(tempRute);
          }
        }
      }
      temp++;
      for(int o = 0; o < bokser.length; o++){
        Rute tempRute = brett[temp][o];
        if(tempRute != null){
          if(o<y){
            bokser[i].add(tempRute);
          }else{
            bokser[i+1].add(tempRute);
          }
        }
      }
      temp++;
    }
  }

  public void leggTIlRad(){
    for(int i = 0; i < rader.length; i++){
      rader[i] = new Rad();
      for(int o = 0; o < rader.length; o++){
        rader[i].add(brett[i][o]);
      }
    }
  }


  public void printBrett(){
    for(int i = 0; i<brett.length; i++){
      for(int j = 0; j < brett[i].length;j++){
        if(brett[i][j] == null){
          System.out.print(".");
        }else{
          System.out.print(brett[i][j].getTegn());
        }
        if((j+1) % y == 0){
          if(j != brett[i].length-1){
            System.out.print("|");
          }
        }
      }
      if(((i+1) % x) == 0){
        if(i != brett.length-1){
          System.out.println("");
          for(int o = 0; o < brett.length; o++){
            System.out.print("-");
            if(((o+1) % y) == 0){
              if(o != brett.length-1){
                System.out.print("+");
              }
            }
          }
          System.out.println("");
        }
      }else{
        System.out.println("");

      }
    }
  }

  public void printBoks(){
    for(int i = 0; i < bokser.length; i++){
      System.out.println("---------------");
      for(Rute x : bokser[i]){
        System.out.println(x.getTegn());
      }
      System.out.println("---------------");
    }
  }

  public Rad[] getRader(){
    return rader;
  }
  public Kolonne[] getKolonner(){
    return kolonner;
  }
}
