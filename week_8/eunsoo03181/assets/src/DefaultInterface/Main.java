package WEEK08.DefaultInterface;

public class Main {
    public static void main(String[] args) {
        ImplementClass ic = new ImplementClass();
        ic.method();
        ic.defaultMethod();
        System.out.println();

        ImplementClass2 ic2 = new ImplementClass2();
        ic2.method();
        ic2.defaultMethod();
    }
}
