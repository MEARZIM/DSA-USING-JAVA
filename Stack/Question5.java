/**
 * 
 */
package Stack;

import java.util.Stack;

/**
 *  Write a method in a separate class to convert an infix expression to its corresponding postfix
	expression.
 */

class InfixToPostfixConverter{
	private Stack<Character> stk;
	InfixToPostfixConverter(){
		stk = new Stack<Character>();
	}
	
	private boolean isOperand( char ch ) {
		 return Character.isLetterOrDigit(ch); // For differentiate Letter and Digits
	}
	
	private int precedence(char operator) {
		switch (operator) {
			case '+':
				return 1;
			case '-':
				return 1;
			case '*':
				return 1;
			case '/':
				return 2;
			case '^':
				return 3;
			default:
				return -1;
		}
	}
	
	public String infixToPostfix(String infixExpression) {
		if (infixExpression == null || infixExpression.isEmpty()) {
			throw new IllegalArgumentException("Expression cannot be null or empty");
		}
		
		StringBuilder postfix = new StringBuilder();
		
		for(char ch: infixExpression.toCharArray()) {
			if (isOperand(ch)) {
				postfix.append(ch);
			} else if (ch == '(') {
				this.stk.push(ch);
			} else if (ch == ')') {
				// For Brackets
				while (!this.stk.isEmpty() && stk.peek() != '(') {
					postfix.append(this.stk.pop());
				}
				if (!this.stk.isEmpty() && this.stk.peek() != '(') {
					throw new IllegalArgumentException("Invalid expression: Unmatched parentheses");
				} else {
					this.stk.pop();
				}
			} else {
				// operators According to there precedence
				while( !this.stk.isEmpty() && this.precedence(ch) <= this.precedence(this.stk.peek())  ) {
					postfix.append(this.stk.pop());
				}
				this.stk.push(ch);
			}
		}
		
		while (!this.stk.isEmpty()) {
            if (this.stk.peek() == '(') {
                throw new IllegalArgumentException("Invalid expression: Unmatched parentheses");
            }
            postfix.append(this.stk.pop());
        }
        
        return postfix.toString();
	}
}

public class Question5 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String infixExpression1 = "(a+b*c-d)+f-g";

		InfixToPostfixConverter obj = new InfixToPostfixConverter();

		System.out.println("Postfix expression of " + infixExpression1 + " is: " + obj.infixToPostfix(infixExpression1));

	}

}


/*
 * Output:
Postfix expression of (a+b*c-d)+f-g is: ab+c*d-f+g-
*/