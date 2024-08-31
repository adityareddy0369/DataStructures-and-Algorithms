import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	
	Node root;
	
	public class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();
		binaryTree.preOrderRecusrsive(binaryTree.root);
		System.out.println();
		binaryTree.preOrderIterative(binaryTree.root);
		System.out.println();
		binaryTree.inOrderRecursive(binaryTree.root);
		System.out.println();
		binaryTree.inOrderIterative(binaryTree.root);
		System.out.println();
		binaryTree.postOrderRecursive(binaryTree.root);
		System.out.println();
		binaryTree.postOrderIterative(binaryTree.root);
		System.out.println();
		binaryTree.levelOrderTraversal(binaryTree.root);
		System.out.println();
		binaryTree.isSymmetric();
	}

	private void isSymmetric() {
		System.out.println(isSymmetric(root));
	}

	private boolean isSymmetric(Node root) {
		if(root == null) {
			return true;
		}
		Stack<Node> stack = new Stack();
		stack.push(root.right);
		stack.push(root.left);
		while(!stack.isEmpty()) {
			Node n1 = stack.pop();
			Node n2 = stack.pop();
			if(n1 == null && n2 == null) {
				continue;
			}
			if(n1 == null || n2 == null || n1.data != n2.data) {
				return false;
			}
			stack.push(n1.left);
			stack.push(n1.right);
			stack.push(n2.left);
			stack.push(n2.right);
		}
		return true;
	}


	public void createBinaryTree() {
		Node first = new Node(1);
		Node  second= new Node(2);
		Node  third= new Node(3);
		Node  fourth= new Node(4);
		Node  fifth= new Node(5);
		Node sixth = new Node(6);
		Node seventh = new Node(7);
		
		root = first;
		first.left = second;
		first.right = third;
		
		second.left = fourth;
		second.right = fifth;
		
		third.left = sixth;
		third.right = seventh;
	}
	
	// Visit the root node
	// Traverse the left subtree in preorder fashion
	// Traverse the right subtree in preorder fashion
	public void preOrderRecusrsive(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrderRecusrsive(root.left);
		preOrderRecusrsive(root.right);
	}
	
	public void preOrderIterative(Node root) {
		if(root == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node temp = stack.pop();
			System.out.print(temp.data + " ");
			if(temp.right != null) {
				stack.push(temp.right);
			}
			if(temp.left != null) {
				stack.push(temp.left);
			}
		}
	}
	// Traverse the left subtree in in order fashion
	// Visit the root node
	// Traverse the right subtree in in order fashion
	public void inOrderRecursive(Node root) {
		if(root == null) {
			return;
		}
		inOrderRecursive(root.left);
		System.out.print(root.data + " ");
		inOrderRecursive(root.right);
	}
	
	public void inOrderIterative(Node root) {
		
	}
	
	public void postOrderRecursive(Node root) {
		if(root == null) {
			return;
		}
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.data + " ");
	}
	
	private void postOrderIterative(Node root) {
		
	}

	private void levelOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.data + " ");
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}

}
