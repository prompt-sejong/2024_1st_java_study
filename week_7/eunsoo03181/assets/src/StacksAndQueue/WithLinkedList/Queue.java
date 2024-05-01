package DataStructure.StacksAndQueue.WithLinkedList;

public class Queue extends StackAndQueue {

    // 마지막 노드를 삭제하는 메소드
    @Override
    void pop() {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        Node prev = null;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
    }
}
