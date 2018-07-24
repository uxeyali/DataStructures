/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 19 Sample Program: The Java interface for the Stack ADT
    
     File: edu/nps/util/NPSStack.java
*/

public interface NPSStack<E> {
    
    public void clear( );
    
    public boolean isEmpty( );
    
    public E  peek( ) throws NPSStackEmptyException;
    
    public E  pop( )  throws NPSStackEmptyException;

    public void push(E element);
   
    public int size(  );
}
