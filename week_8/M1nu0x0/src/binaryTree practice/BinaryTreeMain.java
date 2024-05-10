import BinaryTree.BinaryTree;
import BinaryTree.Node;

public class BinaryTreeMain {
    public static void main(String[] args) throws Exception {
        Node root = BinaryTree.makeNode(0);
        BinaryTree myTree = new BinaryTree(root);

        // set node
        Node treeNode1 = BinaryTree.makeNode(1);
        Node treeNode2 = BinaryTree.makeNode(2);
        Node treeNode3 = BinaryTree.makeNode(3);
        Node treeNode4 = BinaryTree.makeNode(4);
        Node treeNode5 = BinaryTree.makeNode(5);
        Node treeNode6 = BinaryTree.makeNode(6);
        Node treeNode7 = BinaryTree.makeNode(7);

        // root is Lv1
        // Lv 2
        myTree.setLeftNode(root, treeNode1);
        myTree.setRightNode(root, treeNode2);

        // Lv 3
        myTree.setLeftNode(treeNode1, treeNode3);
        myTree.setRightNode(treeNode1, treeNode4);
        myTree.setLeftNode(treeNode2, treeNode5);

        // Lv 4
        myTree.setLeftNode(treeNode5, treeNode6);
        myTree.setRightNode(treeNode5, treeNode7);


        // BFS
        System.out.print("BFS from root : ");
        myTree.BFS(root);
        System.out.print("BFS from node2: ");
        myTree.BFS(treeNode2);
        System.out.print("BFS from node5: ");
        myTree.BFS(treeNode5);

        // DFS
        System.out.print("\nDFS from root : ");
        myTree.DFS(root);
        System.out.print("\nDFS from node2: ");
        myTree.DFS(treeNode2);
        System.out.print("\nDFS from node5: ");
        myTree.DFS(treeNode5);
    }
}
