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
