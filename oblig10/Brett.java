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

  public void legTilRute(char inhold, int xInt, int yInt, int strInn){
    int temp = tegnTilVerdi(inhold);
    brett[yInt][xInt] = new Rute(temp, xInt,yInt,strInn);
  }

  public void leggTilKolonne(){
    for(int i = 0; i < kolonner.length; i++){
      kolonner[i] = new Kolonne();
      for(int o = 0; o < kolonner.length; o++){
         if(brett[o][i] != null){
        kolonner[i].add(brett[o][i]);
        brett[o][i].addKolonne(kolonner[i]);
        }
      }
    }
  }

  public void leggTilBoks(){
    int temp = 0;
    for(int i = 0; i < bokser.length; i += 2){
      if(i+1 <= bokser.length-1){
      bokser[i] = new Boks();
      bokser[i+1] = new Boks();
      for(int j = 0; j < bokser.length; j++){
        Rute tempRute = brett[temp][j];
        if(tempRute != null){
          if(j<y){
            bokser[i].add(tempRute);
            tempRute.addBoks(bokser[i]);
          }else{
            bokser[i+1].add(tempRute);
            tempRute.addBoks(bokser[i+1]);
          }
        }
      }
      temp++;
      for(int o = 0; o < bokser.length; o++){
        Rute tempRute = brett[temp][o];
        if(tempRute != null){
          if(o<y){
            bokser[i].add(tempRute);
            tempRute.addBoks(bokser[i]);
          }else{
            bokser[i+1].add(tempRute);
            tempRute.addBoks(bokser[i+1]);
          }
        }
      }
      temp++;
      }
    }
  }

  public void leggTilRad(){
    for(int i = 0; i < rader.length; i++){
      rader[i] = new Rad();
      for(int o = 0; o < rader.length; o++){
        if(brett[i][o] != null){
        rader[i].add(brett[i][o]);
        brett[i][o].addRad(rader[i]);
        }
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
    System.out.println("");
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

  public void opprettDatastruktur(){
      leggTilBoks();
      leggTilRad();
      leggTilKolonne();
  }

  public void printLosning(int x, int y){
      for(int a : brett[x][y].finnAlleMuligeTegn()){
          System.out.println("-------------------");
          System.out.println(verdiTilTegn(a));
          System.out.println("-------------------");
      }
  }

   public static int tegnTilVerdi(char tegn) {
       char tomRute = '.';
        if (tegn == tomRute) {                // tom rute
            // DENNE KONSTANTEN MAA DEKLARERES
            return 0;
        } else if ('1' <= tegn && tegn <= '9') {    // tegn er i [1, 9]
            return tegn - '0';
        } else if ('A' <= tegn && tegn <= 'Z') {    // tegn er i [A, Z]
            return tegn - 'A' + 10;
        } else if (tegn == '@') {                   // tegn er @
            return 36;
        } else if (tegn == '#') {                   // tegn er #
            return 37;
        } else if (tegn == '&') {                   // tegn er &
            return 38;
        } else if ('a' <= tegn && tegn <= 'z') {    // tegn er i [a, z]
            return tegn - 'a' + 39;
        } else {                                    // tegn er ugyldig
            return -1;
        }
    }
}


public static char verdiTilTegn(int verdi, char tom) {
        if (verdi == 0) {                           // tom
            return tom;
        } else if (1 <= verdi && verdi <= 9) {      // tegn er i [1, 9]
            return (char) (verdi + '0');
        } else if (10 <= verdi && verdi <= 35) {    // tegn er i [A, Z]
            return (char) (verdi + 'A' - 10);
        } else if (verdi == 36) {                   // tegn er @
            return '@';
        } else if (verdi == 37) {                   // tegn er #
            return '#';
        } else if (verdi == 38) {                   // tegn er &
            return '&';
        } else if (39 <= verdi && verdi <= 64) {    // tegn er i [a, z]
            return (char) (verdi + 'a' - 39);
        } else {                                    // tegn er ugyldig
            throw new UgyldigVerdiUnntak(verdi);
            // HUSK DEFINISJON AV UNNTAKSKLASSE
        }
    }
