package DataStructure.StacksAndQueue.WithLinkedList;

import DataStructure.StacksAndQueue.WithLinkedList.Node;

public abstract class StackAndQueue {
    Node head;

    // 생성자
    StackAndQueue() {
        this.head = null;
    }

    // 새로운 노드를 리스트의 시작 부분에 추가하는 메소드
    void push(int data) {
        Node newNode = new Node(data);
        // 리스트가 비어있는 경우
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
        return;
    }

    // 특정 값이 있는 노드를 삭제하는 메소드
    abstract void pop();

    // 현재 리스트의 내용을 모두 표시하는 메소드
    void display() {
        Node current = head;
        while (current != null) {
            // 현재 값(data) 출력 후 다음 노드로 이동.
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print("\n");
    }
}
