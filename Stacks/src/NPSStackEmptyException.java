/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 19 Sample Program: The exception class for an empty stack
    
     File: edu/nps/util/NPSStackEmptyException.java
*/

public class NPSStackEmptyException extends RuntimeException {
    
    public NPSStackEmptyException( ) {
        
        this("Stack is emtpy");
    }
    
    public NPSStackEmptyException(String message) {
        
        super(message);
    }
}
