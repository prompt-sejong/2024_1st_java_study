# 3. 연결 리스트

## 개요

순서를 가지고 원소(노드)를 정렬한 것을 리스트(List)라고 부릅니다. 

---

## 연결 리스트

연결 리스트(Linked List)는 각 원소에 다음으로 가리킬 원소의 위치를 포함시킨 리스트를 의미합니다. 예를 들어, 학생을 학번대로 정렬하였을 때, 3번 학생의 정보에 4번 학생의 정보에 대한 위치를 명시하는 것을 우리는 연결 리스트라고 할 수 있습니다.

C에서는 연결 리스트를 주로 구조체(Struct)와 포인터(Pointer)를 통해 구현합니다.

---

## 단순 연결 리스트

단순 연결 리스트(Simply Linked List)는 각 노드가 앞에서 뒤로의 연결만을 가진 단방향성 연결 리스트입니다. 각 노드는 후행 노드를 가리키므로, 앞에서 뒤로의 접근은 가능하지만, 반대 방향으로의 접근은 불가능합니다.

<br/>

### Node 클래스

```Java
package DataStructure.LinkedList.SimplyLinkedList;

class Node {
    int data;
    Node next; // 객체 참조

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

단순 연결 리스트를 구현하기 위해 사용한, Node 클래스입니다. Node에는 data와 next라는 필드가 있으며, data는 해당 Node의 값을 정수형으로 저장합니다.

next는 Node 형태로 저장하여, 다음 객체의 주솟값을 저장합니다. Java에서는 C와 달리 포인터(Pointer)를 제공하지 않기에, 다음 값에 접근하기 위해 참조(Reference)를 사용합니다.

### SimplyLinkedList 클래스

```Java
package DataStructure.LinkedList.SimplyLinkedList;

class LinkedList {
    Node head;

    // 생성자
    LinkedList() {
        this.head = null;
    }

