/**
 * 
 */
package Stack;

import java.util.Stack;

/**
 * 
    Write a method in a separate class to evaluate a postfix expression 
    (Consider more than single digit number as a input).
 */

class PostfixEvaluator {
	Stack<Integer> stk;
	
	PostfixEvaluator (){
		stk = new Stack<Integer>();
	}
	
	private boolean isNumaric ( String str ) {
		// for Cancel out the expressions
		String exp  = "-?\\d+(\\.\\d+)?"; 
		return str.matches(exp); 
	}
	
	public int EvaluatePostfix(String expression) {
		if (expression == null || expression.isEmpty()) {
			throw new IllegalArgumentException("Expression cannot be null or empty");
		}

		String tokens[] = expression.split("\\s+"); // Remove spaces and separate all the characters

		for (String token : tokens) {
//			System.out.println(token);
			if (isNumaric(token)) {
				this.stk.push(Integer.parseInt(token));
			} else {
				int operand1 = this.stk.pop();
				int operand2 = this.stk.pop();
				int result;

				switch (token) {
				case "+":
					result = operand1 + operand2;
					break;
				case "-":
					result = operand1 - operand2;
					break;
				case "*":
					result = operand1 * operand2;
					break;
				case "/":
					result = operand1 / operand2;
					break;
				default:
					throw new IllegalArgumentException("Invalid operator: " + token);
				}
				this.stk.push(result);
			}
		}
		
//		for (int i: stk) {
//			System.out.println("Stack "+i);
//		}
		if(this.stk.size() == -1) {
			throw new IllegalArgumentException("Invalid Expression ");
		}
		return this.stk.pop();
	}
}

public class Question3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String postfixExpression = "3 4 + 2 *";
		 
		 PostfixEvaluator ev = new PostfixEvaluator();
		 
		 System.out.println("Result of (" + postfixExpression + ") is: " + ev.EvaluatePostfix(postfixExpression));
	}

}

/*
 * Output:
Result of (3 4 + 2 *) is: 14
*/