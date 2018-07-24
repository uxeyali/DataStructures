/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 19 Sample Program: The array-based implementation of the
                                Stack ADT
    
     File: edu/nps/util/NPSArrayStack.java
*/

public class NPSArrayStack<E> implements NPSStack<E> {
    
    private static final int DEFAULT_SIZE = 25;
    
    private E[ ]  element;
    
    private int  count;
    
    public NPSArrayStack( ){
        this(DEFAULT_SIZE);      
    }
       
    public NPSArrayStack(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException( 
                            "Initial capacity must be positive" );
        }
        
        element = (E[]) new Object[size];
        count   = 0;
    }
    
    public void clear() {

        for (int i = 0; i < count; i++) {
            element[i] = null;
        }
         
        count = 0;        
    }
      
    public boolean isEmpty() {
        
        return count == 0;
    }
    
    
    public E peek() throws NPSStackEmptyException {
        
        if (isEmpty( )) {
            
            throw new NPSStackEmptyException( );
            
        } else {
                
            return element[count-1];
        }
    }
    
    
    public E pop() throws NPSStackEmptyException {
        
        if ( isEmpty( ) ) {
            
            throw new NPSStackEmptyException( );
            
        } else {
            
            count--;
            
            E item = element[count];
            element[count] = null;
            
            return item;
        } 
    }
    
    
    public void push(E item) {
        
        if ( count == element.length ) {
            expand( );
        }

        element[count++] = item;        
    }
    
    
    public int size() {

        return count;
    }
    
    private void expand( ) {
        
        // create a new array whose size is 150% of
        // the current array
        int newLength = (int) (1.5 * element.length);
        E[] temp = (E[]) new Object[newLength];
    
        // now copy the data to the new array
        for (int i = 0; i < element.length; i++) {
            temp[i] = element[i];
        }
    
        // finally set the variable entry to point to the new array
        element = temp;    
    }
    
    public static boolean isOperator(char symb){
    	if(symb == '*'){
    		return true;
    	}
    	if(symb == '+'){
    		return true;
    	}
    	
    	if(symb == '/'){
    		return true;
    	}
    	
    	if(symb == '-'){
    		return true;
    	}
    	
    	if(symb == '&'){
    		return true;
    	}
    	
    	return false;
    }
}
