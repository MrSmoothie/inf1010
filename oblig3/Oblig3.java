//importing java utilities
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

//main class for the program
class Oblig3{
  public static void main(String[] args){

  //creating an array for the cars
  ArrayList<Bil> bilListe = new ArrayList<Bil>();

  //try catch for reading the file with cars.
  try{
    Scanner inputScanner = new Scanner(new File("biler.txt"));
    while(inputScanner.hasNextLine()){
      String[] splited = inputScanner.nextLine().split("\\s+");

      /*switch method for checking what type of car that is inserted.
      Also creating an object and adding it to the list for every car.*/
      switch(splited[0]){
        case "BIL": bilListe.add(new Bil(splited[1]));
                    break;

        case "EL": bilListe.add(new El(splited[1], makeI(splited[2])));
                    break;

        case "FOSSIL": bilListe.add(new Fossil(splited[1], makeD(splited[2])));
                        break;

        case "PERSONFOSSILBIL": bilListe.add(new Personfossilbil(splited[1], makeD(splited[2]), makeI(splited[3])));
                                break;

        case "LASTEBIL": bilListe.add(new Lastebil(splited[1], makeD(splited[2]), makeD(splited[3])));
                        break;
      }
    }
  }catch(Exception ex){
    //printing out eventual errors.
    ex.printStackTrace();
  }

  //for each loop for printing out all the passenger cars.
  for(Bil input : bilListe){
    if(input instanceof Personfossilbil){
      input.skrivUt();
    }
  }

  }

  //method for converting text to double
  public static Double makeD(String input){
    return Double.parseDouble(input);
  }

  //method for converting text to int
  public static int makeI(String input){
    return Integer.parseInt(input);
  }
}
