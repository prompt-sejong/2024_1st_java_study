package DataStructure.StacksAndQueue.WithLinkedList;

public class Stack extends StackAndQueue {

    // 1번째 노드를 삭제하는 메소드
    @Override
    void pop() {
        if (head == null) return;
        head = head.next;
        return;
    }
}
