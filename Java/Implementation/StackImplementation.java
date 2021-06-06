import java.util.EmptyStackException;

public class StackImplementation {
	Node top;
	int length;
	
	public class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public static void main(String[] args) {
		StackImplementation stack = new StackImplementation();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	public void push(int value) {
		Node newNode = new Node(value);
		newNode.next = top;
		top = newNode;
		length++;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		int value = top.data;
		top = top.next;
		length--;
		return value;
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return top.data;
	}

}
