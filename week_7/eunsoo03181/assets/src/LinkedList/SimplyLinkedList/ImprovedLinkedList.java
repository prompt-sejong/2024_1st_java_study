package DataStructure.LinkedList.SimplyLinkedList;
import java.util.Scanner;

// LinkedList 클래스 상속
public class ImprovedLinkedList extends LinkedList {
    // 특정 위치에 데이터를 추가하는 메소드
    void insert(int data, int n) {
        if (n <= 0) {
            System.out.println("오류: 유효하지 않은 범위입니다.");
            return;
        }
        // 첫 번째 노드에 추가하는 경우
        if (n == 1 || head == null) {
            Node newNode = new Node(data, head);
            head = newNode;
            return;
        }

        Node current = head;

        // 해당 노드로 이동
        for (int i=1; i<n-1; i++) {
            // 입력 값이 리스트의 범위를 초과한 경우
            if (current == null) {
                System.out.println("오류: 입력한 값이 범위를 초과하였습니다.");
                return;
            }
            current = current.next;
        }
        // 마지막 노드였을 경우
        if (current == null) {
            System.out.println("오류: 입력한 값이 범위를 초과하였습니다.");
            return;
        }
        // current는 newNode의 전에 있는 노드.
        // newNode는 current 노드의 다음 노드를 참조.
        Node newNode = new Node(data, current.next);
        // current 노드의 다음 노드는 newNode를 참조.
        current.next = newNode;
        // current -> newNode -> current.next (->는 참조를 의미)
    }

    // 특정 위치의 노드를 삭제하는 메소드.
    @Override
    void remove(int data) {
        Scanner sc = new Scanner(System.in);
        System.out.println("삭제할 것을 구체적으로 명시해주세요.\n1. 값 (기본)\n2. 위치");
        int mode = sc.nextInt();
        if (mode == 1) {
            super.remove(data);
        }
        else {
            if (head == null) {
                System.out.println(("리스트가 비어있습니다."));
                return;
            }
            // 1번째 노드 삭제
            if (data == 1) {
                head = head.next;
                return;
            }
            Node current = head;
            Node prev = null; // 이전 노드 저장
            int cnt = 0;

            // 노드가 종료되고, 입력값이 cnt와 일치할 때까지 반복
            while (current != null && cnt != data) {
                prev = current;
                current = current.next;
                cnt++;
            }

            if (current == null) {
                System.out.println("해당 위치에 노드가 없습니다.");
                return;
            }

            // 이전 노드가 현재 노드의 다음 노드를 가리키도록 변경
            prev.next = current.next;
        }
    }

    // 입력한 값이 몇 번째 칸에 있는지를 반환하는 메소드
    int search(int data) {
        Node current = head;
        int position = 1;

        while (current != null) {
            if (current.data == data) {
                return position;
            }
            current = current.next;
            position++;
        }
        // 값을 찾지 못한 경우, -1을 반환
        return -1;
    }
}
