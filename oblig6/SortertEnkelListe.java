//importing utility for iterating
import java.util.*;

//class for a container
class SortertEnkelListe<T extends Comparable<T>, Lik> implements AbstraktSortertEnkelListe<T>{
  //variable for storing information about the list
  int antall = 0;
  Node start;

  //class for each component in the list
  private class Node{
    Node forran;
    T innhold;
    Node(T input){
      this.innhold = input;
    }
  }

  /*method for adding an object (sorted from small to large
  starting on the smallets object in the list )*/
  public void leggTil(T t){
    Node input = new Node(t);
    Node current = start;
    Node prev = null;

    if(current == null){
      start = input;
      return;
    }

    while(current != null){
      if(input.innhold.compareTo(current.innhold) <= 0){ //checeking if the object is smaller that current objekt.
        input.forran = current;
        if(prev == null){
          start = input;
        }else{
          prev.forran = input;
        }
        return;
      }
      prev = current;
      current = current.forran;
    }
    prev.forran = input;
  }


  //method for getting the objects iteratior
  public Iterator<T> iterator(){
    return new MinIterator2();
  }

  //class for the objects iterator.
  private class MinIterator2 implements Iterator<T>{
    Node temp = start;

    //method need for the interation process.
    public boolean hasNext(){
      if(temp != null){
        return true;
      }
      return false;
    }

    //method need for the interation process.
    public T next(){
      if(hasNext()){
        T peker = temp.innhold;
        temp = temp.forran;
        return peker;
      }
      return null;
    }

    //remove method that didnt have the need to be used, but need to be in there.
    public void remove(){}
    }

    //method for returning an element cotaining a certain string.
    public T finnElement(String input){
      Node temp = start;

      if(temp==start){
        if(temp.innhold.toString().equals(input)){
          return (T) temp.innhold;
        }
      }

      while(temp!=null){
        if(temp.innhold.toString().equals(input)){
          return (T) temp.innhold;
        }
        temp = temp.forran;
      }
      return null;
    }
  }
