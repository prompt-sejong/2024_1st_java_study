package WEEK09.RuntimeException;

class A { }
class B extends A { }

public class ClassCastExceptionExample {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        B b1 = (B) a;
    }
}
