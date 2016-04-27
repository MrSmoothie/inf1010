//importing utility for iterating.
import java.util.*;

//class for storing Prescriptions.
class EnkelReseptListe implements Iterable<Resept>{
  //variable for storing information about the list
  int antall;
  Node start;
  Node slutt;
  boolean first = true;

  //class for each component in the list
  protected class Node{
    Node forran;
    Resept innhold;
    Node(Resept input){
      this.innhold = input;
    }
  }


  //method for adding an object
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

  //method for returning an object based on resNr
  public Resept getRes(int input){
    Node midlertidig = start;
    try{
      while(midlertidig != null){
        if(midlertidig.innhold.getResNr() == input){
          return midlertidig.innhold;
        }
        midlertidig = midlertidig.forran;
      }
      throw new ReseptException();  //Throwing an exception if anb error occours.
    }catch(ReseptException e){
      e.reseptError();  //printing out an errormsg.
    }
    return null;
  }

  //class for the exception that is thrown for Prescriptions.
  private class ReseptException extends Exception{
    public void reseptError(){
      System.out.println("Didnt find your resept number");
    }
  }

  //method for getting an iteratior for the class
  public Iterator<Resept> iterator(){
    return new MinIterator3();
  }

  //iterator class, used to iterate through the list
  private class MinIterator3 implements Iterator<Resept>{
    Node temp = start;

    //hasNext method used in the iteration process.
    public boolean hasNext(){
      if(temp != null){
        return true;
      }
      return false;
    }

    //next method used in the iteration proccess
    public Resept next(){
      if(hasNext()){
        Resept peker = temp.innhold;
        temp = temp.forran;
        return peker;
      }
      return null;
    }

    //remove method that didnt have the need to be used, but need to be in there.
    public void remove(){}
    }

  }
