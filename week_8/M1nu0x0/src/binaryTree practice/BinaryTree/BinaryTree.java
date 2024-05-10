package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root = null;

    public BinaryTree(int data) {
        Node newNode = new Node(data);
        this.root = newNode;
    }

    public BinaryTree(Node node) {
        this.root = node;
    }

    public static Node makeNode(int data) {
        Node newNode = new Node(data);
        newNode.setValue(data);
        return newNode;
    }

    public Node getRootNode() { return this.root; }
    public void setLeftNode(Node sup, Node sub) { sup.setLeft(sub); }
    public void setRightNode(Node sup, Node sub) { sup.setRight(sub); }

    public void BFS(Node node) {
        // Breadth-First Search
        Queue<Node> queue = new LinkedList<>();
        // add(): enqueue
        // poll(): dequeue and return value
        // remove(): dequeue

        Node cur = null;
        queue.add(node);

        while (queue.size() != 0) {
            cur = queue.poll();
            System.out.print(cur.getValue() + " ");

            if (cur.getLeft() != null) {
                queue.add(cur.getLeft());
            }

            if (cur.getRight() != null) {
                queue.add(cur.getRight());
            }
        }
        
        System.out.println();
    }

    public void DFS(Node node) {
        // 전위 순회
        System.out.print(node.getValue() + " ");
        if (node.getLeft() != null)
            this.DFS(node.getLeft());
        if (node.getRight() != null)
            this.DFS(node.getRight());
    }
}
