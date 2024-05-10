import Queue.*;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        // Array Queue
        ArrQueue arrQueue = new ArrQueue();
        arrQueue.enqueue(0);
        arrQueue.enqueue(10);
        arrQueue.enqueue(100);

        System.out.println("current arrQueue");
        arrQueue.print();
        System.out.println();
        System.out.printf("first value is: %d\n", arrQueue.peek());
        System.out.printf("dequeue %d\n", arrQueue.dequeue());
        System.out.printf("dequeue %d\n", arrQueue.dequeue());
        System.out.printf("dequeue %d\n", arrQueue.dequeue());
        System.out.printf("is empty: %b\n", arrQueue.isEmpty());
        System.out.println();
        System.out.println();

        // Node Queue
        NodeQueue nodeQueue = new NodeQueue();
        nodeQueue.enqueue(0);
        nodeQueue.enqueue(10);
        nodeQueue.enqueue(100);

        System.out.println("current nodeQueue");
        nodeQueue.print();
        System.out.println();
        System.out.printf("head value is: %d\n", nodeQueue.peek());
        System.out.printf("dequeue %d\n", nodeQueue.dequeue());
        System.out.printf("dequeue %d\n", nodeQueue.dequeue());
        System.out.printf("dequeue %d\n", nodeQueue.dequeue());
        System.out.printf("is empty: %b\n", nodeQueue.isEmpty());
    }
}
