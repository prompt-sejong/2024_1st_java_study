package WEEK08.DefaultInterface;

public interface MyInterface {
    void method();

    default void defaultMethod() {
        System.out.println("기본 메소드 호출");
    }
}
