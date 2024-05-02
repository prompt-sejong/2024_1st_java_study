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
