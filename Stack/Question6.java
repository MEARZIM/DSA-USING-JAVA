package Stack;
/*
 *  Write a method in a separate class to convert an infix expression to 
  	its corresponding prefix expression.
 */

class InfixToPrefixConverter{
	
	public String infixToPrefix(String infixExpression){
		
		Expression ex = new Expression();
		
		if (infixExpression == null || infixExpression.isEmpty() ) {
            throw new IllegalArgumentException("Expression cannot be null or empty ");
        }
		
		if(!ex.isValidExpression(infixExpression)) {
			throw new IllegalArgumentException("Invalid expression");
			
		}
		
		StringBuffer reversedInfix = new StringBuffer(infixExpression).reverse();
		
		// Replace '(' with ')' and vice versa for prepare the postfix expression
		for (int i = 0; i < reversedInfix.length(); i++) {
			if (reversedInfix.charAt(i) == '(') {
				reversedInfix.setCharAt(i, ')');
			} else if (reversedInfix.charAt(i) == ')') {
				reversedInfix.setCharAt(i, '(');
			}
		}
		
//		// Calling the infix to postfix function
        InfixToPostfixConverter objForPostfixExpression = new InfixToPostfixConverter();
        String postfixExpression = objForPostfixExpression.infixToPostfix(reversedInfix.toString());
//        
//		System.out.println(postfixExpression);
        // now reverse the result
		return new StringBuilder(postfixExpression).reverse().toString();
		
	}
}

public class Question6 {
	public static void main(String[] args) {
        String infixExpression1 = "(a+b)*c-d/e";
        
        InfixToPrefixConverter inx = new InfixToPrefixConverter();
       
        System.out.println("Prefix expression of " + infixExpression1 + " is: " + inx.infixToPrefix(infixExpression1));
	}
}

/*
 * Output:
Prefix expression of (a+b)*c-d/e is: *+ab-c/de

*/
