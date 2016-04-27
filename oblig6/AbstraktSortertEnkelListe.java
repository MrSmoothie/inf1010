//interface describing one of the container types. 
interface AbstraktSortertEnkelListe<T> extends Iterable<T>{
    void leggTil(T input);
    T finnElement(String input);
}
