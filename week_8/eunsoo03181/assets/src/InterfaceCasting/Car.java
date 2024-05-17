package WEEK08.InterfaceCasting;

public class Car implements Vehicle{
    public void run() {
        System.out.println("부릉부릉");
    }

    public void superRun() {
        System.out.println("힘차게 부릉부릉");
    }
}
