package SinglyLinkedList;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

public class LinkedList {
	public static Node arratToLinkedList(int arr[]) {
		Node head = new Node(arr[0]);
		Node mover = head;
		for (int i = 1; i < arr.length; i++) {
			Node temp = new Node(arr[i]);
			mover.next = temp;
			mover = mover.next;
		}

		return head;
	}

	public static Node reverseLinkedListUsingIteration(Node head) {
		if (head == null || head.next == null) {
            return head;
        }
		
		Node temp = head;
		Node prev = null;

		while (temp != null) {
			Node front = temp.next;
			temp.next = prev;
			prev = temp;

			temp = front;
		}

		return prev;
	}
	public static Node reverseLinkedListUsingRecursion(Node head) {
		if (head == null || head.next == null) {
            return head;
        }
        
        // Recursive step:
        // Reverse the linked list starting
        // from the second node (head.next).
        Node newHead = reverseLinkedListUsingRecursion(head.next);
        
        // Save a reference to the node following
        // the current 'head' node.
        Node front = head.next;
        
        // Make the 'front' node point to the current
        // 'head' node in the reversed order.
        front.next = head;
        
        // Break the link from the current 'head' node
        // to the 'front' node to avoid cycles.
        head.next = null;
        
        // Return the 'newHead,' which is the new
        // head of the reversed linked list.
        return newHead;
	}
	
	public static int LenghtOfTheLinkedList(Node head) {
		int count = 0;
		while(head.next!= null) {
			count++;
			head = head.next;
		}
		return count;
	}
	
	public static void insertAtAnyPosition(Node head, int data, int position) {
		
		if(position <= LenghtOfTheLinkedList(head)) {
			Node newNode = new Node(data);
			
			if ( position == 0 ) {
				// Insert At 1st
				newNode.next = head;
				head = newNode;
			} else {
				Node temp = head;
				while (--position != 0) temp = temp.next;
				
				newNode.next = temp.next;
				temp.next = newNode;
				
			}
		
		} else {
			System.out.println("Invalid Positon");
		}
		
	}
	
	public static Node deleteAtAnyPositon(Node head, int position) {
		
		if (head == null ) {
			System.out.println("List is empty");
		}
		
		if (position < LenghtOfTheLinkedList(head)) {
			if (position == 0) {
				head = head.next;
			} else {
				Node temp = head;
				while(--position != 0) temp= temp.next;
				
				Node freeNode = temp.next;
				temp.next = temp.next.next;
				
				freeNode.next = null;
			}
			
			
			
		} else {
			System.out.println("Invalid Positon");
		}
		return head;
	}

	public static void printLinkedList(Node head) {
		while (head.next != null) {
			System.out.print(head.data + ", ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4 };
		Node store = arratToLinkedList(arr);
		printLinkedList(store);
		Node rev  = reverseLinkedListUsingRecursion(store);
		printLinkedList(rev);
		
		insertAtAnyPosition(rev,10,2);
		printLinkedList(rev);
		Node afterDelete = deleteAtAnyPositon(rev,2);
		printLinkedList(afterDelete);

	}
}
