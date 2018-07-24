/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 20 Sample Program: The exception class for an empty queue
    
     File: edu/nps/util/NPSQueueEmptyException.java
*/

public class NPSQueueEmptyException extends RuntimeException {

    public NPSQueueEmptyException( ) {
        
        this("Stack is emtpy");
    }
    
    public NPSQueueEmptyException(String message) {
        
        super(message);
    }
}
