package WEEK06.Promotion2;

class A { }

// A를 부모로 가진 자식 클래스
class B extends A { }
class C extends A { }

// 각각, B와 C를 부모로 가진 자식 클래스
class D extends B { }
class E extends C { }


public class Main {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        E e = new E();

        // 가능한 조건: 부모 객체가 자식 클래스의 생성자를 통해 생성
        A ex1 = new B();
        C ex2 = new E();

        // 가능한 조건: 자식 타입이 부모 타입으로 변환
        A a1 = b; // b는 타입이 B이고, a1은 타입이 A입니다. B의 부모는 A이므로, 자동 변환이 발생합니다.
        B b1 = d;

        A a2 = e;
        C c1 = e;
    }
}
