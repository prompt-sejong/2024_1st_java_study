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
