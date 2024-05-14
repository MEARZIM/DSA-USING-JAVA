/**
 * 
 */
package Queue;

import java.util.Scanner;

/**
 *  Write a menu driven program to implement a circular queue (use an array to store
	the elements of the queue).
		You can follow any one of the schemes A circular list with front and rear indices and
		one position left vacant. Or, A circular list with front and rear indices and an integer
		variable counting entries
 */
class CircularQueue<T> {
	private T[] Queue;
	private Integer front;
	private Integer rear;
	private Integer maxSize;
	
	@SuppressWarnings("unchecked")
	public CircularQueue(Integer size ) {
		this.maxSize = size+1;
		this.front = 0;
		this.rear = 0;
		this.Queue = (T[]) new Object[this.maxSize];
	}
	
	public boolean isEmpty() {
		return this.front == this.rear;
	}
	
	public boolean isFull () {
		return (this.rear + 1) %this.maxSize == this.front;
	}
	
	public void enqueue (T ele ) {
		if (isFull()) {
			System.out.println("Queue is Full");
			
		} else {
			this.rear = (this.rear + 1) % this.maxSize;
			this.Queue[this.rear] = ele;
			System.out.println("Enqueued " + ele);
		}
	}
	
	public boolean dequeue () {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return false;
		}
		this.front = (this.front + 1) % this.maxSize;
		T ele = this.Queue[this.front];
		System.out.println("Element " + ele + " is removed");
		this.Queue[front] = null;
		return true;

	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			System.out.println("Queue elements: ");
			int i = (this.front + 1) % this.maxSize;
			while (i != this.rear) {
				System.out.print(this.Queue[i]+" ");
				i = (i+1)% this.maxSize;
			}
			System.out.println(this.Queue[i]);
		}
		
	}
}

public class Q2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the size of the circular queue: ");
		int size = scanner.nextInt();
		CircularQueue<Integer> circularQueue = new CircularQueue<Integer>(size);

		int choice;
		do {
			System.out.println("\nCircular Queue Operations:");
			System.out.println("1. Enqueue");
			System.out.println("2. Dequeue");
			System.out.println("3. Display");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter element to enqueue: ");
				int data = scanner.nextInt();
				circularQueue.enqueue(data);
				break;
			case 2:
				circularQueue.dequeue();
				break;
			case 3:
				circularQueue.display();
				break;
			case 4:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		} while (choice != 4);
		scanner.close();
	}

}

/*
 * OutPut -
Enter the size of the circular queue: 5

Circular Queue Operations:
1. Enqueue
2. Dequeue
3. Display
4. Exit
Enter your choice: 1
Enter element to enqueue: 34
Enqueued 34

Circular Queue Operations:
1. Enqueue
2. Dequeue
3. Display
4. Exit
Enter your choice: 1
Enter element to enqueue: 78
Enqueued 78

Circular Queue Operations:
1. Enqueue
2. Dequeue
3. Display
4. Exit
Enter your choice: 1
Enter element to enqueue: 67
Enqueued 67

Circular Queue Operations:
1. Enqueue
2. Dequeue
3. Display
4. Exit
Enter your choice: 1
Enter element to enqueue: 567
Enqueued 567

Circular Queue Operations:
1. Enqueue
2. Dequeue
3. Display
4. Exit
Enter your choice: 3
Queue elements: 
34 78 67 567

Circular Queue Operations:
1. Enqueue
2. Dequeue
3. Display
4. Exit
Enter your choice: 1
Enter element to enqueue: 67
Enqueued 67

Circular Queue Operations:
1. Enqueue
2. Dequeue
3. Display
4. Exit
Enter your choice: 3
Queue elements: 
34 78 67 567 67

Circular Queue Operations:
1. Enqueue
2. Dequeue
3. Display
4. Exit
Enter your choice: 2
Element 34 is removed

Circular Queue Operations:
1. Enqueue
2. Dequeue
3. Display
4. Exit
Enter your choice: 3
Queue elements: 
78 67 567 67

Circular Queue Operations:
1. Enqueue
2. Dequeue
3. Display
4. Exit
Enter your choice: 1
Enter element to enqueue: 34
Enqueued 34

Circular Queue Operations:
1. Enqueue
2. Dequeue
3. Display
4. Exit
Enter your choice: 3
Queue elements: 
78 67 567 67 34

Circular Queue Operations:
1. Enqueue
2. Dequeue
3. Display
4. Exit
Enter your choice: 
*/
