package DataStructure.StacksAndQueue.WithArray;


public class Main {
    public static void main(String[] args) {
        Stack st = new Stack(5);
        Queue qu = new Queue(5);

        for (int i=0; i<5; i++) {
            st.push(i + 1);
            qu.push(i + 1);
        }
        st.display();
        qu.display();
        System.out.println("==========pop 이후==========");
        st.pop();
        st.pop();
        qu.pop();
        qu.pop();
        st.display();
        qu.display();
    }
}
