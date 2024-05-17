package WEEK08.PrivateInterface;

public class Main {
    public static void main(String[] args) {
        PrivateMethod a = new ImplementClass();
        a.method();
        // a.A(); 오류(private)
    }
}
