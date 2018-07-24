
public class StackTest {
	static NPSStack <Integer> myStack = new NPSArrayStack <Integer>();
	
	public static void main(String[] args) {
		
		for(int i = 1; i<=10; i++){ // decide number of elements in stack
			
			int times = (int) (5.0 *Math.random()+1.0); //random number of items to push
			int value;
			
			System.out.println("\n Pushed " + (times-1) + " items \n");
			
			for(int k = 1; k< times; k++){ // push
				
				value = (int) (25.0*Math.random()+10.0);
				System.out.println("Pushing: " + value);
				myStack.push(value);
				
			}
			
			int times1 = (int) (5.0 *Math.random()+1.0); //random number of items to pop
			
			System.out.println("\n Popped " + (times1-1) + " items \n");
			
			for(int j =1; j < times1; j++){
				
			if(myStack.isEmpty()){
				System.out.println("\n  Stack is empty");
				System.out.println("");
			}else {
				
				System.out.println("Popping: " + myStack.pop());
				}
			}
		}
		
		
	}

}
