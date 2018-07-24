/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 19 Sample Program: The linked-list implementation of the
                                Stack ADT
    
     File: edu/nps/util/NPSLinkedStack.java
*/

public class NPSLinkedStack<E> implements NPSStack<E> {
    
//----------------------------------
//        Data Members
//----------------------------------
      
    /** Points to the top-of-stack element. */
   private StackNode topOfStack;
             
       
    /** The number of elements in the stack.  */
    private int count;  
    
//----------------------------------
//        Constructors
//----------------------------------
                                
    /**
     * Default constructor
     */
    public NPSLinkedStack( ) {
        clear( );
    }

//-------------------------------------------------
//          Public Methods:
//
//              void      clear      (              )
//
//              boolean   isEmpty    (              )
//
//              Object    peek       (              ) 
//                            throws NPSEmptyStructureException
//
//              Object    pop        (              ) 
//                             throws NPSEmptyStructureException
//
//              void      push       ( Object       )
//
//              int       size       (              )
//
//------------------------------------------------

    /**
     * Removes all elements from the stack.
     *
     */
    public void clear(  ) {
        
        topOfStack = null;
        
        count = 0;
    }
    
    
    /**
     * Determines whether the stack is empty or not.
     *
     * @return true if the stack is empty; false otherwise.
     */
    public boolean isEmpty(  ) {
        
        return (count == 0);
    }
    
    
    /**
     * Returns the top-of-stack element without removing
     * it from the stack.
     *
     * @return the top-of-stack element
     *
     * @exception NPSEmptyStructureException thrown when the stack is empty
     */
    public E peek( ) throws NPSStackEmptyException {
        
        if (isEmpty( )) {
            
            throw new NPSStackEmptyException( );
            
        } else {
            
            return topOfStack.item;
        }        
    }
    
    
    /**
     * Removes the top-of-stack element.
     *
     * @return the top-of-stack element
     *
     * @exception NPSEmptyStructureException thrown when the stack is empty
     */
    public E pop( )  throws  NPSStackEmptyException {
        
        if (isEmpty( )) {
            
            throw new NPSStackEmptyException( );
            
        } else {
            
            count--;
            
            E temp = topOfStack.item;
            
            topOfStack = topOfStack.link;
            
            return temp;
        }       
    }   

    /**
     * Adds an element to the stack. Newly added element
     * becomes the top-of-stack element
     *
     * @param element a new element to add to the stack
     *
     */
    public void push(E element) {
        
        StackNode newTop = new StackNode(element);
        
        newTop.link = topOfStack;
       
        topOfStack = newTop;    
        
        count++;        
    }


    /**
     * Returns the number of elements in the stack
     *
     * @return the number of elements in the stack
     */
    public int size(   ) {
            
        return count;
    }   
        
//    -------------------------------------------------
//         
//         Inner Class: StackNode
//      
//    ------------------------------------------------
        
    class StackNode {
            
        private E  item;
            
        private StackNode  link; //points to the element
                                     //one position below this node
            
        public StackNode(E item) {
                
            this.item = item;
            this.link = null; //new node is always added to the top
        }
    }
}

