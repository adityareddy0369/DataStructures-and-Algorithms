public class SinglyLinkedList {

	private Node head;

	private static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		public int getNode() {
			return data;
		}

		public void setNode(int data) {
			this.data = data;
		}
	}

	public void display() {
		Node current = head;
		while(current != null) {
			System.out.print(current.data + "->");
			current = current.next;
		}
		System.out.println("null");
	}
	
	public int findLength() {
		int count = 0;
		Node current = head;
		while(current != null) {
	current = current.next;
			count++;
		}
		return count;
		
	}
	
	private void insertFirst(int i) {
		Node firstNode = new Node(i);
		firstNode.next = head;
		head = firstNode;
	}
	
	public void insertEnd(int i) {
		Node lastNode = new Node(i);
		if(head == null) {
			head = lastNode;
			return;
		}
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		
		current.next = lastNode;
	}
	
	public void insert(int position, int value){
		Node newNode = new Node(value);
		if(position == 1) {
			newNode.next = head;
			head = newNode;
		} else {
			int count = 1;
			Node  previous = head;
			while(count < position - 1) {
				previous = previous.next;
				count++;
			}
			Node next = previous.next;
			previous.next = newNode;
			newNode.next = next;
		}
	}
	
	public Node deleteFirst() {
		if(head == null) {
			return null;
		} else {
			Node temp = head;
			head = head.next;
			temp.next = null;
			return temp;
		}
	}
	
	public Node deleteLast() {
		if(head == null || head.next == null) {
			return head;
		} else {
			Node current = head;
			Node previous = null;
			while(current.next != null) {
				previous = current;
				current = current.next;
			}
			previous.next = null;
			return current;
		}
		
	}
	
	public Node delete(int position) {
		if(position == 1) {
			Node temp = head;
			head.next = null;
			head = head.next;
			return temp;
		} else {
			int count = 1;
			Node previous = head;
			while(count < position -1) {
				previous = previous.next;
				count++;
			}
			Node current = previous.next;
			previous.next = current.next;
			current.next = null;
			return current;
		}
	}
	
	public boolean find(int searchKey) {
		if(head == null) {
			return false;
		}
		Node current = head;
		while(current != null) {
			if(current.data == searchKey) {
				return true;
			} 
			 current = current.next;
		}
		return false;
		
	}
	
 	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		
		list.head.next = second;
		second.next = third;
		third.next = fourth;
		
		list.display();
		System.out.println("Length: " + list.findLength());
		list.insertFirst(0);
		list.display();
		list.insertEnd(5);
		list.display();
		list.insert(3, 2);
		list.display();
		list.deleteFirst();
		list.display();
		list.deleteLast();
		list.display();
		list.delete(3);
		list.display();
		if(list.find(4)) {
			System.out.println("Search key found");
		} else {
			System.out.println("search key not found");
		}
		
	}

}
