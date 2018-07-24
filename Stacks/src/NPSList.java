/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 18 Sample Program: Java Interface for the List ADT
    
     File: edu/nps/util/NPSList.java
*/

/**
 * The List ADT.
 *
 */
public interface NPSList<E> {
    
    public void add(E item);
    
    public void add(int index, E item) throws IndexOutOfBoundsException;
    
    public void clear(  );
    
    public boolean contains(E item);
    
    public E get(int index) throws IndexOutOfBoundsException;
    
    public int indexOf(E item);
    
    public NPSIterator<E> iterator();
    
    public boolean isEmpty(  );
    
    public E remove(int index) throws IndexOutOfBoundsException;

    public boolean remove(E item);
    
    public E set(int index, E item) throws IndexOutOfBoundsException;
    
    public int size(   );
}  
