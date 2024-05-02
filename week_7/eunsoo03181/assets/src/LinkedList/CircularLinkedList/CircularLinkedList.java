package DataStructure.LinkedList.CircularLinkedList;

public class CircularLinkedList {
    Node head;
    Node tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // 노드를 리스트 끝에 추가하는 메서드
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // 리스트가 비어있을 때는 자기 자신을 가리킴
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // tail의 다음 노드는 head를 가리킴 (원형)
        }
    }

    void remove(int data) {
        if (head == null) {
            System.out.println("리스트가 비어 있습니다.");
            return;
        }

        Node current = head;
        Node prev = null;

        // 리스트를 순회하며 값을 찾음
        do {
            if (current.data == data) {
                // 특정한 값을 찾았을 때
                if (prev != null) {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev; // 마지막 노드일 경우 tail 업데이트
                    }
                } else {
                    // 첫 번째 노드를 삭제할 경우
                    head = head.next;
                    tail.next = head; // tail의 다음 노드는 head를 가리킴 (원형)
                }
                System.out.println(data + "를 삭제했습니다.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println(data + "를 찾을 수 없습니다.");
    }

    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("리스트가 비어 있습니다.");
            return;
        }
        System.out.print("리스트: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}
