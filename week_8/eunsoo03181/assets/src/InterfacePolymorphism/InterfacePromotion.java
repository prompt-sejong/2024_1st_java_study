package WEEK08.InterfacePolymorphism;

interface A { }

class B implements A { }
class C implements A { }
class D extends B { }
class E extends C { }

public class InterfacePromotion {
    B b = new B();
    C c = new C();
    D d = new D();
    E e = new E();

    // 상속받은 클래스를 인터페이스 타입으로 변환할 수 있습니다.
    A a1 = b;
    A a2 = c;
    A a3 = d;
    A a4 = e;
}
