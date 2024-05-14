package DoublyLinkedList;

class Node {
	int data;
	Node prev;
	Node next;

	Node(int data) {
		this.data = data;
		this.prev = this.next = null;
	}

	Node(int data, Node prev, Node next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
}

public class LinkedList {

	public static Node arrayToDoublyLinkedLsit(int arr[]) {
		Node head = new Node(arr[0]);
		Node prev = head;
		for (int i = 1; i < arr.length; i++) {
			Node newNode = new Node(arr[i], prev, null);
			prev.next = newNode;
			prev = newNode;
		}

		return head;
	}

	public static Node reverseDoublyLinkedList(Node head) {
		Node current = head;
		Node prev = null;

		while (current != null) {
			prev = current.prev;
			current.prev = current.next;
			current.next = prev;

			current = current.prev;
		}
		return prev.prev;
	}

	public static int LenghtOFDLL(Node head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	public static Node insertAtAnyPositonInDoublyLinkedList(Node head, int position, int val) {
		if (head == null)
			return head;

		if (position < LenghtOFDLL(head)) {
			Node newNode = new Node(val);
			if (position == 0) {
				newNode.next = head;
				head.prev = newNode;
				head = newNode;
			} else {
				Node temp = head;
				while (--position != 0)
					temp = temp.next;

				newNode.prev = temp;
				newNode.next = temp.next;

				if (temp.next != null) {
					temp.next.prev = newNode;
				}

				temp.next = newNode;
			}

		} else {
			System.out.println("Invalid Position");
		}

		return head;
	}

	public static Node deleteNodeAtAnyPositon(Node head, int position) {
		if (head == null)
			return head;

		if (position < LenghtOFDLL(head)) {

			if (position == 0) {
				head = head.next;
				if (head != null) // Check if head is not null after deletion
					head.prev = null;
			} else {
				Node temp = head;
				while (--position != 0)
					temp = temp.next;

				temp.next = temp.next.next;
				if (temp.next != null) // Check if temp.next is not null after deletion
					temp.next.prev = temp;
			}

		} else {
			System.out.println("Invalid Position");
		}

		return head;
	}

	public static void print(Node head) {
		while (head != null) {
			System.out.print(head.data + " "); // Print the data in the current node
			head = head.next; // Move to the next node
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4 };
		Node dll = arrayToDoublyLinkedLsit(arr);
		print(dll);
		Node rdll = reverseDoublyLinkedList(dll);
		print(rdll);
		Node idll = insertAtAnyPositonInDoublyLinkedList(rdll, 2, 34);
		print(idll);
		Node ddll = deleteNodeAtAnyPositon(rdll, 4);
		print(ddll);

	}
}
