package DA2;

public class UnorderedList {

    private class Node {
        int data;
        Node next;

        Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public UnorderedList() {
        head = null;
        size = 0;
    }

    public void insertFront(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void remove(int value) {
        if(head == null){
            return;
        } 
        
        if(head.data == value){
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        while(current.next != null && current.next.data != value){
            current = current.next;
        }

        if(current.next != null){
            current.next = current.next.next;
            size--;
        }
    }

    public boolean search(int value) {
        Node current = head;
        while(current != null){
            if(current.data == value){
                return true;
            }
            //Next node
            current = current.next;
        }
        return false;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data+" -> ");
            current = current.next;
        }
        System.out.print("null");
    }

    public int size() {
        return size;
    }
}