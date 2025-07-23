public class SortedLinkedList<T> {

    private Node head;
    
    public SortedLinkedList(){
        head = null;
    }

    public boolean isEmpty(){
        return this.isEmpty();
    }

    public void insert(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            return;
        }
        Node current = head;
        Node previous = null;

        if(newNode.data < current.data){
            newNode.next = current;
            head = newNode;
            return;
        }
        while(current != null){
            if(newNode.data <= current.data){
                previous.next = newNode;
                newNode.next = current;
                return;
            } else if(newNode.data > current.data && current.next == null){
                current.next = newNode;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public void display(){

        if(head == null){
            System.out.println("<<empty list>>");
        }
        Node current = head;
        System.out.print("head->");
        while (current != null) {
            System.out.print(" "+current.data);
            current = current.next;
        }
        System.out.print("<-tail");
        System.out.println();
    }
}
