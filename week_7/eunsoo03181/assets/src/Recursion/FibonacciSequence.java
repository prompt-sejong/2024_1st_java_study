package DataStructure.Recursion;

public class FibonacciSequence {
    public static int fibonacci(int n) {
        Main.cnt++;
        if (n==1) return 0;
        else if (n==2) return 1;
        else return fibonacci(n-2) + fibonacci(n-1);
    }
}
