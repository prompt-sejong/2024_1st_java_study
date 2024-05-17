package WEEK08.Sample;

interface Parent1_ {
    int getA();
}

interface Parent2_ {
    int getB();
}

class Parent1Impl implements Parent1_ {
    private int a = 1;

    public int getA() {
        return a;
    }
}

class Parent2Impl implements Parent2_ {
    private int b = 1;

    public int getB() {
        return b;
    }
}

class Child_ implements Parent1_, Parent2_ {
    private Parent1_ parent1 = new Parent1Impl();
    private Parent2_ parent2 = new Parent2Impl();

    public int getA() {
        return parent1.getA();
    }

    public int getB() {
        return parent2.getB();
    }

    public int getTotal() {
        return getA() + getB();
    }
}


public class MultipleInheritance {
    public static void main(String[] args) {
        Child_ ch = new Child_();
        System.out.println("a + b = " + ch.getTotal());
    }
}