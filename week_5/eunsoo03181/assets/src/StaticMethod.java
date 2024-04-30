package WEEK05;

public class StaticMethod {
    static double p1;
    double p2;

    void instanceMethod (double p1, double p2) {
        StaticMethod.p1 = p1; // this.p1 사용시 컴파일 에러가 발생합니다.
        this.p2 = p2;
    }

    static void staticMethod_ (double p1, double p2) {
        StaticMethod a = new StaticMethod();
        a.p2 = 10;
    }
}
