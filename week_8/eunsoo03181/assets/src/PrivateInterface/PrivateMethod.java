package WEEK08.PrivateInterface;

public interface PrivateMethod {

    // static은 인터페이스에 그 자체에 속하기 때문에, private를 통해 접근할 수 없습니다.

    default void method() {
        System.out.println(A() + B());
    }

    private int A() {
        return 1;
    }

    private int B() {
        return 2;
    }
}