    // 새로운 노드를 리스트의 끝에 추가하는 메소드
    void append(int data) {
        Node newNode = new Node(data);
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
```

위의 코드에서는 append()와 remove(), 그리고 display()를 지원합니다.

<br/>

### append() 메소드
```Java
void append(int data) {
        Node newNode = new Node(data);
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
```

append() 메소드는 입력한 값을 리스트의 마지막에 추가하는 메소드입니다. 작동 방식은 다음과 같습니다.

(1) 입력한 값을 newNode라는 객체의 data에 저장합니다. newNode는 append() 메소드에서만 쓰이며, 누구도 참조하지 않습니다(next = null).

(2) 1번째 노드(head)가 비어있는 경우, 1번째 노드에 newNode를 정의하고 메소드를 반환합니다.

(3) 비어있는 리스트가 아닌 경우, current라는 객체에 현재 리스트의 1번째 노드의 값(data)과 그 노드가 참조하는 객체(next)를 저장합니다. 

(4) current의 마지막 노드가 등장할 때까지 1번째 노드에서 마지막 노드까지 이동합니다. ‘current.next’도 Node 타입이기 때문에, current에 정의할 수 있습니다.

(5) 마지막 노드에 도착한 경우, newNode를 마지막 노드가 참조하게 합니다.

append() 메소드는 n개의 노드를 탐색해야하기 때문에, 시간 복잡도는 O(n)입니다.

<br/>

### remove() 메소드
```Java
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
```

remove() 메소드는 입력한 값을 리스트 내에 찾아 삭제하는 메소드입니다. 작동 방식은 다음과 같습니다.

(1) 비어있는 리스트인 경우, 메소드를 반환합니다.

(2) 연결 리스트의 1번째 노드(head)의 데이터(head.data)가 사용자가 입력한 값(data)과 일치할 경우, 1번째 노드를, 1번째 노드가 참조하는 노드(head.next)로 변경합니다. 둘은 같은 자료형(Node)입니다.

(3) 1번째 노드가 찾는 노드가 아닌 경우, current에 1번째 노드를 정의합니다. 

(4) 현재 노드(current)가 가리키는 객체(current.next)가 비어있을 때까지 또는 원하는 값을 찾을 때까지 시행을 반복합니다.

(4-1) 현재 노드의 다음 노드의 값(current.next.data)이 사용자가 입력한 값(data)와 같은 경우, 현재 노드의 다음 노드를 다다음 노드(current.next.next)로 변경합니다.

(4-2) ‘4-1’을 만족하지 않은 경우, 다음 노드로 넘어갑니다. 

(5) 삭제되는 노드는 누구도 참조하고 있지 않고, 자신도 누구도 참조하지 않기 때문에, 가비지 컬렉터(garbage collector)에서 감지하여 메모리를 해제합니다.

remove() 메소드도 마찬가지로 n개의 노드를 탐색해야하기 때문에, 시간 복잡도는 O(n)입니다.

<br/>

### display() 메소드
```Java
void display() {
        Node current = head;
        while (current != null) {
            // 현재 값(data) 출력 후 다음 노드로 이동.
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print("\n");
    }
```

display() 메소드는 현재 리스트를 출력하는 메소드입니다. 작동 방식은 다음과 같습니다.

(1) current에 1번째 노드(head)를 저장합니다.

(2) 현재 노드(current)가 마지막 노드로 넘어갈 때까지 시행을 반복합니다.

(2-1) 현재 노드의 값(current.data)을 출력합니다.

(2-2) 다음 노드(current.next)로 넘어갑니다.

display() 메소드 또한, n개의 노드를 탐색 후 값을 출력하기 때문에, 시간 복잡도는 O(n)입니다.

<br/>

### 추가 기능

상속(Inheritance)를 통해, 개선된 SimplyLinkedList를 구현하였습니다.

```Java
package DataStructure.LinkedList.SimplyLinkedList;
import java.util.Scanner;

// LinkedList 클래스 상속
public class ImprovedLinkedList extends LinkedList {
    // 특정 위치에 데이터를 추가하는 메소드
    void insert(int data, int n) {
        // 자리를 보정합니다.
        n = n - 1;
        // 첫 번째 노드에 추가하는 경우
        Node newNode = new Node(data);
        if (n == 0) {
            // 추가할 노드가 1번째 노드 참조
            newNode.next = head;
            // 추가한 노드를 1번째 노드로 변경
            head = newNode;
            return;
        }
        Node current = head;
        for (int i = 0; i < n - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("오류: 유효하지 않은 범위입니다.");
            return;
        }
        // 새로운 노드가 현재 노드의 다음을 참조
        newNode.next = current.next;
        // 현재 노드가 새로운 노드를 참조하게 변경
        current.next = newNode;
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
```

<br/>

### insert() 메소드
```Java
void insert(int data, int n) {
        // 자리를 보정합니다.
        n = n - 1;
        // 첫 번째 노드에 추가하는 경우
        Node newNode = new Node(data);
        if (n == 0) {
            // 추가할 노드가 1번째 노드 참조
            newNode.next = head;
            // 추가한 노드를 1번째 노드로 변경
            head = newNode;
            return;
        }
        Node current = head;
        for (int i = 0; i < n - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("오류: 유효하지 않은 범위입니다.");
            return;
        }
        // 새로운 노드가 현재 노드의 다음을 참조
        newNode.next = current.next;
        // 현재 노드가 새로운 노드를 참조하게 변경
        current.next = newNode;
    }
```

insert() 메소드는 매개변수로, data와 n을 받으며, data는 입력할 값을, int는 입력할 자리를 받습니다. 작동 방식은 다음과 같습니다.

(1) 코드에서 1번째 노드는 실제로는 0번째로 가정하였으므로, n의 값을 보정합니다.

(2) n이 0인 경우 (기존 n의 값은 1) 새로운 노드(newNode)가 1번째 노드(head)를 참조하게 합니다.

(3) 1번째 노드를 새로운 노드로 지정합니다.

(3) 1번째 노드를 현재 노드(current)로 지정하고, n이 0이 아닌 경우, n의 값을 증가시키며, 다음 노드로 계속 이동합니다. 이때, 현재 노드가 더 이상 넘길 노드가 없는 경우에도 반복을 중단합니다.

(4) 현재 노드가 아무것도 가리키지 않을 떄, 오류 메시지를 출력하고 반환합니다.

(5) 새로운 노드가 현재 노드의 다음을 참조하게 하고, 현재 노드가 새로운 노드를 참조하게 변경합니다.

insert() 메소드의 시간 복잡도는 O(n)입니다.

<br/>

### remove() 메소드 오버라이딩
```Java
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
```

기존, remove() 메소드를 재정의(Overriding)하였습니다. 이번에는 특정 값이 아닌 특정 위치의 값을 삭제하는 메소드입니다. 작동 원리는 다음과 같습니다.

(1) 기존 방식과 같이 특정값을 삭제하고 싶은지를 사용자에게 묻고, 사용자가 원할 경우 기존의 방식(super.remove())으로 remove() 메소드를 실행합니다.

(2) 리스트가 비어있는 경우, 비어있다고 알린 후 함수를 반환합니다.

(3) 1번째 노드를 삭제하려고 한다면, 1번째 노드(head)가 가리키는 다음 노드(head.next)를 1번째 노드로 만듭니다.

(4) prev 노드는 이전 노드의 저장을 담당합니다.

(5) 사용자가 원하는 범위가 나오거나, 리스트가 종료될 때까지, 현재 노드를 다음 노드로 옮깁니다.

(6) 현재 노드가 비어있는 경우, 오류 메시지를 출력하고 반환합니다.

(7) 이전 노드가 참조하는 다음 노드(prev.next)를 현재 노드가 참조하는 다음 노드(current.next)로 변경합니다.

오버라이딩된 remove() 메소드 또한, 최악의 경우 모든 노드의 값을 순회해야하므로, 시간 복잡도는 O(n)입니다.

<br/>

### search() 메소드
```Java
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
```

search() 메소드는 입력한 값이 리스트의 어느 위치에 있는지를 반환합니다. 1번째 노드는 0이 아닌 1입니다. 작동 원리는 다음과 같습니다.

(1) 현재 노드(current)를 1번째 노드(head)로 설정하고, 위치에 대한 변수를 1로 초기화합니다.

(2) 현재 노드가 마지막 노드로 넘어갈 때까지 반복하며, 이때 위치 변수 값도 증가합니다. 현재 노드의 값이 사용자가 입력한 값과 같은 경우 위치 변수의 값을 반환합니다.

(3) 값을 찾지 못한 경우 -1을 반환합니다.

search() 메소드의 시간 복잡도는 O(n)입니다.

<br/>

### main() 메소드

실행 클래스 예시입니다.

```Java
package DataStructure.LinkedList.SimplyLinkedList;

public class Main {
    public static void main(String[] args) {
        ImprovedLinkedList ll = new ImprovedLinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.append(6);
        ll.display();
        ll.remove(2);
        ll.display();
        ll.insert(0, 3);
        ll.display();
        System.out.println(ll.search(6));
    }
}
```

모든 메소드의 시간 복잡도가 O(n)이므로, Java에서 구현한 단순 연결 리스트(Simply Linked List)의 시간 복잡도는 O(n)이 되는 것을 알 수 있습니다.

<br/>

---

## 이중 연결 리스트

이중 연결 리스트(Doubly Linked List)란, 각 노드가 앞과 뒤로의 연결을 가진 양방향성 연결 리스트입니다. 각 노드는 전행 노드와 후행 노드를 둘 다 가리키므로, 단순 연결 리스트와 달리 양방향으로 접근이 가능합니다.

<br/>

### Node 클래스

```Java
package DataStructure.LinkedList.DoublyLinkedList;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
```

이중 연결 리스트는 앞뒤 노드를 참조하므로, 두 번의 객체 참조를 하게 됩니다.

```Java
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
```

<br/>

### append() 메소드 작동 방식
```Java
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
```

(1) 새로운 노드(newNode)에 데이터를 입력합니다.

(2) 리스트가 비어있을 경우, 시작 노드(head)와 마지막 노드(tail)를 새로운 노드로 정의합니다.

(3) 2를 만족하지 않는 경우, 마지막 노드가 참조하는 다음 노드를 새로운 노드로 정의합니다.

(3) 새로운 노드의 이전 노드를 기존 마지막 노드를 참조하도록 변경합니다.

(4) 마지막 노드를 새로운 노드로 정의합니다.

append() 메소드의 시간 복잡도는 O(n)입니다.

<br/>

### insert() 메소드 작동 방식
```Java
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
```

(1) 프로그램 내에서의 자릿수와 사용자의 자릿수가 다르므로, 보정을 해주고 새로운 노드(newNode)에 데이터를 입력합니다.

(2) 1번째 노드에 입력하는 경우, 새로운 노드가 시작 노드(head)를 참조하게 합니다.

(2-1) 기존 1번째 노드(head)가 참조하는 이전 노드를 새로운 노드로 정의합니다.

(2-2) 1번째 노드를 새로운 노드로 정의하고 반환합니다.

(3) 2를 만족하지 않는 경우 현재 노드(current)를 정의하고, 시작 노드부터 마지막 노드에 도착할 때까지 노드를 넘깁니다.

(3-1) 지정한 범위가 유효하지 않은 경우 오류 메시지를 출력합니다.

(3-2) 현재 노드의 다음 노드로 새로운 노드를 참조하게 합니다.

(3-3) 새로운 노드의 이전 노드로 현재 노드를 참조하게 합니다.

insert() 메소드의 시간 복잡도는 O(n)입니다.

<br/>

### remove() 메소드 작동 방식
```Java
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
```

(1) 입력한 값이 시작 노드(head)에 있을 경우, 시작 노드를 현재 노드로 변경합니다.

(2) 변경한 1번째 노드(head)가 있는 경우, 1번째 노드의 이전 노드가 아무것도 참조하지 않도록 합니다.

(3) 리스트가 비어있을 경우, 마지막 노드(tail)도 제거합니다. 이중 연결 리스트에서 자료가 1개만 있을 경우, 시작 노드와 마지막 노드가 같기 때문입니다.

(4) 입력한 값이 마지막 노드에 있을 경우, 마지막 노드를 이전 노드로 변경합니다.

(5) 변경한 마지막 노드가 다음 노드를 참조하지 않도록 합니다.

(6) 입력한 값이 시작과 끝이 아닌 경우, 이전 노드의 다음 노드를 현재 노드의 다음 노드를 참조하도록 합니다.

(7) 또한, 다음 노드의 이전 노드를 현재 노드의 이전 노드를 참조하도록 합니다.

(8) 만족할 때까지, 현재 노드를 다음 노드로 옮깁니다.

remove() 메소드의 시간 복잡도는 O(n)입니다.

<br/>

### display() 메소드 작동 방식
```Java
void display() {
    Node current = head;
    while (current != null) {
        System.out.print(current.data + " -> ");
        current = current.next;
    }
    System.out.println();
    }
```

단순 연결 리스트와 동일하므로, 생략합니다. 시간 복잡도는 O(n)입니다.

display() 메소드의 시간 복잡도는 O(n)입니다.

<br/>

### main() 메소드

실행 클래스 예시입니다.

```Java
package DataStructure.LinkedList.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.append(0);
        dl.insert(1, 1);
        dl.insert(2, 1);
        dl.insert(3, 1);
        dl.insert(4, 1);
        dl.remove(0);
        dl.display();
    }
}
```

모든 메소드의 시간 복잡도가 O(n)이므로, Java에서 구현한 이중 연결 리스트(Doubly Linked List)의 시간 복잡도는 O(n)이 되는 것을 알 수 있습니다.

<br/>

---

## 원형 연결 리스트

원형 연결 리스트(Circular Linked List)는 마지막(tail) 노드가 시작(head) 노드를 가리키는 연결 리스트입니다. 단순 연결 리스트에서 마지막 노드가 시작 노드를 참조하도록 하여 간단히 구현할 수 있습니다.

<br/>

### Node 클래스

```Java
package DataStructure.LinkedList.CircularLinkedList;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

단순 연결 리스트와 동일한 구조입니다.

```Java
package DataStructure.LinkedList.CircularLinkedList;

public class CircularLinkedList {
    Node head;
    Node tail;

    CircularLinkedList() {
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

    // 노드를 삭제하는 메소드
    void remove(int data) {
        if (head == null) {
            System.out.println("오류: 리스트가 비어 있습니다.");
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
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("오류: 값이 리스트에 없습니다.");
    }

    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("오류: 리스트가 비어 있습니다.");
            return;
        }
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}
```

### append() 메소드 작동 방식
```Java
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
```

(1) 새로운 노드(newNode)에 입력한 값을 저장합니다.

(2) 리스트가 비어있는 경우 1번째 노드(head)와 마지막 노드(tail)에 해당 노드를 저장하고, 자신의 다음 노드를 자신의 노드(head)를 참조하게 합니다.

(3) 마지막 노드의 다음 노드가 새로운 노드를 참조하게 합니다.

(4) 새로운 노드를 마지막 노드로 정의하고, 마지막 노드가 1번째 노드를 참조하게 합니다.

시간 복잡도는 O(n)입니다.

<br/>

### remove() 메소드 작동 방식
```Java
void remove(int data) {
        if (head == null) {
            System.out.println("오류: 리스트가 비어 있습니다.");
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
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("오류: 값이 리스트에 없습니다.");
    }
```

(1) 리스트가 비어있는 경우, 비어있다고 알리고 반환합니다.

(2) 현재 노드(current)를 1번째 노드(head)로 지정하고, 이전 노드(prev)를 선언합니다. 이전 노드는 아무것도 참조하지 않습니다.

(3) 입력한 데이터가 찾는 값이며, 이전 노드가 아무런 값을 참조하지 않을 때, 이전 노드가 현재 노드의 다음을 참조하게 합니다.

(4) 이어서, 현재 노드가 마지막 노드(tail)였을 경우, 이전 노드를 마지막 노드로 변경합니다.

(5) 1번째 노드를 삭제하는 경우, 1번째 노드를 1번째 노드의 다음 노드로 변경합니다.

(6) 마지막 노드가 변경된 1번째 노드를 참조하게 합니다.

(7) 위 실행을 마무리한 경우 메소드를 반환하고, 아닌 경우 이전 노드를 현재 노드로 정의하고, 다음 노드로 넘깁니다. 

(8) 현재 노드가 다시 시작 노드로 돌아올 떄까지 실행(1~7)을 반복합니다. 

시간 복잡도는 O(n)입니다.

<br/>

### display() 메소드 작동 방식
```Java
public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("오류: 리스트가 비어 있습니다.");
            return;
        }
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
```

단순 연결 리스트와 비슷하지만, 다시 현재 노드가 시작 노드로 돌아가면 실행을 종료합니다.

시간 복잡도는 O(n)입니다.

<br/>

### main() 메소드

단순 연결 리스트와 동일하므로, 생략합니다.

모든 메소드의 시간 복잡도가 O(n)이므로, Java에서 구현한 원형 연결 리스트(Circular Linked List)의 시간 복잡도는 O(n)이 되는 것을 알 수 있습니다.

<br/>

---

## 연결 리스트의 장단점

연결 리스트는 배열과 비슷하여, 연결 리스트를 이용에 의문을 가질 수 있지만, 연결 리스트는 배열과는 차별화된 장점을 가지고 있습니다.

<br/>

### 연결 리스트 장점

(1) 데이터의 삽입 및 삭제의 용이성

연결 리스트는 데이터를 삽입하거나 삭제할 때 배열과 달리 자리를 재배열할 필요가 없습니다. 에를 들어, {1, 2, 4, 5}인 배열에서 2와 4 사이에 3을 넣으려면, 2와 4 사이에 3을 넣고, 4와 5를 재배열해야하지만, 연결 리스트의 경우 서로간의 연결만 조율하면 됩니다.

(2) 크기 변경의 가변성

배열은 동적 할당을 하더라도, 처음 지정한 크기를 변경할 수 없습니다. 그러나, 연결 리스트의 경우 크기의 개념이 없으며, 삽입과 삭제가 용이하므로, 공간을 동적으로 할당 및 해제할 수 있습니다.

(3) 메모리 사용의 효율성

배열은 연속된 메모리 공간을 사용하는데, 이는 C에서도 확인할 수 있습니다. 연결 리스트는 각 요소가 다른 메모리 위치에 저장되므로 메모리 공간을 유연하게 활용할 수 있습니다.

<br/>

### 연결 리스트 단점

(1) 느린 속도

특정 위치에 있는 요소에 접근하려면 참조를 통해 순차적으로 접근을 해야합니다. 이는 배열과 달리 임의 접근이 느린 경우가 많습니다. 예를 들어, 배열과 단순 연결 리스트에서 n번째 값에 접근하기 위해서, 배열은 한 번의 연산(시간 복잡도: O(1))만 하면 되지만, 단순 연결 리스트의 경우 n번의 연산(시간 복잡도: O(n))이 요구됩니다.

(2) 메모리 사용의 효율성

각 요소마다 포인터가 필요하므로 연결 리스트는 배열보다 더 많은 메모리를 소비할 수 있습니다.
