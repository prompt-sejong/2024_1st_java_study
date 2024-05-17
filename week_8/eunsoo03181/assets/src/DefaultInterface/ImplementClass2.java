package WEEK08.DefaultInterface;

public class ImplementClass2 implements MyInterface {
    @Override
    public void method() {
        System.out.println("Goodbye, World!");
    }

    @Override
    public void defaultMethod() {
        System.out.println("기본 메소드 오버라이딩");
    }
}
