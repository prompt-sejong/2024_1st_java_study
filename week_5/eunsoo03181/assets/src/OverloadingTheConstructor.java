package WEEK05;

public class OverloadingTheConstructor {
    int a;
    int b;
    int c;

    OverloadingTheConstructor() { }

    // 다른 생성자를 오버로딩합니다.
    OverloadingTheConstructor(int a) {
        this(a, 1, 2);
    }

    OverloadingTheConstructor(int a, int b) {
        this(a, b, 2);
    }

    OverloadingTheConstructor(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
