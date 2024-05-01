package DataStructure.LinkedList.SimplyLinkedList;

public class Main {
    public static void main(String[] args) {
        ImprovedLinkedList ll = new ImprovedLinkedList();
        ll.append(1);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.append(6);
        ll.display();
        // ll.remove(2);
        ll.display();
        ll.insert(0, 1);
        ll.display();
    }
}
