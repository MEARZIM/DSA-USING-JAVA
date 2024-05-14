package Stack;

import java.util.Stack;

/**
 *  Write a program to implement a Stack class (use a Array to store the elements of the stack).
	[Implement Stack Overflow and Underflow by user defined Exception]. Write a method to
	check two stack are carrying similar elements or not.(Repetition of the elements are not
	consider)
 */

class MyStack<T>{
	private Stack<T> stack ;
	
	public MyStack() {
		stack = new Stack<T>();
	}
	
	public boolean push(T ele) {
		try {
			this.stack.push(ele);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public T pop() {
		T ele = this.stack.pop();
		return ele;
	}
	
	public void printStack() {
		System.out.println(this.stack);
	}
}

public class Question1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack<Integer> stack = new MyStack<Integer>();
		 
        // Use add() method to add elements
        stack.push(10);
        stack.push(15);
        stack.push(30);
        stack.push(20);
        stack.push(5);
        stack.pop();
        stack.printStack();
	}

}
/*
 * Output:
[10, 15, 30, 20]
*/
