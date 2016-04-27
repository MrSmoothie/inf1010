import java.util.*;
import java.io.*;

class OrdreStyring{

  SortertEnkelListe<Lege, Lege> leger = new SortertEnkelListe<Lege, Lege>();
  EnkelReseptListe resepter = new EnkelReseptListe();
  Tabell<Pasient> pasienter = new Tabell<Pasient>(11);
  Tabell<Legemiddel> legemidler = new Tabell<Legemiddel>(11);

  public void lesFil() throws Exception{
    String tempTittel = "";
    Scanner filLeser = new Scanner(new File("dataset.txt"));
    while(filLeser.hasNextLine()){
      String input = filLeser.nextLine();
      if(!input.equals("")){
        if(!input.equals("# Slutt")){
          String[] temp = input.split("\\s+");
          if(!temp[0].equals("#")){
            String[] inputArray = input.split(",\\s+");
            switch(tempTittel){
              case "Legemidler":   if(inputArray[3].equals("c")){
                legTilMiddelC(inputArray[1], inputArray[2], Integer.parseInt(inputArray[4]), Integer.parseInt(inputArray[5]), Integer.parseInt(inputArray[6]));
              }else{
                leggTilMiddel(inputArray[1], inputArray[2], inputArray[3], Integer.parseInt(inputArray[4]), Integer.parseInt(inputArray[5]), Integer.parseInt(inputArray[6]), Integer.parseInt(inputArray[7]));
              }
              break;

              case "Personer": leggTilPerson(inputArray[1], inputArray[2], inputArray[3], Integer.parseInt(inputArray[4]));
              break;

              case "Leger":    leggTilLege(inputArray[0], inputArray[1]);
              break;

              case "Resepter": leggTilResept(inputArray[1], Integer.parseInt(inputArray[2]), inputArray[3], Integer.parseInt(inputArray[4]), Integer.parseInt(inputArray[5]));
              break;
            }
          }else{
            tempTittel = temp[1];
          }
        }
      }
    }
  }

  private void writeln(OutputStream writer, String input) throws Exception {
    writer.write((input+"\n").getBytes());
  }


  public void skrivFil() throws Exception{
    OutputStream writer = new FileOutputStream(new File("writeToFile.txt"));
    writeln(writer, "# Personer");
    for (Pasient x: pasienter) {
      writeln(writer, x.getPasientNr() + ", " + x.getNavn() + ", " + x.getFnr() + ", " +	x.getAdresse() + ", " +	x.getPostNr());
    }
    writeln(writer, "");
    writeln(writer, "# Legemidler");


    for (Legemiddel y : legemidler) {
      if(y != null){
        System.out.println(y);
        int legemiddelNr = y.getMiddelNr();
        String navn = y.getNavn();
        String form = "";
        String type = "";
        int pris = y.getPris();
        int antall = 0;
        int virkestoff = 0;
        Integer styrke = null;

        if (y instanceof TypeAPille) {
          TypeAPille d = (TypeAPille)y;
          form = "pille";
          type = "a";
          antall = d.getAntPiller();
          virkestoff = d.getVirkestoff();
          styrke = d.getNarkotisk();
        }
        else if (y instanceof TypeAMikstur) {
          TypeAMikstur d = (TypeAMikstur)y;
          form = "mikstur";
          type = "a";
          antall = d.getCm3PerTube();
          virkestoff = d.getVirkestoff();
          styrke = d.getNarkotisk();
        }
        else if (y instanceof TypeBPille) {
          TypeBPille d = (TypeBPille)y;
          form = "pille";
          type = "b";
          antall = d.getAntPiller();
          virkestoff = d.getVirkestoff();
          styrke = d.getVanedannende();
        }
        else if (y instanceof TypeBMikstur) {
          TypeBMikstur d = (TypeBMikstur)y;
          form = "mikstur";
          type = "b";
          antall = d.getCm3PerTube();
          virkestoff = d.getVirkestoff();
          styrke = d.getVanedannende();
        }
        else if (y instanceof TypeCPille) {
          TypeCPille d = (TypeCPille)y;
          form = "pille";
          type = "c";
          antall = d.getAntPiller();
          virkestoff = d.getVirkestoff();
        }
        else if (y instanceof TypeCMikstur) {
          TypeCMikstur d = (TypeCMikstur)y;
          form = "mikstur";
          type = "c";
          antall = d.getCm3PerTube();
          virkestoff = d.getVirkestoff();
        }

        writeln(writer,
        legemiddelNr+", "+
        navn+", "+
        form+", "+
        type+", "+
        pris+", "+
        antall+", "+
        virkestoff+
        (styrke == null ? "" : ", "+styrke)
        );
      }
    }
    writeln(writer, "");
    writeln(writer, "# Leger");
    for (Lege m: leger) {
      String navn = m.toString();
      String avtNr = "0";
      if (m instanceof Fastleger) {
        Fastleger f = (Fastleger)m;
        avtNr = f.getAvtNumber();
      }

      writeln(writer, navn+", "+avtNr);
    }
    writeln(writer, "");

    writeln(writer, "# Resepter");
    for (Resept r: resepter) {
      int reseptNr = r.getResNr();
      String type = "";
      int pasientNr = r.getPasient();;
      String utskriverNavn = r.getLege();
      int legemiddelNr = r.getMiddel().getMiddelNr();
      int reit = r.getReit();

      if (r instanceof BlaaResept)
      type = "blaa";
      else if (r instanceof HvitResept)
      type = "hvit";

      writeln(writer,
      reseptNr+", "+
      type+", "+
      pasientNr+", "+
      utskriverNavn+", "+
      legemiddelNr+", "+
      reit
      );
    }
    writeln(writer, "");
  }


