import java.util.*;
    class Kolonne implements Iterable<Rute>{
      //variable for storing information about the list
      int antall;
      Node start;
      Node slutt;
      boolean first = true;

      //class for each component in the list
      protected class Node{
        Node forran;
        Rute innhold;
        Node(Rute input){
          this.innhold = input;
        }
      }


      //method for adding an object
      public void add(Rute e){
        Node midlertidig = new Node(e);
        midlertidig.forran = start;
        start = midlertidig;
        if(first == true){
          slutt = midlertidig;
          first = false;
        }
        antall++;
      }


      //method for getting an iteratior for the class
      public Iterator<Rute> iterator(){
        return new MinIterator3();
      }

      //iterator class, used to iterate through the list
      private class MinIterator3 implements Iterator<Rute>{
        Node temp = start;

        //hasNext method used in the iteration process.
        public boolean hasNext(){
          if(temp != null){
            return true;
          }
          return false;
        }

        //next method used in the iteration proccess
        public Rute next(){
          if(hasNext()){
            Rute peker = temp.innhold;
            temp = temp.forran;
            return peker;
          }
          return null;
        }

        //remove method that didnt have the need to be used, but need to be in there.
        public void remove(){}
        }

        public boolean inneholder(int input){
            Iterator minIte = iterator();
            while(minIte.hasNext()){
                Rute temp = (Rute) minIte.next();
                if(temp.getTegn() == input){
                    return true;
                }
            }
            return false;
        }
      }
