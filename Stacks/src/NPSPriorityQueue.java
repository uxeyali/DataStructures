/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 18 Sample Program: Heap-based implementation of the NPSQueue
                                that maintains the priority of the elements
    
     File: edu/nps/util/NPSPriorityQueue.java
*/

public class NPSPriorityQueue<E> implements NPSQueue<E> {
    
    private static final int DEFAULT_SIZE = 25;
    
    private static final int ROOT = 0;
    
    private E[] heap;
    
    private int count;
    
    public NPSPriorityQueue( ) {
        
        this(DEFAULT_SIZE);
    }

    /**
     * Creates a new PriorityQueue with the given size
     *
     * @param size the initial size of the item array
     */
    public NPSPriorityQueue(int size) {
        
        if (size <= 0) {
            throw new IllegalArgumentException( 
                       "Initial capacity must be positive");
        }
        
        heap =  (E[])new Object[size];

        clear();
    }
    

    public void add(E item) {
        
        if (count == heap.length) {
            expand( );
        }

        heap[count] = item;
        
        construct();
        
        count++;        
    }

   
    public void clear() {
        
        for (int i = 0; i < count; i++) { //clears all remaining items
            heap[i] = null;
        }
          
        count = 0;
        
    }

    public boolean isEmpty() {

        return count == 0;
    }

    public E peek() throws NPSQueueEmptyException {
        
        if (isEmpty()) {
            
            throw new NPSQueueEmptyException();

        } else {
            
            return (E) heap[ROOT];
        }
    }

    public E remove() throws NPSQueueEmptyException {
        
        E item;

        if (isEmpty()) {
            
            throw new NPSQueueEmptyException();
            
        } else {
            
            item = heap[ROOT];
            
            heap[ROOT] = heap[count-1];
            
            count--;
            
            rebuild(ROOT);
        }

        return item;
    }
    

    public int size() {
        
        return count;
    }
    
    
    private void construct() {
        
        for (int i = (count-2) / 2; i >= 0; i--) {
            
            rebuild(i);
        }
    }

    /**
     * Expands if the item array to handle the
     * overflow condition
     *
     */
    private void expand( ) {
        
        E[] temp =  (E[])new Object[(int) (heap.length * 1.5)];

        for (int i = 0; i < heap.length; i++) {
            temp[i] = heap[i];
        }

        heap = temp;
    }
    
    
    private int higherPriorityChild( int location, int end ) {

        int result, leftChildIndex, rightChildIndex;

        rightChildIndex = 2*location + 2;
        leftChildIndex  = 2*location + 1;


        if ( rightChildIndex <= end &&
            ((Comparable<E>)heap[leftChildIndex]).
                      compareTo(heap[rightChildIndex]) < 0) {

            result = leftChildIndex;

        } else {
            
            result = rightChildIndex;
        }

        return result;
    }

    
    private void rebuild(int root) {

        int current = root;
        
        boolean done = false;

        while (!done) {

            if (2*current+1 > count-1) {
                //current node has no children, so stop
                done = true;

            } else {
                //current node has at least one child,
                //get the index of higher-priority child
                //We consider e1 is higher priority if
                //if e1.compareTo(e2) < 0
                int hiChildIndex = higherPriorityChild(current, count-1);

                if (((Comparable<E>) heap[hiChildIndex]).
                               compareTo(heap[current]) < 0) {

                    swap(current, hiChildIndex);
                    current = hiChildIndex;

                } else { //value relationship constraint
                        //is satisfied, so stop
                    done = true;
                }
            }
        }
    }
    
    /**
     * Swaps the values in positions loc1 and loc2
     *
     * @param loc1 the position of the first int
     * @param loc2 the position of the second int
     */
    private void swap(int loc1, int loc2) {
        
        E temp;

        temp = heap[loc1];
        heap[loc1] = heap[loc2];
        heap[loc2] = temp;
    }
}
