/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 18 Sample Program: Linked-list implementation of the List ADT
    
     File: edu/nps/util/NPSLinkedList.java
*/

public class NPSLinkedList<E> implements NPSList<E> {

    public static final int NOT_FOUND = -1;

    private ListNode head;

    private ListNode tail;

    private int count;


    public NPSLinkedList(  ) {
        
        clear( );
    }


    public void add(E item) {
        
        //creates a new ListNode
        ListNode newNode = new ListNode(item);

        if (count == 0) {

            head = tail = newNode;
            
        } else {

            tail.next = newNode;
            tail = newNode;
        }

        count++;
    }


    public void add(int index, E item) throws IndexOutOfBoundsException {
        
        checkInsertPosition(index);
        
        ListNode ptr = head;

        ListNode newNode = new ListNode(item);

        if (index == 0) { //adding the new node as the first node

            newNode.next = head;
            head = newNode;
            
        } else {

            for (int i = 1; i < index; i++) {
                ptr = ptr.next;
            }

            newNode.next = ptr.next;
            ptr.next     = newNode;
        }

        //adjust tail if the new node added is
        //the last node in the list
        if (index == count) {
            tail = newNode;
        }

        count++;
    }

    
    public void clear(  ) {
        
        head = tail = null;

        count = 0;
    }


    public boolean contains(E item) {
        
        boolean result = true;

        int loc  = indexOf(item);

        if (loc == NOT_FOUND) {
            result = false;
        }

        return result;
    }


    public E get(int index) throws IndexOutOfBoundsException {
        
        checkAccessPosition(index);
        
        E item = null;

        ListNode ptr = head;

        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }

        item = ptr.item;

        return item;
    }


    public int indexOf(E item) {
        
        int loc = 0;

        ListNode ptr = head;

        while (loc < count && !ptr.item.equals(item)) {
            
            loc++;
            ptr = ptr.next;
        }

        if (loc == count) {
            loc = NOT_FOUND;
        }

        return loc;
    }

    public NPSIterator<E> iterator( ) {
        return new MyIterator();
    }

    public boolean isEmpty(  ) {
        
        return (count == 0);
    }


    public E remove(int index) throws IndexOutOfBoundsException {
        
        checkAccessPosition(index);
        
        ListNode deleteNode;
        
        ListNode ptr = head;
        
        if (index == 0) { //removing the first node
        
            deleteNode = ptr;
        
            head = head.next;
            
            if (head == null) { //removed first node is the only node
                tail = null;
            }
        
        } else {
    
            for (int i = 1; i < index; i++) {
                ptr = ptr.next;
            }
            
            deleteNode = ptr.next;
    
            ptr.next = deleteNode.next;
            
            if (ptr.next == null) { //very last node was removed
                tail = ptr;         //we have a new last node
            }
        }

        count--;
        
        return deleteNode.item;
    }


    public boolean remove(E item) {
        
        boolean result = false;

        ListNode ptr = head;
        ListNode trail = null;

        while (ptr != null && !ptr.item.equals(item)) {

            trail = ptr;
            ptr   = ptr.next;
        }

        if (ptr != null) { //found item

            if (trail == null) { //removing the first node
                
                head = head.next;
                
                if (head == null) { //removed first node is the only node
                    tail = null;
                }
                
            } else {
                
                trail.next = ptr.next;
                
                if (trail.next == null) { //very last node was removed, so
                    tail = trail;       //set tail points to a new last node
                }
            }
            
            result = true;   
            
            count--;
        }
        
        return result;
    }


    public E set(int index, E item) {
        
        checkAccessPosition(index);
        
        ListNode ptr = head;

        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        
        E old = ptr.item;

        ptr.item = item;
        
        return old;
    }


    public int size(  ) {
        
        return count;
    }


    /**
     * Checks the passed index position is a valid index that refers
     * to a non-empty position
     *
     * @param index  value to check for valid position
     * 
     * @exception IndexOutOfBoundsException if the passed index
     *              is outside of the range of valid access positions
     */
    private void checkAccessPosition(int index) {

        if (size() == 0) {
            
            throw new IndexOutOfBoundsException(
                        "Index " + index + " is invalid. List is empty.");
                
        } else if (index < 0) {
            
            throw new IndexOutOfBoundsException(
                        "Negative index of " + index + " is invalid");    
                                                              
        } else if (index > size()-1) {
            
            throw new IndexOutOfBoundsException(index +  
                        " is larger than valid upper bound" + (size()-1));
        }
    }
    
    
    /**
     * Checks the passed index position is a valid insertion point in 
     * the array.
     *
     * @param index   value to check for insertion position
     *
     * @exception IndexOutOfBoundsException if the passed index
     *              is outside of the range of valid insertion positions
     */
    private void checkInsertPosition(int index) {

        if (index < 0) {
            
            throw new IndexOutOfBoundsException(
                        "Negative index of " + index + " is invalid");    
                                                              
        } else if (index > size()) {
            
            throw new IndexOutOfBoundsException(index +  
                        " is larger than valid upper bound" + size());
        }
    }

    // Inner Class: ListNode

    class ListNode {

        private E  item;

        private ListNode next;

        public ListNode(E item) {
            this.item = item;
            this.next = null;
        }
    }
    
   ///---------- Inner Class :  MyIterator -------------////
    private class MyIterator implements NPSIterator<E> {
        
        private ListNode current;
        
        public MyIterator( ) {
            current = head;           
        }
        
        public boolean hasNext( ) {
            
            return (current != null) ;
        }
        
        public E next( ) throws NPSNoSuchElementException {
            
            if (current == null) {
                throw new NPSNoSuchElementException();
                
            } else {
                
                E item = current.item;
                current = current.next;
                
                return item;
            }           
        }
    }
}
