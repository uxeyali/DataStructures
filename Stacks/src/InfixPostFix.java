//---------------------------
//		Uzma Ghazanfar
//---------------------------

public class InfixPostFix {
	
	//initialize and declare a stack that will store all the operators being processed during conversion from Infix string to Postfix string. Stack size is a 100.
	static NPSStack <Character> operatorStack = new NPSArrayStack <Character>(100);
	
	//Initialize and declare a stack that will store operands before an operator is found, after which it will pop the stack twice, do the aritmetic and push the result back in. Stack size is a 100.
	static NPSStack <Integer> evaluationStack = new NPSArrayStack <Integer>(100);
	
	
	// Checks if the symbol given is an operator or not
	// If the symbol is an operator, true is returned, otherwise false is returned.
    public static boolean isOperator(char symb){
    	
    	//if the symbol is multiply, return true
    	if(symb == '*'){
    		return true;
    	}    	
    	
    	//if the symbol is addition, return true
    	if(symb == '+'){
    		return true;
    	}
    	
    	//if the symbol is division, return true
    	if(symb == '/'){
    		return true;
    	}
    	
    	//if the symbol is subtract, return true
    	if(symb == '-'){
    		return true;
    	}
    	
    	//if the symbol is exponent, return true
    	if(symb == '&'){
    		return true;
    	}
    	
    	//if the symbol is left bracket, return true
    	//even though left brack is not exactly an operator, we need to specify this so it will be inserted into the operatorStack when it is come across in the string.
    	if(symb == '('){
    		return true;
    	}
    	
    	//for every other scenario, return false
    	return false;
    }
	
    //if the right parenthesis is come across ')', return true. Otherwise return false.
    public static boolean isRightParenthesis(char symb){
    	//if symbol is the right parenthesis ')' return true, otherwise return false
    	if(symb ==')'){
    		return true;
    	}
    	return false;
    }
    
