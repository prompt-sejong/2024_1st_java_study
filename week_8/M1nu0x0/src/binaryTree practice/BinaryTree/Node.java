package BinaryTree;

public class Node {
    private int value;
    private Node left = null;
    private Node right = null;

    public Node(int data) {
        this.value = data;
    }

    public int getValue() { return this.value; }
    public void setValue(int data) { this.value = data; }

    public Node getLeft() { return this.left; }
    public void setLeft(Node node) { this.left = node; }

    public Node getRight() { return this.right; }
    public void setRight(Node node) { this.right = node; }
}
