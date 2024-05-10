package Queue;

import java.util.ArrayList;
import java.util.Collections;

public class ArrQueue {
    private ArrayList<Integer> queue = new ArrayList<>();

    public void enqueue(int data) {
        this.queue.add(data);
    }

    public int peek() {
        return this.queue.getFirst();
    }

    public int dequeue() {
        Collections.rotate(this.queue, -1);
        return this.queue.removeLast();
    }

    public void print() {
        for (Integer value : this.queue) {
            System.out.printf("%d ", value);
        }
        System.out.println();
    }

    public int size() {
        return this.queue.size();
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }
}