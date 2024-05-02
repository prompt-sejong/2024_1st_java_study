import LinkedList.*;
import Stack.*;

public class LinkedListMain {
    public static void main(String[] args) throws Exception {
        // linked list
        ListNode head = new ListNode();
        int listSize = 0;
        for (int i=0; i<10; i++) {
            ListNode node = new ListNode(i);
            LinkedList.add(head, node, i);
            listSize++;
        }
        System.out.printf("now list size: %d\n", listSize);

        LinkedList.remove(head, 1);
        LinkedList.remove(head, 1);
        LinkedList.remove(head, 1);
        LinkedList.remove(head, 4);
        LinkedList.remove(head, 4);
        listSize -= 5;

        for (int i=0; i<10; i++) {
            ListNode node = new ListNode(i);
            System.out.printf("%d: %b\n", i, LinkedList.contains(head, node));
        }
        System.out.printf("now list size: %d\n", listSize);
        System.out.println();


        // stack
        Stack arrayStack = new Stack();
        for (int i=0; i<10; i++) {
            arrayStack.push(i);
        }
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();

        System.out.printf("head: %d\n", arrayStack.peek());

        while (!arrayStack.isEmpty()) {
            System.out.println(arrayStack.pop());
        }
        System.out.println();


        // linked list stack
        ListNodeStack listNodeStack = new ListNodeStack();
        for (int i=0; i<10; i++) {
            listNodeStack.push(i);
        }
        listNodeStack.pop();
        listNodeStack.pop();
        listNodeStack.pop();
        System.out.printf("now stack size: %d\n", listNodeStack.getSize());
        System.out.printf("head: %d\n", listNodeStack.peek());

        while (!listNodeStack.isEmpty()) {
            System.out.println(listNodeStack.pop());
        }
        System.out.printf("now stack size: %d\n", listNodeStack.getSize());
    }
}
