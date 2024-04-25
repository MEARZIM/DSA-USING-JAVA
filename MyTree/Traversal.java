package MyTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */
class Node {
	protected int data;
	protected Node left, right;

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class Traversal {

	public static void InOrderTraversal(Node node) {
		// Traversing the left sub-tree then root then sub-tree right
		if (node == null) {
			return;
		}
		InOrderTraversal(node.left);

		System.out.print(" " + node.data + ", ");

		InOrderTraversal(node.right);
	}

	public static void PostOrderTraversal(Node node) {
		// Traversing the left sub-tree then right sub-tree then root
		if (node == null) {
			return;
		}
		PostOrderTraversal(node.left);

		PostOrderTraversal(node.right);

		System.out.print(" " + node.data + ", ");
	}

	public static void PreOrderTraversal(Node node) {
		// Traversing start with visiting the root node then left sub-tree then
		// right-subtree
		if (node == null) {
			return;
		}

		System.out.print(" " + node.data + ", ");

		PreOrderTraversal(node.left);

		PreOrderTraversal(node.right);
	}

	public static void LevelOrderTraversal(Node root) {
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

	public static int totalNumberOfNode(Node root) {
		if (root == null) {
			return 0;
		}
		int leftNodeCount = totalNumberOfNode(root.left);
		int rightNodeCount = totalNumberOfNode(root.right);

		return 1 + leftNodeCount + rightNodeCount;
	}

	public static int CountTheTotalNumberOfLeafNode(Node root) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return 1;
		} else {
			return CountTheTotalNumberOfLeafNode(root.left) + CountTheTotalNumberOfLeafNode(root.right);
		}
	}

	public static int getHeightOfBinaryTree(Node root) {
		if (root == null) {
			return 0;
		}

		int leftSubTreeCount = getHeightOfBinaryTree(root.left);
		int rightSubTreeCount = getHeightOfBinaryTree(root.right);

		if (leftSubTreeCount > rightSubTreeCount) {
			return leftSubTreeCount + 1;
		}

		return rightSubTreeCount + 1;
	}

	public static Node searchInBinaryTree(Node root, int key) {
		if (root == null || root.data == key) {
			return root;
		}

		if (root.data < key) {
			return searchInBinaryTree(root.right, key);
		}

		return searchInBinaryTree(root.left, key);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(50);
		root.left = new Node(30);
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		root.right = new Node(70);
		root.right.left = new Node(60);
		root.right.right = new Node(80);

		System.out.print("Inorder Traversal -> ");
		InOrderTraversal(root);

		System.out.println();

		System.out.print("Preorder Traversal -> ");
		PreOrderTraversal(root);

		System.out.println();

		System.out.print("Postorder Traversal -> ");
		PostOrderTraversal(root);

		System.out.println();

		System.out.print("Levelorder Traversal -> ");
		LevelOrderTraversal(root);

		System.out.println("\nTotal Number of nodes :" + totalNumberOfNode(root));
		System.out.println("Total Number of leaf node : " + CountTheTotalNumberOfLeafNode(root));
		System.out.println("The height of the bianry tree is : " + getHeightOfBinaryTree(root));

		int key = 40;
		
		System.out.println("Searching is BST->");
		// Searching in a BST
		if (searchInBinaryTree(root, key) == null)
			System.out.println(key + " not found");
		else
			System.out.println(key + " found");
		
		key= 800;
		if (searchInBinaryTree(root, key) == null)
			System.out.println(key + " not found");
		else
			System.out.println(key + " found");
	}

}
