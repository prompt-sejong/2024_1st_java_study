package DataStructure.StacksAndQueue.WithLinkedList;

public class Main {
    public static void main(String[] args) {
        Stack st = new Stack();
        Queue qu = new Queue();

        for (int i=0; i<5; i++) {
            st.push(i + 1);
            qu.push(i + 1);
        }
        System.out.print("Stack: ");
        st.display();
        System.out.print("Queue: ");
        qu.display();
        System.out.println("==========pop 이후==========");
        st.pop();
        st.pop();
        qu.pop();
        qu.pop();
        System.out.print("Stack: ");
        st.display();
        System.out.print("Queue: ");
        qu.display();
    }
}
