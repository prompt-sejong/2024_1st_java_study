package WEEK08.Sample;

class Parent1 {
    private int a = 1;

    public int getA() {
        return a;
    }
}

class Parent2 extends Parent1 {
    private int b = 1;

    public int getB() {
        return b;
    }
}

class Child extends Parent2 {
    public int getTotal() {
        return getA() + getB();
    }
}

public class Alternative {
    public static void main(String[] args) {
        Child ch = new Child();
        System.out.println("a + b = " + ch.getTotal());
    }
}
