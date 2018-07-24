
public class kFormula {
	
	static NPSStack <Character> Stack = new NPSArrayStack <Character>(100);
	
	public static boolean isAsterix(char symb){
		if(symb == '*'){
			return true;
		}
		return false;
	}
	
	public static boolean isDoubleOperand(){
		char symbTop;
		char symbBott;
		
		if(Stack.size()==1){
			return false;
		} else {
			symbTop = Stack.pop();
			symbBott = Stack.pop();
		}
		
		if((!isAsterix(symbTop)) && (!isAsterix(symbBott))){
			Stack.push(symbBott);
			Stack.push(symbTop);
			return true;
		}
		
		Stack.push(symbBott);
		Stack.push(symbTop);
		
		return false;
	}
	
	public static boolean isSecondOperand(){
		
		if(Stack.isEmpty()){
			return false;
		}
		
		if(!isAsterix(Stack.peek())){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		char [] input = "***a*bc**dcb".toCharArray();
		int i=0;
		
		while(i<input.length){
			
			if(isAsterix(input[i])){
				Stack.push(input[i]);
				i++;
			} else {
				if(isDoubleOperand()){
//					System.out.println("Apparently we have double operands");
					char Top;
					char Mid;
					char Bott;
					
					if(Stack.size()<=2){
						System.out.println("Invalid formula c");
						break;
					} else {
						Top = Stack.pop();
						Mid = Stack.pop();
						Bott = Stack.pop();
						Stack.push(Mid);
					}
					
				}
				
//				System.out.println("Went through this too");
				if(isSecondOperand()){
					char x;
					char y;
					
					if(Stack.size()==1){
						System.out.println("Invalid formula f");
						break;
					} else {
						x = Stack.pop();
						y = Stack.pop();
					}
					
					System.out.println(y + "" + x + "" + input[i]);
					Stack.push(x);
					i++;
					
				} else {
					Stack.push(input[i]);
					i++;
				}
			}
		}
		
		
		
		while(!Stack.isEmpty()){
			
			System.out.println("Stack Size: " +Stack.size());
			
			if(Stack.size()<=2){
				
				while(!Stack.isEmpty()){
					Stack.pop();
				}

				System.out.println("Invalid formula e");
				
				} else {
				char right = Stack.pop();
				char mid = Stack.pop();
				char left = Stack.pop();
				
				if(!isAsterix(left)){
					System.out.println("Invalid formula g");
				} else {
				System.out.println(left+ ""  + mid + "" + right);
				}
			}
			
			
		}
	
		
		
	}

}