  public void legTilMiddelC(String navn, String form, int pris, int antall, int virkestoff){
    if(form.equals("mikstur")){
      legemidler.setInnBakerst(new TypeCMikstur(navn, pris, virkestoff, antall));
    }else{
      legemidler.setInnBakerst(new TypeCPille(navn, pris, virkestoff, antall));
    }
  }

  public void leggTilMiddel(String navn, String form, String type, int pris, int antall, int virkestoff, int styrke){
    if(form.equals("mikstur")){
      if(type.equals("a")){
        legemidler.setInnBakerst(new TypeAMikstur(navn, pris, virkestoff, styrke, antall));
      }else{
        legemidler.setInnBakerst(new TypeBMikstur(navn, pris, virkestoff, styrke, antall));
      }
    }else{
      if(type.equals("a")){
        legemidler.setInnBakerst(new TypeAPille(navn, pris, virkestoff, styrke, antall));
      }else{
        legemidler.setInnBakerst(new TypeBPille(navn, pris, virkestoff, styrke, antall));
      }
    }
  }

  public void leggTilLege(String navn, String avtNr){
    if(avtNr.equals("0")){
      leger.leggTil(new Lege(navn));
    }else{
      leger.leggTil(new Fastleger(navn, avtNr));
    }
  }

  public void leggTilPerson(String navn, String fnr, String adresse, int postnr){
    pasienter.setInnBakerst(new Pasient(navn, adresse, fnr, postnr));
  }

  public void leggTilResept(String type, int person, String lege, int middelNummer, int dose){
    String tempNavn = null;
    Legemiddel tempMiddel = null;

    for(Legemiddel x: legemidler){
      if(x != null){
        if(x.getMiddelNr() == middelNummer){
          tempMiddel = x;
        }
      }
    }

    for(Pasient x: pasienter){
      if(x != null){
        if(x.getPasientNr() == person){
          tempNavn = x.getNavn();
        }
      }
    }


    if(tempNavn == null){
      System.out.println("Fant ingen matchene navn for denne iden.");
      tempNavn = "0";
    }
    if(tempMiddel != null){
      if(type.equals("blaa")){
        resepter.leggTil(new BlaaResept(tempMiddel, lege, person, dose));
      }else{
        resepter.leggTil(new HvitResept(tempMiddel, lege, person, dose));
      }
    }
  }

  public void printVanedannendeResept(){
    int antall = 0;
    int antallIOslo = 0;
    Pasient temp = null;
    for(Resept x: resepter){
      if(x != null){
        if(x.getMiddel() instanceof TypeBMikstur || x.getMiddel() instanceof TypeBPille){
          antall++;
          int tempPerson = x.getPasient();
          for(Pasient y : pasienter){
            if(y != null){
              if(y.getPasientNr() == tempPerson){
                temp = y;
                break;
              }
            }
          }
          if(temp.getPostNr() <= 1295){
            antallIOslo++;
          }
        }
      }
    }
    System.out.println("---------------------------------------------------------------");
    System.out.println("Det er " + antall + " som bruker vanedannende resepter i Norge.");
    System.out.println("Det er " + antallIOslo + " som bruker vanedannende resepter i Oslo.");
    System.out.println("---------------------------------------------------------------");
  }

  public Legemiddel getLegemiddel(Resept input){
    Legemiddel temp = null;

    return temp;
  }

  public void printPerson(int person){
    int temp = 0;
    YngsteForstReseptListe sort = new YngsteForstReseptListe();
    for(Resept x : resepter){
      if(x.getPasient() == person && x instanceof BlaaResept){
        sort.leggTil(x);
        temp++;
      }
    }
    if(temp == 0){
      System.out.println("Det var ingen respter tilgjengelig!");
    }else{
      for(Resept y : sort){
        printResept(y);
      }
    }
  }