    //checks the order of precendence. Returns true if the precedence of the op1 is higher than the precedence of op2. And in all other cases, returns false.
    public static boolean precedence(char op1, char op2){
    	
    	//precedence (*,+) will return true because * or / precedes + or - in order
    	if(((op1 == '*')||(op1=='/'))&&((op2=='+')||(op2=='-'))){
    		return true;
    	}
    	
    	//precedence(+,*) will return true because + or - does not precede + or - in order
    	if(((op1 == '+')||(op1=='-'))&&((op2=='*')||(op2=='/'))){
    		return false;
    	}
    	
    	//precedence(+,+) will return true because first + or - precedes second + or - in order
    	if(((op1 =='+')||(op1=='-'))&& ((op2=='+')||(op2=='-'))){
    		return true;
    	}
    	
    	//precedence(*,*) will return true because first * or / precedes second * or / in order
    	if(((op1 =='*')||(op1=='/'))&& ((op2=='*')||(op2=='/'))){
    		return true;
    	}
    	
    	//precedence('(',op) will return true because precedence of ( does not precede any other operator
    	if((op1=='(')&&((op2=='+')||(op2=='-')||(op2=='*')||(op2=='/'))){
    		return false;
    	}
    	
    	//precedence(op,'(') - False for all except ')' so we only need to define the case in which the precedence will return true, since everything else is returned false in the method.
    	if((op1==')')&&(op2=='(')){
    		return true;
    	}
    	
    	//precedence(op,')') - will return true for all operators except '('
    	if(((op1=='+')||(op1=='-')||(op1=='*'||(op1=='/')))&&(op2==')')){
    		return true;
    	}
    	
    	return false;
    }
    

    
    // does the arithmetic operation and returns an Integer
    public static Integer operation(int oper1, char op, int oper2){
    	
    	//since the operators are char, the arithmetic has to be done within if statements
    	
    	//if the operator is the char '+'
    	if(op == '+'){
    		//add operands 1 and 2 and return result
    		int result = oper1+oper2;
    		 return result;
    	}
    	
    	if(op == '-'){
    		//subtract operand 2 from 1 and return result
    		int result = oper1-oper2;
    		 return result;
    	}
    	
    	if(op == '*'){
    		//multiply operands 1 and 2 and return result
    		int result = oper1*oper2;
    		 return result;
    	}
    	
    	if(op == '/'){
    		//divide operand 1 by 2 and return result
    		int result = oper1/oper2;
    		 return result;
    	}
    	
    	//otherwise returns null
    	return null;
    }
    
    
    public static void main(String[] args) {
    	
    	//Array for post fix string initialized to a 100. This array will store the postfix string as characters are processed from infix to postfix.
		char[] postfixString = new char[100];
		
		//'track' tracks where to insert the next value in the array and tracks the actual size of the array in use at the time. This will be used in evaluation of the postfix string as well
		int track = 0;
		
		//----------------------------------------
		//	Converting Infix String to Postfix
		//----------------------------------------
		
		//The infix string expression that is to be converted to a postfix expression is hardcoded here.
		String expression = new String ("2+3-4+5*6/3");
		System.out.println("The infix expression is: " + expression);
		
		//This first for loop (FOR1) will make sure the loop is repeated until the length of the string-1.
		for(int i=0;i<=(expression.length()-1);i++){
			
			//Reads the current symbol and stores it as symb. This symbol will either go into postfix string or in the operator stack.
			char symb = expression.charAt(i);
			
			
			//----------------------------------
			// Check for right parenthesis ')'
			//----------------------------------
			
			// If the right parenthesis is come across first, everything will be popped until the left parenthesis is come across.
			
			//check to see if the symbol is the right parenthesis before anything else.
			if(isRightParenthesis(symb)){
				
				//pop everything and stick it in postfix string until ')' left parenthesis is come across. Once the ')' right parenthesis is come across, jump out of loop and ignore both '(' and ')'
				
				//go through the loop while the top symbol is not '('
				while(operatorStack.peek() != ('(') ){
					
					//pop the symbol and insert into postfix string
					postfixString[track] = operatorStack.pop();
					
					//increment tracker by 1
					track++;
				}
				
				//if the top symbol is '(', pop it and ignore it.
				if(operatorStack.peek() == ('(')){
					operatorStack.pop();
				}
				
			} // END of IF RIGHT PARENTHESIS
			
			//if the symbol read is an operator a series of complicated steps will now occur haha
			if(isOperator(symb)){
				
				
				//check if the stack is not empty and precedence returns true (in case, the top symbol in the operator stack has higher precedence than the symbol) and then do the following
				while((!operatorStack.isEmpty()) && precedence(operatorStack.peek(),symb)){
					
					//pop the top symbol and assign it to top symbol
					char topsymb = operatorStack.pop();
					
					//insert top symbol in place where tracker points in postfixString array
					postfixString[track]=topsymb;
					
					//increment tracker by 1
					track++;
				}
				
				//push the symbol into the operator stack. The symbol gets pushed into the operator stack regardless of anything. The only question is if the operator in the operator stack gets popped and inserted into the postfixString before it or not. 
				operatorStack.push(symb);
				
			} // END of IF OPERATOR

			//if Symbol is an operand and not a ')' put it in the post fix string array
			if(!isOperator(symb)&&(symb != ')')){
				
				// put the symbol in the position where track is pointing
	    		postfixString[track]=symb;
	    		
	    		// increment track by 1
	    		track++;
	    		
			} //END of IF OPERAND	
			
		} // END OF FOR1
		
		//once the whole string is processed, stick all the leftover operators in the operator stack into the post fix string until the operatorStack is empty.
		while(!operatorStack.isEmpty()){
			postfixString[track]=operatorStack.pop();
			track++;
		}
		
		//------------------------------------------
		// End of conversion from Infix to Postfix
		//------------------------------------------
		
		// Print postfixString
		System.out.print("The Postfix String is:  ");
		for(int i=0; i<=track-1;i++){
			System.out.print(postfixString[i] +" ");
		}
		
		System.out.println("");
		
		
		//----------------------------------------
		//	  Evaluation of the PostfixString
		//----------------------------------------
		
		//begins for loop that will go through the postfrixString array until track-1 (since track always points to the next empty slot)
		for(int i=0; i<=track-1;i++){
			
			//if the postfixString[i] is an operator, pop the stack twice, do the arithmetic in operation method and push the result back into the evaluation stack.
			if(isOperator(postfixString[i])){
				
				//pop and assign value to the second operand
				int op2 = evaluationStack.pop();
				
				//pop and assign value to the first operand
				int op1 = evaluationStack.pop();
				
				//the symbol in postfixString[i] is assigned as the operator
				char op = postfixString[i];
				
				//run the method operation, which will do the arithmetic and return the integer result
				int result = operation(op1, op, op2);
				
				//push the result back into the evaluation stack
				evaluationStack.push(result);
				
			} else{ //otherwise
				
				//if the postfixString[i] is not an operator, convert it to an integer and push it into the evaluation stack.
				
				//convert to an integer by minusing character '0'
				int a = postfixString[i]-'0';
				//push the integer into the evaluationStack 
				evaluationStack.push(a);
			
			}
		} //END of FOR
		
			// By the end, there should only be one element in the stack. Which when printed should return the answer
			System.out.println("The final result of the Postfix Stack is: "+evaluationStack.pop());
		
	}
}
