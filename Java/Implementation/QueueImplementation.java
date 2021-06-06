import java.util.NoSuchElementException;

public class QueueImplementation {
	Node front;
	Node rear;
	int length;
	
	public class Node {
		int data;
		Node next;
		
		public  Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public static void main(String... args) {
		QueueImplementation queue = new QueueImplementation();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.print();
		queue.deQueue();
		queue.print();
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public void enQueue(int value) {
		Node newNode = new Node(value);
		if(isEmpty()) {
			front = newNode;
		} else {
		rear.next = newNode;
		}
		rear = newNode;
		length++;
	}
	
	public int deQueue() {
		if(isEmpty()) {
			throw new NoSuchElementException(" Queue is empty");
		}
		int result = front.data;
		front = front.next;
		if(front.next == null) {
			rear = null;
		}
		length--;
		return result;
	}
	
	public void print() {
		if(isEmpty()) {
			return;
		}
		Node current = front;
		while(current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.println("null");
	}
}
