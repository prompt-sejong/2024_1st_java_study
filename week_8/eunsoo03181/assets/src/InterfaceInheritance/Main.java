package WEEK08.InterfaceInheritance;

public class Main {
    public static void main(String[] args) {
        ImplementClass ic = new ImplementClass();

        Parent1 p1 = ic;
        p1.method1();

        Parent2 p2 = ic;
        p2.method2();
        System.out.println();

        Parent3 p3 = ic;
        p3.method3();
        System.out.println();

        Child ch = ic;
        ch.method1();
        ch.method2();
        ch.method3();
        ch.method4();
    }
}
