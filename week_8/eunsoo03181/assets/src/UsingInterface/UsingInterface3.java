package WEEK08.UsingInterface;

public class UsingInterface3 {
    // 메소드 내 지역 변수로 사용합니다.
    void method() {
        MyInterface mi = new ImplementClass(2.718);
        System.out.println("method()의 출력값: " + mi.multipleRoot2());
    }
}
