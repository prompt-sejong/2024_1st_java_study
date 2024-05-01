package LinkedList;

public class LinkedList {
    // 당연히 헤드와 size를 메인에서 구현하므로
    // 없는 인덱스에 대한 처리도 외부에서 해주어야함.
    public static ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        if (position < 0) { return null; }

        ListNode prevNode = head;
        ListNode curNode = prevNode.getNext();

        for (int i=0; i<position; i++) {
            prevNode = prevNode.getNext();
            curNode = curNode.getNext();
        }
 
        nodeToAdd.setNext(curNode);
        prevNode.setNext(nodeToAdd);

        return head;
    }

    public static ListNode remove(ListNode head, int positionToRemove) {
        if (positionToRemove < 0 || head.getNext() == null) { return null; }

        ListNode prevNode = head;
        ListNode curNode = prevNode.getNext();

        for (int i=0; i<positionToRemove; i++) {
            prevNode = prevNode.getNext();
            curNode = curNode.getNext();
        }

        if (curNode == null) {
            prevNode.setNext(null);
        }
        else {
            prevNode.setNext(curNode.getNext());
        }

        return curNode;
    }

    public static boolean contains(ListNode head, ListNode nodeToCheck) {
        if (head.getNext() == null) { return false; }
        ListNode curNode = head.getNext();

        while (curNode != null) {
            if (curNode.getData() == nodeToCheck.getData()) {
                return true;
            }
            curNode = curNode.getNext();
        }
        return false;
    }
}
