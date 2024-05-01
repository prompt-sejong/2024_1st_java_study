package Stack;

import java.util.ArrayList;

public class Stack {
    private ArrayList<Integer> stack = new ArrayList<>();
    private int head = -1;

    public void push(int data) {
        this.head++;
        this.stack.add(data);
    }

    public int pop() {
        int data;
        data = stack.get(this.head);
        stack.remove(this.head);
        this.head--;
        return data;
    }

    public int peek() {
        return this.stack.get(head);
    }

    public boolean isEmpty() {
        if (this.head == -1) {
            return true;
        }
        return false;
    }
}