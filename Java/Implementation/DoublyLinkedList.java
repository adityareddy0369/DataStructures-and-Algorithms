public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    private class Node {
        private int data;
        private Node next;
        private Node previous;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertEnd(3);
        list.insertEnd(4);
        list.displayForward();
        System.out.println();
        list.dispplayBackward();
        list.deleteFirst();
        list.deleteEnd();
        System.out.println();
        list.displayForward();
        System.out.println();
        list.dispplayBackward();
    }

    private void deleteEnd() {
        if(isEmpty()) {
            return;
        }
        Node temp = tail;
        if(head == tail) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        length--;
    }

    private void deleteFirst() {
        if(isEmpty()) {
            return;
        }
        Node temp = head;
        if(head == tail) {
            tail = null;
        } else {
            temp.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
    }

    private void dispplayBackward() {
        Node current = tail;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.previous;
        }
    }

    private void displayForward() {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    private void insertEnd(int data) {
        Node newNode = new Node(data);
        if(isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.previous = tail;
        tail = newNode;
        length++;
    }

    private void insertFirst(int data) {
        Node newNode = new Node(data);
        if(isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
            newNode.next = head;
        }
        head = newNode;
        length++;
    }

    private boolean isEmpty() {
        return length == 0;
    }
    private int length() {
        return length;
    }


}
