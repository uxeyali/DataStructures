//---------------------
//	 Uzma Ghazanfar
//---------------------


public class kForm {
	
static NPSStack <Character> Stack = new NPSArrayStack <Character>(100);

	//Prints in 3's. Pops stack 3 times and prints characters
	public static void Print3s(){
		
		//initialize char Top, Mid and Bottom
		char Top;
		char Mid;
		char Bott;
		
		//Check to see if there are enough items to pop before popping it
		//if the Stack size is less than 2
		if(Stack.size()<=2){
			
			//obviously the formula is invalid
			System.out.println("Invalid formula a");
			
			//as long as the stack is not empty, pop it until it is
			while(!Stack.isEmpty()){
				Stack.pop();
			}
			
			//if Stack has more than 2 items in it
		} else {
			
			//Assign Stacks popped item to a variable
			Top = Stack.pop();
			Mid = Stack.pop();
			Bott = Stack.pop();
			
			//Prints out the nodes and edges
			System.out.print(" "+Bott +""+Mid+""+Top);
			
			//Pushes back the middle variable back into the stack
			Stack.push(Mid);
			
			//If the new Stack has consecutive operands, recursively calls the Print method 
			if(containsDoubleOperands()){
				Print3s();
			}
		}
	}
	
	
	//checks if the current symbol is an asterix. Returns true if it is. False otherwise.
	public static boolean isAsterix(char symb){
		
		//returns true if symbol is an asterix
		if(symb == '*'){
			return true;
		}
		
		//otherwise returns false
		return false;
	}
	
	//checks to see if the stack contains consecutive operands within it.
	public static boolean containsDoubleOperands(){
		
		//initializes variables
		char symbTop;
		char symbBott;
		
		//checks to see if stack size is less than 2. If it is, returns false straight up
		if(Stack.size()<=2){
			return false;
			
			//otherwise pops the stack twice and assigns to the variables
		} else {
			symbTop = Stack.pop();
			symbBott = Stack.pop();
		}

		//now checks if either of the symbols are an asterix
		
		//if neither are asterix, pushes them back in stack and returns true
		if((!isAsterix(symbTop)) && (!isAsterix(symbBott))){
			Stack.push(symbBott);
			Stack.push(symbTop);
			return true;
		}
		
		//otherwise, pushes them back into the stack and returns false
		Stack.push(symbBott);
		Stack.push(symbTop);
		
		return false;
	}
	
	//checks if the current symbol is going to be the second consecutive operand in the stack
	public static boolean isSecondOperand(){
		
		//if the stack is empty, return false,
		if(Stack.isEmpty()){
			return false;
		}
		
		//if the top symbol is not an asterix (which means its an operand) return true
		if(!isAsterix(Stack.peek())){
			return true;
		}
		
		//in any other case, return false
		return false;
	}


	public static void main(String[] args) {

		//char [] input = "***abcd".toCharArray(); //a
		//char [] input = "**ab*cd".toCharArray(); //b
		//char [] input = "***a***bbcecd".toCharArray(); //c
		//char [] input = "*a**d*b**cd*ea".toCharArray(); //d
		//char [] input = "***a*bc**dcb".toCharArray(); //e
		char [] input = "a**bc*cd".toCharArray(); //f
		
		//initialize variable i to 0
		int i=0;
		
		//as long as i is less than length of input
		while(i<input.length){
			
			//check if the symbol is an asterix
			if(isAsterix(input[i])){
				//if it is, push it into stack		
				Stack.push(input[i]);
				//increment i by 1
				i++;
				
			//if the symbol is not an asterix (is an operand)
			} else {
				
				//first check it if it the second operand
				if(isSecondOperand()){
					
					//if it is, push it into stack first
					Stack.push(input[i]);
					
					//then print the three symbols out
					Print3s();
					
				//if it isnt a second operand
				} else {
					
					// just push it into the stack
					Stack.push(input[i]);
				}
				
				//now check if there are already consecutive operands in the stack
				if(containsDoubleOperands()){
					
					//if there are, print them out
					Print3s();
				}
				
				//increment i by 1 now
				i++;
			}
			
		}
		
		//after going through the whole array, there will always be one extra operand in, so remove it
		Stack.pop();
		
		//now if the stack is not empty. repeat this until stack is empty.
		while(!Stack.isEmpty()){
				
				//first check if the stack size is less than or equal to 0. if it is:
				if((Stack.size()<=2)){
					
					//pop all the elements and do nothing with them.
					while(!Stack.isEmpty()){
						Stack.pop();
					}
					
					//also print out invalid formula, because if it were valid, it would never have just two elements in the stack
					System.out.println(" Invalid formula");
					
					//if the stack size is not less than or equal to 2
					} else {
						
					//pop Stack thrice and assign to variables
					char right = Stack.pop();
					char mid = Stack.pop();
					char left = Stack.pop();
					
					//check if the second or third variables are asterix. If any of those two are asterix, the formula is invalid
					if(isAsterix(mid)||(isAsterix(right))){
						
						//print invalid formula
						System.out.println(" Invalid formula");
						
					//otherwise, if neither is an asterix
					} else {
					
					//print the values out
					System.out.println(left+ ""  + mid + "" + right);
					
					//repeat process until stack is empty
					}
				}
				
			
		}

	}

}
