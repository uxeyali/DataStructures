
public class NPSArrayStack1<E> implements NPSStack<E> {
    
    private static final int DEFAULT_SIZE = 25;
    
    private E[ ]  element;
    
    private int  count;
    
    public NPSArrayStack1( ){
        this(DEFAULT_SIZE);      
    }
       
    public NPSArrayStack1(int size) {
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
    
    public E pop(){
        
        if ( isEmpty( ) ) {
            
            System.out.println("Stack Underflow Error");
            return null;
            
        } else {
            
            count--;
            
            E item = element[count];
            element[count] = null;
            
            return item;
        } 
    }
    
    public void push(E item) {
        
        if ( count == element.length ) {
            System.out.println("Stack Overflow Error");
        }

        element[count++] = item;        
    }
    
    public int size() {

        return count;
    }
    

    

}
