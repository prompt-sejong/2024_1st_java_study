package LinkedList;

public class ListNode {
    // 객체 생성 시 둘 다 알아서 초기화 되긴 함
    private int data;
    private ListNode next;

    public ListNode() {
        this.next = null;
    }

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    // getter와 setter 구현해봄
    public int getData() {
        return this.data;
    }

    public void setData(int newData) {
        this.data = newData;
    }

    public ListNode getNext() {
        return this.next;
    }

    public void setNext(ListNode node) {
        this.next = node;
    }
}
