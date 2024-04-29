package WEEK06.PromotionAndOverriding;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = child; // 프로모션이 발생합니다.

        parent.method1();
        parent.method2(); // 오버라이딩된 메소드(child.method2)가 호출됩니다.
        parent.method3();

        // 호출 불가능: parent.method4();
    }
}
