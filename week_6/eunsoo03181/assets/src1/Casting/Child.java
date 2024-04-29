package WEEK06.Casting;

public class Child extends Parent {

    Child() {
        System.out.println("Child 객체의 생성자가 호출되었습니다.");
    }

    @Override
    void method2() {
        System.out.println("이것은 자식 객체의 재정의된 method2입니다.");
    }

    void method3() {
        System.out.println("이것은 자식 객체의 method3입니다.");
    }
}
