/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 19 Sample Program: The implementation of the Stack ADT by
                                using NPSList.
    
     File: edu/nps/util/NPSListStack.java
*/

public class NPSListStack<E> implements NPSStack<E> {
    
    private static final int FRONT = 0;
    
    private NPSList<E> list;
    
    public NPSListStack( ) {
        list = new NPSLinkedList<E>(); 
    }

    public void clear() {
        list.clear();        
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public E peek() throws NPSStackEmptyException {
        
        if (isEmpty()) {
            
            throw new NPSStackEmptyException();
            
        } else {   
            
            return list.get(FRONT);
        }
    }

    public E pop() throws NPSStackEmptyException {
        
        if (isEmpty()) {
            
            throw new NPSStackEmptyException();
            
        } else {   
            
           return list.remove(FRONT);
        }
    }

    public void push(E element) {
        list.add(FRONT, element);       
    }

    public int size() {
        return list.size();
    }
}