  public void printLege(String legeInn){
    int antall = 0;
    int virkestoffMikstur = 0;
    int virkestoffPille = 0;
    EldsteForstReseptListe sort = new EldsteForstReseptListe();
    for(Resept x : resepter){
      if(x != null){
        if(x.getLege().equals(legeInn) && x.getMiddel() instanceof Mikstur){
          sort.leggTil(x);
          virkestoffMikstur += x.getMiddel().getVirkestoff();
          antall++;
        }else{
          virkestoffPille += x.getMiddel().getVirkestoff();
        }
      }
    }
    if(antall == 0){
      System.out.println("Fant ingen resepter for denne legen");
    }else{
      System.out.println("---------------------------------------------------------------");
      System.out.println("Lege: " + legeInn);
      System.out.println("---------------------------------------------------------------");
      System.out.println("Total mengde utskrevet virkestoff i piller: " + virkestoffPille);
      System.out.println("Total mengde utskrevet virkestoff i mikstur: " + virkestoffMikstur);
      System.out.println("Total mengde utskrevet virkestoff: " + (virkestoffMikstur + virkestoffPille));
      System.out.println("---------------------------------------------------------------");
      for(Resept y : sort){
        printResept(y);
      }
    }
  }

  public void finnNarkotikaLeger(){
    int tempSum = 0;
    YngsteForstReseptListe sort = new YngsteForstReseptListe();
    HashMap<String, Integer> leger = new HashMap<String, Integer>();

    for(Resept x : resepter){
      if(x != null){
        String temp;
        if(x.getMiddel() instanceof TypeAPille || x.getMiddel() instanceof TypeAMikstur){
          temp = x.getLege();

          if(!leger.containsKey(temp)){
            leger.put(temp, 1);
          }else{
            leger.put(temp, leger.get(temp) + 1);
          }
        }
      }
    }


    System.out.println("---------------------------------------------------------------");
    System.out.println("Leger som har skrevet ut narkotika");
    System.out.println("---------------------------------------------------------------");
    for(String key : leger.keySet()){
      System.out.println(key + " " + leger.get(key));
      tempSum += leger.get(key);
    }
    System.out.println("---------------------------------------------------------------");
    System.out.println("Sum av resepter: " + tempSum);
    System.out.println("---------------------------------------------------------------");
  }

  /*For this method i would store the information if the serch is run multiple
   times over a short amount of time. The reason for this, is that if it were
    supposed to go through alot of dato, it would be insufficient */
  public void printNarkotikaSjekk(){
    System.out.println("-------------------------------------");
    finnNarkotikaLeger();
    finnNarkotikaPasienter();
    System.out.println("-------------------------------------");
  }

  public void finnNarkotikaPasienter(){
    int tempSum = 0;
    YngsteForstReseptListe sort = new YngsteForstReseptListe();
    HashMap<String, Integer> narPasienter = new HashMap<String, Integer>();

    for(Resept x : resepter){
      if(x != null){
        String tempNavn = "";
        int temp;
        if(x.getMiddel() instanceof TypeAPille || x.getMiddel() instanceof TypeAMikstur){
          temp = x.getPasient();

          for(Pasient y : pasienter){
            if(y != null){
              if(y.getPasientNr() == temp){
                tempNavn = y.getNavn();
              }
            }
          }


          if(!narPasienter.containsKey(tempNavn)){
            narPasienter.put(tempNavn, 1);
          }else{
            narPasienter.put(tempNavn, narPasienter.get(tempNavn) + 1);
          }
        }
      }
    }


    System.out.println("---------------------------------------------------------------");
    System.out.println("Pasienter som har tatt ut narkotika medisiner");
    System.out.println("---------------------------------------------------------------");
    for(String key : narPasienter.keySet()){
      System.out.println(key + " " + narPasienter.get(key));
      tempSum += narPasienter.get(key);
    }
    System.out.println("---------------------------------------------------------------");
    System.out.println("Sum av resepter: " + tempSum);
    System.out.println("---------------------------------------------------------------");
  }



  public void printResept(Resept input){
    String temp = "";
    for(Pasient x : pasienter){
      if(x != null){
        if(x.getPasientNr() == input.getPasient()){
          temp = x.getNavn();
          break;
        }
      }
    }
    System.out.println("-------------------------------------------");
    System.out.println("|Resept: " + input.getMiddel().getNavn());
    System.out.println("-------------------------------------------");
    System.out.println("|Antall forbruksganger som er igjen: " + input.getReit());
    System.out.println("|navn: " + temp);
    System.out.println("|Lege: " + input.getLege());
    System.out.println("-------------------------------------------");
    System.out.println("|Pris: " + input.getPris());
    System.out.println("|Pris: " + input.getPris());
    System.out.println("-------------------------------------------");
  }
}
