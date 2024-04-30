package WEEK02;

public class JVMStackPrimitiveType {
    public static void main(String[] args) {
        // main 메서드가 시행되어, JVM 스택 영역에 v1이 push 됩니다.
        int v1 = 0;
        if (true) {
            // if문이 시행되어, JVM 스택 영역에 v2, v3, v4가 push 됩니다.
            int v2 = 1;
            int v3 = 2;
            int v4 = 3;
            // if문 종료로, JVM 스택 영역에 v2, v3, v4가 pop 됩니다.
        }
        // main 메서드가 시행되어, JVM 스택 영역에 v5가 push 됩니다.
        int v5 = 4;
        // main 메서드가 종료되어, JVM 스택 영역에 v1, v5가 pop 됩니다.
    }
}