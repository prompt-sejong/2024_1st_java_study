package DataStructure.Recursion;
import java.util.HashMap;

public class FibonacciSequenceMemo {
    private static HashMap<Integer, Integer> fibo = new HashMap<>();

    public static int fibonacci(int n) {
        Main.cnt++;
        if (n <= 0) return 0;
        else if (n == 1) return 0;
        else if (n == 2) return 1;
        else if (fibo.containsKey(n)) return fibo.get(n);
        else {
            int result = fibonacci(n - 1) + fibonacci(n - 2);
            fibo.put(n, result);
            return result;
        }
    }
}
