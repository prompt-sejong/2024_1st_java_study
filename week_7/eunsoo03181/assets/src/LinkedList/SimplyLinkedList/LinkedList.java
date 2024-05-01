package DataStructure.LinkedList.SimplyLinkedList;

class LinkedList {
    Node head;

    // 생성자
    LinkedList() {
        this.head = null;
    }

    // 새로운 노드를 리스트의 끝에 추가하는 메소드
    void append(int data) {
        Node newNode = new Node(data, null);
        // 리스트가 비어있는 경우
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head; // 1번째 노드 저장

        // current의 마지막 노드가 등장할 때까지 1번째 노드에서 끝까지 이동
        while (current.next != null) {
            current = current.next;
        }
        // 마지막 노드가 새로운 노드의 주소를 참조하게 함.
        current.next = newNode;
    }

    // 특정 값이 있는 노드를 삭제하는 메소드
    void remove(int data) {
        if (head == null) return; // 이미 리스트가 비어있으므로, 종료

        // 1번째 값일 경우
        if (head.data == data) {
            // 연결 리스트의 head 노드를 다음 노드인 head.next로 변경
            head = head.next;
            // 기존의 head 노드는 그 누구도 참조하지 않기 때문에, 가비지 컬렉터에서 메모리 해제
            return;
        }

        Node current = head;

        // 마지막 노드까지 반복
        while (current.next != null) {
            // 현재 노드의 다음 값(data)이 삭제하려는 값인 경우
            if (current.next.data == data) {
                // 현재 노드의 다음 노드를 다다음 노드로 변경
                current.next = current.next.next;
                return;
            }

            // 찾는 값이 아닌 경우 다음 노드로 넘어감.
            current = current.next;
        }
    }

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