# 4. 스택과 큐

## 개요

스택(Stack)은 후입선출(LIFO: Last In First Out) 특성을 가진 자료구조입니다. 가장 먼저 들어간 데이터가 가장 먼저 추출됩니다.

큐(Queue)는 선입선출(FIFO: First In First Out) 특성을 가진 자료구조입니다. 가장 먼저 들어간 데이터가 가장 나중에 추출됩니다.

<br/>

---

## 배열로 구현한 스택과 큐

배열로 스택과 큐를 구현할 경우, 데이터의 재배열이 요구될 수 있습니다.

<br/>

```Java
package DataStructure.StacksAndQueue.WithArray;

class Stack {
    int maxSize;
    int[] stackArray;
    int top;

    Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    boolean isFull() {
        return (top == maxSize - 1);
    }

    boolean isEmpty() {
        return (top == -1);
    }

    void push(int value) {
        if (isFull()) {
            System.out.println("오류: 최대 용량에 도달하였습니다.");
            return;
        }
        stackArray[++top] = value;
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("오류: 배열이 비어 있습니다.");
            return -1;
        }
        return stackArray[top--];
    }

    void display() {
        if (isEmpty()) return;
        System.out.print("Stack: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + " -> ");
        }
        System.out.println();
    }
}
```

### Stack 클래스의 생성자
```Java
Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }
```

사용자에게 size만 받고, size에 맞는 배열을 생성합니다. top은 데이터가 있는 노드의 마지막 번호입니다.

<br/>

### Stack 클래스의 push() 메소드
```Java
void push(int value) {
        if (isFull()) {
            System.out.println("오류: 최대 용량에 도달하였습니다.");
            return;
        }
        stackArray[++top] = value;
    }
```

(1) 배열의 최대 크기에 도달하였다면, 오류 메시지를 출력하고 반환합니다.

(2) 입력한 값을 데이터가 있는 칸의 다음 위치에 값을 저장합니다. 

<br/>

### Stack 클래스의 pop() 메소드
```Java
int pop() {
        if (isEmpty()) {
            System.out.println("오류: 배열이 비어 있습니다.");
            return -1;
        }
        return stackArray[top--];
    }
```

(1) 배열이 비어있는 경우, 오류 메시지를 출력하고 -1을 반환합니다.

(2) 데이터가 있는 마지막 칸의 데이터를 반환하고, 마지막 칸(top)을 이전 칸(top-1)으로 정의합니다.

<br/>

```Java
package DataStructure.StacksAndQueue.WithArray;

class Queue {
    private int[] array;
    private int front;
    private int rear;
    private int capacity;

    Queue(int size) {
        this.capacity = size;
        this.array = new int[capacity];
        this.front = 0;
        this.rear = -1;
    }

    boolean isEmpty() {
        return rear == -1;
    }

    boolean isFull() {
        return rear == capacity - 1;
    }

    void push(int value) {
        if (isFull()) {
            System.out.println("오류: 최대 용량에 도달하였습니다.");
            return;
        }
        array[++rear] = value;
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("오류: 배열이 비어 있습니다.");
            return;
        }
        front++;
        if (front == capacity) {
            front = 0;
            rear = -1;
        }
    }

    public void display() {
        if (isEmpty()) return;
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(array[i] + " -> ");
        }
        System.out.println();
    }
}
```

### Queue 클래스의 생성자
```Java
Queue(int size) {
        this.capacity = size;
        this.array = new int[capacity];
        this.front = 0;
        this.rear = -1;
    }
```

stack과 비슷하지만, 가장 1번째 값과 마지막 값에 대한 변수를 지정합니다.

<br/>

### Queue 클래스의 push() 메소드
```Java
void push(int value) {
        if (isFull()) {
            System.out.println("오류: 최대 용량에 도달하였습니다.");
            return;
        }
        array[++rear] = value;
    }
```

(1)  배열의 최대 크기에 도달하였다면, 오류 메시지를 출력하고 반환합니다.

(2) 입력한 값을 마지막 칸의 다음 위치에 저장합니다.

<br/>

### Queue 클래스의 pop() 메소드
```Java
void pop() {
        if (isEmpty()) {
            System.out.println("오류: 배열이 비어 있습니다.");
            return;
        }
        front++;
        if (front == capacity) {
            front = 0;
            rear = -1;
        }
    }
```

(1) 배열이 비어있는 경우, 오류 메시지를 출력하고 -1을 반환합니다.

(2) 1번째 값의 위치를 조율합니다.

(3) 1번째 값의 위치가 최대 용량에 도착한 경우, 배열의 위치를 초기화합니다.

<br/>

### main() 메소드

실행 클래스 예시입니다.

```Java
package DataStructure.StacksAndQueue.WithArray;


public class Main {
    public static void main(String[] args) {
        Stack st = new Stack(5);
        Queue qu = new Queue(5);

        for (int i=0; i<5; i++) {
            st.push(i + 1);
            qu.push(i + 1);
        }
        st.display();
        qu.display();
        System.out.println("==========pop 이후==========");
        st.pop();
        st.pop();
        qu.pop();
        qu.pop();
        st.display();
        qu.display();
    }
}
```

배열로 구현한 스택과 큐는 모두 O(1)의 시간 복잡도를 가집니다. 데이터를 리스트에 추가하는 것과 삭제하는 것에 연산이 크게 요구되지 않기 때문입니다.

<br/>

---

## 연결 리스트로 구현한 스택과 큐

연결 리스트를 이해했다면, 연결 리스트를 통해 스택과 큐를 구현하는 것은 간단합니다. 다음은 단순 연결 리스트를 통해 스택과 큐를 구현할 때, pop() 메소드가 어떤 노드를 삭제하는지에 따라서 스택과 큐로 나뉩니다.

<br/>

### StackAndQueue 클래스

```Java
package DataStructure.StacksAndQueue.WithLinkedList;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```
```Java
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
```

스택과 큐의 공통되는 부분이며, 추상 클래스로 구현하여 상속을 통해서만 생성될 수 있습니다.

```Java
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
```

push() 메소드는, 리스트의 첫 번째 노드에 데이터를 추가합니다.

```Java
abstract void pop();
````

pop() 메소드는, 자식 클래스가 오버라이딩하여 각자의 정의대로 데이터를 추출합니다.

<br/>

### Stack 클래스의 pop() 메소드 오버라이딩

```Java
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
```

스택은 후입선출 방식을 채택하기 때문에, pop() 메소드는 첫 번째 노드를 추출합니다.

<br/>

### Queue 클래스의 pop() 메소드 오버라이딩

```Java
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
```


큐는 선입선출 방식을 채택하기 때문에, pop() 메소드는 마지막 노드를 추출합니다. 

<br/>

### main() 메소드

실행 클래스 예시입니다.

```Java
package DataStructure.StacksAndQueue.WithLinkedList;

public class Main {
    public static void main(String[] args) {
        Stack st = new Stack();
        Queue qu = new Queue();

        for (int i=0; i<5; i++) {
            st.push(i + 1);
            qu.push(i + 1);
        }
        System.out.print("Stack: ");
        st.display();
        System.out.print("Queue: ");
        qu.display();
        System.out.println("==========pop 이후==========");
        st.pop();
        st.pop();
        qu.pop();
        qu.pop();
        System.out.print("Stack: ");
        st.display();
        System.out.print("Queue: ");
        qu.display();
    }
}
```

단순 연결 리스트 방식을 채택하기 때문에 시간 복잡도는 마찬가지로 O(n)입니다.
