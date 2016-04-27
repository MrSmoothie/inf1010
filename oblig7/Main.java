import java.util.*;

class Main{
  public static void main(String[] args) {
    String tempTittel = "";
    Scanner filLeser = new Scanner(new File("dataset.txt"))
    while(filLeser.hasNextLine()){
      String input = filLeser.nextLine();
      if(input != ""){
        if(input != "# Slutt"){
         String temp = myString.split("\\s+");
         if(temp[0] != "#"){
           switch(temp[1]){
             case "Legemidler":

             case "Personer":

             case "Leger":

             case "Resepter":
           }
         }else{
           tempTittel = temp[1];
         }
        }
      }
    }
  }
}
