//importing utility for interation
import java.util.*;

//Class for another list
class Tabell<T> implements AbstraktTabell<T>{
  private T[] array;
  private int currentIndex = 0;
  //construcotr setting the length of the list
  Tabell(int str){
    array = (T[]) new Object[str];
  }

  //method for adding an object
  public void setInnBakerst(T input){
    setInn(input, currentIndex);
  }

  public void setInn(T input, int index){
    if(index < array.length){
      array[index] = input;
      currentIndex++;
    }
  }

  //method for returning an object based on an index
  public T getObj(int index){
    return array[index];
  }

  //method for getting the objects iteratior
  public Iterator<T> iterator(){
    return new MinIterator();
  }

  //class for the objects iterator
  private class MinIterator implements Iterator<T>{
    int index = 0;
    T[] temp = array;

    //method needed for the iteration process
    public boolean hasNext(){
      if(index < temp.length){
        return true;
      }
      return false;
    }

    //method needed for the iteration process
    public T next(){
      if(hasNext()){
        return temp[index++];
      }
      return null;
    }

    //method that is not needed for the software, but needed to be included.
    public void remove(){}
    }

  }
