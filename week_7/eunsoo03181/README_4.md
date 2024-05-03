# 4. 스택과 큐

## 개요

스택(Stack)은 후입선출(LIFO: Last In First Out) 특성을 가진 자료구조입니다. 가장 먼저 들어간 데이터가 가장 먼저 추출됩니다.

큐(Queue)는 선입선출(FIFO: First In First Out) 특성을 가진 자료구조입니다. 가장 먼저 들어간 데이터가 가장 나중에 추출됩니다.

<br/>

---

## 배열로 구현한 스택과 큐

배열로 스택과 큐를 구현할 경우, 데이터의 재배열이 요구될 수 있습니다.

<br/>

https://github.com/eunsoo03181/2024_1st_java_study/blob/175e19a5bc7e5c8bb73db0da16122f36d6afbbdd/week_7/eunsoo03181/assets/src/StacksAndQueue/WithArray/Stack.java#L1-L46

### Stack 클래스의 생성자

사용자에게 size만 받고, size에 맞는 배열을 생성합니다. top은 데이터가 있는 노드의 마지막 번호입니다.

<br/>

### Stack 클래스의 push() 메소드

(1) 배열의 최대 크기에 도달하였다면, 오류 메시지를 출력하고 반환합니다.

(2) 입력한 값을 데이터가 있는 칸의 다음 위치에 값을 저장합니다. 

<br/>

### Stack 클래스의 pop() 메소드

(1) 배열이 비어있는 경우, 오류 메시지를 출력하고 -1을 반환합니다.

(2) 데이터가 있는 마지막 칸의 데이터를 반환하고, 마지막 칸(top)을 이전 칸(top-1)으로 정의합니다.

<br/>

https://github.com/eunsoo03181/2024_1st_java_study/blob/175e19a5bc7e5c8bb73db0da16122f36d6afbbdd/week_7/eunsoo03181/assets/src/StacksAndQueue/WithArray/Queue.java#L1-L52

### Queue 클래스의 생성자

stack과 비슷하지만, 가장 1번째 값과 마지막 값에 대한 변수를 지정합니다.

<br/>

### Queue 클래스의 push() 메소드

(1)  배열의 최대 크기에 도달하였다면, 오류 메시지를 출력하고 반환합니다.

(2) 입력한 값을 마지막 칸의 다음 위치에 저장합니다.

<br/>

### Queue 클래스의 pop() 메소드

(1) 배열이 비어있는 경우, 오류 메시지를 출력하고 -1을 반환합니다.

(2) 1번째 값의 위치를 조율합니다.

(3) 1번째 값의 위치가 최대 용량에 도착한 경우, 배열의 위치를 초기화합니다.

<br/>

### main() 메소드

실행 클래스 예시입니다.

https://github.com/eunsoo03181/2024_1st_java_study/blob/175e19a5bc7e5c8bb73db0da16122f36d6afbbdd/week_7/eunsoo03181/assets/src/StacksAndQueue/WithArray/Main.java#L1-L23

배열로 구현한 스택과 큐는 모두 O(1)의 시간 복잡도를 가집니다. 데이터를 리스트에 추가하는 것과 삭제하는 것에 연산이 크게 요구되지 않기 때문입니다.

<br/>

---

## 연결 리스트로 구현한 스택과 큐

연결 리스트를 이해했다면, 연결 리스트를 통해 스택과 큐를 구현하는 것은 간단합니다. 다음은 단순 연결 리스트를 통해 스택과 큐를 구현할 때, pop() 메소드가 어떤 노드를 삭제하는지에 따라서 스택과 큐로 나뉩니다.

<br/>

### StackAndQueue 클래스

https://github.com/eunsoo03181/2024_1st_java_study/blob/175e19a5bc7e5c8bb73db0da16122f36d6afbbdd/week_7/eunsoo03181/assets/src/StacksAndQueue/WithLinkedList/Node.java#L1-L11
https://github.com/eunsoo03181/2024_1st_java_study/blob/175e19a5bc7e5c8bb73db0da16122f36d6afbbdd/week_7/eunsoo03181/assets/src/StacksAndQueue/WithLinkedList/StackAndQueue.java#L1-L40

스택과 큐의 공통되는 부분이며, 추상 클래스로 구현하여 상속을 통해서만 생성될 수 있습니다.

push() 메소드는, 리스트의 첫 번째 노드에 데이터를 추가합니다.

pop() 메소드는, 자식 클래스가 오버라이딩하여 각자의 정의대로 데이터를 추출합니다.

<br/>

### Stack 클래스의 pop() 메소드 오버라이딩

https://github.com/eunsoo03181/2024_1st_java_study/blob/175e19a5bc7e5c8bb73db0da16122f36d6afbbdd/week_7/eunsoo03181/assets/src/StacksAndQueue/WithLinkedList/Stack.java#L1-L12

스택은 후입선출 방식을 채택하기 때문에, pop() 메소드는 첫 번째 노드를 추출합니다.

<br/>

### Queue 클래스의 pop() 메소드 오버라이딩

https://github.com/eunsoo03181/2024_1st_java_study/blob/175e19a5bc7e5c8bb73db0da16122f36d6afbbdd/week_7/eunsoo03181/assets/src/StacksAndQueue/WithLinkedList/Queue.java#L1-L25

큐는 선입선출 방식을 채택하기 때문에, pop() 메소드는 마지막 노드를 추출합니다. 

<br/>

### main() 메소드

실행 클래스 예시입니다.

https://github.com/eunsoo03181/2024_1st_java_study/blob/175e19a5bc7e5c8bb73db0da16122f36d6afbbdd/week_7/eunsoo03181/assets/src/StacksAndQueue/WithLinkedList/Main.java#L1-L26

단순 연결 리스트 방식을 채택하기 때문에 시간 복잡도는 마찬가지로 O(n)입니다.
