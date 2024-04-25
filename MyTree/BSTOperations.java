package MyTree;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {

	public static void PrintBST(Node root) {
		// I am using level order traversal here
		Queue<Node> queue = new LinkedList<Node>();

		queue.add(root);
		while (!queue.isEmpty()) {
			Node tempData = queue.poll();

			System.out.print(" " + tempData.data + ", ");

			if (tempData.left != null) {
				queue.add(tempData.left);
			}

			if (tempData.right != null) {
				queue.add(tempData.right);
			}
		}
	}

	private static Node findLastRight(Node root) {
		if (root.right == null) {
			return root;
		}
		return findLastRight(root.right);
	}

	private static Node helper(Node root) {
		if (root.right == null) {
			return root.right;
		}

		if (root.left == null) {
			return root.left;
		}
		Node rightChild = root.right;
		Node lastRight = findLastRight(root.left);
		lastRight.right = rightChild;

		return root.left;
	}

	public static Node deleteNodeInBST(Node root, int key) {
		if (root == null) {
			return null;
		}
		if (root.data == key) {
			return helper(root);
		}

		Node temp = root;

		while (temp != null) {

			if (temp.left != null && temp.left.data == key) {
				temp.left = helper(temp.left);
				break;
			} else {
				if (temp.right != null && temp.right.data == key) {
					temp.right = helper(temp.right);
					break;
				} else {
					temp = temp.right;
				}
			}

		}
		return root;
	}
}

public class BSTOperations {
	public static void main(String args[]) {
		Node root = new Node(50);
		root.left = new Node(30);
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		root.right = new Node(70);
		root.right.left = new Node(60);
		root.right.right = new Node(80);

		System.out.print("Original Tree (Level Order Traversal): ");
		BinaryTree.PrintBST(root);
		System.out.println();

		// Deletion
		int key = 30;
		System.out.print("Tree After Deletion (Level Order Traversal): ");
		Node updatedTree = BinaryTree.deleteNodeInBST(root, key);
		BinaryTree.PrintBST(updatedTree);
	}
}
