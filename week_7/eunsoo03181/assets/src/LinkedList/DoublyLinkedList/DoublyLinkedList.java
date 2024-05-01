package DataStructure.LinkedList.DoublyLinkedList;

public class DoublyLinkedList {
    Node head;
    Node tail;

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // 마지막 자리에 데이터 추가 메소드
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // n번째 자리에 데이터 삽입하는 메소드
    void insert(int data, int n) {
        // n의 값을 보정합니다.
        n = n-1;
        Node newNode = new Node(data);
        // 1번째 노드에 입력하는 경우
        if (n==0) {
            // newNode가 참조하는 다음 노드를 기존 1번째 노드로 변경
            newNode.next = head;
            // 1번째 노드가 참조하는 전 노드를 newNode로 지정
            head.prev = newNode;
            // 1번째 노드를 newNode로 지정
            head = newNode;
            return;
        }
        Node current = head;
        for (int i=0; i<n-1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("오류: 유효하지 않은 범위입니다.");
            return;
        }
        // 새로운 노드의 다음 노드가 현재 노드의 다음 노드를 참조하게 변경
        newNode.next = current.next;
        // 현재 노드가 마지막 노드가 아닌 경우, 마지막 노드가 참조하는 노드의 이전을 newNode가 참조하게 변경.
        if (current.next != null) {
            current.next.prev = newNode;
        }
        else {
            tail = newNode; //current가 마지막 노드인 경우 tail을 업데이트
        }
        // 현재 노드가 다음 노드로 newNode를 참조
        current.next = newNode;
        // newNode가 이전 노드로 현재 노드를 참조
        newNode.prev = current;
    }

    void display() {
    Node current = head;
    while (current != null) {
        System.out.print(current.data + " -> ");
        current = current.next;
    }
    System.out.println();
    }

    void remove(int data) {
        Node current = head;

        // 헤드 노드부터 시작하여 값이 일치하는 노드를 찾음
        while (current != null) {
            if (current.data == data) {
                if (current == head) {
                    // 현재 노드를 1번째 노드로 변경
                    head = current.next;
                    if (head != null) {
                        // head가 이전 노드를 참조하지 않도록 변경
                        head.prev = null;
                    }
                    // 리스트가 비어있는 경우, 마지막 노드도 제거
                    if (head == null) {
                        tail = null;
                    }
                }
                else if (current == tail) {
                    tail = current.prev; // tail을 이전 노드로 변경
                    tail.next = null; // 변경된 마지막 노드가 다음 노드를 참조하지 않도록 변경
                } else {
                    // 시작과 끝이 아닌 경우
                    current.prev.next = current.next; // 이전 노드의 다음 노드를 현재 노드의 다음 노드를 참조하도록 설정
                    current.next.prev = current.prev; // 다음 노드의 이전 노드를 현재 노드의 이전 노드를 참조하도록 설정
                }
                return;
            }
            current = current.next;
        }
    }
}
