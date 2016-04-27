//interface describing one of the container types.
interface AbstraktTabell<T> extends Iterable<T>{
  void setInn(T input, int index);
  T getObj(int index);
}
