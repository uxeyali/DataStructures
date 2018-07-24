
public class Node {
	
	
		// DATA MEMBERS
		private Node lptr;
		private char item;
		private Node rptr;
		
		
		// CONSTRUCTORS
		
	// Default Constructor
		public Node() {
		this(null,'0', null);
		}
	
	// Regular Constructor
		public Node(Node lptr, char data, Node rptr) {
		setLptr(lptr);
		setItem(data);
		setRptr(rptr);
		}

		
		// METHODS
		
	//GetWhatsInside
		public char getItem( ) {
		return item;
		}
		
	//GetNextLink
		public Node getRptr( ) {
		return rptr;
		}
		

	//GetPreviousLink
		public Node getLptr( ) {
		return lptr;
		}
		
	//SetWhatsInside
		public void setItem(char data) {
		item = data;
		}
		
	//SetPreviousLink
		public void setLptr(Node node) {
		lptr = node;
		}
		

	//SetNextLink
		public void setRptr(Node node) {
		rptr = node;
		}
		
		}