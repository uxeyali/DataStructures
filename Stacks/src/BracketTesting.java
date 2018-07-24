import java.util.Scanner;

public class BracketTesting {

	static NPSStack <String> curlyBracket = new NPSArrayStack <String>();
	static NPSStack <String> squareBracket = new NPSArrayStack <String>();
	static NPSStack <String> parenthesis = new NPSArrayStack <String>();
	
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner (System.in);

		String string = scanner.nextLine();
		
		int dontMatchCurly = 0;
		int dontMatchParenthesis = 0;
		int dontMatchSquare =0;
		
		for (int i = 0; i < string.length(); i++){
			
		char chara = string.charAt(i);
			
			//case 1 Curly brackets - using ASCII codes 123 for { and 125 for }
			
			if((chara != 123)&& (chara!=125)){
				
			} else {
				
				if(chara == 123){
					curlyBracket.push("A");
				}
				
					if((chara == 125) && (curlyBracket.isEmpty())){
						System.out.println("Incorrect Order of Curly Bracket");
						dontMatchCurly++;
			}
					if((chara == 125) && !(curlyBracket.isEmpty())){
						curlyBracket.pop();
			}
		}
			
			
			//case 2 Parenthesis - using ASCII codes 40 for ( and 41 for )
			
			if((chara != 40 )&& (chara!=41)){
				
			} else {
				
				if(chara == 40){
					parenthesis.push("A");
				}
				
					if((chara == 41) && (parenthesis.isEmpty())){
						System.out.println("Incorrect Order of Parenthesis");
						dontMatchParenthesis++;
			}
					if((chara == 41) && !(parenthesis.isEmpty())){
						parenthesis.pop();
			}
		}
			
			
			//case 3 Square Brackets - using ASCII codes 91 for [ and 93 for ]
			
			if((chara != 91 )&& (chara != 93)){
				
			} else {
				
				if(chara == 91){
					squareBracket.push("A");
				}
				
					if((chara == 93) && (squareBracket.isEmpty())){
						System.out.println("Incorrect Order of Square Brackets\n");
						dontMatchSquare++;
			}
					if((chara == 93) && !(squareBracket.isEmpty())){
						squareBracket.pop();
			}
		}
			
			
			
		}

		if(dontMatchCurly == 0 && (curlyBracket.isEmpty()) ){
			System.out.println("Curly Braces match");
		} else {
			
			System.out.println("Curly Braces are not matched");
		}
		
		if(dontMatchParenthesis == 0 && (parenthesis.isEmpty()) ){
			System.out.println("Parenthesis match");
		} else {
			
			System.out.println("Parenthesis are not matched");
		}
		
		if(dontMatchSquare == 0 && (squareBracket.isEmpty()) ){
			System.out.println("Square Brackets match");
		} else {
			
			System.out.println("Square Brackets are not matched");
		
		
	}

}
}
