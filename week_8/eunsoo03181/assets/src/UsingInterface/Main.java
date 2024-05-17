package WEEK08.UsingInterface;

import WEEK08.Interface.UsingInterface;

public class Main {
    public static void main(String[] args) {
        // 필드와 선언된 mi는 다음과 같이 사용합니다.
        UsingInterface1 ui1 = new UsingInterface1();
        System.out.println("ui1.mi.multipleRoot2() = " + ui1.mi.multipleRoot2());
        ui1.mi.changeInput(9.99);
        System.out.println("ui1.mi.multipleRoot2() = " + ui1.mi.multipleRoot2());

        // 생성자의 매개변수로 선언된 mi는 다음과 같이 사용합니다.
        UsingInterface2 ui2 = new UsingInterface2(new ImplementClass(1));

        // 지역 변수로 선언된 mi는 다음과 같이 사용합니다.
        UsingInterface3 ui3 = new UsingInterface3();
        ui3.method();

        // 메소드의 매개변수로 선언된 rc는 다음과 같이 사용합니다.
        UsingInterface4 ui4 = new UsingInterface4();
        ui4.method1(new ImplementClass(0));
    }
}
