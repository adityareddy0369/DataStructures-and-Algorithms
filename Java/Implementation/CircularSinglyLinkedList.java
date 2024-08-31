public class CircularSinglyLinkedList {

    Node last;
    int length;

    private class Node {
        int data;
        Node next;

        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private boolean isEmpty() {
        return length == 0;
    }

    private int length() {
        return length;
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        list.createList();
        list.display();
        list.insertFirst(0);
        list.insertLast(5);
        list.display();
        list.removeFirst();
        list.removeLast();
        list.display();
    }

    private void removeLast() {
        if(isEmpty()) {
            return;
        }
        if(last.next == last) {
            last = null;
        } else {
            Node current = last;
            while(current.next != last) {
                current = current.next;
            }
            current.next = last.next;
            last = current;
        }
        length--;
    }

    private void removeFirst() {
        if(isEmpty()) {
            return;
        }
        Node firstNode = last.next;
        if(last.next == last) {
            last = null;
        } else {
            last.next = firstNode.next;
        }
        firstNode.next = null;
        length--;
    }

    private void insertLast(int data) {
        Node newNode = new Node(data);
        if(isEmpty()) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    private void insertFirst(int data) {
        Node newNode = new Node(data);
        if(isEmpty()) {
            last = newNode;
        } else {
            newNode.next = last.next;
        }
        last.next = newNode;
        length++;
    }

    private void display() {
        if(isEmpty()) {
            return;
        }
        Node temp = last.next;
        while(temp != last) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
        System.out.println("last: " + last.data);
    }

    private void createList() {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        last = fourth;
        length = 4;
    }
}
