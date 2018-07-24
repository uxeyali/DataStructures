
public class NaturalCorrespondenceAlgo {

	public static void PreTrav(Node tree){
		//if tree is not empty
		if(tree !=null){
			
			//print item in the current tree node
			System.out.print("["+tree.getItem()+"] ");
			//recursively call PreTrav with the left pointer
			PreTrav(tree.getLptr());
			//recursively call PreTrav with the right pointer
			PreTrav(tree.getRptr());
		}
	}
	
	public static void InTrav(Node tree){
		//if tree is not empty
		if(tree !=null){
			
			//recursively call InTrav with the left pointer
			InTrav(tree.getLptr());
			//print item in the current tree node
			System.out.print("["+tree.getItem()+"] ");
			//recursively call InTrav with the right pointer
			InTrav(tree.getRptr());
		}
	}
	
	//Finds and returns the node with the value of character passed
	public static Node Find(Node p, char x){
		
		//checks if the current node has the value x in its info
		if(p.getItem()==x){
			//returns the node if true
			return p;
			
			//otherwise. It moves left or right
			} else {
		
			//if the left pointer of a node is not null, goes into it and recursively checks if there is a node with the info x
			if((p.getLptr()!=null)){
				
				//this will either return the node with the char x value or will return null
				Node y = Find(p.getLptr(),x);
				
				//if the node returned is not null, return y. Otherwise continue to next step
				if((y!=null)){
				return y;
				}
			}
			
			//if the right pointer of a node is not null, goes into it and recursively checks if there is a node with the info x
			if((p.getRptr()!=null)){
				
				//this will either return the node with the char x value or will return null
				Node z = Find(p.getRptr(),x);
				
				//if the node returned is not null, return z. Otherwise continue onwards
				if(z!=null){
				return z;
				}
			}
		}
		//if not found return null pointer
		return null;
	}

	public static void main(String[] args) {

		char [] input = "(P(QR))".toCharArray();
		//char [] input = "(P(Q(ST)R(U)))".toCharArray();
		//char [] input = "(A(B(E(KL)F)C(G)D(H(M)IJ)))".toCharArray();
		
		NPSStack <Character> Stack = new NPSArrayStack <Character>(100);
		
		
		//Step 1 - creates a new node and assigns it to TreeRoot
		Node y = new Node();
		Node TreeRoot = y;
		
		//inserts the value in the index 1 into TreeRoot (since 0 is '(' always
		TreeRoot.setItem(input[1]); 
		
		System.out.println("Treeroot: "+TreeRoot.getItem());
		//initiates index counter
		int i=1;
		
		//Step 2 - moved the index counter ahead by 1
		i++;
		
			//Starts iteration (in pseudo code - return to step2)
		//Keeps the iteration going until the end of the algorithm
			while(i<=input.length){
				
			//Step 3 - what to do in case the character is '('
			if(input[i] == '('){
				
				//Create a new node z
				Node z = new Node();
				
				//set y's left pointer to point at the new node z
				y.setLptr(z);
				
				//push the item of the node y into the Stack
				Stack.push(y.getItem());
				
				//point y at z
				y = z;
				
				//move index forward
				i++;
				
				//insert the value of i into the node y (old z)
				y.setItem(input[i]);
				
				//move the index counter forward again
				i++;
			}
			
			//Step 4 - what to do in case the character is ')'
			if(input[i] == ')'){
				
				//Set the right pointer to null
				y.setRptr(null);
				
				//if the left pointer of y is not set, set it to null
				if(y.getLptr()==null){
					y.setLptr(null);
				} 
				
				//if the stack is empty, jump out of the loop
				if(Stack.isEmpty()){
					break;
				} else {
					// if the stack is not empty
					
					//create a new node that points to the TreeRoot
					Node n = TreeRoot;
					
					//pop the stack
					char x= Stack.pop();
					
					//find the popped info's node and assign it to y
					y = Find(n,x);
					
					//increment i by 1
					i++;
				}
			}
		
			//Step 5 - what to do if character is an operand
			if((input[i] != '(') && (input[i] != ')')){
				
				//create a new node
				Node z = new Node();
				
				//if left pointer of y is not set, set it to null
				if(y.getLptr() == null){
					y.setLptr(null);
				}
				
				//set y's right pointer to the new node z
				y.setRptr(z);
				
				//point y to z
				y = z;
				
				//insert the current character into the info of y
				y.setItem(input[i]);
				
				//increment i by 1
				i++;
			}
		}
			
			//Print traversals
			System.out.println("PreOrder Traversal:");
			PreTrav(TreeRoot);
			System.out.println("");
			System.out.println("InOrder Traversal:");
			InTrav(TreeRoot);
			
			
	}

}
