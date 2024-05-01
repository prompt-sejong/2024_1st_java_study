package LinkedList;

public class ListNodeStack {
    private int size = 0;
    private ListNode head = null;

    public void push(int data) {
        this.size++;
        ListNode newNode = new ListNode(data);
        newNode.setNext(this.head);
        this.head = newNode;
        return;
    }

    public int pop() {
        this.size--;
        ListNode delNode = this.head;
        this.head = this.head.getNext();
        return delNode.getData();
    }

    public int peek() {
        return this.head.getData();
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public int getSize() {
        return this.size;
    }
}
