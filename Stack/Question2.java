
/**
	Write a method in a separate class to check an expression is valid or not.
*/
package Stack;

import java.util.Stack;

class Expression{
	Stack<Character> stk ;
	
	Expression(){
		stk = new Stack<>();
	}
	
	public boolean isValidExpression (String expression) {
		if(expression == null || expression.isEmpty()) {
			return false;
		}
		
		for (char ch: expression.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') {
				stk.push(ch);
			} else if (ch == ')' || ch == '}' || ch == ']') {
                if (stk.isEmpty()) {
                    return false; // Unmatched closing bracket
                }
                char top =  stk.pop();
                if ( (ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{') ) {
                    return false; // Mismatched opening and closing brackets
                }
            }
		}
		
		return stk.isEmpty();
	}
	
	
	
}

public class Question2 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String expression = "{[()]()}";
//		String expression = "{[(])}";
		String expression = "{";
		

		
		Expression ex = new Expression();
		
		System.out.println("Expression is valid: " + ex.isValidExpression(expression) );
		
	}

}
/*
 * Output:
Expression is valid: false
*/