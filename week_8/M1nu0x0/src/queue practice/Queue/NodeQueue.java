package Queue;

class Node {
    private int data;
    private Node next = null;

    public Node(int data) {
        this.data = data;
    }

    public int getData() { return this.data; }
    public void setData(int newData) { this.data = newData; }

    public Node getNext() { return this.next; }
    public void setNext(Node node) { this.next = node; }
}

public class NodeQueue {
    private int size = 0;
    private Node head = null;
    private Node tail = null;

    public boolean isEmpty() {
        if (size == 0) { return true; }
        return false;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
    }

    public int dequeue() {
        Node delNode = this.head;
        this.head = this.head.getNext();
        this.size--;
        return delNode.getData();
    }

    public int peek() {
        return this.head.getData();
    }
    
    public int getSize() {
        return this.size;
    }

    public void print() {
        Node cur = this.head;
        while (true) {
            if (cur == null) { break; }
            
            System.out.printf("%d ", cur.getData());
            cur = cur.getNext();
        }
        System.out.println();
    }
}
